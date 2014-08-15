package mods.Cyphereion.RealisticDeaths.Object.Pig;

import java.util.Random;

import mods.Cyphereion.RealisticDeaths.Object.AchievementManager;
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

public class BlockPigBody extends BlockContainer{

	public BlockPigBody() {
		super(Material.rock);
		this.setBlockBounds(.2f, .1f, .1f, .8f, .65f, .65f);
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
    				RecipeManager.doManditoryDrops(player, EnumMobType.Pig);
        			par1World.setBlockToAir(par2, par3, par4);
        			player.addStat(AchievementManager.cutie, 1);
    			}
    		}
    	}
        return true;
    }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityPigBody();
	}
	
}
