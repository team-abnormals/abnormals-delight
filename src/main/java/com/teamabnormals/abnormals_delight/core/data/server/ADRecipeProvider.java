package com.teamabnormals.abnormals_delight.core.data.server;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConditions;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.abnormals_delight.core.other.tags.ADItemTags;
import com.teamabnormals.atmospheric.core.other.AtmosphericProperties;
import com.teamabnormals.atmospheric.core.other.tags.AtmosphericItemTags;
import com.teamabnormals.atmospheric.core.registry.AtmosphericBlocks;
import com.teamabnormals.atmospheric.core.registry.AtmosphericItems;
import com.teamabnormals.atmospheric.integration.boatload.AtmosphericBoatTypes;
import com.teamabnormals.autumnity.core.registry.AutumnityBlocks;
import com.teamabnormals.autumnity.core.registry.AutumnityBlocks.AutumnityProperties;
import com.teamabnormals.autumnity.core.registry.AutumnityItems;
import com.teamabnormals.autumnity.integration.boatload.AutumnityBoatTypes;
import com.teamabnormals.blueprint.core.data.server.BlueprintRecipeProvider;
import com.teamabnormals.boatload.core.api.BoatloadBoatType;
import com.teamabnormals.buzzier_bees.core.registry.BBBlocks;
import com.teamabnormals.caverns_and_chasms.core.other.tags.CCItemTags;
import com.teamabnormals.caverns_and_chasms.core.registry.CCBlocks;
import com.teamabnormals.caverns_and_chasms.core.registry.CCBlocks.CCProperties;
import com.teamabnormals.caverns_and_chasms.core.registry.CCItems;
import com.teamabnormals.caverns_and_chasms.integration.boatload.CCBoatTypes;
import com.teamabnormals.environmental.core.other.EnvironmentalProperties;
import com.teamabnormals.environmental.core.other.tags.EnvironmentalItemTags;
import com.teamabnormals.environmental.core.registry.EnvironmentalBlocks;
import com.teamabnormals.environmental.core.registry.EnvironmentalItems;
import com.teamabnormals.environmental.integration.boatload.EnvironmentalBoatTypes;
import com.teamabnormals.incubation.core.registry.IncubationItems;
import com.teamabnormals.neapolitan.core.other.tags.NeapolitanItemTags;
import com.teamabnormals.neapolitan.core.registry.NeapolitanItems;
import com.teamabnormals.upgrade_aquatic.core.other.tags.UAItemTags;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks;
import com.teamabnormals.upgrade_aquatic.core.registry.UABlocks.UAProperties;
import com.teamabnormals.upgrade_aquatic.core.registry.UAItems;
import com.teamabnormals.upgrade_aquatic.integration.boatload.UABoatTypes;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ICondition;
import org.apache.commons.lang3.ArrayUtils;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;
import vectorwing.farmersdelight.data.recipe.CookingRecipes;
import vectorwing.farmersdelight.data.recipe.CuttingRecipes;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.teamabnormals.abnormals_delight.core.registry.ADBlocks.*;
import static com.teamabnormals.abnormals_delight.core.registry.ADItems.*;
import static net.minecraft.data.recipes.RecipeCategory.*;

public class ADRecipeProvider extends BlueprintRecipeProvider implements ADConditions {

