package com.teamabnormals.abnormals_delight.core.other;

import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

public interface ADConditions {
	ModLoadedCondition AUTUMNITY_LOADED = new ModLoadedCondition(ADConstants.AUTUMNITY);
	ModLoadedCondition ATMOSPHERIC_LOADED = new ModLoadedCondition(ADConstants.ATMOSPHERIC);
	ModLoadedCondition BUZZIER_BEES_LOADED = new ModLoadedCondition(ADConstants.BUZZIER_BEES);
	ModLoadedCondition ENVIRONMENTAL_LOADED = new ModLoadedCondition(ADConstants.ENVIRONMENTAL);
	ModLoadedCondition INCUBATION_LOADED = new ModLoadedCondition(ADConstants.INCUBATION);
	ModLoadedCondition NEAPOLITAN_LOADED = new ModLoadedCondition(ADConstants.NEAPOLITAN);
	ModLoadedCondition UPGRADE_AQUATIC_LOADED = new ModLoadedCondition(ADConstants.UPGRADE_AQUATIC);
}
