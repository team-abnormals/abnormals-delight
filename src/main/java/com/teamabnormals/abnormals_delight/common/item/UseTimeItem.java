package com.teamabnormals.abnormals_delight.common.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class UseTimeItem extends Item {

	public UseTimeItem(Properties properties) {
		super(properties);
	}

	public int getUseDuration(ItemStack stack) {
		return 8;
	}
}

