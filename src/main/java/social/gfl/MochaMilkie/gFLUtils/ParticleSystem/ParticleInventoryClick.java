package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class ParticleInventoryClick implements Listener {
    Inventory inv;

    @EventHandler
    public void onClick(InventoryClickEvent event){
        ParticleInventorySystem inventorySystem = new ParticleInventorySystem();
        inv = inventorySystem.inv;
        Inventory openedinv = event.getClickedInventory();
        if(event.getCurrentItem() == null) return;


    }
}
