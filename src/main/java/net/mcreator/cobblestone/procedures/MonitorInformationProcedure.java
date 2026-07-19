package net.mcreator.cobblestone.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public class MonitorInformationProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockEntity(BlockPos.containing((int) x, (int) (y - 1), (int) z)) instanceof BlockEntity _blockEnt0 ? _blockEnt0.getPersistentData() : new CompoundTag()).contains("StoneEnergy")) {
			if ((world.getBlockEntity(BlockPos.containing((int) x, (int) (y - 1), (int) z)) instanceof BlockEntity _blockEnt2 ? _blockEnt2.getPersistentData() : new CompoundTag()).contains("second")) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "second") > 0) {
					if (getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "StoneEnergy") <= 20) {
						return Component.translatable("gui.cobblestone.monitor.status1").getString();
					}
					return Component.translatable("gui.cobblestone.monitor.status2").getString();
				}
				return Component.translatable("gui.cobblestone.monitor.status3").getString();
			}
			return Component.translatable("gui.cobblestone.monitor.status4").getString();
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