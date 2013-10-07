package flayr.magiclights;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import flayr.magiclights.tileentities.TileEntityLight;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Light extends BlockContainer 
{
        public Light (int id, Material material) 
        {
                super(id, material);
                this.setHardness(0.0F);
                this.setLightValue(1.0f);
                this.setUnlocalizedName("lightBlock");
                this.setCreativeTab(MagicLights.tabMagicLights);
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
        public TileEntity createNezwTileEntity(World par1World)
        {
                 return new TileEntityLight();
        }
		@Override
        public boolean renderAsNormalBlock()
        {
        	return false;
        }
}