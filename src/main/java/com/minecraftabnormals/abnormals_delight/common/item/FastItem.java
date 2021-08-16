package com.minecraftabnormals.abnormals_delight.common.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FastItem extends Item {

	public FastItem(Properties properties) {
		super(properties);
	}

	public int getUseDuration(ItemStack stack) {
		return 8;
	}
}

