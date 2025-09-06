package com.teamabnormals.abnormals_delight.common.item;

import com.google.common.collect.Lists;
import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.List;

public class SlabdishItem extends ConsumableItem {
	public static final List<MobEffectInstance> EFFECTS = Lists.newArrayList(
			new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 1),
			new MobEffectInstance(MobEffects.REGENERATION, 6000),
			new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000),
			new MobEffectInstance(MobEffects.CONFUSION, 6000));

	public SlabdishItem(Properties properties) {
		super(properties);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
		MutableComponent whenFeeding = Component.translatable("tooltip." + AbnormalsDelight.MOD_ID + ".slabdish.when_feeding");
		tooltip.add(whenFeeding.withStyle(ChatFormatting.GRAY));

		for (MobEffectInstance effectinstance : EFFECTS) {
			MutableComponent effectDescription = Component.literal(" ");
			MutableComponent effectName = Component.translatable(effectinstance.getDescriptionId());
			effectDescription.append(effectName);
			MobEffect effect = effectinstance.getEffect().value();

			if (effectinstance.getAmplifier() > 0) {
				effectDescription.append(" ").append(Component.translatable("potion.potency." + effectinstance.getAmplifier()));
			}

			if (effectinstance.getDuration() > 20) {
				effectDescription.append(" (").append(MobEffectUtil.formatDuration(effectinstance, 1.0F, context.tickRate())).append(")");
			}

			tooltip.add(effectDescription.withStyle(effect.getCategory().getTooltipFormatting()));
		}
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
		if (target instanceof TamableAnimal animal && BuiltInRegistries.ENTITY_TYPE.getKey(target.getType()).equals(ADConstants.SLABFISH)) {
			if (animal.isAlive() && animal.isTame()) {
				return InteractionResult.SUCCESS;
			}
		}
		return InteractionResult.PASS;
	}
}
