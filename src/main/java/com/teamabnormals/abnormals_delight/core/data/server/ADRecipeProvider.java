package com.teamabnormals.abnormals_delight.core.data.server;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConditions;
import com.teamabnormals.abnormals_delight.core.other.tags.ADItemTags;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import com.teamabnormals.atmospheric.core.other.tags.AtmosphericItemTags;
import com.teamabnormals.atmospheric.core.registry.AtmosphericBlocks;
import com.teamabnormals.atmospheric.core.registry.AtmosphericItems;
import com.teamabnormals.autumnity.core.registry.AutumnityBlocks;
import com.teamabnormals.autumnity.core.registry.AutumnityItems;
import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import com.teamabnormals.buzzier_bees.core.registry.BBBlocks;
import com.teamabnormals.caverns_and_chasms.core.other.tags.CCItemTags;
import com.teamabnormals.caverns_and_chasms.core.registry.CCBlocks;
import com.teamabnormals.environmental.core.other.tags.EnvironmentalItemTags;
import com.teamabnormals.environmental.core.registry.EnvironmentalBlocks;
import com.teamabnormals.environmental.core.registry.EnvironmentalItems;
import com.teamabnormals.incubation.core.registry.IncubationItems;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanItemTags;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import com.teamabnormals.upgrade_aquatic.core.other.tags.UAItemTags;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;
import com.teamabnormals.upgrade_aquatic.core.registry.UAItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ICondition;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.crafting.ingredient.ItemAbilityIngredient;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;

import java.util.concurrent.CompletableFuture;

public class ADRecipeProvider extends BlueprintRecipeProvider implements ADConditions {

