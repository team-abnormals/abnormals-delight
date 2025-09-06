package com.teamabnormals.abnormals_delight.core.data.server;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConditions;
import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.ICondition;

import java.util.concurrent.CompletableFuture;

public class ADRecipeProvider extends BlueprintRecipeProvider implements ADConditions {

	public ADRecipeProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(AbnormalsDelight.MOD_ID, output, provider);
	}

	@Override
	public void buildRecipes(RecipeOutput output) {
		conditionalFoodCookingRecipes(output, ADItems.PERCH_SLICE, ADItems.COOKED_PERCH_SLICE, UPGRADE_AQUATIC_LOADED);
		conditionalFoodCookingRecipes(output, ADItems.PIKE_SLICE, ADItems.COOKED_PIKE_SLICE, UPGRADE_AQUATIC_LOADED);

		conditionalFoodCookingRecipes(output, ADItems.DUCK_FILLET, ADItems.COOKED_DUCK_FILLET, ENVIRONMENTAL_LOADED);
		conditionalFoodCookingRecipes(output, ADItems.VENISON_SHANKS, ADItems.COOKED_VENISON_SHANKS, ENVIRONMENTAL_LOADED);
	}

	public static void conditionalFoodCookingRecipes(RecipeOutput recipeOutput, ItemLike input, ItemLike output, ICondition... conditions) {
		conditionalFoodCookingRecipes(recipeOutput, input, output, 0.35F, 200, conditions);
	}

	public static void conditionalFoodCookingRecipes(RecipeOutput recipeOutput, ItemLike input, ItemLike output, float xp, int baseCookTime, ICondition... conditions) {
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.FOOD, output, xp, baseCookTime).unlockedBy(getHasName(input), has(input)).save(recipeOutput.withConditions(conditions));
		SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.FOOD, output, xp, baseCookTime / 2).unlockedBy(getHasName(input), has(input)).save(recipeOutput.withConditions(conditions), RecipeBuilder.getDefaultRecipeId(output) + "_from_smoking");
		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.FOOD, output, xp, baseCookTime * 3).unlockedBy(getHasName(input), has(input)).save(recipeOutput.withConditions(conditions), RecipeBuilder.getDefaultRecipeId(output) + "_from_campfire_cooking");
	}
}