package ec3.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelArmorEC3 extends ModelBiped {
	//fields
	ModelRenderer bodyCross;
	ModelRenderer bodyPlate;
	//ModelRenderer body;
	ModelRenderer bodyPlateb;
	ModelRenderer bodyPlatel;
	ModelRenderer bodyPlater;
	ModelRenderer bodyCross1;
	ModelRenderer lal;
	ModelRenderer lap2;
	ModelRenderer lap1;
	ModelRenderer lap;
	//ModelRenderer leftarm;
	//ModelRenderer rightleg;
	//ModelRenderer leftleg;
	// ModelRenderer rightarm;
	ModelRenderer rap1;
	ModelRenderer rap2;
	ModelRenderer rap;
	ModelRenderer helml;
	//ModelRenderer head;
	ModelRenderer helmt;
	ModelRenderer helms;

	public ModelArmorEC3(float f)
	{
		super(f,0,128,64);
		textureWidth = 128;
		textureHeight = 64;

		bodyCross = new ModelRenderer(this, 10, 32);
		bodyCross.addBox(-4F, 0F, -2.1F, 1, 11, 1);
		bodyCross.setRotationPoint(0F, 0F, -1F);
		bodyCross.setTextureSize(128, 64);
		bodyCross.mirror = true;
		this.bipedBody.addChild(bodyCross);
		setRotation(bodyCross, 0F, 0F, -0.6108652F);
		bodyPlate = new ModelRenderer(this, 14, 39);
		bodyPlate.addBox(-3F, 2F, 1F, 6, 3, 1);
		bodyPlate.setRotationPoint(0F, 0F, 1F);
		bodyPlate.setTextureSize(128, 64);
		bodyPlate.mirror = true;
		setRotation(bodyPlate, 0.1919862F, 0F, 0F);
		this.bipedBody.addChild(bodyPlate);
		/*
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(128, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
		 */
		bodyPlateb = new ModelRenderer(this, 14, 39);
		bodyPlateb.addBox(-3F, 5F, 3F, 6, 3, 1);
		bodyPlateb.setRotationPoint(0F, 0F, 1F);
		bodyPlateb.setTextureSize(128, 64);
		bodyPlateb.mirror = true;
		setRotation(bodyPlateb, -0.1919862F, 0F, 0F);
		this.bipedBody.addChild(bodyPlateb);
		bodyPlatel = new ModelRenderer(this, 14, 32);
		bodyPlatel.addBox(-3F, 2F, 2F, 3, 6, 1);
		bodyPlatel.setRotationPoint(0F, 0F, 1F);
		bodyPlatel.setTextureSize(128, 64);
		bodyPlatel.mirror = true;
		setRotation(bodyPlatel, 0F, -0.1919862F, 0F);
		this.bipedBody.addChild(bodyPlatel);
		bodyPlater = new ModelRenderer(this, 14, 32);
		bodyPlater.addBox(0F, 2F, 2F, 3, 6, 1);
		bodyPlater.setRotationPoint(0F, 0F, 1F);
		bodyPlater.setTextureSize(128, 64);
		bodyPlater.mirror = true;
		setRotation(bodyPlater, 0F, 0.1919862F, 0F);
		this.bipedBody.addChild(bodyPlater);
		bodyCross1 = new ModelRenderer(this, 10, 32);
		bodyCross1.addBox(3F, 0F, -2.1F, 1, 11, 1);
		bodyCross1.setRotationPoint(0F, 0F, -1F);
		bodyCross1.setTextureSize(128, 64);
		bodyCross1.mirror = true;
		setRotation(bodyCross1, 0F, 0F, 0.6108652F);
		this.bipedBody.addChild(bodyCross1);
		lal = new ModelRenderer(this, 0, 40);
		lal.addBox(-1.233333F, -0.8666667F, -2.633333F, 1, 10, 1);
		lal.setRotationPoint(0F, 0F,-1.25F);
		lal.setTextureSize(128, 64);
		lal.mirror = true;
		setRotation(lal, 0.1047198F, -0.7853982F, -0.1047198F);
		this.bipedLeftArm.addChild(lal);
		lap2 = new ModelRenderer(this, 0, 32);
		lap2.addBox(-2F, 5F, -2F, 1, 4, 4);
		lap2.setRotationPoint(5F, 0F, 0F);
		lap2.setTextureSize(128, 64);
		lap2.mirror = true;
		setRotation(lap2, 0F, 0F, -0.0872665F);
		this.bipedLeftArm.addChild(lap2);
		lap1 = new ModelRenderer(this, 0, 32);
		lap1.addBox(-3.5F, 1F, -2F, 1, 4, 4);
		lap1.setRotationPoint(6.75F, 0F, 0F);
		lap1.setTextureSize(128, 64);
		lap1.mirror = true;
		setRotation(lap1, 0F, 0F, -0.0872665F);
		this.bipedLeftArm.addChild(lap1);
		lap = new ModelRenderer(this, 0, 32);
		lap.addBox(-4F, -2F, -2F, 1, 4, 4);
		lap.setRotationPoint(7.5F, 0F, 0F);
		lap.setTextureSize(128, 64);
		lap.mirror = true;
		setRotation(lap, 0F, 0F, -0.0872665F);
		this.bipedLeftArm.addChild(lap);
		/*
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(128, 64);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(128, 64);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(128, 64);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(128, 64);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
		 */
		rap1 = new ModelRenderer(this, 0, 32);
		rap1.addBox(2.5F, 1F, -2F, 1, 4, 4);
		rap1.setRotationPoint(-6.75F, 0F, 0F);
		rap1.setTextureSize(128, 64);
		rap1.mirror = true;
		setRotation(rap1, 0F, 0F, 0.0872665F);
		this.bipedRightArm.addChild(rap1);
		rap2 = new ModelRenderer(this, 0, 32);
		rap2.addBox(2F, 5F, -2F, 1, 4, 4);
		rap2.setRotationPoint(-6F, 0F, 0F);
		rap2.setTextureSize(128, 64);
		rap2.mirror = true;
		setRotation(rap2, 0F, 0F, 0.0872665F);
		this.bipedRightArm.addChild(rap2);
		rap = new ModelRenderer(this, 0, 32);
		rap.addBox(3F, -2F, -2F, 1, 4, 4);
		rap.setRotationPoint(-7.5F, 0F, 0F);
		rap.setTextureSize(128, 64);
		rap.mirror = true;
		setRotation(rap, 0F, 0F, 0.0872665F);
		this.bipedRightArm.addChild(rap);
		helml = new ModelRenderer(this, 0, 40);
		helml.addBox(-2.5F, -1F, -1.5F, 1, 10, 1);
		helml.setRotationPoint(0F, 0F, -1.25F);
		helml.setTextureSize(128, 64);
		helml.mirror = true;
		setRotation(helml, 0.122173F, -0.7853982F, -0.1047198F);
		this.bipedRightArm.addChild(helml);
		/*
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(128, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
		 */
		helmt = new ModelRenderer(this, 0, 52);
		helmt.addBox(-5F, -9F, -5F, 10, 1, 10);
		helmt.setRotationPoint(0F, 0F, 0F);
		helmt.setTextureSize(128, 64);
		helmt.mirror = true;
		setRotation(helmt, 0F, 0F, 0F);
		this.bipedHead.addChild(helmt);
		helms = new ModelRenderer(this, 40, 52);
		helms.addBox(-5F, -5F, -1F, 10, 1, 10);
		helms.setRotationPoint(0F, 0F, 0.1F);
		helms.setTextureSize(128, 64);
		helms.mirror = true;
		setRotation(helms, 1.570796F, 0F, 0F);
		this.bipedHead.addChild(helms);
	}

	public void render(float f5)
	{
		bodyCross.render(f5);
		bodyPlate.render(f5);
		//body.render(f5);
		bodyPlateb.render(f5);
		bodyPlatel.render(f5);
		bodyPlater.render(f5);
		bodyCross1.render(f5);
		lal.render(f5);
		lap2.render(f5);
		lap1.render(f5);
		lap.render(f5);
		//leftarm.render(f5);
		//rightleg.render(f5);
		//leftleg.render(f5);
		//rightarm.render(f5);
		rap1.render(f5);
		rap2.render(f5);
		rap.render(f5);
		helml.render(f5);
		//head.render(f5);
		helmt.render(f5);
		helms.render(f5);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
