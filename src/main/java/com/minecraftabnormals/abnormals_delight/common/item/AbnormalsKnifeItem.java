package com.minecraftabnormals.abnormals_delight.common.item;

import com.minecraftabnormals.abnormals_core.core.util.item.filling.TargetedItemGroupFiller;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.ModList;
import vectorwing.farmersdelight.blocks.PantryBlock;
import vectorwing.farmersdelight.items.KnifeItem;
import vectorwing.farmersdelight.registry.ModItems;

public class AbnormalsKnifeItem extends KnifeItem {
	private static final TargetedItemGroupFiller FILLER = new TargetedItemGroupFiller(ModItems.GOLDEN_KNIFE);

	public AbnormalsKnifeItem(IItemTier tier, Properties properties) {
		super(tier, 1, -1.8F, ModList.get().isLoaded("caverns_and_chasms") ? properties.group(ItemGroup.COMBAT) : properties);
	}

	@Override
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
		FILLER.fillItem(this, group, items);
	}
}
