package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ParticleInventorySystem {
    public Inventory inv;

    public void particleGUI(Player player) {
        inv = Bukkit.createInventory(null, 9, "Select your particle trail");
        createItems("all");
        player.openInventory(inv);


    }

    public ItemStack createItems(String input) {
        //Create custom items and assign them to variables.
        ItemStack vEgg = createGUIItem(Material.VILLAGER_SPAWN_EGG, "Angry Villager", "Select this item to get an angry" +
                " villager particle trail.");
        ItemStack redstone = createGUIItem(Material.REDSTONE, "Redstone Dust", "Select this item to get an a redstone" +
                " dust trail.");
        ItemStack waterBucket = createGUIItem(Material.WATER_BUCKET, "Water Drops", "Select this item to get a water droplet trail.");
        ItemStack lavaBucket = createGUIItem(Material.LAVA_BUCKET, "Lava Drops", "Select this item to get a lava droplets trail.");
        ItemStack pot = createGUIItem(Material.SPLASH_POTION, "Hearts", "Select this item to get a heart trail.");
        ItemStack skull = createGUIItem(Material.SOUL_SAND, "Soul Skulls", "Select this item to get a soul skull trail.");
        ItemStack damage = createGUIItem(Material.DIAMOND_SWORD, "Damage" , "Select this item to get a damage indicator trail.");
        ItemStack dust1 = createGUIItem(Material.SAND , "Dust" , "Select this item to get a dust trail.");
        ItemStack egg = createGUIItem(Material.EGG, "Egg Cracks" , "Select this item to get a cracked eggs trail.");
        ItemStack spark = createGUIItem(Material.LIGHTNING_ROD , "Electric Spark" , "Select this item to get an electric spark trail.");
        ItemStack barrier = createGUIItem(Material.BARRIER, "Reset Trail", "Select this item to clear your trail.");


        //See what reason we called the method and return it. Call "all" to assign all to the inventory.
        switch (input) {
            case "vEgg":
                return vEgg;
            case "redstone":
                return redstone;
            case "waterBucket":
                return waterBucket;
            case "lavaBucket":
                return lavaBucket;
            case "pot":
                return pot;
            case "skull":
                return skull;
            case "barrier":
                return barrier;
            case "damage":
                return damage;
            case "dust1":
                return dust1;
            case "egg":
                return egg;
            case "spark":
                return spark;
            case "all":
                inv.addItem(vEgg);
                inv.addItem(redstone);
                inv.addItem(waterBucket);
                inv.addItem(lavaBucket);
                inv.addItem(pot);
                inv.addItem(skull);
                inv.addItem(barrier);
        }
        return null;
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
