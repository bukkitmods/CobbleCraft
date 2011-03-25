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
	
	private void showStats(Player player, int[] levelArray, String type) {
	    String fileName = plugin.FILEDIRECTORY + player.getName() + ".stats";
		
		int playerLevel = plugin.fileHandler.getLevel(fileName, type.toUpperCase());
		double playerExp = plugin.fileHandler.getNumProperty(fileName, player, type.toUpperCase());
		player.sendMessage("Current '" + type + "' level: " + ChatColor.GOLD + playerLevel);
		player.sendMessage("Exp left to next level: " + ChatColor.GOLD + plugin.fileHandler.getExpToGo(playerExp, levelArray, playerLevel + 1));
	}

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	Player player = (Player)sender;
    	String fileName = plugin.FILEDIRECTORY + player.getName() + ".stats";
    	if(label.equalsIgnoreCase("stats")){
    		showStatHelp(player);
    	}
    	else if (label.equalsIgnoreCase("mining")) {
    		showStats(player,plugin.lvlValues.MiningLevels,"Mining");
    		player.sendMessage("Can be gained by using a Pickaxe");
    		return true;
		} else if (label.equalsIgnoreCase("digging")) {
    		showStats(player,plugin.lvlValues.DiggingLevels,"Digging");
    		player.sendMessage("Can be gained by using a Shovel");
    		return true;
		} else if (label.equalsIgnoreCase("fishing")) {
    		showStats(player,plugin.lvlValues.FishingLevels,"Fishing");
    		player.sendMessage("Can be gained by using a Fishing Rod");
    		return true;
		} else if (label.equalsIgnoreCase("slaying")) {
    		showStats(player,plugin.lvlValues.SlayingLevels,"Slaying");
    		player.sendMessage("Can be gained by killing mobs");
    		return true;
		} else if (label.equalsIgnoreCase("hunting")) {
    		showStats(player,plugin.lvlValues.HuntingLevels,"Hunting");
    		player.sendMessage("Can be gained by killing animals");
    		return true;
		} else if (label.equalsIgnoreCase("archery")) {
    		showStats(player,plugin.lvlValues.ArcheryLevels,"Archery");
    		player.sendMessage("Can be gained by using a Bow and Arrow");
    		return true;
		} else if (label.equalsIgnoreCase("achievements")) {
    		plugin.fileHandler.getAchievements(fileName, player);
    		return true;
		} else if (label.equalsIgnoreCase("setrole") && args.length >= 1){
			player.setDisplayName("");
			String playerSequence = args[0].toLowerCase();
			String firstLetter = playerSequence.substring(0, 1);
			if(playerSequence.equalsIgnoreCase("reset")){
				player.setDisplayName("");
				plugin.fileHandler.editStringProperty(fileName, "PLAYER_TAG", player.getDisplayName());
		    } else{
			String playerName = playerSequence.replaceFirst(firstLetter, firstLetter.toUpperCase());
			player.setDisplayName(ChatColor.BLUE + "[" + ChatColor.YELLOW + playerName
				+ ChatColor.BLUE + "] " + ChatColor.WHITE + player.getDisplayName());
			plugin.fileHandler.editStringProperty(fileName, "PLAYER_TAG", player.getDisplayName());
			}
		}
		return false;
    }
    
    private void showStatHelp(Player player){
    	player.sendMessage(ChatColor.RED + "/Achievements" + ChatColor.GREEN + " - Shows your current Achievement progress");
    	player.sendMessage(ChatColor.RED + "/SetRole [ROLE]" + ChatColor.GREEN + " - Sets a role for your player.");
    	player.sendMessage(ChatColor.RED + "/Mining" + ChatColor.GREEN + " - Shows your current Mining progress");
    	player.sendMessage(ChatColor.RED + "/Digging" + ChatColor.GREEN + " - Shows your current Digging progress");
    	player.sendMessage(ChatColor.RED + "/Slaying" + ChatColor.GREEN + " - Shows your current Slaying progress");
    	player.sendMessage(ChatColor.RED + "/Hunting" + ChatColor.GREEN + " - Shows your current Slaying progress");
    	player.sendMessage(ChatColor.RED + "/Fishing" + ChatColor.GREEN + " - Shows your current Fishing progress");
    	player.sendMessage(ChatColor.RED + "/Archery" + ChatColor.GREEN + " - Shows your current Archery progress");
    }
}
