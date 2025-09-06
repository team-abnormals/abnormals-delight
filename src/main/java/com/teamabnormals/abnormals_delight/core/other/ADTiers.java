package com.teamabnormals.abnormals_delight.core.other;

import com.teamabnormals.abnormals_delight.core.other.tags.ADBlockTags;
import com.teamabnormals.abnormals_delight.core.other.tags.ADItemTags;
import com.teamabnormals.blueprint.core.api.BlueprintItemTier;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ADTiers {
	public static final Tier SILVER = new BlueprintItemTier(ADBlockTags.INCORRECT_FOR_SILVER_TOOL, 157, 9.0F, 1.0F, 18, () -> Ingredient.of(ADItemTags.INGOTS_SILVER));
	public static final Tier NECROMIUM = new BlueprintItemTier(ADBlockTags.INCORRECT_FOR_NECROMIUM_TOOL, 2031, 9.0F, 3.0F, 15, () -> Ingredient.of(ADItemTags.INGOTS_NECROMIUM));
}
