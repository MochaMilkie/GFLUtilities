package social.gfl.MochaMilkie.GFLUtils.ConfigGUISystem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import social.gfl.MochaMilkie.GFLUtils.GFLUtils;

import java.io.ObjectInputFilter;
import java.util.Arrays;
import java.util.HashMap;

public class ConfigHashMap {
    public GFLUtils plugin;

    public ConfigHashMap(GFLUtils plugin) {this.plugin = plugin;}

    public HashMap<String , ItemStack> createConfigHash(){
        HashMap<String , ItemStack> configHash = plugin.configHash;
        configHash.put("enableHexChat" , createGUIItem(Material.RED_TERRACOTTA , "HexChat is disabled"
                , "Click here to enable HexChat"));
        configHash.put("disableHexChat" , createGUIItem(Material.GREEN_TERRACOTTA , "HexChat is enabled"
                , "Click here to disable HexChat"));


        return configHash;
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
