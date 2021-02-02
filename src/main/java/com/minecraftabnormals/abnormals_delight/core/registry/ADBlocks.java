package com.minecraftabnormals.abnormals_delight.core.registry;

import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.minecraftabnormals.abnormals_delight.common.block.AbnormalsPantryBlock;
import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.blocks.PantryBlock;

@Mod.EventBusSubscriber(modid = AbnormalsDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ADBlocks {
	public static final BlockSubRegistryHelper HELPER = AbnormalsDelight.REGISTRY_HELPER.getBlockSubHelper();

	public static final RegistryObject<Block> ROSEWOOD_PANTRY = HELPER.createCompatBlock("atmospheric", "rosewood_pantry", () -> new AbnormalsPantryBlock(Block.Properties.from(Blocks.BARREL)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> MORADO_PANTRY = HELPER.createCompatBlock("atmospheric", "morado_pantry", () -> new AbnormalsPantryBlock(Block.Properties.from(Blocks.BARREL)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> YUCCA_PANTRY = HELPER.createCompatBlock("atmospheric", "yucca_pantry", () -> new AbnormalsPantryBlock(Block.Properties.from(Blocks.BARREL)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> KOUSA_PANTRY = HELPER.createCompatBlock("atmospheric", "kousa_pantry", () -> new AbnormalsPantryBlock(Block.Properties.from(Blocks.BARREL)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> ASPEN_PANTRY = HELPER.createCompatBlock("atmospheric", "aspen_pantry", () -> new AbnormalsPantryBlock(Block.Properties.from(Blocks.BARREL)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> GRIMWOOD_PANTRY = HELPER.createCompatBlock("atmospheric", "grimwood_pantry", () -> new AbnormalsPantryBlock(Block.Properties.from(Blocks.BARREL)), ItemGroup.DECORATIONS);

	public static final RegistryObject<Block> MAPLE_PANTRY = HELPER.createCompatBlock("autumnity", "maple_pantry", () -> new AbnormalsPantryBlock(Block.Properties.from(Blocks.BARREL)), ItemGroup.DECORATIONS);

	public static final RegistryObject<Block> WILLOW_PANTRY = HELPER.createCompatBlock("environmental", "willow_pantry", () -> new AbnormalsPantryBlock(Block.Properties.from(Blocks.BARREL)), ItemGroup.DECORATIONS);

	public static final RegistryObject<Block> DRIFTWOOD_PANTRY = HELPER.createCompatBlock("upgrade_aquatic", "driftwood_pantry", () -> new AbnormalsPantryBlock(Block.Properties.from(Blocks.BARREL)), ItemGroup.DECORATIONS);
	public static final RegistryObject<Block> RIVER_PANTRY = HELPER.createCompatBlock("upgrade_aquatic", "river_pantry", () -> new AbnormalsPantryBlock(Block.Properties.from(Blocks.BARREL)), ItemGroup.DECORATIONS);
}
