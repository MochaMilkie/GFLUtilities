package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
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
        ParticleConfigManager data = new ParticleConfigManager(plugin);
        Player player = (Player) event.getWhoClicked();
        String uuid = player.getUniqueId().toString();

        if(event.getCurrentItem() == null) return;
        if(event.getCurrentItem().isSimilar(plugin.particleHash.get("vEgg"))){
            event.setCancelled(true);
            player.closeInventory();
            data.customConfig().set(uuid+".enabled" , true);
            data.customConfig().set(uuid+".selection" , "vEgg");
            data.saveConfig();
            player.sendMessage("Your trail has been set to Angry Villager.");
        }
        if(event.getCurrentItem().isSimilar(plugin.particleHash.get("redstone"))){
            event.setCancelled(true);
            player.closeInventory();
            data.customConfig().set(uuid+".enabled" , true);
            data.customConfig().set(uuid+".selection" , "redstone");
            data.saveConfig( );
            player.sendMessage("Your trail has been set to Redstone Dust.");
        }
        if(event.getCurrentItem().isSimilar(plugin.particleHash.get("waterBucket"))){
            event.setCancelled(true);
            player.closeInventory();
            data.customConfig().set(uuid+".enabled" , true);
            data.customConfig().set(uuid+".selection" , "waterBucket");
            data.saveConfig();
            player.sendMessage("Your trail has been set to Water Droplets.");
        }
    }
}
