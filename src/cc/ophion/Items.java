package cc.ophion;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public enum Items {
	
	BLASTING_WAND("Blasting Wand", ChatColor.DARK_PURPLE.toString(), new ItemStack(Material.BLAZE_ROD))
	;
	
    private String name;
    private ItemStack stack;
	
	Items(String name, String color, ItemStack itemStack) {
		this.name = name;
		ItemMeta iteMeta = itemStack.getItemMeta();
		iteMeta.setDisplayName(color + name);
		itemStack.setItemMeta(iteMeta);
		this.stack = itemStack;
	}
	
	public String getName() {
		return name;
	}
	
	public ItemStack getItemStack() {
		return stack;
	}
}
