package net.mcreator.cobblestone.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.cobblestone.init.CobblestoneModItems;

public class SetscreenProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if ((getPropertyByName(blockstate, "screen") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 0) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CobblestoneModItems.STONESCREEN.get()) {
				{
					int _value = 1;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("screen") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack7 = new ItemStack(CobblestoneModItems.STONESCREEN.get()).copy();
					_setstack7.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack7);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CobblestoneModItems.IRON_SCREEN.get()) {
				{
					int _value = 2;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("screen") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack13 = new ItemStack(CobblestoneModItems.IRON_SCREEN.get()).copy();
					_setstack13.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount() - 1);
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack13);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == CobblestoneModItems.WRENCH.get()
				&& (getPropertyByName(blockstate, "screen") instanceof IntegerProperty _getip17 ? blockstate.getValue(_getip17) : -1) > 0) {
			if (world instanceof ServerLevel _level) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null, _stkprov -> {
				});
			}
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("screen") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			if ((getPropertyByName(blockstate, "screen") instanceof IntegerProperty _getip22 ? blockstate.getValue(_getip22) : -1) == 1) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(CobblestoneModItems.STONESCREEN.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if ((getPropertyByName(blockstate, "screen") instanceof IntegerProperty _getip25 ? blockstate.getValue(_getip25) : -1) == 2) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(CobblestoneModItems.IRON_SCREEN.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
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