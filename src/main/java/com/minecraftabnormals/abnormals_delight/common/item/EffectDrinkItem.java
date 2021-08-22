package com.minecraftabnormals.abnormals_delight.common.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectUtils;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import vectorwing.farmersdelight.items.ConsumableItem;

import javax.annotation.Nullable;
import java.util.List;

public class EffectDrinkItem extends ConsumableItem {
	public Effect effect;

	public EffectDrinkItem(Effect effect, Properties properties, String modid) {
		super(ModList.get().isLoaded(modid) ? properties.tab(ItemGroup.TAB_FOOD) : properties);
		this.effect = effect;
	}

	public void affectConsumer(ItemStack stack, World worldIn, LivingEntity consumer) {
		super.affectConsumer(stack, worldIn, consumer);
		if (!worldIn.isClientSide() && effect != null)
			consumer.addEffect(new EffectInstance(effect, 300));
	}

	public int getUseDuration(ItemStack stack) {
		return 32;
	}

	public UseAction getUseAnimation(ItemStack stack) {
		return UseAction.DRINK;
	}

	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		return DrinkHelper.useDrink(worldIn, playerIn, handIn);
	}

	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (effect != null) {
			IFormattableTextComponent component = new TranslationTextComponent(effect.getDescriptionId());
			component = new TranslationTextComponent("potion.withDuration", component, EffectUtils.formatDuration(new EffectInstance(effect, 300), 1.0F));
			tooltip.add(component.withStyle(effect.getCategory().getTooltipFormatting()));
		}
	}
}