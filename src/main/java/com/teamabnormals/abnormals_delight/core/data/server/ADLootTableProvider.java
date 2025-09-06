package com.teamabnormals.abnormals_delight.core.data.server;

import com.google.common.collect.ImmutableList;
import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.stream.Collectors;

public class ADLootTableProvider extends LootTableProvider {

	public ADLootTableProvider(PackOutput output) {
		super(output, BuiltInLootTables.all(), ImmutableList.of(new LootTableProvider.SubProviderEntry(BlockProvider::new, LootContextParamSets.BLOCK)));
	}

	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext context) {
	}

	private static class BlockProvider extends VanillaBlockLoot {

		protected BlockProvider() {
			super();
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
		protected Iterable<Block> getKnownBlocks() {
			return ForgeRegistries.BLOCKS.getValues().stream().filter(block -> ForgeRegistries.BLOCKS.getKey(block) != null && AbnormalsDelight.MOD_ID.equals(ForgeRegistries.BLOCKS.getKey(block).getNamespace())).collect(Collectors.toSet());
		}
	}
}