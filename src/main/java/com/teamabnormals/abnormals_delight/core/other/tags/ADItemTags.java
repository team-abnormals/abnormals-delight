package com.teamabnormals.abnormals_delight.core.other.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ADItemTags {
	public static final TagKey<Item> SLABDISH_INGREDIENTS = itemTag("slabdish_ingredients");

	public static final TagKey<Item> COOKED_DUCK = TagUtil.itemTag("forge", "cooked_duck");
	public static final TagKey<Item> COOKED_RABBIT = TagUtil.itemTag("forge", "cooked_rabbit");
	public static final TagKey<Item> COOKED_VENISON = TagUtil.itemTag("forge", "cooked_venison");
	public static final TagKey<Item> COOKED_FISHES_PERCH = TagUtil.itemTag("forge", "cooked_fishes/perch");
	public static final TagKey<Item> COOKED_FISHES_PIKE = TagUtil.itemTag("forge", "cooked_fishes/pike");

	public static final TagKey<Item> RAW_DUCK = TagUtil.itemTag("forge", "raw_duck");
	public static final TagKey<Item> RAW_RABBIT = TagUtil.itemTag("forge", "raw_rabbit");
	public static final TagKey<Item> RAW_VENISON = TagUtil.itemTag("forge", "raw_venison");
	public static final TagKey<Item> RAW_FISHES_PERCH = TagUtil.itemTag("forge", "raw_fishes/perch");
	public static final TagKey<Item> RAW_FISHES_PIKE = TagUtil.itemTag("forge", "raw_fishes/pike");

	public static final TagKey<Item> SNAIL_BREEDING_ITEMS = TagUtil.itemTag(ADConstants.AUTUMNITY, "snail_breeding_items");
	public static final TagKey<Item> AFFLICTION_ITEMS = TagUtil.itemTag(ADConstants.CAVERNS_AND_CHASMS, "affliction_items");
	public static final TagKey<Item> EXPERIENCE_BOOST_ITEMS = TagUtil.itemTag(ADConstants.CAVERNS_AND_CHASMS, "experience_boost_items");
	public static final TagKey<Item> NECROMIUM_GEAR = TagUtil.itemTag(ADConstants.CAVERNS_AND_CHASMS, "necromium_gear");
	public static final TagKey<Item> SILVER_GEAR = TagUtil.itemTag(ADConstants.CAVERNS_AND_CHASMS, "silver_gear");
	public static final TagKey<Item> SLABFISH_FOOD = TagUtil.itemTag(ADConstants.ENVIRONMENTAL, "slabfish_food");
	public static final TagKey<Item> NETHERITE_GEAR = TagUtil.itemTag(ADConstants.NETHER_EXTENSION, "netherite_gear");

	private static TagKey<Item> itemTag(String name) {
		return TagUtil.itemTag(AbnormalsDelight.MOD_ID, name);
	}
}
