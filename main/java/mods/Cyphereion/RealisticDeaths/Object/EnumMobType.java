package mods.Cyphereion.RealisticDeaths.Object;

import java.util.ArrayList;

public enum EnumMobType {
	Cow, Pig, Sheep, Chicken, Skeleton, Zombie, Witch, Creeper,
	Enderman, Villager, Cat, Player, Bat, Slime, Magma, Spider;
	
	public static EnumMobType[] mobList = {
		Cow, Pig, Sheep, Chicken, Skeleton, Zombie, Witch, Creeper, 
		Enderman, Villager, Cat, Player, Bat, Slime, Magma, Spider
		};
	
	public int getIDFromType(EnumMobType type){
		ArrayList<EnumMobType> list = new ArrayList<EnumMobType>();
		int id = 0;
		for(int i=0;i<mobList.length;i++){
			if(mobList[i] == type){
				id = i;
			}
		}
		return id;
	}

}
