package com.bukkitfiller.CobbleCraft;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class LevelValues {
	private CobbleCraft plugin;	
	
	LevelValues(CobbleCraft plugin) {
		this.plugin = plugin;
	}
	
	public final int[] MiningLevels = {3,8,15,50,66,110,170,212,260,320,370,430};
	public final int[] DiggingLevels = {3,8,15,40,70,100,130,165,200,240,285,335};
	public final int[] FishingLevels = {2,5,12,17,25,35,60,80,112,147,179,222};
	public final int[] SlayingLevels = {3,5,10,15,22,29,37,49,67,85,100,112};
	public final int[] HuntingLevels = {3,5,10,15,22,29,37,49,67,85,100,112};
	public final int[] ArcheryLevels = {2,5,15,24,32,29,54,69,87,112,132,155};
	
	public void CheckLevelUp(String fileName, Player player, int[] levels, String type){
		Double playerExp = plugin.fileHandler.getNumProperty(fileName, player, type.toUpperCase());
		int playerLevel = plugin.fileHandler.getLevel(fileName, type.toUpperCase());
		
		for (int i = 0; i < levels.length; i++){
			if (Math.floor(playerExp) == levels[i]){
				plugin.fileHandler.editNumProperty(fileName, type.toUpperCase(), 1.01);
				player.sendMessage(ChatColor.RED + "You have advanced a " +type+ " level!");
				player.sendMessage("Your " +type+ " level is now: " + ChatColor.GOLD + (playerLevel + 1));
			}
		}
	}

}
