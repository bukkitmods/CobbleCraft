package com.bukkitfiller.CobbleCraft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class CobbleCraftFileHandler {
	
	public static void writePlayerFile(String fileName){
		File file = new File(fileName);
		if(!file.exists()){
			try{
				file.createNewFile();
				writeProperty(fileName, "MINING", 0.00);
				writeProperty(fileName, "FISHING", 0.00);
				writeProperty(fileName, "SLAYING", 0.00);
				writeProperty(fileName, "ARCHERY", 0.00);
				writeProperty(fileName, "DIGGING", 0.00);
				writeProperty(fileName, "FARMING", 0.00);
			}catch(IOException ex){}
		}
	}

	public static void writeDir(String fileDir){
		File file = new File(fileDir);
		if(!file.exists()){
			file.mkdir();
		}
	}
	
	public static void writeProperty(String fileName, String keys, double d){
		File file = new File(fileName);
		String key = keys;
		PropertyOrder props = new PropertyOrder();
		d = r2d(d);
		String value = String.valueOf(d);
		
		if(!file.exists()) { writePlayerFile(fileName); }
		
		
		try {
			props.load(new FileInputStream(file));} catch (FileNotFoundException e) {} catch (IOException e) {
		}
		
		props.put(key, value);
		
		try {
			props.store(new FileOutputStream(file), null);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
	public static void editProperty(String fileName, String keys, double d){
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
		}catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	public static Double getProperty(String fileName, String keys){
		PropertyOrder props = new PropertyOrder();
		File file = new File(fileName);
		if(!file.exists()){ writePlayerFile(fileName); }
		
		try {
			props.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		Double value = r2d(Double.parseDouble(props.getProperty(keys)));
		return value;
	}

	public static int getLevel(String fileName, String keys){
		File file = new File(fileName);
		PropertyOrder props = new PropertyOrder();
		try {
			props.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {} catch (IOException e) {}
		int statProgress = (int) Math.round(Double.parseDouble(props.getProperty(keys)));
		int statLevel = 0;
		
		if(keys.equalsIgnoreCase("DIGGING")){
			if(statProgress <= LevelValues.DiggingLevels[0]) { statLevel = 0; }
			if(statProgress <= LevelValues.DiggingLevels[1] && statProgress > LevelValues.DiggingLevels[0]) { statLevel = 1; }
			if(statProgress <= LevelValues.DiggingLevels[2] && statProgress > LevelValues.DiggingLevels[1]) { statLevel = 2; }
			if(statProgress <= LevelValues.DiggingLevels[3] && statProgress > LevelValues.DiggingLevels[2]) { statLevel = 3; }
			if(statProgress <= LevelValues.DiggingLevels[4] && statProgress > LevelValues.DiggingLevels[3]) { statLevel = 4; }
			if(statProgress <= LevelValues.DiggingLevels[5] && statProgress > LevelValues.DiggingLevels[4]) { statLevel = 5; }
			if(statProgress <= LevelValues.DiggingLevels[6] && statProgress > LevelValues.DiggingLevels[5]) { statLevel = 6; }
			if(statProgress <= LevelValues.DiggingLevels[7] && statProgress > LevelValues.DiggingLevels[6]) { statLevel = 7; }
			if(statProgress <= LevelValues.DiggingLevels[8] && statProgress > LevelValues.DiggingLevels[7]) { statLevel = 8; }
			if(statProgress <= LevelValues.DiggingLevels[9] && statProgress > LevelValues.DiggingLevels[8]) { statLevel = 9; }
			if(statProgress <= LevelValues.DiggingLevels[10] && statProgress > LevelValues.DiggingLevels[9]) { statLevel = 10; }
			if(statProgress <= LevelValues.DiggingLevels[11] && statProgress > LevelValues.DiggingLevels[10]) { statLevel = 11; }
			if(statProgress >= LevelValues.DiggingLevels[12]) { statLevel = 12; }
		}
		
		if(keys.equalsIgnoreCase("MINING")){
			if(statProgress <= LevelValues.MiningLevels[0]) { statLevel = 0; }
			if(statProgress <= LevelValues.MiningLevels[1] && statProgress > LevelValues.MiningLevels[0]) { statLevel = 1; }
			if(statProgress <= LevelValues.MiningLevels[2] && statProgress > LevelValues.MiningLevels[1]) { statLevel = 2; }
			if(statProgress <= LevelValues.MiningLevels[3] && statProgress > LevelValues.MiningLevels[2]) { statLevel = 3; }
			if(statProgress <= LevelValues.MiningLevels[4] && statProgress > LevelValues.MiningLevels[3]) { statLevel = 4; }
			if(statProgress <= LevelValues.MiningLevels[5] && statProgress > LevelValues.MiningLevels[4]) { statLevel = 5; }
			if(statProgress <= LevelValues.MiningLevels[6] && statProgress > LevelValues.MiningLevels[5]) { statLevel = 6; }
			if(statProgress <= LevelValues.MiningLevels[7] && statProgress > LevelValues.MiningLevels[6]) { statLevel = 7; }
			if(statProgress <= LevelValues.MiningLevels[8] && statProgress > LevelValues.MiningLevels[7]) { statLevel = 8; }
			if(statProgress <= LevelValues.MiningLevels[9] && statProgress > LevelValues.MiningLevels[8]) { statLevel = 9; }
			if(statProgress <= LevelValues.MiningLevels[10] && statProgress > LevelValues.MiningLevels[9]) { statLevel = 10; }
			if(statProgress <= LevelValues.MiningLevels[11] && statProgress > LevelValues.MiningLevels[10]) { statLevel = 11; }
			if(statProgress >= LevelValues.MiningLevels[12]) { statLevel = 12; }
		}
		
		if(keys.equalsIgnoreCase("FISHING")){
			if(statProgress <= LevelValues.FishingLevels[0]) { statLevel = 0; }
			if(statProgress <= LevelValues.FishingLevels[1] && statProgress > LevelValues.FishingLevels[0]) { statLevel = 1; }
			if(statProgress <= LevelValues.FishingLevels[2] && statProgress > LevelValues.FishingLevels[1]) { statLevel = 2; }
			if(statProgress <= LevelValues.FishingLevels[3] && statProgress > LevelValues.FishingLevels[2]) { statLevel = 3; }
			if(statProgress <= LevelValues.FishingLevels[4] && statProgress > LevelValues.FishingLevels[3]) { statLevel = 4; }
			if(statProgress <= LevelValues.FishingLevels[5] && statProgress > LevelValues.FishingLevels[4]) { statLevel = 5; }
			if(statProgress <= LevelValues.FishingLevels[6] && statProgress > LevelValues.FishingLevels[5]) { statLevel = 6; }
			if(statProgress <= LevelValues.FishingLevels[7] && statProgress > LevelValues.FishingLevels[6]) { statLevel = 7; }
			if(statProgress <= LevelValues.FishingLevels[8] && statProgress > LevelValues.FishingLevels[7]) { statLevel = 8; }
			if(statProgress <= LevelValues.FishingLevels[9] && statProgress > LevelValues.FishingLevels[8]) { statLevel = 9; }
			if(statProgress <= LevelValues.FishingLevels[10] && statProgress > LevelValues.FishingLevels[9]) { statLevel = 10; }
			if(statProgress <= LevelValues.FishingLevels[11] && statProgress > LevelValues.FishingLevels[10]) { statLevel = 11; }
			if(statProgress >= LevelValues.FishingLevels[12]) { statLevel = 12; }
		}
		
		return statLevel;
		
	}
	
	public static Double getExpToGo(Double currentValue, int nextLevel){
		if(nextLevel == 1) { return 8 - currentValue; }
		if(nextLevel == 2) { return 15 - currentValue; }
		if(nextLevel == 3) { return 40 - currentValue; }
		if(nextLevel == 4) { return 70 - currentValue; }
		if(nextLevel == 5) { return 100 - currentValue; }
		if(nextLevel == 6) { return 130 - currentValue; }
		if(nextLevel == 7) { return 165 - currentValue; }
		if(nextLevel == 8) { return 200 - currentValue; }
		if(nextLevel == 9) { return 240 - currentValue; }
		if(nextLevel == 10) { return 285 - currentValue; }
		if(nextLevel == 11) { return 335 - currentValue; }
		return 0.00;
	}
	
	public static double r2d(double d) {
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
    	return Double.valueOf(twoDForm.format(d));
	}

	
}
