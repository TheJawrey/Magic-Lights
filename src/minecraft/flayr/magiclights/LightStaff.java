package flayr.magiclights;

import com.jcraft.jorbis.Block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LightStaff extends Item {

        public LightStaff(int id) {
                super(id);
                
                // Constructor Configuration
                maxStackSize = 1;
                setCreativeTab(MagicLights.tabMagicLights);
                setUnlocalizedName("lightStaff");
        }
        
    	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10){
    		if(par7 != 1){
    			return false;
    		}else{
    			if(player.canPlayerEdit(x, y + 1, z, par7, stack)){
    				world.setBlock(x, y + 1, z, MagicLights.light.blockID);
    				world.notifyBlockOfNeighborChange(x, y + 1, z, MagicLights.light.blockID);
    				return true;
    			}else{
    				return false;
    			}
    		}
    	}
    	
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister iconRegister) {
            this.itemIcon = iconRegister.registerIcon("magiclights:lightStaff");
        }
}