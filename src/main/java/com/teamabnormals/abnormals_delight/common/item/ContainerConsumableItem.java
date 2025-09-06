package com.teamabnormals.abnormals_delight.common.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class ContainerConsumableItem extends ConsumableItem {
	private final ResourceLocation compatItem;

	public ContainerConsumableItem(ResourceLocation compatItem, Properties properties) {
		super(properties);
		this.compatItem = compatItem;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack stack) {
		Item item = ForgeRegistries.ITEMS.getValue(this.compatItem);
		return item == null ? ItemStack.EMPTY : new ItemStack(item);
	}
}
