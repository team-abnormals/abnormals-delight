package com.teamabnormals.abnormals_delight.core.registry;

import com.teamabnormals.abnormals_delight.common.block.AbnormalsCabinetBlock;
import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = AbnormalsDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ADBlocks {
	public static final BlockSubRegistryHelper HELPER = AbnormalsDelight.REGISTRY_HELPER.getBlockSubHelper();

	public static final RegistryObject<Block> ROSEWOOD_CABINET = HELPER.createCompatFuelBlock(ADConstants.ATMOSPHERIC, "rosewood_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> MORADO_CABINET = HELPER.createCompatFuelBlock(ADConstants.ATMOSPHERIC, "morado_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> YUCCA_CABINET = HELPER.createCompatFuelBlock(ADConstants.ATMOSPHERIC, "yucca_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> KOUSA_CABINET = HELPER.createCompatFuelBlock(ADConstants.ATMOSPHERIC, "kousa_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> ASPEN_CABINET = HELPER.createCompatFuelBlock(ADConstants.ATMOSPHERIC, "aspen_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> GRIMWOOD_CABINET = HELPER.createCompatFuelBlock(ADConstants.ATMOSPHERIC, "grimwood_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> MAPLE_CABINET = HELPER.createCompatFuelBlock(ADConstants.AUTUMNITY, "maple_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> AZALEA_CABINET = HELPER.createCompatFuelBlock(ADConstants.CAVERNS_AND_CHASMS, "azalea_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> POISE_CABINET = HELPER.createCompatFuelBlock(ADConstants.ENDERGETIC, "poise_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> WILLOW_CABINET = HELPER.createCompatFuelBlock(ADConstants.ENVIRONMENTAL, "willow_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> WISTERIA_CABINET = HELPER.createCompatFuelBlock(ADConstants.ENVIRONMENTAL, "wisteria_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> CHERRY_CABINET = HELPER.createCompatFuelBlock(ADConstants.ENVIRONMENTAL, "cherry_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> DRIFTWOOD_CABINET = HELPER.createCompatFuelBlock(ADConstants.UPGRADE_AQUATIC, "driftwood_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Block> RIVER_CABINET = HELPER.createCompatFuelBlock(ADConstants.UPGRADE_AQUATIC, "river_cabinet", () -> new AbnormalsCabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300, CreativeModeTab.TAB_DECORATIONS);
}
