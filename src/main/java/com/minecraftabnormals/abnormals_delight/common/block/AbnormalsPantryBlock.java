package com.minecraftabnormals.abnormals_delight.common.block;

import com.minecraftabnormals.abnormals_core.core.util.item.filling.TargetedItemGroupFiller;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import vectorwing.farmersdelight.blocks.PantryBlock;
import vectorwing.farmersdelight.registry.ModItems;

public class AbnormalsPantryBlock extends PantryBlock {
	private static final TargetedItemGroupFiller FILLER = new TargetedItemGroupFiller(ModItems.WARPED_PANTRY);

	public AbnormalsPantryBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {
		FILLER.fillItem(this.asItem(), group, items);
	}
}
