package com.teamabnormals.abnormals_delight.core.mixin;

import net.minecraft.world.item.CreativeModeTab;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vectorwing.farmersdelight.FarmersDelight;

@Mixin(CreativeModeTab.class)
public abstract class ItemGroupMixin {

	@Inject(at = @At("HEAD"), method = "addGroupSafe", cancellable = true, remap = false)
	private static void addGroupSafe(int index, CreativeModeTab newGroup, CallbackInfoReturnable<Integer> cir) {
		if (newGroup.langId.equals(FarmersDelight.MODID)) {
			cir.cancel();
		}
	}
}
