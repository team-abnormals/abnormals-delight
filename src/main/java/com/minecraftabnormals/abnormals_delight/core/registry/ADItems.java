package com.minecraftabnormals.abnormals_delight.core.registry;

import com.minecraftabnormals.abnormals_core.core.api.AbnormalsItemTier;
import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.minecraftabnormals.abnormals_delight.common.item.AbnormalsKnifeItem;
import com.minecraftabnormals.abnormals_delight.common.item.NecromiumKnifeItem;
import com.minecraftabnormals.abnormals_delight.common.item.SilverKnifeItem;
import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = AbnormalsDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ADItems {
	public static final ItemSubRegistryHelper HELPER = AbnormalsDelight.REGISTRY_HELPER.getItemSubHelper();

	public static final RegistryObject<Item> SILVER_KNIFE = HELPER.createItem("silver_knife", SilverKnifeItem::new);
	public static final RegistryObject<Item> NECROMIUM_KNIFE = HELPER.createItem("necromium_knife", NecromiumKnifeItem::new);
}