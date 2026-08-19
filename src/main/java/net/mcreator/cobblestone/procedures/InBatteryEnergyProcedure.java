package net.mcreator.cobblestone.procedures;

import net.minecraft.world.item.ItemStack;

public class InBatteryEnergyProcedure {
	public static String execute(ItemStack itemstack) {
		return ((itemstack.getMaxDamage() - 1) - itemstack.getDamageValue()) * 20 + "/" + (itemstack.getMaxDamage() - 1) * 20;
	}
}