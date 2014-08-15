package mods.Cyphereion.RealisticDeaths.Object.Item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ItemXPBottle extends Item {

	public ItemXPBottle() {
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player){
		NBTTagCompound tag = is.getTagCompound();
		if(getLevels(is) == 0){
			if(player.experienceLevel >= 50){
				tag.setInteger("xp", 50);
				player.addExperienceLevel(-50);
			}else{
				tag.setInteger("xp", player.experienceLevel);
				player.addExperienceLevel(-player.experienceLevel);
			}
		}else{
			player.addExperienceLevel(getLevels(is));
			tag.setInteger("xp", 0);
		}
		return is;
	}
	
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4){
    	if(par1ItemStack.getTagCompound() != null){
    		if(par1ItemStack.getTagCompound().hasKey("xp")){
    			par3List.add("Stored XP: " + par1ItemStack.getTagCompound().getInteger("xp"));
    		}
    	}
    }
	
	private static int getLevels(ItemStack is){
		NBTTagCompound tag = is.getTagCompound();
		if(tag != null){
			if(!tag.hasKey("xp")){
				tag.setInteger("xp", 0);
			}
			return tag.getInteger("xp");
		}else{
			is.setTagCompound(new NBTTagCompound());
			return 0;
		}
	}
}
