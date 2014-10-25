package mods.Cyphereion.RealisticDeaths.Object.Item;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.Cyphereion.RealisticDeaths.RealisticDeaths;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemGuideBook extends Item{
	
	public ItemGuideBook(){
		
	}
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
    	if(RealisticDeaths.getInstance() != null){
    		par3EntityPlayer.openGui(RealisticDeaths.getInstance(), 0, par2World, 0, 0, 0);
    	}
    	return par1ItemStack;
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
    	par3List.add(EnumChatFormatting.AQUA + "The guide book for the Realistic Deaths mod!");
    }
}
