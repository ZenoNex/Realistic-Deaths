package mods.Cyphereion.RealisticDeaths.Object.Slime;

import java.util.Random;

import mods.Cyphereion.RealisticDeaths.Object.EnumMobType;
import mods.Cyphereion.RealisticDeaths.Object.ItemManager;
import mods.Cyphereion.RealisticDeaths.Object.RecipeManager;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSlimeBody extends BlockContainer{

	public BlockSlimeBody() {
		super(Material.rock);
		this.setBlockBounds(.2f, .1f, 0f, .8f, .5f, .6f);
	}
	
	public int getRenderType(){
		return -1;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}

	public boolean renderAsNormalBlock(){
		return false;
	}
	
    public int quantityDropped(Random p_149745_1_){
        return 0;
    }
	
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	if(player.inventory.getCurrentItem() != null){
    		if(player.inventory.getCurrentItem().getItem() == ItemManager.CarvingKnife){
    			player.inventory.getCurrentItem().damageItem(1, player);
    			if(!par1World.isRemote){
    				RecipeManager.doManditoryDrops(player, EnumMobType.Slime);
        			par1World.setBlockToAir(par2, par3, par4);
    			}
    		}
    	}
        return true;
    }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntitySlimeBody();
	}
	
}
