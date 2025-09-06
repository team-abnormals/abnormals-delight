package com.teamabnormals.abnormals_delight.core.data.server.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.abnormals_delight.core.other.ADConstants;
import com.teamabnormals.abnormals_delight.core.other.tags.ADEntityTypeTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ADEntityTypeTagsProvider extends EntityTypeTagsProvider {

	public ADEntityTypeTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, ExistingFileHelper helper) {
		super(output, lookupProvider, AbnormalsDelight.MOD_ID, helper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(ModTags.DOG_FOOD_USERS).addOptional(ADConstants.ZOMBIE_WOLF).addOptional(ADConstants.SKELETON_WOLF);
		this.tag(ModTags.HORSE_FEED_TEMPTED).addOptional(ADConstants.ZEBRA);
		this.tag(ModTags.HORSE_FEED_USERS).addOptional(ADConstants.ZEBRA);
		this.tag(ADEntityTypeTags.SCAVENGES_FEATHER).add(EntityType.CHICKEN).addOptional(ADConstants.DUCK).addOptional(ADConstants.TURKEY);
		this.tag(ADEntityTypeTags.SCAVENGES_LEATHER).add(EntityType.COW, EntityType.DONKEY, EntityType.HORSE, EntityType.LLAMA, EntityType.MULE).addOptional(ADConstants.DEER).addOptional(ADConstants.REINDEER);
	}
}