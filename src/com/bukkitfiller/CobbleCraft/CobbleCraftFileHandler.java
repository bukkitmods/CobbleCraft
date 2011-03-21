package com.bukkitfiller.CobbleCraft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import org.bukkit.entity.Player;

public class CobbleCraftFileHandler {
	private CobbleCraft plugin;	
	
	CobbleCraftFileHandler(CobbleCraft plugin) {
		this.plugin = plugin;
	}
	
	public void writePlayerFile(String fileName){
		File file = new File(fileName);
		if (!file.exists()){
			try {
				file.createNewFile();
				writeNumProperty(fileName, "MINING", 0.00);
				writeNumProperty(fileName, "FISHING", 0.00);
				writeNumProperty(fileName, "SLAYING", 0.00);
				writeNumProperty(fileName, "ARCHERY", 0.00);
				writeNumProperty(fileName, "DIGGING", 0.00);
				writeNumProperty(fileName, "FARMING", 0.00);
				writeNumProperty(fileName, "PIGS_PRODDED", 0);
				writeBoolProperty(fileName, "WORN_PUMPKIN", false);
			} catch(IOException ex) {
				plugin.consoleWarning(ex.toString());
			}
		}
	}

	public static void writeDir(String fileDir){
		File file = new File(fileDir);
		if (!file.exists()){
			file.mkdir();
		}
	}

	public void writeNumProperty(String fileName, String keys, double d){
		File file = new File(fileName);
		String key = keys;
		PropertyOrder props = new PropertyOrder();
		d = r2d(d);
		String value = String.valueOf(d);
		
		if (!file.exists()) { writePlayerFile(fileName); }
		
		
		try {
			props.load(new FileInputStream(file));} catch (FileNotFoundException e) {} catch (IOException e) {
		}
		
		props.put(key, value);
		
		try {
			props.store(new FileOutputStream(file), null);
		} catch (FileNotFoundException e) {
			plugin.consoleWarning(e.toString());
		} catch (IOException e) {
			plugin.consoleWarning(e.toString());
		}
	}
	
	public void writeBoolProperty(String fileName, String keys, boolean b){
		File file = new File(fileName);
		String key = keys;
		PropertyOrder props = new PropertyOrder();
		String value = String.valueOf(b);
		
		if (!file.exists()) { writePlayerFile(fileName); }
		
		try {
			props.load(new FileInputStream(file));} catch (FileNotFoundException e) {} catch (IOException e) {
		}
		
		props.put(key, value);
		
		try {
			props.store(new FileOutputStream(file), null);
		} catch (FileNotFoundException e) {
			plugin.consoleWarning(e.toString());
		} catch (IOException e) {
			plugin.consoleWarning(e.toString());
		}
	}
	
	public void editNumProperty(String fileName, String keys, double d){
		File file = new File(fileName);
		PropertyOrder props = new PropertyOrder();
		String key = keys;
		d = r2d(d);
		
		try {
			props.load(new FileInputStream(file));
			Double currentValue = r2d(Double.parseDouble(props.getProperty(keys)));
			Double totalValue = r2d(currentValue + d);
			String value = String.valueOf(totalValue);
			props.setProperty(key, value);
			props.store(new FileOutputStream(file), null);
		} catch (FileNotFoundException e) {
			plugin.consoleWarning(e.toString());
		} catch (IOException e) {
			plugin.consoleWarning(e.toString());
		}
	}

	public void editBoolProperty(String fileName, String keys, boolean b){
		File file = new File(fileName);
		PropertyOrder props = new PropertyOrder();
		String key = keys;
		
		try {
			props.load(new FileInputStream(file));
			String value = String.valueOf(b);
			props.setProperty(key, value);
			props.store(new FileOutputStream(file), null);
		} catch (FileNotFoundException e) {
			plugin.consoleWarning(e.toString());
		} catch (IOException e) {
			plugin.consoleWarning(e.toString());
		}
	}
	
	public double getNumProperty(String fileName, String keys){
		PropertyOrder props = new PropertyOrder();
		File file = new File(fileName);
		if (!file.exists()){ writePlayerFile(fileName); }
		
		try {
			props.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			plugin.consoleWarning(e.toString());
		} catch (IOException e) {
			plugin.consoleWarning(e.toString());
		}
		Double value = r2d(Double.parseDouble(props.getProperty(keys)));
		return value;
	}

