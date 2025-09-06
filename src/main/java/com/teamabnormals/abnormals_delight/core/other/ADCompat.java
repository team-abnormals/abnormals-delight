package com.teamabnormals.abnormals_delight.core.other;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

@EventBusSubscriber(modid = AbnormalsDelight.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ADCompat {

	@SubscribeEvent
	public static void onModifyComponents(ModifyDefaultComponentsEvent event) {
		event.modify(Items.COOKIE, c -> c.set(DataComponents.FOOD, new FoodProperties.Builder().nutrition(2).saturationModifier(0.3F).fast().build()));
	}
}
