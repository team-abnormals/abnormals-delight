package com.teamabnormals.abnormals_delight.core.data.client;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.blueprint.core.data.client.BlueprintItemModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import vectorwing.farmersdelight.FarmersDelight;

import static com.teamabnormals.abnormals_delight.core.registry.ADItems.*;

public class ADItemModelProvider extends BlueprintItemModelProvider {

	public ADItemModelProvider(PackOutput output, ExistingFileHelper helper) {
		super(output, AbnormalsDelight.MOD_ID, helper);
	}

	@Override
	protected void registerModels() {
		this.handheldItem(
				COPPER_KNIFE, EXPOSED_COPPER_KNIFE, WEATHERED_COPPER_KNIFE, OXIDIZED_COPPER_KNIFE,
				WAXED_COPPER_KNIFE, WAXED_EXPOSED_COPPER_KNIFE, WAXED_WEATHERED_COPPER_KNIFE, WAXED_OXIDIZED_COPPER_KNIFE,
				SILVER_KNIFE, NECROMIUM_KNIFE
		);

		this.generatedItem(
				DUCK_FILLET, COOKED_DUCK_FILLET, VENISON_SHANKS, COOKED_VENISON_SHANKS, PIKE_SLICE, COOKED_PIKE_SLICE, PERCH_SLICE, COOKED_PERCH_SLICE,
				CHERRY_COOKIE, MULBERRY_COOKIE, MAPLE_COOKIE,
				SEARED_VENISON, PASSION_FRUIT_GLAZED_DUCK, DUNE_PLATTER, DUCK_NOODLES, PERCH_WITH_MUSHROOMS, PIKE_WITH_BEETROOT, VENISON_WITH_BAMBOO_SHOOTS,
				ESCARGOT, MAPLE_GLAZED_BACON, SLABDISH,
				VANILLA_CAKE_SLICE, CHOCOLATE_CAKE_SLICE, STRAWBERRY_CAKE_SLICE, BANANA_CAKE_SLICE, MINT_CAKE_SLICE, ADZUKI_CAKE_SLICE, YUCCA_GATEAU_SLICE
		);

		this.mug(CHERRY_CREAM_SODA);
		this.mug(PASSION_ALOE_NECTAR);
		this.mug(PICKERELWEED_JUICE);
	}

	private void mug(ItemLike item) {
		ResourceLocation name = BuiltInRegistries.ITEM.getKey(item.asItem());
		this.getBuilder(name.getPath()).parent(new UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(FarmersDelight.MODID, "item/mug"))).texture("layer0", ResourceLocation.fromNamespaceAndPath(this.modid, "item/" + name.getPath()));
	}

	@Override
	public ItemModelBuilder item(DeferredHolder<? extends ItemLike, ?> item, String type) {
		return this.withExistingParent(name(item.get()), "item/" + type).texture("layer0", itemTexture(item.get()).toString().replace("waxed_", ""));
	}
}