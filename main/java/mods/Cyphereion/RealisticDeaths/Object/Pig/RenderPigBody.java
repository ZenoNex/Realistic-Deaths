package mods.Cyphereion.RealisticDeaths.Object.Pig;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderPigBody extends TileEntitySpecialRenderer{
	
	private ModelPigBody model;

	ResourceLocation texture = new ResourceLocation("textures/entity/pig/pig.png");
	
	public RenderPigBody(){
		this.model = new ModelPigBody();
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
