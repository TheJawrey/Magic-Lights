package flayr.magiclights;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import flayr.magiclights.tileentities.TileEntityLight;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Light extends BlockContainer 
{
        public Light (int id, Material material) 
        {
                super(id, material);
                this.setHardness(0.0F);
                this.setLightValue(1.0f);
                this.setUnlocalizedName("light");
        }
        
        @Override
        public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
        {
           return false;
        }
        @Override
        public boolean isOpaqueCube()
        {
           return false;}

		@Override
        public TileEntity createNewTileEntity(World par1world)
        {
                 return new TileEntityLight();
        }
		@Override
        public boolean renderAsNormalBlock()
        {
        	return false;
        }
		@Override
	    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
		{
			return null;
		}
		@Override
	    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	    {
	    	return null;
	    }
		@Override
		public MovingObjectPosition collisionRayTrace(World par1World, int x, int y, int z, Vec3 par5Vec3, Vec3 par6Vec3)
		{
			AxisAlignedBB aabb = AxisAlignedBB.getAABBPool().getAABB(x-4, y-4, z-4, x+4, y+4, z+4);
			List w = par1World.getEntitiesWithinAABB(EntityPlayer.class, aabb);
			if(w.size() > 0) {
			     //at least one player in range
			     EntityPlayer player;
			     for(int i = 0; i < w.size();) {
			    	 player = (EntityPlayer) w.get(i);
			    	 ItemStack stack = player.getHeldItem();
			    	 ItemStack stack2 = new ItemStack(MagicLights.lightStaff);
				     if(ItemStack.areItemStacksEqual(stack, stack2)){
				    	 return super.collisionRayTrace(par1World, x, y, z, par5Vec3, par6Vec3);
				     }else{return null;}
			     }
			     return null;
		    }else{return null;}
		}
        
        public void registerIcons(IconRegister iconRegister) {
            this.blockIcon = iconRegister.registerIcon("magiclights:light");
        }
}