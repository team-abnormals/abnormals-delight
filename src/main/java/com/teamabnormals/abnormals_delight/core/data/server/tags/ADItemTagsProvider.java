package com.teamabnormals.abnormals_delight.core.data.server.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.abnormals_delight.core.other.tags.ADItemTags;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ADItemTagsProvider extends ItemTagsProvider {

	public ADItemTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, CompletableFuture<TagLookup<Block>> tagLookup, ExistingFileHelper helper) {
		super(output, lookupProvider, tagLookup, AbnormalsDelight.MOD_ID, helper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(ModTags.WOODEN_CABINETS).add(ModBlocks.MANGROVE_CABINET.get().asItem(), ADBlocks.ROSEWOOD_CABINET.get().asItem(), ADBlocks.MORADO_CABINET.get().asItem(), ADBlocks.YUCCA_CABINET.get().asItem(), ADBlocks.KOUSA_CABINET.get().asItem(), ADBlocks.ASPEN_CABINET.get().asItem(), ADBlocks.LAUREL_CABINET.get().asItem(), ADBlocks.GRIMWOOD_CABINET.get().asItem(), ADBlocks.MAPLE_CABINET.get().asItem(), ADBlocks.AZALEA_CABINET.get().asItem(), ADBlocks.POISE_CABINET.get().asItem(), ADBlocks.WILLOW_CABINET.get().asItem(), ADBlocks.PLUM_CABINET.get().asItem(), ADBlocks.WISTERIA_CABINET.get().asItem(), ADBlocks.PINE_CABINET.get().asItem(), ADBlocks.DRIFTWOOD_CABINET.get().asItem(), ADBlocks.RIVER_CABINET.get().asItem());
		this.tag(ADItemTags.SLABDISH_INGREDIENTS).add(Items.LILY_PAD, Items.SEAGRASS, ModItems.RICE_PANICLE.get()).addOptional(ADConstants.DUCKWEED);

		this.tag(ADItemTags.COOKED_DUCK).add(ADItems.COOKED_DUCK_FILLET.get());
		this.tag(ADItemTags.COOKED_TURKEY);
		this.tag(ADItemTags.COOKED_RABBIT).add(Items.COOKED_RABBIT);
		this.tag(ADItemTags.COOKED_VENISON).add(ADItems.COOKED_VENISON_SHANKS.get());
		this.tag(ForgeTags.COOKED_FISHES).addTags(ADItemTags.COOKED_FISHES_PERCH, ADItemTags.COOKED_FISHES_PIKE);
		this.tag(ADItemTags.COOKED_FISHES_PERCH).add(ADItems.COOKED_PERCH_SLICE.get());
		this.tag(ADItemTags.COOKED_FISHES_PIKE).add(ADItems.COOKED_PIKE_SLICE.get());

		this.tag(ADItemTags.RAW_DUCK).add(ADItems.DUCK_FILLET.get());
		this.tag(ADItemTags.RAW_TURKEY);
		this.tag(ADItemTags.RAW_RABBIT).add(Items.RABBIT);
		this.tag(ADItemTags.RAW_VENISON).add(ADItems.VENISON_SHANKS.get());
		this.tag(ForgeTags.RAW_FISHES).addTags(ADItemTags.RAW_FISHES_PERCH, ADItemTags.RAW_FISHES_PIKE);
		this.tag(ADItemTags.RAW_FISHES_PERCH).add(ADItems.PERCH_SLICE.get());
		this.tag(ADItemTags.RAW_FISHES_PIKE).add(ADItems.PIKE_SLICE.get());

		this.tag(ADItemTags.FRUITS_BANANA);

		this.tag(ForgeTags.TOOLS_KNIVES).add(ADItems.SILVER_KNIFE.get(), ADItems.NECROMIUM_KNIFE.get());

		this.tag(ModTags.KNIVES).add(ADItems.SILVER_KNIFE.get(), ADItems.NECROMIUM_KNIFE.get());
		this.tag(ModTags.CABBAGE_ROLL_INGREDIENTS).addTags(ADItemTags.RAW_DUCK, ADItemTags.RAW_RABBIT, ADItemTags.RAW_VENISON);
		this.tag(ModTags.WOLF_PREY).addTags(ADItemTags.RAW_DUCK, ADItemTags.RAW_VENISON);

		this.tag(ADItemTags.BARBECUE_STICK_INGREDIENTS).addTags(ForgeTags.COOKED_BEEF, ForgeTags.COOKED_PORK, ForgeTags.COOKED_CHICKEN, ForgeTags.COOKED_MUTTON, ForgeTags.COOKED_FISHES, ADItemTags.COOKED_RABBIT, ADItemTags.COOKED_DUCK, ADItemTags.COOKED_TURKEY, ADItemTags.COOKED_VENISON);

		this.tag(ADItemTags.INGOTS_SILVER);
		this.tag(ADItemTags.INGOTS_NECROMIUM);

		this.tag(ADItemTags.SNAIL_BREEDING_ITEMS).add(ModItems.NETHER_SALAD.get());
		this.tag(ADItemTags.SLABFISH_FOOD).add(ADItems.SLABDISH.get());
	}
}