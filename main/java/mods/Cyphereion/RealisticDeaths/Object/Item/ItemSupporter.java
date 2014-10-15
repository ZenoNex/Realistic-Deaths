package mods.Cyphereion.RealisticDeaths.Object.Item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSupporter extends Item{
	
	public ItemSupporter(){
		this.setMaxDamage(10);
		this.setMaxStackSize(1);
	}
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
    	if(!par2World.isRemote){
    		if(10 - this.getDisplayDamage(par1ItemStack) == 10){
    			par3EntityPlayer.heal(10F);
    			par1ItemStack.damageItem(9, par3EntityPlayer);
    			par3EntityPlayer.getFoodStats().setFoodLevel(par3EntityPlayer.getFoodStats().getFoodLevel() + 5);
    			par3EntityPlayer.setAbsorptionAmount(5);
    		}
    	}
        return par1ItemStack;
    }

}
