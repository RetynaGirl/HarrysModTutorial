package com.teknoserval.harrysmod112.init;

import java.util.ArrayList;
import java.util.List;

import com.teknoserval.harrysmod112.objects.blocks.BlockBase;
import com.teknoserval.harrysmod112.objects.blocks.BlockBaseLeaves;
import com.teknoserval.harrysmod112.objects.blocks.BlockBaseLog;
import com.teknoserval.harrysmod112.objects.blocks.BlockBasePlanks;
import com.teknoserval.harrysmod112.objects.blocks.BlockBaseSapling;
import com.teknoserval.harrysmod112.objects.blocks.BlockBaseOre;
import com.teknoserval.harrysmod112.util.handlers.EnumHandler.WoodType;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;

public class BlockInit {
	
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BLOCK_COPPER = new BlockBase("block_copper", Material.IRON);
	
	public static final Block ORE_END = new BlockBaseOre("ore_end", "end");
	public static final Block ORE_OVERWORLD = new BlockBaseOre("ore_overworld", "overworld");
	public static final Block ORE_NETHER = new BlockBaseOre("ore_nether", "nether");
	
	public static final Block PLANKS = new BlockBasePlanks("wood_planks", "planks", Material.WOOD);
	public static final Block LOG_MAHOGANY = new BlockBaseLog("log_mahogany");
	public static final Block LOG_CEDAR = new BlockBaseLog("log_cedar");
	public static final Block LOG_WILLOW = new BlockBaseLog("log_willow");
	public static final Block LEAVES_MAHOGANY = new BlockBaseLeaves("leaves_mahogany");
	public static final Block LEAVES_CEDAR = new BlockBaseLeaves("leaves_cedar");
	public static final Block LEAVES_WILLOW = new BlockBaseLeaves("leaves_willow");
	public static final Block SAPLING_MAHOGANY = new BlockBaseSapling("sapling_mahogany", WoodType.MAHOGANY);
	public static final Block SAPLING_CEDAR = new BlockBaseSapling("sapling_cedar", WoodType.CEDAR);
	public static final Block SAPLING_WILLOW = new BlockBaseSapling("sapling_willow", WoodType.WILLOW);
	

}
