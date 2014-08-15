package mods.Cyphereion.RealisticDeaths.Object.Cat;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderCatBody extends TileEntitySpecialRenderer{
	
	private ModelCatBody model;

	ResourceLocation texture = new ResourceLocation("textures/entity/cat/ocelot.png");
	
	public RenderCatBody(){
		this.model = new ModelCatBody();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + .5F, (float)y + 1.1F, (float)z + 1F);
		GL11.glRotatef(180, 0, 0, 1);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		model.renderModel();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
