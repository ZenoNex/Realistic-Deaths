package mods.Cyphereion.RealisticDeaths.Object.Boss;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBoss extends ModelBase
{
  //fields
    ModelRenderer Rib01;
    ModelRenderer Rib03;
    ModelRenderer Rib02;
    ModelRenderer Rib04;
    ModelRenderer Rib05;
    ModelRenderer Udder;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer SpiderTorso;
    ModelRenderer SpiderBack;
    ModelRenderer SpiderLeg01;
    ModelRenderer SpiderLeg02;
    ModelRenderer SpiderLeg03;
    ModelRenderer SpiderLeg04;
    ModelRenderer SpiderLeg05;
    ModelRenderer SpiderLeg06;
    ModelRenderer SpiderLeg07;
    ModelRenderer SpiderLeg08;
    ModelRenderer Rib06;
    ModelRenderer Rib07;
    ModelRenderer Rib08;
    ModelRenderer Rib09;
    ModelRenderer Rib10;
    ModelRenderer head02;
    ModelRenderer head03;
    ModelRenderer Shape1;
  
  public ModelBoss()
  {
    textureWidth = 128;
    textureHeight = 256;
    
      Rib01 = new ModelRenderer(this, 100, 150);
      Rib01.addBox(0F, 0F, 0F, 3, 1, 1);
      Rib01.setRotationPoint(-4F, 1F, -4F);
      Rib01.setTextureSize(128, 256);
      Rib01.mirror = true;
      setRotation(Rib01, 0F, 0.5235988F, -0.0872665F);
      Rib03 = new ModelRenderer(this, 100, 150);
      Rib03.addBox(0F, 0F, 0F, 3, 1, 1);
      Rib03.setRotationPoint(-4F, 3F, -4F);
      Rib03.setTextureSize(128, 256);
      Rib03.mirror = true;
      setRotation(Rib03, 0F, 0.5235988F, 0.2617994F);
      Rib02 = new ModelRenderer(this, 100, 150);
      Rib02.addBox(0F, 0F, 0F, 3, 1, 1);
      Rib02.setRotationPoint(1.3F, 3.8F, -5F);
      Rib02.setTextureSize(128, 256);
      Rib02.mirror = true;
      setRotation(Rib02, 0F, -0.5235988F, -0.2617994F);
      Rib04 = new ModelRenderer(this, 100, 150);
      Rib04.addBox(0F, 0F, 0F, 1, 6, 1);
      Rib04.setRotationPoint(-4F, -1F, -4F);
      Rib04.setTextureSize(128, 256);
      Rib04.mirror = true;
      setRotation(Rib04, 0F, 0F, 0F);
      Rib05 = new ModelRenderer(this, 100, 150);
      Rib05.addBox(0F, 0F, 0F, 1, 6, 1);
      Rib05.setRotationPoint(3F, -1F, -4F);
      Rib05.setTextureSize(128, 256);
      Rib05.mirror = true;
      setRotation(Rib05, 0F, 0F, 0F);
      Udder = new ModelRenderer(this, 1, 53);
      Udder.addBox(0F, 0F, 0F, 4, 4, 1);
      Udder.setRotationPoint(-2F, 6F, -4F);
      Udder.setTextureSize(128, 256);
      Udder.mirror = true;
      setRotation(Udder, 0F, 0F, 0F);
      head = new ModelRenderer(this, 96, 37);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, -1.466667F, -1F);
      head.setTextureSize(128, 256);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 18, 94);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, -1F, -1F);
      body.setTextureSize(128, 256);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 25, 18);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 1F, -1F);
      rightarm.setTextureSize(128, 256);
      rightarm.mirror = true;
      setRotation(rightarm, -1.570796F, 0F, 0F);
      leftarm = new ModelRenderer(this, 63, 19);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 1F, -1F);
      leftarm.setTextureSize(128, 256);
      leftarm.mirror = true;
      setRotation(leftarm, -1.570796F, 0F, 0F);
      SpiderTorso = new ModelRenderer(this, 2, 153);
      SpiderTorso.addBox(0F, 0F, 0F, 8, 5, 8);
      SpiderTorso.setRotationPoint(-4F, 11F, -4F);
      SpiderTorso.setTextureSize(128, 256);
      SpiderTorso.mirror = true;
      setRotation(SpiderTorso, 0F, 0F, 0F);
      SpiderBack = new ModelRenderer(this, 1, 124);
      SpiderBack.addBox(0F, 0F, 0F, 12, 9, 14);
      SpiderBack.setRotationPoint(-6F, 9F, 3F);
      SpiderBack.setTextureSize(128, 256);
      SpiderBack.mirror = true;
      setRotation(SpiderBack, 0F, 0F, 0F);
      SpiderLeg01 = new ModelRenderer(this, 1, 3);
      SpiderLeg01.addBox(0F, 0F, 0F, 1, 14, 1);
      SpiderLeg01.setRotationPoint(-4F, 13F, -2F);
      SpiderLeg01.setTextureSize(128, 256);
      SpiderLeg01.mirror = true;
      setRotation(SpiderLeg01, 0F, -0.4363323F, 1.134464F);
      SpiderLeg02 = new ModelRenderer(this, 1, 3);
      SpiderLeg02.addBox(0F, 0F, 0F, 1, 14, 1);
      SpiderLeg02.setRotationPoint(-4F, 13F, -1F);
      SpiderLeg02.setTextureSize(128, 256);
      SpiderLeg02.mirror = true;
      setRotation(SpiderLeg02, 0F, -0.1570796F, 1.134464F);
      SpiderLeg03 = new ModelRenderer(this, 1, 3);
      SpiderLeg03.addBox(0F, 0F, 0F, 1, 14, 1);
      SpiderLeg03.setRotationPoint(-4F, 13F, 0F);
      SpiderLeg03.setTextureSize(128, 256);
      SpiderLeg03.mirror = true;
      setRotation(SpiderLeg03, 0F, 0.1570796F, 1.134464F);
      SpiderLeg04 = new ModelRenderer(this, 1, 3);
      SpiderLeg04.addBox(0F, 0F, 0F, 1, 14, 1);
      SpiderLeg04.setRotationPoint(-4F, 13F, 1F);
      SpiderLeg04.setTextureSize(128, 256);
      SpiderLeg04.mirror = true;
      setRotation(SpiderLeg04, 0F, 0.4363323F, 1.134464F);
      SpiderLeg05 = new ModelRenderer(this, 1, 3);
      SpiderLeg05.addBox(0F, 0F, -0.5F, 1, 14, 1);
      SpiderLeg05.setRotationPoint(3F, 14F, 0.5F);
      SpiderLeg05.setTextureSize(128, 256);
      SpiderLeg05.mirror = true;
      setRotation(SpiderLeg05, 0F, -0.4363323F, -1.134464F);
      SpiderLeg06 = new ModelRenderer(this, 1, 3);
      SpiderLeg06.addBox(0F, 0F, -0.5F, 1, 14, 1);
      SpiderLeg06.setRotationPoint(3F, 14F, 0F);
      SpiderLeg06.setTextureSize(128, 256);
      SpiderLeg06.mirror = true;
      setRotation(SpiderLeg06, 0F, -0.1570796F, -1.134464F);
      SpiderLeg07 = new ModelRenderer(this, 1, 3);
      SpiderLeg07.addBox(0F, 0F, 0F, 1, 14, 1);
      SpiderLeg07.setRotationPoint(3F, 14F, -1F);
      SpiderLeg07.setTextureSize(128, 256);
      SpiderLeg07.mirror = true;
      setRotation(SpiderLeg07, 0F, 0.1570796F, -1.134464F);
      SpiderLeg08 = new ModelRenderer(this, 1, 3);
      SpiderLeg08.addBox(0F, 0F, 0F, 1, 14, 1);
      SpiderLeg08.setRotationPoint(3F, 14F, -1.5F);
      SpiderLeg08.setTextureSize(128, 256);
      SpiderLeg08.mirror = true;
      setRotation(SpiderLeg08, 0F, 0.4363323F, -1.134464F);
      Rib06 = new ModelRenderer(this, 100, 150);
      Rib06.addBox(0F, 0F, 0F, 4, 1, 1);
      Rib06.setRotationPoint(-4F, 0F, -4F);
      Rib06.setTextureSize(128, 256);
      Rib06.mirror = true;
      setRotation(Rib06, 0F, 0.5235988F, -0.2617994F);
      Rib07 = new ModelRenderer(this, 100, 150);
      Rib07.addBox(0F, 0F, 0F, 3, 1, 1);
      Rib07.setRotationPoint(1.6F, -0.7F, -5F);
      Rib07.setTextureSize(128, 256);
      Rib07.mirror = true;
      setRotation(Rib07, 0F, -0.5235988F, 0.2617994F);
      Rib08 = new ModelRenderer(this, 100, 150);
      Rib08.addBox(0F, 0F, 0F, 3, 1, 1);
      Rib08.setRotationPoint(1.5F, 0.7F, -5F);
      Rib08.setTextureSize(128, 256);
      Rib08.mirror = true;
      setRotation(Rib08, 0F, -0.5235988F, 0.0872665F);
      Rib09 = new ModelRenderer(this, 100, 150);
      Rib09.addBox(0F, 0F, 0F, 2, 1, 1);
      Rib09.setRotationPoint(-4F, 2F, -4F);
      Rib09.setTextureSize(128, 256);
      Rib09.mirror = true;
      setRotation(Rib09, 0F, 0.5235988F, 0.0872665F);
      Rib10 = new ModelRenderer(this, 100, 150);
      Rib10.addBox(0F, 0F, 0F, 3, 1, 1);
      Rib10.setRotationPoint(1.5F, 2.5F, -5F);
      Rib10.setTextureSize(128, 256);
      Rib10.mirror = true;
      setRotation(Rib10, 0F, -0.5235988F, -0.2617994F);
      head02 = new ModelRenderer(this, 96, 20);
      head02.addBox(0F, 0F, 0F, 8, 8, 8);
      head02.setRotationPoint(-13.46667F, -6.733333F, -5F);
      head02.setTextureSize(128, 256);
      head02.mirror = true;
      setRotation(head02, 0.0258185F, 0F, -0.1745329F);
      head03 = new ModelRenderer(this, 96, 3);
      head03.addBox(0F, 0F, 0F, 8, 8, 8);
      head03.setRotationPoint(4.8F, -8.4F, -5F);
      head03.setTextureSize(128, 256);
      head03.mirror = true;
      setRotation(head03, 0.1373543F, 0F, 0.1745329F);
      Shape1 = new ModelRenderer(this, 69, 118);
      Shape1.addBox(0F, 0F, 0F, 4, 3, 1);
      Shape1.setRotationPoint(5.8F, -3.8F, -5F);
      Shape1.setTextureSize(128, 256);
      Shape1.mirror = true;
      setRotation(Shape1, 0.1745329F, 0F, 0.1745329F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Rib01.render(f5);
    Rib03.render(f5);
    Rib02.render(f5);
    Rib04.render(f5);
    Rib05.render(f5);
    Udder.render(f5);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    SpiderTorso.render(f5);
    SpiderBack.render(f5);
    SpiderLeg01.render(f5);
    SpiderLeg02.render(f5);
    SpiderLeg03.render(f5);
    SpiderLeg04.render(f5);
    SpiderLeg05.render(f5);
    SpiderLeg06.render(f5);
    SpiderLeg07.render(f5);
    SpiderLeg08.render(f5);
    Rib06.render(f5);
    Rib07.render(f5);
    Rib08.render(f5);
    Rib09.render(f5);
    Rib10.render(f5);
    head02.render(f5);
    head03.render(f5);
    Shape1.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
    this.SpiderLeg01.rotateAngleX=-.6f;
    this.SpiderLeg02.rotateAngleX=-.4f;
    this.SpiderLeg03.rotateAngleX=-.2f;
    this.SpiderLeg05.rotateAngleX=.6f;
    this.SpiderLeg06.rotateAngleX=.4f;
    this.SpiderLeg07.rotateAngleX=.2f;
  }

}
