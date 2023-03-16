package com.teamabnormals.abnormals_delight.core.other;

import com.teamabnormals.abnormals_delight.core.other.tags.ADItemTags;
import com.teamabnormals.blueprint.core.api.BlueprintItemTier;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ADTiers {
	public static final Tier SILVER = new BlueprintItemTier(0, 111, 7.0F, 0.0F, 17, () -> Ingredient.of(ADItemTags.INGOTS_SILVER));
	public static final Tier NECROMIUM = new BlueprintItemTier(4, 2251, 9.0F, 3.0F, 12, () -> Ingredient.of(ADItemTags.INGOTS_NECROMIUM));
}
