package com.teamabnormals.abnormals_delight.core.data.server.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
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
		this.copy(ModTags.Blocks.CABINETS_WOODEN, ModTags.Items.CABINETS_WOODEN);
		this.tag(SLABDISH_INGREDIENTS).add(Items.LILY_PAD, Items.SEAGRASS, ModItems.RICE_PANICLE.get()).addOptional(ADConstants.DUCKWEED);

		this.tag(ItemTags.MEAT).add(DUCK_FILLET.get(), COOKED_DUCK_FILLET.get(), VENISON_SHANKS.get(), COOKED_VENISON_SHANKS.get(), MAPLE_GLAZED_BACON.get());

		this.tag(UAItemTags.FOODS_COOKED_PERCH).add(COOKED_PERCH_SLICE.get());
		this.tag(UAItemTags.FOODS_COOKED_PIKE).add(COOKED_PIKE_SLICE.get());

		this.tag(EnvironmentalItemTags.FOODS_COOKED_DUCK).add(COOKED_DUCK_FILLET.get());
		this.tag(EnvironmentalItemTags.FOODS_COOKED_VENISON).add(COOKED_VENISON_SHANKS.get());

		this.tag(EnvironmentalItemTags.FOODS_RAW_DUCK).add(DUCK_FILLET.get());
		this.tag(EnvironmentalItemTags.FOODS_RAW_VENISON).add(VENISON_SHANKS.get());

		this.tag(UAItemTags.FOODS_RAW_PERCH).add(PERCH_SLICE.get());
		this.tag(UAItemTags.FOODS_RAW_PIKE).add(PIKE_SLICE.get());

		this.tag(COPPER_KNIVES).add(COPPER_KNIFE.get(), EXPOSED_COPPER_KNIFE.get(), WEATHERED_COPPER_KNIFE.get(), OXIDIZED_COPPER_KNIFE.get(), WAXED_COPPER_KNIFE.get(), WAXED_EXPOSED_COPPER_KNIFE.get(), WAXED_WEATHERED_COPPER_KNIFE.get(), WAXED_OXIDIZED_COPPER_KNIFE.get());
		this.tag(CommonTags.Items.TOOLS_KNIFE).addTag(COPPER_KNIVES).add(SILVER_KNIFE.get(), NECROMIUM_KNIFE.get());

		this.tag(Tags.Items.FOODS_COOKIE).add(CHERRY_COOKIE.get(), MAPLE_COOKIE.get(), MULBERRY_COOKIE.get());

		this.tag(ModTags.Items.KNIVES).addTag(COPPER_KNIVES).add(SILVER_KNIFE.get(), NECROMIUM_KNIFE.get());
		this.tag(ModTags.Items.MEALS).add(SEARED_VENISON.get(), PASSION_FRUIT_GLAZED_DUCK.get(), DUNE_PLATTER.get(), DUCK_NOODLES.get(), PERCH_WITH_MUSHROOMS.get(), PIKE_WITH_BEETROOT.get(), VENISON_WITH_BAMBOO_SHOOTS.get());
		this.tag(ModTags.Items.DRINKS).add(CHERRY_CREAM_SODA.get(), PASSION_ALOE_NECTAR.get(), PICKERELWEED_JUICE.get());

		this.tag(AutumnityItemTags.SNAIL_FOOD).add(ModItems.NETHER_SALAD.get());
		this.tag(EnvironmentalItemTags.SLABFISH_FOOD).add(SLABDISH.get());
	}
}