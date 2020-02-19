package com.teknoserval.harrysmod112.objects.armor;

import com.teknoserval.harrysmod112.HarrysMod112;
import com.teknoserval.harrysmod112.init.ItemInit;
import com.teknoserval.harrysmod112.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor implements IHasModel {

	public ArmorBase(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		
		ItemInit.ITEMS.add(this);
		
	}

	@Override
	public void registerModels() {
		
		HarrysMod112.proxy.registerItemRenderer(this, 0, "inventory");
		
	}

}
