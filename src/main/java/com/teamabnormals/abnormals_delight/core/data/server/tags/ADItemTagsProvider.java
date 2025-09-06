package com.teamabnormals.abnormals_delight.core.data.server.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import com.teamabnormals.abnormals_delight.core.registry.ADItems;
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

	@Override
	protected void addTags(Provider provider) {
		this.tag(ModTags.WOODEN_CABINETS).add(ModBlocks.MANGROVE_CABINET.get().asItem(), ADBlocks.ROSEWOOD_CABINET.get().asItem(), ADBlocks.MORADO_CABINET.get().asItem(), ADBlocks.YUCCA_CABINET.get().asItem(), ADBlocks.KOUSA_CABINET.get().asItem(), ADBlocks.ASPEN_CABINET.get().asItem(), ADBlocks.LAUREL_CABINET.get().asItem(), ADBlocks.GRIMWOOD_CABINET.get().asItem(), ADBlocks.MAPLE_CABINET.get().asItem(), ADBlocks.AZALEA_CABINET.get().asItem(), ADBlocks.POISE_CABINET.get().asItem(), ADBlocks.WILLOW_CABINET.get().asItem(), ADBlocks.PLUM_CABINET.get().asItem(), ADBlocks.WISTERIA_CABINET.get().asItem(), ADBlocks.PINE_CABINET.get().asItem(), ADBlocks.DRIFTWOOD_CABINET.get().asItem(), ADBlocks.RIVER_CABINET.get().asItem());
		this.tag(SLABDISH_INGREDIENTS).add(Items.LILY_PAD, Items.SEAGRASS, ModItems.RICE_PANICLE.get()).addOptional(ADConstants.DUCKWEED);

		this.tag(ItemTags.MEAT).add(DUCK_FILLET.get(), COOKED_DUCK_FILLET.get(), VENISON_SHANKS.get(), COOKED_VENISON_SHANKS.get(), MAPLE_GLAZED_BACON.get());

		this.tag(Tags.Items.FOODS_COOKED_MEAT).addTags(COOKED_RABBIT, COOKED_DUCK, COOKED_TURKEY, COOKED_VENISON);
		this.tag(COOKED_DUCK).add(ADItems.COOKED_DUCK_FILLET.get());
		this.tag(COOKED_TURKEY);
		this.tag(COOKED_RABBIT).add(Items.COOKED_RABBIT);
		this.tag(COOKED_VENISON).add(ADItems.COOKED_VENISON_SHANKS.get());

		this.tag(Tags.Items.FOODS_COOKED_FISH).addTags(COOKED_FISHES_PERCH, COOKED_FISHES_PIKE);
		this.tag(COOKED_FISHES_PERCH).add(ADItems.COOKED_PERCH_SLICE.get());
		this.tag(COOKED_FISHES_PIKE).add(ADItems.COOKED_PIKE_SLICE.get());

		this.tag(Tags.Items.FOODS_RAW_MEAT).addTags(RAW_RABBIT, RAW_DUCK, RAW_TURKEY, RAW_VENISON);
		this.tag(RAW_DUCK).add(ADItems.DUCK_FILLET.get());
		this.tag(RAW_TURKEY);
		this.tag(RAW_RABBIT).add(Items.RABBIT);
		this.tag(RAW_VENISON).add(ADItems.VENISON_SHANKS.get());

		this.tag(Tags.Items.FOODS_RAW_FISH).addTags(RAW_FISHES_PERCH, RAW_FISHES_PIKE);
		this.tag(RAW_FISHES_PERCH).add(ADItems.PERCH_SLICE.get());
		this.tag(RAW_FISHES_PIKE).add(ADItems.PIKE_SLICE.get());

		this.tag(FOODS_BANANA);

		this.tag(CommonTags.TOOLS_KNIFE).add(ADItems.SILVER_KNIFE.get(), ADItems.NECROMIUM_KNIFE.get());

		this.tag(ModTags.KNIVES).add(ADItems.SILVER_KNIFE.get(), ADItems.NECROMIUM_KNIFE.get());
		this.tag(ModTags.CABBAGE_ROLL_INGREDIENTS).addTags(RAW_DUCK, RAW_RABBIT, RAW_VENISON);

		this.tag(BARBECUE_STICK_INGREDIENTS);

		this.tag(INGOTS_SILVER);
		this.tag(INGOTS_NECROMIUM);

		this.tag(SNAIL_BREEDING_ITEMS).add(ModItems.NETHER_SALAD.get());
		this.tag(SLABFISH_FOOD).add(ADItems.SLABDISH.get());
	}
}