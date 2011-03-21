package com.bukkitfiller.CobbleCraft;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AchievementHandler {
	
	 @SuppressWarnings("unused")
	private static String[] achievementList = {
			"PIG PRODDER",
			"IT'S HALLOWEEN?"
	 };
	
	public static void showAchievements(Player player, String[] completed){
		for(int i=0 ; i<completed.length; i++){
				player.sendMessage(ChatColor.GREEN + completed[i]);
		}
		if(completed.length == 0){
			player.sendMessage("You have no achievements");
		}
	}
	
}
