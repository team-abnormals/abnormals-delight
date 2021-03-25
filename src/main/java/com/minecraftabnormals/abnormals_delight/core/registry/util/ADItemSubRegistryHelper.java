package com.minecraftabnormals.abnormals_delight.core.registry.util;

import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.minecraftabnormals.abnormals_delight.common.item.CompatConsumableItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import vectorwing.farmersdelight.items.ConsumableItem;

public class ADItemSubRegistryHelper extends ItemSubRegistryHelper {

	public ADItemSubRegistryHelper(RegistryHelper parent) {
		super(parent, parent.getItemSubHelper().getDeferredRegister());
	}

	public RegistryObject<Item> createCompatConsumableItem(String name, Item.Properties properties, ItemGroup group, String... modIds) {
		return this.deferredRegister.register(name, () -> new ConsumableItem(properties.group(areModsLoaded(modIds) ? group : null)));
	}

	public RegistryObject<Item> createCompatContainerConsumableItem(String name, ResourceLocation item, Item.Properties properties, ItemGroup group, String... modIds) {
		return this.deferredRegister.register(name, () -> new CompatConsumableItem(item, properties.group(areModsLoaded(modIds) ? group : null)));
	}
}