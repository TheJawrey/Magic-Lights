package flayr.magiclights.tileentities;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class LightRenderer extends TileEntitySpecialRenderer{
    
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {

    	ResourceLocation rl = new ResourceLocation("magiclights:textures/blocks/light.png");
    	Minecraft.getMinecraft().renderEngine.bindTexture(rl);
    	
        Tessellator tessellator = Tessellator.instance;
        GL11.glPushMatrix();
        GL11.glTranslated(x+0.5, y+0.5, z+0.5);//+1 so that our "drawing" appears 1 block over our block (to get a better view)
        GL11.glNormal3f(0.0F, 10.0F, 0.0F);
        GL11.glRotatef(-this.tileEntityRenderer.playerYaw, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(this.tileEntityRenderer.playerPitch, 1.0F, 0.0F, 0.0F);
        
        tessellator.startDrawingQuads();
        
        tessellator.addVertexWithUV(-0.5, 0.5, 0, 1, 0);
        tessellator.addVertexWithUV(0.5, 0.5, 0, 1, 1);
        tessellator.addVertexWithUV(-0.5, -0.5, 0, 0, 0);
        tessellator.addVertexWithUV(0.5, -0.5, 0, 0, 1);
        
        tessellator.addVertexWithUV(0.5, -0.5, 0, 1, 0);
        tessellator.addVertexWithUV(-0.5, -0.5, 0, 0, 0);
        tessellator.addVertexWithUV(0.5, 0.5, 0, 1, 1);
        tessellator.addVertexWithUV(-0.5, 0.5, 0, 0, 1);

        tessellator.draw();
        GL11.glPopMatrix();
    }
}