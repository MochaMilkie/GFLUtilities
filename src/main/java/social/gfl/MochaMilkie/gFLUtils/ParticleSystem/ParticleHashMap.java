package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import social.gfl.MochaMilkie.GFLUtils.GFLUtils;

import java.util.HashMap;

public class ParticleHashMap {

    public GFLUtils plugin;
    public ParticleHashMap(GFLUtils plugin){
        this.plugin = plugin;
    }

    public HashMap<String , ItemStack> createParticleHash(){
        ParticleInventorySystem inventorySystem = new ParticleInventorySystem(plugin);
        HashMap<String , ItemStack> hash = plugin.particleHash;
        hash.put("vEgg", inventorySystem.createGUIItem(Material.VILLAGER_SPAWN_EGG , "Angry Villager"
                , "Select this item to get", "an angry villager trail."));
        hash.put("redstone" , inventorySystem.createGUIItem(Material.REDSTONE, "Redstone Dust"
                , "Select this item to get", "a redstone dust trail."));
        hash.put("waterBucket" , inventorySystem.createGUIItem(Material.WATER_BUCKET , "Water Droplets"
                , "Select this item to get" , "a water droplet trail."));
        hash.put("damage" , inventorySystem.createGUIItem(Material.DIAMOND_SWORD, "Damage Indicator"
                , "Select this item to get", "a damage indicator trail"));





        return hash;
    }
}
