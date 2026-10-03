package net.mcreator.cobblestone.client;

import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.client.Minecraft;

import net.mcreator.cobblestone.item.StoneBookItem;
import net.mcreator.cobblestone.client.gui.StoneBookBookScreen;

@EventBusSubscriber(modid = "cobblestone", value = Dist.CLIENT)
public final class StoneBookBookClientEvents {
	private StoneBookBookClientEvents() {
	}

	/**
	 * Open before vanilla block/entity interaction consumes the right click.
	 * This makes guide books behave consistently no matter what the player is looking at.
	 */
	@SubscribeEvent
	public static void onInteractionKey(InputEvent.InteractionKeyMappingTriggered event) {
		if (!event.isUseItem())
			return;
		Minecraft minecraft = Minecraft.getInstance();
		if (minecraft.player == null || minecraft.screen != null)
			return;
		ItemStack stack = minecraft.player.getItemInHand(event.getHand());
		if (stack.getItem() instanceof StoneBookItem) {
			minecraft.setScreen(new StoneBookBookScreen());
			event.setSwingHand(false);
			event.setCanceled(true);
		}
	}
}