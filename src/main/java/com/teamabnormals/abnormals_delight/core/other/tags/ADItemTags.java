package com.teamabnormals.abnormals_delight.core.other.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;

public class ADItemTags {
	public static final Tag.Named<Item> SLABDISH_INGREDIENTS = tag("slabdish_ingredients");

	public static final Tag.Named<Item> COOKED_DUCK = forgeTag("cooked_duck");
	public static final Tag.Named<Item> COOKED_RABBIT = forgeTag("cooked_rabbit");
	public static final Tag.Named<Item> COOKED_VENISON = forgeTag("cooked_venison");
	public static final Tag.Named<Item> COOKED_FISHES_PERCH = forgeTag("cooked_fishes/perch");
	public static final Tag.Named<Item> COOKED_FISHES_PIKE = forgeTag("cooked_fishes/pike");

	public static final Tag.Named<Item> RAW_DUCK = forgeTag("raw_duck");
	public static final Tag.Named<Item> RAW_RABBIT = forgeTag("raw_rabbit");
	public static final Tag.Named<Item> RAW_VENISON = forgeTag("raw_venison");
	public static final Tag.Named<Item> RAW_FISHES_PERCH = forgeTag("raw_fishes/perch");
	public static final Tag.Named<Item> RAW_FISHES_PIKE = forgeTag("raw_fishes/pike");

	public static final Tag.Named<Item> SNAIL_BREEDING_ITEMS = modTag(ADConstants.AUTUMNITY, "snail_breeding_items");
	public static final Tag.Named<Item> AFFLICTION_ITEMS = modTag(ADConstants.CAVERNS_AND_CHASMS, "affliction_items");
	public static final Tag.Named<Item> EXPERIENCE_BOOST_ITEMS = modTag(ADConstants.CAVERNS_AND_CHASMS, "experience_boost_items");
	public static final Tag.Named<Item> NECROMIUM_GEAR = modTag(ADConstants.CAVERNS_AND_CHASMS, "necromium_gear");
	public static final Tag.Named<Item> SILVER_GEAR = modTag(ADConstants.CAVERNS_AND_CHASMS, "silver_gear");
	public static final Tag.Named<Item> SLABFISH_FOOD = modTag(ADConstants.ENVIRONMENTAL, "slabfish_food");
	public static final Tag.Named<Item> NETHERITE_GEAR = modTag(ADConstants.NETHER_EXTENSION, "netherite_gear");

	private static Tag.Named<Item> tag(String name) {
		return ItemTags.bind(AbnormalsDelight.MOD_ID + ":" + name);
	}

	private static Tag.Named<Item> modTag(String modid, String name) {
		return ItemTags.bind(modid + ":" + name);
	}

	private static Tag.Named<Item> forgeTag(String name) {
		return ItemTags.bind("forge:" + name);
	}
}
