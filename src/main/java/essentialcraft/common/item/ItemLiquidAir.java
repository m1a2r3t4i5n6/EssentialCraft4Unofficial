package essentialcraft.common.item;

import DummyCore.Client.IModelRegisterer;
import essentialcraft.common.registry.PotionRegistry;
import essentialcraft.utils.common.ECUtils;
import essentialcraft.utils.common.WindRelations;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

public class ItemLiquidAir extends Item implements IModelRegisterer {

	public ItemLiquidAir() {
		super();
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack p_77654_1_, World p_77654_2_, EntityLivingBase p_77654_3_)
	{
		if(p_77654_3_ instanceof EntityPlayer && !p_77654_2_.isRemote) {
			((EntityPlayer)p_77654_3_).inventory.decrStackSize(((EntityPlayer)p_77654_3_).inventory.currentItem,1);
			ECUtils.calculateAndAddPE((EntityPlayer)p_77654_3_, PotionRegistry.paranormalLightness, 8*60*20, 2*60*20);
			WindRelations.increasePlayerWindRelations((EntityPlayer) p_77654_3_, 100);
		}
		return p_77654_1_;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_)
	{
		return 32;
	}

	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
	{
		return EnumAction.DRINK;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer, enumHand
	 */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World p_77659_2_, EntityPlayer p_77659_3_, EnumHand hand)
	{
		p_77659_3_.setActiveHand(hand);
		return super.onItemRightClick(p_77659_2_, p_77659_3_, hand);
	}

	@Override
	public void registerModels() {
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("essentialcraft:item/air_potion", "inventory"));
	}
}
