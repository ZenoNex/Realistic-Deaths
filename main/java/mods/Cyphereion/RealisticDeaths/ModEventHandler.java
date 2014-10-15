package mods.Cyphereion.RealisticDeaths;

import java.util.Random;

import mods.Cyphereion.RealisticDeaths.Object.AchievementManager;
import mods.Cyphereion.RealisticDeaths.Object.BlockManager;
import mods.Cyphereion.RealisticDeaths.Object.EnchantmentManager;
import mods.Cyphereion.RealisticDeaths.Object.EnumMobType;
import mods.Cyphereion.RealisticDeaths.Object.ItemManager;
import mods.Cyphereion.RealisticDeaths.Object.RecipeManager;
import mods.Cyphereion.RealisticDeaths.Object.Boss.EntityBoss;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ModEventHandler {
	public static String[] supporterList = {"deadrecon98"};
	
	@SubscribeEvent
	public void playerJoinEvent(EntityJoinWorldEvent e){
		if(e.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)e.entity;
			for(int i=0;i<supporterList.length;i++){
				if(supporterList[i].equals(player.getDisplayName())){
					if(!player.worldObj.isRemote){
						player.addStat(AchievementManager.supporter, 1);
						RecipeManager.drop(player, ItemManager.supporter, 1);
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void livingDeathEvent(LivingDeathEvent event){
		Entity ent = event.entity;
		World world = ent.worldObj;
		Random rand = new Random();
		
		if(rand.nextInt(100) <= 10){
			if(event.source.getEntity() != null){
				if(event.source.getEntity() instanceof EntityPlayer){
					EntityPlayer player = (EntityPlayer)event.source.getEntity();
					if(player.inventory.getCurrentItem().hasEffect(EnchantmentManager.SoulTaker.effectId)){
						if(player.inventory.hasItem(ItemManager.soulBottle)){
							player.inventory.consumeInventoryItem(ItemManager.soulBottle);
							RecipeManager.drop(player, ItemManager.soulBottleFull, 1);
						}
					}
				}
			}
		}
		
		if(ent instanceof EntityBoss){
			EntitySpider spider = new EntitySpider(world);
			for(int i=0;i<rand.nextInt(12)+1;i++){
				world.spawnEntityInWorld(spider);
			}
		}
		
		if(!world.isRemote && rand.nextInt(100) <= 25){
			Block b = null;
			if(ent instanceof EntityCow){
				b = BlockManager.CowBody;
			}
			if(ent instanceof EntityPig){
				b = BlockManager.PigBody;
			}
			if(ent instanceof EntityChicken){
				b = BlockManager.ChickenBody;
			}
			if(ent instanceof EntitySheep){
				b = BlockManager.SheepBody;
			}
			if(ent instanceof EntityOcelot){
				b = BlockManager.CatBody;
			}
			if(ent instanceof EntityZombie){
				b = BlockManager.ZombieBody;
			}
			if(ent instanceof EntitySkeleton){
				b = BlockManager.SkeletonBody;
			}
			if(ent instanceof EntityEnderman){
				b = BlockManager.EndermanBody;
			}
			if(ent instanceof EntityVillager){
				b = BlockManager.VillagerBody;
			}
			if(ent instanceof EntityWitch){
				b = BlockManager.WitchBody;
			}
			if(ent instanceof EntityCreeper){
				b = BlockManager.CreeperBody;
			}
			if(ent instanceof EntityBat){
				b = BlockManager.BatBody;
			}
			if(ent instanceof EntitySlime){
				b = BlockManager.SlimeBody;
			}
			if(ent instanceof EntityMagmaCube){
				b = BlockManager.MagmaBody;
			}
			if(ent instanceof EntityPlayer){
				EntityPlayer player = (EntityPlayer)ent;
				MinecraftServer server = MinecraftServer.getServer();
				if(!world.isRemote){
					server.getCommandManager().executeCommand(server, "/setblock " + ent.posX + " " + ent.posY + " " + ent.posZ + " minecraft:skull 1 replace {ExtraType:" + player.getDisplayName() + ",SkullType:3}");
				}
			}
			if(b != null){
				world.setBlock((int)ent.posX, (int)ent.posY, (int)ent.posZ, b);
			}
		}
	}
	
	@SubscribeEvent
	public void entityDamageEvent(LivingHurtEvent e){
		if(e.source.damageType.contains("fall")){
			if(e.entity instanceof EntityPlayer){
				EntityPlayer player = (EntityPlayer)e.entity;
				if(player.inventory.armorItemInSlot(0) != null){
					if(player.inventory.armorItemInSlot(0).getItem() == ItemManager.batWingBoots){
						int damage = player.inventory.armorItemInSlot(0).getMaxDamage() - player.inventory.armorItemInSlot(0).getItemDamageForDisplay();
						if((int)e.ammount > damage){
							int reduce = (int)e.ammount - damage;
							player.heal(-reduce);
						}
						player.addStat(AchievementManager.damageDenied, 1);
						player.inventory.armorItemInSlot(0).damageItem((int)e.ammount * 2, player);
						e.setCanceled(true);
					}
				}
			}
		}
		if(e.entity != null){
			if(e.entity instanceof EntityPlayer){
				EntityPlayer player = (EntityPlayer)e.entity;
				if(e.ammount >= player.getHealth()){
					if(player.inventory.hasItem(ItemManager.soulBottleFull)){
						player.inventory.consumeInventoryItem(ItemManager.soulBottleFull);
						e.ammount = 0;
						player.heal(player.getMaxHealth());
						player.getFoodStats().setFoodLevel(20);
			        	ChatComponentText component = new ChatComponentText(EnumChatFormatting.GREEN + "" + EnumChatFormatting.BOLD + "Second Win!");
			        	player.addChatComponentMessage(component);
			        	player.addExperience((int)-player.experienceLevel);
					}
				}
			}
		}
		if(e.source.getEntity() != null){
			if(e.source.getEntity() instanceof EntityPlayer){
				EntityPlayer player = (EntityPlayer)e.source.getEntity();
				if(player.inventory.getCurrentItem() != null){
					if(EnchantmentHelper.getEnchantmentLevel(EnchantmentManager.lifesteal.effectId, player.inventory.getCurrentItem()) > 0){
						int multiplier = EnchantmentHelper.getEnchantmentLevel(EnchantmentManager.lifesteal.effectId, player.inventory.getCurrentItem());
						player.heal(e.ammount * multiplier);
					}
				}
			}else if(e.source.isProjectile()){
				if(e.source.getEntity() instanceof EntityArrow){
					EntityArrow arrow = (EntityArrow)e.source.getEntity();
					if(arrow.shootingEntity instanceof EntityPlayer){
						EntityPlayer player = (EntityPlayer)arrow.shootingEntity;
						if(EnchantmentHelper.getEnchantmentLevel(EnchantmentManager.lifesteal.effectId, player.inventory.getCurrentItem()) > 0){
							int multiplier = EnchantmentHelper.getEnchantmentLevel(EnchantmentManager.lifesteal.effectId, player.inventory.getCurrentItem());
							player.heal(e.ammount * multiplier / .5f);
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void playerInteractEvent(PlayerInteractEvent e){
		World world = e.entityPlayer.worldObj;
		EntityPlayer player = e.entityPlayer;
		Random rand = new Random();
		if(e.action.name().equals("RIGHT_CLICK_BLOCK")){
				Block b = world.getBlock(e.x, e.y, e.z);
				if(b != null){
					if(!world.isRemote){
						if(rand.nextInt(100) <= 10){
							player.inventory.addItemStackToInventory(new ItemStack(b, 1));
						}
						if(b == Blocks.skull){
							if(b.getDamageValue(world, e.x, e.y, e.z) == 3){
								if(player.inventory.getCurrentItem() != null){
									if(player.inventory.getCurrentItem().getItem() == ItemManager.CarvingKnife){
										RecipeManager.doManditoryDrops(player, EnumMobType.Player);
										player.inventory.getCurrentItem().damageItem(1, player);
										world.setBlockToAir(e.x, e.y, e.z);
									}
									if(player.inventory.getCurrentItem().getItem() == Items.glass_bottle){
										world.setBlockToAir(e.x, e.y, e.z);
										player.addStat(AchievementManager.bloodThirsty, 1);
										player.inventory.consumeInventoryItem(Items.glass_bottle);
										player.inventory.addItemStackToInventory(new ItemStack(ItemManager.jarOfBlood, 1));
									}
									player.inventoryContainer.detectAndSendChanges();
								}
							}
						}
					}
				}
		}
	}
}
