package com.minecraftabnormals.abnormals_delight.core.other;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import com.minecraftabnormals.abnormals_delight.core.registry.ADItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import vectorwing.farmersdelight.utils.tags.ModTags;

import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = AbnormalsDelight.MOD_ID)
public class ADEvents {
	public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, 9);
	public static final HashMap<ResourceLocation, Supplier<Item>> CAKES = Util.make(Maps.newHashMap(), (list) -> {
		list.put(ADConstants.VANILLA_CAKE, ADItems.VANILLA_CAKE_SLICE);
		list.put(ADConstants.CHOCOLATE_CAKE, ADItems.CHOCOLATE_CAKE_SLICE);
		list.put(ADConstants.STRAWBERRY_CAKE, ADItems.STRAWBERRY_CAKE_SLICE);
		list.put(ADConstants.BANANA_CAKE, ADItems.BANANA_CAKE_SLICE);
		list.put(ADConstants.MINT_CAKE, ADItems.MINT_CAKE_SLICE);
		list.put(ADConstants.ADZUKI_CAKE, ADItems.ADZUKI_CAKE_SLICE);
	});

	@SubscribeEvent
	public static void onCakeInteraction(PlayerInteractEvent.RightClickBlock event) {
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		BlockState state = event.getWorld().getBlockState(pos);
		ItemStack tool = event.getPlayer().getItemInHand(event.getHand());
		ResourceLocation name = state.getBlock().getRegistryName();

		if (ModTags.KNIVES.contains(tool.getItem()) && name != null) {
			if (CAKES.containsKey(name)) {
				Supplier<Item> item = CAKES.get(name);
				int bites = state.getValue(CakeBlock.BITES);
				if (bites < 6) {
					world.setBlock(pos, state.setValue(CakeBlock.BITES, bites + 1), 3);
				} else {
					world.removeBlock(pos, false);
				}
				InventoryHelper.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(item.get()));
				world.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundCategory.PLAYERS, 0.8F, 0.8F);

				event.setCancellationResult(ActionResultType.SUCCESS);
				event.setCanceled(true);
			}

			if (name.equals(ADConstants.YUCCA_GATEAU)) {
				int bites = state.getValue(BITES);
				if (bites < 9) {
					world.setBlock(pos, state.setValue(BITES, bites + 1), 3);
				} else {
					world.removeBlock(pos, false);
				}
				InventoryHelper.dropItemStack(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ADItems.YUCCA_GATEAU_SLICE.get()));
				world.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundCategory.PLAYERS, 0.8F, 0.8F);

				event.setCancellationResult(ActionResultType.SUCCESS);
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		BlockState state = event.getState();
		PlayerEntity player = event.getPlayer();
		List<ItemStack> loot = Lists.newArrayList();
		ResourceLocation name = state.getBlock().getRegistryName();

		if (player.getMainHandItem().getItem().is(ModTags.KNIVES) && name != null) {
			if (CAKES.containsKey(name)) {
				Supplier<Item> item = CAKES.get(name);
				loot.add(new ItemStack(item.get(), 7 - state.getValue(CakeBlock.BITES)));
			} else if (name.equals(ADConstants.YUCCA_GATEAU)) {
				loot.add(new ItemStack(ADItems.YUCCA_GATEAU_SLICE.get(), 10 - state.getValue(BITES)));
			}

			if (!loot.isEmpty() && event.getWorld() instanceof World) {
				for (ItemStack stack : loot) {
					Block.popResource((World) event.getWorld(), event.getPos(), stack);
				}
			}
		}
	}
}
