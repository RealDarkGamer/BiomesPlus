package jsk.BiomesPlus.client.renders;

import jsk.BiomesPlus.BiomesPlus;
import jsk.BiomesPlus.client.models.CandyTraderModel;
import jsk.BiomesPlus.entities.CandyTrader;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class CandyTraderRender extends LivingRenderer<CandyTrader, CandyTraderModel>
{

	public CandyTraderRender(EntityRendererManager manager) 
	{
		super(manager, new CandyTraderModel(), 0f);
	}

	@Override
	protected ResourceLocation getEntityTexture(CandyTrader entity) 
	{
		return BiomesPlus.RegistryEvents.location("textures/entity/candy_trader.png");
	}
	
	public static class RenderFactory implements IRenderFactory<CandyTrader>
	{

		@Override
		public EntityRenderer<? super CandyTrader> createRenderFor(EntityRendererManager manager) 
		{
			return new CandyTraderRender(manager);
		}
		
	}
}
