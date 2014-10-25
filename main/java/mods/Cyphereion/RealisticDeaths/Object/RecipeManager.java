package mods.Cyphereion.RealisticDeaths.Object;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
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
		addRecipe(new ItemStack(ItemManager.supporter, 1), " s ", "sis", " s ", Character.valueOf('s'), Items.stick, Character.valueOf('i'), Items.iron_ingot);
		
		addShapelessRecipe(new ItemStack(ItemManager.guideBook, 1), Items.dye, Items.book, new ItemStack(Items.dye, 1, 4), Items.feather);
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
		int id = type.getIDFromType(type);
		
		int x =Minecraft.getMinecraft().objectMouseOver.blockX, y = Minecraft.getMinecraft().objectMouseOver.blockY, z = Minecraft.getMinecraft().objectMouseOver.blockZ;
		
		int multiplier = 1;
        
		if(player.inventory.hasItem(ItemManager.supporter)){
			multiplier += 1;
		}
		
		if(EnchantmentHelper.getEnchantmentLevel(EnchantmentManager.Suprise.effectId, player.inventory.getCurrentItem()) > 0){
			multiplier += EnchantmentHelper.getEnchantmentLevel(EnchantmentManager.Suprise.effectId, player.inventory.getCurrentItem());
		}
		
		for(int i=0;i<50;i++){
			Minecraft.getMinecraft().theWorld.spawnParticle("reddust", x + 0.5D + rand.nextDouble(), y + 0.5D + rand.nextDouble(), z - 1 + 0.5D + rand.nextDouble(), 0, 0, 0);
		}
		switch(id){
		default:
			dropOrgans(player, 1, 1, 1, 2, 1, 7, multiplier);
			System.err.println("Entity " + id + " has not been registered!");
			break;
		case 0:
			drop(player, ItemManager.CowHide, rand.nextInt(5) + 1 * multiplier);
			drop(player, Items.leather, rand.nextInt(2) + 1 * multiplier);
			dropOrgans(player, 1, 1, 1, 2, 1, 7, multiplier);
			break;
		case 1:
			RecipeManager.dropOrgans(player, 1, 1, 1, 1, 1, 1, multiplier);
			drop(player, ItemManager.PigHide, rand.nextInt(3) + 1 * multiplier);
			drop(player, Items.porkchop, rand.nextInt(4) + 1 * multiplier);
			break;
		case 2:
			RecipeManager.dropOrgans(player, 1, 1, 1, 1, 1, 1, multiplier);
			drop(player, ItemManager.Lamb, rand.nextInt(2) + 1 * multiplier);
			drop(player, Blocks.wool, rand.nextInt(3) + 1 * multiplier);
			break;
		case 3:
			RecipeManager.dropOrgans(player, 1, 1, 1, 1, 1, 1, multiplier);
			drop(player, Items.feather, rand.nextInt(4) + 1 * multiplier);
			drop(player, Items.chicken, rand.nextInt(2) + 1 * multiplier);
			break;
		case 4:
			RecipeManager.dropOrgans(player, 1, 1, 1, 1, 1, 1, multiplier);
			drop(player, Items.bone, rand.nextInt(5) + 1 * multiplier);
			if(rand.nextInt(100) <= 5){
				drop(player, Items.iron_sword, 1);
				ItemStack is = new ItemStack(Items.bow, 1);
				if(multiplier > 0){
					is.addEnchantment(Enchantment.flame, multiplier);
				}
				drop(player, is, 1);
			}
			break;
		case 5:
			RecipeManager.dropOrgans(player, 1, 1, 1, 1, 1, 1, multiplier);
			drop(player, Items.rotten_flesh, rand.nextInt(6) + 1 * multiplier);
			break;
		case 6:
			RecipeManager.dropOrgans(player, 1, 1, 1, 1, 1, 1, multiplier);
			drop(player, Items.glass_bottle, rand.nextInt(4) + 1 * multiplier);
			break;
		case 7:
			RecipeManager.dropOrgans(player, 1, 1, 1, 1, 1, 1, multiplier);
			drop(player, Items.gunpowder, rand.nextInt(4) + 1 * multiplier);
			break;
		case 8:
			RecipeManager.dropOrgans(player, 1, 1, 1, 1, 1, 1, multiplier);
			drop(player, Items.ender_pearl, rand.nextInt(1) + 1 * multiplier);
			break;
		case 9:
			RecipeManager.dropOrgans(player, 1, 1, 1, 1, 1, 1, multiplier);
			drop(player, Items.iron_ingot, rand.nextInt(3) + 1 * multiplier);
			if(rand.nextInt(100) <= 10){
				drop(player, Items.iron_ingot, rand.nextInt(25) + 1 * multiplier);
				drop(player, Items.gold_nugget, rand.nextInt(25) + 1 * multiplier);
				if(rand.nextInt(10) == 1){
					drop(player, Items.emerald, rand.nextInt(25) + 1 * multiplier);
					drop(player, Items.diamond, rand.nextInt(25) + 1 * multiplier);
				}
			} 
			break;
		case 10:
			RecipeManager.dropOrgans(player, 1, 1, 1, 1, 1, 1, multiplier);
			drop(player, Items.fish, rand.nextInt(3) + 1 * multiplier);
			break;
		case 11:
			RecipeManager.dropOrgans(player, 1, 1, 1, 1, 1, 1, multiplier);
			drop(player, Blocks.cobblestone, rand.nextInt(64) + 1 * multiplier);
			int random = rand.nextInt(500) + 1;
			if(random >= 500){
				drop(player, Items.diamond_helmet, 1 * multiplier);
				drop(player, Items.diamond_chestplate, 1 * multiplier);
				drop(player, Items.diamond_leggings, 1 * multiplier);
				drop(player, Items.diamond_boots, 1 * multiplier);
			}else if(random >= 400){
				drop(player, Items.diamond, 3 * multiplier);
			}else if(random >= 300){
				drop(player, Items.gold_ingot, 15 * multiplier);
			}else if(random >= 200){
				drop(player, Items.iron_ingot, 5 * multiplier);
			}else if(random >= 100){
				drop(player, Items.apple, rand.nextInt(35) + 1 * multiplier);
			}else if(random >= 50){
				drop(player, Blocks.dirt, rand.nextInt(125) + 1 * multiplier);
			}
			else{
				drop(player, Blocks.log, rand.nextInt(16) + 1 * multiplier);
			}
			break;
		case 12:
			RecipeManager.dropOrgans(player, 1, 1, 1, 1, 1, 1, multiplier);
			drop(player, ItemManager.batWing, 2 * multiplier);
			break;
		case 13:
			drop(player, Items.slime_ball, rand.nextInt(12) + 1 * multiplier);
			break;
		case 14:
			drop(player, Items.magma_cream, rand.nextInt(2) + 1 * multiplier);
			break;
		case 15:
			RecipeManager.dropOrgans(player, 1, 1, 1, 1, 1, 1, multiplier);
			drop(player, Items.string, rand.nextInt(4) + 1 * multiplier);
			break;
		}
		
		player.inventoryContainer.detectAndSendChanges();
	}
	
	/**
	 * 
	 * @param Player
	 * @param Brain
	 * @param Stomach
	 * @param Heart
	 * @param Lung
	 * @param Kidney
	 * @param Bone
	 * @param Multiplier
	 */
	public static void dropOrgans(EntityPlayer player,int brain, int stomach, int heart, int lung, int kidney, int bone, int multiplier){
		Random rand = new Random();
		drop(player, ItemManager.Brain, rand.nextInt(brain) + 1 * multiplier);
		drop(player, ItemManager.Stomach, rand.nextInt(stomach) + 1 * multiplier);
		drop(player, ItemManager.Heart, rand.nextInt(heart) + 1 * multiplier);
		drop(player, ItemManager.Lung, rand.nextInt(lung) + 1 * multiplier);
		drop(player, ItemManager.Kidney, rand.nextInt(kidney) + 1 * multiplier);
		drop(player, Items.bone, rand.nextInt(bone) + 1 * multiplier);
	}
	
	public static void drop(EntityPlayer player, Item i, int rand, int meta){
		if(player.inventory.getFirstEmptyStack() == -1){
			player.entityDropItem(new ItemStack(i, 1, meta), rand);
		}else{
			player.inventory.addItemStackToInventory(new ItemStack(i, rand, meta));
		}
	}
	
	public static void drop(EntityPlayer player, ItemStack i, int rand){
		if(player.inventory.getFirstEmptyStack() == -1){
			player.entityDropItem(i, rand);
		}else{
			player.inventory.addItemStackToInventory(i);
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
