package com.minecraftabnormals.abnormals_delight.core.other;

import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.minecraftabnormals.abnormals_delight.core.registry.ADItems;
import net.minecraft.util.ResourceLocation;

public class ADCompat {

	public static final String ATMOSPHERIC = "atmospheric";
	public static final String AUTUMNITY = "autumnity";
	public static final String ENVIRONMENTAL = "environmental";
	public static final String CAVERNS_AND_CHASMS = "caverns_and_chasms";
	public static final String NEAPOLITAN = "neapolitan";
	public static final String NETHER_EXTENSION = "nether_extension";
	public static final String UPGRADE_AQUATIC = "upgrade_aquatic";

	public static final ResourceLocation YUCCA_GATEAU = new ResourceLocation(ATMOSPHERIC, "yucca_gateau");

	public static final ResourceLocation BRAZIERS = new ResourceLocation(CAVERNS_AND_CHASMS, "braziers");

	public static final ResourceLocation ADZUKI_STEW = new ResourceLocation(NEAPOLITAN, "adzuki_stew");
	public static final ResourceLocation VANILLA_CAKE = new ResourceLocation(NEAPOLITAN, "vanilla_cake");
	public static final ResourceLocation CHOCOLATE_CAKE = new ResourceLocation(NEAPOLITAN, "chocolate_cake");
	public static final ResourceLocation STRAWBERRY_CAKE = new ResourceLocation(NEAPOLITAN, "strawberry_cake");
	public static final ResourceLocation BANANA_CAKE = new ResourceLocation(NEAPOLITAN, "banana_cake");
	public static final ResourceLocation MINT_CAKE = new ResourceLocation(NEAPOLITAN, "mint_cake");
	public static final ResourceLocation ADZUKI_CAKE = new ResourceLocation(NEAPOLITAN, "adzuki_cake");

	public static final ResourceLocation GLOWING_OBSIDIAN = new ResourceLocation(NETHER_EXTENSION, "glowing_obsidian");

	public static void registerCompostables() {
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
