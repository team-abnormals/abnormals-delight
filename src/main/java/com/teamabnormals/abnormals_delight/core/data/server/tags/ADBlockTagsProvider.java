package com.teamabnormals.abnormals_delight.core.data.server.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.abnormals_delight.core.other.tags.ADBlockTags;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.ModTags;

public class ADBlockTagsProvider extends BlockTagsProvider {

	public ADBlockTagsProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
		super(generator, AbnormalsDelight.MOD_ID, fileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(BlockTags.MINEABLE_WITH_AXE).add(ADBlocks.ROSEWOOD_CABINET.get(), ADBlocks.MORADO_CABINET.get(), ADBlocks.YUCCA_CABINET.get(), ADBlocks.KOUSA_CABINET.get(), ADBlocks.ASPEN_CABINET.get(), ADBlocks.GRIMWOOD_CABINET.get(), ADBlocks.MAPLE_CABINET.get(), ADBlocks.AZALEA_CABINET.get(), ADBlocks.POISE_CABINET.get(), ADBlocks.WILLOW_CABINET.get(), ADBlocks.CHERRY_CABINET.get(), ADBlocks.WISTERIA_CABINET.get(), ADBlocks.DRIFTWOOD_CABINET.get(), ADBlocks.RIVER_CABINET.get());
		this.tag(ModTags.HEAT_SOURCES).addOptional(ADConstants.GLOWING_OBSIDIAN);
		this.tag(ModTags.TRAY_HEAT_SOURCES).addOptionalTag(ADConstants.BRAZIERS);
		this.tag(ModTags.MINEABLE_WITH_KNIFE).addOptional(ADConstants.VANILLA_CAKE).addOptional(ADConstants.CHOCOLATE_CAKE).addOptional(ADConstants.STRAWBERRY_CAKE).addOptional(ADConstants.BANANA_CAKE).addOptional(ADConstants.MINT_CAKE).addOptional(ADConstants.ADZUKI_CAKE);

		this.tag(ADBlockTags.DROPS_FLAVORED_CAKE_SLICE).addTags(ADBlockTags.DROPS_VANILLA_CAKE_SLICE, ADBlockTags.DROPS_CHOCOLATE_CAKE_SLICE, ADBlockTags.DROPS_STRAWBERRY_CAKE_SLICE, ADBlockTags.DROPS_BANANA_CAKE_SLICE, ADBlockTags.DROPS_MINT_CAKE_SLICE, ADBlockTags.DROPS_ADZUKI_CAKE_SLICE);
		this.tag(ADBlockTags.DROPS_VANILLA_CAKE_SLICE);
		this.tag(ADBlockTags.DROPS_CHOCOLATE_CAKE_SLICE);
		this.tag(ADBlockTags.DROPS_STRAWBERRY_CAKE_SLICE);
		this.tag(ADBlockTags.DROPS_BANANA_CAKE_SLICE);
		this.tag(ADBlockTags.DROPS_MINT_CAKE_SLICE);
		this.tag(ADBlockTags.DROPS_ADZUKI_CAKE_SLICE);
	}
}