package mods.Cyphereion.RealisticDeaths.Object;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentManager {
	
	public static Enchantment lifesteal, Suprise, SoulTaker;
	
	public static void loadEnchantments(){
		lifesteal = new CustomEnchantment(150, 1, EnumEnchantmentType.weapon, "Lifesteal", 3);
		Suprise = new CustomEnchantment(151, 1, EnumEnchantmentType.all, "Suprise", 2);
		SoulTaker = new CustomEnchantment(152, 1, EnumEnchantmentType.weapon, "SoulTaker", 1);
	}

}
