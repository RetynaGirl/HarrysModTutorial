package com.teknoserval.harrysmod112.objects.items;

import com.teknoserval.harrysmod112.HarrysMod112;
import com.teknoserval.harrysmod112.init.ItemInit;
import com.teknoserval.harrysmod112.proxy.ClientProxy;
import com.teknoserval.harrysmod112.util.interfaces.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{
	
	public ItemBase(String name) {
		
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
