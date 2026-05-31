package com.teamabnormals.abnormals_delight.core.other.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ADItemTags {
	public static final TagKey<Item> SLABDISH_INGREDIENTS = itemTag("slabdish_ingredients");
	public static final TagKey<Item> COPPER_KNIVES = itemTag("copper_knives");

	private static TagKey<Item> itemTag(String name) {
		return TagUtil.itemTag(AbnormalsDelight.MOD_ID, name);
	}
}
