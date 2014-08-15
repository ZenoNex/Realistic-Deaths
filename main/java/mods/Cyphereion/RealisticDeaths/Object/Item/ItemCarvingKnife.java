package mods.Cyphereion.RealisticDeaths.Object.Item;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCarvingKnife extends Item{
	
	public ItemCarvingKnife(){
		
	}
	
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
    	if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
    		par3List.add("Used to get more drops from mob heads!");
    		par3List.add("Just right click a head and wala!");
    	}else{
    		par3List.add("--Hold Shift for more!--");
    	}
    }


}
