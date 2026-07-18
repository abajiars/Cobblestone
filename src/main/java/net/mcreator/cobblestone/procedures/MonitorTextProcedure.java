package net.mcreator.cobblestone.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class MonitorTextProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockEntity(BlockPos.containing((int) x, (int) (y - 1), (int) z)) instanceof BlockEntity _blockEnt0 ? _blockEnt0.getPersistentData() : new CompoundTag()).contains("StoneEnergy")) {
			return BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()).toString();
		}
		return "\u5E95\u90E8\u65E0\u673A\u5668\u3002";
	}
}