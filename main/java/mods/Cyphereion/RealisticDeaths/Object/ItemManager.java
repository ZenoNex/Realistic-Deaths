package mods.Cyphereion.RealisticDeaths.Object;

import java.util.ArrayList;

import mods.Cyphereion.RealisticDeaths.RealisticDeaths;
import mods.Cyphereion.RealisticDeaths.Object.Item.CustomArmor;
import mods.Cyphereion.RealisticDeaths.Object.Item.ItemAchievement;
import mods.Cyphereion.RealisticDeaths.Object.Item.ItemCarvingKnife;
import mods.Cyphereion.RealisticDeaths.Object.Item.ItemGuideBook;
import mods.Cyphereion.RealisticDeaths.Object.Item.ItemSupporter;
import mods.Cyphereion.RealisticDeaths.Object.Item.ItemXPBottle;
import mods.Cyphereion.RealisticDeaths.Object.PlayerHead.ItemPlayerHead;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSoup;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemManager {
	
	public static ArmorMaterial armor_PigHide = EnumHelper.addArmorMaterial("Bat Wing", 29, new int[] {2, 5, 4, 3}, 30);
	public static ArmorMaterial armor_BatWing = EnumHelper.addArmorMaterial("Pig Hide", 29, new int[] {1, 3, 2, 1}, 15);
	
	public static Item 
	CarvingKnife = new ItemCarvingKnife(),
	Brain = new ItemAchievement(1, .5f, true),
	CookedBrain = new ItemFood(3, 1.5f, false),
	Stomach = new ItemFood(2, 3f, true),
	CookedStomach = new ItemFood(4, 6f, false),
	Heart = new ItemFood(1, .2f, true),
	CookedHeart = new ItemFood(2, .4f, false),
	CowHide = new Item(),
	PigHide = new Item(),
	TannedPigHide = new Item(),
	PigHideHelmet = new CustomArmor(armor_PigHide, 4, 0, "PigHide"),
	PigHideChestplate = new CustomArmor(armor_PigHide, 4, 1, "PigHide"),
	PigHideLeggings = new CustomArmor(armor_PigHide, 4, 2, "PigHide"),
	PigHideBoots = new CustomArmor(armor_PigHide, 4, 3, "PigHide"),
	Lamb = new ItemFood(3, .3f, true),
	CookedLamb = new ItemFood(5, .8f, false),
	Lung = new ItemFood(5, 2f, true),
	CookedLung = new ItemFood(7, 4f, false),
	Kidney = new ItemFood(5, 2f, true),
	CookedKidney = new ItemFood(5, 2f, true),
	jarOfBlood = new Item(),
	batWingSoup = new ItemSoup(8),
	batWing = new Item(),
	batWingBoots = new CustomArmor(armor_BatWing, 4, 3, "BatWing"),
	soulBottle = new Item(),
	soulBottleFull = new Item(),
	xpBottle = new ItemXPBottle().setMaxStackSize(1),
	playerHead = new ItemPlayerHead(),
	supporter = new ItemSupporter(),
	guideBook = new ItemGuideBook();
	
	
	public static ArrayList<String> ItemList = new ArrayList();
	public static void loadItems(){
		CarvingKnife.setMaxStackSize(1);
		CarvingKnife.setMaxDamage(3);
		
		soulBottleFull.setMaxStackSize(1);
		guideBook.setMaxStackSize(1);
		
		registerItem(CarvingKnife, "CarvingKnife");
		registerItem(Brain, "RawBrain");
		registerItem(CookedBrain, "CookedBrain");
		registerItem(Stomach, "RawStomach");
		registerItem(CookedStomach, "CookedStomach");
		registerItem(Heart, "RawHeart");
		registerItem(CookedHeart, "CookedHeart");
		registerItem(CowHide, "CowHide");
		registerItem(PigHide, "PigHide");
		registerItem(TannedPigHide, "TannedPigHide");
		registerItem(PigHideHelmet, "PigHideHelmet");
		registerItem(PigHideChestplate, "PigHideChestplate");
		registerItem(PigHideLeggings, "PigHideLeggings");
		registerItem(PigHideBoots, "PigHideBoots");
		registerItem(Lamb, "Lamb");
		registerItem(CookedLamb, "CookedLamb");
		registerItem(Lung, "Lung");
		registerItem(CookedLung, "CookedLung");
		registerItem(Kidney, "Kidney");
		registerItem(CookedKidney, "CookedKidney");
		registerItem(jarOfBlood, "JarOfBlood");
		registerItem(batWingSoup, "BatwingSoup");
		registerItem(batWing, "BatWing");
		registerItem(batWingBoots, "BatWingBoots");
		registerItem(soulBottle, "SoulBottle");
		registerItem(soulBottleFull, "SoulBottleFull");
		registerItem(xpBottle, "XPBottle");
		registerItem(playerHead, "PlayerHead");
		registerItem(supporter, "Supporter");
		registerItem(guideBook, "GuideBook");
		
		printItemList();
	}
	
	private static void registerItem(Item i, String s){
		i.setUnlocalizedName("rd_" + s);
		i.setCreativeTab(RealisticDeaths.tabRealisticDeaths);
		i.setTextureName("rd:" + s);
		GameRegistry.registerItem(i, "rd_" + s);
		ItemList.add("Item:" + s);
	}
	
	private static void printItemList(){
		System.out.println("\nRegistering the following objects with the mod Realistic Deaths.\n"
				+ " There are a total of " + ItemList.size() + " objects in this mod."
				+ "\n{");
		for(int i=0;i<ItemList.size();i++){
			System.out.println(ItemList.get(i));
		}
		System.out.println("}");
	}

}
