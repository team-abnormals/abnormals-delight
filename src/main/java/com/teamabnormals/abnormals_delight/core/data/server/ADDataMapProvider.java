package com.teamabnormals.abnormals_delight.core.data.server;

import com.teamabnormals.abnormals_delight.core.other.ADConditions;
import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import com.teamabnormals.caverns_and_chasms.core.other.CCDataMaps;
import com.teamabnormals.caverns_and_chasms.core.other.CCDataMaps.OxidizableItem;
import com.teamabnormals.caverns_and_chasms.core.other.CCDataMaps.WaxableItem;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

import static com.teamabnormals.abnormals_delight.core.registry.ADBlocks.*;

public class ADDataMapProvider extends DataMapProvider {

	public ADDataMapProvider(PackOutput output, CompletableFuture<Provider> provider) {
		super(output, provider);
	}

	@Override
	protected void gather(Provider provider) {
		this.builder(NeoForgeDataMaps.FURNACE_FUELS)
				.add(ROSEWOOD_CABINET.getId(), new FurnaceFuel(300), false)
				.add(MORADO_CABINET.getId(), new FurnaceFuel(300), false)
				.add(YUCCA_CABINET.getId(), new FurnaceFuel(300), false)
				.add(KOUSA_CABINET.getId(), new FurnaceFuel(300), false)
				.add(ASPEN_CABINET.getId(), new FurnaceFuel(300), false)
				.add(LAUREL_CABINET.getId(), new FurnaceFuel(300), false)
				.add(GRIMWOOD_CABINET.getId(), new FurnaceFuel(300), false)
				.add(MAPLE_CABINET.getId(), new FurnaceFuel(300), false)
				.add(AZALEA_CABINET.getId(), new FurnaceFuel(300), false)
				.add(POISE_CABINET.getId(), new FurnaceFuel(300), false)
				.add(WILLOW_CABINET.getId(), new FurnaceFuel(300), false)
				.add(WISTERIA_CABINET.getId(), new FurnaceFuel(300), false)
				.add(PLUM_CABINET.getId(), new FurnaceFuel(300), false)
				.add(PINE_CABINET.getId(), new FurnaceFuel(300), false)
				.add(DRIFTWOOD_CABINET.getId(), new FurnaceFuel(300), false)
				.add(RIVER_CABINET.getId(), new FurnaceFuel(300), false)
		;

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

		this.builder(CCDataMaps.OXIDIZABLES)
				.add(ADItems.COPPER_KNIFE, new OxidizableItem(ADItems.EXPOSED_COPPER_KNIFE.get()), false, ADConditions.CAVERNS_AND_CHASMS_LOADED)
				.add(ADItems.EXPOSED_COPPER_KNIFE, new OxidizableItem(ADItems.WEATHERED_COPPER_KNIFE.get()), false, ADConditions.CAVERNS_AND_CHASMS_LOADED)
				.add(ADItems.WEATHERED_COPPER_KNIFE, new OxidizableItem(ADItems.OXIDIZED_COPPER_KNIFE.get()), false, ADConditions.CAVERNS_AND_CHASMS_LOADED);

		this.builder(CCDataMaps.WAXABLES)
				.add(ADItems.COPPER_KNIFE, new WaxableItem(ADItems.WAXED_COPPER_KNIFE.get()), false, ADConditions.CAVERNS_AND_CHASMS_LOADED)
				.add(ADItems.EXPOSED_COPPER_KNIFE, new WaxableItem(ADItems.WAXED_EXPOSED_COPPER_KNIFE.get()), false, ADConditions.CAVERNS_AND_CHASMS_LOADED)
				.add(ADItems.WEATHERED_COPPER_KNIFE, new WaxableItem(ADItems.WAXED_WEATHERED_COPPER_KNIFE.get()), false, ADConditions.CAVERNS_AND_CHASMS_LOADED)
				.add(ADItems.OXIDIZED_COPPER_KNIFE, new WaxableItem(ADItems.OXIDIZED_COPPER_KNIFE.get()), false, ADConditions.CAVERNS_AND_CHASMS_LOADED);
	}
}