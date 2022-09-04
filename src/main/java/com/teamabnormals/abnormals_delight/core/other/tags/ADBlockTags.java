package com.teamabnormals.abnormals_delight.core.other.tags;

import com.teamabnormals.abnormals_delight.core.AbnormalsDelight;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ADBlockTags {
	public static final TagKey<Block> DROPS_FLAVORED_CAKE_SLICE = blockTag("drops_flavored_cake_slice");
	public static final TagKey<Block> DROPS_VANILLA_CAKE_SLICE = blockTag("drops_vanilla_cake_slice");
	public static final TagKey<Block> DROPS_CHOCOLATE_CAKE_SLICE = blockTag("drops_chocolate_cake_slice");
	public static final TagKey<Block> DROPS_STRAWBERRY_CAKE_SLICE = blockTag("drops_strawberry_cake_slice");
	public static final TagKey<Block> DROPS_BANANA_CAKE_SLICE = blockTag("drops_banana_cake_slice");
	public static final TagKey<Block> DROPS_MINT_CAKE_SLICE = blockTag("drops_mint_cake_slice");
	public static final TagKey<Block> DROPS_ADZUKI_CAKE_SLICE = blockTag("drops_adzuki_cake_slice");

	private static TagKey<Block> blockTag(String name) {
		return TagUtil.blockTag(AbnormalsDelight.MOD_ID, name);
	}
}
