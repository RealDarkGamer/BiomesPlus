package jsk.BiomesPlus.init;

import jsk.BiomesPlus.BiomesPlus;
import jsk.BiomesPlus.entities.CandyTrader;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

public class BPEntities 
{
	public static EntityType<?> CANDYTRADER = EntityType.Builder.create(CandyTrader::new, EntityClassification.AMBIENT).build(BiomesPlus.MODID + ":candy_trader").setRegistryName(BiomesPlus.RegistryEvents.location("candy_trader"));
	
	public static void registerEntitySpawnEggs(final RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll
		(
				BPItems.candy_trader_egg = registerEntitySpawnEgg(CANDYTRADER, 0xff0000, 0xffffff, "candy_trader_egg")
		);
	}
	
	public static void registerEntityWorldSpawns()
	{
		registerEntityWorldSpawn(CANDYTRADER, Biomes.DESERT, Biomes.PLAINS, Biomes.NETHER, Biomes.SAVANNA, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST, Biomes.TAIGA, Biomes.FOREST, Biomes.FLOWER_FOREST);
	}
	
	public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name)
	{
		SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(BiomesPlus.BP));
		item.setRegistryName(BiomesPlus.RegistryEvents.location(name));
		return item;
	}
	
	public static void registerEntityWorldSpawn(EntityType<?> entity, Biome...biomes)
	{
		for(Biome biome : biomes)
		{
			if(biome != null)
			{
				biome.getSpawns(entity.getClassification()).add(new SpawnListEntry(entity, 10, 1, 10));
			}
		}
	}
}
