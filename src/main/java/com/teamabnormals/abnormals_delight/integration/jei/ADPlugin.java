package com.teamabnormals.abnormals_delight.integration.jei;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.abnormals_delight.core.other.ADTiers;
import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.vanilla.IJeiAnvilRecipe;
import mezz.jei.api.recipe.vanilla.IVanillaRecipeFactory;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fml.ModList;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.List;
import java.util.stream.Stream;

@JeiPlugin
public class ADPlugin implements IModPlugin {

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation(AbnormalsDelight.MOD_ID, AbnormalsDelight.MOD_ID);
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addRecipes(RecipeTypes.ANVIL, getRepairRecipes(registration.getVanillaRecipeFactory()).toList());
	}

	private static Stream<RepairData> getRepairData() {
		Stream<RepairData> fdTools = Stream.of(
				new RepairData(Tiers.GOLD.getRepairIngredient(), new ItemStack(ModItems.GOLDEN_KNIFE.get())),
				new RepairData(Tiers.NETHERITE.getRepairIngredient(), new ItemStack(ModItems.NETHERITE_KNIFE.get()))
		);

		Stream<RepairData> ccTools = Stream.of(
				new RepairData(ADTiers.SILVER.getRepairIngredient(), new ItemStack(ADItems.SILVER_KNIFE.get())),
				new RepairData(ADTiers.NECROMIUM.getRepairIngredient(), new ItemStack(ADItems.NECROMIUM_KNIFE.get()))
		);

		return ModList.get().isLoaded(ADConstants.CAVERNS_AND_CHASMS) ? Stream.concat(fdTools, ccTools) : fdTools;
	}

	private static Stream<IJeiAnvilRecipe> getRepairRecipes(IVanillaRecipeFactory vanillaRecipeFactory) {
		return getRepairData().flatMap(repairData -> getRepairRecipes(repairData, vanillaRecipeFactory));
	}

	private static Stream<IJeiAnvilRecipe> getRepairRecipes(RepairData repairData, IVanillaRecipeFactory vanillaRecipeFactory) {
		Ingredient repairIngredient = repairData.getRepairIngredient();
		List<ItemStack> repairables = repairData.getRepairables();

		List<ItemStack> repairMaterials = List.of(repairIngredient.getItems());

		return repairables.stream().mapMulti((itemStack, consumer) -> {
			ItemStack damagedThreeQuarters = itemStack.copy();
			damagedThreeQuarters.setDamageValue(damagedThreeQuarters.getMaxDamage() * 3 / 4);
			ItemStack damagedHalf = itemStack.copy();
			damagedHalf.setDamageValue(damagedHalf.getMaxDamage() / 2);

			IJeiAnvilRecipe repairWithSame = vanillaRecipeFactory.createAnvilRecipe(List.of(damagedThreeQuarters), List.of(damagedThreeQuarters), List.of(damagedHalf));
			consumer.accept(repairWithSame);

			if (!repairMaterials.isEmpty()) {
				ItemStack damagedFully = itemStack.copy();
				damagedFully.setDamageValue(damagedFully.getMaxDamage());
				IJeiAnvilRecipe repairWithMaterial = vanillaRecipeFactory.createAnvilRecipe(List.of(damagedFully), repairMaterials, List.of(damagedThreeQuarters));
				consumer.accept(repairWithMaterial);
			}
		});
	}

	private static class RepairData {
		private final Ingredient repairIngredient;
		private final List<ItemStack> repairables;

		public RepairData(Ingredient repairIngredient, ItemStack... repairables) {
			this.repairIngredient = repairIngredient;
			this.repairables = List.of(repairables);
		}

		public Ingredient getRepairIngredient() {
			return repairIngredient;
		}

		public List<ItemStack> getRepairables() {
			return repairables;
		}
	}
}