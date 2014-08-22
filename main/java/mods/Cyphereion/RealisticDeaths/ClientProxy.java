package mods.Cyphereion.RealisticDeaths;

import mods.Cyphereion.RealisticDeaths.Object.Bat.RenderBatBody;
import mods.Cyphereion.RealisticDeaths.Object.Bat.TileEntityBatBody;
import mods.Cyphereion.RealisticDeaths.Object.Boss.EntityBoss;
import mods.Cyphereion.RealisticDeaths.Object.Boss.ModelBoss;
import mods.Cyphereion.RealisticDeaths.Object.Boss.RenderBoss;
import mods.Cyphereion.RealisticDeaths.Object.Cat.RenderCatBody;
import mods.Cyphereion.RealisticDeaths.Object.Cat.TileEntityCatBody;
import mods.Cyphereion.RealisticDeaths.Object.Chicken.RenderChickenBody;
import mods.Cyphereion.RealisticDeaths.Object.Chicken.TileEntityChickenBody;
import mods.Cyphereion.RealisticDeaths.Object.Cow.RenderCowBody;
import mods.Cyphereion.RealisticDeaths.Object.Cow.TileEntityCowBody;
import mods.Cyphereion.RealisticDeaths.Object.Creeper.RenderCreeperBody;
import mods.Cyphereion.RealisticDeaths.Object.Creeper.TileEntityCreeperBody;
import mods.Cyphereion.RealisticDeaths.Object.Enderman.RenderEndermanBody;
import mods.Cyphereion.RealisticDeaths.Object.Enderman.TileEntityEndermanBody;
import mods.Cyphereion.RealisticDeaths.Object.MagmaCube.RenderMagmaBody;
import mods.Cyphereion.RealisticDeaths.Object.MagmaCube.TileEntityMagmaBody;
import mods.Cyphereion.RealisticDeaths.Object.Pig.RenderPigBody;
import mods.Cyphereion.RealisticDeaths.Object.Pig.TileEntityPigBody;
import mods.Cyphereion.RealisticDeaths.Object.Sheep.RenderSheepBody;
import mods.Cyphereion.RealisticDeaths.Object.Sheep.TileEntitySheepBody;
import mods.Cyphereion.RealisticDeaths.Object.Skeleton.RenderSkeletonBody;
import mods.Cyphereion.RealisticDeaths.Object.Skeleton.TileEntitySkeletonBody;
import mods.Cyphereion.RealisticDeaths.Object.Slime.RenderSlimeBody;
import mods.Cyphereion.RealisticDeaths.Object.Slime.TileEntitySlimeBody;
import mods.Cyphereion.RealisticDeaths.Object.Spider.RenderSpiderBody;
import mods.Cyphereion.RealisticDeaths.Object.Spider.TileEntitySpiderBody;
import mods.Cyphereion.RealisticDeaths.Object.Villager.RenderVillagerBody;
import mods.Cyphereion.RealisticDeaths.Object.Villager.TileEntityVillagerBody;
import mods.Cyphereion.RealisticDeaths.Object.Witch.RenderWitchBody;
import mods.Cyphereion.RealisticDeaths.Object.Witch.TileEntityWitchBody;
import mods.Cyphereion.RealisticDeaths.Object.Zombie.RenderZombieBody;
import mods.Cyphereion.RealisticDeaths.Object.Zombie.TileEntityZombieBody;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends CommonProxy{
	
	public void register(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCowBody.class, new RenderCowBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPigBody.class, new RenderPigBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChickenBody.class, new RenderChickenBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySheepBody.class, new RenderSheepBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCatBody.class, new RenderCatBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVillagerBody.class, new RenderVillagerBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityZombieBody.class, new RenderZombieBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySkeletonBody.class, new RenderSkeletonBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEndermanBody.class, new RenderEndermanBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWitchBody.class, new RenderWitchBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCreeperBody.class, new RenderCreeperBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBatBody.class, new RenderBatBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySlimeBody.class, new RenderSlimeBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMagmaBody.class, new RenderMagmaBody());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpiderBody.class, new RenderSpiderBody());
		RenderingRegistry.registerEntityRenderingHandler(EntityBoss.class, new RenderBoss(new ModelBoss(), 1));
	}
}