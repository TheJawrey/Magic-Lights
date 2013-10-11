package flayr.magiclights;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import flayr.magiclights.tileentities.TileEntityLight;
import flayr.magiclights.tileentities.TileEntityLightInv;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class LightInv extends Light
{
        public LightInv (int id, Material material) 
        {
                super(id, material);
                this.setUnlocalizedName("lightInv");
                this.setCreativeTab(MagicLights.tabMagicLights);
        }
        @Override
        public TileEntity createNewTileEntity(World par1world)
        {
			AxisAlignedBB aabb = AxisAlignedBB.getAABBPool().getAABB(-4, -4, -4, +4, +4, +4);
			List w = par1world.getEntitiesWithinAABB(EntityPlayer.class, aabb);
			if(w.size() > 0) {
			     //at least one player in range
			     EntityPlayer player;
			     for(int i = 0; i < w.size();) {
			    	 player = (EntityPlayer) w.get(i);
			    	 ItemStack stack = player.getHeldItem();
			    	 ItemStack stack2 = new ItemStack(MagicLights.lightStaff);
				     if(ItemStack.areItemStacksEqual(stack, stack2)){
		                 return new TileEntityLightInv();
				     }else{return null;}
			     }
			     return null;
		    }else{return null;}
        }
        @Override
        public void registerIcons(IconRegister iconRegister) {
            this.blockIcon = iconRegister.registerIcon("magiclights:lightInv");
        }
}