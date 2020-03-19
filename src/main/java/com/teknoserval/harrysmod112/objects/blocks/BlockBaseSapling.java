package com.teknoserval.harrysmod112.objects.blocks;

import java.util.Random;

import com.teknoserval.harrysmod112.HarrysMod112;
import com.teknoserval.harrysmod112.init.BlockInit;
import com.teknoserval.harrysmod112.init.ItemInit;
import com.teknoserval.harrysmod112.util.handlers.EnumHandler;
import com.teknoserval.harrysmod112.util.interfaces.IHasModel;
import com.teknoserval.harrysmod112.world.gen.generators.WorldGenCedarTree;
import com.teknoserval.harrysmod112.world.gen.generators.WorldGenMahoganyTree;
import com.teknoserval.harrysmod112.world.gen.generators.WorldGenWillowTree;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class BlockBaseSapling extends BlockBush implements IGrowable, IHasModel {

	protected EnumHandler.WoodType variant;

	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D,
			0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

	public BlockBaseSapling(String name, EnumHandler.WoodType variant) {

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(HarrysMod112.TUTORIAL);
		setSoundType(SoundType.PLANT);

		this.variant = variant;

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));

	}

	// Sapling Shape
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		return SAPLING_AABB;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {

		return NULL_AABB;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {

		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {

		return false;
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {

		return (double) worldIn.rand.nextFloat() < 0.3D;

	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {

		this.generateTree(worldIn, rand, pos, state);

	}

	public void generateTree(World worldIn, Random rand, BlockPos pos, IBlockState state) {

		if (!TerrainGen.saplingGrowTree(worldIn, rand, pos)) {

			return;

		}

		WorldGenerator gen = (WorldGenerator) (rand.nextInt(10) == 0 ? new WorldGenBigTree(false)
				: new WorldGenTrees(false));

		boolean flag = false;
		IBlockState treeState = BlockInit.SAPLING_MAHOGANY.getDefaultState();

		switch (variant) {

		case MAHOGANY:
			gen = new WorldGenMahoganyTree();
			treeState = BlockInit.SAPLING_MAHOGANY.getDefaultState();
			break;

		case CEDAR:
			gen = new WorldGenCedarTree();
			treeState = BlockInit.SAPLING_CEDAR.getDefaultState();
			break;

		case WILLOW:
			gen = new WorldGenWillowTree();
			treeState = BlockInit.SAPLING_WILLOW.getDefaultState();
			break;

		}

		IBlockState iblockstate = Blocks.AIR.getDefaultState();

		if (flag) {

			worldIn.setBlockState(pos.add(0, 0, 0), iblockstate, 4);
			worldIn.setBlockState(pos.add(1, 0, 0), iblockstate, 4);
			worldIn.setBlockState(pos.add(0, 0, 1), iblockstate, 4);
			worldIn.setBlockState(pos.add(1, 0, 1), iblockstate, 4);

		} else {

			worldIn.setBlockState(pos, iblockstate, 4);

		}

		if (!gen.generate(worldIn, rand, pos)) {

			if (flag) {

				worldIn.setBlockState(pos.add(0, 0, 0), treeState, 4);
				worldIn.setBlockState(pos.add(1, 0, 0), treeState, 4);
				worldIn.setBlockState(pos.add(0, 0, 1), treeState, 4);
				worldIn.setBlockState(pos.add(1, 0, 1), treeState, 4);

			} else {

				worldIn.setBlockState(pos, treeState, 4);

			}

		}

	}

	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((Integer) state.getValue(STAGE)).intValue() << 3;
		return i;
	}

	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] { STAGE });

	}

	@Override
	protected boolean canSustainBush(IBlockState state) {

		return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT
				|| state.getBlock() == Blocks.FARMLAND;
	}

	@Override
	public void registerModels() {

		HarrysMod112.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

}
