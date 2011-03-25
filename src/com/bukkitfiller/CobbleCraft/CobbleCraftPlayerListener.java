package com.bukkitfiller.CobbleCraft;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class CobbleCraftPlayerListener extends PlayerListener {
	private CobbleCraft plugin;	
	
	CobbleCraftPlayerListener(CobbleCraft plugin) {
		this.plugin = plugin;
	}
	
	private void checkForPumpkin(Player player) {
		String fileName = plugin.FILEDIRECTORY + player.getName() + ".stats";
		if (player.getInventory().getHelmet().getType() == Material.PUMPKIN) {
			if (!plugin.fileHandler.getBoolProperty(fileName, player, "WORN_PUMPKIN")) {
				plugin.broadcastAchievement(player, "IT'S HALLOWEEN?");
				plugin.fileHandler.editBoolProperty(fileName, "WORN_PUMPKIN", true);
				plugin.fileHandler.getAchievements(fileName, player);
			}
		}
	}
	
	@Override
	public void onPlayerJoin(PlayerEvent event) {
		Player player = event.getPlayer();
		String fileName = plugin.FILEDIRECTORY + player.getName() + ".stats";
		player.setDisplayName(plugin.fileHandler.getStringProperty(fileName, player, "PLAYER_TAG"));
		plugin.fileHandler.writePlayerFile(fileName, player);
	}

	@Override
	public void onPlayerPickupItem(PlayerPickupItemEvent event) {
		Player player = event.getPlayer();
		Material itemInHand = player.getItemInHand().getType();
		Material item = event.getItem().getItemStack().getType();
		String fileName = plugin.FILEDIRECTORY + event.getPlayer().getName() + ".stats";
		double fishingMod = plugin.fileHandler.getLevel(fileName, "FISHING")/15;
		
		if (item.equals(Material.RAW_FISH) && itemInHand.equals(Material.FISHING_ROD)){
			plugin.fileHandler.editNumProperty(fileName, "FISHING", 1 + fishingMod );
			plugin.lvlValues.CheckLevelUp(fileName, player, plugin.lvlValues.FishingLevels, "Fishing");
		}
		if(item.equals(Material.DIAMOND)){
			plugin.fileHandler.editNumProperty(fileName, "DIAMOND_COLLECTED", 1);
			if(plugin.fileHandler.getNumProperty(fileName, player,  "DIAMOND_COLLECTED") == 3){
				plugin.broadcastAchievement(player, "BLING, BLING!");
				plugin.fileHandler.getAchievements(fileName, player);
			}
		}
	}
	
	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		checkForPumpkin(event.getPlayer());
	}

}