	public ADRecipeProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(AbnormalsDelight.MOD_ID, output, provider);
	}

	@Override
	public void buildRecipes(RecipeOutput output) {
		this.buildMixedRecipes(output);
		this.buildAtmosphericRecipes(output, ATMOSPHERIC_LOADED);
		this.buildAutumnityRecipes(output, AUTUMNITY_LOADED);
		this.buildBuzzierBeesRecipes(output, BUZZIER_BEES_LOADED);
		this.buildCavernsAndChasmsRecipes(output, CAVERNS_AND_CHASMS_LOADED);
		this.buildEnvironmentalRecipes(output, ENVIRONMENTAL_LOADED);
		this.buildIncubationRecipes(output, INCUBATION_LOADED);
		this.buildNeapolitanRecipes(output, NEAPOLITAN_LOADED);
		this.buildUpgradeAquaticRecipes(output, UPGRADE_AQUATIC_LOADED);
	}

	public void buildAtmosphericRecipes(RecipeOutput output, ICondition... conditions) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ADItems.DUNE_PLATTER)
				.requires(Items.COOKED_RABBIT).requires(AtmosphericItems.ALOE_LEAVES).requires(Items.BOWL).requires(AtmosphericItems.ROASTED_YUCCA_FRUIT).requires(AtmosphericItems.YELLOW_BLOSSOMS).requires(AtmosphericItems.BARREL_CACTUS)
				.unlockedBy(getHasName(AtmosphericItems.ALOE_LEAVES), has(AtmosphericItems.ALOE_LEAVES)).unlockedBy(getHasName(AtmosphericItems.ROASTED_YUCCA_FRUIT), has(AtmosphericItems.ROASTED_YUCCA_FRUIT)).unlockedBy(getHasName(AtmosphericItems.BARREL_CACTUS), has(AtmosphericItems.BARREL_CACTUS))
				.save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(ADItems.PASSION_ALOE_NECTAR, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(Items.HONEY_BOTTLE).addIngredient(AtmosphericItems.ALOE_LEAVES).addIngredient(AtmosphericItemTags.FOODS_PASSION_FRUIT).addIngredient(AtmosphericItemTags.FOODS_PASSION_FRUIT)
				.unlockedBy("has_passion_fruit", has(AtmosphericItemTags.FOODS_PASSION_FRUIT)).unlockedByAnyIngredient(AtmosphericItems.ALOE_LEAVES)
				.setRecipeBookTab(CookingPotRecipeBookTab.DRINKS).save(output.withConditions(conditions));

		cuttingRecipe(output, AtmosphericBlocks.FIRETHORN, Items.RED_DYE, 2, conditions);
		cuttingRecipe(output, AtmosphericBlocks.FORSYTHIA, Items.YELLOW_DYE, 2, conditions);
		cuttingRecipe(output, AtmosphericBlocks.GILIA, Items.PURPLE_DYE, 2, conditions);
		cuttingRecipe(output, AtmosphericBlocks.HOT_MONKEY_BRUSH, Items.ORANGE_DYE, 2, conditions);
		cuttingRecipe(output, AtmosphericBlocks.SCALDING_MONKEY_BRUSH, Items.RED_DYE, 2, conditions);
		cuttingRecipe(output, AtmosphericBlocks.WARM_MONKEY_BRUSH, Items.YELLOW_DYE, 2, conditions);
		cuttingRecipe(output, AtmosphericBlocks.WATER_HYACINTH, Items.PURPLE_DYE, 2, conditions);
		cuttingRecipe(output, AtmosphericBlocks.YUCCA_FLOWER, Items.LIGHT_GRAY_DYE, 2, conditions);

		cuttingRecipe(output, AtmosphericItems.YUCCA_GATEAU, ADItems.YUCCA_GATEAU_SLICE, 10, conditions);

		cabinetRecipe(output, ADBlocks.ROSEWOOD_CABINET, AtmosphericBlocks.ROSEWOOD_SLAB, AtmosphericBlocks.ROSEWOOD_TRAPDOOR, conditions);
		cabinetRecipe(output, ADBlocks.MORADO_CABINET, AtmosphericBlocks.MORADO_SLAB, AtmosphericBlocks.MORADO_TRAPDOOR, conditions);
		cabinetRecipe(output, ADBlocks.YUCCA_CABINET, AtmosphericBlocks.YUCCA_SLAB, AtmosphericBlocks.YUCCA_TRAPDOOR, conditions);
		cabinetRecipe(output, ADBlocks.KOUSA_CABINET, AtmosphericBlocks.KOUSA_SLAB, AtmosphericBlocks.KOUSA_TRAPDOOR, conditions);
		cabinetRecipe(output, ADBlocks.ASPEN_CABINET, AtmosphericBlocks.ASPEN_SLAB, AtmosphericBlocks.ASPEN_TRAPDOOR, conditions);
		cabinetRecipe(output, ADBlocks.LAUREL_CABINET, AtmosphericBlocks.LAUREL_SLAB, AtmosphericBlocks.LAUREL_TRAPDOOR, conditions);
		cabinetRecipe(output, ADBlocks.GRIMWOOD_CABINET, AtmosphericBlocks.GRIMWOOD_SLAB, AtmosphericBlocks.GRIMWOOD_TRAPDOOR, conditions);

		salvagePlankFromFurniture(output, AtmosphericBlocks.ROSEWOOD_PLANKS, AtmosphericBlocks.ROSEWOOD_DOOR, AtmosphericBlocks.ROSEWOOD_TRAPDOOR, AtmosphericBlocks.ROSEWOOD_SIGNS.getFirst(), AtmosphericBlocks.ROSEWOOD_HANGING_SIGNS.getFirst(), conditions);
		salvagePlankFromFurniture(output, AtmosphericBlocks.MORADO_PLANKS, AtmosphericBlocks.MORADO_DOOR, AtmosphericBlocks.MORADO_TRAPDOOR, AtmosphericBlocks.MORADO_SIGNS.getFirst(), AtmosphericBlocks.MORADO_HANGING_SIGNS.getFirst(), conditions);
		salvagePlankFromFurniture(output, AtmosphericBlocks.YUCCA_PLANKS, AtmosphericBlocks.YUCCA_DOOR, AtmosphericBlocks.YUCCA_TRAPDOOR, AtmosphericBlocks.YUCCA_SIGNS.getFirst(), AtmosphericBlocks.YUCCA_HANGING_SIGNS.getFirst(), conditions);
		salvagePlankFromFurniture(output, AtmosphericBlocks.KOUSA_PLANKS, AtmosphericBlocks.KOUSA_DOOR, AtmosphericBlocks.KOUSA_TRAPDOOR, AtmosphericBlocks.KOUSA_SIGNS.getFirst(), AtmosphericBlocks.KOUSA_HANGING_SIGNS.getFirst(), conditions);
		salvagePlankFromFurniture(output, AtmosphericBlocks.ASPEN_PLANKS, AtmosphericBlocks.ASPEN_DOOR, AtmosphericBlocks.ASPEN_TRAPDOOR, AtmosphericBlocks.ASPEN_SIGNS.getFirst(), AtmosphericBlocks.ASPEN_HANGING_SIGNS.getFirst(), conditions);
		salvagePlankFromFurniture(output, AtmosphericBlocks.LAUREL_PLANKS, AtmosphericBlocks.LAUREL_DOOR, AtmosphericBlocks.LAUREL_TRAPDOOR, AtmosphericBlocks.LAUREL_SIGNS.getFirst(), AtmosphericBlocks.LAUREL_HANGING_SIGNS.getFirst(), conditions);
		salvagePlankFromFurniture(output, AtmosphericBlocks.GRIMWOOD_PLANKS, AtmosphericBlocks.GRIMWOOD_DOOR, AtmosphericBlocks.GRIMWOOD_TRAPDOOR, AtmosphericBlocks.GRIMWOOD_SIGNS.getFirst(), AtmosphericBlocks.GRIMWOOD_HANGING_SIGNS.getFirst(), conditions);

		stripLogForBark(output, AtmosphericBlocks.ROSEWOOD_LOG, AtmosphericBlocks.STRIPPED_ROSEWOOD_LOG, conditions);
		stripLogForBark(output, AtmosphericBlocks.ROSEWOOD, AtmosphericBlocks.STRIPPED_ROSEWOOD, conditions);
		stripLogForBark(output, AtmosphericBlocks.MORADO_LOG, AtmosphericBlocks.STRIPPED_MORADO_LOG, conditions);
		stripLogForBark(output, AtmosphericBlocks.MORADO_WOOD, AtmosphericBlocks.STRIPPED_MORADO_WOOD, conditions);
		stripLogForBark(output, AtmosphericBlocks.YUCCA_LOG, AtmosphericBlocks.STRIPPED_YUCCA_LOG, conditions);
		stripLogForBark(output, AtmosphericBlocks.YUCCA_WOOD, AtmosphericBlocks.STRIPPED_YUCCA_WOOD, conditions);
		stripLogForBark(output, AtmosphericBlocks.KOUSA_LOG, AtmosphericBlocks.STRIPPED_KOUSA_LOG, conditions);
		stripLogForBark(output, AtmosphericBlocks.KOUSA_WOOD, AtmosphericBlocks.STRIPPED_KOUSA_WOOD, conditions);
		stripLogForBark(output, AtmosphericBlocks.ASPEN_LOG, AtmosphericBlocks.STRIPPED_ASPEN_LOG, conditions);
		stripLogForBark(output, AtmosphericBlocks.ASPEN_WOOD, AtmosphericBlocks.STRIPPED_ASPEN_WOOD, conditions);
		stripLogForBark(output, AtmosphericBlocks.WATCHFUL_ASPEN_LOG, AtmosphericBlocks.STRIPPED_ASPEN_LOG, conditions);
		stripLogForBark(output, AtmosphericBlocks.WATCHFUL_ASPEN_WOOD, AtmosphericBlocks.STRIPPED_ASPEN_WOOD, conditions);
		stripLogForBark(output, AtmosphericBlocks.LAUREL_LOG, AtmosphericBlocks.STRIPPED_LAUREL_LOG, conditions);
		stripLogForBark(output, AtmosphericBlocks.LAUREL_WOOD, AtmosphericBlocks.STRIPPED_LAUREL_WOOD, conditions);
		stripLogForBark(output, AtmosphericBlocks.GRIMWOOD_LOG, AtmosphericBlocks.STRIPPED_GRIMWOOD_LOG, conditions);
		stripLogForBark(output, AtmosphericBlocks.GRIMWOOD, AtmosphericBlocks.STRIPPED_GRIMWOOD, conditions);
	}

	public void buildAutumnityRecipes(RecipeOutput output, ICondition... conditions) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, AutumnityItems.PUMPKIN_BREAD, 2)
				.requires(AutumnityItems.SYRUP_BOTTLE).requires(ModItems.PUMPKIN_SLICE.get())
				.requires(Items.WHEAT, 2).unlockedBy(getHasName(AutumnityItems.SYRUP_BOTTLE), has(AutumnityItems.SYRUP_BOTTLE))
				.save(output.withConditions(AUTUMNITY_LOADED), wrapRecipeID(AutumnityItems.PUMPKIN_BREAD));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ADItems.MAPLE_GLAZED_BACON)
				.requires(ModItems.COOKED_BACON.get()).requires(AutumnityItems.SYRUP_BOTTLE)
				.unlockedBy(getHasName(ModItems.COOKED_BACON.get()), has(ModItems.COOKED_BACON.get()))
				.unlockedBy(getHasName(AutumnityItems.SYRUP_BOTTLE), has(AutumnityItems.SYRUP_BOTTLE))
				.save(output.withConditions(conditions));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ADItems.MAPLE_COOKIE, 8)
				.requires(AutumnityItems.SYRUP_BOTTLE).requires(Items.WHEAT).requires(Items.WHEAT)
				.unlockedBy(getHasName(AutumnityItems.SYRUP_BOTTLE), has(AutumnityItems.SYRUP_BOTTLE)).save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(ADItems.ESCARGOT, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP, AutumnityItems.SNAIL_SHELL_PIECE)
				.addIngredient(AutumnityBlocks.SNAIL_GOO, 2).addIngredient(CommonTags.Items.CROPS_ONION).addIngredient(Tags.Items.DRINKS_MILK)
				.unlockedByAnyIngredient(AutumnityBlocks.SNAIL_GOO, AutumnityItems.SNAIL_SHELL_PIECE)
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(AutumnityItems.FOUL_SOUP, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(AutumnityItems.FOUL_BERRIES, 2).addIngredient(Items.SPIDER_EYE).addIngredient(CommonTags.Items.CROPS_ONION)
				.unlockedByAnyIngredient(AutumnityItems.FOUL_BERRIES)
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(ModItems.STUFFED_PUMPKIN_BLOCK.get(), 1, CookingRecipes.SLOW_COOKING, CookingRecipes.LARGE_EXP, AutumnityBlocks.LARGE_PUMPKIN_SLICE)
				.addIngredient(CommonTags.Items.CROPS_RICE)
				.addIngredient(CommonTags.Items.CROPS_ONION)
				.addIngredient(Items.BROWN_MUSHROOM)
				.addIngredient(Items.POTATO)
				.addIngredient(Tags.Items.FOODS_BERRY)
				.addIngredient(Tags.Items.FOODS_VEGETABLE)
				.unlockedByItems(getHasName(AutumnityBlocks.LARGE_PUMPKIN_SLICE), AutumnityBlocks.LARGE_PUMPKIN_SLICE)
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
				.save(output.withConditions(conditions));

		cuttingRecipe(output, AutumnityBlocks.AUTUMN_CROCUS, Items.MAGENTA_DYE, 2, conditions);

		cuttingRecipe(output, AutumnityBlocks.TURKEY, AutumnityItems.TURKEY_PIECE, 5, conditions);
		cuttingRecipe(output, AutumnityBlocks.COOKED_TURKEY, AutumnityItems.COOKED_TURKEY_PIECE, 5, conditions);
		cuttingRecipe(output, AutumnityBlocks.LARGE_PUMPKIN_SLICE, ModItems.PUMPKIN_SLICE.get(), 4, conditions);

		cabinetRecipe(output, ADBlocks.MAPLE_CABINET, AutumnityBlocks.MAPLE_SLAB, AutumnityBlocks.MAPLE_TRAPDOOR, conditions);
		salvagePlankFromFurniture(output, AutumnityBlocks.MAPLE_PLANKS, AutumnityBlocks.MAPLE_DOOR, AutumnityBlocks.MAPLE_TRAPDOOR, AutumnityBlocks.MAPLE_SIGNS.getFirst(), AutumnityBlocks.MAPLE_HANGING_SIGNS.getFirst(), conditions);
		stripLogForBark(output, AutumnityBlocks.MAPLE_LOG, AutumnityBlocks.STRIPPED_MAPLE_LOG, conditions);
		stripLogForBark(output, AutumnityBlocks.MAPLE_WOOD, AutumnityBlocks.STRIPPED_MAPLE_WOOD, conditions);
	}

	public void buildBuzzierBeesRecipes(RecipeOutput output, ICondition... conditions) {
		cuttingRecipe(output, BBBlocks.BUTTERCUP, Items.YELLOW_DYE, 2, conditions);
		cuttingRecipe(output, BBBlocks.PINK_CLOVER, Items.PINK_DYE, 2, conditions);
		cuttingRecipe(output, BBBlocks.WHITE_CLOVER, Items.WHITE_DYE, 2, conditions);
	}

	public void buildCavernsAndChasmsRecipes(RecipeOutput output, ICondition... conditions) {
		ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ADItems.SILVER_KNIFE.get()).pattern("m").pattern("s").define('m', CCItemTags.INGOTS_SILVER).define('s', Items.STICK).unlockedBy("has_silver_ingot", has(CCItemTags.INGOTS_SILVER)).save(output.withConditions(conditions));
		SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(ModItems.DIAMOND_KNIFE.get()), Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.COMBAT, ModItems.NETHERITE_KNIFE.get()).unlocks("has_necromium_ingot", has(CCItemTags.INGOTS_NECROMIUM)).save(output.withConditions(conditions), AbnormalsDelight.MOD_ID + ":necromium_knife_smithing");

		cabinetRecipe(output, ADBlocks.AZALEA_CABINET, CCBlocks.AZALEA_SLAB, CCBlocks.AZALEA_TRAPDOOR, conditions);
		salvagePlankFromFurniture(output, CCBlocks.AZALEA_PLANKS, CCBlocks.AZALEA_DOOR, CCBlocks.AZALEA_TRAPDOOR, CCBlocks.AZALEA_SIGNS.getFirst(), CCBlocks.AZALEA_HANGING_SIGNS.getFirst(), conditions);
		stripLogForBark(output, CCBlocks.AZALEA_LOG, CCBlocks.STRIPPED_AZALEA_LOG, conditions);
		stripLogForBark(output, CCBlocks.AZALEA_WOOD, CCBlocks.STRIPPED_AZALEA_WOOD, conditions);
	}

	public void buildEnvironmentalRecipes(RecipeOutput output, ICondition... conditions) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ADItems.SEARED_VENISON)
				.requires(EnvironmentalItemTags.FOODS_COOKED_VENISON).requires(EnvironmentalItemTags.FOODS_CHERRY).requires(Items.BOWL).requires(EnvironmentalItemTags.FOODS_CHERRY).requires(Items.CARROT)
				.unlockedBy("has_cooked_venison", has(EnvironmentalItemTags.FOODS_COOKED_VENISON)).unlockedBy("has_cherries", has(EnvironmentalItemTags.FOODS_CHERRY))
				.save(output.withConditions(ENVIRONMENTAL_LOADED));

		CookingPotRecipeBuilder.cookingPotRecipe(ADItems.VENISON_WITH_BAMBOO_SHOOTS, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(EnvironmentalItemTags.FOODS_RAW_VENISON).addIngredient(Items.KELP).addIngredient(Items.BAMBOO).addIngredient(Items.BAMBOO).addIngredient(Tags.Items.FOODS_VEGETABLE)
				.unlockedBy("has_raw_venison", has(EnvironmentalItemTags.FOODS_RAW_VENISON)).unlockedByAnyIngredient(Items.KELP, Items.BAMBOO)
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(ADItems.DUCK_NOODLES, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(EnvironmentalItemTags.FOODS_RAW_DUCK).addIngredient(CommonTags.Items.FOODS_PASTA).addIngredient(Items.CARROT).addIngredient(Tags.Items.FOODS_VEGETABLE)
				.unlockedBy("has_raw_duck", has(EnvironmentalItemTags.FOODS_RAW_DUCK)).unlockedByAnyIngredient(ModItems.RAW_PASTA.get())
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(ADItems.SLABDISH, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(Tags.Items.FOODS_RAW_FISH).addIngredient(EnvironmentalBlocks.DIANTHUS).addIngredient(Items.BONE_MEAL).addIngredient(ADItemTags.SLABDISH_INGREDIENTS).addIngredient(ADItemTags.SLABDISH_INGREDIENTS)
				.unlockedBy("has_slabdish_ingredients", has(ADItemTags.SLABDISH_INGREDIENTS)).unlockedByAnyIngredient(Items.BONE_MEAL)
				.setRecipeBookTab(CookingPotRecipeBookTab.MISC).save(output.withConditions(conditions));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ADItems.CHERRY_COOKIE, 8)
				.requires(EnvironmentalItemTags.FOODS_CHERRY).requires(Items.WHEAT).requires(Items.WHEAT)
				.unlockedBy("has_cherries", has(EnvironmentalItemTags.FOODS_CHERRY)).save(output.withConditions(conditions));

		cuttingRecipe(output, EnvironmentalItems.DUCK, ADItems.DUCK_FILLET, 2, conditions);
		cuttingRecipe(output, EnvironmentalItems.COOKED_DUCK, ADItems.COOKED_DUCK_FILLET, 2, conditions);
		conditionalFoodCookingRecipes(output, ADItems.DUCK_FILLET, ADItems.COOKED_DUCK_FILLET, conditions);

		cuttingRecipe(output, EnvironmentalItems.VENISON, ADItems.VENISON_SHANKS, 2, conditions);
		cuttingRecipe(output, EnvironmentalItems.COOKED_VENISON, ADItems.COOKED_VENISON_SHANKS, 2, conditions);
		conditionalFoodCookingRecipes(output, ADItems.VENISON_SHANKS, ADItems.COOKED_VENISON_SHANKS, conditions);

		cuttingRecipe(output, EnvironmentalBlocks.BLUEBELL, Items.BLUE_DYE, 2, conditions);
		cuttingRecipe(output, EnvironmentalBlocks.DIANTHUS, Items.LIME_DYE, 2, conditions);
		cuttingRecipe(output, EnvironmentalBlocks.VIOLET, Items.PURPLE_DYE, 2, conditions);
		cuttingRecipe(output, EnvironmentalBlocks.TASSELFLOWER, Items.ORANGE_DYE, 2, conditions);
		cuttingRecipe(output, EnvironmentalBlocks.RED_LOTUS_FLOWER, Items.RED_DYE, 2, conditions);
		cuttingRecipe(output, EnvironmentalBlocks.WHITE_LOTUS_FLOWER, Items.WHITE_DYE, 2, conditions);
		cuttingRecipe(output, EnvironmentalBlocks.CARTWHEEL, Items.PINK_DYE, 2, conditions);
		cuttingRecipe(output, EnvironmentalBlocks.YELLOW_HIBISCUS, Items.YELLOW_DYE, 2, conditions);
		cuttingRecipe(output, EnvironmentalBlocks.ORANGE_HIBISCUS, Items.ORANGE_DYE, 2, conditions);
		cuttingRecipe(output, EnvironmentalBlocks.RED_HIBISCUS, Items.RED_DYE, 2, conditions);
		cuttingRecipe(output, EnvironmentalBlocks.PINK_HIBISCUS, Items.PINK_DYE, 2, conditions);
		cuttingRecipe(output, EnvironmentalBlocks.MAGENTA_HIBISCUS, Items.MAGENTA_DYE, 2, conditions);
		cuttingRecipe(output, EnvironmentalBlocks.PURPLE_HIBISCUS, Items.PURPLE_DYE, 2, conditions);

		cabinetRecipe(output, ADBlocks.WILLOW_CABINET, EnvironmentalBlocks.WILLOW_SLAB, EnvironmentalBlocks.WILLOW_TRAPDOOR, conditions);
		cabinetRecipe(output, ADBlocks.WISTERIA_CABINET, EnvironmentalBlocks.WISTERIA_SLAB, EnvironmentalBlocks.WISTERIA_TRAPDOOR, conditions);
		cabinetRecipe(output, ADBlocks.PLUM_CABINET, EnvironmentalBlocks.PLUM_SLAB, EnvironmentalBlocks.PLUM_TRAPDOOR, conditions);
		cabinetRecipe(output, ADBlocks.PINE_CABINET, EnvironmentalBlocks.PINE_SLAB, EnvironmentalBlocks.PINE_TRAPDOOR, conditions);

		salvagePlankFromFurniture(output, EnvironmentalBlocks.WILLOW_PLANKS, EnvironmentalBlocks.WILLOW_DOOR, EnvironmentalBlocks.WILLOW_TRAPDOOR, EnvironmentalBlocks.WILLOW_SIGNS.getFirst(), EnvironmentalBlocks.WILLOW_HANGING_SIGNS.getFirst(), conditions);
		salvagePlankFromFurniture(output, EnvironmentalBlocks.WISTERIA_PLANKS, EnvironmentalBlocks.WISTERIA_DOOR, EnvironmentalBlocks.WISTERIA_TRAPDOOR, EnvironmentalBlocks.WISTERIA_SIGNS.getFirst(), EnvironmentalBlocks.WISTERIA_HANGING_SIGNS.getFirst(), conditions);
		salvagePlankFromFurniture(output, EnvironmentalBlocks.PLUM_PLANKS, EnvironmentalBlocks.PLUM_DOOR, EnvironmentalBlocks.PLUM_TRAPDOOR, EnvironmentalBlocks.PLUM_SIGNS.getFirst(), EnvironmentalBlocks.PLUM_HANGING_SIGNS.getFirst(), conditions);
		salvagePlankFromFurniture(output, EnvironmentalBlocks.PINE_PLANKS, EnvironmentalBlocks.PINE_DOOR, EnvironmentalBlocks.PINE_TRAPDOOR, EnvironmentalBlocks.PINE_SIGNS.getFirst(), EnvironmentalBlocks.PINE_HANGING_SIGNS.getFirst(), conditions);

		stripLogForBark(output, EnvironmentalBlocks.WILLOW_LOG, EnvironmentalBlocks.STRIPPED_WILLOW_LOG, conditions);
		stripLogForBark(output, EnvironmentalBlocks.WILLOW_WOOD, EnvironmentalBlocks.STRIPPED_WILLOW_WOOD, conditions);
		stripLogForBark(output, EnvironmentalBlocks.WISTERIA_LOG, EnvironmentalBlocks.STRIPPED_WISTERIA_LOG, conditions);
		stripLogForBark(output, EnvironmentalBlocks.WISTERIA_WOOD, EnvironmentalBlocks.STRIPPED_WISTERIA_WOOD, conditions);
		stripLogForBark(output, EnvironmentalBlocks.PLUM_LOG, EnvironmentalBlocks.STRIPPED_PLUM_LOG, conditions);
		stripLogForBark(output, EnvironmentalBlocks.PLUM_WOOD, EnvironmentalBlocks.STRIPPED_PLUM_WOOD, conditions);
		stripLogForBark(output, EnvironmentalBlocks.PINE_LOG, EnvironmentalBlocks.STRIPPED_PINE_LOG, conditions);
		stripLogForBark(output, EnvironmentalBlocks.PINE_WOOD, EnvironmentalBlocks.STRIPPED_PINE_WOOD, conditions);
	}

	public void buildIncubationRecipes(RecipeOutput output, ICondition... conditions) {
		conditionalFoodCookingRecipes(output, Items.EGG, ModItems.FRIED_EGG.get(), INCUBATION_NOT_LOADED);

		CookingPotRecipeBuilder.cookingPotRecipe(IncubationItems.SCRAMBLED_EGGS, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(Tags.Items.EGGS).addIngredient(Tags.Items.EGGS).addIngredient(Tags.Items.DRINKS_MILK)
				.unlockedBy("has_eggs", has(Tags.Items.EGGS))
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(conditions));
	}

	public void buildNeapolitanRecipes(RecipeOutput output, ICondition... conditions) {
		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.MELON_POPSICLE.get(), 1)
				.pattern(" mm").pattern("imm").pattern("-i ").define('m', Items.MELON_SLICE).define('i', Items.ICE).define('-', Items.STICK)
				.unlockedBy(getHasName(Items.MELON_SLICE), has(Items.MELON_SLICE)).save(output.withConditions(NEAPOLITAN_NOT_LOADED));

		ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.MELON_POPSICLE.get(), 1)
				.pattern(" mm").pattern("imm").pattern("-i ").define('m', Items.MELON_SLICE).define('i', NeapolitanItems.ICE_CUBES).define('-', Items.STICK)
				.unlockedBy(getHasName(Items.MELON_SLICE), has(Items.MELON_SLICE)).save(output.withConditions(NEAPOLITAN_LOADED), wrapRecipeID(ModItems.MELON_POPSICLE.get()));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, NeapolitanItems.ADZUKI_CURRY)
				.requires(NeapolitanItems.ROASTED_ADZUKI_BEANS)
				.requires(NeapolitanItems.DRIED_BANANA)
				.requires(Items.CARROT).requires(ModItems.PUMPKIN_SLICE.get())
				.requires(Items.BOWL)
				.unlockedBy(getHasName(NeapolitanItems.ROASTED_ADZUKI_BEANS.get()), has(NeapolitanItems.ROASTED_ADZUKI_BEANS.get()))
				.save(output.withConditions(conditions), wrapRecipeID(NeapolitanItems.ADZUKI_CURRY));

		CookingPotRecipeBuilder.cookingPotRecipe(NeapolitanItems.ADZUKI_CURRY, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(NeapolitanItems.ADZUKI_BEANS).addIngredient(NeapolitanItemTags.FOODS_BANANA).addIngredient(Tags.Items.CROPS_CARROT).addIngredient(ModItems.PUMPKIN_SLICE.get())
				.unlockedBy(getHasName(NeapolitanItems.ADZUKI_BEANS.get()), has(NeapolitanItems.ADZUKI_BEANS.get()))
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(NeapolitanItems.ADZUKI_STEW, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(NeapolitanItems.ADZUKI_BEANS, 2).addIngredient(Tags.Items.CROPS_BEETROOT).addIngredient(CommonTags.Items.CROPS_TOMATO).addIngredient(Items.BROWN_MUSHROOM)
				.unlockedBy(getHasName(NeapolitanItems.ADZUKI_BEANS.get()), has(NeapolitanItems.ADZUKI_BEANS.get()))
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(conditions));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.MILK_BOTTLE.get(), 4).requires(Items.MILK_BUCKET).requires(Items.GLASS_BOTTLE, 4).unlockedBy("has_milk_bucket", has(Items.MILK_BUCKET)).save(output.withConditions(NEAPOLITAN_NOT_LOADED));
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MILK_BUCKET).requires(Items.BUCKET).requires(ModItems.MILK_BOTTLE.get(), 4).unlockedBy(getHasName(ModItems.MILK_BOTTLE.get()), has(ModItems.MILK_BOTTLE.get())).save(output.withConditions(NEAPOLITAN_NOT_LOADED), ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID, "milk_bucket_from_bottles"));

		cuttingRecipe(output, NeapolitanItems.ADZUKI_CAKE, ADItems.ADZUKI_CAKE_SLICE, 7, conditions);
		cuttingRecipe(output, NeapolitanItems.BANANA_CAKE, ADItems.BANANA_CAKE_SLICE, 7, conditions);
		cuttingRecipe(output, NeapolitanItems.CHOCOLATE_CAKE, ADItems.CHOCOLATE_CAKE_SLICE, 7, conditions);
		cuttingRecipe(output, NeapolitanItems.MINT_CAKE, ADItems.MINT_CAKE_SLICE, 7, conditions);
		cuttingRecipe(output, NeapolitanItems.STRAWBERRY_CAKE, ADItems.STRAWBERRY_CAKE_SLICE, 7, conditions);
		cuttingRecipe(output, NeapolitanItems.VANILLA_CAKE, ADItems.VANILLA_CAKE_SLICE, 7, conditions);

		cakeRecipe(output, NeapolitanItems.ADZUKI_CAKE, ADItems.ADZUKI_CAKE_SLICE, conditions);
		cakeRecipe(output, NeapolitanItems.BANANA_CAKE, ADItems.BANANA_CAKE_SLICE, conditions);
		cakeRecipe(output, NeapolitanItems.CHOCOLATE_CAKE, ADItems.CHOCOLATE_CAKE_SLICE, conditions);
		cakeRecipe(output, NeapolitanItems.MINT_CAKE, ADItems.MINT_CAKE_SLICE, conditions);
		cakeRecipe(output, NeapolitanItems.STRAWBERRY_CAKE, ADItems.STRAWBERRY_CAKE_SLICE, conditions);
		cakeRecipe(output, NeapolitanItems.VANILLA_CAKE, ADItems.VANILLA_CAKE_SLICE, conditions);

	}

	public void buildUpgradeAquaticRecipes(RecipeOutput output, ICondition... conditions) {
		CookingPotRecipeBuilder.cookingPotRecipe(ADItems.PICKERELWEED_JUICE, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(UABlocks.PICKERELWEED).addIngredient(UABlocks.PICKERELWEED).addIngredient(Items.SUGAR)
				.unlockedByAnyIngredient(UABlocks.PICKERELWEED)
				.setRecipeBookTab(CookingPotRecipeBookTab.DRINKS).save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(ADItems.PERCH_WITH_MUSHROOMS, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(UAItemTags.FOODS_RAW_PERCH).addIngredient(ModItems.RED_MUSHROOM_COLONY.get()).addIngredient(CommonTags.Items.CROPS_RICE).addIngredient(CommonTags.Items.CROPS_TOMATO)
				.unlockedByAnyIngredient(UAItems.PERCH, ModItems.RED_MUSHROOM_COLONY.get(), ModItems.RICE.get(), ModItems.TOMATO.get())
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(ADItems.PIKE_WITH_BEETROOT, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(UAItemTags.FOODS_RAW_PIKE).addIngredient(UABlocks.PICKERELWEED).addIngredient(UABlocks.PICKERELWEED).addIngredient(Tags.Items.CROPS_BEETROOT)
				.unlockedByAnyIngredient(UAItems.PERCH, UABlocks.PICKERELWEED, Items.BEETROOT)
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(conditions));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ADItems.MULBERRY_COOKIE, 8)
				.requires(UAItems.MULBERRY).requires(Items.WHEAT).requires(Items.WHEAT)
				.unlockedBy(getHasName(UAItems.MULBERRY), has(UAItems.MULBERRY)).save(output.withConditions(conditions));

		cuttingRecipe(output, UABlocks.PICKERELWEED, Items.CYAN_DYE, 2, conditions);
		cuttingRecipe(output, UABlocks.PINK_SEAROCKET, Items.PINK_DYE, 2, conditions);
		cuttingRecipe(output, UABlocks.WHITE_SEAROCKET, Items.WHITE_DYE, 2, conditions);

		cuttingFish(output, UAItems.PIKE, ADItems.PIKE_SLICE, 2, conditions);
		cuttingFish(output, UAItems.COOKED_PIKE, ADItems.COOKED_PIKE_SLICE, 2, conditions);
		conditionalFoodCookingRecipes(output, ADItems.PIKE_SLICE, ADItems.COOKED_PIKE_SLICE, conditions);

		cuttingFish(output, UAItems.PERCH, ADItems.PERCH_SLICE, 2, conditions);
		cuttingFish(output, UAItems.COOKED_PERCH, ADItems.COOKED_PERCH_SLICE, 2, conditions);
		conditionalFoodCookingRecipes(output, ADItems.PERCH_SLICE, ADItems.COOKED_PERCH_SLICE, conditions);

		cabinetRecipe(output, ADBlocks.DRIFTWOOD_CABINET, UABlocks.DRIFTWOOD_SLAB, UABlocks.DRIFTWOOD_TRAPDOOR, conditions);
		cabinetRecipe(output, ADBlocks.RIVER_CABINET, UABlocks.RIVER_SLAB, UABlocks.RIVER_TRAPDOOR, conditions);

		salvagePlankFromFurniture(output, UABlocks.DRIFTWOOD_PLANKS, UABlocks.DRIFTWOOD_DOOR, UABlocks.DRIFTWOOD_TRAPDOOR, UABlocks.DRIFTWOOD_SIGNS.getFirst(), UABlocks.DRIFTWOOD_HANGING_SIGNS.getFirst(), conditions);
		salvagePlankFromFurniture(output, UABlocks.RIVER_PLANKS, UABlocks.RIVER_DOOR, UABlocks.RIVER_TRAPDOOR, UABlocks.RIVER_SIGNS.getFirst(), UABlocks.RIVER_HANGING_SIGNS.getFirst(), conditions);

		stripLogForBark(output, UABlocks.DRIFTWOOD_LOG, UABlocks.STRIPPED_DRIFTWOOD_LOG, conditions);
		stripLogForBark(output, UABlocks.DRIFTWOOD, UABlocks.STRIPPED_DRIFTWOOD, conditions);
		stripLogForBark(output, UABlocks.RIVER_LOG, UABlocks.STRIPPED_RIVER_LOG, conditions);
		stripLogForBark(output, UABlocks.RIVER_WOOD, UABlocks.STRIPPED_RIVER_WOOD, conditions);
	}

	public void buildMixedRecipes(RecipeOutput output) {
		CookingPotRecipeBuilder.cookingPotRecipe(ADItems.CHERRY_CREAM_SODA, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(Tags.Items.DRINKS_MILK).addIngredient(Items.SUGAR).addIngredient(EnvironmentalItemTags.FOODS_CHERRY).addIngredient(EnvironmentalItemTags.FOODS_CHERRY).addIngredient(NeapolitanItems.DRIED_VANILLA_PODS)
				.unlockedBy("has_cherries", has(EnvironmentalItemTags.FOODS_CHERRY)).unlockedByAnyIngredient(NeapolitanItems.DRIED_VANILLA_PODS)
				.setRecipeBookTab(CookingPotRecipeBookTab.DRINKS).save(output.withConditions(ENVIRONMENTAL_LOADED, NEAPOLITAN_LOADED));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ADItems.PASSION_FRUIT_GLAZED_DUCK)
				.requires(EnvironmentalItemTags.FOODS_COOKED_DUCK).requires(AtmosphericItemTags.FOODS_PASSION_FRUIT).requires(Items.BOWL).requires(Items.BAKED_POTATO).requires(CommonTags.Items.CROPS_ONION)
				.unlockedBy("has_cooked_duck", has(EnvironmentalItemTags.FOODS_COOKED_DUCK)).unlockedBy("has_passion_fruit", has(AtmosphericItemTags.FOODS_PASSION_FRUIT))
				.save(output.withConditions(ATMOSPHERIC_LOADED, ENVIRONMENTAL_LOADED));
	}

	public static void cabinetRecipe(RecipeOutput output, ItemLike block, ItemLike slab, ItemLike trapdoor, ICondition... conditions) {
		ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, block)
				.pattern("___").pattern("D D").pattern("___").define('_', slab).define('D', trapdoor)
				.unlockedBy(getHasName(trapdoor), InventoryChangeTrigger.TriggerInstance.hasItems(trapdoor))
				.group("fd_cabinet").save(output.withConditions(conditions));
	}

	private static void salvagePlankFromFurniture(RecipeOutput output, ItemLike plank, ItemLike door, ItemLike trapdoor, ItemLike sign, ItemLike hangingSign, ICondition... conditions) {
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(door), new ItemAbilityIngredient(ItemAbilities.AXE_DIG).toVanilla(), plank).save(output.withConditions(conditions));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(trapdoor), new ItemAbilityIngredient(ItemAbilities.AXE_DIG).toVanilla(), plank).save(output.withConditions(conditions));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(sign), new ItemAbilityIngredient(ItemAbilities.AXE_DIG).toVanilla(), plank).save(output.withConditions(conditions));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(hangingSign), new ItemAbilityIngredient(ItemAbilities.AXE_DIG).toVanilla(), plank).save(output.withConditions(conditions));
	}

	private static void cuttingRecipe(RecipeOutput output, ItemLike input, ItemLike cut, int count, ICondition... conditions) {
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(input), Ingredient.of(CommonTags.Items.TOOLS_KNIFE), cut, count).save(output.withConditions(conditions));
	}

	private static void cuttingFish(RecipeOutput output, ItemLike input, ItemLike cut, int count, ICondition... conditions) {
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(input), Ingredient.of(CommonTags.Items.TOOLS_KNIFE), cut, count).addResult(Items.BONE_MEAL).save(output.withConditions(conditions));
	}

	private static void stripLogForBark(RecipeOutput output, ItemLike log, ItemLike strippedLog, ICondition... conditions) {
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(log), new ItemAbilityIngredient(ItemAbilities.AXE_STRIP).toVanilla(), strippedLog).addResult(ModItems.TREE_BARK.get()).addSound(SoundEvents.AXE_STRIP).save(output.withConditions(conditions));
	}

	private void cakeRecipe(RecipeOutput output, ItemLike cake, ItemLike slice, ICondition... conditions) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, cake)
				.requires(slice).requires(slice).requires(slice).requires(slice).requires(slice).requires(slice).requires(slice)
				.unlockedBy(getHasName(slice), InventoryChangeTrigger.TriggerInstance.hasItems(slice))
				.group("cake").save(output.withConditions(conditions), this.getModConversionRecipeName(cake, slice));
	}

	public static void conditionalFoodCookingRecipes(RecipeOutput recipeOutput, ItemLike input, ItemLike output, ICondition... conditions) {
		conditionalFoodCookingRecipes(recipeOutput, input, output, 0.35F, 200, conditions);
	}

	public static void conditionalFoodCookingRecipes(RecipeOutput recipeOutput, ItemLike input, ItemLike output, float xp, int baseCookTime, ICondition... conditions) {
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.FOOD, output, xp, baseCookTime).unlockedBy(getHasName(input), has(input)).save(recipeOutput.withConditions(conditions));
		SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.FOOD, output, xp, baseCookTime / 2).unlockedBy(getHasName(input), has(input)).save(recipeOutput.withConditions(conditions), RecipeBuilder.getDefaultRecipeId(output) + "_from_smoking");
		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.FOOD, output, xp, baseCookTime * 3).unlockedBy(getHasName(input), has(input)).save(recipeOutput.withConditions(conditions), RecipeBuilder.getDefaultRecipeId(output) + "_from_campfire_cooking");
	}

	public static ResourceLocation wrapRecipeID(ItemLike itemLike) {
		return AbnormalsDelight.location(RecipeBuilder.getDefaultRecipeId(itemLike).getPath());
	}
}