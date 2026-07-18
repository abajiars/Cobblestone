package net.mcreator.cobblestone.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public class MonitorPProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("is_working") instanceof BooleanProperty _booleanProp)
				world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
		}
		if ((world.getBlockEntity(BlockPos.containing((int) x, (int) (y - 1), (int) z)) instanceof BlockEntity _blockEnt1 ? _blockEnt1.getPersistentData() : new CompoundTag()).contains("StoneEnergy")) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("is_working") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
			}
		}
	}
}