package flayr.magiclights;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class Light extends Block 
{

        public Light (int id, Material material) 
        {
                super(id, material);
        }
        
        @Override
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister iconRegister) {
            this.blockIcon = iconRegister.registerIcon("magiclights:light");
        }

}