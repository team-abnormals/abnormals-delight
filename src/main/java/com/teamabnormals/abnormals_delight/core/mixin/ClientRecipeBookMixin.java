package com.teamabnormals.abnormals_delight.core.mixin;

import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.item.crafting.Recipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vectorwing.farmersdelight.common.registry.ModRecipeTypes;

@Mixin(ClientRecipeBook.class)
public class ClientRecipeBookMixin {

	@Inject(at = @At("HEAD"), method = "getCategory", cancellable = true)
	private static void getCategory(Recipe<?> recipe, CallbackInfoReturnable<RecipeBookCategories> cir) {
		if (recipe.getType() == ModRecipeTypes.COOKING.get() || recipe.getType() == ModRecipeTypes.CUTTING.get()) {
			cir.setReturnValue(RecipeBookCategories.UNKNOWN);
		}
	}
}