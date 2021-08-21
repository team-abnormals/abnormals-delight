package com.minecraftabnormals.abnormals_delight.common.item;

import com.minecraftabnormals.abnormals_delight.core.registry.ADItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;
import java.util.function.Supplier;

public class CakeSliceItem extends Item {
	public Supplier<EffectInstance> effect;

	public CakeSliceItem(String modid, ResourceLocation effectName, int duration, Properties properties, ItemGroup group) {
		super(ModList.get().isLoaded(modid) ? properties.tab(group) : properties);
		this.effect = () -> new EffectInstance(ForgeRegistries.POTIONS.getValue(effectName), duration);
	}

	public CakeSliceItem(String modid, Properties properties, ItemGroup group) {
		this(modid, null, 0, properties, group);
	}

	public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		if (!worldIn.isClientSide && effect != null && effect.get().getEffect() != null)
			entityLiving.addEffect(new EffectInstance(effect.get().getEffect(), effect.get().getDuration(), effect.get().getAmplifier()));
		if (this == ADItems.STRAWBERRY_CAKE_SLICE.get())
			applyHealing(1.0F, worldIn, entityLiving);
		return super.finishUsingItem(stack, worldIn, entityLiving);
	}

	public static void applyHealing(float healAmount, IWorld world, LivingEntity entity) {
		entity.heal(healAmount);
		Random rand = entity.getRandom();
		if (world.isClientSide()) {
			int times = 2 * Math.round(healAmount);
			for (int i = 0; i < times; ++i) {
				double d0 = rand.nextGaussian() * 0.02D;
				double d1 = rand.nextGaussian() * 0.02D;
				double d2 = rand.nextGaussian() * 0.02D;
				world.addParticle(ParticleTypes.HEART, entity.getRandomX(1.0D), entity.getRandomY() + 0.5D, entity.getRandomZ(1.0D), d0, d1, d2);
			}
		}
	}
}
