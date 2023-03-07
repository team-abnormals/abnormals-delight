package com.teamabnormals.abnormals_delight.core.data.server.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.ModTags;

public class ADEntityTypeTagsProvider extends EntityTypeTagsProvider {

	public ADEntityTypeTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, AbnormalsDelight.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(ModTags.DOG_FOOD_USERS).addOptional(ADConstants.ZOMBIE_WOLF).addOptional(ADConstants.SKELETON_WOLF);
	}
}