	public boolean getBoolProperty(String fileName, String keys){
		PropertyOrder props = new PropertyOrder();
		File file = new File(fileName);
		if (!file.exists()){ writePlayerFile(fileName); }
		
		try {
			props.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			plugin.consoleWarning(e.toString());
		} catch (IOException e) {
			plugin.consoleWarning(e.toString());
		}
		Boolean value = Boolean.getBoolean(props.getProperty(keys));
		return value;
	}
	
	public int getLevel(String fileName, String keys){
		File file = new File(fileName);
		PropertyOrder props = new PropertyOrder();
		try {
			props.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			plugin.consoleWarning(e.toString());
		} catch (IOException e) {
			plugin.consoleWarning(e.toString());
		}
		int statProgress = (int)Math.floor(Double.parseDouble(props.getProperty(keys)));
		int statLevel = 0;
		
		if (keys.equalsIgnoreCase("DIGGING")){
			if (statProgress <= plugin.lvlValues.DiggingLevels[0]) { statLevel = 0; }
			if (statProgress <= plugin.lvlValues.DiggingLevels[1] && statProgress > plugin.lvlValues.DiggingLevels[0]) { statLevel = 1; }
			if (statProgress <= plugin.lvlValues.DiggingLevels[2] && statProgress > plugin.lvlValues.DiggingLevels[1]) { statLevel = 2; }
			if (statProgress <= plugin.lvlValues.DiggingLevels[3] && statProgress > plugin.lvlValues.DiggingLevels[2]) { statLevel = 3; }
			if (statProgress <= plugin.lvlValues.DiggingLevels[4] && statProgress > plugin.lvlValues.DiggingLevels[3]) { statLevel = 4; }
			if (statProgress <= plugin.lvlValues.DiggingLevels[5] && statProgress > plugin.lvlValues.DiggingLevels[4]) { statLevel = 5; }
			if (statProgress <= plugin.lvlValues.DiggingLevels[6] && statProgress > plugin.lvlValues.DiggingLevels[5]) { statLevel = 6; }
			if (statProgress <= plugin.lvlValues.DiggingLevels[7] && statProgress > plugin.lvlValues.DiggingLevels[6]) { statLevel = 7; }
			if (statProgress <= plugin.lvlValues.DiggingLevels[8] && statProgress > plugin.lvlValues.DiggingLevels[7]) { statLevel = 8; }
			if (statProgress <= plugin.lvlValues.DiggingLevels[9] && statProgress > plugin.lvlValues.DiggingLevels[8]) { statLevel = 9; }
			if (statProgress <= plugin.lvlValues.DiggingLevels[10] && statProgress > plugin.lvlValues.DiggingLevels[9]) { statLevel = 10; }
			if (statProgress <= plugin.lvlValues.DiggingLevels[11] && statProgress > plugin.lvlValues.DiggingLevels[10]) { statLevel = 11; }
			if (statProgress >= plugin.lvlValues.DiggingLevels[12]) { statLevel = 12; }
		}
		
		if (keys.equalsIgnoreCase("MINING")){
			if (statProgress <= plugin.lvlValues.MiningLevels[0]) { statLevel = 0; }
			if (statProgress <= plugin.lvlValues.MiningLevels[1] && statProgress > plugin.lvlValues.MiningLevels[0]) { statLevel = 1; }
			if (statProgress <= plugin.lvlValues.MiningLevels[2] && statProgress > plugin.lvlValues.MiningLevels[1]) { statLevel = 2; }
			if (statProgress <= plugin.lvlValues.MiningLevels[3] && statProgress > plugin.lvlValues.MiningLevels[2]) { statLevel = 3; }
			if (statProgress <= plugin.lvlValues.MiningLevels[4] && statProgress > plugin.lvlValues.MiningLevels[3]) { statLevel = 4; }
			if (statProgress <= plugin.lvlValues.MiningLevels[5] && statProgress > plugin.lvlValues.MiningLevels[4]) { statLevel = 5; }
			if (statProgress <= plugin.lvlValues.MiningLevels[6] && statProgress > plugin.lvlValues.MiningLevels[5]) { statLevel = 6; }
			if (statProgress <= plugin.lvlValues.MiningLevels[7] && statProgress > plugin.lvlValues.MiningLevels[6]) { statLevel = 7; }
			if (statProgress <= plugin.lvlValues.MiningLevels[8] && statProgress > plugin.lvlValues.MiningLevels[7]) { statLevel = 8; }
			if (statProgress <= plugin.lvlValues.MiningLevels[9] && statProgress > plugin.lvlValues.MiningLevels[8]) { statLevel = 9; }
			if (statProgress <= plugin.lvlValues.MiningLevels[10] && statProgress > plugin.lvlValues.MiningLevels[9]) { statLevel = 10; }
			if (statProgress <= plugin.lvlValues.MiningLevels[11] && statProgress > plugin.lvlValues.MiningLevels[10]) { statLevel = 11; }
			if (statProgress >= plugin.lvlValues.MiningLevels[12]) { statLevel = 12; }
		}
		
		if (keys.equalsIgnoreCase("FISHING")){
			if (statProgress <= plugin.lvlValues.FishingLevels[0]) { statLevel = 0; }
			if (statProgress <= plugin.lvlValues.FishingLevels[1] && statProgress > plugin.lvlValues.FishingLevels[0]) { statLevel = 1; }
			if (statProgress <= plugin.lvlValues.FishingLevels[2] && statProgress > plugin.lvlValues.FishingLevels[1]) { statLevel = 2; }
			if (statProgress <= plugin.lvlValues.FishingLevels[3] && statProgress > plugin.lvlValues.FishingLevels[2]) { statLevel = 3; }
			if (statProgress <= plugin.lvlValues.FishingLevels[4] && statProgress > plugin.lvlValues.FishingLevels[3]) { statLevel = 4; }
			if (statProgress <= plugin.lvlValues.FishingLevels[5] && statProgress > plugin.lvlValues.FishingLevels[4]) { statLevel = 5; }
			if (statProgress <= plugin.lvlValues.FishingLevels[6] && statProgress > plugin.lvlValues.FishingLevels[5]) { statLevel = 6; }
			if (statProgress <= plugin.lvlValues.FishingLevels[7] && statProgress > plugin.lvlValues.FishingLevels[6]) { statLevel = 7; }
			if (statProgress <= plugin.lvlValues.FishingLevels[8] && statProgress > plugin.lvlValues.FishingLevels[7]) { statLevel = 8; }
			if (statProgress <= plugin.lvlValues.FishingLevels[9] && statProgress > plugin.lvlValues.FishingLevels[8]) { statLevel = 9; }
			if (statProgress <= plugin.lvlValues.FishingLevels[10] && statProgress > plugin.lvlValues.FishingLevels[9]) { statLevel = 10; }
			if (statProgress <= plugin.lvlValues.FishingLevels[11] && statProgress > plugin.lvlValues.FishingLevels[10]) { statLevel = 11; }
			if (statProgress >= plugin.lvlValues.FishingLevels[12]) { statLevel = 12; }
		}
		
		return statLevel;
		
	}
	
