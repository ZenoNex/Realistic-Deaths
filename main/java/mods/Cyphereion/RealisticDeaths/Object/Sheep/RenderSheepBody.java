package mods.Cyphereion.RealisticDeaths.Object.Sheep;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderSheepBody extends TileEntitySpecialRenderer{
	
	private ModelSheepBody model;

	ResourceLocation texture = new ResourceLocation("textures/entity/sheep/sheep.png");
	
	public RenderSheepBody(){
		this.model = new ModelSheepBody();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x + .5F, (float)y + .6F, (float)z + 1F);
			GL11.glRotatef(180, 0, 0, 1);
			this.bindTexture(texture);
			GL11.glPushMatrix();
			model.renderModel();
			GL11.glPopMatrix();
			GL11.glPopMatrix();
	}
}
