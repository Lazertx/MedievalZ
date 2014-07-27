package cc.ophion;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Item {
	
	private String name;
	private ItemStack stack;

	public Item(String name, ItemStack stack) {
		this.name = name;
		this.stack = stack;
		ItemManager.items.add(this);
	}
	
	public void onPlayerInteract(Player player) {}
	
	public String getName() {
		return name;
	}
	
	public ItemStack getItemStack() {
		return stack;
	}
	
	public FileConfiguration getConfig() {
		return MedievalZ.p.getFileConfig();
	}
}
