package social.gfl.MochaMilkie.GFLUtils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.HandlerList;
import social.gfl.MochaMilkie.GFLUtils.HexForPrefix.HexChatListener;

public class RegEvents {
    public GFLUtils plugin;
    public RegEvents(GFLUtils plugin){
        this.plugin = plugin;
    }


    public void registerMyMethods(){
        HandlerList.unregisterAll(plugin);
        plugin.getLogger().warning("To enable or disable any of the features of GFLUtils see config.yml");
        YamlConfiguration pluginConfig = plugin.pluginConfig;
        if(pluginConfig.getBoolean("Hex.enabled")){
            Bukkit.getPluginManager().registerEvents(new HexChatListener(), plugin);
            plugin.getLogger().info("Hex decode before player messages is enabled.");
        } else if (!pluginConfig.getBoolean("Hex.enabled")) {
            plugin.getLogger().info("Hex decode before player messages is not enabled");

        }
        if(pluginConfig.getBoolean("ParticleTrails.enabled")){
            //Bukkit.getPluginManager().registerEvents();
            plugin.getLogger().warning("ParticleTrails is currently disabled by the developer.");
        }

    }
}
