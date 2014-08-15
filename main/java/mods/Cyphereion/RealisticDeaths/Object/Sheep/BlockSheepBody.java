package mods.Cyphereion.RealisticDeaths.Object.Sheep;

import java.util.Random;

import mods.Cyphereion.RealisticDeaths.Object.EnumMobType;
import mods.Cyphereion.RealisticDeaths.Object.ItemManager;
import mods.Cyphereion.RealisticDeaths.Object.RecipeManager;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSheepBody extends BlockContainer{

	public BlockSheepBody() {
		super(Material.rock);
		this.setBlockBounds(.3f, .1f, .1f, .69f, .5f, .65f);
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
	
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	if(player.inventory.getCurrentItem() != null){
    		if(player.inventory.getCurrentItem().getItem() == ItemManager.CarvingKnife){
    			player.inventory.getCurrentItem().damageItem(1, player);
    			if(!par1World.isRemote){
    				Random rand = new Random();
    				RecipeManager.doManditoryDrops(player, EnumMobType.Sheep);
        			par1World.setBlockToAir(par2, par3, par4);
    			}
    		}
    	}
        return true;
    }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntitySheepBody();
	}
	
}
