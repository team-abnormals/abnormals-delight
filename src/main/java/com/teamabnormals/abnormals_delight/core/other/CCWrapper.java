package com.teamabnormals.abnormals_delight.core.other;

import com.teamabnormals.abnormals_delight.common.item.WeatheringKnifeItem;
import com.teamabnormals.caverns_and_chasms.core.other.CCTiers.CCItemTiers;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.WeatheringCopper.WeatherState;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Supplier;

public class CCWrapper {
	public static final Tier COPPER = CCItemTiers.COPPER;
	public static final Tier SILVER = CCItemTiers.SILVER;
	public static final Tier NECROMIUM = CCItemTiers.NECROMIUM;

	public static Supplier<? extends WeatheringKnifeItem> createCopperKnife(WeatherState state) {
		return () -> new WeatheringKnifeItem(state, COPPER, ModItems.knifeItem(COPPER));
	}
}
