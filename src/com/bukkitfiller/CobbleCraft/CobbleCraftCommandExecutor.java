package com.bukkitfiller.CobbleCraft;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CobbleCraftCommandExecutor implements CommandExecutor {
	private CobbleCraft plugin;	
	
	CobbleCraftCommandExecutor(CobbleCraft plugin) {
		this.plugin = plugin;
	}
	
	private void showStats(Player player,String type) {
	    String fileName = CobbleCraft.FILEDIRECTORY + player.getName() + ".stats";
		
		int playerLevel = plugin.fileHandler.getLevel(fileName, type.toUpperCase());
		double playerExp = plugin.fileHandler.getProperty(fileName, type.toUpperCase());
		player.sendMessage("Current '" + type + "' level: " + ChatColor.GOLD + playerLevel);
		player.sendMessage("Exp left to next level: " + ChatColor.GOLD + plugin.fileHandler.getExpToGo(playerExp, playerLevel + 1));
	}

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	Player player = (Player)sender;
    	if (label.equalsIgnoreCase("mining")) {
    		showStats(player,"Mining");
		} else if (label.equalsIgnoreCase("digging")) {
    		showStats(player,"Digging");
		} else if (label.equalsIgnoreCase("fishing")) {
    		showStats(player,"Fishing");
		}
		return false;
    }
}
