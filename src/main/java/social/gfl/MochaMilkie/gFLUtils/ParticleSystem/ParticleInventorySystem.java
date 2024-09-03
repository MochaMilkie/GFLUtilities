package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import social.gfl.MochaMilkie.GFLUtils.GFLUtils;

import java.util.Arrays;

public class ParticleInventorySystem {
    public GFLUtils plugin;
    public ParticleInventorySystem(GFLUtils plugin){
        this.plugin  = plugin;
    }
    public Inventory inv;

    public void particleGUI(Player player) {
        inv = Bukkit.createInventory(null, 9, "Select your particle trail");
        createItems();
        player.openInventory(inv);


    }
    public void createItems(){
        inv.addItem(plugin.particleHash.get("vEgg"));
        inv.addItem(plugin.particleHash.get("redstone"));
        inv.addItem(plugin.particleHash.get("waterBucket"));
        inv.addItem(plugin.particleHash.get("damage"));
        inv.addItem(plugin.particleHash.get("disable"));
    }

    protected ItemStack createGUIItem(final Material material, final String name , final String... lore){
        final ItemStack item = new ItemStack(material , 1);
        final ItemMeta meta = item.getItemMeta();

        assert meta != null;
        meta.setDisplayName(name);

        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
}
