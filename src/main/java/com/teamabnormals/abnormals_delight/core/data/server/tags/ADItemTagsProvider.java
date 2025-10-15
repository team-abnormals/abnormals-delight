package com.teamabnormals.abnormals_delight.core.data.server.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import com.teamabnormals.autumnity.core.other.tags.AutumnityItemTags;
import com.teamabnormals.environmental.core.other.tags.EnvironmentalItemTags;
import com.teamabnormals.upgrade_aquatic.core.other.tags.UAItemTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

import static com.teamabnormals.abnormals_delight.core.other.tags.ADItemTags.*;
import static com.teamabnormals.abnormals_delight.core.registry.ADItems.*;

public class ADItemTagsProvider extends ItemTagsProvider {

	public ADItemTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, CompletableFuture<TagLookup<Block>> tagLookup, ExistingFileHelper helper) {
		super(output, lookupProvider, tagLookup, AbnormalsDelight.MOD_ID, helper);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addTags(Provider provider) {
		this.tag(ModTags.WOODEN_CABINETS).add(ADBlocks.ROSEWOOD_CABINET.asItem(), ADBlocks.MORADO_CABINET.asItem(), ADBlocks.YUCCA_CABINET.asItem(), ADBlocks.KOUSA_CABINET.asItem(), ADBlocks.ASPEN_CABINET.asItem(), ADBlocks.LAUREL_CABINET.asItem(), ADBlocks.GRIMWOOD_CABINET.asItem(), ADBlocks.MAPLE_CABINET.asItem(), ADBlocks.AZALEA_CABINET.asItem(), ADBlocks.POISE_CABINET.asItem(), ADBlocks.WILLOW_CABINET.asItem(), ADBlocks.PLUM_CABINET.asItem(), ADBlocks.WISTERIA_CABINET.asItem(), ADBlocks.PINE_CABINET.asItem(), ADBlocks.DRIFTWOOD_CABINET.asItem(), ADBlocks.RIVER_CABINET.asItem());
		this.tag(SLABDISH_INGREDIENTS).add(Items.LILY_PAD, Items.SEAGRASS, ModItems.RICE_PANICLE.get()).addOptional(ADConstants.DUCKWEED);

		this.tag(ItemTags.MEAT).add(DUCK_FILLET.get(), COOKED_DUCK_FILLET.get(), VENISON_SHANKS.get(), COOKED_VENISON_SHANKS.get(), MAPLE_GLAZED_BACON.get());

		this.tag(UAItemTags.FOODS_COOKED_PERCH).add(COOKED_PERCH_SLICE.get());
		this.tag(UAItemTags.FOODS_COOKED_PIKE).add(COOKED_PIKE_SLICE.get());

		this.tag(EnvironmentalItemTags.COOKED_DUCK).add(COOKED_DUCK_FILLET.get());
		this.tag(EnvironmentalItemTags.COOKED_VENISON).add(COOKED_VENISON_SHANKS.get());

		this.tag(EnvironmentalItemTags.RAW_DUCK).add(DUCK_FILLET.get());
		this.tag(EnvironmentalItemTags.RAW_VENISON).add(VENISON_SHANKS.get());

		this.tag(UAItemTags.FOODS_RAW_PERCH).add(PERCH_SLICE.get());
		this.tag(UAItemTags.FOODS_RAW_PIKE).add(PIKE_SLICE.get());
		this.tag(CommonTags.TOOLS_KNIFE).add(SILVER_KNIFE.get(), NECROMIUM_KNIFE.get());

		this.tag(ModTags.KNIVES).add(SILVER_KNIFE.get(), NECROMIUM_KNIFE.get());
		this.tag(ModTags.CABBAGE_ROLL_INGREDIENTS).addTags(EnvironmentalItemTags.RAW_DUCK, EnvironmentalItemTags.RAW_VENISON).add(Items.RABBIT);
		this.tag(ModTags.MEALS).add(SEARED_VENISON.get(), PASSION_FRUIT_GLAZED_DUCK.get(), DUNE_PLATTER.get(), DUCK_NOODLES.get(), PERCH_WITH_MUSHROOMS.get(), PIKE_WITH_BEETROOT.get(), VENISON_WITH_BAMBOO_SHOOTS.get());
		this.tag(ModTags.DRINKS).add(CHERRY_CREAM_SODA.get(), PASSION_ALOE_NECTAR.get(), PICKERELWEED_JUICE.get());

		this.tag(INGOTS_SILVER);
		this.tag(INGOTS_NECROMIUM);

		this.tag(AutumnityItemTags.SNAIL_FOOD).add(ModItems.NETHER_SALAD.get());
		this.tag(EnvironmentalItemTags.SLABFISH_FOOD).add(SLABDISH.get());
	}
}