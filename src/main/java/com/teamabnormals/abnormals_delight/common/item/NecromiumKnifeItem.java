package com.teamabnormals.abnormals_delight.common.item;

import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.blueprint.core.api.BlueprintItemTier;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class NecromiumKnifeItem extends AbnormalsKnifeItem {
	public static final Tier NECROMIUM = new BlueprintItemTier(4, 2251, 9.0F, 3.0F, 12, () -> Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ADConstants.CAVERNS_AND_CHASMS, "necromium_ingot"))));

	public NecromiumKnifeItem() {
		super(NECROMIUM, new Item.Properties().fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
		return super.hurtEnemy(stack, target, attacker);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		if (ModList.get().isLoaded(ADConstants.CAVERNS_AND_CHASMS))
			tooltip.add(Component.translatable("tooltip.caverns_and_chasms.slowing").withStyle(ChatFormatting.GRAY));
	}
}
