package mods.Cyphereion.RealisticDeaths.Object.Pig;

import net.minecraft.client.model.ModelQuadruped;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelPigBody extends ModelQuadruped
{
    private static final String __OBFID = "CL_00000849";

    public ModelPigBody()
    {
        this(0.0F);
    }
    
    public void renderModel(){
    	float f = .0625f;
    	this.head.render(f);
    }

    public ModelPigBody(float par1)
    {
        super(6, par1);
        this.head.setTextureOffset(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4, 3, 1, par1);
        this.field_78145_g = 4.0F;
    }
}