package net.mcreator.cobblestone.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class ESTSpriteProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		return Math.floor(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StoneEnergy") / (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MaxStoneEnergy") / 12));
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}