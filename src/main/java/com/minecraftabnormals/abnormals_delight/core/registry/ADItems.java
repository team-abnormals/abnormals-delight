package com.minecraftabnormals.abnormals_delight.core.registry;

import com.minecraftabnormals.abnormals_delight.common.item.CakeSliceItem;
import com.minecraftabnormals.abnormals_delight.common.item.NecromiumKnifeItem;
import com.minecraftabnormals.abnormals_delight.common.item.SilverKnifeItem;
import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import com.minecraftabnormals.abnormals_delight.core.other.ADCompat;
import com.minecraftabnormals.abnormals_delight.core.registry.util.ADItemSubRegistryHelper;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.registry.ModEffects;

@Mod.EventBusSubscriber(modid = AbnormalsDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ADItems {
	public static final ADItemSubRegistryHelper HELPER = AbnormalsDelight.REGISTRY_HELPER.getItemSubHelper();

	public static final RegistryObject<Item> SILVER_KNIFE = HELPER.createItem("silver_knife", SilverKnifeItem::new);
	public static final RegistryObject<Item> NECROMIUM_KNIFE = HELPER.createItem("necromium_knife", NecromiumKnifeItem::new);

	public static final RegistryObject<Item> DUCK_FILLET = HELPER.createCompatItem(ADCompat.ENVIRONMENTAL, "duck_fillet", new Item.Properties().food(Foods.DUCK_FILLET), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> COOKED_DUCK_FILLET = HELPER.createCompatItem(ADCompat.ENVIRONMENTAL, "cooked_duck_fillet", new Item.Properties().food(Foods.COOKED_DUCK_FILLET), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> VENISON_SHANKS = HELPER.createCompatItem(ADCompat.ENVIRONMENTAL, "venison_shanks", new Item.Properties().food(Foods.VENISON_SHANKS), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> COOKED_VENISON_SHANKS = HELPER.createCompatItem(ADCompat.ENVIRONMENTAL, "cooked_venison_shanks", new Item.Properties().food(Foods.COOKED_VENISON_SHANKS), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> PIKE_SLICE = HELPER.createCompatItem(ADCompat.UPGRADE_AQUATIC, "pike_slice", new Item.Properties().food(Foods.PIKE_SLICE), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> COOKED_PIKE_SLICE = HELPER.createCompatItem(ADCompat.UPGRADE_AQUATIC, "cooked_pike_slice", new Item.Properties().food(Foods.COOKED_PIKE_SLICE), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> PERCH_SLICE = HELPER.createCompatItem(ADCompat.UPGRADE_AQUATIC, "perch_slice", new Item.Properties().food(Foods.PERCH_SLICE), ItemGroup.TAB_FOOD);
	public static final RegistryObject<Item> COOKED_PERCH_SLICE = HELPER.createCompatItem(ADCompat.UPGRADE_AQUATIC, "cooked_perch_slice", new Item.Properties().food(Foods.COOKED_PERCH_SLICE), ItemGroup.TAB_FOOD);

	public static final RegistryObject<Item> CHERRY_COOKIE = HELPER.createCompatFastItem("cherry_cookie", new Item.Properties().food(Foods.COOKIES), ItemGroup.TAB_FOOD, ADCompat.ENVIRONMENTAL);
	public static final RegistryObject<Item> MULBERRY_COOKIE = HELPER.createCompatConsumableItem("mulberry_cookie", new Item.Properties().food(Foods.COOKIES), ItemGroup.TAB_FOOD, ADCompat.UPGRADE_AQUATIC);
	public static final RegistryObject<Item> MAPLE_COOKIE = HELPER.createCompatConsumableItem("maple_cookie", new Item.Properties().food(Foods.COOKIES), ItemGroup.TAB_FOOD, ADCompat.AUTUMNITY);

	public static final RegistryObject<Item> SEARED_VENISON = HELPER.createCompatConsumableItem("seared_venison", new Item.Properties().craftRemainder(Items.BOWL).food(Foods.SEARED_VENISON).stacksTo(16), ItemGroup.TAB_FOOD, ADCompat.ENVIRONMENTAL);
	public static final RegistryObject<Item> PASSIONFRUIT_GLAZED_DUCK = HELPER.createCompatConsumableItem("passionfruit_glazed_duck", new Item.Properties().craftRemainder(Items.BOWL).food(Foods.PASSIONFRUIT_GLAZED_DUCK).stacksTo(16), ItemGroup.TAB_FOOD, ADCompat.ATMOSPHERIC, ADCompat.ENVIRONMENTAL);
	public static final RegistryObject<Item> DUNE_PLATTER = HELPER.createCompatConsumableItem("dune_platter", new Item.Properties().craftRemainder(Items.BOWL).food(Foods.DUNE_PLATTER).stacksTo(16), ItemGroup.TAB_FOOD, ADCompat.ATMOSPHERIC);
	public static final RegistryObject<Item> ESCARGOT = HELPER.createCompatContainerConsumableItem("escargot", new ResourceLocation(ADCompat.AUTUMNITY, "snail_shell_piece"), new Item.Properties().food(Foods.ESCARGOT).stacksTo(16), ItemGroup.TAB_FOOD, ADCompat.AUTUMNITY);

	public static final RegistryObject<Item> VANILLA_CAKE_SLICE = HELPER.createItem("vanilla_cake_slice", () -> new CakeSliceItem(ADCompat.NEAPOLITAN, () -> new EffectInstance(CompatEffects.VANILLA_SCENT, 100), new Item.Properties().food(Foods.CAKE_SLICE), ItemGroup.TAB_FOOD));
	public static final RegistryObject<Item> CHOCOLATE_CAKE_SLICE = HELPER.createItem("chocolate_cake_slice", () -> new CakeSliceItem(ADCompat.NEAPOLITAN, () -> new EffectInstance(CompatEffects.SUGAR_RUSH, 200), new Item.Properties().food(Foods.CAKE_SLICE), ItemGroup.TAB_FOOD));
	public static final RegistryObject<Item> STRAWBERRY_CAKE_SLICE = HELPER.createItem("strawberry_cake_slice", () -> new CakeSliceItem(ADCompat.NEAPOLITAN, null, new Item.Properties().food(Foods.CAKE_SLICE), ItemGroup.TAB_FOOD));
	public static final RegistryObject<Item> BANANA_CAKE_SLICE = HELPER.createItem("banana_cake_slice", () -> new CakeSliceItem(ADCompat.NEAPOLITAN, () -> new EffectInstance(CompatEffects.AGILITY, 200), new Item.Properties().food(Foods.CAKE_SLICE), ItemGroup.TAB_FOOD));
	public static final RegistryObject<Item> MINT_CAKE_SLICE = HELPER.createItem("mint_cake_slice", () -> new CakeSliceItem(ADCompat.NEAPOLITAN, () -> new EffectInstance(CompatEffects.BERSERKING, 300), new Item.Properties().food(Foods.CAKE_SLICE), ItemGroup.TAB_FOOD));
	public static final RegistryObject<Item> ADZUKI_CAKE_SLICE = HELPER.createItem("adzuki_cake_slice", () -> new CakeSliceItem(ADCompat.NEAPOLITAN, () -> new EffectInstance(CompatEffects.HARMONY, 200), new Item.Properties().food(Foods.CAKE_SLICE), ItemGroup.TAB_FOOD));

	public static final RegistryObject<Item> YUCCA_GATEAU_SLICE = HELPER.createItem("yucca_gateau_slice", () -> new CakeSliceItem(ADCompat.ATMOSPHERIC, () -> new EffectInstance(CompatEffects.PERSISTENCE, 320), new Item.Properties().food(Foods.YUCCA_GATEAU_SLICE), ItemGroup.TAB_FOOD));

	public static class Foods {
		public static final Food DUCK_FILLET = (new Food.Builder()).nutrition(2).saturationMod(0.1F).effect(() -> new EffectInstance(Effects.HUNGER, 600, 0), 0.3F).meat().build();
		public static final Food COOKED_DUCK_FILLET = (new Food.Builder()).nutrition(4).saturationMod(0.3F).meat().build();
		public static final Food VENISON_SHANKS = (new Food.Builder()).nutrition(1).saturationMod(0.3F).meat().build();
		public static final Food COOKED_VENISON_SHANKS = (new Food.Builder()).nutrition(3).saturationMod(0.8F).meat().build();
		public static final Food PIKE_SLICE = (new Food.Builder()).nutrition(1).saturationMod(0.3F).build();
		public static final Food COOKED_PIKE_SLICE = (new Food.Builder()).nutrition(4).saturationMod(0.8F).build();
		public static final Food PERCH_SLICE = (new Food.Builder()).nutrition(1).saturationMod(0.2F).build();
		public static final Food COOKED_PERCH_SLICE = (new Food.Builder()).nutrition(2).saturationMod(0.7F).build();

		public static final Food SEARED_VENISON = (new Food.Builder()).nutrition(12).saturationMod(0.9F).effect(() -> new EffectInstance(ModEffects.NOURISHED.get(), 4800, 0), 1.0F).build();
		public static final Food PASSIONFRUIT_GLAZED_DUCK = (new Food.Builder()).nutrition(14).saturationMod(0.9F).effect(() -> new EffectInstance(ModEffects.NOURISHED.get(), 9600, 0), 1.0F).build();
		public static final Food DUNE_PLATTER = (new Food.Builder()).nutrition(10).saturationMod(0.8F).effect(() -> new EffectInstance(ModEffects.NOURISHED.get(), 4800, 0), 1.0F).build();
		public static final Food ESCARGOT = (new Food.Builder()).nutrition(8).saturationMod(0.5F).build();

		public static final Food COOKIES = (new Food.Builder()).nutrition(2).saturationMod(0.1F).fast().build();
		public static final Food CAKE_SLICE = (new Food.Builder()).nutrition(1).saturationMod(0.1F).fast().effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 600, 0), 1.0F).build();
		public static final Food YUCCA_GATEAU_SLICE = (new Food.Builder()).nutrition(1).saturationMod(0.0F).fast().effect(() -> new EffectInstance(Effects.MOVEMENT_SPEED, 600, 0), 1.0F).build();
	}

	public static class CompatEffects {
		public static final Effect SUGAR_RUSH = ForgeRegistries.POTIONS.getValue(new ResourceLocation(ADCompat.NEAPOLITAN, "sugar_rush"));
		public static final Effect VANILLA_SCENT = ForgeRegistries.POTIONS.getValue(new ResourceLocation(ADCompat.NEAPOLITAN, "vanilla_scent"));
		public static final Effect AGILITY = ForgeRegistries.POTIONS.getValue(new ResourceLocation(ADCompat.NEAPOLITAN, "agility"));
		public static final Effect BERSERKING = ForgeRegistries.POTIONS.getValue(new ResourceLocation(ADCompat.NEAPOLITAN, "berserking"));
		public static final Effect HARMONY = ForgeRegistries.POTIONS.getValue(new ResourceLocation(ADCompat.NEAPOLITAN, "harmony"));

		public static final Effect PERSISTENCE = ForgeRegistries.POTIONS.getValue(new ResourceLocation(ADCompat.ATMOSPHERIC, "persistence"));
	}
}