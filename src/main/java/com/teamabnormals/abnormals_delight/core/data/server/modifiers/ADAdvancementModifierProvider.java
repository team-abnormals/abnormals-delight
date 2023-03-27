package com.teamabnormals.abnormals_delight.core.data.server.modifiers;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.blueprint.common.advancement.modification.AdvancementModifierProvider;
import com.teamabnormals.blueprint.common.advancement.modification.modifiers.CriteriaModifier;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.List;
import java.util.stream.Collectors;

public class ADAdvancementModifierProvider extends AdvancementModifierProvider {

	public ADAdvancementModifierProvider(DataGenerator generator) {
		super(generator, AbnormalsDelight.MOD_ID);
	}

	@Override
	protected void registerEntries() {
		CriteriaModifier.Builder balancedDiet = CriteriaModifier.builder(this.modId);
		List<Item> items = ForgeRegistries.ITEMS.getValues().stream().filter(item -> ForgeRegistries.ITEMS.getKey(item) != null && FarmersDelight.MODID.equals(ForgeRegistries.ITEMS.getKey(item).getNamespace())).collect(Collectors.toList());
		items.forEach(item -> {
			if (item.isEdible() && item != ModItems.APPLE_CIDER.get() && item != ModItems.FRIED_EGG.get()) {
				balancedDiet.addCriterion(ForgeRegistries.ITEMS.getKey(item).getPath(), ConsumeItemTrigger.TriggerInstance.usedItem(item));
			}
		});
		this.entry("husbandry/balanced_diet").selects("husbandry/balanced_diet").addModifier(balancedDiet.requirements(RequirementsStrategy.AND).build());
	}
}