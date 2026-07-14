package trinity.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static trinity.init.ModItems.*;

@SideOnly(Side.CLIENT)
public class ModItemsClient {

	public static void registerRenders() {
		registerRender(trinitite);
		registerRender(gem_witherite);
		registerRender(gem_dust_witherite);
		registerRender(barium);
		registerRender(compound_barium_nitrate);
		registerRender(compound_barium_oxide);
		registerRender(compound_lithium_deuteride);
		registerRender(dust_au_198);
		registerRender(ingot_au_198);
		registerRender(source_au_198);

		registerRender(bomb_pit_u233);
		registerRender(bomb_pit_u235);
		registerRender(bomb_pit_np237);
		registerRender(bomb_pit_pu239);
		registerRender(bomb_pit_am242);
		registerRender(bomb_pit_cm247);
		registerRender(bomb_pit_bk248);
		registerRender(bomb_pit_cf249);
		registerRender(bomb_pit_cf251);

		registerRender(detonator);
		registerRender(neutron_initiator);
	}

	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));

	}
}