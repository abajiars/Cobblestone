package net.mcreator.cobblestone.configuration;

import net.neoforged.neoforge.common.ModConfigSpec;

public class SetEnergyConfiguration {
	public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
	public static final ModConfigSpec SPEC;
	public static final ModConfigSpec.ConfigValue<Double> MAX_STONE_ENERGY;
	public static final ModConfigSpec.ConfigValue<Double> MAX_PIPELINE_ENERGY;
	static {
		BUILDER.push("max_energy");
		MAX_STONE_ENERGY = BUILDER.comment("Max Machine's Energy").define("max_stone_energy", (double) 20000);
		MAX_PIPELINE_ENERGY = BUILDER.comment("Max Pipeline's Energy").define("max_pipeline_energy", (double) 1000);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}