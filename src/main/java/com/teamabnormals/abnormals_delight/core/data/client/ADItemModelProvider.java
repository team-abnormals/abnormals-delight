package com.teamabnormals.abnormals_delight.core.data.client;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import vectorwing.farmersdelight.FarmersDelight;

public class ADItemModelProvider extends ItemModelProvider {

	public ADItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
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
		this.generated(ADItems.PASSION_FRUIT_GLAZED_DUCK.get());
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

	private void generated(ItemLike item) {
		this.model(item, "generated");
	}

	private void handheld(ItemLike item) {
		this.model(item, "handheld");
	}

	private void mug(ItemLike item) {
		ResourceLocation name = ForgeRegistries.ITEMS.getKey(item.asItem());
		if (name != null)
			this.getBuilder(name.getPath()).parent(new UncheckedModelFile(new ResourceLocation(FarmersDelight.MODID, "item/mug"))).texture("layer0", new ResourceLocation(this.modid, "item/" + name.getPath()));
	}

	private void model(ItemLike item, String parent) {
		ResourceLocation name = ForgeRegistries.ITEMS.getKey(item.asItem());
		if (name != null)
			this.withExistingParent(name.getPath(), "item/" + parent).texture("layer0", new ResourceLocation(this.modid, "item/" + name.getPath()));
	}
}