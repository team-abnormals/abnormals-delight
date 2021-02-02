package com.minecraftabnormals.abnormals_delight.core.registry;

import com.minecraftabnormals.abnormals_core.core.api.AbnormalsItemTier;
import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.minecraftabnormals.abnormals_delight.common.item.AbnormalsKnifeItem;
import com.minecraftabnormals.abnormals_delight.common.item.NecromiumKnifeItem;
import com.minecraftabnormals.abnormals_delight.common.item.SilverKnifeItem;
import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import net.minecraft.item.Food;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = AbnormalsDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ADItems {
	public static final ItemSubRegistryHelper HELPER = AbnormalsDelight.REGISTRY_HELPER.getItemSubHelper();

	public static final RegistryObject<Item> SILVER_KNIFE = HELPER.createItem("silver_knife", SilverKnifeItem::new);
	public static final RegistryObject<Item> NECROMIUM_KNIFE = HELPER.createItem("necromium_knife", NecromiumKnifeItem::new);

	public static final RegistryObject<Item> DUCK_FILLET = HELPER.createItem("duck_fillet", () -> new Item(new Item.Properties().food(Foods.DUCK_FILLET).group(ItemGroup.FOOD)));
	public static final RegistryObject<Item> COOKED_DUCK_FILLET = HELPER.createItem("cooked_duck_fillet", () -> new Item(new Item.Properties().food(Foods.COOKED_DUCK_FILLET).group(ItemGroup.FOOD)));
	public static final RegistryObject<Item> VENISON_SHANKS = HELPER.createItem("venison_shanks", () -> new Item(new Item.Properties().food(Foods.VENISON_SHANKS).group(ItemGroup.FOOD)));
	public static final RegistryObject<Item> COOKED_VENISON_SHANKS = HELPER.createItem("cooked_venison_shanks", () -> new Item(new Item.Properties().food(Foods.COOKED_VENISON_SHANKS).group(ItemGroup.FOOD)));

	public static final RegistryObject<Item> VANILLA_CAKE_SLICE = HELPER.createItem("vanilla_cake_slice", () -> new Item(new Item.Properties().food(Foods.CAKE_SLICE).group(ItemGroup.FOOD)));
	public static final RegistryObject<Item> CHOCOLATE_CAKE_SLICE = HELPER.createItem("chocolate_cake_slice", () -> new Item(new Item.Properties().food(Foods.CAKE_SLICE).group(ItemGroup.FOOD)));
	public static final RegistryObject<Item> STRAWBERRY_CAKE_SLICE = HELPER.createItem("strawberry_cake_slice", () -> new Item(new Item.Properties().food(Foods.CAKE_SLICE).group(ItemGroup.FOOD)));
	public static final RegistryObject<Item> BANANA_CAKE_SLICE = HELPER.createItem("banana_cake_slice", () -> new Item(new Item.Properties().food(Foods.CAKE_SLICE).group(ItemGroup.FOOD)));
	public static final RegistryObject<Item> YUCCA_GATEAU_SLICE = HELPER.createItem("yucca_gateau_slice", () -> new Item(new Item.Properties().food(Foods.YUCCA_GATEAU_SLICE).group(ItemGroup.FOOD)));

	public static class Foods {
		public static final Food DUCK_FILLET = (new Food.Builder()).hunger(1).saturation(0.1F).build();
		public static final Food COOKED_DUCK_FILLET = (new Food.Builder()).hunger(1).saturation(0.1F).build();
		public static final Food VENISON_SHANKS = (new Food.Builder()).hunger(1).saturation(0.1F).build();
		public static final Food COOKED_VENISON_SHANKS = (new Food.Builder()).hunger(1).saturation(0.1F).build();

		public static final Food CAKE_SLICE = (new Food.Builder()).hunger(1).saturation(0.1F).fastToEat().effect(() -> new EffectInstance(Effects.SPEED, 1200, 0), 1.0F).build();
		public static final Food YUCCA_GATEAU_SLICE = (new Food.Builder()).hunger(1).saturation(0.0F).fastToEat().effect(() -> new EffectInstance(Effects.SPEED, 1200, 0), 1.0F).build();
	}
}