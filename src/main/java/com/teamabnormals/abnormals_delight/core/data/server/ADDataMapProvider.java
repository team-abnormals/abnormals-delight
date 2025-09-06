package com.teamabnormals.abnormals_delight.core.data.server;

import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ADDataMapProvider extends DataMapProvider {

	public ADDataMapProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(output, provider);
	}

	@Override
	protected void gather(Provider provider) {
		this.builder(NeoForgeDataMaps.COMPOSTABLES)
				.add(ADItems.CHERRY_COOKIE, new Compostable(0.85F), false)
				.add(ADItems.MULBERRY_COOKIE, new Compostable(0.85F), false)
				.add(ADItems.MAPLE_COOKIE, new Compostable(0.85F), false)

				.add(ADItems.VANILLA_CAKE_SLICE, new Compostable(0.85F), false)
				.add(ADItems.CHOCOLATE_CAKE_SLICE, new Compostable(0.85F), false)
				.add(ADItems.STRAWBERRY_CAKE_SLICE, new Compostable(0.85F), false)
				.add(ADItems.BANANA_CAKE_SLICE, new Compostable(0.85F), false)
				.add(ADItems.MINT_CAKE_SLICE, new Compostable(0.85F), false)
				.add(ADItems.ADZUKI_CAKE_SLICE, new Compostable(0.85F), false)
				.add(ADItems.YUCCA_GATEAU_SLICE, new Compostable(0.85F), false);
	}
}