package com.minecraftabnormals.abnormals_delight.core.other;

import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.minecraftabnormals.abnormals_delight.core.registry.ADItems;
import net.minecraft.util.ResourceLocation;

public class ADCompat {

	public static final ResourceLocation VANILLA_CAKE = new ResourceLocation("neapolitan", "vanilla_cake");
	public static final ResourceLocation CHOCOLATE_CAKE = new ResourceLocation("neapolitan", "chocolate_cake");
	public static final ResourceLocation STRAWBERRY_CAKE = new ResourceLocation("neapolitan", "strawberry_cake");
	public static final ResourceLocation BANANA_CAKE = new ResourceLocation("neapolitan", "banana_cake");
	public static final ResourceLocation MINT_CAKE = new ResourceLocation("neapolitan", "mint_cake");
	public static final ResourceLocation ADZUKI_CAKE = new ResourceLocation("neapolitan", "adzuki_cake");
	public static final ResourceLocation YUCCA_GATEAU = new ResourceLocation("atmospheric", "yucca_gateau");


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
