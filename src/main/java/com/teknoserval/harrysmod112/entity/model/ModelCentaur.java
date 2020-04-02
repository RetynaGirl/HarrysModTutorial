package com.teknoserval.harrysmod112.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelCow - Either Mojang or a mod author
 * Created using Tabula 7.1.0
 */
public class ModelCentaur extends ModelBase {
    public ModelRenderer Body;
    public ModelRenderer Udder;
    public ModelRenderer BLLeg;
    public ModelRenderer FLLeg;
    public ModelRenderer BRLeg;
    public ModelRenderer BFLeg;
    public ModelRenderer Head;
    public ModelRenderer RUpperArm;
    public ModelRenderer LUpperArm;
    public ModelRenderer Hands;
    public ModelRenderer Chest;
    public ModelRenderer Coat;
    public ModelRenderer Nose;

    public ModelCentaur() {
        this.textureWidth = 64;
        this.textureHeight = 96;
        this.Nose = new ModelRenderer(this, 24, 0);
        this.Nose.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.Nose.addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);
        this.BRLeg = new ModelRenderer(this, 0, 80);
        this.BRLeg.setRotationPoint(-4.0F, 12.0F, 7.0F);
        this.BRLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.BFLeg = new ModelRenderer(this, 0, 80);
        this.BFLeg.setRotationPoint(-4.0F, 12.0F, -6.0F);
        this.BFLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.RUpperArm = new ModelRenderer(this, 44, 22);
        this.RUpperArm.setRotationPoint(0.0F, -12.0F, -6.0F);
        this.RUpperArm.addBox(-8.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(RUpperArm, -0.7499679795819634F, 0.0F, 0.0F);
        this.BLLeg = new ModelRenderer(this, 0, 80);
        this.BLLeg.setRotationPoint(4.0F, 12.0F, 7.0F);
        this.BLLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, -15.0F, -5.0F);
        this.Head.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.Udder = new ModelRenderer(this, 52, 64);
        this.Udder.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.Udder.addBox(-2.0F, 2.0F, -8.0F, 4, 6, 1, 0.0F);
        this.setRotateAngle(Udder, 1.5707963267948966F, 0.0F, 0.0F);
        this.FLLeg = new ModelRenderer(this, 0, 80);
        this.FLLeg.setRotationPoint(4.0F, 12.0F, -6.0F);
        this.FLLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.LUpperArm = new ModelRenderer(this, 44, 22);
        this.LUpperArm.setRotationPoint(0.0F, -12.0F, -6.0F);
        this.LUpperArm.addBox(4.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F);
        this.setRotateAngle(LUpperArm, -0.7499679795819634F, 0.0F, 0.0F);
        this.Coat = new ModelRenderer(this, 0, 38);
        this.Coat.setRotationPoint(0.0F, -15.0F, -5.0F);
        this.Coat.addBox(-4.0F, 0.0F, -3.0F, 8, 18, 6, 0.5F);
        this.Body = new ModelRenderer(this, 18, 68);
        this.Body.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.Body.addBox(-6.0F, -10.0F, -7.0F, 12, 18, 10, 0.0F);
        this.setRotateAngle(Body, 1.5707963267948966F, 0.0F, 0.0F);
        this.Hands = new ModelRenderer(this, 40, 38);
        this.Hands.setRotationPoint(0.0F, -12.0F, -6.0F);
        this.Hands.addBox(-4.0F, 2.0F, -2.0F, 8, 4, 4, 0.0F);
        this.setRotateAngle(Hands, -0.7499679795819634F, 0.0F, 0.0F);
        this.Chest = new ModelRenderer(this, 16, 20);
        this.Chest.setRotationPoint(0.0F, -15.0F, -5.0F);
        this.Chest.addBox(-4.0F, 0.0F, -3.0F, 8, 12, 6, 0.0F);
        this.Head.addChild(this.Nose);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BRLeg.render(f5);
        this.BFLeg.render(f5);
        this.RUpperArm.render(f5);
        this.BLLeg.render(f5);
        this.Head.render(f5);
        this.Udder.render(f5);
        this.FLLeg.render(f5);
        this.LUpperArm.render(f5);
        this.Coat.render(f5);
        this.Body.render(f5);
        this.Hands.render(f5);
        this.Chest.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn) {
    	
    	this.FLLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.BLLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.BFLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	this.BRLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F  + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.Head.rotateAngleX = headPitch * 0.017453292F;
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
