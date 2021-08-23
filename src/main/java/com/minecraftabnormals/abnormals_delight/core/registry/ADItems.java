package com.minecraftabnormals.abnormals_delight.core.registry;

import com.minecraftabnormals.abnormals_delight.common.item.*;
import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import com.minecraftabnormals.abnormals_delight.core.other.ADConstants;
import com.minecraftabnormals.abnormals_delight.core.registry.util.ADItemSubRegistryHelper;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.registry.ModEffects;

@Mod.EventBusSubscriber(modid = AbnormalsDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ADItems {
	public static final ADItemSubRegistryHelper HELPER = AbnormalsDelight.REGISTRY_HELPER.getItemSubHelper();

	public static final RegistryObject<Item> SILVER_KNIFE = HELPER.createItem("silver_knife", SilverKnifeItem::new);
	public static final RegistryObject<Item> NECROMIUM_KNIFE = HELPER.createItem("necromium_knife", NecromiumKnifeItem::new);

	public static final RegistryObject<Item> DUCK_FILLET = HELPER.createCompatItem(ADConstants.ENVIRONMENTAL, "duck_fillet", new Item.Properties().food(Foods.DUCK_FILLET), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> COOKED_DUCK_FILLET = HELPER.createCompatItem(ADConstants.ENVIRONMENTAL, "cooked_duck_fillet", new Item.Properties().food(Foods.COOKED_DUCK_FILLET), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> VENISON_SHANKS = HELPER.createCompatItem(ADConstants.ENVIRONMENTAL, "venison_shanks", new Item.Properties().food(Foods.VENISON_SHANKS), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> COOKED_VENISON_SHANKS = HELPER.createCompatItem(ADConstants.ENVIRONMENTAL, "cooked_venison_shanks", new Item.Properties().food(Foods.COOKED_VENISON_SHANKS), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> PIKE_SLICE = HELPER.createCompatItem(ADConstants.UPGRADE_AQUATIC, "pike_slice", new Item.Properties().food(Foods.PIKE_SLICE), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> COOKED_PIKE_SLICE = HELPER.createCompatItem(ADConstants.UPGRADE_AQUATIC, "cooked_pike_slice", new Item.Properties().food(Foods.COOKED_PIKE_SLICE), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> PERCH_SLICE = HELPER.createCompatItem(ADConstants.UPGRADE_AQUATIC, "perch_slice", new Item.Properties().food(Foods.PERCH_SLICE), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> COOKED_PERCH_SLICE = HELPER.createCompatItem(ADConstants.UPGRADE_AQUATIC, "cooked_perch_slice", new Item.Properties().food(Foods.COOKED_PERCH_SLICE), ItemGroup.TAB_FOOD);

	public static final RegistryObject<Item> CHERRY_COOKIE = HELPER.createCompatConsumableItem("cherry_cookie", new Item.Properties().food(Foods.COOKIES), ItemGroup.TAB_FOOD, ADConstants.ENVIRONMENTAL);
	public static final RegistryObject<Item> MULBERRY_COOKIE = HELPER.createCompatConsumableItem("mulberry_cookie", new Item.Properties().food(Foods.COOKIES), ItemGroup.TAB_FOOD, ADConstants.UPGRADE_AQUATIC);
	public static final RegistryObject<Item> MAPLE_COOKIE = HELPER.createCompatConsumableItem("maple_cookie", new Item.Properties().food(Foods.COOKIES), ItemGroup.TAB_FOOD, ADConstants.AUTUMNITY);

	public static final RegistryObject<Item> SEARED_VENISON = HELPER.createCompatConsumableItem("seared_venison", new Item.Properties().craftRemainder(Items.BOWL).food(Foods.SEARED_VENISON).stacksTo(16), ItemGroup.TAB_FOOD, ADConstants.ENVIRONMENTAL);
	public static final RegistryObject<Item> PASSIONFRUIT_GLAZED_DUCK = HELPER.createCompatConsumableItem("passionfruit_glazed_duck", new Item.Properties().craftRemainder(Items.BOWL).food(Foods.PASSIONFRUIT_GLAZED_DUCK).stacksTo(16), ItemGroup.TAB_FOOD, ADConstants.ATMOSPHERIC, ADConstants.ENVIRONMENTAL);
	public static final RegistryObject<Item> DUNE_PLATTER = HELPER.createCompatConsumableItem("dune_platter", new Item.Properties().craftRemainder(Items.BOWL).food(Foods.DUNE_PLATTER).stacksTo(16), ItemGroup.TAB_FOOD, ADConstants.ATMOSPHERIC);
	public static final RegistryObject<Item> DUCK_NOODLES = HELPER.createCompatConsumableItem("duck_noodles", new Item.Properties().craftRemainder(Items.BOWL).food(Foods.DUCK_NOODLES).stacksTo(16), ItemGroup.TAB_FOOD, ADConstants.ENVIRONMENTAL);
	public static final RegistryObject<Item> PERCH_WITH_MUSHROOMS = HELPER.createCompatConsumableItem("perch_with_mushrooms", new Item.Properties().craftRemainder(Items.BOWL).food(Foods.PERCH_WITH_MUSHROOMS).stacksTo(16), ItemGroup.TAB_FOOD, ADConstants.UPGRADE_AQUATIC);
	public static final RegistryObject<Item> PIKE_WITH_BEETROOT = HELPER.createCompatConsumableItem("pike_with_beetroot", new Item.Properties().craftRemainder(Items.BOWL).food(Foods.PIKE_WITH_BEETROOT).stacksTo(16), ItemGroup.TAB_FOOD, ADConstants.UPGRADE_AQUATIC);
	public static final RegistryObject<Item> VENISON_WITH_BAMBOO_SHOOTS = HELPER.createCompatConsumableItem("venison_with_bamboo_shoots", new Item.Properties().craftRemainder(Items.BOWL).food(Foods.VENISON_WITH_BAMBOO_SHOOTS).stacksTo(16), ItemGroup.TAB_FOOD, ADConstants.ENVIRONMENTAL);

	public static final RegistryObject<Item> MAPLE_GLAZED_BACON = HELPER.createCompatItem("maple_glazed_bacon", new Item.Properties().food(Foods.MAPLE_GLAZED_BACON), ItemGroup.TAB_FOOD, ADConstants.AUTUMNITY);
	public static final RegistryObject<Item> ESCARGOT = HELPER.createCompatContainerConsumableItem("escargot", ADConstants.SNAIL_SHELL_PIECE, new Item.Properties().food(Foods.ESCARGOT).stacksTo(16), ItemGroup.TAB_FOOD, ADConstants.AUTUMNITY);

	public static final RegistryObject<Item> CHERRY_CREAM_SODA = HELPER.createItem("cherry_cream_soda", () -> new EffectDrinkItem(Effects.SLOW_FALLING, new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), ADConstants.ENVIRONMENTAL));
	public static final RegistryObject<Item> PASSION_ALOE_NECTAR = HELPER.createItem("passion_aloe_nectar", () -> new NectarItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> PICKERELWEED_JUICE = HELPER.createItem("pickerelweed_juice", () -> new EffectDrinkItem(Effects.WATER_BREATHING, new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), ADConstants.UPGRADE_AQUATIC));

	public static final RegistryObject<Item> VANILLA_CAKE_SLICE = HELPER.createItem("vanilla_cake_slice", () -> new CakeSliceItem(ADConstants.NEAPOLITAN, ADConstants.VANILLA_SCENT, 100, new Item.Properties().food(Foods.CAKE_SLICE), ItemGroup.TAB_FOOD));
	public static final RegistryObject<Item> CHOCOLATE_CAKE_SLICE = HELPER.createItem("chocolate_cake_slice", () -> new CakeSliceItem(ADConstants.NEAPOLITAN, ADConstants.SUGAR_RUSH, 200, new Item.Properties().food(Foods.CAKE_SLICE), ItemGroup.TAB_FOOD));
	public static final RegistryObject<Item> STRAWBERRY_CAKE_SLICE = HELPER.createItem("strawberry_cake_slice", () -> new CakeSliceItem(ADConstants.NEAPOLITAN, new Item.Properties().food(Foods.CAKE_SLICE), ItemGroup.TAB_FOOD));
	public static final RegistryObject<Item> BANANA_CAKE_SLICE = HELPER.createItem("banana_cake_slice", () -> new CakeSliceItem(ADConstants.NEAPOLITAN, ADConstants.AGILITY, 200, new Item.Properties().food(Foods.CAKE_SLICE), ItemGroup.TAB_FOOD));
	public static final RegistryObject<Item> MINT_CAKE_SLICE = HELPER.createItem("mint_cake_slice", () -> new CakeSliceItem(ADConstants.NEAPOLITAN, ADConstants.BERSERKING, 300, new Item.Properties().food(Foods.CAKE_SLICE), ItemGroup.TAB_FOOD));
	public static final RegistryObject<Item> ADZUKI_CAKE_SLICE = HELPER.createItem("adzuki_cake_slice", () -> new CakeSliceItem(ADConstants.NEAPOLITAN, ADConstants.HARMONY, 200, new Item.Properties().food(Foods.CAKE_SLICE), ItemGroup.TAB_FOOD));
	public static final RegistryObject<Item> YUCCA_GATEAU_SLICE = HELPER.createItem("yucca_gateau_slice", () -> new CakeSliceItem(ADConstants.ATMOSPHERIC, ADConstants.PERSISTENCE, 320, new Item.Properties().food(Foods.YUCCA_GATEAU_SLICE), ItemGroup.TAB_FOOD));

	public static class Foods {
		public static final Food DUCK_FILLET = (new Food.Builder()).nutrition(2).saturationMod(0.1F).effect(() -> new EffectInstance(Effects.HUNGER, 600, 0), 0.3F).meat().build();
		public static final Food COOKED_DUCK_FILLET = (new Food.Builder()).nutrition(4).saturationMod(0.3F).meat().build();
		public static final Food VENISON_SHANKS = (new Food.Builder()).nutrition(1).saturationMod(0.3F).meat().build();
		public static final Food COOKED_VENISON_SHANKS = (new Food.Builder()).nutrition(3).saturationMod(0.8F).meat().build();
		public static final Food PIKE_SLICE = (new Food.Builder()).nutrition(1).saturationMod(0.3F).build();
		public static final Food COOKED_PIKE_SLICE = (new Food.Builder()).nutrition(4).saturationMod(0.8F).build();
		public static final Food PERCH_SLICE = (new Food.Builder()).nutrition(1).saturationMod(0.2F).build();
		public static final Food COOKED_PERCH_SLICE = (new Food.Builder()).nutrition(2).saturationMod(0.7F).build();

		public static final Food SEARED_VENISON = (new Food.Builder()).nutrition(12).saturationMod(0.9F).effect(() -> new EffectInstance(ModEffects.NOURISHED.get(), 2400, 0), 1.0F).build();
		public static final Food PASSIONFRUIT_GLAZED_DUCK = (new Food.Builder()).nutrition(14).saturationMod(0.9F).effect(() -> new EffectInstance(ModEffects.NOURISHED.get(), 4800, 0), 1.0F).build();
		public static final Food DUNE_PLATTER = (new Food.Builder()).nutrition(10).saturationMod(0.8F).effect(() -> new EffectInstance(ModEffects.NOURISHED.get(), 2400, 0), 1.0F).build();
		public static final Food DUCK_NOODLES = (new Food.Builder()).nutrition(12).saturationMod(0.8F).effect(() -> new EffectInstance(ModEffects.NOURISHED.get(), 4800, 0), 1.0F).build();
		public static final Food PERCH_WITH_MUSHROOMS = (new Food.Builder()).nutrition(14).saturationMod(0.9F).effect(() -> new EffectInstance(ModEffects.NOURISHED.get(), 4800, 0), 1.0F).build();
		public static final Food PIKE_WITH_BEETROOT = (new Food.Builder()).nutrition(9).saturationMod(0.7F).effect(() -> new EffectInstance(ModEffects.NOURISHED.get(), 1200, 0), 1.0F).build();
		public static final Food VENISON_WITH_BAMBOO_SHOOTS = (new Food.Builder()).nutrition(11).saturationMod(0.9F).effect(() -> new EffectInstance(ModEffects.NOURISHED.get(), 2400, 0), 1.0F).build();

		public static final Food MAPLE_GLAZED_BACON = (new Food.Builder()).nutrition(6).saturationMod(0.8F).effect(() -> new EffectInstance(Effects.DAMAGE_RESISTANCE, 100), 1.0F).build();
		public static final Food ESCARGOT = (new Food.Builder()).nutrition(8).saturationMod(0.5F).build();

		public static final Food COOKIES = (new Food.Builder()).nutrition(2).saturationMod(0.1F).fast().build();
		public static final Food CAKE_SLICE = (new Food.Builder()).nutrition(1).saturationMod(0.1F).fast().effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 600, 0), 1.0F).build();
		public static final Food YUCCA_GATEAU_SLICE = (new Food.Builder()).nutrition(1).saturationMod(0.0F).fast().effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 600, 0), 1.0F).build();
	}
}