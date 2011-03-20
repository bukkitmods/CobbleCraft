package com.bukkitfiller.CobbleCraft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

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
				writeProperty(fileName, "MINING", 0.00);
				writeProperty(fileName, "FISHING", 0.00);
				writeProperty(fileName, "SLAYING", 0.00);
				writeProperty(fileName, "ARCHERY", 0.00);
				writeProperty(fileName, "DIGGING", 0.00);
				writeProperty(fileName, "FARMING", 0.00);
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
	
	public void writeProperty(String fileName, String keys, double d){
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
	
	public void editProperty(String fileName, String keys, double d){
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

	public double getProperty(String fileName, String keys){
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
	
	public double getExpToGo(Double currentValue, int nextLevel){
		if (nextLevel == 1) { return 8 - currentValue; }
		if (nextLevel == 2) { return 15 - currentValue; }
		if (nextLevel == 3) { return 40 - currentValue; }
		if (nextLevel == 4) { return 70 - currentValue; }
		if (nextLevel == 5) { return 100 - currentValue; }
		if (nextLevel == 6) { return 130 - currentValue; }
		if (nextLevel == 7) { return 165 - currentValue; }
		if (nextLevel == 8) { return 200 - currentValue; }
		if (nextLevel == 9) { return 240 - currentValue; }
		if (nextLevel == 10) { return 285 - currentValue; }
		if (nextLevel == 11) { return 335 - currentValue; }
		return 0.00;
	}
	
	public double r2d(double d) {
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
    	return Double.valueOf(twoDForm.format(d));
	}

	
}
