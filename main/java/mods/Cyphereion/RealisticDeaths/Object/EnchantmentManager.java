package mods.Cyphereion.RealisticDeaths.Object;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentManager {
	
	public static Enchantment lifesteal, Suprise;
	
	public static void loadEnchantments(){
		lifesteal = new CustomEnchantment(150, 1, EnumEnchantmentType.all, "Lifesteal", 3);
		Suprise = new CustomEnchantment(151, 1, EnumEnchantmentType.all, "Suprise", 2);
	}

}
