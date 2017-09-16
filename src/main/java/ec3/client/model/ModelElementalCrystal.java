package ec3.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelElementalCrystal extends ModelBase {
	//fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;
	ModelRenderer Shape12;
	ModelRenderer Shape13;
	ModelRenderer Shape14;
	ModelRenderer Shape15;
	ModelRenderer Shape16;
	ModelRenderer Shape17;
	ModelRenderer Shape18;
	ModelRenderer Shape19;
	ModelRenderer Shape20;
	ModelRenderer Shape21;
	ModelRenderer Shape22;

	public ModelElementalCrystal()
	{
		textureWidth = 128;
		textureHeight = 128;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 4, 20, 5);
		Shape1.setRotationPoint(1F, 10F, -7F);
		Shape1.setTextureSize(128, 128);
		Shape1.mirror = true;
		setRotation(Shape1, 0.2094395F, 0.2094395F, 0.3316126F);
		Shape2 = new ModelRenderer(this, 18, 0);
		Shape2.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape2.setRotationPoint(3F, 13F, -6F);
		Shape2.setTextureSize(128, 128);
		Shape2.mirror = true;
		setRotation(Shape2, -0.5585054F, -0.8552113F, 0.418879F);
		Shape3 = new ModelRenderer(this, 18, 0);
		Shape3.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape3.setRotationPoint(1F, 13F, -4F);
		Shape3.setTextureSize(128, 128);
		Shape3.mirror = true;
		setRotation(Shape3, -3.141593F, -0.9599311F, -0.4014257F);
		Shape4 = new ModelRenderer(this, 18, 0);
		Shape4.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape4.setRotationPoint(1F, 18F, -1F);
		Shape4.setTextureSize(128, 128);
		Shape4.mirror = true;
		setRotation(Shape4, -3.141593F, -0.9599311F, -1.029744F);
		Shape5 = new ModelRenderer(this, 18, 0);
		Shape5.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape5.setRotationPoint(1F, 21F, -3F);
		Shape5.setTextureSize(128, 128);
		Shape5.mirror = true;
		setRotation(Shape5, -0.0523599F, -0.6632251F, -0.9424778F);
		Shape6 = new ModelRenderer(this, 18, 0);
		Shape6.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape6.setRotationPoint(-1F, 20F, -6F);
		Shape6.setTextureSize(128, 128);
		Shape6.mirror = true;
		setRotation(Shape6, 0.2268928F, -0.6632251F, -0.4712389F);
		Shape7 = new ModelRenderer(this, 0, 0);
		Shape7.addBox(0F, 0F, 0F, 4, 14, 5);
		Shape7.setRotationPoint(-5F, 12F, 1F);
		Shape7.setTextureSize(128, 128);
		Shape7.mirror = true;
		setRotation(Shape7, -0.0174533F, 0.2094395F, -0.2617994F);
		Shape8 = new ModelRenderer(this, 0, 0);
		Shape8.addBox(0F, 0F, 0F, 4, 7, 5);
		Shape8.setRotationPoint(2F, 16F, -1F);
		Shape8.setTextureSize(128, 128);
		Shape8.mirror = true;
		setRotation(Shape8, -0.2268928F, 0.2094395F, 0.2617994F);
		Shape9 = new ModelRenderer(this, 0, 0);
		Shape9.addBox(0F, 0F, 0F, 3, 5, 5);
		Shape9.setRotationPoint(-3F, 19F, -3F);
		Shape9.setTextureSize(128, 128);
		Shape9.mirror = true;
		setRotation(Shape9, -0.0523599F, -0.7504916F, -0.1745329F);
		Shape10 = new ModelRenderer(this, 0, 0);
		Shape10.addBox(0F, 0F, 0F, 4, 8, 4);
		Shape10.setRotationPoint(-5F, 18F, -9F);
		Shape10.setTextureSize(128, 128);
		Shape10.mirror = true;
		setRotation(Shape10, 0.2443461F, -0.7330383F, -0.2617994F);
		Shape11 = new ModelRenderer(this, 0, 0);
		Shape11.addBox(0F, 0F, 0F, 4, 8, 4);
		Shape11.setRotationPoint(6F, 15F, 4F);
		Shape11.setTextureSize(128, 128);
		Shape11.mirror = true;
		setRotation(Shape11, -0.0872665F, -0.7330383F, 0.3839724F);
		Shape12 = new ModelRenderer(this, 0, 0);
		Shape12.addBox(0F, 0F, 0F, 3, 7, 3);
		Shape12.setRotationPoint(-4F, 19F, 4F);
		Shape12.setTextureSize(128, 128);
		Shape12.mirror = true;
		setRotation(Shape12, -0.3316126F, -0.7330383F, 0.2268928F);
		Shape13 = new ModelRenderer(this, 0, 0);
		Shape13.addBox(0F, 0F, 0F, 3, 7, 3);
		Shape13.setRotationPoint(5F, 18F, -7F);
		Shape13.setTextureSize(128, 128);
		Shape13.mirror = true;
		setRotation(Shape13, 0.1396263F, -0.7330383F, 0.0349066F);
		Shape14 = new ModelRenderer(this, 18, 0);
		Shape14.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape14.setRotationPoint(-4F, 14F, 4F);
		Shape14.setTextureSize(128, 128);
		Shape14.mirror = true;
		setRotation(Shape14, -3.141593F, -0.9599311F, -0.7504916F);
		Shape15 = new ModelRenderer(this, 18, 0);
		Shape15.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape15.setRotationPoint(4F, 23F, 6F);
		Shape15.setTextureSize(128, 128);
		Shape15.mirror = true;
		setRotation(Shape15, -2.844887F, -1.099557F, -0.7853982F);
		Shape16 = new ModelRenderer(this, 18, 0);
		Shape16.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape16.setRotationPoint(-3F, 19F, 4F);
		Shape16.setTextureSize(128, 128);
		Shape16.mirror = true;
		setRotation(Shape16, -2.740167F, -0.9250245F, -0.2617994F);
		Shape17 = new ModelRenderer(this, 18, 0);
		Shape17.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape17.setRotationPoint(-7F, 19F, -6F);
		Shape17.setTextureSize(128, 128);
		Shape17.mirror = true;
		setRotation(Shape17, -2.408554F, -1.047198F, -0.5585054F);
		Shape18 = new ModelRenderer(this, 18, 0);
		Shape18.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape18.setRotationPoint(-6F, 22F, 0F);
		Shape18.setTextureSize(128, 128);
		Shape18.mirror = true;
		setRotation(Shape18, -2.722714F, -1.064651F, -0.7330383F);
		Shape19 = new ModelRenderer(this, 18, 0);
		Shape19.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape19.setRotationPoint(4F, 17F, 0F);
		Shape19.setTextureSize(128, 128);
		Shape19.mirror = true;
		setRotation(Shape19, -0.9250245F, -0.8552113F, 0.4886922F);
		Shape20 = new ModelRenderer(this, 18, 0);
		Shape20.addBox(0F, 0F, 0F, 3, 3, 3);
		Shape20.setRotationPoint(6F, 15F, 7F);
		Shape20.setTextureSize(128, 128);
		Shape20.mirror = true;
		setRotation(Shape20, -0.9250245F, -0.8726646F, 0.9773844F);
		Shape21 = new ModelRenderer(this, 18, 0);
		Shape21.addBox(0F, 0F, 0F, 2, 2, 2);
		Shape21.setRotationPoint(6F, 18F, -5F);
		Shape21.setTextureSize(128, 128);
		Shape21.mirror = true;
		setRotation(Shape21, -0.715585F, -0.9599311F, 0.9250245F);
		Shape22 = new ModelRenderer(this, 18, 0);
		Shape22.addBox(0F, 0F, 0F, 2, 2, 2);
		Shape22.setRotationPoint(-4F, 19F, 6F);
		Shape22.setTextureSize(128, 128);
		Shape22.mirror = true;
		setRotation(Shape22, -0.715585F, -0.9599311F, 0.9250245F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
		Shape13.render(f5);
		Shape14.render(f5);
		Shape15.render(f5);
		Shape16.render(f5);
		Shape17.render(f5);
		Shape18.render(f5);
		Shape19.render(f5);
		Shape20.render(f5);
		Shape21.render(f5);
		Shape22.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par7Entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, par7Entity);
	}

	public void renderModel(float f5) {

		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
		Shape13.render(f5);
		Shape14.render(f5);
		Shape15.render(f5);
		Shape16.render(f5);
		Shape17.render(f5);
		Shape18.render(f5);
		Shape19.render(f5);
		Shape20.render(f5);
		Shape21.render(f5);
		Shape22.render(f5);
	}

}
