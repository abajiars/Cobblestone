package net.mcreator.cobblestone.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class TransmissionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		assert Boolean.TRUE; //#dbg:Transmission:start
		if ((world.getBlockEntity(BlockPos.containing((int) (x + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepZ()), (int) y, (int) (z + (getDirectionFromBlockState(blockstate)).getStepX()))) instanceof BlockEntity _blockEnt7
				? _blockEnt7.getPersistentData()
				: new CompoundTag()).contains("StoneEnergy")
				&& (world
						.getBlockEntity(BlockPos.containing((int) (x + (getDirectionFromBlockState(blockstate)).getStepZ()), (int) y, (int) (z + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepX()))) instanceof BlockEntity _blockEnt16
								? _blockEnt16.getPersistentData()
								: new CompoundTag())
						.contains("StoneEnergy")) {
			assert Boolean.TRUE; //#dbg:Transmission:in
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StoneEnergy") >= 40
					&& getBlockNBTNumber(world, BlockPos.containing(x + (getDirectionFromBlockState(blockstate)).getStepZ(), y, z + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepX()), "StoneEnergy") + 40 <= getBlockNBTNumber(world,
							BlockPos.containing(x + (getDirectionFromBlockState(blockstate)).getStepZ(), y, z + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepX()), "MaxStoneEnergy")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("StoneEnergy", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StoneEnergy") - 40));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x + (getDirectionFromBlockState(blockstate)).getStepZ(), y, z + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepX());
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("StoneEnergy",
								(getBlockNBTNumber(world, BlockPos.containing(x + (getDirectionFromBlockState(blockstate)).getStepZ(), y, z + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepX()), "StoneEnergy") + 40));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StoneEnergy") + 40 <= getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MaxStoneEnergy")
					&& getBlockNBTNumber(world, BlockPos.containing(x + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepZ(), y, z + (getDirectionFromBlockState(blockstate)).getStepX()), "StoneEnergy") >= 40) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepZ(), y, z + (getDirectionFromBlockState(blockstate)).getStepX());
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("StoneEnergy",
								(getBlockNBTNumber(world, BlockPos.containing(x + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepZ(), y, z + (getDirectionFromBlockState(blockstate)).getStepX()), "StoneEnergy") - 40));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("StoneEnergy", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "StoneEnergy") + 40));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		Property<?> prop = getPropertyByName(blockState, "facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = getPropertyByName(blockState, "axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}