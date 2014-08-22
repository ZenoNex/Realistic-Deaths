package mods.Cyphereion.RealisticDeaths.Object.PlayerHead;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ItemPlayerHead extends Item{
	
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
		MinecraftServer server = MinecraftServer.getServer();
		if(!par2World.isRemote){
			server.getCommandManager().executeCommand(server, "/setblock " + par3EntityPlayer.posX + " " + par3EntityPlayer.posY + " " + par3EntityPlayer.posZ + " minecraft:skull 1 replace {ExtraType:" + par3EntityPlayer.getDisplayName() + ",SkullType:3}");
		}
    	par1ItemStack.stackSize--;
        return par1ItemStack;
    }

}
