package com.minecraftabnormals.abnormals_delight.core.data;

import com.minecraftabnormals.abnormals_delight.core.AbnormalsDelight;
import com.minecraftabnormals.abnormals_delight.core.other.ADConstants;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import vectorwing.farmersdelight.utils.tags.ModTags;

public class BlockTagGenerator extends BlockTagsProvider {

	public BlockTagGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, AbnormalsDelight.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags() {
		this.tag(ModTags.HEAT_SOURCES).addOptional(ADConstants.GLOWING_OBSIDIAN);
		this.tag(ModTags.TRAY_HEAT_SOURCES).addOptionalTag(ADConstants.BRAZIERS);
	}
}