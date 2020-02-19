package com.teknoserval.harrysmod112.objects.blocks;

import com.teknoserval.harrysmod112.HarrysMod112;
import com.teknoserval.harrysmod112.init.BlockInit;
import com.teknoserval.harrysmod112.init.ItemInit;
import com.teknoserval.harrysmod112.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel{

	public BlockBase(String name, Material materialIn) {
		super(materialIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registerModels() {
		
		HarrysMod112.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}

}
