package com.bukkitfiller.CobbleCraft;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class LevelValues {
	private CobbleCraft plugin;	
	
	LevelValues(CobbleCraft plugin) {
		this.plugin = plugin;
	}
	
	public int[] MiningLevels = {0,3,8,15,50,66,110,170,212,260,320,370,430,480};
	public int[] DiggingLevels = {3,8,15,40,70,100,130,165,200,240,285,335,390};
	public int[] FishingLevels = {3,5,12,17,25,35,60,80,112,147,179,222,270,320};
	
	public void CheckLevelUp(String fileName, Player player, int[] levels, String type){
		int playerExp = (int)Math.floor(plugin.fileHandler.getProperty(fileName, type.toUpperCase()));
		int playerLevel = plugin.fileHandler.getLevel(fileName, type.toUpperCase());
		
		for (int i = 0; i < levels.length; i++){
			if (playerExp == levels[i]){
				player.sendMessage(ChatColor.RED + "You have advanced a " +type+ " level!");
				player.sendMessage("Your " +type+ " level is now: " + ChatColor.GOLD + (playerLevel + 1));
			}
		}
	}

}
