package com.teamabnormals.abnormals_delight.core.other;

import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import com.teamabnormals.blueprint.core.util.DataUtil;

public class ADCompat {

	public static void registerCompat() {
		registerCompostables();
	}

	private static void registerCompostables() {
		DataUtil.registerCompostable(ADItems.CHERRY_COOKIE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.MULBERRY_COOKIE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.MAPLE_COOKIE.get(), 0.85F);

		DataUtil.registerCompostable(ADItems.VANILLA_CAKE_SLICE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.CHOCOLATE_CAKE_SLICE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.STRAWBERRY_CAKE_SLICE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.BANANA_CAKE_SLICE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.MINT_CAKE_SLICE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.ADZUKI_CAKE_SLICE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.YUCCA_GATEAU_SLICE.get(), 0.85F);
	}
}
