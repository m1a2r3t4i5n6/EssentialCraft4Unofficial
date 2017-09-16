package ec3.client.render.tile;

import DummyCore.Client.AdvancedModelLoader;
import DummyCore.Client.IModelCustom;
import ec3.common.tile.TileDemonicPentacle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDemonicPentacle extends TileEntitySpecialRenderer
{
	public static final ResourceLocation rune = new ResourceLocation("essentialcraft:textures/models/demonicPentacle.png");
	public static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("essentialcraft:models/block/Rune.obj"));

	public void doRender(TileEntity tile, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	{
		RenderHelper.disableStandardItemLighting();
		TileDemonicPentacle p = (TileDemonicPentacle) tile;

		GlStateManager.pushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(rune);
		GlStateManager.translate(p_76986_2_+0.5F, p_76986_4_-0.2F, p_76986_6_+0.5F);

		if(p.tier == -1) {
			GlStateManager.popMatrix();
			return;
		}

		float movement = Minecraft.getMinecraft().world.getTotalWorldTime()%60F+p_76986_8_;

		if(movement > 30)
			movement = 30 - movement+30F;

		float c = movement/30F;
		if(c < 0.02F)c = 0.02F;
		if(c > 0.8F)c= 0.8F;

		if(p.tier == 0)
		{
			GlStateManager.color(c, 0, 0);
		}

		GlStateManager.rotate(Minecraft.getMinecraft().world.getTotalWorldTime()%360F, 0, 1, 0);
		model.renderAll();
		GlStateManager.popMatrix();
		RenderHelper.enableStandardItemLighting();
	}

	@Override
	public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_, int destroyStage) {
		this.doRender(p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_, 0);
	}
}