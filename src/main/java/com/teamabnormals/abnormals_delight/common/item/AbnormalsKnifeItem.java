package com.teamabnormals.abnormals_delight.common.item;

import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.blueprint.core.util.item.filling.TargetedItemCategoryFiller;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraftforge.fml.ModList;
import vectorwing.farmersdelight.common.item.KnifeItem;
import vectorwing.farmersdelight.common.registry.ModItems;

public class AbnormalsKnifeItem extends KnifeItem {
	private static final TargetedItemCategoryFiller FILLER = new TargetedItemCategoryFiller(ModItems.GOLDEN_KNIFE);

	public AbnormalsKnifeItem(Tier tier, Properties properties) {
		super(tier, 0.5F, -2.0F, ModList.get().isLoaded(ADConstants.CAVERNS_AND_CHASMS) ? properties.tab(CreativeModeTab.TAB_COMBAT) : properties);
	}

	@Override
	public void fillItemCategory(CreativeModeTab group, NonNullList<ItemStack> items) {
		FILLER.fillItem(this, group, items);
	}
}
