package com.teamabnormals.abnormals_delight.core.registry;

import com.teamabnormals.abnormals_delight.common.item.*;
import com.teamabnormals.abnormals_delight.core.ADConfig;
import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.abnormals_delight.core.other.ADTiers;
import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.KnifeItem;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;
import vectorwing.farmersdelight.common.registry.ModEffects;
import vectorwing.farmersdelight.common.registry.ModItems;

import static net.minecraft.world.item.CreativeModeTabs.*;
import static net.minecraft.world.item.crafting.Ingredient.of;

@EventBusSubscriber(modid = AbnormalsDelight.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ADItems {
	public static final ItemSubRegistryHelper HELPER = AbnormalsDelight.REGISTRY_HELPER.getItemSubHelper();

	public static final RegistryObject<Item> SILVER_KNIFE = HELPER.createItem("silver_knife", () -> new KnifeItem(ADTiers.SILVER, 0.5F, -2.0F, new Item.Properties()));
	public static final RegistryObject<Item> NECROMIUM_KNIFE = HELPER.createItem("necromium_knife", () -> new KnifeItem(ADTiers.NECROMIUM, 0.5F, -2.0F, new Item.Properties().fireResistant()));

	public static final RegistryObject<Item> DUCK_FILLET = HELPER.createItem("duck_fillet", () -> new Item(new Item.Properties().food(ADFoods.DUCK_FILLET)));
	public static final RegistryObject<Item> COOKED_DUCK_FILLET = HELPER.createItem("cooked_duck_fillet", () -> new Item(new Item.Properties().food(ADFoods.COOKED_DUCK_FILLET)));
	public static final RegistryObject<Item> VENISON_SHANKS = HELPER.createItem("venison_shanks", () -> new Item(new Item.Properties().food(ADFoods.VENISON_SHANKS)));
	public static final RegistryObject<Item> COOKED_VENISON_SHANKS = HELPER.createItem("cooked_venison_shanks", () -> new Item(new Item.Properties().food(ADFoods.COOKED_VENISON_SHANKS)));
	public static final RegistryObject<Item> PIKE_SLICE = HELPER.createItem("pike_slice", () -> new Item(new Item.Properties().food(ADFoods.PIKE_SLICE)));
	public static final RegistryObject<Item> COOKED_PIKE_SLICE = HELPER.createItem("cooked_pike_slice", () -> new Item(new Item.Properties().food(ADFoods.COOKED_PIKE_SLICE)));
	public static final RegistryObject<Item> PERCH_SLICE = HELPER.createItem("perch_slice", () -> new Item(new Item.Properties().food(ADFoods.PERCH_SLICE)));
	public static final RegistryObject<Item> COOKED_PERCH_SLICE = HELPER.createItem("cooked_perch_slice", () -> new Item(new Item.Properties().food(ADFoods.COOKED_PERCH_SLICE)));

	public static final RegistryObject<Item> CHERRY_COOKIE = HELPER.createItem("cherry_cookie", () -> new ConsumableItem(new Item.Properties().food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> MULBERRY_COOKIE = HELPER.createItem("mulberry_cookie", () -> new ConsumableItem(new Item.Properties().food(FoodValues.COOKIES)));
	public static final RegistryObject<Item> MAPLE_COOKIE = HELPER.createItem("maple_cookie", () -> new ConsumableItem(new Item.Properties().food(FoodValues.COOKIES)));

	public static final RegistryObject<Item> SEARED_VENISON = HELPER.createItem("seared_venison", () -> new ConsumableItem(new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.SEARED_VENISON).stacksTo(16)));
	public static final RegistryObject<Item> PASSIONFRUIT_GLAZED_DUCK = HELPER.createItem("passionfruit_glazed_duck", () -> new ConsumableItem(new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.PASSIONFRUIT_GLAZED_DUCK).stacksTo(16)));
	public static final RegistryObject<Item> DUNE_PLATTER = HELPER.createItem("dune_platter", () -> new ConsumableItem(new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.DUNE_PLATTER).stacksTo(16)));
	public static final RegistryObject<Item> DUCK_NOODLES = HELPER.createItem("duck_noodles", () -> new ConsumableItem(new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.DUCK_NOODLES).stacksTo(16)));
	public static final RegistryObject<Item> PERCH_WITH_MUSHROOMS = HELPER.createItem("perch_with_mushrooms", () -> new ConsumableItem(new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.PERCH_WITH_MUSHROOMS).stacksTo(16)));
	public static final RegistryObject<Item> PIKE_WITH_BEETROOT = HELPER.createItem("pike_with_beetroot", () -> new ConsumableItem(new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.PIKE_WITH_BEETROOT).stacksTo(16)));
	public static final RegistryObject<Item> VENISON_WITH_BAMBOO_SHOOTS = HELPER.createItem("venison_with_bamboo_shoots", () -> new ConsumableItem(new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.VENISON_WITH_BAMBOO_SHOOTS).stacksTo(16)));

	public static final RegistryObject<Item> MAPLE_GLAZED_BACON = HELPER.createItem("maple_glazed_bacon", () -> new Item(new Item.Properties().food(ADFoods.MAPLE_GLAZED_BACON)));
	public static final RegistryObject<Item> ESCARGOT = HELPER.createItem("escargot", () -> new ContainerConsumableItem(ADConstants.SNAIL_SHELL_PIECE, new Item.Properties().food(ADFoods.ESCARGOT).stacksTo(16)));
	public static final RegistryObject<Item> SLABDISH = HELPER.createItem("slabdish", () -> new SlabdishItem(new Item.Properties().craftRemainder(Items.BOWL).food(ADFoods.SLABDISH).stacksTo(16)));

	public static final RegistryObject<Item> CHERRY_CREAM_SODA = HELPER.createItem("cherry_cream_soda", () -> new EffectDrinkItem(MobEffects.SLOW_FALLING, new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> PASSION_ALOE_NECTAR = HELPER.createItem("passion_aloe_nectar", () -> new NectarItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
	public static final RegistryObject<Item> PICKERELWEED_JUICE = HELPER.createItem("pickerelweed_juice", () -> new EffectDrinkItem(MobEffects.WATER_BREATHING, new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));

	public static final RegistryObject<Item> VANILLA_CAKE_SLICE = HELPER.createItem("vanilla_cake_slice", () -> new CakeSliceItem(ADConstants.VANILLA_SCENT, 100, new Item.Properties().food(ADFoods.CAKE_SLICE)));
	public static final RegistryObject<Item> CHOCOLATE_CAKE_SLICE = HELPER.createItem("chocolate_cake_slice", () -> new CakeSliceItem(ADConstants.SUGAR_RUSH, 200, new Item.Properties().food(ADFoods.CAKE_SLICE)));
	public static final RegistryObject<Item> STRAWBERRY_CAKE_SLICE = HELPER.createItem("strawberry_cake_slice", () -> new CakeSliceItem(new Item.Properties().food(ADFoods.CAKE_SLICE)));
	public static final RegistryObject<Item> BANANA_CAKE_SLICE = HELPER.createItem("banana_cake_slice", () -> new CakeSliceItem(ADConstants.AGILITY, 200, new Item.Properties().food(ADFoods.CAKE_SLICE)));
	public static final RegistryObject<Item> MINT_CAKE_SLICE = HELPER.createItem("mint_cake_slice", () -> new CakeSliceItem(ADConstants.BERSERKING, 300, new Item.Properties().food(ADFoods.CAKE_SLICE)));
	public static final RegistryObject<Item> ADZUKI_CAKE_SLICE = HELPER.createItem("adzuki_cake_slice", () -> new CakeSliceItem(ADConstants.HARMONY, 200, new Item.Properties().food(ADFoods.CAKE_SLICE)));
	public static final RegistryObject<Item> YUCCA_GATEAU_SLICE = HELPER.createItem("yucca_gateau_slice", () -> new CakeSliceItem(ADConstants.PERSISTENCE, 320, new Item.Properties().food(ADFoods.YUCCA_GATEAU_SLICE)));

	public static class ADFoods {
		public static final FoodProperties DUCK_FILLET = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().fast().build();
		public static final FoodProperties COOKED_DUCK_FILLET = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).meat().fast().build();
		public static final FoodProperties VENISON_SHANKS = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).meat().fast().build();
		public static final FoodProperties COOKED_VENISON_SHANKS = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.8F).meat().fast().build();
		public static final FoodProperties PIKE_SLICE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).fast().build();
		public static final FoodProperties COOKED_PIKE_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.8F).fast().build();
		public static final FoodProperties PERCH_SLICE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).fast().build();
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

	public static void setupTabEditors() {
		CreativeModeTabContentsPopulator.mod(AbnormalsDelight.MOD_ID)
				.predicate(event -> modPredicate(event, FOOD_AND_DRINKS))
				.addItemsAfter(of(Items.CAKE), ModItems.CAKE_SLICE)
				.predicate(event -> modPredicate(event, COMBAT))
				.addItemsBefore(of(Items.FLINT_AND_STEEL), ModItems.FLINT_KNIFE)
				.addItemsAfter(of(Items.IRON_HOE), ModItems.IRON_KNIFE)
				.addItemsAfter(of(Items.GOLDEN_HOE), ModItems.GOLDEN_KNIFE)
				.addItemsAfter(of(Items.DIAMOND_HOE), ModItems.DIAMOND_KNIFE)
				.addItemsAfter(of(Items.NETHERITE_HOE), ModItems.NETHERITE_KNIFE)
				.predicate(event -> modPredicate(event, FUNCTIONAL_BLOCKS))
				.addItemsAfter(of(Items.BARREL), ModBlocks.OAK_CABINET, ModBlocks.SPRUCE_CABINET, ModBlocks.BIRCH_CABINET, ModBlocks.JUNGLE_CABINET, ModBlocks.ACACIA_CABINET, ModBlocks.DARK_OAK_CABINET, ModBlocks.MANGROVE_CABINET, ModBlocks.CHERRY_CABINET, ModBlocks.BAMBOO_CABINET)

				.predicate(event -> modPredicate(event, FOOD_AND_DRINKS, ADConstants.FARMERS_DELIGHT))
				.addItemsAfter(of(Items.CAKE), VANILLA_CAKE_SLICE, CHOCOLATE_CAKE_SLICE, STRAWBERRY_CAKE_SLICE, BANANA_CAKE_SLICE, MINT_CAKE_SLICE, ADZUKI_CAKE_SLICE)

				.predicate(event -> modPredicate(event, FUNCTIONAL_BLOCKS, ADConstants.FARMERS_DELIGHT))
				.addItemsAfter(of(Items.BARREL), ADBlocks.ROSEWOOD_CABINET, ADBlocks.MORADO_CABINET, ADBlocks.YUCCA_CABINET, ADBlocks.KOUSA_CABINET, ADBlocks.ASPEN_CABINET, ADBlocks.LAUREL_CABINET, ADBlocks.GRIMWOOD_CABINET)

				.predicate(event -> modPredicate(event, FUNCTIONAL_BLOCKS, ADConstants.FARMERS_DELIGHT))
				.addItemsAfter(of(Items.BARREL), ADBlocks.MAPLE_CABINET)

				.predicate(event -> modPredicate(event, FUNCTIONAL_BLOCKS, ADConstants.FARMERS_DELIGHT))
				.addItemsAfter(of(Items.BARREL), ADBlocks.AZALEA_CABINET)

				.predicate(event -> modPredicate(event, FUNCTIONAL_BLOCKS, ADConstants.FARMERS_DELIGHT))
				.addItemsAfter(of(Items.BARREL), ADBlocks.WILLOW_CABINET, ADBlocks.PINE_CABINET, ADBlocks.CHERRY_CABINET, ADBlocks.WISTERIA_CABINET)

				.predicate(event -> modPredicate(event, FUNCTIONAL_BLOCKS, ADConstants.FARMERS_DELIGHT))
				.addItemsAfter(of(Items.BARREL), ADBlocks.DRIFTWOOD_CABINET, ADBlocks.RIVER_CABINET)

				.predicate(event -> modPredicate(event, FUNCTIONAL_BLOCKS, ADConstants.FARMERS_DELIGHT))
				.addItemsAfter(of(Items.BARREL), ModBlocks.CRIMSON_CABINET, ModBlocks.WARPED_CABINET)

				.predicate(event -> modPredicate(event, FUNCTIONAL_BLOCKS, ADConstants.FARMERS_DELIGHT))
				.addItemsAfter(of(Items.BARREL), ADBlocks.POISE_CABINET)
		;
	}

	public static boolean fdGroupPredicate(BuildCreativeModeTabContentsEvent event, String... modids) {
		return !ADConfig.COMMON.replaceFDItemGroup.get() && ItemSubRegistryHelper.areModsLoaded(modids) && event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey();
	}

	public static boolean modPredicate(BuildCreativeModeTabContentsEvent event, ResourceKey<CreativeModeTab> tab, String... modids) {
		return ADConfig.COMMON.replaceFDItemGroup.get() && ItemSubRegistryHelper.areModsLoaded(modids) && event.getTabKey() == tab;
	}
}