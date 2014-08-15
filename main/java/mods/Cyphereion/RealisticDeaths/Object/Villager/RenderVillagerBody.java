package mods.Cyphereion.RealisticDeaths.Object.Villager;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderVillagerBody extends TileEntitySpecialRenderer{
	
	private ModelVillagerBody model;

	ResourceLocation texture = new ResourceLocation("textures/entity/villager/villager.png");
	
	public RenderVillagerBody(){
		this.model = new ModelVillagerBody(0);
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x + .5F, (float)y + 0.2F, (float)z + 0.7F);
			GL11.glRotatef(180, 0, 0, 1);
			this.bindTexture(texture);
			GL11.glPushMatrix();
			model.renderModel();
			GL11.glPopMatrix();
			GL11.glPopMatrix();
	}
}
