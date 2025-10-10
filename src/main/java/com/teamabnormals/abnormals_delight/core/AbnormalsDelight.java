package com.teamabnormals.abnormals_delight.core;

import com.teamabnormals.abnormals_delight.core.data.client.ADBlockStateProvider;
import com.teamabnormals.abnormals_delight.core.data.client.ADItemModelProvider;
import com.teamabnormals.abnormals_delight.core.data.client.ADLanguageProvider;
import com.teamabnormals.abnormals_delight.core.data.server.ADDataMapProvider;
import com.teamabnormals.abnormals_delight.core.data.server.ADGlobalLootModifierProvider;
import com.teamabnormals.abnormals_delight.core.data.server.ADLootTableProvider;
import com.teamabnormals.abnormals_delight.core.data.server.ADRecipeProvider;
import com.teamabnormals.abnormals_delight.core.data.server.modifiers.ADAdvancementModifierProvider;
import com.teamabnormals.abnormals_delight.core.data.server.tags.ADBlockTagsProvider;
import com.teamabnormals.abnormals_delight.core.data.server.tags.ADEntityTypeTagsProvider;
import com.teamabnormals.abnormals_delight.core.data.server.tags.ADItemTagsProvider;
import com.teamabnormals.abnormals_delight.core.registry.ADBlocks;
import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod(AbnormalsDelight.MOD_ID)
public class AbnormalsDelight {
	public static final String MOD_ID = "abnormals_delight";
	public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

	public AbnormalsDelight(IEventBus bus, ModContainer container) {
		ADBlocks.BLOCKS.register(bus);
		ADItems.ITEMS.register(bus);

		bus.addListener(this::commonSetup);
		bus.addListener(this::clientSetup);
		bus.addListener(this::dataSetup);

		container.registerConfig(ModConfig.Type.COMMON, ADConfig.COMMON_SPEC);
	}

	private void commonSetup(FMLCommonSetupEvent event) {
	}

	private void clientSetup(FMLClientSetupEvent event) {
		event.enqueueWork(ADItems::setupTabEditors);
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<Provider> provider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		boolean server = event.includeServer();
		ADBlockTagsProvider blockTags = new ADBlockTagsProvider(output, provider, helper);
		generator.addProvider(server, blockTags);
		generator.addProvider(server, new ADItemTagsProvider(output, provider, blockTags.contentsGetter(), helper));
		generator.addProvider(server, new ADEntityTypeTagsProvider(output, provider, helper));
		generator.addProvider(server, new ADLootTableProvider(output, provider));
		generator.addProvider(server, new ADAdvancementModifierProvider(output, provider));
		generator.addProvider(server, new ADDataMapProvider(output, provider));
		generator.addProvider(server, new ADRecipeProvider(output, provider));
		generator.addProvider(server, new ADGlobalLootModifierProvider(output, provider));

		boolean client = event.includeClient();
		generator.addProvider(client, new ADBlockStateProvider(output, helper));
		generator.addProvider(client, new ADItemModelProvider(output, helper));
		generator.addProvider(client, new ADLanguageProvider(output));
	}

	public static ResourceLocation location(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}