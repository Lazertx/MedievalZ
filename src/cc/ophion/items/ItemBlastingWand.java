package cc.ophion.items;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import cc.ophion.Item;
import cc.ophion.Items;
import cc.ophion.MedievalZ;
import cc.ophion.ParticleEffect;

public class ItemBlastingWand extends Item {

	private final String RADIUS_PATH = "abilities." + getName() + ".radius";
	private final String DAMAGE_PATH = "abilities." + getName() + ".damage";
	private final String KNOCKBACK_PATH = "abilities." + getName() + ".knockback";
	
	public ItemBlastingWand() {
		super(Items.BLASTING_WAND.getName(), Items.BLASTING_WAND.getItemStack());
	}

	@Override
	public void onPlayerInteract(final Player player) {
		for(Entity nearby : player.getNearbyEntities(getConfig().getInt(RADIUS_PATH), getConfig().getInt(RADIUS_PATH), getConfig().getInt(RADIUS_PATH))) {
			if(nearby instanceof Player) {
				Player nearbyPlayer = (Player) nearby;
				
				nearbyPlayer.damage(getConfig().getDouble(DAMAGE_PATH));
				nearbyPlayer.setVelocity(new Vector(nearbyPlayer.getLocation().getX() - player.getLocation().getX(), 0.75, nearbyPlayer.getLocation().getZ() - player.getLocation().getZ()).normalize().multiply(0.2004 * getConfig().getInt(KNOCKBACK_PATH)));
				nearbyPlayer.setVelocity(nearbyPlayer.getVelocity().setY(0.75));
				for(int i = 0; i <= 25; i++) {
					final int dist = i;
			        new BukkitRunnable() {
			        	 
			            @Override
			            public void run() {
							ParticleEffect.WITCH_MAGIC.display(player.getLocation().add(0, 0.6, 0), dist/10F, 0F, dist/10F, .075F, 100);
			            }
			 
			        }.runTaskLater(MedievalZ.p, (long) (i/1.25));
				}
			}
		}
	}
}
