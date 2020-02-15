package jsk.BiomesPlus;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jsk.BiomesPlus.lists.FoodList;
import jsk.BiomesPlus.lists.ItemList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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
			ItemList.candy_cane = new Item(new Item.Properties().group(ItemGroup.FOOD).food())
		    Item﻿List.candy_cane = new Item(new Item.Properties().food(ItemList.candy_cane).group(ItemGroup.FOOD)).setRegistryName(location("gobber2_goo")),
			
			logger.info("Items regestered.");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
}	
