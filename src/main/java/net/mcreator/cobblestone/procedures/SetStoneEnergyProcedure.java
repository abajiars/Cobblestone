package net.mcreator.cobblestone.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.cobblestone.configuration.SetEnergyConfiguration;

public class SetStoneEnergyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(world.getBlockEntity(BlockPos.containing((int) x, (int) y, (int) z)) instanceof BlockEntity _blockEnt0 ? _blockEnt0.getPersistentData() : new CompoundTag()).contains("StoneEnergy")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("StoneEnergy", 0);
					_blockEntity.getPersistentData().putDouble("MaxStoneEnergy", ((double) SetEnergyConfiguration.MAX_STONE_ENERGY.get()));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}