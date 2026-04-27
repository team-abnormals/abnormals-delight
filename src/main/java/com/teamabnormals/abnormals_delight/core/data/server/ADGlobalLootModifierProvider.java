package com.teamabnormals.abnormals_delight.core.data.server;

import com.teamabnormals.abnormals_delight.core.other.tags.ADEntityTypeTags;
import net.minecraft.advancements.critereon.EntityEquipmentPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.EntityTypePredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext.EntityTarget;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.loot.modifier.AddItemModifier;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ADGlobalLootModifierProvider extends GlobalLootModifierProvider {

	public ADGlobalLootModifierProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(output, provider, FarmersDelight.MODID);
	}

	@Override
	protected void start() {
		this.add("scavenging_leather", new WrappedAddItemModifier(
				new LootItemCondition[]{
						LootItemEntityPropertyCondition.hasProperties(EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.Items.KNIVES)).build())).build(),
						LootItemEntityPropertyCondition.hasProperties(EntityTarget.THIS, EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(ADEntityTypeTags.SCAVENGES_LEATHER))).build()
				}, Items.LEATHER, 1));

		this.add("scavenging_feather", new WrappedAddItemModifier(
				new LootItemCondition[]{
						LootItemEntityPropertyCondition.hasProperties(EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(ModTags.Items.KNIVES)).build())).build(),
						LootItemEntityPropertyCondition.hasProperties(EntityTarget.THIS, EntityPredicate.Builder.entity().entityType(EntityTypePredicate.of(ADEntityTypeTags.SCAVENGES_FEATHER))).build()
				}, Items.FEATHER, 1));
	}

	public static class WrappedAddItemModifier extends AddItemModifier {
		public WrappedAddItemModifier(LootItemCondition[] conditionsIn, Item addedItemIn, int count) {
			super(conditionsIn, addedItemIn, count);
		}
	}
}