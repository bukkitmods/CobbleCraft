package com.bukkitfiller.CobbleCraft;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CobbleCraft extends JavaPlugin {
	
	public static final String FILEDIRECTORY = "plugins/CobbleCraft/";
	public final CobbleCraftBlockListener blockListener = new CobbleCraftBlockListener();
	public final CobbleCraftPlayerListener playerListener = new CobbleCraftPlayerListener();

	@Override
	public void onDisable() {
	}

	@Override
	public void onEnable() {
		PluginDescriptionFile desc = getDescription();
		PluginManager pm = getServer().getPluginManager();
		CobbleCraftFileHandler.writeDir(FILEDIRECTORY);
		
		pm.registerEvent(Event.Type.BLOCK_BREAK, this.blockListener,
				Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, this.playerListener,
				Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, this.playerListener,
				Priority.Normal, this);
		
		System.out.println(desc.getName() + " - " + desc.getVersion() 
				+ " was enabled.");
	}

	
}
