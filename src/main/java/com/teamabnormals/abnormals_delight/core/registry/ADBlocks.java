package com.teamabnormals.abnormals_delight.core.registry;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.CabinetBlock;

@EventBusSubscriber(modid = AbnormalsDelight.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ADBlocks {
	public static final BlockSubRegistryHelper HELPER = AbnormalsDelight.REGISTRY_HELPER.getBlockSubHelper();

	public static final RegistryObject<Block> ROSEWOOD_CABINET = HELPER.createFuelBlock("rosewood_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> MORADO_CABINET = HELPER.createFuelBlock("morado_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> YUCCA_CABINET = HELPER.createFuelBlock("yucca_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> KOUSA_CABINET = HELPER.createFuelBlock("kousa_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> ASPEN_CABINET = HELPER.createFuelBlock("aspen_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> LAUREL_CABINET = HELPER.createFuelBlock("laurel_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> GRIMWOOD_CABINET = HELPER.createFuelBlock("grimwood_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> MAPLE_CABINET = HELPER.createFuelBlock("maple_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> AZALEA_CABINET = HELPER.createFuelBlock("azalea_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> POISE_CABINET = HELPER.createFuelBlock("poise_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> WILLOW_CABINET = HELPER.createFuelBlock("willow_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> WISTERIA_CABINET = HELPER.createFuelBlock("wisteria_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> PLUM_CABINET = HELPER.createFuelBlock("plum_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> PINE_CABINET = HELPER.createFuelBlock("pine_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> DRIFTWOOD_CABINET = HELPER.createFuelBlock("driftwood_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
	public static final RegistryObject<Block> RIVER_CABINET = HELPER.createFuelBlock("river_cabinet", () -> new CabinetBlock(Block.Properties.copy(Blocks.BARREL)), 300);
}
