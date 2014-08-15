package mods.Cyphereion.RealisticDeaths.Object.Item;

import mods.Cyphereion.RealisticDeaths.RealisticDeaths;
import mods.Cyphereion.RealisticDeaths.Object.ItemManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.ISpecialArmor;

public  class CustomArmor extends ItemArmor implements ISpecialArmor {
	private String Texture = "";
	public CustomArmor(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_, String Tex) {
		  super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
		  Texture = Tex;
	}
	
	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
	  return 4;
	}
	
	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
	  stack.damageItem(damage * 2, entity);
	}

	@Override
	public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
		if(armor.getItem().getUnlocalizedName().toLowerCase().contains("leg")){
			return "rd:textures/armor/" + Texture + "_2.png";
		}
		return "rd:textures/armor/" + Texture + "_1.png";
	}

	@Override
	public CreativeTabs[] getCreativeTabs() {
	  return new CreativeTabs[] {CreativeTabs.tabCombat, RealisticDeaths.tabRealisticDeaths};
	}

	@Override
	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
	  return true;
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		return new ArmorProperties(0, 0, 0);
	}
}