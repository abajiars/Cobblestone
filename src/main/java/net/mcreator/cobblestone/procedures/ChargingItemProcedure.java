package net.mcreator.cobblestone.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.cobblestone.init.CobblestoneModItems;

public class ChargingItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(world.getBlockEntity(BlockPos.containing((int) x, (int) y, (int) z)) instanceof BlockEntity _blockEnt0 ? _blockEnt0.getPersistentData() : new CompoundTag()).contains("second")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("second", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		ChargingItemPProcedure.execute(world, x, y, z, new ItemStack(CobblestoneModItems.QUARTZ_DUST.get()), new ItemStack(Items.QUARTZ));
		ChargingItemPProcedure.execute(world, x, y, z, new ItemStack(Items.QUARTZ), new ItemStack(CobblestoneModItems.QUARTZ_CRYSTAL.get()));
		ChargingItemPProcedure.execute(world, x, y, z, new ItemStack(CobblestoneModItems.GLASS_DUST.get()), new ItemStack(Items.REDSTONE));
		ChargingItemPProcedure.execute(world, x, y, z, new ItemStack(Items.REDSTONE), new ItemStack(CobblestoneModItems.REDSTONE_CRYSTAL.get()));
	}
}