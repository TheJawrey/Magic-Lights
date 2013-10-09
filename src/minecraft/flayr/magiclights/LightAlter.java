package flayr.magiclights;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LightAlter extends Block
{
        public LightAlter (int id, Material material) 
        {
                super(id, material);
                this.setHardness(1.0F);
                this.setLightValue(1.0f);
                this.setUnlocalizedName("lightAlter");
                this.setCreativeTab(MagicLights.tabMagicLights);
        }
        @SideOnly(Side.CLIENT)
        public void registerIcons(IconRegister iconRegister) {
            this.blockIcon = iconRegister.registerIcon("magiclights:lightAlter");
}
}