package com.teamabnormals.abnormals_delight.core.data.client;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import com.teamabnormals.blueprint.core.data.client.BlueprintBlockStateProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.block.CabinetBlock;

public class ADBlockStateProvider extends BlueprintBlockStateProvider {

	public ADBlockStateProvider(PackOutput output, ExistingFileHelper helper) {
		super(output, AbnormalsDelight.MOD_ID, helper);
	}

	@Override
	protected void registerStatesAndModels() {
		this.cabinet(ADBlocks.ROSEWOOD_CABINET.get());
		this.cabinet(ADBlocks.MORADO_CABINET.get());
		this.cabinet(ADBlocks.YUCCA_CABINET.get());
		this.cabinet(ADBlocks.KOUSA_CABINET.get());
		this.cabinet(ADBlocks.ASPEN_CABINET.get());
		this.cabinet(ADBlocks.LAUREL_CABINET.get());
		this.cabinet(ADBlocks.GRIMWOOD_CABINET.get());
		this.cabinet(ADBlocks.MAPLE_CABINET.get());
		this.cabinet(ADBlocks.AZALEA_CABINET.get());
		this.cabinet(ADBlocks.POISE_CABINET.get());
		this.cabinet(ADBlocks.WILLOW_CABINET.get());
		this.cabinet(ADBlocks.PLUM_CABINET.get());
		this.cabinet(ADBlocks.WISTERIA_CABINET.get());
		this.cabinet(ADBlocks.PINE_CABINET.get());
		this.cabinet(ADBlocks.DRIFTWOOD_CABINET.get());
		this.cabinet(ADBlocks.RIVER_CABINET.get());
	}

	private void cabinet(Block cabinet) {
		ResourceLocation registryName = BuiltInRegistries.BLOCK.getKey(cabinet);
		ResourceLocation name = prefix("block/", registryName);

		ModelFile cabinetModel = models().orientable(name(cabinet), suffix(name, "_side"), suffix(name, "_front"), suffix(name, "_top"));
		ModelFile cabinetOpenModel = models().orientable(name(cabinet) + "_open", suffix(name, "_side"), suffix(name, "_front_open"), suffix(name, "_top"));

		this.cabinetBlock(cabinet, cabinetModel, cabinetOpenModel);
		this.blockItem(cabinet);
	}

	public void cabinetBlock(Block block, ModelFile cabinet, ModelFile cabinetOpen) {
		this.getVariantBuilder(block)
				.forAllStates(state -> ConfiguredModel.builder()
						.modelFile(state.getValue(CabinetBlock.OPEN) ? cabinetOpen : cabinet)
						.rotationY(((int) state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180) % 360)
						.build()
				);
	}
}