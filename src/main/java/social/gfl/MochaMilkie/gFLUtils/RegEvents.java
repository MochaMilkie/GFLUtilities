package social.gfl.MochaMilkie.GFLUtils;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.HandlerList;
import social.gfl.MochaMilkie.GFLUtils.HexForPrefix.HexChatListener;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.ParticleInventoryClick;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.ParticlePlayerFollow;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.TrailCommand;

import java.util.Objects;

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

        if(pluginConfig.getBoolean("ParticleTrail.enabled")){
            Bukkit.getPluginManager().registerEvents(new ParticlePlayerFollow(plugin) , plugin);
            plugin.getLogger().warning("ParticleTrails is currently enabled. There may be bugs.");
            Objects.requireNonNull(plugin.getCommand("trail")).setExecutor(new TrailCommand(plugin));
            Bukkit.getPluginManager().registerEvents(new ParticleInventoryClick(plugin) , plugin);
        } else if (!pluginConfig.getBoolean("ParticleTrail.enabled")) {
            //Objects.requireNonNull(plugin.getCommand("trail")).unregister((CommandMap) new TrailCommand(plugin));
            plugin.getLogger().warning("ParticleTrails is currently disabled.");

        }

    }
}
