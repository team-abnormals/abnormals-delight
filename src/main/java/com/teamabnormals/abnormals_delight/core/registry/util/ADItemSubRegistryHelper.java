package com.teamabnormals.abnormals_delight.core.registry.util;

import com.teamabnormals.abnormals_delight.common.item.ContainerConsumableItem;
import com.teamabnormals.abnormals_delight.common.item.UseTimeItem;
import com.teamabnormals.blueprint.core.util.registry.ItemSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class ADItemSubRegistryHelper extends ItemSubRegistryHelper {

	public ADItemSubRegistryHelper(RegistryHelper parent) {
		super(parent, parent.getItemSubHelper().getDeferredRegister());
	}

	public RegistryObject<Item> createCompatConsumableItem(String name, Item.Properties properties, CreativeModeTab group, String... modIds) {
		return this.deferredRegister.register(name, () -> new ConsumableItem(properties.tab(areModsLoaded(modIds) ? group : null)));
	}

	public RegistryObject<Item> createCompatUseTimeItem(String name, Item.Properties properties, CreativeModeTab group, String... modIds) {
		return this.deferredRegister.register(name, () -> new UseTimeItem(properties.tab(areModsLoaded(modIds) ? group : null)));
	}

	public RegistryObject<Item> createCompatContainerConsumableItem(String name, ResourceLocation item, Item.Properties properties, CreativeModeTab group, String... modIds) {
		return this.deferredRegister.register(name, () -> new ContainerConsumableItem(item, properties.tab(areModsLoaded(modIds) ? group : null)));
	}
}