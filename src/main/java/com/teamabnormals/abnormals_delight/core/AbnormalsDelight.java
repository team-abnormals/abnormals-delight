package com.teamabnormals.abnormals_delight.core;

import com.teamabnormals.abnormals_delight.core.data.client.ADBlockStateProvider;
import com.teamabnormals.abnormals_delight.core.data.client.ADItemModelProvider;
import com.teamabnormals.abnormals_delight.core.data.client.ADLanguageProvider;
import com.teamabnormals.abnormals_delight.core.data.server.ADLootTableProvider;
import com.teamabnormals.abnormals_delight.core.data.server.tags.ADBlockTagsProvider;
import com.teamabnormals.abnormals_delight.core.data.server.tags.ADItemTagsProvider;
import com.teamabnormals.abnormals_delight.core.other.ADCompat;
import com.teamabnormals.abnormals_delight.core.registry.ADModifications;
import com.teamabnormals.abnormals_delight.core.registry.util.ADItemSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(AbnormalsDelight.MOD_ID)
public class AbnormalsDelight {
	public static final String MOD_ID = "abnormals_delight";
	public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MOD_ID, helper -> helper.putSubHelper(ForgeRegistries.ITEMS, new ADItemSubRegistryHelper(helper)));

	public AbnormalsDelight() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext context = ModLoadingContext.get();

		REGISTRY_HELPER.register(bus);
		MinecraftForge.EVENT_BUS.register(this);

		bus.addListener(this::commonSetup);
		bus.addListener(this::dataSetup);

		context.registerConfig(ModConfig.Type.COMMON, ADConfig.COMMON_SPEC);
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ADCompat.registerCompat();
			ADModifications.makeModifications();
		});
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		if (event.includeServer()) {
			ADBlockTagsProvider blockTags = new ADBlockTagsProvider(generator, existingFileHelper);
			generator.addProvider(blockTags);
			generator.addProvider(new ADItemTagsProvider(generator, blockTags, existingFileHelper));
			generator.addProvider(new ADLootTableProvider(generator));
		}

		if (event.includeClient()) {
			generator.addProvider(new ADBlockStateProvider(generator, existingFileHelper));
			generator.addProvider(new ADItemModelProvider(generator, existingFileHelper));
			generator.addProvider(new ADLanguageProvider(generator));
		}
	}
}