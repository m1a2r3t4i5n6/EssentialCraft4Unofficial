package essentialcraft.client.render.entity;

import org.lwjgl.opengl.GL11;

import DummyCore.Utils.DrawUtils;
import essentialcraft.common.entity.EntityMRURay;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderMRURay extends Render<EntityMRURay> {

	public RenderMRURay(RenderManager renderManager) {
		super(renderManager);
	}

	private static final ResourceLocation field_147523_b = new ResourceLocation("textures/entity/beacon_beam.png");

	@Override
	public void doRender(EntityMRURay entity, double x,
			double y, double z, float entityYaw,
			float partialTicks) {
		EntityMRURay ray = entity;

		if(ray.pX == 0 && ray.pY == 0 && ray.pZ == 0)
			return;

		float r = 0;
		float g = 1;
		float b = 1;
		if(ray.balance == 1)
		{
			r = 1;
			g = 0;
			b = 0;
		}
		if(ray.balance == 2)
		{
			r = 0;
			g = 0;
			b = 1;
		}
		if(ray.balance == 3)
		{
			r = 1;
			g = 0;
			b = 1;
		}
		if(ray.balance == 4)
		{
			r = 0.3F;
			g = 0.3F;
			b = 0.3F;
		}
		renderBeam(partialTicks,x,y,z,1D-ray.ticksExisted/60D,0,0,ray.pX-ray.posX,ray.pY-ray.posY,ray.pZ-ray.posZ,r,g,b,r,g,b,(float) (0.1F * (1 + (double)ray.ticksExisted/60)));

	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMRURay entity) {
		return field_147523_b;
	}

	public static void renderBeam(float partialTicks, double x, double y, double z, double posX, double posY, double posZ, double offsetX, double offsetY, double offsetZ, float colorR, float colorG, float colorB, float colorRB, float colorGB, float colorBB, float size) {
		GlStateManager.pushMatrix();
		GlStateManager.disableLighting();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
		float f21 = 0 + partialTicks;
		float f31 = MathHelper.sin(f21 * 0.2F) / 2.0F + 0.5F;
		f31 = (f31 * f31 + f31) * 0.2F;
		float f4;
		float f5;
		float f6;
		f4 = (float) offsetX;
		f5 = (float) offsetY;
		f6 = (float) offsetZ;
		GlStateManager.translate(x, y + posY, z+posZ);
		float f7 = MathHelper.sqrt(f4 * f4 + f6 * f6);
		float f8 = MathHelper.sqrt(f4 * f4 + f5 * f5 + f6 * f6);
		GlStateManager.rotate((float)-Math.atan2(f6, f4) * 180.0F / (float)Math.PI - 90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate((float)-Math.atan2(f7, f5) * 180.0F / (float)Math.PI - 90.0F, 1.0F, 0.0F, 0.0F);
		Tessellator tessellator = Tessellator.getInstance();
		RenderHelper.disableStandardItemLighting();
		DrawUtils.bindTexture("essentialcraft","textures/special/mru_beam.png");
		GlStateManager.shadeModel(GL11.GL_SMOOTH);
		float f9 = 1;
		float f10 = MathHelper.sqrt(f4 * f4 + f5 * f5 + f6 * f6) / 32.0F - 1 * 0.0001F;
		tessellator.getBuffer().begin(5, DefaultVertexFormats.POSITION_TEX_COLOR);
		byte b0 = 8;
		for (int i1 = 0; i1 <= b0; ++i1) {
			float f11 = MathHelper.sin(i1 % b0 * (float)Math.PI * 2.0F / b0) * 0.75F * size;
			float f12 = MathHelper.cos(i1 % b0 * (float)Math.PI * 2.0F / b0) * 0.75F * size;
			float f13 = i1 % b0 * 1.0F / b0;
			tessellator.getBuffer().pos(f11, f12, 0.0D).tex(f13, f10).color(colorRB, colorGB, colorBB, (float) posX).endVertex();
			tessellator.getBuffer().pos(f11, f12, f8).tex(f13, f9).color(colorR, colorG, colorB, (float) posX).endVertex();;
		}

		tessellator.draw();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.disableBlend();
		GlStateManager.shadeModel(GL11.GL_FLAT);
		RenderHelper.enableStandardItemLighting();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();
	}

	public static class Factory implements IRenderFactory<EntityMRURay> {
		@Override
		public Render<? super EntityMRURay> createRenderFor(RenderManager manager) {
			return new RenderMRURay(manager);
		}
	}
}
