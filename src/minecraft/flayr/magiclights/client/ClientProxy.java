package flayr.magiclights.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;
import flayr.magiclights.tileentities.LightInvRenderer;
import flayr.magiclights.tileentities.LightRenderer;
import flayr.magiclights.tileentities.TileEntityLight;
import flayr.magiclights.tileentities.TileEntityLightInv;
import flayr.magiclights.CommonProxy;
import net.minecraftforge.client.MinecraftForgeClient;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
        
    @Override
    public void registerRenderers() {
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLight.class, new LightRenderer());
    	
    	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLightInv.class, new LightInvRenderer());
	}
}