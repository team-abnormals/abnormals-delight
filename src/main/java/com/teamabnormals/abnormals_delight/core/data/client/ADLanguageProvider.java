package com.teamabnormals.abnormals_delight.core.data.client;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.text.WordUtils;

public class ADLanguageProvider extends LanguageProvider {

	public ADLanguageProvider(PackOutput output) {
		super(output, AbnormalsDelight.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		this.add(ADBlocks.ROSEWOOD_CABINET.get());
		this.add(ADBlocks.MORADO_CABINET.get());
		this.add(ADBlocks.YUCCA_CABINET.get());
		this.add(ADBlocks.KOUSA_CABINET.get());
		this.add(ADBlocks.ASPEN_CABINET.get());
		this.add(ADBlocks.LAUREL_CABINET.get());
		this.add(ADBlocks.GRIMWOOD_CABINET.get());
		this.add(ADBlocks.MAPLE_CABINET.get());
		this.add(ADBlocks.AZALEA_CABINET.get());
		this.add(ADBlocks.POISE_CABINET.get());
		this.add(ADBlocks.WILLOW_CABINET.get());
		this.add(ADBlocks.PLUM_CABINET.get());
		this.add(ADBlocks.WISTERIA_CABINET.get());
		this.add(ADBlocks.PINE_CABINET.get());
		this.add(ADBlocks.DRIFTWOOD_CABINET.get());
		this.add(ADBlocks.RIVER_CABINET.get());

		this.add(ADItems.SILVER_KNIFE.get());
		this.add(ADItems.NECROMIUM_KNIFE.get());

		this.addRaw(ADItems.DUCK_FILLET.get());
		this.add(ADItems.COOKED_DUCK_FILLET.get());
		this.addRaw(ADItems.VENISON_SHANKS.get());
		this.add(ADItems.COOKED_VENISON_SHANKS.get());
		this.addRaw(ADItems.PIKE_SLICE.get());
		this.add(ADItems.COOKED_PIKE_SLICE.get());
		this.addRaw(ADItems.PERCH_SLICE.get());
		this.add(ADItems.COOKED_PERCH_SLICE.get());

		this.add(ADItems.CHERRY_COOKIE.get());
		this.add(ADItems.MULBERRY_COOKIE.get());
		this.add(ADItems.MAPLE_COOKIE.get());

		this.add(ADItems.SEARED_VENISON.get());
		this.add(ADItems.PASSION_FRUIT_GLAZED_DUCK.get());
		this.add(ADItems.DUNE_PLATTER.get());
		this.add(ADItems.DUCK_NOODLES.get());
		this.add(ADItems.PERCH_WITH_MUSHROOMS.get());
		this.add(ADItems.PIKE_WITH_BEETROOT.get());
		this.add(ADItems.VENISON_WITH_BAMBOO_SHOOTS.get());

		this.add(ADItems.ESCARGOT.get());
		this.add(ADItems.MAPLE_GLAZED_BACON.get());
		this.add(ADItems.SLABDISH.get());

		this.add(ADItems.CHERRY_CREAM_SODA.get());
		this.add(ADItems.PASSION_ALOE_NECTAR.get());
		this.add(ADItems.PICKERELWEED_JUICE.get());

		this.addSlice(ADItems.VANILLA_CAKE_SLICE.get());
		this.addSlice(ADItems.CHOCOLATE_CAKE_SLICE.get());
		this.addSlice(ADItems.STRAWBERRY_CAKE_SLICE.get());
		this.addSlice(ADItems.BANANA_CAKE_SLICE.get());
		this.addSlice(ADItems.MINT_CAKE_SLICE.get());
		this.addSlice(ADItems.ADZUKI_CAKE_SLICE.get());
		this.addSlice(ADItems.YUCCA_GATEAU_SLICE.get());

		this.add("itemGroup." + AbnormalsDelight.MOD_ID, "Farmer's Delight");
		this.add("tooltip." + AbnormalsDelight.MOD_ID + ".slabdish.when_feeding", "When fed to a tamed Slabfish:");
	}

	private void add(Item item) {
		this.add(item, format(ForgeRegistries.ITEMS.getKey(item)));
	}

	private void addRaw(Item item) {
		this.add(item, "Raw " + format(ForgeRegistries.ITEMS.getKey(item)));
	}

	private void add(Block block) {
		this.add(block, format(ForgeRegistries.BLOCKS.getKey(block)));
	}

	private String format(ResourceLocation registryName) {
		return WordUtils.capitalizeFully(registryName.getPath().replace("_", " ")).replace("With", "with");
	}

	private void addSlice(Item item) {
		if (ForgeRegistries.ITEMS.getKey(item) != null)
			this.add(item, "Slice of " + format(ForgeRegistries.ITEMS.getKey(item)).replace(" Slice", ""));
	}
}