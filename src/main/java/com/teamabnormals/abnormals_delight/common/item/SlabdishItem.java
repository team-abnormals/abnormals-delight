package com.teamabnormals.abnormals_delight.common.item;

import com.google.common.collect.Lists;
import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.ModList;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import javax.annotation.Nullable;
import java.util.List;

public class SlabdishItem extends ConsumableItem {
	public static final List<MobEffectInstance> EFFECTS = Lists.newArrayList(
			new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 1),
			new MobEffectInstance(MobEffects.REGENERATION, 6000),
			new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000),
			new MobEffectInstance(MobEffects.CONFUSION, 6000));

	public SlabdishItem(Properties properties) {
		super(ModList.get().isLoaded(ADConstants.ENVIRONMENTAL) ? properties.tab(CreativeModeTab.TAB_FOOD) : properties);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		MutableComponent whenFeeding = new TranslatableComponent("tooltip." + AbnormalsDelight.MOD_ID + ".slabdish.when_feeding");
		tooltip.add(whenFeeding.withStyle(ChatFormatting.GRAY));

		for (MobEffectInstance effectinstance : EFFECTS) {
			MutableComponent effectDescription = new TextComponent(" ");
			MutableComponent effectName = new TranslatableComponent(effectinstance.getDescriptionId());
			effectDescription.append(effectName);
			MobEffect effect = effectinstance.getEffect();

			if (effectinstance.getAmplifier() > 0) {
				effectDescription.append(" ").append(new TranslatableComponent("potion.potency." + effectinstance.getAmplifier()));
			}

			if (effectinstance.getDuration() > 20) {
				effectDescription.append(" (").append(MobEffectUtil.formatDuration(effectinstance, 1.0F)).append(")");
			}

			tooltip.add(effectDescription.withStyle(effect.getCategory().getTooltipFormatting()));
		}
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player playerIn, LivingEntity target, InteractionHand hand) {
		if (target.getType().getRegistryName().equals(ADConstants.SLABFISH)) {
			TamableAnimal slabfish = (TamableAnimal) target;
			if (slabfish.isAlive() && slabfish.isTame()) {
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}
}
