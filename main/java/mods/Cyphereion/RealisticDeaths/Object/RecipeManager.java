package mods.Cyphereion.RealisticDeaths.Object;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeManager extends GameRegistry{
	
	public static void loadRecipes(){
		addSmelting(ItemManager.Brain, new ItemStack(ItemManager.CookedBrain, 1), 5);
		addSmelting(ItemManager.Heart, new ItemStack(ItemManager.CookedHeart, 1), 5);
		addSmelting(ItemManager.Stomach, new ItemStack(ItemManager.CookedStomach, 1), 5);
		addSmelting(ItemManager.CowHide, new ItemStack(Items.leather, 1), 2);
		addSmelting(ItemManager.PigHide, new ItemStack(ItemManager.TannedPigHide, 1), 5);
		addSmelting(ItemManager.Lamb, new ItemStack(ItemManager.CookedLamb, 1), 5);
		addSmelting(ItemManager.Lung, new ItemStack(ItemManager.CookedLung, 1), 5);
		addSmelting(ItemManager.Kidney, new ItemStack(ItemManager.CookedKidney, 1), 5);
		
		ItemStack is_ench = new ItemStack(ItemManager.CarvingKnife);
		is_ench.addEnchantment(EnchantmentManager.Suprise, 1);
		is_ench.setStackDisplayName(EnumChatFormatting.GOLD + "Carving Knife");
		addShapelessRecipe(is_ench,ItemManager.CarvingKnife, ItemManager.jarOfBlood);
		
		addRecipe(new ItemStack(BlockManager.CompressedDiamond, 1), "ddd", "ddd", "ddd", Character.valueOf('d'), Blocks.diamond_block);
		addRecipe(new ItemStack(ItemManager.xpBottle, 1), " G ", "GXG", "GGG", Character.valueOf('G'), Blocks.glass, Character.valueOf('X'), Items.experience_bottle);
		addRecipe(new ItemStack(ItemManager.batWingBoots, 1), "1 1", "1 1", "   ", '1', ItemManager.batWing);
		addRecipe(new ItemStack(ItemManager.batWingBoots, 1), "   ", "1 1", "1 1", '1', ItemManager.batWing);
		
		addShapelessRecipe(new ItemStack(Blocks.diamond_block, 9), BlockManager.CompressedDiamond);
		addShapelessRecipe(new ItemStack(ItemManager.batWingSoup, 1), Items.mushroom_stew, ItemManager.batWing);
		
		registerArmorRecipe(ItemManager.PigHideHelmet, ItemManager.PigHideChestplate, ItemManager.PigHideLeggings, ItemManager.PigHideBoots, ItemManager.TannedPigHide);
		
		addShapelessRecipe(new ItemStack(ItemManager.CarvingKnife, 1), Items.stick, Items.iron_ingot);
	}
	
	private static void registerArmorRecipe(Item helm, Item chest, Item leg, Item boot, Item CraftedWith){
		addRecipe(new ItemStack(helm, 1), "111", "1 1", "   ", '1', CraftedWith);
		addRecipe(new ItemStack(helm, 1), "   ", "111", "1 1", '1', CraftedWith);
		addRecipe(new ItemStack(leg, 1), "111", "1 1", "1 1", '1', CraftedWith);
		addRecipe(new ItemStack(chest, 1), "1 1", "111", "111", '1', CraftedWith);
		addRecipe(new ItemStack(boot, 1), "1 1", "1 1", "   ", '1', CraftedWith);
		addRecipe(new ItemStack(boot, 1), "   ", "1 1", "1 1", '1', CraftedWith);
	}
	
	public static void doManditoryDrops(EntityPlayer player, EnumMobType type){
		Random rand = new Random();
		player.addStat(AchievementManager.dexter, 1);
		
		int multiplier = 1;
		
		if(EnchantmentHelper.getEnchantmentLevel(EnchantmentManager.Suprise.effectId, player.inventory.getCurrentItem()) > 0){
			multiplier += EnchantmentHelper.getEnchantmentLevel(EnchantmentManager.Suprise.effectId, player.inventory.getCurrentItem());
		}
		
		drop(player, ItemManager.Brain, rand.nextInt(2) + 1 * multiplier);
		drop(player, ItemManager.Stomach, rand.nextInt(2) + 1 * multiplier);
		drop(player, ItemManager.Heart, rand.nextInt(2) + 1 * multiplier);
		drop(player, ItemManager.Lung, rand.nextInt(3) + 1 * multiplier);
		drop(player, ItemManager.Kidney, rand.nextInt(3) + 1 * multiplier);
		drop(player, Items.bone, rand.nextInt(10) + 1 * multiplier);
		
		if(type == EnumMobType.Witch){
			drop(player, Items.glass_bottle, rand.nextInt(12) * multiplier);
		}
		if(type==EnumMobType.Zombie){
			drop(player, Items.rotten_flesh, rand.nextInt(12) * multiplier);
		}
		if(type==EnumMobType.Villager){
			if(rand.nextInt(100)<=5){
				drop(player, Items.emerald, rand.nextInt(12) * multiplier);
				drop(player, Items.diamond, rand.nextInt(12) * multiplier);
			}
		}
		if(type==EnumMobType.Skeleton){
			drop(player, Items.bone, rand.nextInt(12) * multiplier);
		}
		if(type==EnumMobType.Sheep){
			drop(player, Blocks.wool, rand.nextInt(15) * multiplier);
			drop(player, ItemManager.Lamb, rand.nextInt(12) * multiplier);
		}
		if(type==EnumMobType.Pig){
			drop(player, Items.porkchop, rand.nextInt(6) * multiplier);
			drop(player, ItemManager.PigHide, rand.nextInt(5) * multiplier);
		}
		if(type==EnumMobType.Enderman){
			drop(player, Items.ender_eye, 2 * multiplier);
			drop(player, Items.ender_pearl, rand.nextInt(3) * multiplier);
		}
		if(type==EnumMobType.Creeper){
			drop(player, Items.gunpowder, rand.nextInt(12) * multiplier);
		}
		if(type==EnumMobType.Cow){
			drop(player, Items.beef, rand.nextInt(10) * multiplier);
			drop(player, ItemManager.CowHide, rand.nextInt(15) * multiplier);
		}
		if(type==EnumMobType.Chicken){
			drop(player, Items.chicken, rand.nextInt(3) * multiplier);
			drop(player, Items.feather, rand.nextInt(12) * multiplier);
		}
		if(type==EnumMobType.Cat){
			drop(player, Items.fish, rand.nextInt(3) * multiplier);
		}
		if(type==EnumMobType.Slime){
			drop(player, Items.slime_ball, rand.nextInt(15) * multiplier);
		}
		if(type==EnumMobType.Player){
			if(rand.nextInt(100) <= 5){
				drop(player, Items.iron_ingot, rand.nextInt(7) * multiplier);
				drop(player, Items.coal, rand.nextInt(14) * multiplier);
				drop(player, Blocks.cobblestone, rand.nextInt(85) * multiplier);
				if(rand.nextInt(100) <= 5){
					drop(player, Items.diamond, rand.nextInt(54) * multiplier);
					drop(player, Items.emerald, rand.nextInt(25) * multiplier);
					drop(player, Items.iron_ingot, rand.nextInt(34) * multiplier);
				}
			}
		}
		if(type==EnumMobType.Magma){
			drop(player, Items.magma_cream, rand.nextInt(3) * multiplier);
		}
		if(type==EnumMobType.Bat){
			drop(player, ItemManager.batWing, rand.nextInt(2) * multiplier);
		}
		if(type==EnumMobType.Spider){
			drop(player, Items.string, rand.nextInt(12) * multiplier);
		}
		player.inventoryContainer.detectAndSendChanges();
	}
	
	public static void drop(EntityPlayer player, Item i, int rand, int meta){
		if(player.inventory.getFirstEmptyStack() == -1){
			player.entityDropItem(new ItemStack(i, 1, meta), rand);
		}else{
			player.inventory.addItemStackToInventory(new ItemStack(i, rand, meta));
		}
	}
	public static void drop(EntityPlayer player, Item i, int rand){
		if(player.inventory.getFirstEmptyStack() == -1){
			player.entityDropItem(new ItemStack(i, 1), rand);
		}else{
			player.inventory.addItemStackToInventory(new ItemStack(i, rand));
		}
	}
	public static void drop(EntityPlayer player, Block i, int rand, int meta){
		if(player.inventory.getFirstEmptyStack() == -1){
			player.entityDropItem(new ItemStack(i, 1, meta), rand);
		}else{
			player.inventory.addItemStackToInventory(new ItemStack(i, rand, meta));
		}
	}
	public static void drop(EntityPlayer player, Block i, int rand){
		if(player.inventory.getFirstEmptyStack() == -1){
			player.entityDropItem(new ItemStack(i, 1), rand);
		}else{
			player.inventory.addItemStackToInventory(new ItemStack(i, rand));
		}
	}
}
