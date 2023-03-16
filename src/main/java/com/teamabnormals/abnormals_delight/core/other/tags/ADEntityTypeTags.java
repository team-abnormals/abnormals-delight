package com.teamabnormals.abnormals_delight.core.other.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ADEntityTypeTags {
	public static final TagKey<EntityType<?>> SCAVENGES_FEATHER = entityTypeTag("scavenges_feather");
	public static final TagKey<EntityType<?>> SCAVENGES_LEATHER = entityTypeTag("scavenges_leather");

	private static TagKey<EntityType<?>> entityTypeTag(String name) {
		return TagUtil.entityTypeTag(AbnormalsDelight.MOD_ID, name);
	}
}
