package com.bukkitfiller.CobbleCraft;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageByProjectileEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityListener;

public class CobbleCraftEntityListener extends EntityListener {
	
	private CobbleCraft plugin;
	
	public CobbleCraftEntityListener(CobbleCraft instance){
		plugin = instance;
	}
	
	@Override
	public void onEntityDamage(EntityDamageEvent event) {
		
		if (event instanceof EntityDamageByEntityEvent){
			EntityDamageByEntityEvent e = (EntityDamageByEntityEvent) event;
			
			if(event.getEntity() instanceof Pig && e.getDamager() instanceof Player){
				Player player = (Player)e.getDamager();
				if(player.getItemInHand().getType() == Material.STICK){
					String fileName = plugin.FILEDIRECTORY + player.getName() + ".stats";
					plugin.fileHandler.editNumProperty(fileName, "PIGS_PRODDED", 1.00);
					if(plugin.fileHandler.getNumProperty(fileName, player, "PIGS_PRODDED") == 5){
						plugin.broadcastAchievement(player, "PIG PRODDER");
						plugin.fileHandler.getAchievements(fileName, player);
					}
				}
			}
			if (e.getDamager() instanceof Player && event.getEntity() instanceof Monster) {
				Monster monster = (Monster)event.getEntity();
				if (monster.getHealth() <= event.getDamage()) {
					runKill((Player)e.getDamager(),monster,false);
				}
			}
		}
		if (event instanceof EntityDamageByProjectileEvent) {
			EntityDamageByProjectileEvent e = (EntityDamageByProjectileEvent) event;
			if (e.getDamager() instanceof Player && event.getEntity() instanceof Monster) {
				Monster monster = (Monster)event.getEntity();
				if (monster.getHealth() <= event.getDamage()) {
					runKill((Player)e.getDamager(),monster,true);
				}
			}
		}
		
	}

	private void runKill(Player player, Monster monster,boolean archery) {
		if (monster instanceof Skeleton || 
			monster instanceof Spider || 
			monster instanceof Creeper || 
			monster instanceof Ghast || 
			monster instanceof Slime || 
			monster instanceof PigZombie || 
			monster instanceof Giant || 
			monster instanceof Zombie) {
			String fileName = plugin.FILEDIRECTORY + player.getName() + ".stats";
			plugin.fileHandler.editNumProperty(fileName, "SLAYING", 0.6);
			if (archery) {
				plugin.fileHandler.editNumProperty(fileName, "ARCHERY", 0.34);
			}
		}
		if (monster instanceof Sheep ||
			monster instanceof Cow ||
			monster instanceof Pig ||
			monster instanceof Chicken ||
			monster instanceof Squid) {
			String fileName = plugin.FILEDIRECTORY + player.getName() + ".stats";
			if (archery) {
				plugin.fileHandler.editNumProperty(fileName, "ARCHERY", 0.23);
			} else {
				plugin.fileHandler.editNumProperty(fileName, "HUNTING", 0.6);
			}
		}
	}
}
