package mods.Cyphereion.RealisticDeaths.Object.Zombie;

import java.util.Random;

import mods.Cyphereion.RealisticDeaths.Object.BlockManager;
import mods.Cyphereion.RealisticDeaths.Object.EnumMobType;
import mods.Cyphereion.RealisticDeaths.Object.ItemManager;
import mods.Cyphereion.RealisticDeaths.Object.RecipeManager;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockZombieBody extends BlockContainer{

	public BlockZombieBody() {
		super(Material.rock);
		this.setBlockBounds(.2f, .05f, .2f,
				.8f, .55f, .8f);
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
	
	public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);

        if (world.getBlock(x, y - 1, z) == BlockManager.CompressedDiamond && world.getBlock(x, y - 2, z) == Blocks.gold_block && world.getBlock(x, y - 3, z) == BlockManager.SpiderBody
        		&& world.getBlock(x + 1, y - 1, z) == Blocks.gold_block && world.getBlock(x - 1, y - 1, z) == Blocks.gold_block)
        {
            if (!world.isRemote)
            {
                world.setBlockToAir(x, y, z);
                world.setBlockToAir(x, y - 1, z);
                world.setBlockToAir(x, y - 2, z);
                world.setBlockToAir(x, y - 3, z);
                world.setBlockToAir(x + 1, y - 1, z);
                world.setBlockToAir(x - 1, y - 1, z);
                world.setBlockToAir(x + 1, y, z);
                world.setBlockToAir(x - 1, y, z);
                EntitySnowman entitysnowman = new EntitySnowman(world);
                entitysnowman.setLocationAndAngles((double)x + 0.5D, (double)y - 1.95D, (double)z + 0.5D, 0.0F, 0.0F);
                world.spawnEntityInWorld(entitysnowman);
                world.notifyBlockChange(x, y, z, getBlockById(0));
                world.notifyBlockChange(x, y - 1, z, getBlockById(0));
                world.notifyBlockChange(x, y - 2, z, getBlockById(0));
            }

            for (int i1 = 0; i1 < 120; ++i1)
            {
                world.spawnParticle("snowshovel", (double)x + world.rand.nextDouble(), (double)(y - 2) + world.rand.nextDouble() * 2.5D, (double)z + world.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }
    }
	
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	if(player.inventory.getCurrentItem() != null){
    		if(player.inventory.getCurrentItem().getItem() == ItemManager.CarvingKnife){
    			player.inventory.getCurrentItem().damageItem(1, player);
    			if(!par1World.isRemote){
    				Random rand = new Random();
    				RecipeManager.doManditoryDrops(player, EnumMobType.Zombie);
        			par1World.setBlockToAir(par2, par3, par4);
    			}
    		}
    	}
        return true;
    }

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityZombieBody();
	}
	
}
