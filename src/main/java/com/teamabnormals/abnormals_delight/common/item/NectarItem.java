package com.teamabnormals.abnormals_delight.common.item;

import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
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
	public void affectConsumer(ItemStack stack, Level worldIn, LivingEntity consumer) {
		if (!worldIn.isClientSide() && ForgeRegistries.POTIONS.getValue(ADConstants.RELIEF) != null)
			consumer.addEffect(new MobEffectInstance(ForgeRegistries.MOB_EFFECTS.getValue(ADConstants.RELIEF), 300));
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		if (ForgeRegistries.POTIONS.getValue(ADConstants.RELIEF) != null) {
			MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(ADConstants.RELIEF);
			MutableComponent component = new TranslatableComponent(effect.getDescriptionId());
			component = new TranslatableComponent("potion.withDuration", component, MobEffectUtil.formatDuration(new MobEffectInstance(effect, 300), 1.0F));
			tooltip.add(component.withStyle(effect.getCategory().getTooltipFormatting()));
		}
	}
}