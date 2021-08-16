package com.minecraftabnormals.abnormals_delight.core;

import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.minecraftabnormals.abnormals_delight.core.data.*;
import com.minecraftabnormals.abnormals_delight.core.other.ADCompat;
import com.minecraftabnormals.abnormals_delight.core.registry.ADModifications;
import com.minecraftabnormals.abnormals_delight.core.registry.util.ADItemSubRegistryHelper;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(AbnormalsDelight.MOD_ID)
public class AbnormalsDelight {
	public static final String MOD_ID = "abnormals_delight";
	public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MOD_ID, helper -> {
		helper.putSubHelper(ForgeRegistries.ITEMS, new ADItemSubRegistryHelper(helper));
	});

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
			ADCompat.registerCompostables();
			ADModifications.modifyCookies();
			ADModifications.replaceItemGroups();
		});
	}

	private void dataSetup(GatherDataEvent event) {
		DataGenerator dataGenerator = event.getGenerator();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

		if (event.includeServer()) {
			BlockTagGenerator blockTagGen = new BlockTagGenerator(dataGenerator, existingFileHelper);
			dataGenerator.addProvider(blockTagGen);
			dataGenerator.addProvider(new ItemTagGenerator(dataGenerator, blockTagGen, existingFileHelper));
			dataGenerator.addProvider(new LootTableGenerator(dataGenerator));
		}

		if (event.includeClient()) {
			dataGenerator.addProvider(new BlockModelGenerator(dataGenerator, existingFileHelper));
			dataGenerator.addProvider(new ItemModelGenerator(dataGenerator, existingFileHelper));
			dataGenerator.addProvider(new LanguageGenerator(dataGenerator));
		}
	}
}