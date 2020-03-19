package com.teknoserval.harrysmod112.world.gen.generators;

import java.util.Random;

import com.teknoserval.harrysmod112.init.BlockInit;
import com.teknoserval.harrysmod112.objects.blocks.BlockBaseLog;
import com.teknoserval.harrysmod112.objects.blocks.BlockBaseSapling;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenCedarTree extends WorldGenAbstractTree {

	public static IBlockState LOG = BlockInit.LOG_CEDAR.getStateFromMeta(1);
	public static final IBlockState LEAF = BlockInit.LEAVES_CEDAR.getDefaultState();

	private int minHeight;

	public WorldGenCedarTree() {

		super(false);
		this.minHeight = 12;

	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {

		int height = this.minHeight + rand.nextInt(4);
		boolean flag = true;

		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		for (int yPos = y; yPos <= y + 1 + height; yPos++) {

			if (!(worldIn.getBlockState(new BlockPos(x, yPos, z)) == Blocks.AIR.getDefaultState())) {

				flag = false;

			}

		}

		if (!flag) {

			return false;

		} else {

			BlockPos down = pos.down();
			IBlockState state = worldIn.getBlockState(down);

			boolean isSoil = state.getBlock().canSustainPlant(state, worldIn, down, EnumFacing.UP,
					(BlockBaseSapling) BlockInit.SAPLING_CEDAR);

			if (isSoil && worldIn.getHeight() >= height + 1) {

				state.getBlock().onPlantGrow(state, worldIn, down, pos);

				for (int yPos = y - 3 + height; yPos <= y + height; yPos++) {

					int b1 = yPos - (y + height);
					int b2 = 1 - b1 / 2;

					for (int xPos = x - b2; xPos <= x + b2; xPos++) {

						int b3 = xPos - x;

						for (int zPos = z - b2; zPos <= z + b2; zPos++) {

							int b4 = zPos - z;

							if (Math.abs(b3) != b2 || Math.abs(b4) != b2 || (rand.nextInt(2) != 0 && b1 != 0)) {

								BlockPos treePos = new BlockPos(xPos, yPos, zPos);
								IBlockState treeState = worldIn.getBlockState(treePos);
								if (treeState == Blocks.AIR.getDefaultState()) {

									this.setBlockAndNotifyAdequately(worldIn, treePos, LEAF);

								}

								if (worldIn.getBlockState(treePos.add(0, -0.25 * height, 0)) == Blocks.AIR
										.getDefaultState()) {

									this.setBlockAndNotifyAdequately(worldIn, treePos.add(0, -0.25 * height, 0), LEAF);

								}

								if (worldIn.getBlockState(treePos.add(0, -0.5 * height, 0)) == Blocks.AIR
										.getDefaultState()) {

									this.setBlockAndNotifyAdequately(worldIn, treePos.add(0, -0.5 * height, 0), LEAF);

								}

							}

						}

					}

				}

				for (int logHeight = 0; logHeight < height - 1; logHeight++) {

					BlockPos up = pos.up(logHeight);
					IBlockState logState = worldIn.getBlockState(up);
					if (logState.getBlock().isAir(logState, worldIn, up)
							|| logState.getBlock().isLeaves(logState, worldIn, up)) {

						this.setBlockAndNotifyAdequately(worldIn, up, LOG);

					}

				}

				return true;

			}

		}

		return true;

	}

}
