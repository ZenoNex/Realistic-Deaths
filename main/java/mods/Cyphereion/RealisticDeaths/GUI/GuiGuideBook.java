package mods.Cyphereion.RealisticDeaths.GUI;

import javax.swing.KeyStroke;
import javax.swing.text.JTextComponent.KeyBinding;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class GuiGuideBook extends GuiScreen{
	
	private static int page = 0, pageSave = 0, keyTick = 0, 
			maxPages = 6,
			maxPageRecipe = 1, displayMaxRecipe = maxPageRecipe + 1,
			displayPage = page + 1, 
			displayMax = maxPages + 1;
	private static String Title = "",Special="";
	int posX = (this.width - 256) / 2;
	int posY = (this.height - 256) / 2;
	
	private String[] recipeList_1 = new String[]{
			"Tanned_PigHide",
			"Pighide_Helmet",
			"Pighide_Chestplate",
			"Pighide_Leggings",
			"Pighide_Boots",
			"Batwing_Boots",
			"Carving_Knife",
			"Carving_Power",
			"Batwing_Soup",
			"Supporter_Item",
			"XP_Bottle",
			"Leather",
			"Cooked_Kidneys",
			"Cooked_Heart",
			"Cooked_Brain",
			};
	private String[] recipeList_2 = new String[]{
			"Cooked_Lungs",
			"Cooked_Stomach",
			"Guide_Book",
			"Compressed_Diamond",
			"Cooked_Lamb"
	};
	
	public GuiGuideBook(){
		super();
	}
	
	private String[] page_0_Desc = new String[]{
			"This book will teach you everything you need to know about the mod!", 
			"Just pay attention and everything will work out for you!",
			"In this book we cover many different things including the following:",
			"Recipes, Item Mechanisms, Drop Chances, and much more!",
			"If you have any other questions you can always contact me on my pmc page!"
			};
	private String[] page_1_Desc = new String[]{
			"First things first. You need to learn about what the mod is!",
			"Realistic Deaths is a mod made to enable you to get more loot from mobs.",
			"This mod is non-intrusive and should be compatible with every other mod!",
			"In the next page I will tell you all about how to get started."
	};
	private String[] page_2_Desc = new String[]{
			"In order to take advantage of this mod you will need to get some heads.",
			"To do this just kill mobs until one drops. You will not be able to pick these up.",
			"Now that you have a head you need to craft a Carving Knife.",
			"You can create it with the recipe below:"
	};
	private String[] page_3_Desc = new String[]{
			"With this tool you will be able to cut up the heads that the mobs drop.",
			"To do this just hold the Carving Knife and right click while looking",
			"at a mob head. Don't worry, if your inventory is full it will drop",
			"the items onto the ground."
	};
	private String[] page_4_Desc = new String[]{
			EnumChatFormatting.BLUE + "" + EnumChatFormatting.UNDERLINE + "Batwing Boots",
			"These boots will prevent all of your fall damage!",
			"The only downside to these is that it damages the boots.",
			"If you take fall damage and the boots break then you will take",
			"the remainder of the damage.",
			EnumChatFormatting.BLUE + "" + EnumChatFormatting.UNDERLINE + "Soul Bottle",
			"In order to fill a Soul Bottle you must have at least",
			"25 levels of experience. If you have those then you need",
			"to go around killing mobs until it fills up. This item will",
			"prevent your death and heal you to max health but upon use",
			"it will be destroyed.",
			EnumChatFormatting.BLUE + "" + EnumChatFormatting.UNDERLINE + "Bottle of Blood",
			"To obtain this item you need to get a bottle in your inventory.",
			"Once you have that kill other players until it drops",
			"their head. Once you have this, cut it up with the Carving Knife.",
			"This will fill up the bottle with blood but know that you",
			"will not get player drops from doing this.",
			"With the full bottle you can craft it with a Carving Knife",
			"to get a Carving Knife with Carving Power 1."
	};
	private String[] page_5_Desc = new String[]{
			EnumChatFormatting.BLUE + "" + EnumChatFormatting.UNDERLINE + "Supporter Item",
			"The supporter item will only be given to those who have",
			"proven themselves as supporters of the mod. If you have not",
			"then you will not be able to even have the item in your inventory.",
			"If you have then you will be able to use it. To use this item right click.",
			"When you do this it will heal you for 10 health, give you 5 food, and give",
			"you 5 levels of absorb. The item will then be damaged. While it is damaged",
			"then every 5 seconds it will get another charge. Once it has 10 charges",
			"you will be able to use the item again."
	};
	private String[] page_6_Desc = new String[]{
			EnumChatFormatting.UNDERLINE + "The drop rates go as follows:",
			"Mob Drops - " + EnumChatFormatting.DARK_PURPLE + "25%",
			"Soul Bottle - " + EnumChatFormatting.DARK_PURPLE + "10%",
			"Head Drops - " + EnumChatFormatting.DARK_PURPLE + "10%",
			"Skeleton Special - " + EnumChatFormatting.DARK_PURPLE + "5%",
			"Villager Special - " + EnumChatFormatting.DARK_PURPLE + "10%",
			"Player Special - " + EnumChatFormatting.DARK_PURPLE + "1%"
	};
    
    public void initGui(){
    }
    
    protected void actionPerformed(GuiButton guiButton) {
    }
    
	@Override
	public void drawScreen(int x, int y, float f){
		this.drawDefaultBackground();
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		
		posX = (this.width - 256) / 2;
		posY = (this.height - 256) / 2;
		
		keyTick ++;
		if(keyTick > 10){
			if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
				if(Special == ""){
					if(page < maxPages){
						page += 1;
						keyTick = 0;
					}
					if(page > maxPages){
						page = pageSave;
					}
				}else if(Special == "Recipe"){
					if(page < maxPageRecipe){
						page += 1;
						keyTick = 0;
					}
					if(page > maxPageRecipe){
						page = pageSave;
					}
				}
			}else if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
				if(Special == ""){
					if(page > 0){
						page -= 1;
						keyTick = 0;
					}
					if(page > maxPages){
						page = pageSave;
					}
				}else if(Special == "Recipe"){
					if(page > 0){
						page -= 1;
						keyTick = 0;
					}
					if(page > maxPageRecipe){
						page = pageSave;
					}
				}
			}else if(Keyboard.isKeyDown(Keyboard.KEY_R)){
				if(Special == "Recipe"){
					Special = "";
					page = pageSave;
				}else{
					pageSave = page;
					Special="Recipe";
					page = 0;
				}
				keyTick = 0;
			}
		}
		
		if(Special == ""){
			switch(page){
			default:
				break;
			case 0:
				Title = "Welcome!";
				GL11.glPushMatrix();
				drawDefaultBackground();
				GL11.glScalef(.6f, .4f, .6f);
				GL11.glColor4f(1, 1, 1, 1);
				this.mc.renderEngine.bindTexture(new ResourceLocation("rd:textures/logos/Logo.png"));
				drawTexturedModalRect(posX - 25, 75, 0, 256, 256, 256);
				GL11.glPopMatrix();
				for(int i=0;i<page_0_Desc.length;i++){
					int temp = i * 10;
					this.drawString(this.mc.fontRenderer, EnumChatFormatting.AQUA + page_0_Desc[i], posX - 50, 155 + temp, 200);
				}
				break;
			case 1:
				Title = "Introduction";
				for(int i=0;i<page_1_Desc.length;i++){
					int temp = i * 10;
					this.drawString(this.mc.fontRenderer, EnumChatFormatting.AQUA + page_1_Desc[i], posX - 50, 30 + temp, 200);
				}
				break;
			case 2:
				GL11.glPushMatrix();
				drawDefaultBackground();
				GL11.glScalef(.6f, .35f, .6f);
				GL11.glColor4f(1, 1, 1, 1);
				this.mc.renderEngine.bindTexture(new ResourceLocation("rd:textures/Recipes/Carving_Knife.png"));
				drawTexturedModalRect(posX, posY + 250, 0, 256, 256, 256);
				GL11.glPopMatrix();
				Title = "Getting Started";
				for(int i=0;i<page_2_Desc.length;i++){
					int temp = i * 10;
					this.drawString(this.mc.fontRenderer, EnumChatFormatting.AQUA + page_2_Desc[i], posX - 50, 45 + temp, 200);
				}
				break;
			case 3:
				Title = "Getting Started";
				for(int i=0;i<page_3_Desc.length;i++){
					int temp = i * 10;
					this.drawString(this.mc.fontRenderer, EnumChatFormatting.AQUA + page_3_Desc[i], posX - 50, 30 + temp, 200);
				}
				break;
			case 4:
				Title = "Specialty Items";
				for(int i=0;i<page_4_Desc.length;i++){
					int temp = i * 10;
					this.drawString(this.mc.fontRenderer, EnumChatFormatting.AQUA + page_4_Desc[i], posX - 50, 30 + temp, 200);
				}
				break;
			case 5:
				Title = "Specialty Items";
				for(int i=0;i<page_5_Desc.length;i++){
					int temp = i * 10;
					this.drawString(this.mc.fontRenderer, EnumChatFormatting.AQUA + page_5_Desc[i], posX - 50, 30 + temp, 200);
				}
				break;
			case 6:
				Title = "Drop Rates";
				for(int i=0;i<page_6_Desc.length;i++){
					int temp = i * 10;
					this.drawString(this.mc.fontRenderer, EnumChatFormatting.AQUA + page_6_Desc[i], posX - 50, 30 + temp, 200);
				}
				break;
			}
		}else if(Special == "Recipe"){
			Title = "Recipe's";
			int recipeY = posY,recipeX = posX - 150,par2=0;
			GL11.glPushMatrix();
			drawDefaultBackground();
			GL11.glScalef(.25f, .15f, .25f);
			GL11.glColor4f(1, 1, 1, 1);
			switch(page){
				default:
					break;
				case 0:
					for(int i=0;i<this.recipeList_1.length;i++){
						int par1 = par2 * 300;
						if(par2 == 5){
							par2 = 0;
							recipeX = posX - 450;
							recipeY += 300;
						}
						par2 ++;
						this.mc.renderEngine.bindTexture(new ResourceLocation("rd:textures/Recipes/" + this.recipeList_1[i] + ".png"));
						drawTexturedModalRect(recipeX + par1 + 150, recipeY + 350, 0, 256, 256, 256);
					}
					break;
				case 1:
					for(int i=0;i<this.recipeList_2.length;i++){
						int par1 = par2 * 300;
						if(par2 == 5){
							par2 = 0;
							recipeX = posX - 450;
							recipeY += 300;
						}
						par2 ++;
						this.mc.renderEngine.bindTexture(new ResourceLocation("rd:textures/Recipes/" + this.recipeList_2[i] + ".png"));
						drawTexturedModalRect(recipeX + par1 + 150, recipeY + 350, 0, 256, 256, 256);
					}
					break;
			}
			GL11.glPopMatrix();
		}
		
		displayMax = maxPages + 1;
		displayPage = page + 1;
		this.drawString(this.mc.fontRenderer, EnumChatFormatting.BOLD + "" + EnumChatFormatting.UNDERLINE + "Realistic Deaths Guide Book - " + Title, posX - 50, 10, -250);
		this.drawString(this.mc.fontRenderer, EnumChatFormatting.GOLD + "<--   -->", posX + 275, posY + 225, 200);
		if(Special == ""){
			this.drawString(this.mc.fontRenderer, EnumChatFormatting.GOLD + "R - Recipes", posX - 50, posY + 235, 200);
			this.drawString(this.mc.fontRenderer, EnumChatFormatting.GOLD + "Page: " + displayPage + "/" + displayMax, posX + 275, posY + 235, 200);
		}else if(Special == "Recipe"){
			this.drawString(this.mc.fontRenderer, EnumChatFormatting.GOLD + "R - Home", posX - 50, posY + 235, 200);
			this.drawString(this.mc.fontRenderer, EnumChatFormatting.GOLD + "Page: " + displayPage + "/" + displayMaxRecipe, posX + 275, posY + 235, 200);
		}
	}
}
