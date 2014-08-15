package mods.Cyphereion.RealisticDeaths;

public class ModConsole {
	
	public static void print(String s){
		System.out.println("[" + RealisticDeaths.MODID + "] " + s);
	}
	
	public static void error(String s){
		print("[ERROR!] " + s);
	}

}
