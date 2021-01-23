package com.minecraftabnormals.abnormals_delight.core.registry;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.blocks.*;
import vectorwing.farmersdelight.items.KnifeItem;
import vectorwing.farmersdelight.registry.ModBlocks;
import vectorwing.farmersdelight.registry.ModItems;
import vectorwing.farmersdelight.utils.tags.ModTags;

import java.util.List;
import java.util.Set;

public class ADModifications {
	private static final Set<Item> FOOD = ImmutableSet.of(ModItems.HORSE_FEED.get(), ModItems.ROAST_CHICKEN_BLOCK.get(), ModItems.STUFFED_PUMPKIN_BLOCK.get(), ModItems.HONEY_GLAZED_HAM_BLOCK.get(), ModItems.APPLE_PIE.get(), ModItems.SWEET_BERRY_CHEESECAKE.get(), ModItems.CHOCOLATE_PIE.get(), ModItems.HOT_COCOA.get(), ModItems.MILK_BOTTLE.get());

	public static void replaceItemGroups() {
		for(Item item : ForgeRegistries.ITEMS.getValues()) {
			if (item.getRegistryName().getNamespace().equals(FarmersDelight.MODID)) {
				if (item.isFood()) setItemGroup(item, ItemGroup.FOOD);
				else if (DECORATIONS.contains(item)) setItemGroup(item, ItemGroup.DECORATIONS);
				else if (FOOD.contains(item)) setItemGroup(item, ItemGroup.FOOD);
			}
		}
	}

	private static void setItemGroup(Item item, ItemGroup group) {
		ObfuscationReflectionHelper.setPrivateValue(Item.class, item, group, "field_77701_a");
	}
}
