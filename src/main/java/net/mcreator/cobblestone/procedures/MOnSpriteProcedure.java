package net.mcreator.cobblestone.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public class MOnSpriteProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockEntity(BlockPos.containing((int) x, (int) (y - 1), (int) z)) instanceof BlockEntity _blockEnt0 ? _blockEnt0.getPersistentData() : new CompoundTag()).contains("StoneEnergy")) {
			return Math.floor(getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "StoneEnergy") / (getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "MaxStoneEnergy") / 12));
		}
		return 0;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}