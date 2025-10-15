package com.teamabnormals.abnormals_delight.core.data.server.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import com.teamabnormals.autumnity.core.other.tags.AutumnityItemTags;
import com.teamabnormals.environmental.core.other.tags.EnvironmentalItemTags;
import com.teamabnormals.upgrade_aquatic.core.other.tags.UAItemTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.registry.ModBlocks;
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
		this.tag(ModTags.WOODEN_CABINETS).add(ModBlocks.MANGROVE_CABINET.get().asItem(), ADBlocks.ROSEWOOD_CABINET.get().asItem(), ADBlocks.MORADO_CABINET.get().asItem(), ADBlocks.YUCCA_CABINET.get().asItem(), ADBlocks.KOUSA_CABINET.get().asItem(), ADBlocks.ASPEN_CABINET.get().asItem(), ADBlocks.LAUREL_CABINET.get().asItem(), ADBlocks.GRIMWOOD_CABINET.get().asItem(), ADBlocks.MAPLE_CABINET.get().asItem(), ADBlocks.AZALEA_CABINET.get().asItem(), ADBlocks.POISE_CABINET.get().asItem(), ADBlocks.WILLOW_CABINET.get().asItem(), ADBlocks.PLUM_CABINET.get().asItem(), ADBlocks.WISTERIA_CABINET.get().asItem(), ADBlocks.PINE_CABINET.get().asItem(), ADBlocks.DRIFTWOOD_CABINET.get().asItem(), ADBlocks.RIVER_CABINET.get().asItem());
		this.tag(SLABDISH_INGREDIENTS).add(Items.LILY_PAD, Items.SEAGRASS, ModItems.RICE_PANICLE.get()).addOptional(ADConstants.DUCKWEED);

		this.tag(ItemTags.MEAT).add(DUCK_FILLET.get(), COOKED_DUCK_FILLET.get(), VENISON_SHANKS.get(), COOKED_VENISON_SHANKS.get(), MAPLE_GLAZED_BACON.get());

		this.tag(Tags.Items.FOODS_COOKED_MEAT).addTags(EnvironmentalItemTags.COOKED_DUCK, EnvironmentalItemTags.COOKED_VENISON);
		this.tag(EnvironmentalItemTags.COOKED_DUCK).add(ADItems.COOKED_DUCK_FILLET.get());
		this.tag(EnvironmentalItemTags.COOKED_VENISON).add(ADItems.COOKED_VENISON_SHANKS.get());

		this.tag(UAItemTags.FOODS_COOKED_PERCH).add(ADItems.COOKED_PERCH_SLICE.get());
		this.tag(UAItemTags.FOODS_COOKED_PIKE).add(ADItems.COOKED_PIKE_SLICE.get());

		this.tag(Tags.Items.FOODS_RAW_MEAT).addTags(EnvironmentalItemTags.RAW_DUCK, EnvironmentalItemTags.RAW_VENISON);
		this.tag(EnvironmentalItemTags.RAW_DUCK).add(ADItems.DUCK_FILLET.get());
		this.tag(EnvironmentalItemTags.RAW_VENISON).add(ADItems.VENISON_SHANKS.get());

		this.tag(UAItemTags.FOODS_RAW_PERCH).add(ADItems.PERCH_SLICE.get());
		this.tag(UAItemTags.FOODS_RAW_PIKE).add(ADItems.PIKE_SLICE.get());
		this.tag(CommonTags.TOOLS_KNIFE).add(ADItems.SILVER_KNIFE.get(), ADItems.NECROMIUM_KNIFE.get());

		this.tag(ModTags.KNIVES).add(ADItems.SILVER_KNIFE.get(), ADItems.NECROMIUM_KNIFE.get());
		this.tag(ModTags.CABBAGE_ROLL_INGREDIENTS).addTags(EnvironmentalItemTags.RAW_DUCK, EnvironmentalItemTags.RAW_VENISON).add(Items.RABBIT);

		this.tag(INGOTS_SILVER);
		this.tag(INGOTS_NECROMIUM);

		this.tag(AutumnityItemTags.SNAIL_FOOD).add(ModItems.NETHER_SALAD.get());
		this.tag(EnvironmentalItemTags.SLABFISH_FOOD).add(ADItems.SLABDISH.get());
	}
}