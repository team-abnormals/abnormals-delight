package com.minecraftabnormals.abnormals_delight.core.other;

import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class ADItemTags {
	public static final ITag.INamedTag<Item> COOKED_DUCK = forgeTag("cooked_duck");
	public static final ITag.INamedTag<Item> COOKED_RABBIT = forgeTag("cooked_rabbit");
	public static final ITag.INamedTag<Item> COOKED_VENISON = forgeTag("cooked_venison");
	public static final ITag.INamedTag<Item> COOKED_FISHES_PERCH = forgeTag("cooked_fishes/perch");
	public static final ITag.INamedTag<Item> COOKED_FISHES_PIKE = forgeTag("cooked_fishes/pike");

	public static final ITag.INamedTag<Item> RAW_DUCK = forgeTag("raw_duck");
	public static final ITag.INamedTag<Item> RAW_RABBIT = forgeTag("raw_rabbit");
	public static final ITag.INamedTag<Item> RAW_VENISON = forgeTag("raw_venison");
	public static final ITag.INamedTag<Item> RAW_FISHES_PERCH = forgeTag("raw_fishes/perch");
	public static final ITag.INamedTag<Item> RAW_FISHES_PIKE = forgeTag("raw_fishes/pike");

	public static final ITag.INamedTag<Item> SNAIL_BREEDING_ITEMS = modTag(ADCompat.AUTUMNITY, "snail_breeding_items");
	public static final ITag.INamedTag<Item> AFFLICTION_ITEMS = modTag(ADCompat.CAVERNS_AND_CHASMS, "affliction_items");
	public static final ITag.INamedTag<Item> EXPERIENCE_BOOST_ITEMS = modTag(ADCompat.CAVERNS_AND_CHASMS, "experience_boost_items");
	public static final ITag.INamedTag<Item> NECROMIUM_GEAR = modTag(ADCompat.CAVERNS_AND_CHASMS, "necromium_gear");
	public static final ITag.INamedTag<Item> SILVER_GEAR = modTag(ADCompat.CAVERNS_AND_CHASMS, "silver_gear");
	public static final ITag.INamedTag<Item> NETHERITE_GEAR = modTag(ADCompat.NETHER_EXTENSION, "netherite_gear");

	private static ITag.INamedTag<Item> tag(String name) {
		return ItemTags.bind(AbnormalsDelight.MOD_ID + ":" + name);
	}

	private static ITag.INamedTag<Item> modTag(String modid, String name) {
		return ItemTags.bind(modid + ":" + name);
	}

	private static ITag.INamedTag<Item> forgeTag(String name) {
		return ItemTags.bind("forge:" + name);
	}
}
