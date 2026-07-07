package net.mcreator.cobblestone.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;

import net.mcreator.cobblestone.procedures.WrenchDestroyMachineProcedure;

public class MechanicalHousingBlock extends Block {
	public MechanicalHousingBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(5f, 6f));
	}

	@Override
	public void attack(BlockState blockstate, Level world, BlockPos pos, Player entity) {
		super.attack(blockstate, world, pos, entity);
		WrenchDestroyMachineProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}