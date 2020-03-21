package jsk.BiomesPlus.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig 
{
	public static ForgeConfigSpec.IntValue food_ore_chance;
	public static ForgeConfigSpec.BooleanValue generate_overworld;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("Oregen Config");
		
		food_ore_chance = server
				.comment("Maximum number of ores that can spawn for an food item with a respective ore.")
				.defineInRange("oregen.food_ore_chance", 100, 1, 10);
		
		generate_overworld = server
				.comment("Can the food ores generate in the overworld (true/false)")
				.define("oregen.generate_overworld", true);
	}
}
