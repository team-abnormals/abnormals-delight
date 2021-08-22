package com.minecraftabnormals.abnormals_delight.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class UseTimeItem extends Item {

	public UseTimeItem(Properties properties) {
		super(properties);
	}

	public int getUseDuration(ItemStack stack) {
		return 8;
	}
}

