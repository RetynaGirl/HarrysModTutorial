package com.teknoserval.harrysmod112.objects.blocks;

import java.util.List;

import com.teknoserval.harrysmod112.HarrysMod112;
import com.teknoserval.harrysmod112.init.BlockInit;
import com.teknoserval.harrysmod112.init.ItemInit;
import com.teknoserval.harrysmod112.objects.blocks.item.ItemBlockVariants;
import com.teknoserval.harrysmod112.util.handlers.EnumHandler;
import com.teknoserval.harrysmod112.util.interfaces.IHasModel;
import com.teknoserval.harrysmod112.util.interfaces.IMetaName;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBaseLeaves extends BlockLeaves implements IHasModel, IMetaName {

	public static final PropertyBool DECAYABLE = PropertyBool.create("decayable");
	public static final PropertyBool CHECK_DECAY = PropertyBool.create("check_decay");

	public BlockBaseLeaves(String name) {

		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.PLANT);
		setCreativeTab(HarrysMod112.TUTORIAL);
		setDefaultState(this.getDefaultState().withProperty(DECAYABLE, true).withProperty(CHECK_DECAY, true));
		

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));

	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {

		return NonNullList.withSize(1, new ItemStack(this, 1));

	}

	@Override
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {

		return;

	}

	@Override
	protected int getSaplingDropChance(IBlockState state) {
		// TODO Auto-generated method stub
		return 30;
	}

	protected BlockStateContainer createBlockState() {

		return new BlockStateContainer(this, new IProperty[] { DECAYABLE, CHECK_DECAY });

	}

	@Override
	public IBlockState getStateFromMeta(int meta) {

		return this.getDefaultState();

	}

	@Override
	public int getMetaFromState(IBlockState state) {

		int i = 0;

		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue()) {

			i |= 2;

		}

		if (!((Boolean) state.getValue(CHECK_DECAY)).booleanValue()) {

			i |= 4;

		}
		
		return i;

	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		// TODO Auto-generated method stub
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public EnumType getWoodType(int meta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerModels() {

		HarrysMod112.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");

	}

	@Override
	public String getSpeacialName(ItemStack stack) {
		// TODO Auto-generated method stub
		return null;
	}

}
