package trinity.init;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import trinity.Reference;
import trinity.config.TrinityConfig;

import static trinity.init.ModBlocks.*;

@SideOnly(Side.CLIENT)
public class ModBlocksClient {
	public static void registerRenders() {
		registerRender(light_container);
		registerRender(medium_container);
		registerRender(heavy_container);
		registerRender(compression_charge);
		registerRender(baratol);
		registerRender(dirty_bomb);
		registerRender(fusion_bomb);
		registerRender(empty_fusion_bomb);
		registerRender(gold_bomb);
		registerRender(core_u233);
		registerRender(core_u235);
		registerRender(core_np237);
		registerRender(core_pu239);
		registerRender(core_am242);
		registerRender(core_cm247);
		registerRender(core_bk248);
		registerRender(core_cf249);
		registerRender(core_cf251);
		
		registerRender(salted_core_u233);
		registerRender(salted_core_u235);
		registerRender(salted_core_np237);
		registerRender(salted_core_pu239);
		registerRender(salted_core_am242);
		registerRender(salted_core_cm247);
		registerRender(salted_core_bk248);
		registerRender(salted_core_cf249);
		registerRender(salted_core_cf251);
		
		registerRender(thermonuclear_core_pu239);
		
		registerRender(bomb_u233);
		registerRender(bomb_u235);
		registerRender(bomb_np237);
		registerRender(bomb_pu239);
		registerRender(bomb_am242);
		registerRender(bomb_cm247);
		registerRender(bomb_bk248);
		registerRender(bomb_cf249);
		registerRender(bomb_cf251);
		
		registerRender(salted_bomb_u233);
		registerRender(salted_bomb_u235);
		registerRender(salted_bomb_np237);
		registerRender(salted_bomb_pu239);
		registerRender(salted_bomb_am242);
		registerRender(salted_bomb_cm247);
		registerRender(salted_bomb_bk248);
		registerRender(salted_bomb_cf249);
		registerRender(salted_bomb_cf251);
		registerRender(bomb_antimatter);
		registerRender(radioactive_earth);
		registerRender(radioactive_earth2);
		registerRender(trinitite);
		registerRender(solid_trinitite);
		registerRender(salted_sand);
		registerRender(salted_sand2);
		
		if (TrinityConfig.custom_nukes) {
			registerRenders(core_custom, "core_custom_1");
			registerRenders(salted_core_custom, "salted_core_u233");
			registerRenders(bomb_custom, "bomb_custom_1");
			registerRenders(salted_bomb_custom, "salted_bomb_custom_1");
		}
	}

	private static void registerRenders(Block[] blocks, String modelName) {
		for (Block block : blocks) {
			registerRender(block, modelName);
		}
	}

	public static void registerRender(Block block) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}

	public static void registerRender(Block block, String modelName) {
		ModelResourceLocation modelLocation = new ModelResourceLocation(Reference.MOD_ID + ":" + modelName, "normal");
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + modelName, "inventory"));
		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return modelLocation;
			}
		});
	}
}