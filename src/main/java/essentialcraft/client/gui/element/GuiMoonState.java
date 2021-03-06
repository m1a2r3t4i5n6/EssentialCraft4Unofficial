package essentialcraft.client.gui.element;

import DummyCore.Utils.DrawUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class GuiMoonState extends GuiTextElement{

	public GuiMoonState(int i, int j)
	{
		super(i,j);
	}

	@Override
	public ResourceLocation getElementTexture() {
		return super.getElementTexture();
	}

	@Override
	public void draw(int posX, int posY, int mouseX, int mouseY) {
		this.drawTexturedModalRect(posX, posY, 0, 0, 18, 18);
		DrawUtils.bindTexture("essentialcraft", "textures/gui/gui_moon_phases.png");
		int moonPhase = Minecraft.getMinecraft().world.getMoonPhase();
		this.drawTexturedModalRect(posX+1, posY+1, 16*moonPhase, 0, 16, 16);
		drawText(posX,posY);
	}

	@Override
	public int getX() {
		return super.getX();
	}

	@Override
	public int getY() {
		return super.getY();
	}

	@Override
	public void drawText(int posX, int posY) {

	}
}
