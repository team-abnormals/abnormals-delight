package com.teamabnormals.abnormals_delight.core.registry;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredBlock;
import vectorwing.farmersdelight.common.block.CabinetBlock;

public class ADBlocks {
	public static final BlockSubRegistryHelper BLOCKS = AbnormalsDelight.REGISTRY_HELPER.getBlockSubHelper();

	public static final DeferredBlock<Block> ROSEWOOD_CABINET = BLOCKS.createFuelBlock("rosewood_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> MORADO_CABINET = BLOCKS.createFuelBlock("morado_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> YUCCA_CABINET = BLOCKS.createFuelBlock("yucca_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> KOUSA_CABINET = BLOCKS.createFuelBlock("kousa_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> ASPEN_CABINET = BLOCKS.createFuelBlock("aspen_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> LAUREL_CABINET = BLOCKS.createFuelBlock("laurel_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> GRIMWOOD_CABINET = BLOCKS.createFuelBlock("grimwood_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> MAPLE_CABINET = BLOCKS.createFuelBlock("maple_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> AZALEA_CABINET = BLOCKS.createFuelBlock("azalea_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> POISE_CABINET = BLOCKS.createFuelBlock("poise_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> WILLOW_CABINET = BLOCKS.createFuelBlock("willow_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> WISTERIA_CABINET = BLOCKS.createFuelBlock("wisteria_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> PLUM_CABINET = BLOCKS.createFuelBlock("plum_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> PINE_CABINET = BLOCKS.createFuelBlock("pine_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> DRIFTWOOD_CABINET = BLOCKS.createFuelBlock("driftwood_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
	public static final DeferredBlock<Block> RIVER_CABINET = BLOCKS.createFuelBlock("river_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)), 300);
}
