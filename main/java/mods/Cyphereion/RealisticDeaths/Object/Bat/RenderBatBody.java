package mods.Cyphereion.RealisticDeaths.Object.Bat;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderBatBody extends TileEntitySpecialRenderer{
	
	private ModelBatBody model;

	ResourceLocation texture = new ResourceLocation("textures/entity/bat.png");
	
	public RenderBatBody(){
		this.model = new ModelBatBody();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x + .5F, (float)y + .4F, (float)z + 0.3F);
			GL11.glRotatef(180, 0, 0, 1);
			this.bindTexture(texture);
			GL11.glPushMatrix();
			model.renderModel();
			GL11.glPopMatrix();
			GL11.glPopMatrix();
	}
}
