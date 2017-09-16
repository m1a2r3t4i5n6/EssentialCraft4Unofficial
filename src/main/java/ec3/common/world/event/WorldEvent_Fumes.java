package ec3.common.world.event;

import ec3.api.IWorldEvent;
import ec3.utils.cfg.Config;
import ec3.utils.common.ECUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class WorldEvent_Fumes implements IWorldEvent{

	@Override
	public void onEventBeginning(World w) {
		ECUtils.sendChatMessageToAllPlayersInDim(Config.dimensionID, TextFormatting.RED+"What is that smell?!");
	}

	@Override
	public void worldTick(World w, int leftoverTime) {

	}

	@Override
	public void playerTick(EntityPlayer p, int leftoverTime) {

	}

	@Override
	public void onEventEnd(World w) {
		ECUtils.sendChatMessageToAllPlayersInDim(Config.dimensionID, TextFormatting.GREEN+"The poison is gone!");
	}

	@Override
	public int getEventDuration(World w) {
		return 12000;
	}

	@Override
	public boolean possibleToApply(World w) {
		return true;
	}

	@Override
	public float getEventProbability(World w) {
		return 0.000175F;
	}

	@Override
	public String getEventID() {
		return "ec3.event.fumes";
	}

}
