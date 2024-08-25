package social.gfl.MochaMilkie.GFLUtils;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import social.gfl.MochaMilkie.GFLUtils.HexForPrefix.HexChatListener;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.ParticlePlayerFollow;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.ParticlePlayerJoinListener;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.TrailCommand;

import java.io.IOException;

public final class GFLUtils extends JavaPlugin {


    @Override
    public void onEnable() {
        DataManager data = new DataManager(this);
        //Save Default Config ... xD
        //saveDefaultConfig();

        //Register events for HexForPrefix
        try {
            if(data.customConfig("Hex").getBoolean("enabled")) {
                getLogger().info("GFLUtils module: Automatically decode hex codes before the players message is Enabled");
                Bukkit.getPluginManager().registerEvents(new HexChatListener(), this);
            }
            else{
                getLogger().info("GFLUtils module: Automatically decode hex codes before the players message is Disabled");
            }
        } catch (IOException e) {
            getLogger().info("GFLUtils module: Automatically decode hex codes before the players message is Disabled");
        }
        Bukkit.getPluginManager().registerEvents(new TotemVoidSave(this), this);

        //Register Particle System
        //Bukkit.getPluginManager().registerEvents(new ParticlePlayerJoinListener(this) , this);
        Bukkit.getPluginManager().registerEvents(new ParticlePlayerFollow(this), this);
        getCommand("trail").setExecutor(new TrailCommand());

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
