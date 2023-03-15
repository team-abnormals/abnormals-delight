package com.teamabnormals.abnormals_delight.common.item;

import com.teamabnormals.abnormals_delight.core.other.tags.ADItemTags;
import com.teamabnormals.blueprint.core.api.BlueprintItemTier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public class SilverKnifeItem extends AbnormalsKnifeItem {

	public SilverKnifeItem() {
		super(new BlueprintItemTier(0, 111, 7.0F, 0.0F, 17, () -> Ingredient.of(ADItemTags.INGOTS_SILVER)), new Item.Properties());
	}
}
