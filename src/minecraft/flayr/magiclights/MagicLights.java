package flayr.magiclights;

// This Import list will grow longer with each additional tutorial.
// It's not pruned between full class postings, unlike other tutorial code.
import net.minecraft.block.Block;
import flayr.magiclights.tileentities.TileEntityLight;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = MagicLights.MOD_ID, name = MagicLights.MOD_NAME, version = MagicLights.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class MagicLights
{
    public static final String MOD_ID = "MagicLights";
    static final String MOD_NAME = "Magic Lights";
    static final String MOD_VERSION = "1.0.0";
    static final String SOURCE_PATH = "flayr.magiclights.";
    private static int lightStaffID;
    private static int lightID;
    private static int lightAlterID;
    public static Item lightStaff;
    public static Block light;
    public static Block lightAlter;
    
	public static CreativeTabs tabMagicLights = new CreativeTabs("tabMagicLights"){
		public ItemStack getIconItemStack(){
			return new ItemStack(lightStaff);
		}
	};
    
        @Mod.Instance("MOD_ID")
        public static MagicLights instance;

        @SidedProxy(clientSide="flayr.magiclights.client.ClientProxy",
                        serverSide="flayr.magiclights.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
            Configuration config = new Configuration(event.getSuggestedConfigurationFile());
       
            config.load();
            lightID = config.getBlock("light", 672).getInt();
            lightID = config.getBlock("lightAlter", 673).getInt();
            lightStaffID = config.getItem("lightStaff", 2527).getInt();
            config.save();
        }
        
        @EventHandler
        public void load(FMLInitializationEvent event) {
            lightStaff = new LightStaff(lightStaffID);
            light = new Light(lightID, Material.rock);
            light = new Block(lightAlterID, Material.rock)
            
        	ItemStack starStack = new ItemStack(Item.netherStar);
        	ItemStack stickStack = new ItemStack(Item.stick);
        	ItemStack goldStack = new ItemStack(Item.ingotGold);
        	
        	GameRegistry.addRecipe(new ItemStack(lightStaff, 4), "gng", " s ", " s ",
        	        'n', starStack, 's', stickStack, 'g', goldStack);
        	    
            LanguageRegistry.addName(lightStaff, "Staff of Light");
            LanguageRegistry.addName(light, "Light");
            LanguageRegistry.addName(lightAlter, "Alter of Light");
            LanguageRegistry.instance().addStringLocalization("itemGroup.tabMagicLights", "en_US", MOD_NAME);
            GameRegistry.registerBlock(light, "light");
            GameRegistry.registerBlock(lightAlter, "lightAlter");
            proxy.registerRenderers();
            GameRegistry.registerTileEntity(TileEntityLight.class, "tileEntityLight");
        }
        
        @Mod.EventHandler
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}
