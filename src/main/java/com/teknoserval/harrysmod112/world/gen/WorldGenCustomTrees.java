package com.teknoserval.harrysmod112.world.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.teknoserval.harrysmod112.world.biomes.BiomeCopper;
import com.teknoserval.harrysmod112.world.gen.generators.WorldGenCedarTree;
import com.teknoserval.harrysmod112.world.gen.generators.WorldGenMahoganyTree;
import com.teknoserval.harrysmod112.world.gen.generators.WorldGenWillowTree;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDesert;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeTaiga;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomTrees implements IWorldGenerator {

	private final WorldGenerator MAHOGANY = new WorldGenMahoganyTree();
	private final WorldGenerator CEDAR = new WorldGenCedarTree();
	private final WorldGenerator WILLOW = new WorldGenWillowTree();

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {

		switch (world.provider.getDimension()) {

		case 1:

			break;

		case 0:

			runGenerator(MAHOGANY, world, random, chunkX, chunkZ, .2D, -1, 0, BiomePlains.class, BiomeCopper.class);
			runGenerator(CEDAR, world, random, chunkX, chunkZ, .5D, -1, 0, BiomeTaiga.class);
			runGenerator(WILLOW, world, random, chunkX, chunkZ, .3D, -1, 0, BiomeForest.class);

			break;

		case -1:

		}

	}

	private void runGenerator(WorldGenerator generator, World worldIn, Random rand, int chunkX, int chunkZ,
			double chancesToSpawn, int minHeight, int maxHeight, Class<?>... classes) {

		if (chancesToSpawn < 1) {

			if (rand.nextDouble() < chancesToSpawn) {

				chancesToSpawn = 1;

			} else {

				chancesToSpawn = 0;

			}

		}

		ArrayList<Class<?>> classList = new ArrayList<Class<?>>(Arrays.asList(classes));
		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) {

			BlockPos pos = new BlockPos(chunkX * 16 + 10 + rand.nextInt(15), minHeight + rand.nextInt(heightDiff),
					chunkZ * 16 + 10 + rand.nextInt(15));

			if (minHeight < 0) {

				pos = worldIn.getHeight(pos);

			}

			Class<?> biome = worldIn.provider.getBiomeForCoords(pos).getClass();

			if (classList.contains(biome) || classes.length == 0) {

				generator.generate(worldIn, rand, pos);

			}

		}

	}

}
