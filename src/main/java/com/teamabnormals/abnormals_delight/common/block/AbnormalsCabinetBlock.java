package com.teamabnormals.abnormals_delight.common.block;

import com.teamabnormals.blueprint.core.util.item.filling.TargetedItemCategoryFiller;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.registry.ModItems;

public class AbnormalsCabinetBlock extends CabinetBlock {
	private static final TargetedItemCategoryFiller FILLER = new TargetedItemCategoryFiller(ModItems.WARPED_CABINET);

	public AbnormalsCabinetBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
		FILLER.fillItem(this.asItem(), group, items);
	}
}
