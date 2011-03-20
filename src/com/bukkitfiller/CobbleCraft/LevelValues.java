package com.bukkitfiller.CobbleCraft;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class LevelValues {
	
	public static int[] MiningLevels = {0,3,8,15,50,66,110,170,212,260,320,370,430,480};
	public static int[] DiggingLevels = {3,8,15,40,70,100,130,165,200,240,285,335,390};
	public static int[] FishingLevels = {3,5,12,17,25,35,60,80,112,147,179,222,270,320};
	
	public static void CheckLevelUp(String fileName, Player player, int[] levels, String type){
		int playerExp = (int)Math.round(CobbleCraftFileHandler.getProperty(fileName, type.toUpperCase()));
		int playerLevel = CobbleCraftFileHandler.getLevel(fileName, type.toUpperCase());
		
		for(int i = 0; i < levels.length; i++){
			if(playerExp == levels[i]){
				player.sendMessage(ChatColor.RED + "You have advanced a " +type+ " level!");
				player.sendMessage("Your " +type+ " level is now: " + ChatColor.GOLD + (playerLevel + 1));
			}
		}
	}

}
