package com.teamabnormals.abnormals_delight.core.registry;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.registries.DeferredBlock;
import vectorwing.farmersdelight.common.block.CabinetBlock;

public class ADBlocks {
	public static final BlockSubRegistryHelper BLOCKS = AbnormalsDelight.REGISTRY_HELPER.getBlockSubHelper();

	public static final DeferredBlock<Block> ROSEWOOD_CABINET = BLOCKS.createBlock("rosewood_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> MORADO_CABINET = BLOCKS.createBlock("morado_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> YUCCA_CABINET = BLOCKS.createBlock("yucca_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> KOUSA_CABINET = BLOCKS.createBlock("kousa_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> ASPEN_CABINET = BLOCKS.createBlock("aspen_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> LAUREL_CABINET = BLOCKS.createBlock("laurel_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> GRIMWOOD_CABINET = BLOCKS.createBlock("grimwood_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> MAPLE_CABINET = BLOCKS.createBlock("maple_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> AZALEA_CABINET = BLOCKS.createBlock("azalea_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> POISE_CABINET = BLOCKS.createBlock("poise_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> WILLOW_CABINET = BLOCKS.createBlock("willow_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> WISTERIA_CABINET = BLOCKS.createBlock("wisteria_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> PLUM_CABINET = BLOCKS.createBlock("plum_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> PINE_CABINET = BLOCKS.createBlock("pine_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> DRIFTWOOD_CABINET = BLOCKS.createBlock("driftwood_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
	public static final DeferredBlock<Block> RIVER_CABINET = BLOCKS.createBlock("river_cabinet", () -> new CabinetBlock(Block.Properties.ofFullCopy(Blocks.BARREL)));
}
