package com.gmail.filoghost.holographicdisplays.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public class ItemUtils {
	
	// This is used on hologram icons, to prevent vanilla items from merging with them.
	public static final String ANTISTACK_LORE = ChatColor.BLACK.toString() + Math.random();
	
	// A map with formatter materials (lowercase and without dashes) for fast access.
	private static Map<String, Material> materialMap = new HashMap<String, Material>();
	
	private static Pattern stripSpacingSymbolsPattern = Pattern.compile("[_ \\-]+");
	
	static {
		// Default material names are ugly.
		Map<String, Material> tempMap = Utils.newMap();
			
		tempMap.put("iron bar",				Material.IRON_BARS);
		tempMap.put("iron bars",			Material.IRON_BARS);
		tempMap.put("glass pane",			Material.GLASS_PANE);
		tempMap.put("nether wart",			Material.NETHER_WART);
		tempMap.put("nether warts",			Material.NETHER_WART);
		tempMap.put("slab",					Material.STONE_SLAB);
		tempMap.put("double slab",			Material.LEGACY_DOUBLE_STONE_SLAB2);
		tempMap.put("stone brick",			Material.STONE_BRICKS);
		tempMap.put("stone bricks",			Material.STONE_BRICKS);
		tempMap.put("stone stair",			Material.STONE_BRICK_STAIRS);
		tempMap.put("stone stairs",			Material.STONE_BRICK_STAIRS);
		tempMap.put("potato",				Material.POTATO);
		tempMap.put("carrot",				Material.CARROT);
		tempMap.put("brewing stand",		Material.BREWING_STAND);
		tempMap.put("cauldron",				Material.CAULDRON);
		tempMap.put("carrot on stick",		Material.CARROT_ON_A_STICK);
		tempMap.put("carrot on a stick",	Material.CARROT_ON_A_STICK);
		tempMap.put("cobblestone wall",		Material.COBBLESTONE_WALL);
		tempMap.put("wood slab",			Material.OAK_SLAB);
		tempMap.put("double wood slab",		Material.LEGACY_WOOD_DOUBLE_STEP);
		tempMap.put("repeater",				Material.REPEATER);
		tempMap.put("piston",				Material.PISTON);
		tempMap.put("sticky piston",		Material.STICKY_PISTON);
		tempMap.put("flower pot",			Material.FLOWER_POT);
		tempMap.put("wood showel",			Material.WOODEN_SHOVEL);
		tempMap.put("stone showel",			Material.STONE_SHOVEL);
		tempMap.put("gold showel",			Material.GOLDEN_SWORD);
		tempMap.put("iron showel",			Material.IRON_SHOVEL);
		tempMap.put("diamond showel",		Material.DIAMOND_SHOVEL);
		tempMap.put("steak",				Material.COOKED_BEEF);
		tempMap.put("cooked porkchop",		Material.COOKED_PORKCHOP);
		tempMap.put("raw porkchop",			Material.PORKCHOP);
		tempMap.put("hardened clay",		Material.LEGACY_HARD_CLAY);
		tempMap.put("huge brown mushroom",	Material.LEGACY_HUGE_MUSHROOM_1);
		tempMap.put("huge red mushroom",	Material.LEGACY_HUGE_MUSHROOM_2);
		tempMap.put("mycelium",				Material.MYCELIUM);
		tempMap.put("poppy",				Material.ROSE_RED);
		tempMap.put("comparator",			Material.COMPARATOR);
		tempMap.put("skull",				Material.LEGACY_SKULL_ITEM);
		tempMap.put("head",					Material.LEGACY_SKULL_ITEM);
		tempMap.put("redstone torch",		Material.REDSTONE_TORCH);
		tempMap.put("redstone lamp",		Material.REDSTONE_LAMP);
		tempMap.put("glistering melon",		Material.GLISTERING_MELON_SLICE);
		tempMap.put("gunpowder",			Material.GUNPOWDER);
		tempMap.put("lilypad",				Material.LILY_PAD);
		tempMap.put("command block",		Material.COMMAND_BLOCK);
		tempMap.put("dye",					Material.INK_SAC);
		
		for (Entry<String, Material> tempEntry : tempMap.entrySet()) {
			materialMap.put(stripSpacingChars(tempEntry.getKey()).toLowerCase(), tempEntry.getValue());
		}
		
		for (Material mat : Material.values()) {
			materialMap.put(stripSpacingChars(mat.toString()).toLowerCase(), mat);
		}
	}
	
	public static String stripSpacingChars(String input) {
		return stripSpacingSymbolsPattern.matcher(input).replaceAll("");
	}
	
	@SuppressWarnings("deprecation")
	public static Material matchMaterial(String input) {
		try {
			return Material.getMaterial(input);
		} catch (NumberFormatException e) {
			return materialMap.get(stripSpacingChars(input).toLowerCase());
		}
	}

}
