package jsk.BiomesPlus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jsk.BiomesPlus.client.renders.BPRenderRegistry;
import jsk.BiomesPlus.config.Config;
import jsk.BiomesPlus.init.ArmorMaterials;
import jsk.BiomesPlus.init.BPBlocks;
import jsk.BiomesPlus.init.BPEntities;
import jsk.BiomesPlus.init.BPFoods;
import jsk.BiomesPlus.init.BPItems;
import jsk.BiomesPlus.init.ToolMaterials;
import jsk.BiomesPlus.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod("bp")
public class BiomesPlus 
{
	public static BiomesPlus instance;
	public static final String MODID = "bp";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
	
	public static final ItemGroup BP = new BPIG();
	
	public BiomesPlus() 
	{
		instance = this;
		
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config, "biomesplus-server.toml");
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.client_config, "biomesplus-client.toml");
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve("biomesplus-server.toml").toString());
		Config.loadConfig(Config.client_config, FMLPaths.CONFIGDIR.get().resolve("biomesplus-client.toml").toString());
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		OreGeneration.setupOreGeneration();
		LOGGER.info("setup method registered");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		
	BPRenderRegistry.registerEntityRendering();
	LOGGER.info("clientRegistries method registered");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
		    event.getRegistry().registerAll
		    (
			BPItems.candy_cane = new Item(new Item.Properties().food(BPFoods.candy_cane).group(BP)).setRegistryName(location("candy_cane")),
			BPItems.candy_cane_axe = new AxeItem(ToolMaterials.candy, -1.0f, 6.0f, new Item.Properties().group(BP)).setRegistryName("candy_cane_axe"),
			BPItems.candy_cane_boots = new ArmorItem(ArmorMaterials.candy, EquipmentSlotType.FEET, new Item.Properties().group(BP)).setRegistryName("candy_cane_boots"),
			BPItems.candy_cane_chestplate = new ArmorItem(ArmorMaterials.candy, EquipmentSlotType.CHEST, new Item.Properties().group(BP)).setRegistryName("candy_cane_chestplate"),
			BPItems.candy_cane_helmet = new ArmorItem(ArmorMaterials.candy, EquipmentSlotType.HEAD, new Item.Properties().group(BP)).setRegistryName("candy_cane_helmet"),
			BPItems.candy_cane_hoe = new HoeItem(ToolMaterials.candy, 6.0f, new Item.Properties().group(BP)).setRegistryName("candy_cane_hoe"),				
			BPItems.candy_cane_leggings = new ArmorItem(ArmorMaterials.candy, EquipmentSlotType.LEGS, new Item.Properties().group(BP)).setRegistryName("candy_cane_leggings"),
			BPItems.candy_cane_ore = new BlockItem(BPBlocks.candy_cane_ore, new Item.Properties().group(BP)).setRegistryName(BPBlocks.candy_cane_ore.getRegistryName()),
			BPItems.candy_cane_pickaxe = new PickaxeItem(ToolMaterials.candy, -1, 6.0f, new Item.Properties().group(BP)).setRegistryName("candy_cane_pickaxe"),
			BPItems.candy_cane_shovel = new ShovelItem(ToolMaterials.candy, -3.0f, 6.0f, new Item.Properties().group(BP)).setRegistryName("candy_cane_shovel"),
			BPItems.candy_cane_sword = new SwordItem(ToolMaterials.candy, 0, 6.0f, new Item.Properties().group(BP)).setRegistryName("candy_cane_sword"),						
			BPItems.cherry_planks = new BlockItem(BPBlocks.cherry_planks, new Item.Properties().group(BP)).setRegistryName(BPBlocks.cherry_planks.getRegistryName())
		    );
	
		    BPEntities.registerEntitySpawnEggs(event);
		    
			LOGGER.info("Items regestered.");
		}

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
		    event.getRegistry().registerAll
		    (
			BPBlocks.candy_cane_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0f).lightValue(0).sound(SoundType.GROUND)).setRegistryName("candy_cane_ore"),
		    BPBlocks.cherry_planks = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 0.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName("cherry_planks")
			);
			
			LOGGER.info("Blocks regestered.");
		}
		
		@SubscribeEvent
		public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
		{
			event.getRegistry().registerAll
			(
					BPEntities.CANDYTRADER
			);
			
			BPEntities.registerEntityWorldSpawns();
		}
				
		public static ResourceLocation location(String name)
		{
			return new ResourceLocation(MODID, name);
		}
	}
}	