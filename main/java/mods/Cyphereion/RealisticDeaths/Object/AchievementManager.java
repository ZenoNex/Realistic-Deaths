package mods.Cyphereion.RealisticDeaths.Object;

import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchievementManager {
	
	public static Achievement dexter, intellegent, cutie, bloodThirsty, damageDenied, supporter;
	
	public static void loadAchievements(){
		dexter = new Achievement("rd_002", "rd_002", 0, 0, ItemManager.CarvingKnife, (Achievement)null).registerStat();
		cutie = new Achievement("rd_005", "rd_005", -2, -1, BlockManager.PigBody, dexter).registerStat();
		intellegent = new Achievement("rd_003", "rd_003", -1, 1, ItemManager.Brain, dexter).registerStat();
		bloodThirsty = new Achievement("rd_006", "rd_006", 0, -2, ItemManager.jarOfBlood, dexter).registerStat();
		damageDenied = new Achievement("rd_007", "rd_007", 2, 0, ItemManager.batWingBoots, (Achievement)null).registerStat();
		damageDenied.isIndependent = true;
		supporter = new Achievement("rd_008", "rd_008", 2, 1, ItemManager.supporter, (Achievement)null).registerStat();
		supporter.setSpecial();
		AchievementPage.registerAchievementPage(new AchievementPage("Realistic Deaths", new Achievement[]{damageDenied, cutie, dexter, supporter, intellegent, bloodThirsty}));
	}
}
