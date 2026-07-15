package net.mcreator.cobblestone.procedures;

import net.minecraft.world.item.ItemStack;

public class InBatteryEnergyProcedure {
	public static String execute(ItemStack itemstack) {
		return (100 - itemstack.getDamageValue()) * 20 + "/" + 2000;
	}
}