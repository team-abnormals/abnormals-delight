package com.minecraftabnormals.abnormals_delight.core.data;

import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import com.minecraftabnormals.abnormals_delight.core.registry.ADBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.blocks.PantryBlock;

public class BlockModelGenerator extends BlockStateProvider {

	public BlockModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, AbnormalsDelight.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.pantry(ADBlocks.ROSEWOOD_PANTRY.get());
		this.pantry(ADBlocks.MORADO_PANTRY.get());
		this.pantry(ADBlocks.YUCCA_PANTRY.get());
		this.pantry(ADBlocks.KOUSA_PANTRY.get());
		this.pantry(ADBlocks.ASPEN_PANTRY.get());
		this.pantry(ADBlocks.GRIMWOOD_PANTRY.get());
		this.pantry(ADBlocks.MAPLE_PANTRY.get());
		this.pantry(ADBlocks.POISE_PANTRY.get());
		this.pantry(ADBlocks.WILLOW_PANTRY.get());
		this.pantry(ADBlocks.CHERRY_PANTRY.get());
		this.pantry(ADBlocks.WISTERIA_PANTRY.get());
		this.pantry(ADBlocks.DRIFTWOOD_PANTRY.get());
		this.pantry(ADBlocks.RIVER_PANTRY.get());
	}

	private void pantry(Block pantry) {
		if (pantry.getRegistryName() != null) {
			ResourceLocation name = this.prefix("block/", pantry.getRegistryName());

			ModelFile pantryModel = models().orientable(name(pantry), suffix(name, "_side"), suffix(name, "_front"), suffix(name, "_top"));
			ModelFile pantryOpenModel = models().orientable(name(pantry) + "_open", suffix(name, "_side"), suffix(name, "_front_open"), suffix(name, "_top"));

			this.pantryBlock(pantry, pantryModel, pantryOpenModel);
			this.item(pantry);
		}
	}

	public void pantryBlock(Block block, ModelFile pantry, ModelFile pantryOpen) {
		this.getVariantBuilder(block)
				.forAllStates(state -> ConfiguredModel.builder()
						.modelFile(state.getValue(PantryBlock.OPEN) ? pantryOpen : pantry)
						.rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360)
						.build()
				);
	}

	private String name(Block block) {
		return block.getRegistryName().getPath();
	}

	private ResourceLocation prefix(String prefix, ResourceLocation rl) {
		return new ResourceLocation(rl.getNamespace(), prefix + rl.getPath());
	}

	private ResourceLocation suffix(ResourceLocation rl, String suffix) {
		return new ResourceLocation(rl.getNamespace(), rl.getPath() + suffix);
	}

	public void item(Block block) {
		this.simpleBlockItem(block, new ExistingModelFile(blockTexture(block), this.models().existingFileHelper));
	}
}