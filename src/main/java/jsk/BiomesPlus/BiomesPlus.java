package jsk.BiomesPlus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jsk.BiomesPlus.lists.ArmorMaterialList;
import jsk.BiomesPlus.lists.BlockList;
import jsk.BiomesPlus.lists.FoodList;
import jsk.BiomesPlus.lists.ItemList;
import jsk.BiomesPlus.lists.ToolMaterialList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("bp")
public class BiomesPlus 
{
	public static BiomesPlus instance;
	public static final String modid = "bp";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public static final ItemGroup bp = new BPIG();
	
	public BiomesPlus() 
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		logger.info("setup method registered");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("clientRegistries method registered");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
		    event.getRegistry().registerAll
		    (
			ItemList.candy_cane = new Item(new Item.Properties().food(FoodList.candy_cane).group(bp)).setRegistryName(location("candy_cane")),
			ItemList.candy_cane_axe = new AxeItem(ToolMaterialList.candy, -1.0f, 6.0f, new Item.Properties().group(bp)).setRegistryName("candy_cane_axe"),
			ItemList.candy_cane_boots = new ArmorItem(ArmorMaterialList.candy, EquipmentSlotType.FEET, new Item.Properties().group(bp)).setRegistryName("candy_cane_boots"),
			ItemList.candy_cane_chestplate = new ArmorItem(ArmorMaterialList.candy, EquipmentSlotType.CHEST, new Item.Properties().group(bp)).setRegistryName("candy_cane_chestplate"),
			ItemList.candy_cane_helmet = new ArmorItem(ArmorMaterialList.candy, EquipmentSlotType.HEAD, new Item.Properties().group(bp)).setRegistryName("candy_cane_helmet"),
			ItemList.candy_cane_hoe = new HoeItem(ToolMaterialList.candy, 6.0f, new Item.Properties().group(bp)).setRegistryName("candy_cane_hoe"),				
			ItemList.candy_cane_leggings = new ArmorItem(ArmorMaterialList.candy, EquipmentSlotType.LEGS, new Item.Properties().group(bp)).setRegistryName("candy_cane_leggings"),
			ItemList.candy_cane_pickaxe = new PickaxeItem(ToolMaterialList.candy, -1, 6.0f, new Item.Properties().group(bp)).setRegistryName("candy_cane_pickaxe"),
			ItemList.candy_cane_shovel = new ShovelItem(ToolMaterialList.candy, -3.0f, 6.0f, new Item.Properties().group(bp)).setRegistryName("candy_cane_shovel"),
			ItemList.candy_cane_sword = new SwordItem(ToolMaterialList.candy, 0, 6.0f, new Item.Properties().group(bp)).setRegistryName("candy_cane_sword"),						
			ItemList.cherry_planks = new BlockItem(BlockList.cherry_planks, new Item.Properties().group(bp)).setRegistryName(BlockList.cherry_planks.getRegistryName())
		    );
			logger.info("Items regestered.");
		}

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
		    event.getRegistry().registerAll
		    (
			BlockList.cherry_planks = new Block(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.0f, 0.0f).lightValue(0).sound(SoundType.WOOD)).setRegistryName("cherry_planks")
			);
			
			logger.info("Blocks regestered.");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
}	
