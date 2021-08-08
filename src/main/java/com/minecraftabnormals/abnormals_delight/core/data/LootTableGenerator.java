package com.minecraftabnormals.abnormals_delight.core.data;

import com.google.common.collect.ImmutableList;
import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import com.minecraftabnormals.abnormals_delight.core.registry.ADBlocks;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ForgeLootTableProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LootTableGenerator extends ForgeLootTableProvider {
	private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> tables = ImmutableList.of(Pair.of(BlockProvider::new, LootParameterSets.BLOCK));

	public LootTableGenerator(DataGenerator generator) {
		super(generator);
	}

	@Override
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables() {
		return tables;
	}

	private static class BlockProvider extends BlockLootTables {

		@Override
		protected void addTables() {
			this.add(ADBlocks.ROSEWOOD_PANTRY.get(), BlockLootTables::createNameableBlockEntityTable);
			this.add(ADBlocks.MORADO_PANTRY.get(), BlockLootTables::createNameableBlockEntityTable);
			this.add(ADBlocks.YUCCA_PANTRY.get(), BlockLootTables::createNameableBlockEntityTable);
			this.add(ADBlocks.KOUSA_PANTRY.get(), BlockLootTables::createNameableBlockEntityTable);
			this.add(ADBlocks.ASPEN_PANTRY.get(), BlockLootTables::createNameableBlockEntityTable);
			this.add(ADBlocks.GRIMWOOD_PANTRY.get(), BlockLootTables::createNameableBlockEntityTable);
			this.add(ADBlocks.MAPLE_PANTRY.get(), BlockLootTables::createNameableBlockEntityTable);
			this.add(ADBlocks.POISE_PANTRY.get(), BlockLootTables::createNameableBlockEntityTable);
			this.add(ADBlocks.WILLOW_PANTRY.get(), BlockLootTables::createNameableBlockEntityTable);
			this.add(ADBlocks.CHERRY_PANTRY.get(), BlockLootTables::createNameableBlockEntityTable);
			this.add(ADBlocks.WISTERIA_PANTRY.get(), BlockLootTables::createNameableBlockEntityTable);
			this.add(ADBlocks.DRIFTWOOD_PANTRY.get(), BlockLootTables::createNameableBlockEntityTable);
			this.add(ADBlocks.RIVER_PANTRY.get(), BlockLootTables::createNameableBlockEntityTable);
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> block.getRegistryName() != null && AbnormalsDelight.MOD_ID.equals(block.getRegistryName().getNamespace())).collect(Collectors.toSet());
		}
	}
}