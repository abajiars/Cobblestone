package net.mcreator.cobblestone.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public class MonitorInformationProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockEntity(BlockPos.containing((int) x, (int) (y - 1), (int) z)) instanceof BlockEntity _blockEnt0 ? _blockEnt0.getPersistentData() : new CompoundTag()).contains("StoneEnergy")) {
			if ((world.getBlockEntity(BlockPos.containing((int) x, (int) (y - 1), (int) z)) instanceof BlockEntity _blockEnt2 ? _blockEnt2.getPersistentData() : new CompoundTag()).contains("second")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "second") > 0) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "StoneEnergy") <= 20) {
						return "\u673A\u5668\u88AB\u8FEB\u505C\u6B62\u5DE5\u4F5C";
					}
					return "\u673A\u5668\u6B63\u5728\u5DE5\u4F5C";
				}
				return "\u673A\u5668\u672A\u5DE5\u4F5C";
			}
			return "\u50A8\u7F50\u6709\u7535";
		}
		return "";
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}