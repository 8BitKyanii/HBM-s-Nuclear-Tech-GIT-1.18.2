package at.martinthedragon.nucleartech.tileentities

import at.martinthedragon.nucleartech.ModItems
import at.martinthedragon.nucleartech.NuclearTech
import at.martinthedragon.nucleartech.containers.ShredderContainer
import at.martinthedragon.nucleartech.energy.EnergyStorageExposed
import at.martinthedragon.nucleartech.energy.transferEnergy
import at.martinthedragon.nucleartech.items.ShredderBlade
import at.martinthedragon.nucleartech.items.canTransferItem
import at.martinthedragon.nucleartech.recipes.RecipeTypes
import at.martinthedragon.nucleartech.recipes.ShreddingRecipe
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap
import net.minecraft.block.BlockState
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.inventory.IRecipeHelperPopulator
import net.minecraft.inventory.IRecipeHolder
import net.minecraft.inventory.Inventory
import net.minecraft.inventory.ItemStackHelper
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.IRecipe
import net.minecraft.item.crafting.RecipeItemHelper
import net.minecraft.nbt.CompoundNBT
import net.minecraft.tileentity.ITickableTileEntity
import net.minecraft.tileentity.LockableTileEntity
import net.minecraft.util.Direction
import net.minecraft.util.IIntArray
import net.minecraft.util.NonNullList
import net.minecraft.util.ResourceLocation
import net.minecraft.util.text.TranslationTextComponent
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.util.LazyOptional
import net.minecraftforge.energy.CapabilityEnergy
import net.minecraftforge.items.CapabilityItemHandler
import net.minecraftforge.items.ItemStackHandler

