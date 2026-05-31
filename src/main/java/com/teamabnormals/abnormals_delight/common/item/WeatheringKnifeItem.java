package com.teamabnormals.abnormals_delight.common.item;

import com.teamabnormals.caverns_and_chasms.common.item.copper.WeatheringCopperItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.WeatheringCopper.WeatherState;
import vectorwing.farmersdelight.common.item.KnifeItem;

public class WeatheringKnifeItem extends KnifeItem implements WeatheringCopperItem {
	private final WeatherState weatherState;

	public WeatheringKnifeItem(WeatherState weatherState, Tier tier, Properties properties) {
		super(tier, properties);
		this.weatherState = weatherState;
	}

	@Override
	public WeatherState getAge() {
		return this.weatherState;
	}
}