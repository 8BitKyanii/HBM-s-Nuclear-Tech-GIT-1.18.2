package at.martinthedragon.ntm.datagen

import at.martinthedragon.ntm.Main
import at.martinthedragon.ntm.ModBlocks
import net.minecraft.block.Block
import net.minecraft.data.DataGenerator
import net.minecraft.util.ResourceLocation
import net.minecraftforge.client.model.generators.BlockStateProvider
import net.minecraftforge.common.data.ExistingFileHelper

class NuclearBlockStateProvider(
    dataGenerator: DataGenerator,
    existingFileHelper: ExistingFileHelper
) : BlockStateProvider(dataGenerator, Main.MODID, existingFileHelper) {
    override fun getName(): String = "Nuclear Tech Mod Block States and Models"

    override fun registerStatesAndModels() {
        simpleBlock(ModBlocks.uraniumOre.get())
        simpleBlock(ModBlocks.thoriumOre.get())
        simpleBlock(ModBlocks.titaniumOre.get())
        simpleBlock(ModBlocks.sulfurOre.get())
        simpleBlock(ModBlocks.niterOre.get())
        simpleBlock(ModBlocks.copperOre.get())
        simpleBlock(ModBlocks.tungstenOre.get())
        simpleBlock(ModBlocks.aluminiumOre.get())
        simpleBlock(ModBlocks.fluoriteOre.get())
        simpleBlock(ModBlocks.berylliumOre.get())
        simpleBlock(ModBlocks.leadOre.get())
        simpleBlock(ModBlocks.oilDeposit.get())
        simpleBlock(ModBlocks.emptyOilDeposit.get())
        simpleBlock(ModBlocks.oilSand.get())
        simpleBlock(ModBlocks.ligniteOre.get())
        simpleBlock(ModBlocks.asbestosOre.get())
        simpleBlock(ModBlocks.schrabidiumOre.get())
        simpleBlock(ModBlocks.australianOre.get())
        simpleBlock(ModBlocks.weidite.get())
        simpleBlock(ModBlocks.reiite.get())
        simpleBlock(ModBlocks.brightblendeOre.get())
        simpleBlock(ModBlocks.dellite.get())
        simpleBlock(ModBlocks.dollarGreenMineral.get())
        simpleBlock(ModBlocks.rareEarthOre.get())
        simpleBlock(ModBlocks.netherUraniumOre.get())
        simpleBlock(ModBlocks.netherPlutoniumOre.get())
        simpleBlock(ModBlocks.netherTungstenOre.get())
        simpleBlock(ModBlocks.netherSulfurOre.get())
        simpleBlock(ModBlocks.netherPhosphorusOre.get())
        simpleBlock(ModBlocks.netherSchrabidiumOre.get())
        simpleBlock(ModBlocks.meteorUraniumOre.get())
        simpleBlock(ModBlocks.meteorThoriumOre.get())
        simpleBlock(ModBlocks.meteorTitaniumOre.get())
        simpleBlock(ModBlocks.meteorSulfurOre.get())
        simpleBlock(ModBlocks.meteorCopperOre.get())
        simpleBlock(ModBlocks.meteorTungstenOre.get())
        simpleBlock(ModBlocks.meteorAluminiumOre.get())
        simpleBlock(ModBlocks.meteorLeadOre.get())
        simpleBlock(ModBlocks.meteorLithiumOre.get())
        simpleBlock(ModBlocks.starmetalOre.get())
        simpleBlock(ModBlocks.trixite.get())
        simpleBlock(ModBlocks.uraniumBlock.get())
        simpleBlock(ModBlocks.u233Block.get())
        simpleBlock(ModBlocks.u235Block.get())
        simpleBlock(ModBlocks.u238Block.get())
        simpleBlock(ModBlocks.uraniumFuelBlock.get())
        simpleBlock(ModBlocks.neptuniumBlock.get())
        simpleBlock(ModBlocks.moxFuelBlock.get())
        simpleBlock(ModBlocks.plutoniumBlock.get())
        simpleBlock(ModBlocks.pu238Block.get())
        simpleBlock(ModBlocks.pu239Block.get())
        simpleBlock(ModBlocks.pu240Block.get())
        simpleBlock(ModBlocks.plutoniumFuelBlock.get())
        simpleBlock(ModBlocks.thoriumBlock.get())
        simpleBlock(ModBlocks.thoriumFuelBlock.get())
        simpleBlock(ModBlocks.titaniumBlock.get())
        simpleBlock(ModBlocks.sulfurBlock.get())
        simpleBlock(ModBlocks.niterBlock.get())
        simpleBlock(ModBlocks.copperBlock.get())
        simpleBlock(ModBlocks.redCopperBlock.get())
        simpleBlock(ModBlocks.advancedAlloyBlock.get())
        simpleBlock(ModBlocks.tungstenBlock.get())
        simpleBlock(ModBlocks.aluminiumBlock.get())
        simpleBlock(ModBlocks.fluoriteBlock.get())
        simpleBlock(ModBlocks.berylliumBlock.get())
        simpleBlock(ModBlocks.cobaltBlock.get())
        simpleBlock(ModBlocks.steelBlock.get())
        simpleBlock(ModBlocks.leadBlock.get())
        simpleBlock(ModBlocks.lithiumBlock.get())
        simpleBlock(ModBlocks.whitePhosphorusBlock.get())
        simpleBlock(ModBlocks.redPhosphorusBlock.get())
        simpleBlock(ModBlocks.yellowcakeBlock.get())
        simpleBlock(ModBlocks.scrapBlock.get())
        simpleBlock(ModBlocks.electricalScrapBlock.get())
        axisBlock(ModBlocks.insulatorRoll.get())
        axisBlock(ModBlocks.fiberglassRoll.get())
        simpleBlock(ModBlocks.asbestosBlock.get())
        simpleBlock(ModBlocks.trinititeBlock.get())
        simpleBlock(ModBlocks.nuclearWasteBlock.get())
        simpleBlock(ModBlocks.schrabidiumBlock.get())
        simpleBlock(ModBlocks.soliniumBlock.get())
        simpleBlock(ModBlocks.schrabidiumFuelBlock.get())
        simpleBlock(ModBlocks.euphemiumBlock.get())
        simpleBlock(ModBlocks.schrabidiumCluster.get(), models().cubeColumn("schrabidium_cluster", extend(blockTexture(ModBlocks.schrabidiumCluster.get()), "_side"), extend(blockTexture(ModBlocks.schrabidiumCluster.get()), "_end")))
        simpleBlock(ModBlocks.euphemiumEtchedSchrabidiumCluster.get(), models().cubeColumn("euphemium_etched_schrabidium_cluster", extend(blockTexture(ModBlocks.euphemiumEtchedSchrabidiumCluster.get()), "_side"), extend(blockTexture(ModBlocks.euphemiumEtchedSchrabidiumCluster.get()), "_end")))
        simpleBlock(ModBlocks.magnetizedTungstenBlock.get())
        simpleBlock(ModBlocks.combineSteelBlock.get())
        simpleBlock(ModBlocks.deshReinforcedBlock.get())
        simpleBlock(ModBlocks.starmetalBlock.get())
        simpleBlock(ModBlocks.australiumBlock.get())
        simpleBlock(ModBlocks.weidaniumBlock.get())
        simpleBlock(ModBlocks.reiiumBlock.get())
        simpleBlock(ModBlocks.unobtainiumBlock.get())
        simpleBlock(ModBlocks.daffergonBlock.get())
        simpleBlock(ModBlocks.verticiumBlock.get())
        simpleBlock(ModBlocks.titaniumDecoBlock.get())
        simpleBlock(ModBlocks.redCopperDecoBlock.get())
        simpleBlock(ModBlocks.tungstenDecoBlock.get())
        simpleBlock(ModBlocks.aluminiumDecoBlock.get())
        simpleBlock(ModBlocks.steelDecoBlock.get())
        simpleBlock(ModBlocks.leadDecoBlock.get())
        simpleBlock(ModBlocks.berylliumDecoBlock.get())
        simpleBlock(ModBlocks.asbestosRoof.get())
        simpleBlock(ModBlocks.hazmatBlock.get())
        simpleBlock(ModBlocks.siren.get(), models().cubeColumn("siren", extend(blockTexture(ModBlocks.siren.get()), "_side"), blockTexture(ModBlocks.steelBlock.get())))
        horizontalBlock(ModBlocks.safe.get(), extend(blockTexture(ModBlocks.safe.get()), "_side"), extend(blockTexture(ModBlocks.safe.get()), "_front"), extend(blockTexture(ModBlocks.safe.get()), "_side"))
        simpleBlock(ModBlocks.steamPressBase.get(), models().getExistingFile(ModBlocks.steamPressBase.id))
        simpleBlock(ModBlocks.steamPressFrame.get(), models().getExistingFile(ModBlocks.steamPressFrame.id))
        simpleBlock(ModBlocks.steamPressTop.get(), models().getExistingFile(ModBlocks.steamPressTop.id))

        copiedBlockItem(ModBlocks.uraniumOre.get())
        copiedBlockItem(ModBlocks.thoriumOre.get())
        copiedBlockItem(ModBlocks.titaniumOre.get())
        copiedBlockItem(ModBlocks.sulfurOre.get())
        copiedBlockItem(ModBlocks.niterOre.get())
        copiedBlockItem(ModBlocks.copperOre.get())
        copiedBlockItem(ModBlocks.tungstenOre.get())
        copiedBlockItem(ModBlocks.aluminiumOre.get())
        copiedBlockItem(ModBlocks.fluoriteOre.get())
        copiedBlockItem(ModBlocks.berylliumOre.get())
        copiedBlockItem(ModBlocks.leadOre.get())
        copiedBlockItem(ModBlocks.oilDeposit.get())
        copiedBlockItem(ModBlocks.emptyOilDeposit.get())
        copiedBlockItem(ModBlocks.oilSand.get())
        copiedBlockItem(ModBlocks.ligniteOre.get())
        copiedBlockItem(ModBlocks.asbestosOre.get())
        copiedBlockItem(ModBlocks.schrabidiumOre.get())
        copiedBlockItem(ModBlocks.australianOre.get())
        copiedBlockItem(ModBlocks.weidite.get())
        copiedBlockItem(ModBlocks.reiite.get())
        copiedBlockItem(ModBlocks.brightblendeOre.get())
        copiedBlockItem(ModBlocks.dellite.get())
        copiedBlockItem(ModBlocks.dollarGreenMineral.get())
        copiedBlockItem(ModBlocks.rareEarthOre.get())
        copiedBlockItem(ModBlocks.netherUraniumOre.get())
        copiedBlockItem(ModBlocks.netherPlutoniumOre.get())
        copiedBlockItem(ModBlocks.netherTungstenOre.get())
        copiedBlockItem(ModBlocks.netherSulfurOre.get())
        copiedBlockItem(ModBlocks.netherPhosphorusOre.get())
        copiedBlockItem(ModBlocks.netherSchrabidiumOre.get())
        copiedBlockItem(ModBlocks.meteorUraniumOre.get())
        copiedBlockItem(ModBlocks.meteorThoriumOre.get())
        copiedBlockItem(ModBlocks.meteorTitaniumOre.get())
        copiedBlockItem(ModBlocks.meteorSulfurOre.get())
        copiedBlockItem(ModBlocks.meteorCopperOre.get())
        copiedBlockItem(ModBlocks.meteorTungstenOre.get())
        copiedBlockItem(ModBlocks.meteorAluminiumOre.get())
        copiedBlockItem(ModBlocks.meteorLeadOre.get())
        copiedBlockItem(ModBlocks.meteorLithiumOre.get())
        copiedBlockItem(ModBlocks.starmetalOre.get())
        copiedBlockItem(ModBlocks.trixite.get())
        copiedBlockItem(ModBlocks.uraniumBlock.get())
        copiedBlockItem(ModBlocks.u233Block.get())
        copiedBlockItem(ModBlocks.u235Block.get())
        copiedBlockItem(ModBlocks.u238Block.get())
        copiedBlockItem(ModBlocks.uraniumFuelBlock.get())
        copiedBlockItem(ModBlocks.neptuniumBlock.get())
        copiedBlockItem(ModBlocks.moxFuelBlock.get())
        copiedBlockItem(ModBlocks.plutoniumBlock.get())
        copiedBlockItem(ModBlocks.pu238Block.get())
        copiedBlockItem(ModBlocks.pu239Block.get())
        copiedBlockItem(ModBlocks.pu240Block.get())
        copiedBlockItem(ModBlocks.plutoniumFuelBlock.get())
        copiedBlockItem(ModBlocks.thoriumBlock.get())
        copiedBlockItem(ModBlocks.thoriumFuelBlock.get())
        copiedBlockItem(ModBlocks.titaniumBlock.get())
        copiedBlockItem(ModBlocks.sulfurBlock.get())
        copiedBlockItem(ModBlocks.niterBlock.get())
        copiedBlockItem(ModBlocks.copperBlock.get())
        copiedBlockItem(ModBlocks.redCopperBlock.get())
        copiedBlockItem(ModBlocks.advancedAlloyBlock.get())
        copiedBlockItem(ModBlocks.tungstenBlock.get())
        copiedBlockItem(ModBlocks.aluminiumBlock.get())
        copiedBlockItem(ModBlocks.fluoriteBlock.get())
        copiedBlockItem(ModBlocks.berylliumBlock.get())
        copiedBlockItem(ModBlocks.cobaltBlock.get())
        copiedBlockItem(ModBlocks.steelBlock.get())
        copiedBlockItem(ModBlocks.leadBlock.get())
        copiedBlockItem(ModBlocks.lithiumBlock.get())
        copiedBlockItem(ModBlocks.whitePhosphorusBlock.get())
        copiedBlockItem(ModBlocks.redPhosphorusBlock.get())
        copiedBlockItem(ModBlocks.yellowcakeBlock.get())
        copiedBlockItem(ModBlocks.scrapBlock.get())
        copiedBlockItem(ModBlocks.electricalScrapBlock.get())
        copiedBlockItem(ModBlocks.insulatorRoll.get())
        copiedBlockItem(ModBlocks.fiberglassRoll.get())
        copiedBlockItem(ModBlocks.asbestosBlock.get())
        copiedBlockItem(ModBlocks.trinititeBlock.get())
        copiedBlockItem(ModBlocks.nuclearWasteBlock.get())
        copiedBlockItem(ModBlocks.schrabidiumBlock.get())
        copiedBlockItem(ModBlocks.soliniumBlock.get())
        copiedBlockItem(ModBlocks.schrabidiumFuelBlock.get())
        copiedBlockItem(ModBlocks.euphemiumBlock.get())
        copiedBlockItem(ModBlocks.schrabidiumCluster.get())
        copiedBlockItem(ModBlocks.euphemiumEtchedSchrabidiumCluster.get())
        copiedBlockItem(ModBlocks.magnetizedTungstenBlock.get())
        copiedBlockItem(ModBlocks.combineSteelBlock.get())
        copiedBlockItem(ModBlocks.deshReinforcedBlock.get())
        copiedBlockItem(ModBlocks.starmetalBlock.get())
        copiedBlockItem(ModBlocks.australiumBlock.get())
        copiedBlockItem(ModBlocks.weidaniumBlock.get())
        copiedBlockItem(ModBlocks.reiiumBlock.get())
        copiedBlockItem(ModBlocks.unobtainiumBlock.get())
        copiedBlockItem(ModBlocks.daffergonBlock.get())
        copiedBlockItem(ModBlocks.verticiumBlock.get())
        copiedBlockItem(ModBlocks.titaniumDecoBlock.get())
        copiedBlockItem(ModBlocks.redCopperDecoBlock.get())
        copiedBlockItem(ModBlocks.tungstenDecoBlock.get())
        copiedBlockItem(ModBlocks.aluminiumDecoBlock.get())
        copiedBlockItem(ModBlocks.steelDecoBlock.get())
        copiedBlockItem(ModBlocks.leadDecoBlock.get())
        copiedBlockItem(ModBlocks.berylliumDecoBlock.get())
        copiedBlockItem(ModBlocks.asbestosRoof.get())
        copiedBlockItem(ModBlocks.hazmatBlock.get())
        copiedBlockItem(ModBlocks.siren.get())
        copiedBlockItem(ModBlocks.safe.get())
    }

    private fun extend(rl: ResourceLocation, suffix: String): ResourceLocation =
        ResourceLocation(rl.namespace, rl.path + suffix)

    private fun copiedBlockItem(block: Block) {
        simpleBlockItem(block, models().getExistingFile(block.registryName))
    }
}
