package com.teamabnormals.abnormals_delight.core.data.server.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.abnormals_delight.core.other.tags.ADEntityTypeTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.ModTags;

public class ADEntityTypeTagsProvider extends EntityTypeTagsProvider {

	public ADEntityTypeTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, AbnormalsDelight.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(ModTags.DOG_FOOD_USERS).addOptional(ADConstants.ZOMBIE_WOLF).addOptional(ADConstants.SKELETON_WOLF);
		this.tag(ADEntityTypeTags.SCAVENGES_FEATHER).add(EntityType.CHICKEN).addOptional(ADConstants.DUCK).addOptional(ADConstants.TURKEY);
		this.tag(ADEntityTypeTags.SCAVENGES_LEATHER).add(EntityType.COW, EntityType.DONKEY, EntityType.HORSE, EntityType.LLAMA, EntityType.MULE).addOptional(ADConstants.DEER).addOptional(ADConstants.REINDEER);
	}
}