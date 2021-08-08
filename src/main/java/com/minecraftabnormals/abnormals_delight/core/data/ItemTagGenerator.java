package com.minecraftabnormals.abnormals_delight.core.data;

import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import com.minecraftabnormals.abnormals_delight.core.other.ADCompat;
import com.minecraftabnormals.abnormals_delight.core.other.ADItemTags;
import com.minecraftabnormals.abnormals_delight.core.registry.ADItems;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Items;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.registry.ModItems;
import vectorwing.farmersdelight.utils.tags.ForgeTags;
import vectorwing.farmersdelight.utils.tags.ModTags;

public class ItemTagGenerator extends ItemTagsProvider {

	public ItemTagGenerator(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
		super(generator, blockTagsProvider, AbnormalsDelight.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(ADItemTags.COOKED_DUCK).add(ADItems.COOKED_DUCK_FILLET.get());
		this.tag(ADItemTags.COOKED_RABBIT).add(Items.COOKED_RABBIT);
		this.tag(ADItemTags.COOKED_VENISON).add(ADItems.COOKED_VENISON_SHANKS.get());
		this.tag(ForgeTags.COOKED_FISHES).addTags(ADItemTags.COOKED_FISHES_PERCH, ADItemTags.COOKED_FISHES_PIKE);
		this.tag(ADItemTags.COOKED_FISHES_PERCH).add(ADItems.COOKED_PERCH_SLICE.get());
		this.tag(ADItemTags.COOKED_FISHES_PIKE).add(ADItems.COOKED_PIKE_SLICE.get());

		this.tag(ADItemTags.RAW_DUCK).add(ADItems.DUCK_FILLET.get());
		this.tag(ADItemTags.RAW_RABBIT).add(Items.RABBIT);
		this.tag(ADItemTags.RAW_VENISON).add(ADItems.VENISON_SHANKS.get());
		this.tag(ForgeTags.RAW_FISHES).addTags(ADItemTags.RAW_FISHES_PERCH, ADItemTags.RAW_FISHES_PIKE);
		this.tag(ADItemTags.RAW_FISHES_PERCH).add(ADItems.PERCH_SLICE.get());
		this.tag(ADItemTags.RAW_FISHES_PIKE).add(ADItems.PIKE_SLICE.get());

		this.tag(ForgeTags.TOOLS_KNIVES).add(ADItems.SILVER_KNIFE.get(), ADItems.NECROMIUM_KNIFE.get());

		this.tag(ModTags.KNIVES).add(ADItems.SILVER_KNIFE.get(), ADItems.NECROMIUM_KNIFE.get());
		this.tag(ModTags.CABBAGE_ROLL_INGREDIENTS).addTags(ADItemTags.RAW_DUCK, ADItemTags.RAW_RABBIT, ADItemTags.RAW_VENISON);
		this.tag(ModTags.WOLF_PREY).addTags(ADItemTags.RAW_DUCK, ADItemTags.RAW_VENISON);
		this.tag(ModTags.COMFORT_FOODS).addOptional(ADCompat.ADZUKI_STEW);

		this.tag(ADItemTags.SNAIL_BREEDING_ITEMS).add(ModItems.NETHER_SALAD.get());
		this.tag(ADItemTags.AFFLICTION_ITEMS).add(ADItems.SILVER_KNIFE.get());
		this.tag(ADItemTags.EXPERIENCE_BOOST_ITEMS).add(ModItems.GOLDEN_KNIFE.get());
		this.tag(ADItemTags.NECROMIUM_GEAR).add(ADItems.NECROMIUM_KNIFE.get());
		this.tag(ADItemTags.SILVER_GEAR).add(ADItems.SILVER_KNIFE.get());
		this.tag(ADItemTags.NETHERITE_GEAR).add(ModItems.NETHERITE_KNIFE.get());
	}
}