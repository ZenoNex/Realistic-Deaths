package mods.Cyphereion.RealisticDeaths;

import mods.Cyphereion.RealisticDeaths.Object.AchievementManager;
import mods.Cyphereion.RealisticDeaths.Object.BlockManager;
import mods.Cyphereion.RealisticDeaths.Object.EnchantmentManager;
import mods.Cyphereion.RealisticDeaths.Object.ItemManager;
import mods.Cyphereion.RealisticDeaths.Object.RecipeManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = RealisticDeaths.MODID, version = RealisticDeaths.VERSION)
public class RealisticDeaths
{
    public static final String MODID = "Realistic Deaths";
    public static final String VERSION = "1.0.3";
    
    public static CreativeTabs tabRealisticDeaths = new CreativeTabsRD("RealisticDeaths");
    
    @SidedProxy(clientSide = "mods.Cyphereion.RealisticDeaths.ClientProxy", serverSide = "mods.Cyphereion.RealisticDeaths.CommonProxy")
	public static CommonProxy proxy;
    
    public RealisticDeaths instance;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	MinecraftForge.EVENT_BUS.register(new ModEventHandler());
    	BlockManager.loadBlocks();
    	ItemManager.loadItems();
    	EnchantmentManager.loadEnchantments();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	RecipeManager.loadRecipes();
    	AchievementManager.loadAchievements();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    	proxy.register();
    }
}

class CreativeTabsRD extends CreativeTabs{
	public CreativeTabsRD(String tabLabel){
		super(tabLabel);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(BlockManager.CowBody);
	}

}
