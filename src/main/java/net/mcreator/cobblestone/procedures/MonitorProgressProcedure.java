package net.mcreator.cobblestone.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public class MonitorProgressProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockEntity(BlockPos.containing((int) x, (int) (y - 1), (int) z)) instanceof BlockEntity _blockEnt0 ? _blockEnt0.getPersistentData() : new CompoundTag()).contains("second")) {
			if (!(world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("c:cobblestone/generator"))) && getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "second") > 0) {
				return Component.translatable("gui.cobblestone.progress").getString() + "" + Math.floor((getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "second") / 60) * 100) + "%";
			}
			return Component.translatable("gui.cobblestone.monitor.status3").getString();
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