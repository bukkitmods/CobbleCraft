package com.bukkitfiller.CobbleCraft;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class CobbleCraftPlayerListener extends PlayerListener {
	
	@Override
	public void onPlayerJoin(PlayerEvent event) {
		Player player = event.getPlayer();
		String fileName = CobbleCraft.FILEDIRECTORY + player.getName() + ".stats";
		CobbleCraftFileHandler.writePlayerFile(fileName);
	}

	@Override
	public void onPlayerPickupItem(PlayerPickupItemEvent event) {
		Player player = event.getPlayer();
		Material itemInHand = player.getItemInHand().getType();
		Material item = event.getItem().getItemStack().getType();
		String fileName = CobbleCraft.FILEDIRECTORY + event.getPlayer().getName() + ".stats";
		
		if(item.equals(Material.RAW_FISH) && itemInHand.equals(Material.FISHING_ROD) ){
			LevelValues.CheckLevelUp(fileName, player, LevelValues.FishingLevels, "Fishing");
			CobbleCraftFileHandler.editProperty(fileName, "FISHING", 0.7);
		}
		
	}

}
