package com.teamabnormals.abnormals_delight.core.other;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.neoforged.fml.ModList;

public class ADItemTiers {
	public static final Tier COPPER = isCCLoaded() ? CCItemTiersWrapper.COPPER : Tiers.STONE;
	public static final Tier SILVER = isCCLoaded() ? CCItemTiersWrapper.SILVER : Tiers.IRON;
	public static final Tier NECROMIUM = isCCLoaded() ? CCItemTiersWrapper.NECROMIUM : Tiers.NETHERITE;

	public static boolean isCCLoaded() {
		return ModList.get().isLoaded(ADConstants.CAVERNS_AND_CHASMS);
	}
}
