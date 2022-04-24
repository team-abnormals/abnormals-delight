package com.teamabnormals.abnormals_delight.core.registry;

import com.teamabnormals.abnormals_delight.common.item.CakeSliceItem;
import com.teamabnormals.abnormals_delight.common.item.EffectDrinkItem;
import com.teamabnormals.abnormals_delight.common.item.NecromiumKnifeItem;
import com.teamabnormals.abnormals_delight.common.item.NectarItem;
import com.teamabnormals.abnormals_delight.common.item.SilverKnifeItem;
import com.teamabnormals.abnormals_delight.common.item.SlabdishItem;
import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.abnormals_delight.core.registry.util.ADItemSubRegistryHelper;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.registry.ModEffects;

@Mod.EventBusSubscriber(modid = AbnormalsDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ADItems {
	public static final ADItemSubRegistryHelper HELPER = AbnormalsDelight.REGISTRY_HELPER.getItemSubHelper();

	public static final RegistryObject<Item> SILVER_KNIFE = HELPER.createItem("silver_knife", SilverKnifeItem::new);
	public static final RegistryObject<Item> NECROMIUM_KNIFE = HELPER.createItem("necromium_knife", NecromiumKnifeItem::new);

	public static final RegistryObject<Item> DUCK_FILLET = HELPER.createCompatItem(ADConstants.ENVIRONMENTAL, "duck_fillet", new Item.Properties().food(ADFoods.DUCK_FILLET), CreativeModeTab.TAB_FOOD);
	public static final RegistryObject<Item> COOKED_DUCK_FILLET = HELPER.createCompatItem(ADConstants.ENVIRONMENTAL, "cooked_duck_fillet", new Item.Properties().food(ADFoods.COOKED_DUCK_FILLET), CreativeModeTab.TAB_FOOD);
	public static final RegistryObject<Item> VENISON_SHANKS = HELPER.createCompatItem(ADConstants.ENVIRONMENTAL, "venison_shanks", new Item.Properties().food(ADFoods.VENISON_SHANKS), CreativeModeTab.TAB_FOOD);
	public static final RegistryObject<Item> COOKED_VENISON_SHANKS = HELPER.createCompatItem(ADConstants.ENVIRONMENTAL, "cooked_venison_shanks", new Item.Properties().food(ADFoods.COOKED_VENISON_SHANKS), CreativeModeTab.TAB_FOOD);
	public static final RegistryObject<Item> PIKE_SLICE = HELPER.createCompatItem(ADConstants.UPGRADE_AQUATIC, "pike_slice", new Item.Properties().food(ADFoods.PIKE_SLICE), CreativeModeTab.TAB_FOOD);
	public static final RegistryObject<Item> COOKED_PIKE_SLICE = HELPER.createCompatItem(ADConstants.UPGRADE_AQUATIC, "cooked_pike_slice", new Item.Properties().food(ADFoods.COOKED_PIKE_SLICE), CreativeModeTab.TAB_FOOD);
	public static final RegistryObject<Item> PERCH_SLICE = HELPER.createCompatItem(ADConstants.UPGRADE_AQUATIC, "perch_slice", new Item.Properties().food(ADFoods.PERCH_SLICE), CreativeModeTab.TAB_FOOD);
	public static final RegistryObject<Item> COOKED_PERCH_SLICE = HELPER.createCompatItem(ADConstants.UPGRADE_AQUATIC, "cooked_perch_slice", new Item.Properties().food(ADFoods.COOKED_PERCH_SLICE), CreativeModeTab.TAB_FOOD);

	public static final RegistryObject<Item> CHERRY_COOKIE = HELPER.createCompatConsumableItem("cherry_cookie", new Item.Properties().food(FoodValues.COOKIES), CreativeModeTab.TAB_FOOD, ADConstants.ENVIRONMENTAL);
	public static final RegistryObject<Item> MULBERRY_COOKIE = HELPER.createCompatConsumableItem("mulberry_cookie", new Item.Properties().food(FoodValues.COOKIES), CreativeModeTab.TAB_FOOD, ADConstants.UPGRADE_AQUATIC);
	public static final RegistryObject<Item> MAPLE_COOKIE = HELPER.createCompatConsumableItem("maple_cookie", new Item.Properties().food(FoodValues.COOKIES), CreativeModeTab.TAB_FOOD, ADConstants.AUTUMNITY);

	public static final RegistryObject<Item> SEARED_VENISON = HELPER.createCompatConsumableItem("seared_venison", new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.SEARED_VENISON).stacksTo(16), CreativeModeTab.TAB_FOOD, ADConstants.ENVIRONMENTAL);
	public static final RegistryObject<Item> PASSIONFRUIT_GLAZED_DUCK = HELPER.createCompatConsumableItem("passionfruit_glazed_duck", new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.PASSIONFRUIT_GLAZED_DUCK).stacksTo(16), CreativeModeTab.TAB_FOOD, ADConstants.ATMOSPHERIC, ADConstants.ENVIRONMENTAL);
	public static final RegistryObject<Item> DUNE_PLATTER = HELPER.createCompatConsumableItem("dune_platter", new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.DUNE_PLATTER).stacksTo(16), CreativeModeTab.TAB_FOOD, ADConstants.ATMOSPHERIC);
	public static final RegistryObject<Item> DUCK_NOODLES = HELPER.createCompatConsumableItem("duck_noodles", new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.DUCK_NOODLES).stacksTo(16), CreativeModeTab.TAB_FOOD, ADConstants.ENVIRONMENTAL);
	public static final RegistryObject<Item> PERCH_WITH_MUSHROOMS = HELPER.createCompatConsumableItem("perch_with_mushrooms", new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.PERCH_WITH_MUSHROOMS).stacksTo(16), CreativeModeTab.TAB_FOOD, ADConstants.UPGRADE_AQUATIC);
	public static final RegistryObject<Item> PIKE_WITH_BEETROOT = HELPER.createCompatConsumableItem("pike_with_beetroot", new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.PIKE_WITH_BEETROOT).stacksTo(16), CreativeModeTab.TAB_FOOD, ADConstants.UPGRADE_AQUATIC);
	public static final RegistryObject<Item> VENISON_WITH_BAMBOO_SHOOTS = HELPER.createCompatConsumableItem("venison_with_bamboo_shoots", new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.VENISON_WITH_BAMBOO_SHOOTS).stacksTo(16), CreativeModeTab.TAB_FOOD, ADConstants.ENVIRONMENTAL);

	public static final RegistryObject<Item> MAPLE_GLAZED_BACON = HELPER.createCompatItem("maple_glazed_bacon", new Item.Properties().food(ADFoods.MAPLE_GLAZED_BACON), CreativeModeTab.TAB_FOOD, ADConstants.AUTUMNITY);
	public static final RegistryObject<Item> ESCARGOT = HELPER.createCompatContainerConsumableItem("escargot", ADConstants.SNAIL_SHELL_PIECE, new Item.Properties().food(ADFoods.ESCARGOT).stacksTo(16), CreativeModeTab.TAB_FOOD, ADConstants.AUTUMNITY);
	public static final RegistryObject<Item> SLABDISH = HELPER.createItem("slabdish", () -> new SlabdishItem(new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.SLABDISH).stacksTo(16)));

	public static final RegistryObject<Item> CHERRY_CREAM_SODA = HELPER.createItem("cherry_cream_soda", () -> new EffectDrinkItem(MobEffects.SLOW_FALLING, new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), ADConstants.ENVIRONMENTAL));
	public static final RegistryObject<Item> PASSION_ALOE_NECTAR = HELPER.createItem("passion_aloe_nectar", () -> new NectarItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> PICKERELWEED_JUICE = HELPER.createItem("pickerelweed_juice", () -> new EffectDrinkItem(MobEffects.WATER_BREATHING, new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), ADConstants.UPGRADE_AQUATIC));

	public static final RegistryObject<Item> VANILLA_CAKE_SLICE = HELPER.createItem("vanilla_cake_slice", () -> new CakeSliceItem(ADConstants.NEAPOLITAN, ADConstants.VANILLA_SCENT, 100, new Item.Properties().food(ADFoods.CAKE_SLICE), CreativeModeTab.TAB_FOOD));
	public static final RegistryObject<Item> CHOCOLATE_CAKE_SLICE = HELPER.createItem("chocolate_cake_slice", () -> new CakeSliceItem(ADConstants.NEAPOLITAN, ADConstants.SUGAR_RUSH, 200, new Item.Properties().food(ADFoods.CAKE_SLICE), CreativeModeTab.TAB_FOOD));
	public static final RegistryObject<Item> STRAWBERRY_CAKE_SLICE = HELPER.createItem("strawberry_cake_slice", () -> new CakeSliceItem(ADConstants.NEAPOLITAN, new Item.Properties().food(ADFoods.CAKE_SLICE), CreativeModeTab.TAB_FOOD));
	public static final RegistryObject<Item> BANANA_CAKE_SLICE = HELPER.createItem("banana_cake_slice", () -> new CakeSliceItem(ADConstants.NEAPOLITAN, ADConstants.AGILITY, 200, new Item.Properties().food(ADFoods.CAKE_SLICE), CreativeModeTab.TAB_FOOD));
	public static final RegistryObject<Item> MINT_CAKE_SLICE = HELPER.createItem("mint_cake_slice", () -> new CakeSliceItem(ADConstants.NEAPOLITAN, ADConstants.BERSERKING, 300, new Item.Properties().food(ADFoods.CAKE_SLICE), CreativeModeTab.TAB_FOOD));
	public static final RegistryObject<Item> ADZUKI_CAKE_SLICE = HELPER.createItem("adzuki_cake_slice", () -> new CakeSliceItem(ADConstants.NEAPOLITAN, ADConstants.HARMONY, 200, new Item.Properties().food(ADFoods.CAKE_SLICE), CreativeModeTab.TAB_FOOD));
	public static final RegistryObject<Item> YUCCA_GATEAU_SLICE = HELPER.createItem("yucca_gateau_slice", () -> new CakeSliceItem(ADConstants.ATMOSPHERIC, ADConstants.PERSISTENCE, 320, new Item.Properties().food(ADFoods.YUCCA_GATEAU_SLICE), CreativeModeTab.TAB_FOOD));

	public static class ADFoods {
		public static final FoodProperties DUCK_FILLET = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().fast().build();
		public static final FoodProperties COOKED_DUCK_FILLET = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).meat().fast().build();
		public static final FoodProperties VENISON_SHANKS = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).meat().fast().build();
		public static final FoodProperties COOKED_VENISON_SHANKS = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.8F).meat().fast().build();
		public static final FoodProperties PIKE_SLICE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).fast().build();
		public static final FoodProperties COOKED_PIKE_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.8F).fast().build();
		public static final FoodProperties PERCH_SLICE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).fast().build();
		public static final FoodProperties COOKED_PERCH_SLICE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.7F).fast().build();

		public static final FoodProperties SEARED_VENISON = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.9F).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();
		public static final FoodProperties PASSIONFRUIT_GLAZED_DUCK = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.9F).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();
		public static final FoodProperties DUNE_PLATTER = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.MEDIUM_DURATION, 0), 1.0F).build();
		public static final FoodProperties DUCK_NOODLES = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();
		public static final FoodProperties PERCH_WITH_MUSHROOMS = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.9F).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();
		public static final FoodProperties PIKE_WITH_BEETROOT = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.7F).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.SHORT_DURATION, 0), 1.0F).build();
		public static final FoodProperties VENISON_WITH_BAMBOO_SHOOTS = (new FoodProperties.Builder()).nutrition(11).saturationMod(0.9F).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();

		public static final FoodProperties SLABDISH = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, FoodValues.BRIEF_DURATION), 1.0F).build();
		public static final FoodProperties MAPLE_GLAZED_BACON = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.8F).meat().effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, FoodValues.BRIEF_DURATION), 1.0F).build();
		public static final FoodProperties ESCARGOT = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.5F).build();

		public static final FoodProperties CAKE_SLICE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1.0F).build();
		public static final FoodProperties YUCCA_GATEAU_SLICE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.0F).fast().effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1.0F).build();
	}
}