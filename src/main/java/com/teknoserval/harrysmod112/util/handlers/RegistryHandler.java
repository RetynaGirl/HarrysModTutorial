package com.teknoserval.harrysmod112.util.handlers;

import com.teknoserval.harrysmod112.init.BiomeInit;
import com.teknoserval.harrysmod112.init.BlockInit;
import com.teknoserval.harrysmod112.init.EntityInit;
import com.teknoserval.harrysmod112.init.ItemInit;
import com.teknoserval.harrysmod112.util.interfaces.IHasModel;
import com.teknoserval.harrysmod112.world.gen.WorldGenCustomTrees;
import com.teknoserval.harrysmod112.world.gen.WorldGenCustomOres;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {

		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));

	}

	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {

		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));

	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {

		for (Item item : ItemInit.ITEMS) {

			if (item instanceof IHasModel) {

				((IHasModel) item).registerModels();

			}

		}

		for (Block block : BlockInit.BLOCKS) {

			if (block instanceof IHasModel) {

				((IHasModel) block).registerModels();

			}

		}

	}

	public static void preInitRegistries() {

		GameRegistry.registerWorldGenerator(new WorldGenCustomOres(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenCustomTrees(), 0);

		BiomeInit.registerBiomes();
		EntityInit.registerEntities();
		RenderHandler.registerEntityRenders();

	}

	public static void initRegistries() {
		
		SoundsHandler.registerSounds();

	}

}
