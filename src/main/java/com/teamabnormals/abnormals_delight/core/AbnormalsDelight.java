package com.teamabnormals.abnormals_delight.core;

import com.teamabnormals.abnormals_delight.core.data.client.ADBlockStateProvider;
import com.teamabnormals.abnormals_delight.core.data.client.ADItemModelProvider;
import com.teamabnormals.abnormals_delight.core.data.client.ADLanguageProvider;
import com.teamabnormals.abnormals_delight.core.data.server.ADLootTableProvider;
import com.teamabnormals.abnormals_delight.core.data.server.modifiers.ADAdvancementModifierProvider;
import com.teamabnormals.abnormals_delight.core.data.server.tags.ADBlockTagsProvider;
import com.teamabnormals.abnormals_delight.core.data.server.tags.ADEntityTypeTagsProvider;
import com.teamabnormals.abnormals_delight.core.data.server.tags.ADItemTagsProvider;
import com.teamabnormals.abnormals_delight.core.other.ADCompat;
import com.teamabnormals.abnormals_delight.core.registry.ADItems;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.concurrent.CompletableFuture;

@Mod(AbnormalsDelight.MOD_ID)
public class AbnormalsDelight {
	public static final String MOD_ID = "abnormals_delight";
	public static final RegistryHelper REGISTRY_HELPER = new RegistryHelper(MOD_ID);

	public AbnormalsDelight() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext context = ModLoadingContext.get();

		REGISTRY_HELPER.register(bus);
		MinecraftForge.EVENT_BUS.register(this);

		bus.addListener(this::commonSetup);
		bus.addListener(this::dataSetup);

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
			ADItems.setupTabEditors();
		});

		context.registerConfig(ModConfig.Type.COMMON, ADConfig.COMMON_SPEC);
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ADCompat.registerCompat();
		});
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		CompletableFuture<Provider> provider = event.getLookupProvider();
		ExistingFileHelper helper = event.getExistingFileHelper();

		boolean includeServer = event.includeServer();
		ADBlockTagsProvider blockTags = new ADBlockTagsProvider(output, provider, helper);
		generator.addProvider(includeServer, blockTags);
		generator.addProvider(includeServer, new ADItemTagsProvider(output, provider, blockTags.contentsGetter(), helper));
		generator.addProvider(includeServer, new ADEntityTypeTagsProvider(output, provider, helper));
		generator.addProvider(includeServer, new ADLootTableProvider(output));
		generator.addProvider(includeServer, new ADAdvancementModifierProvider(output, provider));
//		generator.addProvider(includeServer, new ADLootModifierProvider(output));

		boolean includeClient = event.includeClient();
		generator.addProvider(includeClient, new ADBlockStateProvider(output, helper));
		generator.addProvider(includeClient, new ADItemModelProvider(output, helper));
		generator.addProvider(includeClient, new ADLanguageProvider(output));
	}
}