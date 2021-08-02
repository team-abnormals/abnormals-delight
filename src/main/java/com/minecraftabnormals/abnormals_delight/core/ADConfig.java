package com.minecraftabnormals.abnormals_delight.core;

import com.minecraftabnormals.abnormals_core.core.annotations.ConfigKey;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.apache.commons.lang3.tuple.Pair;

@EventBusSubscriber(modid = AbnormalsDelight.MOD_ID)
public class ADConfig {

	public static class Common {

		@ConfigKey("replace_fd_item_group")
		public final ConfigValue<Boolean> replaceFDItemGroup;

		Common(ForgeConfigSpec.Builder builder) {
			builder.push("overrides");
			replaceFDItemGroup = builder.comment("Removes and hides Farmer's Delight's ItemGroup and move the items to vanilla ItemGroups").define("replaceFDItemGroup", false);
			builder.pop();
		}
	}

	public static final ForgeConfigSpec COMMON_SPEC;
	public static final Common COMMON;

	static {
		final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = specPair.getRight();
		COMMON = specPair.getLeft();
	}
}