package mods.Cyphereion.RealisticDeaths.Object.Item;

import mods.Cyphereion.RealisticDeaths.Object.AchievementManager;
import mods.Cyphereion.RealisticDeaths.Object.ItemManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAchievement extends ItemFood{
	
	private int fl;
	private float sat;

	public ItemAchievement(int p_i45340_1_, float f, boolean p_i45340_2_) {
		super(p_i45340_1_, f, p_i45340_2_);
		fl = p_i45340_1_;
		sat = f;
	}
	
    public ItemStack onEaten(ItemStack is, World par2World, EntityPlayer par3EntityPlayer){
    	if(is.getItem() == ItemManager.Brain){
    		par3EntityPlayer.addStat(AchievementManager.intellegent, 1);
    	}
    	par3EntityPlayer.getFoodStats().addStats(fl, sat);
    	-- is.stackSize;
    	return is;
    }

}
