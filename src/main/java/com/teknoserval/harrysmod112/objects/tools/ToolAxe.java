package com.teknoserval.harrysmod112.objects.tools;

import java.util.Set;

import com.google.common.collect.Sets;
import com.teknoserval.harrysmod112.HarrysMod112;
import com.teknoserval.harrysmod112.init.ItemInit;
import com.teknoserval.harrysmod112.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

public class ToolAxe extends ItemTool implements IHasModel{
	
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.PLANKS, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.LIT_PUMPKIN, Blocks.MELON_BLOCK, Blocks.LADDER, Blocks.WOODEN_BUTTON, Blocks.WOODEN_PRESSURE_PLATE);

	public ToolAxe(String name, ToolMaterial material) {
		super(material, EFFECTIVE_ON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(HarrysMod112.TUTORIAL);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		
		HarrysMod112.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
