package ec3.common.block;

import DummyCore.Client.IModelRegisterer;
import DummyCore.Utils.MiscUtils;
import ec3.common.mod.EssentialCraftCore;
import ec3.common.tile.TileMagicalMirror;
import ec3.utils.cfg.Config;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;

public class BlockMagicalMirror extends BlockContainer implements IModelRegisterer {

	public BlockMagicalMirror(Material p_i45394_1_) {
		super(p_i45394_1_);
	}

	public BlockMagicalMirror() {
		super(Material.ROCK);
	}

	@Override
	public void breakBlock(World par1World, BlockPos par2Pos, IBlockState par3State) {
		MiscUtils.dropItemsOnBlockBreak(par1World, par2Pos.getX(), par2Pos.getY(), par2Pos.getZ(), par3State.getBlock(), 0);
		super.breakBlock(par1World, par2Pos, par3State);
	}

	@Override
	public boolean isOpaqueCube(IBlockState s)
	{
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.SOLID;
	}

	@Override
	public boolean isFullCube(IBlockState s)
	{
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileMagicalMirror();
	}

	@Override
	public boolean onBlockActivated(World par1World, BlockPos par2, IBlockState par3, EntityPlayer par4EntityPlayer, EnumHand par5, ItemStack par6, EnumFacing par7, float par8, float par9, float par10) {
		if(par1World.isRemote) {
			return true;
		}
		else {
			if(!par4EntityPlayer.isSneaking()) {
				par4EntityPlayer.openGui(EssentialCraftCore.core, Config.guiID[0], par1World, par2.getX(), par2.getY(), par2.getZ());
				return true;
			}
			else {
				return false;
			}
		}
	}

	@Override
	public void registerModels() {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation("essentialcraft:magicalMirror", "inventory"));
	}
}
