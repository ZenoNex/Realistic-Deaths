package mods.Cyphereion.RealisticDeaths.Object.Skeleton;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderSkeletonBody extends TileEntitySpecialRenderer{
	
	private ModelSkeletonBody model;

	ResourceLocation texture = new ResourceLocation("textures/entity/skeleton/skeleton.png");
	
	public RenderSkeletonBody(){
		this.model = new ModelSkeletonBody();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x + .5F, (float)y + 0F, (float)z + .5F);
			GL11.glRotatef(180, 0, 0, 1);
			this.bindTexture(texture);
			GL11.glPushMatrix();
			model.renderModel();
			GL11.glPopMatrix();
			GL11.glPopMatrix();
	}
}
