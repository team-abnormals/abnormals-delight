package com.minecraftabnormals.abnormals_delight.core.registry.util;

import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import vectorwing.farmersdelight.items.ConsumableItem;

public class ADItemSubRegistryHelper extends ItemSubRegistryHelper {

	public ADItemSubRegistryHelper(RegistryHelper parent) {
		super(parent, parent.getItemSubHelper().getDeferredRegister());
	}

	public RegistryObject<Item> createCompatConsumableItem(String name, Item.Properties properties, ItemGroup group, String... modIds) {
		return this.deferredRegister.register(name, () -> new ConsumableItem(properties.group(areModsLoaded(modIds) ? group : null)));
	}
}