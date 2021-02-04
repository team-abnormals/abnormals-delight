package com.minecraftabnormals.abnormals_delight.common.item;

import com.minecraftabnormals.abnormals_core.core.api.AbnormalsItemTier;
import com.minecraftabnormals.abnormals_core.core.util.item.filling.TargetedItemGroupFiller;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.items.KnifeItem;
import vectorwing.farmersdelight.registry.ModItems;

import javax.annotation.Nullable;
import java.util.List;

public class NecromiumKnifeItem extends AbnormalsKnifeItem {
	public static final IItemTier NECROMIUM = new AbnormalsItemTier(4, 2251, 9.0F, 3.0F, 12, () -> Ingredient.fromItems(ForgeRegistries.ITEMS.getValue(new ResourceLocation("caverns_and_chasms", "necromium_ingot"))));

	public NecromiumKnifeItem() {
		super(NECROMIUM, new Item.Properties().isImmuneToFire());
	}

	@Override
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		target.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 60, 1));
		return super.hitEntity(stack, target, attacker);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TranslationTextComponent("tooltip.caverns_and_chasms.slowing").mergeStyle(TextFormatting.GRAY));
	}
}
