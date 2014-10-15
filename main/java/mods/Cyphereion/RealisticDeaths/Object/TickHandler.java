package mods.Cyphereion.RealisticDeaths.Object;

import mods.Cyphereion.RealisticDeaths.ModEventHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class TickHandler{

	@SubscribeEvent
	public void tick(TickEvent e){

	}
	
	private static int ticks=0;
	private static boolean hasCooldowned = false;
	
	@SubscribeEvent
	public void playerTickEvent(PlayerTickEvent e){
		EntityPlayer player = e.player;
		if(player != null){
			if(!player.worldObj.isRemote){
				if(player.inventory.hasItem(ItemManager.supporter)){
					ticks ++;
					int seconds = 5;
					if(ticks > 5 * 100){
						ticks = 0;
						for(int i=0;i<player.inventory.getSizeInventory();i++){
							if(player.inventory.getStackInSlot(i) != null){
								if(player.inventory.getStackInSlot(i).getItem() == ItemManager.supporter){
									if(!hasCooldowned){
										ItemStack item = player.inventory.getStackInSlot(i);
										if(10 - item.getItemDamageForDisplay() != 10){
											item.damageItem(-1, player);
											hasCooldowned = true;
										}
									}
								}
							}
						}
						hasCooldowned = false;
					}
					
					boolean take = true;
					for(int i=0;i<ModEventHandler.supporterList.length;i++){
						if(ModEventHandler.supporterList[i].equals(player.getDisplayName())){
							take = false;
						}
					}
					if(take){
						player.inventory.consumeInventoryItem(ItemManager.supporter);
						player.inventoryContainer.detectAndSendChanges();
					}
				}
			}
		}
	}
}
