package com.teknoserval.harrysmod112.objects.blocks;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.teknoserval.harrysmod112.HarrysMod112;
import com.teknoserval.harrysmod112.init.BlockInit;
import com.teknoserval.harrysmod112.init.ItemInit;
import com.teknoserval.harrysmod112.objects.blocks.item.ItemBlockVariants;
import com.teknoserval.harrysmod112.util.handlers.EnumHandler;
import com.teknoserval.harrysmod112.util.interfaces.IHasModel;
import com.teknoserval.harrysmod112.util.interfaces.IMetaName;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockBaseLog extends BlockRotatedPillar implements IHasModel {

	
	public BlockBaseLog(String name) {
		super(Material.WOOD);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(HarrysMod112.TUTORIAL);


		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registerModels() {

		HarrysMod112.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

	

	@Override
	public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}

	

}
