package com.bukkitfiller.CobbleCraft;

import org.bukkit.Material;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;

public class CobbleCraftEntityListener extends EntityListener {
	
	private CobbleCraft plugin;
	
	public CobbleCraftEntityListener(CobbleCraft instance){
		plugin = instance;
	}
	
	@Override
	public void onEntityDamage(EntityDamageEvent event) {
		
		if(event instanceof EntityDamageByEntityEvent){
			EntityDamageByEntityEvent e = (EntityDamageByEntityEvent) event;
			Player player = (Player)e.getDamager();
			String fileName = plugin.FILEDIRECTORY + player.getName() + ".stats";
			
			if(e.getEntity() instanceof Pig && player == e.getDamager() && player.getItemInHand().equals(Material.STICK)){
				plugin.fileHandler.editNumProperty(fileName, "PIGS_PRODDED", 1);
			}
			
		}
		
	}
	
	
}
