package com.minecraftabnormals.abnormals_delight.common.item;

import com.minecraftabnormals.abnormals_delight.core.other.ADConstants;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectUtils;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class NectarItem extends EffectDrinkItem {

	public NectarItem(Properties properties) {
		super(null, properties, ADConstants.ATMOSPHERIC);
	}

	@Override
	public void affectConsumer(ItemStack stack, World worldIn, LivingEntity consumer) {
		if (!worldIn.isClientSide() && ForgeRegistries.POTIONS.getValue(ADConstants.RELIEF) != null)
			consumer.addEffect(new EffectInstance(ForgeRegistries.POTIONS.getValue(ADConstants.RELIEF), 300));
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (ForgeRegistries.POTIONS.getValue(ADConstants.RELIEF) != null) {
			Effect effect = ForgeRegistries.POTIONS.getValue(ADConstants.RELIEF);
			IFormattableTextComponent component = new TranslationTextComponent(effect.getDescriptionId());
			component = new TranslationTextComponent("potion.withDuration", component, EffectUtils.formatDuration(new EffectInstance(effect, 300), 1.0F));
			tooltip.add(component.withStyle(effect.getCategory().getTooltipFormatting()));
		}
	}
}