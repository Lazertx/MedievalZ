package cc.ophion;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.InputStreamReader;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import cc.ophion.listener.CypherPlayerListener;

public class MedievalZ extends JavaPlugin {

	public static MedievalZ p;
	private FileConfiguration config;

	@Override
	public void onEnable() {
		p = this;
		reloadConfig();
		new ItemManager();
		registerListeners(getServer().getPluginManager());
	}

	private void registerListeners(PluginManager pm) {
		HandlerList.unregisterAll(this);

		final CypherPlayerListener playerListener = new CypherPlayerListener();

		pm.registerEvents(playerListener, this);
	}
	
	public void saveDefaultConfig() {
	    if (!new File(getDataFolder(), "abilities.yml").exists()) {            
	         saveResource("abilities.yml", false);
	     }
	}
	
	public void reloadConfig() {
		saveDefaultConfig();
	    config = YamlConfiguration.loadConfiguration(new File(getDataFolder(), "abilities.yml"));
	    
	    Reader defConfigStream = null;
		try {
			defConfigStream = new InputStreamReader(this.getResource("abilities.yml"), "UTF8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    if (defConfigStream != null) {
	        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        config.setDefaults(defConfig);
	    }
	    
	    saveConfig();
	}
	
	public void saveConfig() {
	    if (config == null) {
	        return;
	    }
	    try {
	    	getFileConfig().save(new File(getDataFolder(), "abilities.yml"));
	    } catch (IOException ex) {
	        getLogger().log(Level.SEVERE, "Could not save config to " + new File(getDataFolder(), "abilities.yml"), ex);
	    }
	}

	public FileConfiguration getFileConfig() {
	    if (config == null) {
	        reloadConfig();
	    }
	    return config;
	}

	public Item getItem(String s) {
		Item item = null;;
		for(Item i : ItemManager.items) {
			String name = i.getName();
			if (name.equalsIgnoreCase(s)) {
				item = i;
			}
		}
		return item;
	}
}