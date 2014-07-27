package cc.ophion;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class MedievalZ extends JavaPlugin {
	
	public static MedievalZ p;
	private FileConfiguration config = null;
	
	@Override
	public void onEnable() {
		p = this;
		loadConfig();
	}
	
	private void loadConfig() {
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		config = this.getConfig();
	}
	
	public FileConfiguration getFileConfig() {
		return config;
	}
}