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
			Player player = (Player)e.getDamager();
			String fileName = plugin.FILEDIRECTORY + player.getName() + ".stats";
			
			if(e.getEntity() instanceof Pig && player == e.getDamager() && player.getItemInHand().equals(Material.STICK)){
				plugin.fileHandler.editNumProperty(fileName, "PIGS_PRODDED", 1);
			}
			if (((EntityDamageByEntityEvent)event).getDamager() instanceof Player && event.getEntity() instanceof Monster) {
				Monster monster = (Monster)event.getEntity();
				if (monster.getHealth() <= event.getDamage()) {
					runKill((Player)((EntityDamageByEntityEvent)event).getDamager(),monster);
				}
			}
		}
		if (event instanceof EntityDamageByProjectileEvent) {
			if (((EntityDamageByProjectileEvent)event).getDamager() instanceof Player && event.getEntity() instanceof Monster) {
				Monster monster = (Monster)event.getEntity();
				if (monster.getHealth() <= event.getDamage()) {
					runKill((Player)((EntityDamageByEntityEvent)event).getDamager(),monster);
				}
			}
		}
		
	}

	private void runKill(Player player, Monster monster) {
		if (monster instanceof Skeleton || 
			monster instanceof Spider || 
			monster instanceof Creeper || 
			monster instanceof Ghast || 
			monster instanceof Slime || 
			monster instanceof PigZombie || 
			monster instanceof Giant || 
			monster instanceof Zombie) {
			String fileName = plugin.FILEDIRECTORY + player.getName() + ".stats";
			plugin.fileHandler.editNumProperty(fileName, "SLAYING", 1);
		}
	}
	
	
}
