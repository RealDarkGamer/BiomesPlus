package jsk.BiomesPlus.client.renders;

import jsk.BiomesPlus.entities.CandyTrader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class BPRenderRegistry 
{
	public static void registerEntityRendering() 
	{
		RenderingRegistry.registerEntityRenderingHandler(CandyTrader.class, new CandyTraderRender.RenderFactory());
	}
}
