package com.teknoserval.harrysmod112.init;

import java.util.ArrayList;
import java.util.List;

import com.teknoserval.harrysmod112.objects.armor.ArmorBase;
import com.teknoserval.harrysmod112.objects.items.ItemBase;
import com.teknoserval.harrysmod112.objects.tools.ToolAxe;
import com.teknoserval.harrysmod112.objects.tools.ToolHoe;
import com.teknoserval.harrysmod112.objects.tools.ToolPickaxe;
import com.teknoserval.harrysmod112.objects.tools.ToolSpade;
import com.teknoserval.harrysmod112.objects.tools.ToolSword;
import com.teknoserval.harrysmod112.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemInit {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	public static final ToolMaterial TOOL_COPPER = EnumHelper.addToolMaterial("tool_copper", 2, 200, 4.0F, 1.5F, 17);
	public static final ArmorMaterial ARMOR_COPPER = EnumHelper.addArmorMaterial("armor_copper", Reference.MODID + ":copper", 15, new int[]{2, 4, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	
	//Items
	public static final Item INGOT_COPPER = new ItemBase("ingot_copper");
	
	//Tools
	public static final Item AXE_COPPER = new ToolAxe("axe_copper", TOOL_COPPER);
	public static final Item PICKAXE_COPPER = new ToolPickaxe("pickaxe_copper", TOOL_COPPER);
	public static final Item SPADE_COPPER = new ToolSpade("spade_copper", TOOL_COPPER);
	public static final Item SWORD_COPPER = new ToolSword("sword_copper", TOOL_COPPER);
	public static final Item HOE_COPPER = new ToolHoe("hoe_copper", TOOL_COPPER);
	
	//Armor
	public static final Item HELMET_COPPER = new ArmorBase("helmet_copper", ARMOR_COPPER, 1, EntityEquipmentSlot.HEAD);
	public static final Item CHESTPLATE_COPPER = new ArmorBase("chestplate_copper", ARMOR_COPPER, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEGGINGS_COPPER = new ArmorBase("leggings_copper", ARMOR_COPPER, 2, EntityEquipmentSlot.LEGS);
	public static final Item BOOTS_COPPER = new ArmorBase("boots_copper", ARMOR_COPPER, 1, EntityEquipmentSlot.FEET);

}
