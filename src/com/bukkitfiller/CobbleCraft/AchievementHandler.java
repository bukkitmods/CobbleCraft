package com.bukkitfiller.CobbleCraft;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AchievementHandler {
	AchievementHandler() {}
	
	@SuppressWarnings("unused")
	private static String[] achievementList = {
			"PIG PRODDER",
			"IT'S HALLOWEEN?",
			"BLING, BLING!",
			"GOLD DIGGA"
	};
	
	public void showAchievements(Player player, ArrayList<String> completed){
		if (completed.size() == 0) {
			player.sendMessage(ChatColor.RED + "You have no achievements");
		} else {
			player.sendMessage(ChatColor.GOLD + "Your achievements: ");
			for (String achievement : completed) {
				player.sendMessage(ChatColor.GREEN + achievement);
			}
		}
	}
	
}
