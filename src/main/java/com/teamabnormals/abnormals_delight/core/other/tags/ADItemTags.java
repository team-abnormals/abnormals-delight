package com.teamabnormals.abnormals_delight.core.other.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ADItemTags {
	public static final TagKey<Item> SLABDISH_INGREDIENTS = itemTag("slabdish_ingredients");

	public static final TagKey<Item> INGOTS_NECROMIUM = TagUtil.itemTag("c", "ingots/necromium");
	public static final TagKey<Item> INGOTS_SILVER = TagUtil.itemTag("c", "ingots/silver");

	private static TagKey<Item> itemTag(String name) {
		return TagUtil.itemTag(AbnormalsDelight.MOD_ID, name);
	}
}
