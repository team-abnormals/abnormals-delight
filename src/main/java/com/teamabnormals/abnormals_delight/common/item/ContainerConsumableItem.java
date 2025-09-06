package com.teamabnormals.abnormals_delight.common.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class ContainerConsumableItem extends ConsumableItem {
	private final ResourceLocation compatItem;

	public ContainerConsumableItem(ResourceLocation compatItem, Properties properties) {
		super(properties);
		this.compatItem = compatItem;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack stack) {
		return BuiltInRegistries.ITEM.getHolder(this.compatItem).map(ItemStack::new).orElse(ItemStack.EMPTY);
	}
}
