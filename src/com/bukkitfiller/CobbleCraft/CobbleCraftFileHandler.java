package com.bukkitfiller.CobbleCraft;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class CobbleCraftFileHandler {
	
	public static void writeFile(String fileName){
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
		
		if(!file.exists()) { writeFile(fileName); }
		
		
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
		if(!file.exists()){ writeFile(fileName); }
		
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
		
		if(statProgress <= 3) { statLevel = 0; }
		if(statProgress <= 8 && statProgress > 3) { statLevel = 1; }
		if(statProgress <= 15 && statProgress > 8) { statLevel = 2; }
		if(statProgress <= 40 && statProgress > 15) { statLevel = 3; }
		if(statProgress <= 70 && statProgress > 40) { statLevel = 4; }
		if(statProgress <= 100 && statProgress > 70) { statLevel = 5; }
		if(statProgress <= 130 && statProgress > 100) { statLevel = 6; }
		if(statProgress <= 165 && statProgress > 130) { statLevel = 7; }
		if(statProgress <= 200 && statProgress > 165) { statLevel = 8; }
		if(statProgress <= 240 && statProgress > 200) { statLevel = 9; }
		if(statProgress <= 285 && statProgress > 240) { statLevel = 10; }
		if(statProgress <= 335 && statProgress > 335) { statLevel = 11; }
		if(statProgress >= 390) { statLevel = 12; }
		
		return statLevel;
		//testing commit and push
		
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
