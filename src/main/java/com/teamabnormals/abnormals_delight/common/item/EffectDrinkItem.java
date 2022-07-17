package com.teamabnormals.abnormals_delight.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import javax.annotation.Nullable;
import java.util.List;

public class EffectDrinkItem extends ConsumableItem {
	public MobEffect effect;

	public EffectDrinkItem(MobEffect effect, Properties properties, String modid) {
		super(ModList.get().isLoaded(modid) ? properties.tab(CreativeModeTab.TAB_FOOD) : properties);
		this.effect = effect;
	}

	public void affectConsumer(ItemStack stack, Level worldIn, LivingEntity consumer) {
		super.affectConsumer(stack, worldIn, consumer);
		if (!worldIn.isClientSide() && effect != null)
			consumer.addEffect(new MobEffectInstance(effect, 300));
	}

	public int getUseDuration(ItemStack stack) {
		return 32;
	}

	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.DRINK;
	}

	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		return ItemUtils.startUsingInstantly(worldIn, playerIn, handIn);
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		if (effect != null) {
			MutableComponent component = new TranslatableComponent(effect.getDescriptionId());
			component = new TranslatableComponent("potion.withDuration", component, MobEffectUtil.formatDuration(new MobEffectInstance(effect, 300), 1.0F));
			tooltip.add(component.withStyle(effect.getCategory().getTooltipFormatting()));
		}
	}
}