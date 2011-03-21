package com.bukkitfiller.CobbleCraft;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AchievementHandler {
	AchievementHandler() {}
	
	@SuppressWarnings("unused")
	private static String[] achievementList = {
			"PIG PRODDER",
			"IT'S HALLOWEEN?"
	};
	
	public void showAchievements(Player player, ArrayList<String> completed){
		if (completed.size() == 0) {
			player.sendMessage("You have no achievements");
		} else {
			for (String achievement : completed) {
				player.sendMessage(ChatColor.GREEN + achievement);
			}
		}
	}
	
}
