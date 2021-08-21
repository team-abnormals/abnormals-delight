package com.minecraftabnormals.abnormals_delight.common.item;

import com.minecraftabnormals.abnormals_core.core.util.item.filling.TargetedItemGroupFiller;
import com.minecraftabnormals.abnormals_delight.core.other.ADConstants;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.ModList;
import vectorwing.farmersdelight.items.KnifeItem;
import vectorwing.farmersdelight.registry.ModItems;

public class AbnormalsKnifeItem extends KnifeItem {
	private static final TargetedItemGroupFiller FILLER = new TargetedItemGroupFiller(ModItems.GOLDEN_KNIFE);

	public AbnormalsKnifeItem(IItemTier tier, Properties properties) {
		super(tier, 1, -1.8F, ModList.get().isLoaded(ADConstants.CAVERNS_AND_CHASMS) ? properties.tab(ItemGroup.TAB_COMBAT) : properties);
	}

	@Override
	public void fillItemCategory(ItemGroup group, NonNullList<ItemStack> items) {
		FILLER.fillItem(this, group, items);
	}
}
