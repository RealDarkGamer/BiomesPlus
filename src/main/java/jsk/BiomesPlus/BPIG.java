package jsk.BiomesPlus;

import jsk.BiomesPlus.lists.BlockList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BPIG extends ItemGroup
{

	public BPIG() 
	{
		super("biomesplus");
	}

	@Override
	public ItemStack createIcon() 
	{
		return new ItemStack(Item.BLOCK_TO_ITEM.get(BlockList.cherry_planks));
	}	
}
