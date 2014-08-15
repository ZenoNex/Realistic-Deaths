package mods.Cyphereion.RealisticDeaths.Object;

import mods.Cyphereion.RealisticDeaths.RealisticDeaths;
import mods.Cyphereion.RealisticDeaths.Object.Bat.BlockBatBody;
import mods.Cyphereion.RealisticDeaths.Object.Bat.TileEntityBatBody;
import mods.Cyphereion.RealisticDeaths.Object.Cat.BlockCatBody;
import mods.Cyphereion.RealisticDeaths.Object.Cat.TileEntityCatBody;
import mods.Cyphereion.RealisticDeaths.Object.Chicken.BlockChickenBody;
import mods.Cyphereion.RealisticDeaths.Object.Chicken.TileEntityChickenBody;
import mods.Cyphereion.RealisticDeaths.Object.Cow.BlockCowBody;
import mods.Cyphereion.RealisticDeaths.Object.Cow.TileEntityCowBody;
import mods.Cyphereion.RealisticDeaths.Object.Creeper.BlockCreeperBody;
import mods.Cyphereion.RealisticDeaths.Object.Creeper.TileEntityCreeperBody;
import mods.Cyphereion.RealisticDeaths.Object.Enderman.BlockEndermanBody;
import mods.Cyphereion.RealisticDeaths.Object.Enderman.TileEntityEndermanBody;
import mods.Cyphereion.RealisticDeaths.Object.MagmaCube.BlockMagmaBody;
import mods.Cyphereion.RealisticDeaths.Object.MagmaCube.TileEntityMagmaBody;
import mods.Cyphereion.RealisticDeaths.Object.Pig.BlockPigBody;
import mods.Cyphereion.RealisticDeaths.Object.Pig.TileEntityPigBody;
import mods.Cyphereion.RealisticDeaths.Object.Sheep.BlockSheepBody;
import mods.Cyphereion.RealisticDeaths.Object.Sheep.TileEntitySheepBody;
import mods.Cyphereion.RealisticDeaths.Object.Skeleton.BlockSkeletonBody;
import mods.Cyphereion.RealisticDeaths.Object.Skeleton.TileEntitySkeletonBody;
import mods.Cyphereion.RealisticDeaths.Object.Slime.BlockSlimeBody;
import mods.Cyphereion.RealisticDeaths.Object.Slime.TileEntitySlimeBody;
import mods.Cyphereion.RealisticDeaths.Object.Spider.BlockSpiderBody;
import mods.Cyphereion.RealisticDeaths.Object.Spider.TileEntitySpiderBody;
import mods.Cyphereion.RealisticDeaths.Object.Villager.BlockVillagerBody;
import mods.Cyphereion.RealisticDeaths.Object.Villager.TileEntityVillagerBody;
import mods.Cyphereion.RealisticDeaths.Object.Witch.BlockWitchBody;
import mods.Cyphereion.RealisticDeaths.Object.Witch.TileEntityWitchBody;
import mods.Cyphereion.RealisticDeaths.Object.Zombie.BlockZombieBody;
import mods.Cyphereion.RealisticDeaths.Object.Zombie.TileEntityZombieBody;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockManager {
	
	public static Block CowBody, PigBody, ChickenBody, SheepBody, CatBody, VillagerBody, ZombieBody, SkeletonBody, EndermanBody,
	WitchBody, CreeperBody, BatBody, SlimeBody, MagmaBody, SpiderBody, CompressedDiamond;
	
	public static void loadBlocks(){
		CowBody = new BlockCowBody();
		registerModeledBlock(CowBody, "CowBody");
		GameRegistry.registerTileEntity(TileEntityCowBody.class, "rd_tileCowBody");
		
		PigBody = new BlockPigBody();
		registerModeledBlock(PigBody, "PigBody");
		GameRegistry.registerTileEntity(TileEntityPigBody.class, "rd_tilePigBody");
		
		ChickenBody = new BlockChickenBody();
		registerModeledBlock(ChickenBody, "ChickenBody");
		GameRegistry.registerTileEntity(TileEntityChickenBody.class, "rd_tileChickenBody");
		
		SheepBody = new BlockSheepBody();
		registerModeledBlock(SheepBody, "SheepBody");
		GameRegistry.registerTileEntity(TileEntitySheepBody.class, "rd_tileSheepBody");
		
		CatBody = new BlockCatBody();
		registerModeledBlock(CatBody, "CatBody");
		GameRegistry.registerTileEntity(TileEntityCatBody.class, "rd_tileCatBody");
		
		VillagerBody = new BlockVillagerBody();
		registerModeledBlock(VillagerBody, "VillagerBody");
		GameRegistry.registerTileEntity(TileEntityVillagerBody.class, "rd_tileVillagerBody");
		
		ZombieBody = new BlockZombieBody();
		registerModeledBlock(ZombieBody, "ZombieBody");
		GameRegistry.registerTileEntity(TileEntityZombieBody.class, "rd_tileZombieBody");
		
		SkeletonBody = new BlockSkeletonBody();
		registerModeledBlock(SkeletonBody, "SkeletonBody");
		GameRegistry.registerTileEntity(TileEntitySkeletonBody.class, "rd_tileSkeletonBody");
		
		EndermanBody = new BlockEndermanBody();
		registerModeledBlock(EndermanBody, "EndermanBody");
		GameRegistry.registerTileEntity(TileEntityEndermanBody.class, "rd_tileEndermanBody");
		
		WitchBody = new BlockWitchBody();
		registerModeledBlock(WitchBody, "WitchBody");
		GameRegistry.registerTileEntity(TileEntityWitchBody.class, "rd_tileWitchBody");
		
		CreeperBody = new BlockCreeperBody();
		registerModeledBlock(CreeperBody, "CreeperBody");
		GameRegistry.registerTileEntity(TileEntityCreeperBody.class, "rd_tileCreeperBody");
		
		BatBody = new BlockBatBody();
		registerModeledBlock(BatBody, "BatBody");
		GameRegistry.registerTileEntity(TileEntityBatBody.class, "rd_tileBatBody");
		
		SlimeBody = new BlockSlimeBody();
		registerModeledBlock(SlimeBody, "SlimeBody");
		GameRegistry.registerTileEntity(TileEntitySlimeBody.class, "rd_tileSlimeBody");
		
		MagmaBody = new BlockMagmaBody();
		registerModeledBlock(MagmaBody, "MagmaBody");
		GameRegistry.registerTileEntity(TileEntityMagmaBody.class, "rd_tileMagmaBody");
		
		SpiderBody = new BlockSpiderBody();
		registerModeledBlock(SpiderBody, "SpiderBody");
		GameRegistry.registerTileEntity(TileEntitySpiderBody.class, "rd_tileSpiderBody");
		
		CompressedDiamond = new CompressedDiamond();
		registerModeledBlock(CompressedDiamond, "CompressedDiamond");
	}
	
	private static void registerModeledBlock(Block block, String string){
		block.setCreativeTab(RealisticDeaths.tabRealisticDeaths);
		block.setBlockName("rd_" + string);
		block.setHardness(.56f);
		block.setBlockTextureName("rd:" + string);
		GameRegistry.registerBlock(block, "rd_" + string);
		ItemManager.ItemList.add("Block:" + string);
	}
	
}
