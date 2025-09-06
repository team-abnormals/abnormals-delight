package com.teamabnormals.abnormals_delight.core.other.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ADItemTags {
	public static final TagKey<Item> SLABDISH_INGREDIENTS = itemTag("slabdish_ingredients");
	public static final TagKey<Item> BARBECUE_STICK_INGREDIENTS = itemTag("barbecue_stick_ingredients");

	public static final TagKey<Item> COOKED_DUCK = TagUtil.itemTag("c", "foods/cooked_duck");
	public static final TagKey<Item> COOKED_TURKEY = TagUtil.itemTag("c", "foods/cooked_turkey");
	public static final TagKey<Item> COOKED_RABBIT = TagUtil.itemTag("c", "foods/cooked_rabbit");
	public static final TagKey<Item> COOKED_VENISON = TagUtil.itemTag("c", "foods/cooked_venison");
	public static final TagKey<Item> COOKED_FISHES_PERCH = TagUtil.itemTag("c", "foods/cooked_perch");
	public static final TagKey<Item> COOKED_FISHES_PIKE = TagUtil.itemTag("c", "foods/cooked_pike");

	public static final TagKey<Item> RAW_DUCK = TagUtil.itemTag("c", "foods/raw_duck");
	public static final TagKey<Item> RAW_TURKEY = TagUtil.itemTag("c", "foods/raw_turkey");
	public static final TagKey<Item> RAW_RABBIT = TagUtil.itemTag("c", "foods/raw_rabbit");
	public static final TagKey<Item> RAW_VENISON = TagUtil.itemTag("c", "foods/raw_venison");
	public static final TagKey<Item> RAW_FISHES_PERCH = TagUtil.itemTag("c", "foods/raw_perch");
	public static final TagKey<Item> RAW_FISHES_PIKE = TagUtil.itemTag("c", "foods/raw_pike");

	public static final TagKey<Item> FOODS_BANANA = TagUtil.itemTag("c", "foods/banana");

	public static final TagKey<Item> INGOTS_NECROMIUM = TagUtil.itemTag("c", "ingots/necromium");
	public static final TagKey<Item> INGOTS_SILVER = TagUtil.itemTag("c", "ingots/silver");

	public static final TagKey<Item> SNAIL_BREEDING_ITEMS = TagUtil.itemTag(ADConstants.AUTUMNITY, "snail_breeding_items");
	public static final TagKey<Item> SLABFISH_FOOD = TagUtil.itemTag(ADConstants.ENVIRONMENTAL, "slabfish_food");

	private static TagKey<Item> itemTag(String name) {
		return TagUtil.itemTag(AbnormalsDelight.MOD_ID, name);
	}
}
