package com.teamabnormals.abnormals_delight.common.item;

import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;
import java.util.function.Supplier;

public class CakeSliceItem extends Item {
	public Supplier<MobEffectInstance> effect;

	public CakeSliceItem(String modid, ResourceLocation effectName, int duration, Properties properties, CreativeModeTab group) {
		super(ModList.get().isLoaded(modid) ? properties.tab(group) : properties);
		this.effect = () -> new MobEffectInstance(ForgeRegistries.MOB_EFFECTS.getValue(effectName), duration);
	}

	public CakeSliceItem(String modid, Properties properties, CreativeModeTab group) {
		this(modid, null, 0, properties, group);
	}

	public ItemStack finishUsingItem(ItemStack stack, Level worldIn, LivingEntity entityLiving) {
		if (!worldIn.isClientSide && effect != null && effect.get().getEffect() != null)
			entityLiving.addEffect(new MobEffectInstance(effect.get().getEffect(), effect.get().getDuration(), effect.get().getAmplifier()));
		if (this == ADItems.STRAWBERRY_CAKE_SLICE.get())
			applyHealing(1.0F, worldIn, entityLiving);
		return super.finishUsingItem(stack, worldIn, entityLiving);
	}

	public static void applyHealing(float healAmount, LevelAccessor world, LivingEntity entity) {
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
