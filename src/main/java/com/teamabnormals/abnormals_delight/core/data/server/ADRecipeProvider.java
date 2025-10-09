package com.teamabnormals.abnormals_delight.core.data.server;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConditions;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import com.teamabnormals.atmospheric.core.registry.AtmosphericBlocks;
import com.teamabnormals.atmospheric.core.registry.AtmosphericItems;
import com.teamabnormals.autumnity.core.registry.AutumnityBlocks;
import com.teamabnormals.autumnity.core.registry.AutumnityItems;
import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import com.teamabnormals.buzzier_bees.core.registry.BBBlocks;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;
import com.teamabnormals.upgrade_aquatic.core.registry.UAItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.conditions.ICondition;
import vectorwing.farmersdelight.common.crafting.ingredient.ItemAbilityIngredient;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.concurrent.CompletableFuture;

public class ADRecipeProvider extends BlueprintRecipeProvider implements ADConditions {

	public ADRecipeProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(AbnormalsDelight.MOD_ID, output, provider);
	}

	@Override
	public void buildRecipes(RecipeOutput output) {
		this.buildAtmosphericRecipes(output, ATMOSPHERIC_LOADED);
		this.buildAutumnityRecipes(output, AUTUMNITY_LOADED);
		this.buildBuzzierBeesRecipes(output, BUZZIER_BEES_LOADED);
		this.buildEnvironmentalRecipes(output, ENVIRONMENTAL_LOADED);
		this.buildNeapolitanRecipes(output, NEAPOLITAN_LOADED);
		this.buildUpgradeAquaticRecipes(output, UPGRADE_AQUATIC_LOADED);
	}

	public void buildAtmosphericRecipes(RecipeOutput output, ICondition... conditions) {
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
		cuttingRecipe(output, AutumnityBlocks.AUTUMN_CROCUS, Items.MAGENTA_DYE, 2, conditions);

		cuttingRecipe(output, AutumnityBlocks.TURKEY, AutumnityItems.TURKEY_PIECE, 5, conditions);
		cuttingRecipe(output, AutumnityBlocks.COOKED_TURKEY, AutumnityItems.COOKED_TURKEY_PIECE, 5, conditions);
		cuttingRecipe(output, AutumnityBlocks.LARGE_PUMPKIN_SLICE, ModItems.PUMPKIN_SLICE.get(), 4, conditions);

		cabinetRecipe(output, ADBlocks.MAPLE_CABINET, AutumnityBlocks.MAPLE_SLAB, AutumnityBlocks.MAPLE_TRAPDOOR, conditions);
		salvagePlankFromFurniture(output, AutumnityBlocks.MAPLE_PLANKS, AutumnityBlocks.MAPLE_DOOR, AutumnityBlocks.MAPLE_TRAPDOOR, AutumnityBlocks.MAPLE_SIGNS.getFirst(), AutumnityBlocks.MAPLE_HANGING_SIGNS.getFirst(), conditions);
		stripLogForBarkWithChance(output, AutumnityBlocks.MAPLE_LOG, AutumnityBlocks.STRIPPED_MAPLE_LOG, AutumnityBlocks.SAPPY_MAPLE_LOG, conditions);
		stripLogForBarkWithChance(output, AutumnityBlocks.MAPLE_WOOD, AutumnityBlocks.STRIPPED_MAPLE_WOOD, AutumnityBlocks.SAPPY_MAPLE_WOOD, conditions);
	}

	public void buildBuzzierBeesRecipes(RecipeOutput output, ICondition... conditions) {
		cuttingRecipe(output, BBBlocks.BUTTERCUP, Items.YELLOW_DYE, 2, conditions);
		cuttingRecipe(output, BBBlocks.PINK_CLOVER, Items.PINK_DYE, 2, conditions);
		cuttingRecipe(output, BBBlocks.WHITE_CLOVER, Items.WHITE_DYE, 2, conditions);
	}

	public void buildEnvironmentalRecipes(RecipeOutput output, ICondition... conditions) {
		conditionalFoodCookingRecipes(output, ADItems.DUCK_FILLET, ADItems.COOKED_DUCK_FILLET, conditions);
		conditionalFoodCookingRecipes(output, ADItems.VENISON_SHANKS, ADItems.COOKED_VENISON_SHANKS, conditions);
	}

	public void buildNeapolitanRecipes(RecipeOutput output, ICondition... conditions) {
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
		cuttingRecipe(output, UABlocks.PICKERELWEED, Items.CYAN_DYE, 2, conditions);
		cuttingRecipe(output, UABlocks.PINK_SEAROCKET, Items.PINK_DYE, 2, conditions);
		cuttingRecipe(output, UABlocks.WHITE_SEAROCKET, Items.WHITE_DYE, 2, conditions);

		cuttingFish(output, UAItems.PIKE, ADItems.PIKE_SLICE, 2, conditions);
		cuttingFish(output, UAItems.COOKED_PIKE, ADItems.COOKED_PIKE_SLICE, 2, conditions);
		cuttingFish(output, UAItems.PERCH, ADItems.PERCH_SLICE, 2, conditions);
		cuttingFish(output, UAItems.COOKED_PERCH, ADItems.COOKED_PERCH_SLICE, 2, conditions);

		conditionalFoodCookingRecipes(output, ADItems.PERCH_SLICE, ADItems.COOKED_PERCH_SLICE, conditions);
		conditionalFoodCookingRecipes(output, ADItems.PIKE_SLICE, ADItems.COOKED_PIKE_SLICE, conditions);

		cabinetRecipe(output, ADBlocks.DRIFTWOOD_CABINET, UABlocks.DRIFTWOOD_SLAB, UABlocks.DRIFTWOOD_TRAPDOOR, conditions);
		cabinetRecipe(output, ADBlocks.RIVER_CABINET, UABlocks.RIVER_SLAB, UABlocks.RIVER_TRAPDOOR, conditions);

		salvagePlankFromFurniture(output, UABlocks.DRIFTWOOD_PLANKS, UABlocks.DRIFTWOOD_DOOR, UABlocks.DRIFTWOOD_TRAPDOOR, UABlocks.DRIFTWOOD_SIGNS.getFirst(), UABlocks.DRIFTWOOD_HANGING_SIGNS.getFirst(), conditions);
		salvagePlankFromFurniture(output, UABlocks.RIVER_PLANKS, UABlocks.RIVER_DOOR, UABlocks.RIVER_TRAPDOOR, UABlocks.RIVER_SIGNS.getFirst(), UABlocks.RIVER_HANGING_SIGNS.getFirst(), conditions);

		stripLogForBark(output, UABlocks.DRIFTWOOD_LOG, UABlocks.STRIPPED_DRIFTWOOD_LOG, conditions);
		stripLogForBark(output, UABlocks.DRIFTWOOD, UABlocks.STRIPPED_DRIFTWOOD, conditions);
		stripLogForBark(output, UABlocks.RIVER_LOG, UABlocks.STRIPPED_RIVER_LOG, conditions);
		stripLogForBark(output, UABlocks.RIVER_WOOD, UABlocks.STRIPPED_RIVER_WOOD, conditions);
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
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(input), Ingredient.of(CommonTags.TOOLS_KNIFE), cut, count).save(output.withConditions(conditions));
	}

	private static void cuttingFish(RecipeOutput output, ItemLike input, ItemLike cut, int count, ICondition... conditions) {
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(input), Ingredient.of(CommonTags.TOOLS_KNIFE), cut, count).addResult(Items.BONE_MEAL).save(output.withConditions(conditions));
	}

	private static void stripLogForBark(RecipeOutput output, ItemLike log, ItemLike strippedLog, ICondition... conditions) {
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(log), new ItemAbilityIngredient(ItemAbilities.AXE_STRIP).toVanilla(), strippedLog).addResult(ModItems.TREE_BARK.get()).addSound(SoundEvents.AXE_STRIP).build(output.withConditions(conditions));
	}

	private static void stripLogForBarkWithChance(RecipeOutput output, ItemLike log, ItemLike strippedLog, ItemLike chance, ICondition... conditions) {
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(log), new ItemAbilityIngredient(ItemAbilities.AXE_STRIP).toVanilla(), strippedLog).addResult(ModItems.TREE_BARK.get()).addSound(SoundEvents.AXE_STRIP)
				.addResultWithChance(chance, 0.25F)
				.build(output.withConditions(conditions));
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
}