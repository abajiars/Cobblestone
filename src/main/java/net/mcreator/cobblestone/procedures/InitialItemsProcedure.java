package net.mcreator.cobblestone.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.cobblestone.network.CobblestoneModVariables;
import net.mcreator.cobblestone.init.CobblestoneModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class InitialItemsProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!CobblestoneModVariables.WorldVariables.get(world).initial) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(CobblestoneModItems.HAMMER.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			CobblestoneModVariables.WorldVariables.get(world).initial = true;
			CobblestoneModVariables.WorldVariables.get(world).markSyncDirty();
		}
	}
}