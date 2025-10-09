package com.teamabnormals.abnormals_delight.core.data.server.modifiers;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConditions;
import com.teamabnormals.blueprint.common.advancement.modification.AdvancementModifierProvider;
import com.teamabnormals.blueprint.common.advancement.modification.modifiers.CriteriaModifier;
import com.teamabnormals.blueprint.core.api.conditions.BlueprintAndCondition;
import com.teamabnormals.blueprint.core.util.modification.selection.ConditionedResourceSelector;
import com.teamabnormals.blueprint.core.util.modification.selection.selectors.NamesResourceSelector;
import net.minecraft.advancements.AdvancementRequirements.Strategy;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.NotCondition;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static com.teamabnormals.abnormals_delight.core.registry.ADItems.*;

public class ADAdvancementModifierProvider extends AdvancementModifierProvider implements ADConditions {

	public ADAdvancementModifierProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(AbnormalsDelight.MOD_ID, output, provider);
	}

	@Override
	protected void registerEntries(Provider provider) {
		CriteriaModifier.Builder balancedDiet = CriteriaModifier.builder(this.modId);
		List<Item> items = BuiltInRegistries.ITEM.stream().filter(item -> FarmersDelight.MODID.equals(BuiltInRegistries.ITEM.getKey(item).getNamespace())).toList();
		items.forEach(item -> {
			if (item.getDefaultInstance().getFoodProperties(null) != null && item != ModItems.APPLE_CIDER.get() && item != ModItems.FRIED_EGG.get()) {
				balancedDiet.addCriterion(BuiltInRegistries.ITEM.getKey(item).getPath(), ConsumeItemTrigger.TriggerInstance.usedItem(item));
			}
		});
		this.entry("husbandry/balanced_diet").selects("husbandry/balanced_diet").addModifier(balancedDiet.requirements(Strategy.AND).build());

		compatBalancedDiet("autumnity", AUTUMNITY_LOADED, List.of(MAPLE_COOKIE, MAPLE_GLAZED_BACON, ESCARGOT));
		compatBalancedDiet("atmospheric", ATMOSPHERIC_LOADED, List.of(DUNE_PLATTER, YUCCA_GATEAU_SLICE));
		compatBalancedDiet("environmental", ENVIRONMENTAL_LOADED, List.of(DUCK_FILLET, COOKED_DUCK_FILLET, VENISON_SHANKS, COOKED_VENISON_SHANKS, CHERRY_COOKIE, SEARED_VENISON, DUCK_NOODLES, VENISON_WITH_BAMBOO_SHOOTS, SLABDISH));
		compatBalancedDiet("environmental_and_atmospheric", new BlueprintAndCondition(ENVIRONMENTAL_LOADED, ATMOSPHERIC_LOADED), List.of(PASSION_FRUIT_GLAZED_DUCK));
		compatBalancedDiet("incubation", new NotCondition(INCUBATION_LOADED), List.of(ModItems.FRIED_EGG));
		compatBalancedDiet("neapolitan", NEAPOLITAN_LOADED, List.of(VANILLA_CAKE_SLICE, CHOCOLATE_CAKE_SLICE, STRAWBERRY_CAKE_SLICE, BANANA_CAKE_SLICE, MINT_CAKE_SLICE, ADZUKI_CAKE_SLICE));
		compatBalancedDiet("upgrade_aquatic", UPGRADE_AQUATIC_LOADED, List.of(PIKE_SLICE, COOKED_PIKE_SLICE, PERCH_SLICE, COOKED_PERCH_SLICE, MULBERRY_COOKIE, PERCH_WITH_MUSHROOMS, PIKE_WITH_BEETROOT));
	}

	private void compatBalancedDiet(String name, ICondition condition, List<Supplier<Item>> items) {
		ConditionedResourceSelector selector = new ConditionedResourceSelector(new NamesResourceSelector("husbandry/balanced_diet"), condition);
		CriteriaModifier.Builder balancedDiet = CriteriaModifier.builder(this.modId);
		items.stream()
				.filter(item -> item.get().getDefaultInstance().getFoodProperties(null) != null)
				.sorted(Comparator.comparing(item -> BuiltInRegistries.ITEM.getKey(item.get())))
				.forEach(item -> {
					balancedDiet.addCriterion(BuiltInRegistries.ITEM.getKey(item.get()).getPath(), ConsumeItemTrigger.TriggerInstance.usedItem(item.get()));
				});
		this.entry("husbandry/balanced_diet/" + name).selector(selector).addModifier(balancedDiet.requirements(Strategy.AND).build());
	}
}