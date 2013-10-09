package flayr.magiclights;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import flayr.magiclights.tileentities.TileEntityLight;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
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

		/*@Override
        public TileEntity createNewTileEntity(World par1world)
        {
                 return new TileEntityLight();
        }*/
}