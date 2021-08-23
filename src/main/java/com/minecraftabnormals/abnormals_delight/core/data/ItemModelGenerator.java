package com.minecraftabnormals.abnormals_delight.core.data;

import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import com.minecraftabnormals.abnormals_delight.core.registry.ADItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.FarmersDelight;

public class ItemModelGenerator extends ItemModelProvider {

	public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, AbnormalsDelight.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels() {
		this.handheld(ADItems.SILVER_KNIFE.get());
		this.handheld(ADItems.NECROMIUM_KNIFE.get());

		this.generated(ADItems.DUCK_FILLET.get());
		this.generated(ADItems.COOKED_DUCK_FILLET.get());
		this.generated(ADItems.VENISON_SHANKS.get());
		this.generated(ADItems.COOKED_VENISON_SHANKS.get());
		this.generated(ADItems.PIKE_SLICE.get());
		this.generated(ADItems.COOKED_PIKE_SLICE.get());
		this.generated(ADItems.PERCH_SLICE.get());
		this.generated(ADItems.COOKED_PERCH_SLICE.get());

		this.generated(ADItems.CHERRY_COOKIE.get());
		this.generated(ADItems.MULBERRY_COOKIE.get());
		this.generated(ADItems.MAPLE_COOKIE.get());

		this.generated(ADItems.SEARED_VENISON.get());
		this.generated(ADItems.PASSIONFRUIT_GLAZED_DUCK.get());
		this.generated(ADItems.DUNE_PLATTER.get());
		this.generated(ADItems.DUCK_NOODLES.get());
		this.generated(ADItems.PERCH_WITH_MUSHROOMS.get());
		this.generated(ADItems.PIKE_WITH_BEETROOT.get());
		this.generated(ADItems.VENISON_WITH_BAMBOO_SHOOTS.get());

		this.generated(ADItems.ESCARGOT.get());
		this.generated(ADItems.MAPLE_GLAZED_BACON.get());
		this.generated(ADItems.SLABDISH.get());

		this.mug(ADItems.CHERRY_CREAM_SODA.get());
		this.mug(ADItems.PASSION_ALOE_NECTAR.get());
		this.mug(ADItems.PICKERELWEED_JUICE.get());

		this.generated(ADItems.VANILLA_CAKE_SLICE.get());
		this.generated(ADItems.CHOCOLATE_CAKE_SLICE.get());
		this.generated(ADItems.STRAWBERRY_CAKE_SLICE.get());
		this.generated(ADItems.BANANA_CAKE_SLICE.get());
		this.generated(ADItems.MINT_CAKE_SLICE.get());
		this.generated(ADItems.ADZUKI_CAKE_SLICE.get());
		this.generated(ADItems.YUCCA_GATEAU_SLICE.get());
	}

	private void generated(IItemProvider item) {
		this.model(item, "generated");
	}

	private void handheld(IItemProvider item) {
		this.model(item, "handheld");
	}

	private void mug(IItemProvider item) {
		ResourceLocation name = item.asItem().getRegistryName();
		if (name != null)
			this.getBuilder(name.getPath()).parent(new UncheckedModelFile(new ResourceLocation(FarmersDelight.MODID, "item/mug"))).texture("layer0", new ResourceLocation(this.modid, "item/" + name.getPath()));
	}

	private void model(IItemProvider item, String parent) {
		ResourceLocation name = item.asItem().getRegistryName();
		if (name != null)
			this.withExistingParent(name.getPath(), "item/" + parent).texture("layer0", new ResourceLocation(this.modid, "item/" + name.getPath()));
	}
}