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
        
    	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int s, float par8, float par9, float par10){
    			if(world.getBlockId(x, y, z)==MagicLights.light.blockID){
        				world.setBlock(x, y, z, MagicLights.lightInv.blockID);
        				world.notifyBlockOfNeighborChange(x, y, z, MagicLights.light.blockID);
        				return true;
        		}
    			if(world.getBlockId(x, y, z)==MagicLights.lightInv.blockID){
    				world.setBlock(x, y, z, MagicLights.light.blockID);
    				world.notifyBlockOfNeighborChange(x, y, z, MagicLights.light.blockID);
    				return true;
    			}
    			//
    			//
    			if(s == 1 && player.canPlayerEdit(x, y + 1, z, s, stack)){
    				world.setBlock(x, y + 1, z, MagicLights.light.blockID);
    				world.notifyBlockOfNeighborChange(x, y + 1, z, MagicLights.light.blockID);
    				return true;}
    			if(s == 2 && player.canPlayerEdit(x, y, z - 1, s, stack)){
    				world.setBlock(x, y, z - 1, MagicLights.light.blockID);
    				world.notifyBlockOfNeighborChange(x, y , z - 1, MagicLights.light.blockID);
    				return true;}
    			if(s == 3 && player.canPlayerEdit(x, y, z + 1, s, stack)){
    				world.setBlock(x, y, z + 1, MagicLights.light.blockID);
    				world.notifyBlockOfNeighborChange(x, y, z + 1, MagicLights.light.blockID);
    				return true;}
    			if(s == 4 && player.canPlayerEdit(x - 1, y, z, s, stack)){
    				world.setBlock(x - 1, y, z, MagicLights.light.blockID);
    				world.notifyBlockOfNeighborChange(x - 1, y, z, MagicLights.light.blockID);
    				return true;}
    			if(s == 5 && player.canPlayerEdit(x + 1, y, z, s, stack)){
    				world.setBlock(x + 1, y, z, MagicLights.light.blockID);
    				world.notifyBlockOfNeighborChange(x + 1, y, z, MagicLights.light.blockID);
    				return true;}
    			if(s == 0 && player.canPlayerEdit(x, y - 1, z, s, stack)){
    				world.setBlock(x, y - 1, z, MagicLights.light.blockID);
    				world.notifyBlockOfNeighborChange(x, y - 1, z, MagicLights.light.blockID);
    				return true;}
    			
    			else{return false;}
    		}
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister iconRegister) {
            this.itemIcon = iconRegister.registerIcon("magiclights:lightStaff");
        }
}