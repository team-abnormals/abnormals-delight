package com.teamabnormals.abnormals_delight.core.data.server;

import com.google.common.collect.ImmutableList;
import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.WritableRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ADLootTableProvider extends LootTableProvider {

	public ADLootTableProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(output, BuiltInLootTables.all(), ImmutableList.of(new LootTableProvider.SubProviderEntry(BlockProvider::new, LootContextParamSets.BLOCK)), provider);
	}

	@Override
	protected void validate(WritableRegistry<LootTable> registry, ValidationContext context, ProblemReporter.Collector collector) {
	}

	private static class BlockProvider extends VanillaBlockLoot {

		protected BlockProvider(Provider provider) {
			super(provider);
		}

		@Override
		protected void generate() {
			this.add(ADBlocks.ROSEWOOD_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.MORADO_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.YUCCA_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.KOUSA_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.ASPEN_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.LAUREL_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.GRIMWOOD_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.MAPLE_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.AZALEA_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.POISE_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.WILLOW_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.PLUM_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.WISTERIA_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.PINE_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.DRIFTWOOD_CABINET.get(), this::createNameableBlockEntityTable);
			this.add(ADBlocks.RIVER_CABINET.get(), this::createNameableBlockEntityTable);
		}

		@Override
		public Iterable<Block> getKnownBlocks() {
			return BuiltInRegistries.BLOCK.stream().filter(block -> BuiltInRegistries.BLOCK.getKey(block).getNamespace().equals(AbnormalsDelight.MOD_ID)).collect(Collectors.toSet());
		}

	}
}