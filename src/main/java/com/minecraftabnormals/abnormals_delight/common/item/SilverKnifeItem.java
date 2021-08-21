package com.minecraftabnormals.abnormals_delight.common.item;

import com.minecraftabnormals.abnormals_core.core.api.AbnormalsItemTier;
import com.minecraftabnormals.abnormals_delight.core.other.ADConstants;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class SilverKnifeItem extends AbnormalsKnifeItem {
	public static final IItemTier SILVER = new AbnormalsItemTier(0, 111, 7.0F, 0.0F, 17, () -> Ingredient.of(ForgeRegistries.ITEMS.getValue(new ResourceLocation(ADConstants.CAVERNS_AND_CHASMS, "silver_ingot"))));

	public SilverKnifeItem() {
		super(SILVER, new Item.Properties());
	}

	@Override
	public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		Effect affliction = ForgeRegistries.POTIONS.getValue(new ResourceLocation("caverns_and_chasms", "affliction"));
		if (affliction != null && target.isInvertedHealAndHarm())
			target.addEffect(new EffectInstance(affliction, 60));
		return super.hurtEnemy(stack, target, attacker);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if (ModList.get().isLoaded(ADConstants.CAVERNS_AND_CHASMS))
			tooltip.add(new TranslationTextComponent("tooltip.caverns_and_chasms.afflicting").withStyle(TextFormatting.GRAY));
	}
}
