package com.minecraftabnormals.abnormals_delight.core.registry;

import com.google.common.collect.ImmutableSet;
import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.minecraftabnormals.abnormals_delight.core.ADConfig;
import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import com.minecraftabnormals.abnormals_delight.core.other.ADCompat;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.FDItemGroup;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.blocks.PantryBlock;
import vectorwing.farmersdelight.blocks.WildPatchBlock;
import vectorwing.farmersdelight.blocks.WildRiceBlock;
import vectorwing.farmersdelight.items.Foods;
import vectorwing.farmersdelight.items.KnifeItem;
import vectorwing.farmersdelight.registry.ModEnchantments;
import vectorwing.farmersdelight.registry.ModItems;

import java.util.Set;

public class ADModifications {
	private static final Set<Item> MATERIALS = ImmutableSet.of(ModItems.STRAW.get(), ModItems.CANVAS.get(), ModItems.TREE_BARK.get(), ModItems.CABBAGE_SEEDS.get(), ModItems.TOMATO_SEEDS.get(), ModItems.RICE_PANICLE.get(), ModItems.RICE.get());
	private static final Set<Item> DECORATIONS = ImmutableSet.of(ModItems.STOVE.get(), ModItems.COOKING_POT.get(), ModItems.CUTTING_BOARD.get(), ModItems.BEETROOT_CRATE.get(), ModItems.CARROT_CRATE.get(), ModItems.POTATO_CRATE.get(), ModItems.ONION_CRATE.get(), ModItems.CABBAGE_CRATE.get(), ModItems.RICE_BAG.get(), ModItems.TOMATO_CRATE.get(), ModItems.RICE_BALE.get(), ModItems.STRAW_BALE.get(), ModItems.RICH_SOIL_FARMLAND.get(), ModItems.FULL_TATAMI_MAT.get(), ModItems.HALF_TATAMI_MAT.get(), ModItems.BROWN_MUSHROOM_COLONY.get(), ModItems.RED_MUSHROOM_COLONY.get(), ModItems.BASKET.get(), ModItems.SAFETY_NET.get(), ModItems.ROPE.get());
	private static final Set<Item> BUILDING_BLOCKS = ImmutableSet.of(ModItems.ORGANIC_COMPOST.get(), ModItems.RICH_SOIL.get(), ModItems.TATAMI.get());
	private static final Set<Item> FOOD = ImmutableSet.of(ModItems.HORSE_FEED.get(), ModItems.ROAST_CHICKEN_BLOCK.get(), ModItems.STUFFED_PUMPKIN_BLOCK.get(), ModItems.HONEY_GLAZED_HAM_BLOCK.get(), ModItems.APPLE_PIE.get(), ModItems.SWEET_BERRY_CHEESECAKE.get(), ModItems.CHOCOLATE_PIE.get(), ModItems.HOT_COCOA.get(), ModItems.MILK_BOTTLE.get());

	public static void modifyCookies() {
		if (!ModList.get().isLoaded(ADCompat.NEAPOLITAN)) {
			ADItems.Foods.COOKIES.saturationModifier = 0.3F;
			Foods.COOKIES.saturationModifier = 0.3F;
		}
	}

	/*
	 * Very hacky method to filter Farmer's Delight items into vanilla creative tabs
	 * Will likely be removed in the future in favor of a Creative inventory modifying mod
	 */
	public static void replaceItemGroups() {
		if (ADConfig.COMMON.replaceFDItemGroup.get()) {
			ItemGroup.TAB_COMBAT.setEnchantmentCategories(DataUtil.add(ItemGroup.TAB_COMBAT.getEnchantmentCategories(), ModEnchantments.KNIFE));
			for (Item item : ForgeRegistries.ITEMS.getValues()) {
				if (item.getRegistryName().getNamespace().equals(FarmersDelight.MODID)) {
					if (item.isEdible()) setItemGroup(item, ItemGroup.TAB_FOOD);
					else if (item instanceof KnifeItem) setItemGroup(item, ItemGroup.TAB_COMBAT);
					else if (MATERIALS.contains(item)) setItemGroup(item, ItemGroup.TAB_MATERIALS);
					else if (DECORATIONS.contains(item)) setItemGroup(item, ItemGroup.TAB_DECORATIONS);
					else if (BUILDING_BLOCKS.contains(item)) setItemGroup(item, ItemGroup.TAB_BUILDING_BLOCKS);
					else if (FOOD.contains(item)) setItemGroup(item, ItemGroup.TAB_FOOD);
					else if (item instanceof BlockItem) {
						Block block = ((BlockItem) item).getBlock();
						if (block instanceof PantryBlock || block instanceof WildPatchBlock || block instanceof WildRiceBlock) {
							setItemGroup(item, ItemGroup.TAB_DECORATIONS);
						}
					}
				}
			}
		} else {
			FDItemGroup group = new FDItemGroup(AbnormalsDelight.MOD_ID);
			for (Item item : ForgeRegistries.ITEMS.getValues()) {
				if (item.getRegistryName().getNamespace().equals(FarmersDelight.MODID)) {
					setItemGroup(item, group);
				}

				if (item.getRegistryName().getNamespace().equals(AbnormalsDelight.MOD_ID) && item.getItemCategory() != null) {
					setItemGroup(item, group);
				}
			}
		}
	}

	private static void setItemGroup(Item item, ItemGroup group) {
		ObfuscationReflectionHelper.setPrivateValue(Item.class, item, group, "field_77701_a");
	}
}
