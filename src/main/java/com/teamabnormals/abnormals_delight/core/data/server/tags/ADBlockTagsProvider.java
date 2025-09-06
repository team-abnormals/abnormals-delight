package com.teamabnormals.abnormals_delight.core.data.server.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.abnormals_delight.core.other.tags.ADBlockTags;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ADBlockTagsProvider extends BlockTagsProvider {

	public ADBlockTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, ExistingFileHelper helper) {
		super(output, lookupProvider, AbnormalsDelight.MOD_ID, helper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(BlockTags.MINEABLE_WITH_AXE).add(ADBlocks.ROSEWOOD_CABINET.get(), ADBlocks.MORADO_CABINET.get(), ADBlocks.YUCCA_CABINET.get(), ADBlocks.KOUSA_CABINET.get(), ADBlocks.ASPEN_CABINET.get(), ADBlocks.LAUREL_CABINET.get(), ADBlocks.GRIMWOOD_CABINET.get(), ADBlocks.MAPLE_CABINET.get(), ADBlocks.AZALEA_CABINET.get(), ADBlocks.POISE_CABINET.get(), ADBlocks.WILLOW_CABINET.get(), ADBlocks.PLUM_CABINET.get(), ADBlocks.WISTERIA_CABINET.get(), ADBlocks.PINE_CABINET.get(), ADBlocks.DRIFTWOOD_CABINET.get(), ADBlocks.RIVER_CABINET.get());
		this.tag(ModTags.HEAT_SOURCES).addOptional(ADConstants.GLOWING_OBSIDIAN);
		this.tag(ModTags.TRAY_HEAT_SOURCES).addOptionalTag(ADConstants.BRAZIERS).addOptional(ADConstants.LAVA_LAMP);
		this.tag(ModTags.MINEABLE_WITH_KNIFE).addOptional(ADConstants.VANILLA_CAKE).addOptional(ADConstants.CHOCOLATE_CAKE).addOptional(ADConstants.STRAWBERRY_CAKE).addOptional(ADConstants.BANANA_CAKE).addOptional(ADConstants.MINT_CAKE).addOptional(ADConstants.ADZUKI_CAKE);

		this.tag(ModTags.DROPS_CAKE_SLICE).addOptional(ADConstants.SOUL_CANDLE_CAKE).addOptional(ADConstants.CUPRIC_CANDLE_CAKE);
		this.tag(ADBlockTags.DROPS_FLAVORED_CAKE_SLICE).addTags(ADBlockTags.DROPS_VANILLA_CAKE_SLICE, ADBlockTags.DROPS_CHOCOLATE_CAKE_SLICE, ADBlockTags.DROPS_STRAWBERRY_CAKE_SLICE, ADBlockTags.DROPS_BANANA_CAKE_SLICE, ADBlockTags.DROPS_MINT_CAKE_SLICE, ADBlockTags.DROPS_ADZUKI_CAKE_SLICE);
		this.tag(ADBlockTags.DROPS_VANILLA_CAKE_SLICE);
		this.tag(ADBlockTags.DROPS_CHOCOLATE_CAKE_SLICE);
		this.tag(ADBlockTags.DROPS_STRAWBERRY_CAKE_SLICE);
		this.tag(ADBlockTags.DROPS_BANANA_CAKE_SLICE);
		this.tag(ADBlockTags.DROPS_MINT_CAKE_SLICE);
		this.tag(ADBlockTags.DROPS_ADZUKI_CAKE_SLICE);
	}
}