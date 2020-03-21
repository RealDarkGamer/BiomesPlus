package jsk.BiomesPlus.client.models;

import jsk.BiomesPlus.entities.CandyTrader;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CandyTraderModel extends EntityModel<CandyTrader>
{
	private final RendererModel candy_trader;
	private final RendererModel Body;
	private final RendererModel Legs;
	private final RendererModel Arms;
	private final RendererModel Head;

	public CandyTraderModel() 
	{
		textureWidth = 32;
		textureHeight = 32;

		candy_trader = new RendererModel(this);
		candy_trader.setRotationPoint(0.0F, 24.0F, -4.0F);

		Body = new RendererModel(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		candy_trader.addChild(Body);
		Body.cubeList.add(new ModelBox(Body, 11, 10, -3.0F, -13.0F, -1.0F, 6, 10, 4, 0.0F, false));

		Legs = new RendererModel(this);
		Legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotationAngle(Legs, 0.0F, 3.1416F, 0.0F);
		candy_trader.addChild(Legs);
		Legs.cubeList.add(new ModelBox(Legs, 0, 14, 0.0F, -3.0F, -2.0F, 2, 3, 2, 0.0F, false));
		Legs.cubeList.add(new ModelBox(Legs, 0, 14, -2.0F, -3.0F, -2.0F, 2, 3, 2, 0.0F, false));

		Arms = new RendererModel(this);
		Arms.setRotationPoint(12.0F, -4.0F, 3.0F);
		setRotationAngle(Arms, 0.7854F, 0.0F, 0.0F);
		candy_trader.addChild(Arms);
		Arms.cubeList.add(new ModelBox(Arms, 8, 15, -17.0F, -7.1213F, 2.1213F, 10, 5, 2, 0.0F, false));

		Head = new RendererModel(this);
		Head.setRotationPoint(12.0F, -4.0F, 3.0F);
		setRotationAngle(Head, 0.0F, 3.1416F, 0.0F);
		candy_trader.addChild(Head);
		Head.cubeList.add(new ModelBox(Head, 0, 0, 10.0F, -14.0F, 0.0F, 4, 5, 4, 0.0F, false));
	}

	public void render(EntityType<?> entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		candy_trader.render(f5);
	}
	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}

