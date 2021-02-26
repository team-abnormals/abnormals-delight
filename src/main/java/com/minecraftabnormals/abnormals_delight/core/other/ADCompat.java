package com.minecraftabnormals.abnormals_delight.core.other;

import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.minecraftabnormals.abnormals_delight.core.registry.ADItems;

public class ADCompat {
	public static void registerCompostables() {
		DataUtil.registerCompostable(ADItems.VANILLA_CAKE_SLICE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.CHOCOLATE_CAKE_SLICE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.STRAWBERRY_CAKE_SLICE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.BANANA_CAKE_SLICE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.MINT_CAKE_SLICE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.ADZUKI_CAKE_SLICE.get(), 0.85F);
		DataUtil.registerCompostable(ADItems.YUCCA_GATEAU_SLICE.get(), 0.85F);
	}
}
