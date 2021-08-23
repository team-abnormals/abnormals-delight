package com.minecraftabnormals.abnormals_delight.common.item;

import com.google.common.collect.Lists;
import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import com.minecraftabnormals.abnormals_delight.core.other.ADConstants;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectUtils;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import vectorwing.farmersdelight.items.ConsumableItem;

import javax.annotation.Nullable;
import java.util.List;

public class SlabdishItem extends ConsumableItem {
	public static final List<EffectInstance> EFFECTS = Lists.newArrayList(
			new EffectInstance(Effects.MOVEMENT_SPEED, 6000, 1),
			new EffectInstance(Effects.REGENERATION, 6000),
			new EffectInstance(Effects.FIRE_RESISTANCE, 6000),
			new EffectInstance(Effects.CONFUSION, 6000));

	public SlabdishItem(Properties properties) {
		super(ModList.get().isLoaded(ADConstants.ENVIRONMENTAL) ? properties.tab(ItemGroup.TAB_FOOD) : properties);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		IFormattableTextComponent whenFeeding = new TranslationTextComponent("tooltip." + AbnormalsDelight.MOD_ID + "tamed_slabfish.when_feeding");
		tooltip.add(whenFeeding.withStyle(TextFormatting.GRAY));

		for (EffectInstance effectinstance : EFFECTS) {
			IFormattableTextComponent effectDescription = new StringTextComponent(" ");
			IFormattableTextComponent effectName = new TranslationTextComponent(effectinstance.getDescriptionId());
			effectDescription.append(effectName);
			Effect effect = effectinstance.getEffect();

			if (effectinstance.getAmplifier() > 0) {
				effectDescription.append(" ").append(new TranslationTextComponent("potion.potency." + effectinstance.getAmplifier()));
			}

			if (effectinstance.getDuration() > 20) {
				effectDescription.append(" (").append(EffectUtils.formatDuration(effectinstance, 1.0F)).append(")");
			}

			tooltip.add(effectDescription.withStyle(effect.getCategory().getTooltipFormatting()));
		}
	}

	@Override
	public ActionResultType interactLivingEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
		if (target.getType().getRegistryName().equals(ADConstants.SLABFISH)) {
			TameableEntity slabfish = (TameableEntity) target;
			if (slabfish.isAlive() && slabfish.isTame()) {
				return ActionResultType.SUCCESS;
			}
		}
		return ActionResultType.PASS;
	}
}
