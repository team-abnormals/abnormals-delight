package com.minecraftabnormals.abnormals_delight.core.mixin;

import com.minecraftabnormals.abnormals_delight.core.ADConfig;
import net.minecraft.item.ItemGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vectorwing.farmersdelight.FDItemGroup;
import vectorwing.farmersdelight.FarmersDelight;

@Mixin(ItemGroup.class)
public abstract class ItemGroupMixin {

	@Inject(at = @At("HEAD"), method = "addGroupSafe", cancellable = true, remap = false)
	private static void addGroupSafe(int index, ItemGroup newGroup, CallbackInfoReturnable<Integer> cir) {
		if (newGroup.tabLabel.equals(FarmersDelight.MODID)) {
			cir.cancel();
		}
	}
}
