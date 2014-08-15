package mods.Cyphereion.RealisticDeaths.Object.Spider;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderSpiderBody extends TileEntitySpecialRenderer{
	
	private ModelSpiderBody model;

	ResourceLocation texture = new ResourceLocation("textures/entity/spider/spider.png");
	
	public RenderSpiderBody(){
		this.model = new ModelSpiderBody();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x + .5F, (float)y + 1.2F, (float)z + .95F);
			GL11.glRotatef(180, 0, 0, 1);
			this.bindTexture(texture);
			GL11.glPushMatrix();
			model.renderModel();
			GL11.glPopMatrix();
			GL11.glPopMatrix();
	}
}
