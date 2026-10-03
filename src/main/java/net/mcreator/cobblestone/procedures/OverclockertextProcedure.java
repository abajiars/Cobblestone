package net.mcreator.cobblestone.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;

public class OverclockertextProcedure {
	public static String execute(ItemStack itemstack) {
		return (Component.translatable("item.cobblestone.overclocker_upgrade.time").getString() + "" + Math.pow(0.5, itemstack.getCount()) * 100 + "%\uFF0C") + ""
				+ (Component.translatable("item.cobblestone.overclocker_upgrade.energy").getString() + "" + Math.pow(4, itemstack.getCount()) * 100 + "%\u3002") + "\n"
				+ Component.translatable("item.cobblestone.overcloker_upgrade.prompt").getString();
	}
}