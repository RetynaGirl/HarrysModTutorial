package com.teknoserval.harrysmod112.objects.blocks;

import com.teknoserval.harrysmod112.HarrysMod112;
import com.teknoserval.harrysmod112.init.BlockInit;
import com.teknoserval.harrysmod112.init.ItemInit;
import com.teknoserval.harrysmod112.objects.blocks.item.ItemBlockVariants;
import com.teknoserval.harrysmod112.util.handlers.EnumHandler;
import com.teknoserval.harrysmod112.util.interfaces.IHasModel;
import com.teknoserval.harrysmod112.util.interfaces.IMetaName;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockBasePlanks extends Block implements IHasModel, IMetaName {
	
	public static final PropertyEnum<EnumHandler.WoodType> VARIANT = PropertyEnum.<EnumHandler.WoodType>create("variant", EnumHandler.WoodType.class);
	
	private String name, type;
	
	public BlockBasePlanks(String name, String type, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.WOOD);
		setCreativeTab(HarrysMod112.TUTORIAL);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.WoodType.MAHOGANY));
		
		this.name = name;
		this.type = type;
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
		// TODO Auto-generated constructor stub
	}

	@Override
	public int damageDropped(IBlockState state) {

		return ((EnumHandler.WoodType)state.getValue(VARIANT)).getMeta();
		
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {

		return ((EnumHandler.WoodType)state.getValue(VARIANT)).getMeta();
		
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {

		return this.getDefaultState().withProperty(VARIANT, EnumHandler.WoodType.byMetadata(meta));
	
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {

		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
		
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		
		for(EnumHandler.WoodType variant : EnumHandler.WoodType.values()) {
			
			items.add(new ItemStack(this, 1, variant.getMeta()));
			
		}
		
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		// TODO Auto-generated method stub
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}

	@Override
	public void registerModels() {
		
		for(int i = 0; i < EnumHandler.WoodType.values().length; i++) {
			
			HarrysMod112.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "wood_" + this.type + "_" + EnumHandler.WoodType.values()[i].getName(), "inventory");
			
		}
		
	}

	@Override
	public String getSpeacialName(ItemStack stack) {
		// TODO Auto-generated method stub
		return EnumHandler.WoodType.values()[stack.getItemDamage()].getName();
	}

}
