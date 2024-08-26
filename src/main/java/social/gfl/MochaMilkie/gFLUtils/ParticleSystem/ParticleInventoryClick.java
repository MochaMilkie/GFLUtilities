package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import social.gfl.MochaMilkie.GFLUtils.DataManager;
import social.gfl.MochaMilkie.GFLUtils.GFLUtils;
import java.io.IOException;


public class ParticleInventoryClick implements Listener {
    public GFLUtils plugin;
    public ParticleInventoryClick(GFLUtils plugin){
        this.plugin = plugin;
    }
    Inventory inv;

    @EventHandler
    public void onClick(InventoryClickEvent event) throws IOException {
        ParticleInventorySystem inventorySystem = new ParticleInventorySystem(plugin);
        inv = inventorySystem.inv;
        DataManager data = new DataManager(plugin);
        Player player = (Player) event.getWhoClicked();
        String uuid = player.getUniqueId().toString();

        if(event.getCurrentItem() == null) return;
        if(event.getCurrentItem().isSimilar(plugin.particleHash.get("vEgg"))){
            event.setCancelled(true);
            player.closeInventory();
            data.customConfig("Particle").set(uuid+".enabled" , true);
            data.customConfig("Particle").set(uuid+".selection" , "vEgg");
            data.saveConfig("Particle");
            player.sendMessage("Your trail has been set to Angry Villager.");
        }
        if(event.getCurrentItem().isSimilar(plugin.particleHash.get("redstone"))){
            event.setCancelled(true);
            player.closeInventory();
            data.customConfig("Particle").set(uuid+".enabled" , true);
            data.customConfig("Particle").set(uuid+".selection" , "redstone");
            data.saveConfig("Particle");
            player.sendMessage("Your trail has been set to Redstone Dust.");
        }
        if(event.getCurrentItem().isSimilar(plugin.particleHash.get("waterBucket"))){
            event.setCancelled(true);
            player.closeInventory();
            data.customConfig("Particle").set(uuid+".enabled" , true);
            data.customConfig("Particle").set(uuid+".selection" , "waterBucket");
            data.saveConfig("Particle");
            player.sendMessage("Your trail has been set to Water Droplets.");
        }
    }
}
