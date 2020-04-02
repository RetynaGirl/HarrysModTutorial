package com.teknoserval.harrysmod112.entity.render;

import com.teknoserval.harrysmod112.entity.EntityCentaur;
import com.teknoserval.harrysmod112.entity.model.ModelCentaur;
import com.teknoserval.harrysmod112.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCentaur extends RenderLiving<EntityCentaur> {
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/centaur.png");

	public RenderCentaur(RenderManager manager) {
		super(manager, new ModelCentaur(), 0.5F);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCentaur entity) {
		// TODO Auto-generated method stub
		return TEXTURES;
	}
	
	protected void applyRotations(EntityCentaur entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {};

}
