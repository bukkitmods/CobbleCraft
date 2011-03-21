package com.bukkitfiller.CobbleCraft;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
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
			if (!plugin.fileHandler.getBoolProperty(fileName, "WORN_PUMPKIN")) {
				plugin.fileHandler.editBoolProperty(fileName, "WORN_PUMPKIN", true);
			}
		}
	}
	
	@Override
	public void onPlayerJoin(PlayerEvent event) {
		Player player = event.getPlayer();
		String fileName = plugin.FILEDIRECTORY + player.getName() + ".stats";
		plugin.fileHandler.writePlayerFile(fileName);
	}

	@Override
	public void onPlayerPickupItem(PlayerPickupItemEvent event) {
		Player player = event.getPlayer();
		Material itemInHand = player.getItemInHand().getType();
		Material item = event.getItem().getItemStack().getType();
		String fileName = plugin.FILEDIRECTORY + event.getPlayer().getName() + ".stats";
		
		if (item.equals(Material.RAW_FISH) && itemInHand.equals(Material.FISHING_ROD)){
			plugin.fileHandler.editNumProperty(fileName, "FISHING", 1);
			plugin.lvlValues.CheckLevelUp(fileName, player, plugin.lvlValues.FishingLevels, "Fishing");
		}
		checkForPumpkin(player);
	}
	
	@Override
	public void onPlayerMove(PlayerMoveEvent event) {
		checkForPumpkin(event.getPlayer());
	}

	@Override
	public void onItemHeldChange(PlayerItemHeldEvent event) {
		checkForPumpkin(event.getPlayer());
	}
	
}
