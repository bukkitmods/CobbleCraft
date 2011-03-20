package com.bukkitfiller.CobbleCraft;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;

public class CobbleCraftBlockListener extends BlockListener {
	
	@Override
	public void onBlockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		String playerName = player.getName();
		Block block = event.getBlock();
		String fileName = CobbleCraft.FILEDIRECTORY + playerName + ".stats";
		Material playersItem = player.getItemInHand().getType();
		
		if(playersItem == Material.WOOD_PICKAXE || playersItem == Material.STONE_PICKAXE || playersItem == Material.IRON_PICKAXE || playersItem == Material.GOLD_PICKAXE || playersItem == Material.DIAMOND_PICKAXE){
			
		hitMiningBlock(player, block, playersItem, fileName);
		
		}else if(playersItem == Material.WOOD_SPADE || playersItem == Material.STONE_SPADE || playersItem == Material.IRON_SPADE || playersItem == Material.GOLD_SPADE || playersItem == Material.DIAMOND_SPADE){
			
		hitDiggingBlock(player, block, playersItem, fileName);
		
		}
		
	}
	
	public void hitMiningBlock(Player player, Block block, Material playersItem, String fileName){
		
		LevelValues.CheckLevelUp(fileName, player, LevelValues.MiningLevels, "Mining");
		
		if(block.getType() == Material.STONE){
			if(playersItem == Material.WOOD_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.2);
			}
			if(playersItem == Material.STONE_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.3);
			}
			if(playersItem == Material.IRON_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.4);
			}
			if(playersItem == Material.GOLD_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.5);
			}
			if(playersItem == Material.DIAMOND_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.6);
			}
		}
		
		if(block.getType() == Material.COAL_ORE){
			if(playersItem == Material.WOOD_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.28);
			}
			if(playersItem == Material.STONE_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.38);
			}
			if(playersItem == Material.IRON_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.48);
			}
			if(playersItem == Material.GOLD_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.58);
			}
			if(playersItem == Material.DIAMOND_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.68);
			}
		}
		
		if(block.getType() == Material.IRON_ORE){
			if(playersItem == Material.WOOD_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.34);
			}
			if(playersItem == Material.STONE_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.44);
			}
			if(playersItem == Material.IRON_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.54);
			}
			if(playersItem == Material.GOLD_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.64);
			}
			if(playersItem == Material.DIAMOND_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.74);
			}
		}
		
		if(block.getType() == Material.GOLD_ORE){
			if(playersItem == Material.WOOD_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.39);
			}
			if(playersItem == Material.STONE_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.49);
			}
			if(playersItem == Material.IRON_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.59);
			}
			if(playersItem == Material.GOLD_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.69);
			}
			if(playersItem == Material.DIAMOND_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.79);
			}
		}
		
		if(block.getType() == Material.REDSTONE_ORE){
			if(playersItem == Material.WOOD_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.52);
			}
			if(playersItem == Material.STONE_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.62);
			}
			if(playersItem == Material.IRON_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.72);
			}
			if(playersItem == Material.GOLD_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.82);
			}
			if(playersItem == Material.DIAMOND_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.92);
			}
		}
		
		if(block.getType() == Material.DIAMOND_ORE){
			if(playersItem == Material.WOOD_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.60);
			}
			if(playersItem == Material.STONE_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.70);
			}
			if(playersItem == Material.IRON_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.80);
			}
			if(playersItem == Material.GOLD_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 0.90);
			}
			if(playersItem == Material.DIAMOND_PICKAXE){
				CobbleCraftFileHandler.editProperty(fileName, "MINING", 1.00);
			}
		}
		
		
	}
	
	public void hitDiggingBlock(Player player, Block block, Material playersItem, String fileName){
		
		LevelValues.CheckLevelUp(fileName, player, LevelValues.DiggingLevels, "Digging");
		
		if(block.getType() == Material.DIRT){
			if(playersItem == Material.WOOD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.10);
			}
			if(playersItem == Material.STONE_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.15);
			}
			if(playersItem == Material.IRON_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.20);
			}
			if(playersItem == Material.GOLD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.25);
			}
			if(playersItem == Material.DIAMOND_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.30);
			}
		}
		
		if(block.getType() == Material.GRASS){
			if(playersItem == Material.WOOD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.10);
			}
			if(playersItem == Material.STONE_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.15);
			}
			if(playersItem == Material.IRON_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.20);
			}
			if(playersItem == Material.GOLD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.25);
			}
			if(playersItem == Material.DIAMOND_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.30);
			}
		}
		
		if(block.getType() == Material.SAND){
			if(playersItem == Material.WOOD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.12);
			}
			if(playersItem == Material.STONE_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.17);
			}
			if(playersItem == Material.IRON_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.22);
			}
			if(playersItem == Material.GOLD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.27);
			}
			if(playersItem == Material.DIAMOND_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.32);
			}
		}
		
		if(block.getType() == Material.GRAVEL){
			if(playersItem == Material.WOOD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.17);
			}
			if(playersItem == Material.STONE_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.22);
			}
			if(playersItem == Material.IRON_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.27);
			}
			if(playersItem == Material.GOLD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.32);
			}
			if(playersItem == Material.DIAMOND_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.37);
			}
		}
		
		if(block.getType() == Material.CLAY){
			if(playersItem == Material.WOOD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.24);
			}
			if(playersItem == Material.STONE_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.29);
			}
			if(playersItem == Material.IRON_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.34);
			}
			if(playersItem == Material.GOLD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.39);
			}
			if(playersItem == Material.DIAMOND_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.44);
			}
		}
		
		if(block.getType() == Material.GLOWSTONE){
			if(playersItem == Material.WOOD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.17);
			}
			if(playersItem == Material.STONE_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.22);
			}
			if(playersItem == Material.IRON_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.27);
			}
			if(playersItem == Material.GOLD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.32);
			}
			if(playersItem == Material.DIAMOND_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.37);
			}
		}
		
		if(block.getType() == Material.NETHERRACK){
			if(playersItem == Material.WOOD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.19);
			}
			if(playersItem == Material.STONE_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.24);
			}
			if(playersItem == Material.IRON_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.29);
			}
			if(playersItem == Material.GOLD_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.34);
			}
			if(playersItem == Material.DIAMOND_SPADE){
				CobbleCraftFileHandler.editProperty(fileName, "DIGGING", 0.39);
			}
		}
		
		
	}
	
}
