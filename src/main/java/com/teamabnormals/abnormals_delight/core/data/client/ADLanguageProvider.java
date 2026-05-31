package com.teamabnormals.abnormals_delight.core.data.client;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.blueprint.core.data.client.BlueprintLanguageProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;

import java.util.List;

import static com.teamabnormals.abnormals_delight.core.registry.ADBlocks.*;
import static com.teamabnormals.abnormals_delight.core.registry.ADItems.*;

public class ADLanguageProvider extends BlueprintLanguageProvider {

	public ADLanguageProvider(PackOutput output) {
		super(output, AbnormalsDelight.MOD_ID);
	}

	@Override
	protected void addTranslations() {
		this.add(
				ROSEWOOD_CABINET.get(), MORADO_CABINET.get(), YUCCA_CABINET.get(), KOUSA_CABINET.get(), ASPEN_CABINET.get(), LAUREL_CABINET.get(), GRIMWOOD_CABINET.get(),
				MAPLE_CABINET.get(), AZALEA_CABINET.get(), POISE_CABINET.get(),
				WILLOW_CABINET.get(), PLUM_CABINET.get(), WISTERIA_CABINET.get(), PINE_CABINET.get(),
				DRIFTWOOD_CABINET.get(), RIVER_CABINET.get()
		);

		this.add(
				COPPER_KNIFE.get(), EXPOSED_COPPER_KNIFE.get(), WEATHERED_COPPER_KNIFE.get(), OXIDIZED_COPPER_KNIFE.get(),
				WAXED_COPPER_KNIFE.get(), WAXED_EXPOSED_COPPER_KNIFE.get(), WAXED_WEATHERED_COPPER_KNIFE.get(), WAXED_OXIDIZED_COPPER_KNIFE.get(),
				SILVER_KNIFE.get(), NECROMIUM_KNIFE.get(),
				COOKED_DUCK_FILLET.get(), COOKED_VENISON_SHANKS.get(), COOKED_PIKE_SLICE.get(), COOKED_PERCH_SLICE.get(),
				CHERRY_COOKIE.get(), MULBERRY_COOKIE.get(), MAPLE_COOKIE.get(),
				SEARED_VENISON.get(), PASSION_FRUIT_GLAZED_DUCK.get(), DUNE_PLATTER.get(), DUCK_NOODLES.get(), PERCH_WITH_MUSHROOMS.get(), PIKE_WITH_BEETROOT.get(), VENISON_WITH_BAMBOO_SHOOTS.get(),
				ESCARGOT.get(), MAPLE_GLAZED_BACON.get(), SLABDISH.get(),
				CHERRY_CREAM_SODA.get(), PASSION_ALOE_NECTAR.get(), PICKERELWEED_JUICE.get()
		);

		this.addRaw(DUCK_FILLET.get(), VENISON_SHANKS.get(), PIKE_SLICE.get(), PERCH_SLICE.get());
		this.addSlice(VANILLA_CAKE_SLICE.get(), CHOCOLATE_CAKE_SLICE.get(), STRAWBERRY_CAKE_SLICE.get(), BANANA_CAKE_SLICE.get(), MINT_CAKE_SLICE.get(), ADZUKI_CAKE_SLICE.get(), YUCCA_GATEAU_SLICE.get());

		this.add("itemGroup." + AbnormalsDelight.MOD_ID, "Farmer's Delight");
		this.add("tooltip." + AbnormalsDelight.MOD_ID + ".slabdish.when_feeding", "When fed to a tamed Slabfish:");
	}

	private void addRaw(Item... items) {
		List.of(items).forEach(item -> this.add(item, "Raw " + format(BuiltInRegistries.ITEM.getKey(item))));
	}

	private void addSlice(Item... items) {
		List.of(items).forEach(item -> this.add(item, "Slice of " + format(BuiltInRegistries.ITEM.getKey(item)).replace(" Slice", "")));
	}

	@Override
	public String format(String path) {
		return super.format(path).replace("With", "with");
	}
}