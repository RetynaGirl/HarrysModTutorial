package com.teknoserval.harrysmod112.objects.blocks;

import java.util.List;
import java.util.Random;

import com.teknoserval.harrysmod112.init.BlockInit;
import com.teknoserval.harrysmod112.init.ItemInit;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class BlockBaseDirt extends BlockBase {

	public BlockBaseDirt(String name) {
		super(name, Material.GRASS);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction,
			IPlantable plantable) {
		// TODO Auto-generated method stub
		return true;
	}
	

}
