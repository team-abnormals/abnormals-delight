package com.teamabnormals.abnormals_delight.common.item;

import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class NectarItem extends DrinkableItem {

	public NectarItem(Properties properties) {
		super(properties.food((new FoodProperties.Builder()).alwaysEdible().effect(() -> new MobEffectInstance(
				BuiltInRegistries.MOB_EFFECT.getHolder(ADConstants.RELIEF).isPresent() ? BuiltInRegistries.MOB_EFFECT.getHolder(ADConstants.RELIEF).get() : MobEffects.ABSORPTION,
				300, 0), 1.0F).build()));
	}
}