	public void getAchievements(String fileName, Player player){
		String[] completed = new String [10];
		
		if(getNumProperty(fileName, "PIGS_PRODDED") >= 5){
			completed[0] = "PIG PRODDER";
		}
		if(getBoolProperty(fileName, "WORN_PUMPKIN") == true){
			completed[1] = "IT'S HALLOWEEN?";
		}
		
		AchievementHandler.showAchievements(player, completed);
	}
	
	public double getExpToGo(Double currentValue, int[] lvlArray, int nextLevel){
		currentValue = r2d(currentValue);
		if (nextLevel == 1) { return lvlArray[1] - currentValue; }
		if (nextLevel == 2) { return lvlArray[2] - currentValue; }
		if (nextLevel == 3) { return lvlArray[3] - currentValue; }
		if (nextLevel == 4) { return lvlArray[4] - currentValue; }
		if (nextLevel == 5) { return lvlArray[5] - currentValue; }
		if (nextLevel == 6) { return lvlArray[6] - currentValue; }
		if (nextLevel == 7) { return lvlArray[7] - currentValue; }
		if (nextLevel == 8) { return lvlArray[8] - currentValue; }
		if (nextLevel == 9) { return lvlArray[9] - currentValue; }
		if (nextLevel == 10) { return lvlArray[10] - currentValue; }
		if (nextLevel == 11) { return lvlArray[11] - currentValue; }
		return 0.00;
	}
	
	public double r2d(double d) {
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
    	return Double.valueOf(twoDForm.format(d));
	}

	
}
