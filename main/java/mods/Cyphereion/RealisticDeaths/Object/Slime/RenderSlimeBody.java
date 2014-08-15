package mods.Cyphereion.RealisticDeaths.Object.Slime;

import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderSlimeBody extends TileEntitySpecialRenderer{
	
	private ModelExtendedSlime model;

	ResourceLocation texture = new ResourceLocation("textures/entity/slime/slime.png");
	
	public RenderSlimeBody(){
		this.model = new ModelExtendedSlime(0);
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
			GL11.glPushMatrix();
			GL11.glTranslatef((float)x + .5f, (float)y + 1.5f, (float)z + .3f);
			GL11.glRotatef(180, 0, 0, 1);
			this.bindTexture(texture);
			model.renderModel();
			GL11.glPopMatrix();
	}
}
