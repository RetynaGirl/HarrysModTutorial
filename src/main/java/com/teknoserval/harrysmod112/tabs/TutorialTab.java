package com.teknoserval.harrysmod112.tabs;

import com.teknoserval.harrysmod112.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TutorialTab extends CreativeTabs{

	public TutorialTab(String label) {
		super("tutorialtab");
		this.setBackgroundImageName("tutorial.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		// TODO Auto-generated method stub
		return new ItemStack(ItemInit.INGOT_COPPER);
	}

}
