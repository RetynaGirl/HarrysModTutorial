package com.teknoserval.harrysmod112.world.biomes;

import java.util.Random;

import com.teknoserval.harrysmod112.init.BlockInit;
import com.teknoserval.harrysmod112.objects.blocks.BlockBaseOre;
import com.teknoserval.harrysmod112.util.handlers.EnumHandler;
import com.teknoserval.harrysmod112.world.gen.generators.WorldGenMahoganyTree;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;


public class BiomeCopper extends Biome {
	
	protected static final WorldGenAbstractTree TREE = new WorldGenMahoganyTree();

	public BiomeCopper() {
		super(new BiomeProperties("Copper").setBaseHeight(1.5F).setHeightVariation(1.2F).setTemperature(0.6F)
				.setRainDisabled().setWaterColor(14287084));
		
		topBlock = BlockInit.BLOCK_RED_GRASS.getDefaultState();
		fillerBlock = BlockInit.BLOCK_RED_DIRT.getDefaultState();
		
		
		this.decorator.coalGen = new WorldGenMinable(BlockInit.ORE_OVERWORLD.getDefaultState().withProperty(BlockBaseOre.VARIANT, EnumHandler.OreType.COPPER), 9);

		
		this.decorator.treesPerChunk = 1;
		
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		
		this.spawnableCreatureList.add(new SpawnListEntry(EntityWither.class, 10, 1, 3));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityDragon.class, 10, 1, 3));
		
	}
	
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		
		return TREE;
		
	}

}
