package com.teamabnormals.abnormals_delight.core.other;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.teamabnormals.abnormals_delight.common.item.SlabdishItem;
import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.tags.ADBlockTags;
import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.common.registry.ModParticleTypes;
import vectorwing.farmersdelight.common.tag.ModTags;
import vectorwing.farmersdelight.common.utility.ItemUtils;
import vectorwing.farmersdelight.common.utility.MathUtils;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

@EventBusSubscriber(modid = AbnormalsDelight.MOD_ID)
public class ADEvents {
	public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 9);

	public static final HashMap<Supplier<Item>, ResourceLocation> SLICES_TO_CAKES = Util.make(Maps.newHashMap(), (list) -> {
		list.put(ADItems.VANILLA_CAKE_SLICE, ADConstants.VANILLA_CAKE);
		list.put(ADItems.CHOCOLATE_CAKE_SLICE, ADConstants.CHOCOLATE_CAKE);
		list.put(ADItems.STRAWBERRY_CAKE_SLICE, ADConstants.STRAWBERRY_CAKE);
		list.put(ADItems.BANANA_CAKE_SLICE, ADConstants.BANANA_CAKE);
		list.put(ADItems.MINT_CAKE_SLICE, ADConstants.MINT_CAKE);
		list.put(ADItems.ADZUKI_CAKE_SLICE, ADConstants.ADZUKI_CAKE);
	});

	public static final HashMap<TagKey<Block>, Supplier<Item>> TAGS_TO_SLICES = Util.make(Maps.newHashMap(), (list) -> {
		list.put(ADBlockTags.DROPS_VANILLA_CAKE_SLICE, ADItems.VANILLA_CAKE_SLICE);
		list.put(ADBlockTags.DROPS_CHOCOLATE_CAKE_SLICE, ADItems.CHOCOLATE_CAKE_SLICE);
		list.put(ADBlockTags.DROPS_STRAWBERRY_CAKE_SLICE, ADItems.STRAWBERRY_CAKE_SLICE);
		list.put(ADBlockTags.DROPS_BANANA_CAKE_SLICE, ADItems.BANANA_CAKE_SLICE);
		list.put(ADBlockTags.DROPS_MINT_CAKE_SLICE, ADItems.MINT_CAKE_SLICE);
		list.put(ADBlockTags.DROPS_ADZUKI_CAKE_SLICE, ADItems.ADZUKI_CAKE_SLICE);
	});

	public static Supplier<Item> getCakeSlice(BlockState state) {
		TagKey<Block> cakeTag = ADBlockTags.DROPS_FLAVORED_CAKE_SLICE;
		for (TagKey<Block> tagKey : TAGS_TO_SLICES.keySet()) {
			if (state.is(tagKey)) {
				cakeTag = tagKey;
			}
		}

		return TAGS_TO_SLICES.get(cakeTag);
	}

	@SubscribeEvent
	public static void onCakeInteraction(PlayerInteractEvent.RightClickBlock event) {
		Level level = event.getLevel();
		BlockPos pos = event.getPos();
		BlockState state = level.getBlockState(pos);
		ItemStack tool = event.getEntity().getItemInHand(event.getHand());
		ResourceLocation name = ForgeRegistries.BLOCKS.getKey(state.getBlock());

		if (tool.is(ModTags.KNIVES) && name != null) {
			if (state.is(ADBlockTags.DROPS_FLAVORED_CAKE_SLICE)) {
				Supplier<Item> cakeSlice = getCakeSlice(state);
				float offset = 0.0F;
				if (state.hasProperty(CakeBlock.BITES)) {
					int bites = state.getValue(CakeBlock.BITES);
					offset = bites * 0.1F;
					if (bites < 6) {
						level.setBlock(pos, state.setValue(CakeBlock.BITES, bites + 1), 3);
					} else {
						level.removeBlock(pos, false);
					}
				} else {
					level.setBlock(pos, ForgeRegistries.BLOCKS.getValue(SLICES_TO_CAKES.get(cakeSlice)).defaultBlockState().setValue(CakeBlock.BITES, 1), 3);
					Block.dropResources(state, level, pos);
				}

				ItemUtils.spawnItemEntity(level, new ItemStack(cakeSlice.get()), pos.getX() + offset, pos.getY() + 0.2F, pos.getZ() + 0.5F, -0.05F, 0.0F, 0.0F);
				level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
				event.setCancellationResult(InteractionResult.SUCCESS);
				event.setCanceled(true);
			} else if (name.equals(ADConstants.YUCCA_GATEAU)) {
				int bites = state.getValue(BITES);
				if (bites < 9) {
					level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
				} else {
					level.removeBlock(pos, false);
				}

				ItemUtils.spawnItemEntity(level, new ItemStack(ADItems.YUCCA_GATEAU_SLICE.get()), pos.getX() + (bites * 0.075F), pos.getY() + 0.2F, pos.getZ() + 0.5F, -0.05F, 0.0F, 0.0F);
				level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);

				event.setCancellationResult(InteractionResult.SUCCESS);
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		BlockState state = event.getState();
		Player player = event.getPlayer();
		List<ItemStack> loot = Lists.newArrayList();
		ResourceLocation name = ForgeRegistries.BLOCKS.getKey(state.getBlock());

		if (player.getMainHandItem().is(ModTags.KNIVES) && name != null) {
			if (state.is(ADBlockTags.DROPS_FLAVORED_CAKE_SLICE)) {
				Supplier<Item> cakeSlice = getCakeSlice(state);
				int subtraction = !state.hasProperty(CakeBlock.BITES) ? 0 : state.getValue(CakeBlock.BITES);
				loot.add(new ItemStack(cakeSlice.get(), 7 - subtraction));
			} else if (name.equals(ADConstants.YUCCA_GATEAU)) {
				loot.add(new ItemStack(ADItems.YUCCA_GATEAU_SLICE.get(), 10 - state.getValue(BITES)));
			}

			if (!loot.isEmpty() && event.getLevel() instanceof Level) {
				for (ItemStack stack : loot) {
					Block.popResource((Level) event.getLevel(), event.getPos(), stack);
				}
			}
		}
	}

	@SubscribeEvent
	public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
		Player player = event.getEntity();
		Entity target = event.getTarget();
		ItemStack stack = event.getItemStack();

		if (target instanceof TamableAnimal entity && ForgeRegistries.ENTITY_TYPES.getKey(target.getType()).equals(ADConstants.SLABFISH)) {
			if (entity.isAlive() && entity.isTame() && stack.getItem().equals(ADItems.SLABDISH.get())) {
				entity.setHealth(entity.getMaxHealth());
				for (MobEffectInstance effect : SlabdishItem.EFFECTS) {
					entity.addEffect(new MobEffectInstance(effect));
				}
				entity.level.playSound(null, target.blockPosition(), SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);

				for (int i = 0; i < 5; ++i) {
					double d0 = MathUtils.RAND.nextGaussian() * 0.02D;
					double d1 = MathUtils.RAND.nextGaussian() * 0.02D;
					double d2 = MathUtils.RAND.nextGaussian() * 0.02D;
					entity.level.addParticle(ModParticleTypes.STAR.get(), entity.getRandomX(1.0D), entity.getRandomY() + 0.5D, entity.getRandomZ(1.0D), d0, d1, d2);
				}

				if (stack.getCraftingRemainingItem() != ItemStack.EMPTY && !player.isCreative()) {
					player.addItem(stack.getCraftingRemainingItem());
					stack.shrink(1);
				}

				event.setCancellationResult(InteractionResult.SUCCESS);
				event.setCanceled(true);
			}
		}
	}
}
