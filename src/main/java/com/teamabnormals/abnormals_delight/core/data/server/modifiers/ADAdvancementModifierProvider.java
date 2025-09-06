package com.teamabnormals.abnormals_delight.core.data.server.modifiers;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.blueprint.common.advancement.modification.AdvancementModifierProvider;
import com.teamabnormals.blueprint.common.advancement.modification.modifiers.CriteriaModifier;
import com.teamabnormals.blueprint.core.util.modification.selection.ConditionedResourceSelector;
import com.teamabnormals.blueprint.core.util.modification.selection.selectors.NamesResourceSelector;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.crafting.conditions.AndCondition;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.common.crafting.conditions.NotCondition;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.teamabnormals.abnormals_delight.core.registry.ADItems.*;

public class ADAdvancementModifierProvider extends AdvancementModifierProvider {
	public static final ModLoadedCondition AUTUMNITY_LOADED = new ModLoadedCondition(ADConstants.AUTUMNITY);
	public static final ModLoadedCondition ATMOSPHERIC_LOADED = new ModLoadedCondition(ADConstants.ATMOSPHERIC);
	public static final ModLoadedCondition ENVIRONMENTAL_LOADED = new ModLoadedCondition(ADConstants.ENVIRONMENTAL);
	public static final ModLoadedCondition INCUBATION_LOADED = new ModLoadedCondition(ADConstants.INCUBATION);
	public static final ModLoadedCondition NEAPOLITAN_LOADED = new ModLoadedCondition(ADConstants.NEAPOLITAN);
	public static final ModLoadedCondition UPGRADE_AQUATIC_LOADED = new ModLoadedCondition(ADConstants.UPGRADE_AQUATIC);

	public ADAdvancementModifierProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(AbnormalsDelight.MOD_ID, output, provider);
	}

	@Override
	protected void registerEntries(Provider provider) {
		CriteriaModifier.Builder balancedDiet = CriteriaModifier.builder(this.modId);
		List<Item> items = ForgeRegistries.ITEMS.getValues().stream().filter(item -> ForgeRegistries.ITEMS.getKey(item) != null && FarmersDelight.MODID.equals(ForgeRegistries.ITEMS.getKey(item).getNamespace())).toList();
		items.forEach(item -> {
			if (item.isEdible() && item != ModItems.APPLE_CIDER.get() && item != ModItems.FRIED_EGG.get()) {
				balancedDiet.addCriterion(ForgeRegistries.ITEMS.getKey(item).getPath(), ConsumeItemTrigger.TriggerInstance.usedItem(item));
			}
		});
		this.entry("husbandry/balanced_diet").selects("husbandry/balanced_diet").addModifier(balancedDiet.requirements(RequirementsStrategy.AND).build());

		compatBalancedDiet("autumnity", AUTUMNITY_LOADED, Set.of(MAPLE_COOKIE, MAPLE_GLAZED_BACON, ESCARGOT));
		compatBalancedDiet("atmospheric", ATMOSPHERIC_LOADED, Set.of(DUNE_PLATTER, YUCCA_GATEAU_SLICE));
		compatBalancedDiet("environmental", ENVIRONMENTAL_LOADED, Set.of(DUCK_FILLET, COOKED_DUCK_FILLET, VENISON_SHANKS, COOKED_VENISON_SHANKS, CHERRY_COOKIE, SEARED_VENISON, DUCK_NOODLES, VENISON_WITH_BAMBOO_SHOOTS, SLABDISH));
		compatBalancedDiet("environmental_and_atmospheric", new AndCondition(ENVIRONMENTAL_LOADED, ATMOSPHERIC_LOADED), Set.of(PASSION_FRUIT_GLAZED_DUCK));
		compatBalancedDiet("incubation", new NotCondition(INCUBATION_LOADED), Set.of(ModItems.FRIED_EGG));
		compatBalancedDiet("neapolitan", NEAPOLITAN_LOADED, Set.of(VANILLA_CAKE_SLICE, CHOCOLATE_CAKE_SLICE, STRAWBERRY_CAKE_SLICE, BANANA_CAKE_SLICE, MINT_CAKE_SLICE, ADZUKI_CAKE_SLICE));
		compatBalancedDiet("upgrade_aquatic", UPGRADE_AQUATIC_LOADED, Set.of(PIKE_SLICE, COOKED_PIKE_SLICE, PERCH_SLICE, COOKED_PERCH_SLICE, MULBERRY_COOKIE, PERCH_WITH_MUSHROOMS, PIKE_WITH_BEETROOT));
	}

	private void compatBalancedDiet(String name, ICondition condition, Set<RegistryObject<Item>> items) {
		ConditionedResourceSelector selector = new ConditionedResourceSelector(new NamesResourceSelector("husbandry/balanced_diet"), condition);
		CriteriaModifier.Builder balancedDiet = CriteriaModifier.builder(this.modId);
		items.forEach(item -> {
			if (item.get().isEdible())
				balancedDiet.addCriterion(ForgeRegistries.ITEMS.getKey(item.get()).getPath(), ConsumeItemTrigger.TriggerInstance.usedItem(item.get()));
		});
		this.entry("husbandry/balanced_diet/" + name).selector(selector).addModifier(balancedDiet.requirements(RequirementsStrategy.AND).build());
	}
}