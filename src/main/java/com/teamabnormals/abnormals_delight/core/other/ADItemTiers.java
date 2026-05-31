package com.teamabnormals.abnormals_delight.core.other;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.WeatheringCopper.WeatherState;
import net.neoforged.fml.ModList;
import vectorwing.farmersdelight.common.item.KnifeItem;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Supplier;

public class ADItemTiers {
	public static final Tier COPPER = isCCLoaded() ? CCWrapper.COPPER : Tiers.STONE;
	public static final Tier SILVER = isCCLoaded() ? CCWrapper.SILVER : Tiers.IRON;
	public static final Tier NECROMIUM = isCCLoaded() ? CCWrapper.NECROMIUM : Tiers.NETHERITE;

	public static boolean isCCLoaded() {
		return ModList.get().isLoaded(ADConstants.CAVERNS_AND_CHASMS);
	}

	public static Supplier<? extends KnifeItem> createCopperKnife() {
		return () -> new KnifeItem(COPPER, ModItems.knifeItem(COPPER));
	}

	public static Supplier<? extends KnifeItem> createCopperKnife(WeatherState state) {
		return isCCLoaded() ? CCWrapper.createCopperKnife(state) : createCopperKnife();
	}
}