class ShredderTileEntity : LockableTileEntity(TileEntityTypes.shredderTileEntityType.get()),
    IRecipeHolder, IRecipeHelperPopulator, ExperienceRecipeResultTileEntity, ITickableTileEntity
{
    private var shreddingProgress = 0
    private val isShredding: Boolean
        get() = shreddingProgress > 0
    private var energy: Int
        get() = energyStorage.energyStored
        set(value) { energyStorage.energy = value }

    private val dataAccess = object : IIntArray {
        override fun get(index: Int): Int = when (index) {
            0 -> shreddingProgress
            1 -> energy
            else -> 0
        }

        override fun set(index: Int, value: Int) {
            when (index) {
                0 -> shreddingProgress = value
                1 -> energy = value
            }
        }

        override fun getCount() = 2
    }

    private val items = NonNullList.withSize(30, ItemStack.EMPTY)
    private val inventory = object : ItemStackHandler(items) {
        override fun onContentsChanged(slot: Int) {
            setChanged()
        }

        override fun isItemValid(slot: Int, stack: ItemStack): Boolean =
            when (slot) {
                9 -> stack.getCapability(CapabilityEnergy.ENERGY).isPresent
                10, 11 -> stack.item is ShredderBlade
                else -> true
            }
    }

    private val energyStorage = EnergyStorageExposed(MAX_ENERGY, ENERGY_TRANSFER_RATE, 0)

    private val recipesUsed = Object2IntOpenHashMap<ResourceLocation>()

    override fun load(state: BlockState, nbt: CompoundNBT) {
        super.load(state, nbt)
        items.clear()
        ItemStackHelper.loadAllItems(nbt, items)
        shreddingProgress = nbt.getInt("ShreddingTime")
        energy = nbt.getInt("Energy")
    }

    override fun save(nbt: CompoundNBT): CompoundNBT {
        super.save(nbt)
        ItemStackHelper.saveAllItems(nbt, items)
        nbt.putInt("ShreddingTime", shreddingProgress)
        nbt.putInt("Energy", energy)
        return nbt
    }

    override fun clearContent() = items.clear()

    override fun getContainerSize() = items.size

    override fun isEmpty() = items.all { it.isEmpty } && energy <= 0

    override fun getItem(slot: Int): ItemStack = items[slot]

    override fun removeItem(slot: Int, amount: Int): ItemStack = ItemStackHelper.removeItem(items, slot, amount)

    override fun removeItemNoUpdate(slot: Int): ItemStack = ItemStackHelper.takeItem(items, slot)

    override fun setItem(slot: Int, itemStack: ItemStack) {
        items[slot] = itemStack
        if (itemStack.count > maxStackSize)
            itemStack.count = maxStackSize
    }

    override fun stillValid(player: PlayerEntity): Boolean =
        if (level!!.getBlockEntity(worldPosition) != this) false
        else player.distanceToSqr(worldPosition.x + .5, worldPosition.y + .5, worldPosition.z + .5) <= 64

    override fun createMenu(windowID: Int, playerInventory: PlayerInventory) = ShredderContainer(windowID, playerInventory, this, dataAccess)

    override fun getDefaultName() = TranslationTextComponent("container.${NuclearTech.MODID}.shredder")

    override fun setRecipeUsed(recipe: IRecipe<*>?) {
        if (recipe == null) return
        recipesUsed.addTo(recipe.id, 1)
    }

    override fun getRecipeUsed(): IRecipe<*>? = null

    override fun fillStackedContents(recipeItemHelper: RecipeItemHelper) {
        for (itemStack in items) recipeItemHelper.accountStack(itemStack)
    }

    override fun getExperienceToDrop(player: PlayerEntity?): Float =
        recipesUsed.object2IntEntrySet().mapNotNull { (recipeID, amount) ->
            (level!!.recipeManager.byKey(recipeID).orElse(null) as? ShreddingRecipe)?.experience?.times(amount)
        }.sum()

    override fun getRecipesToAward(player: PlayerEntity): List<IRecipe<*>> =
        recipesUsed.keys.mapNotNull { player.level.recipeManager.byKey(it).orElse(null) }

    override fun clearUsedRecipes() {
        recipesUsed.clear()
    }

    override fun tick() {
        if (level!!.isClientSide) return

        val wasShredding = isShredding
        var contentsChanged = false

        if (isShredding) energy = (energy - ENERGY_CONSUMPTION_RATE).coerceAtLeast(0)

        val energyItemSlot = items[9]
        if (!energyItemSlot.isEmpty) transferEnergy(energyItemSlot, energyStorage)

        if ((0..8).any { !items[it].isEmpty } &&
            energy > 0 &&
            (10..11).all {
                val itemStack = items[it]
                itemStack.item is ShredderBlade && (itemStack.damageValue < itemStack.maxDamage || !itemStack.isDamageableItem)
            }
        ) {
            val recipes: Map<Int, IRecipe<*>> = (0..8) // find matching recipes
                .filterNot { items[it].isEmpty }
                .associateWith {
                    level!!.recipeManager
                        .getRecipeFor(RecipeTypes.SHREDDING, Inventory(items[it].copy()), level!!)
                        .orElse(null)
                }.filterNot { (_, recipe) -> recipe == null }
            val scrapStacks = (0..8).filter { !items[it].isEmpty && !recipes.contains(it) } // find no recipe random
            val scrapItem = ItemStack(ModItems.scrap.get())
            if (shreddingProgress >= SHREDDING_TIME) {

                // do all found recipes
                for ((slotIndex, recipe) in recipes) { // FIXME split random to fill the stack: 63 + 2 -> 64 + 1
                    val availableSlotIndex = (12..29).firstOrNull { canTransferItem(recipe.resultItem, items[it], this) } ?: continue
                    val resultSlot = items[availableSlotIndex]
                    if (resultSlot.isEmpty) items[availableSlotIndex] = recipe.resultItem.copy()
                    else resultSlot.grow(recipe.resultItem.count)
                    items[slotIndex].shrink(1)
                    recipesUsed.addTo(recipe.id, 1) // only give xp for actual recipes
                }

                // for those unknown, convert them to scrap
                for (toScrap in scrapStacks.map { items[it] }) {
                    val availableSlotIndex = (12..29).firstOrNull { canTransferItem(scrapItem, items[it], this) } ?: continue
                    val resultSlot = items[availableSlotIndex]
                    if (resultSlot.isEmpty) items[availableSlotIndex] = scrapItem.copy()
                    else resultSlot.grow(1)
                    toScrap.shrink(1)
                }

                // damage them shredder blades (and bullet press stamps)
                (10..11).forEach { items[it].hurt(1, level!!.random, null) }

                shreddingProgress = 0
            } else if ( // TODO very spaghetti and expensiv. much bad
                (!isShredding && energy >= MIN_ENERGY_THRESHOLD || isShredding && energy > 0) &&
                (scrapStacks.isNotEmpty() && (12..29).any { canTransferItem(scrapItem, items[it], this) } ||
                        recipes.values.any { recipe -> (12..29).any { canTransferItem(recipe.resultItem, items[it], this) }})
            ) {
                shreddingProgress++
            }
        } else if (isShredding) shreddingProgress = (shreddingProgress - 2).coerceAtLeast(0)

        if (wasShredding != isShredding) {
            contentsChanged = true
        }

        if (contentsChanged) setChanged()
    }

    private val inventoryCapability = LazyOptional.of(this::inventory)
    private val energyCapability = LazyOptional.of(this::energyStorage)

    override fun <T : Any?> getCapability(cap: Capability<T>, side: Direction?): LazyOptional<T> {
        if (!remove) when (cap) {
            CapabilityItemHandler.ITEM_HANDLER_CAPABILITY -> return inventoryCapability.cast()
            CapabilityEnergy.ENERGY -> return energyCapability.cast()
        }

        return super.getCapability(cap, side)
    }

    override fun invalidateCaps() {
        super.invalidateCaps()
        inventoryCapability.invalidate()
        energyCapability.invalidate()
    }

    companion object {
        const val MAX_ENERGY = 40_000
        const val SHREDDING_TIME = 60
        const val ENERGY_CONSUMPTION_RATE = 20
        const val MIN_ENERGY_THRESHOLD = SHREDDING_TIME * ENERGY_CONSUMPTION_RATE / 10
        const val ENERGY_TRANSFER_RATE = MAX_ENERGY / 100
    }
}
