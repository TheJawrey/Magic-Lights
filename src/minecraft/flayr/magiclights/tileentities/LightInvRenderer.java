package flayr.magiclights.tileentities;

import java.util.List;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import flayr.magiclights.MagicLights;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class LightInvRenderer extends TileEntitySpecialRenderer{
	@SideOnly(Side.CLIENT)
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		
		ItemStack heldItem = Minecraft.getMinecraft().thePlayer.getHeldItem();
   	    ItemStack staff = new ItemStack(MagicLights.lightStaff);
		if (heldItem != null && ItemStack.areItemStacksEqual(heldItem, staff)) {
			
		ResourceLocation rl = new ResourceLocation("magiclights:textures/blocks/lightInv.png");
		Minecraft.getMinecraft().renderEngine.bindTexture(rl);
		
		Tessellator tessellator = Tessellator.instance;
        GL11.glPushMatrix();
        GL11.glTranslated(x+0.5, y+0.5, z+0.5);
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
}