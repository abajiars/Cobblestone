/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cobblestone.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.cobblestone.client.gui.StoneMakingMachineGUIScreen;
import net.mcreator.cobblestone.client.gui.StoneHeaterGUIScreen;
import net.mcreator.cobblestone.client.gui.HammerMachineGUIScreen;
import net.mcreator.cobblestone.client.gui.ESTGUIScreen;
import net.mcreator.cobblestone.client.gui.ChargingDeviceGUIScreen;

@EventBusSubscriber(Dist.CLIENT)
public class CobblestoneModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(CobblestoneModMenus.HAMMER_MACHINE_GUI.get(), HammerMachineGUIScreen::new);
		event.register(CobblestoneModMenus.STONE_HEATER_GUI.get(), StoneHeaterGUIScreen::new);
		event.register(CobblestoneModMenus.STONE_MAKING_MACHINE_GUI.get(), StoneMakingMachineGUIScreen::new);
		event.register(CobblestoneModMenus.ESTGUI.get(), ESTGUIScreen::new);
		event.register(CobblestoneModMenus.CHARGING_DEVICE_GUI.get(), ChargingDeviceGUIScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}