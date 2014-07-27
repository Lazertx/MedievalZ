package cc.ophion.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import cc.ophion.Item;
import cc.ophion.Items;
import cc.ophion.MedievalZ;

public class CypherPlayerListener implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		MedievalZ.p.getItem(Items.BLASTING_WAND.getName()).onPlayerInteract(event.getPlayer());
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
			if(!event.getPlayer().isSneaking()) {
				Item item = MedievalZ.p.getItem(Items.BLASTING_WAND.getName());
				if(item.getItemStack().getType() == event.getPlayer().getItemInHand().getType()) {
					if(item.getItemStack().getItemMeta().getDisplayName().equals(event.getPlayer().getItemInHand().getItemMeta().getDisplayName())) {
						MedievalZ.p.getItem(Items.BLASTING_WAND.getName()).onPlayerInteract(event.getPlayer());
					}
				}
			} else {
				event.getPlayer().getInventory().addItem(Items.BLASTING_WAND.getItemStack());
			}
		}
	}
}
