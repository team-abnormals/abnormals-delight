package com.teamabnormals.abnormals_delight.core.data.server;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ADLootTableProvider extends LootTableProvider {
	private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> tables = ImmutableList.of(Pair.of(BlockProvider::new, LootContextParamSets.BLOCK));

	public ADLootTableProvider(DataGenerator generator) {
		super(generator);
	}

	@Override
	public List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables() {
		return tables;
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext context) {
	}

	private static class BlockProvider extends BlockLoot {

		@Override
		protected void addTables() {
			this.add(ADBlocks.ROSEWOOD_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
			this.add(ADBlocks.MORADO_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
			this.add(ADBlocks.YUCCA_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
			this.add(ADBlocks.KOUSA_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
			this.add(ADBlocks.ASPEN_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
			this.add(ADBlocks.GRIMWOOD_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
			this.add(ADBlocks.MAPLE_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
			this.add(ADBlocks.AZALEA_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
			this.add(ADBlocks.POISE_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
			this.add(ADBlocks.WILLOW_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
			this.add(ADBlocks.CHERRY_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
			this.add(ADBlocks.WISTERIA_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
			this.add(ADBlocks.DRIFTWOOD_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
			this.add(ADBlocks.RIVER_CABINET.get(), BlockLoot::createNameableBlockEntityTable);
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> ForgeRegistries.BLOCKS.getKey(block) != null && AbnormalsDelight.MOD_ID.equals(ForgeRegistries.BLOCKS.getKey(block).getNamespace())).collect(Collectors.toSet());
		}
	}
}