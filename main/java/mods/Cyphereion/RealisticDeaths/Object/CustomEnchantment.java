package mods.Cyphereion.RealisticDeaths.Object;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class CustomEnchantment extends Enchantment
{
    private static final String __OBFID = "CL_00000119";
    
    private int Max = 1;

    public CustomEnchantment(int par1, int par2, EnumEnchantmentType par3EnumEnchantmentType, String name, int max)
    {
        super(par1, par2, par3EnumEnchantmentType);
        setName(name);
        Max = max;
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int par1)
    {
        return 15 + (par1 - 1) * 9;
    }

    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int par1)
    {
        return super.getMinEnchantability(par1) + 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return Max;
    }

    /**
     * Determines if the enchantment passed can be applyied together with this enchantment.
     */
    public boolean canApplyTogether(Enchantment par1Enchantment)
    {
        return true;
    }
}