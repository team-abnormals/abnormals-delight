package com.teamabnormals.abnormals_delight.common.item;

import com.teamabnormals.abnormals_delight.core.other.tags.ADItemTags;
import com.teamabnormals.blueprint.core.api.BlueprintItemTier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public class NecromiumKnifeItem extends AbnormalsKnifeItem {

	public NecromiumKnifeItem() {
		super(new BlueprintItemTier(4, 2251, 9.0F, 3.0F, 12, () -> Ingredient.of(ADItemTags.INGOTS_NECROMIUM)), new Item.Properties().fireResistant());
	}
}