	public ADRecipeProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(AbnormalsDelight.MOD_ID, output, provider);
	}

	@Override
	public void buildRecipes(RecipeOutput output) {
		this.buildMixedRecipes(output);
		this.buildAtmosphericRecipes(output, ATMOSPHERIC_LOADED);
		this.buildAutumnityRecipes(output, AUTUMNITY_LOADED);
		this.buildBoatloadRecipes(output, BOATLOADED);
		this.buildBuzzierBeesRecipes(output, BUZZIER_BEES_LOADED);
		this.buildCavernsAndChasmsRecipes(output, CAVERNS_AND_CHASMS_LOADED);
		this.buildEnvironmentalRecipes(output, ENVIRONMENTAL_LOADED);
		this.buildIncubationRecipes(output, INCUBATION_LOADED);
		this.buildNeapolitanRecipes(output, NEAPOLITAN_LOADED);
		this.buildUpgradeAquaticRecipes(output, UPGRADE_AQUATIC_LOADED);
	}

	public void buildAtmosphericRecipes(RecipeOutput output, ICondition... conditions) {
		ShapelessRecipeBuilder.shapeless(FOOD, DUNE_PLATTER)
				.requires(Items.COOKED_RABBIT).requires(AtmosphericItems.ALOE_LEAVES).requires(Items.BOWL).requires(AtmosphericItems.ROASTED_YUCCA_FRUIT).requires(AtmosphericItems.YELLOW_BLOSSOMS).requires(AtmosphericItems.BARREL_CACTUS)
				.unlockedBy(getHasName(AtmosphericItems.ALOE_LEAVES), has(AtmosphericItems.ALOE_LEAVES)).unlockedBy(getHasName(AtmosphericItems.ROASTED_YUCCA_FRUIT), has(AtmosphericItems.ROASTED_YUCCA_FRUIT)).unlockedBy(getHasName(AtmosphericItems.BARREL_CACTUS), has(AtmosphericItems.BARREL_CACTUS))
				.save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(PASSION_ALOE_NECTAR, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
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

		cuttingRecipe(output, AtmosphericItems.YUCCA_GATEAU, YUCCA_GATEAU_SLICE, 10, conditions);

		cabinetRecipe(output, ROSEWOOD_CABINET, AtmosphericBlocks.ROSEWOOD_SLAB, AtmosphericBlocks.ROSEWOOD_TRAPDOOR, conditions);
		cabinetRecipe(output, MORADO_CABINET, AtmosphericBlocks.MORADO_SLAB, AtmosphericBlocks.MORADO_TRAPDOOR, conditions);
		cabinetRecipe(output, YUCCA_CABINET, AtmosphericBlocks.YUCCA_SLAB, AtmosphericBlocks.YUCCA_TRAPDOOR, conditions);
		cabinetRecipe(output, KOUSA_CABINET, AtmosphericBlocks.KOUSA_SLAB, AtmosphericBlocks.KOUSA_TRAPDOOR, conditions);
		cabinetRecipe(output, ASPEN_CABINET, AtmosphericBlocks.ASPEN_SLAB, AtmosphericBlocks.ASPEN_TRAPDOOR, conditions);
		cabinetRecipe(output, LAUREL_CABINET, AtmosphericBlocks.LAUREL_SLAB, AtmosphericBlocks.LAUREL_TRAPDOOR, conditions);
		cabinetRecipe(output, GRIMWOOD_CABINET, AtmosphericBlocks.GRIMWOOD_SLAB, AtmosphericBlocks.GRIMWOOD_TRAPDOOR, conditions);

		salvagePlankFromFurniture(output, AtmosphericProperties.ROSEWOOD_WOOD_TYPE, AtmosphericBlocks.ROSEWOOD_PLANKS, List.of(AtmosphericBlocks.ROSEWOOD_DOOR, AtmosphericBlocks.ROSEWOOD_TRAPDOOR, AtmosphericBlocks.ROSEWOOD_SIGNS.getFirst(), AtmosphericBlocks.ROSEWOOD_HANGING_SIGNS.getFirst(), AtmosphericBlocks.ROSEWOOD_FENCE, AtmosphericBlocks.ROSEWOOD_FENCE_GATE, AtmosphericBlocks.ROSEWOOD_PRESSURE_PLATE, AtmosphericBlocks.ROSEWOOD_BUTTON, AtmosphericItems.ROSEWOOD_BOAT, ROSEWOOD_CABINET), conditions);
		salvagePlankFromFurniture(output, AtmosphericProperties.MORADO_WOOD_TYPE, AtmosphericBlocks.MORADO_PLANKS, List.of(AtmosphericBlocks.MORADO_DOOR, AtmosphericBlocks.MORADO_TRAPDOOR, AtmosphericBlocks.MORADO_SIGNS.getFirst(), AtmosphericBlocks.MORADO_HANGING_SIGNS.getFirst(), AtmosphericBlocks.MORADO_FENCE, AtmosphericBlocks.MORADO_FENCE_GATE, AtmosphericBlocks.MORADO_PRESSURE_PLATE, AtmosphericBlocks.MORADO_BUTTON, AtmosphericItems.MORADO_BOAT, MORADO_CABINET), conditions);
		salvagePlankFromFurniture(output, AtmosphericProperties.YUCCA_WOOD_TYPE, AtmosphericBlocks.YUCCA_PLANKS, List.of(AtmosphericBlocks.YUCCA_DOOR, AtmosphericBlocks.YUCCA_TRAPDOOR, AtmosphericBlocks.YUCCA_SIGNS.getFirst(), AtmosphericBlocks.YUCCA_HANGING_SIGNS.getFirst(), AtmosphericBlocks.YUCCA_FENCE, AtmosphericBlocks.YUCCA_FENCE_GATE, AtmosphericBlocks.YUCCA_PRESSURE_PLATE, AtmosphericBlocks.YUCCA_BUTTON, AtmosphericItems.YUCCA_BOAT, YUCCA_CABINET), conditions);
		salvagePlankFromFurniture(output, AtmosphericProperties.KOUSA_WOOD_TYPE, AtmosphericBlocks.KOUSA_PLANKS, List.of(AtmosphericBlocks.KOUSA_DOOR, AtmosphericBlocks.KOUSA_TRAPDOOR, AtmosphericBlocks.KOUSA_SIGNS.getFirst(), AtmosphericBlocks.KOUSA_HANGING_SIGNS.getFirst(), AtmosphericBlocks.KOUSA_FENCE, AtmosphericBlocks.KOUSA_FENCE_GATE, AtmosphericBlocks.KOUSA_PRESSURE_PLATE, AtmosphericBlocks.KOUSA_BUTTON, AtmosphericItems.KOUSA_BOAT, KOUSA_CABINET), conditions);
		salvagePlankFromFurniture(output, AtmosphericProperties.ASPEN_WOOD_TYPE, AtmosphericBlocks.ASPEN_PLANKS, List.of(AtmosphericBlocks.ASPEN_DOOR, AtmosphericBlocks.ASPEN_TRAPDOOR, AtmosphericBlocks.ASPEN_SIGNS.getFirst(), AtmosphericBlocks.ASPEN_HANGING_SIGNS.getFirst(), AtmosphericBlocks.ASPEN_FENCE, AtmosphericBlocks.ASPEN_FENCE_GATE, AtmosphericBlocks.ASPEN_PRESSURE_PLATE, AtmosphericBlocks.ASPEN_BUTTON, AtmosphericItems.ASPEN_BOAT, ASPEN_CABINET), conditions);
		salvagePlankFromFurniture(output, AtmosphericProperties.LAUREL_WOOD_TYPE, AtmosphericBlocks.LAUREL_PLANKS, List.of(AtmosphericBlocks.LAUREL_DOOR, AtmosphericBlocks.LAUREL_TRAPDOOR, AtmosphericBlocks.LAUREL_SIGNS.getFirst(), AtmosphericBlocks.LAUREL_HANGING_SIGNS.getFirst(), AtmosphericBlocks.LAUREL_FENCE, AtmosphericBlocks.LAUREL_FENCE_GATE, AtmosphericBlocks.LAUREL_PRESSURE_PLATE, AtmosphericBlocks.LAUREL_BUTTON, AtmosphericItems.LAUREL_BOAT, LAUREL_CABINET), conditions);
		salvagePlankFromFurniture(output, AtmosphericProperties.GRIMWOOD_WOOD_TYPE, AtmosphericBlocks.GRIMWOOD_PLANKS, List.of(AtmosphericBlocks.GRIMWOOD_DOOR, AtmosphericBlocks.GRIMWOOD_TRAPDOOR, AtmosphericBlocks.GRIMWOOD_SIGNS.getFirst(), AtmosphericBlocks.GRIMWOOD_HANGING_SIGNS.getFirst(), AtmosphericBlocks.GRIMWOOD_FENCE, AtmosphericBlocks.GRIMWOOD_FENCE_GATE, AtmosphericBlocks.GRIMWOOD_PRESSURE_PLATE, AtmosphericBlocks.GRIMWOOD_BUTTON, AtmosphericItems.GRIMWOOD_BOAT, GRIMWOOD_CABINET), conditions);

		salvageBlockFromVehicle(output, AtmosphericBoatTypes.ROSEWOOD, conditions);
		salvageBlockFromVehicle(output, AtmosphericBoatTypes.MORADO, conditions);
		salvageBlockFromVehicle(output, AtmosphericBoatTypes.YUCCA, conditions);
		salvageBlockFromVehicle(output, AtmosphericBoatTypes.KOUSA, conditions);
		salvageBlockFromVehicle(output, AtmosphericBoatTypes.ASPEN, conditions);
		salvageBlockFromVehicle(output, AtmosphericBoatTypes.LAUREL, conditions);
		salvageBlockFromVehicle(output, AtmosphericBoatTypes.GRIMWOOD, conditions);

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
		ShapelessRecipeBuilder.shapeless(FOOD, AutumnityItems.PUMPKIN_BREAD, 2)
				.requires(AutumnityItems.SYRUP_BOTTLE).requires(ModItems.PUMPKIN_SLICE.get())
				.requires(Items.WHEAT, 2).unlockedBy(getHasName(AutumnityItems.SYRUP_BOTTLE), has(AutumnityItems.SYRUP_BOTTLE))
				.save(output.withConditions(AUTUMNITY_LOADED), wrapRecipeID(AutumnityItems.PUMPKIN_BREAD));

		ShapelessRecipeBuilder.shapeless(FOOD, MAPLE_GLAZED_BACON)
				.requires(ModItems.COOKED_BACON.get()).requires(AutumnityItems.SYRUP_BOTTLE)
				.unlockedBy(getHasName(ModItems.COOKED_BACON.get()), has(ModItems.COOKED_BACON.get()))
				.unlockedBy(getHasName(AutumnityItems.SYRUP_BOTTLE), has(AutumnityItems.SYRUP_BOTTLE))
				.save(output.withConditions(conditions));

		ShapelessRecipeBuilder.shapeless(FOOD, MAPLE_COOKIE, 8)
				.requires(AutumnityItems.SYRUP_BOTTLE).requires(Items.WHEAT).requires(Items.WHEAT)
				.unlockedBy(getHasName(AutumnityItems.SYRUP_BOTTLE), has(AutumnityItems.SYRUP_BOTTLE)).save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(ESCARGOT, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP, AutumnityItems.SNAIL_SHELL_PIECE)
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
				.save(output.withConditions(conditions), AbnormalsDelight.location(RecipeBuilder.getDefaultRecipeId(ModItems.STUFFED_PUMPKIN_BLOCK.get()).getPath()));

		cuttingRecipe(output, AutumnityBlocks.AUTUMN_CROCUS, Items.MAGENTA_DYE, 2, conditions);

		cuttingRecipe(output, AutumnityBlocks.TURKEY, AutumnityItems.TURKEY_PIECE, 5, conditions);
		cuttingRecipe(output, AutumnityBlocks.COOKED_TURKEY, AutumnityItems.COOKED_TURKEY_PIECE, 5, conditions);
		cuttingRecipe(output, AutumnityBlocks.LARGE_PUMPKIN_SLICE, ModItems.PUMPKIN_SLICE.get(), 4, conditions);

		cabinetRecipe(output, MAPLE_CABINET, AutumnityBlocks.MAPLE_SLAB, AutumnityBlocks.MAPLE_TRAPDOOR, conditions);
		salvagePlankFromFurniture(output, AutumnityProperties.MAPLE_WOOD_TYPE, AutumnityBlocks.MAPLE_PLANKS, List.of(AutumnityBlocks.MAPLE_DOOR, AutumnityBlocks.MAPLE_TRAPDOOR, AutumnityBlocks.MAPLE_SIGNS.getFirst(), AutumnityBlocks.MAPLE_HANGING_SIGNS.getFirst(), AutumnityBlocks.MAPLE_FENCE, AutumnityBlocks.MAPLE_FENCE_GATE, AutumnityBlocks.MAPLE_PRESSURE_PLATE, AutumnityBlocks.MAPLE_BUTTON, AutumnityItems.MAPLE_BOAT.getFirst(), MAPLE_CABINET), conditions);
		salvageBlockFromVehicle(output, AutumnityBoatTypes.MAPLE, conditions);
		stripLogForBark(output, AutumnityBlocks.MAPLE_LOG, AutumnityBlocks.STRIPPED_MAPLE_LOG, conditions);
		stripLogForBark(output, AutumnityBlocks.MAPLE_WOOD, AutumnityBlocks.STRIPPED_MAPLE_WOOD, conditions);
	}

	public void buildBoatloadRecipes(RecipeOutput output, ICondition... conditions) {
		salvageBlockFromVehicle(output, BoatloadBoatType.OAK, conditions);
		salvageBlockFromVehicle(output, BoatloadBoatType.BIRCH, conditions);
		salvageBlockFromVehicle(output, BoatloadBoatType.SPRUCE, conditions);
		salvageBlockFromVehicle(output, BoatloadBoatType.JUNGLE, conditions);
		salvageBlockFromVehicle(output, BoatloadBoatType.ACACIA, conditions);
		salvageBlockFromVehicle(output, BoatloadBoatType.DARK_OAK, conditions);
		salvageBlockFromVehicle(output, BoatloadBoatType.MANGROVE, conditions);
		salvageBlockFromVehicle(output, BoatloadBoatType.CHERRY, conditions);
		salvageBlockFromVehicle(output, BoatloadBoatType.BAMBOO, conditions);
		salvageBlockFromVehicle(output, BoatloadBoatType.CRIMSON, conditions);
		salvageBlockFromVehicle(output, BoatloadBoatType.WARPED, conditions);
	}

	public void buildBuzzierBeesRecipes(RecipeOutput output, ICondition... conditions) {
		cuttingRecipe(output, BBBlocks.BUTTERCUP, Items.YELLOW_DYE, 2, conditions);
		cuttingRecipe(output, BBBlocks.PINK_CLOVER, Items.PINK_DYE, 2, conditions);
		cuttingRecipe(output, BBBlocks.WHITE_CLOVER, Items.WHITE_DYE, 2, conditions);
	}

	public void buildCavernsAndChasmsRecipes(RecipeOutput output, ICondition... conditions) {
		copperKnifeRecipes(output, COPPER_KNIFE, Blocks.COPPER_BLOCK, Items.COPPER_INGOT, conditions);
		copperKnifeRecipes(output, EXPOSED_COPPER_KNIFE, Blocks.EXPOSED_COPPER, CCItems.EXPOSED_COPPER_INGOT, conditions);
		copperKnifeRecipes(output, WEATHERED_COPPER_KNIFE, Blocks.WEATHERED_COPPER, CCItems.WEATHERED_COPPER_INGOT, conditions);
		copperKnifeRecipes(output, OXIDIZED_COPPER_KNIFE, Blocks.OXIDIZED_COPPER, CCItems.OXIDIZED_COPPER_INGOT, conditions);
		copperKnifeRecipes(output, WAXED_COPPER_KNIFE, Blocks.WAXED_COPPER_BLOCK, CCItems.WAXED_COPPER_INGOT, conditions);
		copperKnifeRecipes(output, WAXED_EXPOSED_COPPER_KNIFE, Blocks.WAXED_EXPOSED_COPPER, CCItems.WAXED_EXPOSED_COPPER_INGOT, conditions);
		copperKnifeRecipes(output, WAXED_WEATHERED_COPPER_KNIFE, Blocks.WAXED_WEATHERED_COPPER, CCItems.WAXED_WEATHERED_COPPER_INGOT, conditions);
		copperKnifeRecipes(output, WAXED_OXIDIZED_COPPER_KNIFE, Blocks.WAXED_OXIDIZED_COPPER, CCItems.WAXED_OXIDIZED_COPPER_INGOT, conditions);

		ShapedRecipeBuilder.shaped(COMBAT, SILVER_KNIFE).pattern("m").pattern("s").define('m', CCItemTags.INGOTS_SILVER).define('s', Items.STICK).unlockedBy("has_silver_ingot", has(CCItemTags.INGOTS_SILVER)).save(output.withConditions(conditions));
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(SILVER_KNIFE), MISC, CCItems.SILVER_NUGGET, 0.1F, 200).unlockedBy("has_silver_knife", has(SILVER_KNIFE)).save(output.withConditions(conditions), AbnormalsDelight.location("silver_nugget_from_smelting_knife"));
		SimpleCookingRecipeBuilder.blasting(Ingredient.of(SILVER_KNIFE), MISC, CCItems.SILVER_NUGGET, 0.1F, 100).unlockedBy("has_silver_knife", has(SILVER_KNIFE)).save(output.withConditions(conditions), AbnormalsDelight.location("silver_nugget_from_blasting_knife"));

		SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(ModItems.DIAMOND_KNIFE.get()), Ingredient.of(CCItemTags.INGOTS_NECROMIUM), COMBAT, NECROMIUM_KNIFE.get()).unlocks("has_necromium_ingot", has(CCItemTags.INGOTS_NECROMIUM)).save(output.withConditions(conditions), AbnormalsDelight.location("necromium_knife_smithing"));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CCItems.TMT_MINECART), CuttingRecipes.HOES, Items.MINECART).addResult(CCBlocks.TMT).addSound(SoundEvents.METAL_BREAK).salvaging().save(output.withConditions(conditions));

		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CCBlocks.LAPIS_LAZULI_BRICKS.get()), CuttingRecipes.PICKAXES, Items.LAPIS_LAZULI, 4).salvaging().save(output.withConditions(conditions));
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(CCBlocks.SPINEL_BRICKS.get()), CuttingRecipes.PICKAXES, CCItems.SPINEL.get(), 4).salvaging().save(output.withConditions(conditions));

		cabinetRecipe(output, AZALEA_CABINET, CCBlocks.AZALEA_SLAB, CCBlocks.AZALEA_TRAPDOOR, conditions);
		salvagePlankFromFurniture(output, CCProperties.AZALEA_WOOD_TYPE, CCBlocks.AZALEA_PLANKS, List.of(CCBlocks.AZALEA_DOOR, CCBlocks.AZALEA_TRAPDOOR, CCBlocks.AZALEA_SIGNS.getFirst(), CCBlocks.AZALEA_HANGING_SIGNS.getFirst(), CCBlocks.AZALEA_FENCE, CCBlocks.AZALEA_FENCE_GATE, CCBlocks.AZALEA_PRESSURE_PLATE, CCBlocks.AZALEA_BUTTON, CCItems.AZALEA_BOAT.getFirst(), AZALEA_CABINET), conditions);
		salvageBlockFromVehicle(output, CCBoatTypes.AZALEA, conditions);
		stripLogForBark(output, CCBlocks.AZALEA_LOG, CCBlocks.STRIPPED_AZALEA_LOG, conditions);
		stripLogForBark(output, CCBlocks.AZALEA_WOOD, CCBlocks.STRIPPED_AZALEA_WOOD, conditions);
	}

	public static void copperKnifeRecipes(RecipeOutput output, ItemLike knife, ItemLike block, ItemLike ingot, ICondition... conditions) {
		ShapedRecipeBuilder.shaped(COMBAT, knife).pattern("m").pattern("s").define('m', block).define('s', Items.STICK).unlockedBy("has_copper_block", has(block)).save(output.withConditions(conditions));
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(knife), MISC, ingot, 0.1F, 200).unlockedBy(getHasName(knife), has(knife)).save(output.withConditions(conditions), AbnormalsDelight.location(getSmeltingRecipeName(ingot)).withSuffix("_" + getItemName(knife)));
		SimpleCookingRecipeBuilder.blasting(Ingredient.of(knife), MISC, ingot, 0.1F, 100).unlockedBy(getHasName(knife), has(knife)).save(output.withConditions(conditions), AbnormalsDelight.location(getBlastingRecipeName(ingot)).withSuffix("_" + getItemName(knife)));
	}

	public void buildEnvironmentalRecipes(RecipeOutput output, ICondition... conditions) {
		ShapelessRecipeBuilder.shapeless(FOOD, SEARED_VENISON)
				.requires(EnvironmentalItemTags.FOODS_COOKED_VENISON).requires(EnvironmentalItemTags.FOODS_CHERRY).requires(Items.BOWL).requires(EnvironmentalItemTags.FOODS_CHERRY).requires(Items.CARROT)
				.unlockedBy("has_cooked_venison", has(EnvironmentalItemTags.FOODS_COOKED_VENISON)).unlockedBy("has_cherries", has(EnvironmentalItemTags.FOODS_CHERRY))
				.save(output.withConditions(ENVIRONMENTAL_LOADED));

		CookingPotRecipeBuilder.cookingPotRecipe(VENISON_WITH_BAMBOO_SHOOTS, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(EnvironmentalItemTags.FOODS_RAW_VENISON).addIngredient(Items.KELP).addIngredient(Items.BAMBOO).addIngredient(Items.BAMBOO).addIngredient(Tags.Items.FOODS_VEGETABLE)
				.unlockedBy("has_raw_venison", has(EnvironmentalItemTags.FOODS_RAW_VENISON)).unlockedByAnyIngredient(Items.KELP, Items.BAMBOO)
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(DUCK_NOODLES, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(EnvironmentalItemTags.FOODS_RAW_DUCK).addIngredient(CommonTags.Items.FOODS_PASTA).addIngredient(Items.CARROT).addIngredient(Tags.Items.FOODS_VEGETABLE)
				.unlockedBy("has_raw_duck", has(EnvironmentalItemTags.FOODS_RAW_DUCK)).unlockedByAnyIngredient(ModItems.RAW_PASTA.get())
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(SLABDISH, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(Tags.Items.FOODS_RAW_FISH).addIngredient(EnvironmentalBlocks.DIANTHUS).addIngredient(Items.BONE_MEAL).addIngredient(ADItemTags.SLABDISH_INGREDIENTS).addIngredient(ADItemTags.SLABDISH_INGREDIENTS)
				.unlockedBy("has_slabdish_ingredients", has(ADItemTags.SLABDISH_INGREDIENTS)).unlockedByAnyIngredient(Items.BONE_MEAL)
				.setRecipeBookTab(CookingPotRecipeBookTab.MISC).save(output.withConditions(conditions));

		ShapelessRecipeBuilder.shapeless(FOOD, CHERRY_COOKIE, 8)
				.requires(EnvironmentalItemTags.FOODS_CHERRY).requires(Items.WHEAT).requires(Items.WHEAT)
				.unlockedBy("has_cherries", has(EnvironmentalItemTags.FOODS_CHERRY)).save(output.withConditions(conditions));

		cuttingRecipe(output, EnvironmentalItems.DUCK, DUCK_FILLET, 2, conditions);
		cuttingRecipe(output, EnvironmentalItems.COOKED_DUCK, COOKED_DUCK_FILLET, 2, conditions);
		conditionalFoodCookingRecipes(output, DUCK_FILLET, COOKED_DUCK_FILLET, conditions);

		cuttingRecipe(output, EnvironmentalItems.VENISON, VENISON_SHANKS, 2, conditions);
		cuttingRecipe(output, EnvironmentalItems.COOKED_VENISON, COOKED_VENISON_SHANKS, 2, conditions);
		conditionalFoodCookingRecipes(output, VENISON_SHANKS, COOKED_VENISON_SHANKS, conditions);

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

		cabinetRecipe(output, WILLOW_CABINET, EnvironmentalBlocks.WILLOW_SLAB, EnvironmentalBlocks.WILLOW_TRAPDOOR, conditions);
		cabinetRecipe(output, WISTERIA_CABINET, EnvironmentalBlocks.WISTERIA_SLAB, EnvironmentalBlocks.WISTERIA_TRAPDOOR, conditions);
		cabinetRecipe(output, PLUM_CABINET, EnvironmentalBlocks.PLUM_SLAB, EnvironmentalBlocks.PLUM_TRAPDOOR, conditions);
		cabinetRecipe(output, PINE_CABINET, EnvironmentalBlocks.PINE_SLAB, EnvironmentalBlocks.PINE_TRAPDOOR, conditions);

		salvagePlankFromFurniture(output, EnvironmentalProperties.WILLOW_WOOD_TYPE, EnvironmentalBlocks.WILLOW_PLANKS, List.of(EnvironmentalBlocks.WILLOW_DOOR, EnvironmentalBlocks.WILLOW_TRAPDOOR, EnvironmentalBlocks.WILLOW_SIGNS.getFirst(), EnvironmentalBlocks.WILLOW_HANGING_SIGNS.getFirst(), EnvironmentalBlocks.WILLOW_FENCE, EnvironmentalBlocks.WILLOW_FENCE_GATE, EnvironmentalBlocks.WILLOW_PRESSURE_PLATE, EnvironmentalBlocks.WILLOW_BUTTON, EnvironmentalItems.WILLOW_BOAT.getFirst(), WILLOW_CABINET), conditions);
		salvagePlankFromFurniture(output, EnvironmentalProperties.WISTERIA_WOOD_TYPE, EnvironmentalBlocks.WISTERIA_PLANKS, List.of(EnvironmentalBlocks.WISTERIA_DOOR, EnvironmentalBlocks.WISTERIA_TRAPDOOR, EnvironmentalBlocks.WISTERIA_SIGNS.getFirst(), EnvironmentalBlocks.WISTERIA_HANGING_SIGNS.getFirst(), EnvironmentalBlocks.WISTERIA_FENCE, EnvironmentalBlocks.WISTERIA_FENCE_GATE, EnvironmentalBlocks.WISTERIA_PRESSURE_PLATE, EnvironmentalBlocks.WISTERIA_BUTTON, EnvironmentalItems.WISTERIA_BOAT.getFirst(), WISTERIA_CABINET), conditions);
		salvagePlankFromFurniture(output, EnvironmentalProperties.PLUM_WOOD_TYPE, EnvironmentalBlocks.PLUM_PLANKS, List.of(EnvironmentalBlocks.PLUM_DOOR, EnvironmentalBlocks.PLUM_TRAPDOOR, EnvironmentalBlocks.PLUM_SIGNS.getFirst(), EnvironmentalBlocks.PLUM_HANGING_SIGNS.getFirst(), EnvironmentalBlocks.PLUM_FENCE, EnvironmentalBlocks.PLUM_FENCE_GATE, EnvironmentalBlocks.PLUM_PRESSURE_PLATE, EnvironmentalBlocks.PLUM_BUTTON, EnvironmentalItems.PLUM_BOAT.getFirst(), PLUM_CABINET), conditions);
		salvagePlankFromFurniture(output, EnvironmentalProperties.PINE_WOOD_TYPE, EnvironmentalBlocks.PINE_PLANKS, List.of(EnvironmentalBlocks.PINE_DOOR, EnvironmentalBlocks.PINE_TRAPDOOR, EnvironmentalBlocks.PINE_SIGNS.getFirst(), EnvironmentalBlocks.PINE_HANGING_SIGNS.getFirst(), EnvironmentalBlocks.PINE_FENCE, EnvironmentalBlocks.PINE_FENCE_GATE, EnvironmentalBlocks.PINE_PRESSURE_PLATE, EnvironmentalBlocks.PINE_BUTTON, EnvironmentalItems.PINE_BOAT.getFirst(), PINE_CABINET), conditions);

		salvageBlockFromVehicle(output, EnvironmentalBoatTypes.WILLOW, conditions);
		salvageBlockFromVehicle(output, EnvironmentalBoatTypes.WISTERIA, conditions);
		salvageBlockFromVehicle(output, EnvironmentalBoatTypes.PLUM, conditions);
		salvageBlockFromVehicle(output, EnvironmentalBoatTypes.PINE, conditions);

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
		ShapedRecipeBuilder.shaped(FOOD, ModItems.MELON_POPSICLE.get(), 1)
				.pattern(" mm").pattern("imm").pattern("-i ").define('m', Items.MELON_SLICE).define('i', Items.ICE).define('-', Items.STICK)
				.unlockedBy(getHasName(Items.MELON_SLICE), has(Items.MELON_SLICE)).save(output.withConditions(NEAPOLITAN_NOT_LOADED));

		ShapedRecipeBuilder.shaped(FOOD, ModItems.MELON_POPSICLE.get(), 1)
				.pattern(" mm").pattern("imm").pattern("-i ").define('m', Items.MELON_SLICE).define('i', NeapolitanItems.ICE_CUBES).define('-', Items.STICK)
				.unlockedBy(getHasName(Items.MELON_SLICE), has(Items.MELON_SLICE)).save(output.withConditions(NEAPOLITAN_LOADED), wrapRecipeID(ModItems.MELON_POPSICLE.get()));

		ShapelessRecipeBuilder.shapeless(FOOD, NeapolitanItems.ADZUKI_CURRY)
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

		ShapelessRecipeBuilder.shapeless(FOOD, ModItems.MILK_BOTTLE.get(), 4).requires(Items.MILK_BUCKET).requires(Items.GLASS_BOTTLE, 4).unlockedBy("has_milk_bucket", has(Items.MILK_BUCKET)).save(output.withConditions(NEAPOLITAN_NOT_LOADED));
		ShapelessRecipeBuilder.shapeless(MISC, Items.MILK_BUCKET).requires(Items.BUCKET).requires(ModItems.MILK_BOTTLE.get(), 4).unlockedBy(getHasName(ModItems.MILK_BOTTLE.get()), has(ModItems.MILK_BOTTLE.get())).save(output.withConditions(NEAPOLITAN_NOT_LOADED), ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID, "milk_bucket_from_bottles"));

		cuttingRecipe(output, NeapolitanItems.ADZUKI_CAKE, ADZUKI_CAKE_SLICE, 7, conditions);
		cuttingRecipe(output, NeapolitanItems.BANANA_CAKE, BANANA_CAKE_SLICE, 7, conditions);
		cuttingRecipe(output, NeapolitanItems.CHOCOLATE_CAKE, CHOCOLATE_CAKE_SLICE, 7, conditions);
		cuttingRecipe(output, NeapolitanItems.MINT_CAKE, MINT_CAKE_SLICE, 7, conditions);
		cuttingRecipe(output, NeapolitanItems.STRAWBERRY_CAKE, STRAWBERRY_CAKE_SLICE, 7, conditions);
		cuttingRecipe(output, NeapolitanItems.VANILLA_CAKE, VANILLA_CAKE_SLICE, 7, conditions);

		cakeRecipe(output, NeapolitanItems.ADZUKI_CAKE, ADZUKI_CAKE_SLICE, conditions);
		cakeRecipe(output, NeapolitanItems.BANANA_CAKE, BANANA_CAKE_SLICE, conditions);
		cakeRecipe(output, NeapolitanItems.CHOCOLATE_CAKE, CHOCOLATE_CAKE_SLICE, conditions);
		cakeRecipe(output, NeapolitanItems.MINT_CAKE, MINT_CAKE_SLICE, conditions);
		cakeRecipe(output, NeapolitanItems.STRAWBERRY_CAKE, STRAWBERRY_CAKE_SLICE, conditions);
		cakeRecipe(output, NeapolitanItems.VANILLA_CAKE, VANILLA_CAKE_SLICE, conditions);
	}

	public void buildUpgradeAquaticRecipes(RecipeOutput output, ICondition... conditions) {
		CookingPotRecipeBuilder.cookingPotRecipe(PICKERELWEED_JUICE, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(UABlocks.PICKERELWEED).addIngredient(UABlocks.PICKERELWEED).addIngredient(Items.SUGAR)
				.unlockedByAnyIngredient(UABlocks.PICKERELWEED)
				.setRecipeBookTab(CookingPotRecipeBookTab.DRINKS).save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(PERCH_WITH_MUSHROOMS, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(UAItemTags.FOODS_RAW_PERCH).addIngredient(ModItems.RED_MUSHROOM_COLONY.get()).addIngredient(CommonTags.Items.CROPS_RICE).addIngredient(CommonTags.Items.CROPS_TOMATO)
				.unlockedByAnyIngredient(UAItems.PERCH, ModItems.RED_MUSHROOM_COLONY.get(), ModItems.RICE.get(), ModItems.TOMATO.get())
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(conditions));

		CookingPotRecipeBuilder.cookingPotRecipe(PIKE_WITH_BEETROOT, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(UAItemTags.FOODS_RAW_PIKE).addIngredient(UABlocks.PICKERELWEED).addIngredient(UABlocks.PICKERELWEED).addIngredient(Tags.Items.CROPS_BEETROOT)
				.unlockedByAnyIngredient(UAItems.PERCH, UABlocks.PICKERELWEED, Items.BEETROOT)
				.setRecipeBookTab(CookingPotRecipeBookTab.MEALS).save(output.withConditions(conditions));

		ShapelessRecipeBuilder.shapeless(FOOD, MULBERRY_COOKIE, 8)
				.requires(UAItems.MULBERRY).requires(Items.WHEAT).requires(Items.WHEAT)
				.unlockedBy(getHasName(UAItems.MULBERRY), has(UAItems.MULBERRY)).save(output.withConditions(conditions));

		cuttingRecipe(output, UABlocks.PICKERELWEED, Items.CYAN_DYE, 2, conditions);
		cuttingRecipe(output, UABlocks.PINK_SEAROCKET, Items.PINK_DYE, 2, conditions);
		cuttingRecipe(output, UABlocks.WHITE_SEAROCKET, Items.WHITE_DYE, 2, conditions);

		cuttingFish(output, UAItems.PIKE, PIKE_SLICE, 2, conditions);
		cuttingFish(output, UAItems.COOKED_PIKE, COOKED_PIKE_SLICE, 2, conditions);
		conditionalFoodCookingRecipes(output, PIKE_SLICE, COOKED_PIKE_SLICE, conditions);

		cuttingFish(output, UAItems.PERCH, PERCH_SLICE, 2, conditions);
		cuttingFish(output, UAItems.COOKED_PERCH, COOKED_PERCH_SLICE, 2, conditions);
		conditionalFoodCookingRecipes(output, PERCH_SLICE, COOKED_PERCH_SLICE, conditions);

		cabinetRecipe(output, DRIFTWOOD_CABINET, UABlocks.DRIFTWOOD_SLAB, UABlocks.DRIFTWOOD_TRAPDOOR, conditions);
		cabinetRecipe(output, RIVER_CABINET, UABlocks.RIVER_SLAB, UABlocks.RIVER_TRAPDOOR, conditions);

		salvagePlankFromFurniture(output, UAProperties.DRIFTWOOD_WOOD_TYPE, UABlocks.DRIFTWOOD_PLANKS, List.of(UABlocks.DRIFTWOOD_DOOR, UABlocks.DRIFTWOOD_TRAPDOOR, UABlocks.DRIFTWOOD_SIGNS.getFirst(), UABlocks.DRIFTWOOD_HANGING_SIGNS.getFirst(), UABlocks.DRIFTWOOD_FENCE, UABlocks.DRIFTWOOD_FENCE_GATE, UABlocks.DRIFTWOOD_PRESSURE_PLATE, UABlocks.DRIFTWOOD_BUTTON, UAItems.DRIFTWOOD_BOAT.getFirst(), DRIFTWOOD_CABINET), conditions);
		salvagePlankFromFurniture(output, UAProperties.RIVER_WOOD_TYPE, UABlocks.RIVER_PLANKS, List.of(UABlocks.RIVER_DOOR, UABlocks.RIVER_TRAPDOOR, UABlocks.RIVER_SIGNS.getFirst(), UABlocks.RIVER_HANGING_SIGNS.getFirst(), UABlocks.RIVER_FENCE, UABlocks.RIVER_FENCE_GATE, UABlocks.RIVER_PRESSURE_PLATE, UABlocks.RIVER_BUTTON, UAItems.RIVER_BOAT.getFirst(), RIVER_CABINET), conditions);

		salvageBlockFromVehicle(output, UABoatTypes.DRIFTWOOD, conditions);
		salvageBlockFromVehicle(output, UABoatTypes.RIVER, conditions);

		stripLogForBark(output, UABlocks.DRIFTWOOD_LOG, UABlocks.STRIPPED_DRIFTWOOD_LOG, conditions);
		stripLogForBark(output, UABlocks.DRIFTWOOD, UABlocks.STRIPPED_DRIFTWOOD, conditions);
		stripLogForBark(output, UABlocks.RIVER_LOG, UABlocks.STRIPPED_RIVER_LOG, conditions);
		stripLogForBark(output, UABlocks.RIVER_WOOD, UABlocks.STRIPPED_RIVER_WOOD, conditions);
	}

	public void buildMixedRecipes(RecipeOutput output) {
		CookingPotRecipeBuilder.cookingPotRecipe(CHERRY_CREAM_SODA, 1, CookingRecipes.NORMAL_COOKING, CookingRecipes.MEDIUM_EXP)
				.addIngredient(Tags.Items.DRINKS_MILK).addIngredient(Items.SUGAR).addIngredient(EnvironmentalItemTags.FOODS_CHERRY).addIngredient(EnvironmentalItemTags.FOODS_CHERRY).addIngredient(NeapolitanItems.DRIED_VANILLA_PODS)
				.unlockedBy("has_cherries", has(EnvironmentalItemTags.FOODS_CHERRY)).unlockedByAnyIngredient(NeapolitanItems.DRIED_VANILLA_PODS)
				.setRecipeBookTab(CookingPotRecipeBookTab.DRINKS).save(output.withConditions(ENVIRONMENTAL_LOADED, NEAPOLITAN_LOADED));

		ShapelessRecipeBuilder.shapeless(FOOD, PASSION_FRUIT_GLAZED_DUCK)
				.requires(EnvironmentalItemTags.FOODS_COOKED_DUCK).requires(AtmosphericItemTags.FOODS_PASSION_FRUIT).requires(Items.BOWL).requires(Items.BAKED_POTATO).requires(CommonTags.Items.CROPS_ONION)
				.unlockedBy("has_cooked_duck", has(EnvironmentalItemTags.FOODS_COOKED_DUCK)).unlockedBy("has_passion_fruit", has(AtmosphericItemTags.FOODS_PASSION_FRUIT))
				.save(output.withConditions(ATMOSPHERIC_LOADED, ENVIRONMENTAL_LOADED));
	}

	public static void cabinetRecipe(RecipeOutput output, ItemLike block, ItemLike slab, ItemLike trapdoor, ICondition... conditions) {
		ShapedRecipeBuilder.shaped(DECORATIONS, block)
				.pattern("___").pattern("D D").pattern("___").define('_', slab).define('D', trapdoor)
				.unlockedBy(getHasName(trapdoor), has(trapdoor))
				.group("fd_cabinet").save(output.withConditions(conditions));
	}

	private static void salvagePlankFromFurniture(RecipeOutput output, WoodType woodType, ItemLike plank, List<? extends ItemLike> furniture, ICondition... conditions) {
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(furniture.stream().map(ItemStack::new)), CuttingRecipes.AXES, plank, 1, 0.75F).salvaging().save(output.withConditions(conditions), ResourceLocation.parse(woodType.name()).withPrefix("salvaging/").withSuffix("_furniture"));
	}

	private static void salvageBlockFromVehicle(RecipeOutput output, BoatloadBoatType boatType, ICondition... conditions) {
		if (!boatType.registryName().getNamespace().equals(ADConstants.BOATLOAD) || boatType.fireproof()) {
			CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(boatType.chestBoat().get()), CuttingRecipes.HOES, boatType.boat().get()).addResult(Items.CHEST).salvaging().save(output.withConditions(conditions));
		}

		ICondition[] boatloadConditions = Arrays.stream(conditions).anyMatch(condition -> condition == BOATLOADED) ? conditions : ArrayUtils.add(conditions, BOATLOADED);
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(boatType.furnaceBoat().get()), CuttingRecipes.HOES, boatType.boat().get()).addResult(Items.FURNACE).salvaging().save(output.withConditions(boatloadConditions));
	}

	private static void cuttingRecipe(RecipeOutput output, ItemLike input, ItemLike cut, int count, ICondition... conditions) {
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(input), CuttingRecipes.KNIVES, cut, count).save(output.withConditions(conditions));
	}

	private static void cuttingFish(RecipeOutput output, ItemLike input, ItemLike cut, int count, ICondition... conditions) {
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(input), CuttingRecipes.KNIVES, cut, count).addResult(Items.BONE_MEAL).save(output.withConditions(conditions));
	}

	private static void stripLogForBark(RecipeOutput output, ItemLike log, ItemLike strippedLog, ICondition... conditions) {
		CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(log), CuttingRecipes.AXES_STRIP, strippedLog).addResult(ModItems.TREE_BARK.get()).addSound(SoundEvents.AXE_STRIP).save(output.withConditions(conditions));
	}

	private void cakeRecipe(RecipeOutput output, ItemLike cake, ItemLike slice, ICondition... conditions) {
		ShapelessRecipeBuilder.shapeless(FOOD, cake)
				.requires(slice).requires(slice).requires(slice).requires(slice).requires(slice).requires(slice).requires(slice)
				.unlockedBy(getHasName(slice), has(slice))
				.group("cake").save(output.withConditions(conditions), this.getModConversionRecipeName(cake, slice));
	}

	public static void conditionalFoodCookingRecipes(RecipeOutput recipeOutput, ItemLike input, ItemLike output, ICondition... conditions) {
		conditionalFoodCookingRecipes(recipeOutput, input, output, 0.35F, 200, conditions);
	}

	public static void conditionalFoodCookingRecipes(RecipeOutput recipeOutput, ItemLike input, ItemLike output, float xp, int baseCookTime, ICondition... conditions) {
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), FOOD, output, xp, baseCookTime).unlockedBy(getHasName(input), has(input)).save(recipeOutput.withConditions(conditions));
		SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), FOOD, output, xp, baseCookTime / 2).unlockedBy(getHasName(input), has(input)).save(recipeOutput.withConditions(conditions), RecipeBuilder.getDefaultRecipeId(output) + "_from_smoking");
		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), FOOD, output, xp, baseCookTime * 3).unlockedBy(getHasName(input), has(input)).save(recipeOutput.withConditions(conditions), RecipeBuilder.getDefaultRecipeId(output) + "_from_campfire_cooking");
	}

	public static ResourceLocation wrapRecipeID(ItemLike itemLike) {
		return AbnormalsDelight.location(RecipeBuilder.getDefaultRecipeId(itemLike).getPath());
	}
}