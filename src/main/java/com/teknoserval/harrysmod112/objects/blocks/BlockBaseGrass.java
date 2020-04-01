package com.teknoserval.harrysmod112.objects.blocks;

import java.util.Random;

import com.teknoserval.harrysmod112.init.BlockInit;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockBaseGrass extends BlockBaseDirt {

	public BlockBaseGrass(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		// TODO Auto-generated method stub
		return BlockInit.BLOCK_RED_DIRT.getItemDropped(BlockInit.BLOCK_RED_DIRT.getDefaultState(), rand, fortune);
	}

}
