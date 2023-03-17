package com.teamabnormals.abnormals_delight.core.registry;

import com.google.common.collect.ImmutableSet;
import com.teamabnormals.abnormals_delight.core.ADConfig;
import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.blueprint.core.util.DataUtil;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import vectorwing.farmersdelight.common.block.WildRiceBlock;
import vectorwing.farmersdelight.common.item.KnifeItem;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModEnchantments;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.Set;

public class ADModifications {
	private static final Set<Item> MATERIALS = ImmutableSet.of(ModItems.STRAW.get(), ModItems.CANVAS.get(), ModItems.TREE_BARK.get(), ModItems.CABBAGE_SEEDS.get(), ModItems.TOMATO_SEEDS.get(), ModItems.RICE_PANICLE.get(), ModItems.RICE.get());
	private static final Set<Item> DECORATIONS = ImmutableSet.of(ModItems.STOVE.get(), ModItems.COOKING_POT.get(), ModItems.SKILLET.get(), ModItems.CUTTING_BOARD.get(), ModItems.BEETROOT_CRATE.get(), ModItems.CARROT_CRATE.get(), ModItems.POTATO_CRATE.get(), ModItems.ONION_CRATE.get(), ModItems.CABBAGE_CRATE.get(), ModItems.RICE_BAG.get(), ModItems.TOMATO_CRATE.get(), ModItems.RICE_BALE.get(), ModItems.STRAW_BALE.get(), ModItems.RICH_SOIL_FARMLAND.get(), ModItems.FULL_TATAMI_MAT.get(), ModItems.HALF_TATAMI_MAT.get(), ModItems.BROWN_MUSHROOM_COLONY.get(), ModItems.RED_MUSHROOM_COLONY.get(), ModItems.BASKET.get(), ModItems.SAFETY_NET.get(), ModItems.ROPE.get(), ModItems.CANVAS_RUG.get());
	private static final Set<Item> BUILDING_BLOCKS = ImmutableSet.of(ModItems.ORGANIC_COMPOST.get(), ModItems.RICH_SOIL.get(), ModItems.TATAMI.get());
	private static final Set<Item> FOOD = ImmutableSet.of(ModItems.HORSE_FEED.get(), ModItems.APPLE_PIE.get(), ModItems.SWEET_BERRY_CHEESECAKE.get(), ModItems.CHOCOLATE_PIE.get(), ModItems.HOT_COCOA.get(), ModItems.MILK_BOTTLE.get(), ModItems.APPLE_CIDER.get(), ModItems.MELON_JUICE.get());

	public static void makeModifications() {
		modifyCookies();
		replaceItemGroups();
	}

	public static void modifyCookies() {
		Foods.COOKIE.fastFood = true;
	}

	/*
	 * Very hacky method to filter Farmer's Delight items into vanilla creative tabs
	 * Will likely be removed in the future in favor of a Creative inventory modifying mod
	 */
	public static void replaceItemGroups() {
		if (ADConfig.COMMON.replaceFDItemGroup.get()) {
			CreativeModeTab.TAB_COMBAT.setEnchantmentCategories(DataUtil.concatArrays(CreativeModeTab.TAB_COMBAT.getEnchantmentCategories(), ModEnchantments.KNIFE));
			for (Item item : ForgeRegistries.ITEMS.getValues()) {
				if (item.getItemCategory() == FarmersDelight.CREATIVE_TAB) {
					if (item.isEdible()) setItemGroup(item, CreativeModeTab.TAB_FOOD);
					else if (item instanceof KnifeItem) setItemGroup(item, CreativeModeTab.TAB_COMBAT);
					else if (MATERIALS.contains(item)) setItemGroup(item, CreativeModeTab.TAB_MATERIALS);
					else if (DECORATIONS.contains(item) || item instanceof SignItem)
						setItemGroup(item, CreativeModeTab.TAB_DECORATIONS);
					else if (BUILDING_BLOCKS.contains(item)) setItemGroup(item, CreativeModeTab.TAB_BUILDING_BLOCKS);
					else if (FOOD.contains(item)) setItemGroup(item, CreativeModeTab.TAB_FOOD);
					else if (item instanceof BlockItem) {
						Block block = ((BlockItem) item).getBlock();
						if (block instanceof CabinetBlock || block instanceof WildCropBlock || block instanceof WildRiceBlock) {
							setItemGroup(item, CreativeModeTab.TAB_DECORATIONS);
						} else if (block instanceof FeastBlock) {
							setItemGroup(item, CreativeModeTab.TAB_FOOD);
						}
					}
				}
			}
		} else {
			CreativeModeTab group = new CreativeModeTab(AbnormalsDelight.MOD_ID) {
				@Override
				public ItemStack makeIcon() {
					return new ItemStack(ModBlocks.STOVE.get());
				}
			};
			for (Item item : ForgeRegistries.ITEMS.getValues()) {
				String namespace = ForgeRegistries.ITEMS.getKey(item).getNamespace();
				if (item.getItemCategory() != null && (item.getItemCategory() == FarmersDelight.CREATIVE_TAB || namespace.equals(AbnormalsDelight.MOD_ID))) {
					setItemGroup(item, group);
				}
			}
		}
	}

	private static void setItemGroup(Item item, CreativeModeTab group) {
		ObfuscationReflectionHelper.setPrivateValue(Item.class, item, group, "f_41377_");
	}
}
