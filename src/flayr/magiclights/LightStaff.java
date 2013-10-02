package flayr.magiclights;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LightStaff extends Item {

        public LightStaff(int id) {
                super(id);
                
                // Constructor Configuration
                maxStackSize = 1;
                setCreativeTab(MagicLights.tabMagicLights);
                setUnlocalizedName("lightStaff");
        }
        

        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister iconRegister) {
            this.itemIcon = iconRegister.registerIcon("magiclights:lightStaff");
        }
}