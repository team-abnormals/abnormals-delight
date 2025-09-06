package com.teamabnormals.abnormals_delight.core;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ADConfig {

	public static class Common {
//		public final BooleanValue replaceFDItemGroup;

		Common(ModConfigSpec.Builder builder) {
//			builder.push("overrides");
//			replaceFDItemGroup = builder.comment("Removes and hides Farmer's Delight's ItemGroup and move the items to vanilla ItemGroups").define("replaceFDItemGroup", false);
//			builder.pop();
		}
	}

	public static final ModConfigSpec COMMON_SPEC;
	public static final Common COMMON;

	static {
		final Pair<Common, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = specPair.getRight();
		COMMON = specPair.getLeft();
	}
}