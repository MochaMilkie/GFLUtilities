package social.gfl.MochaMilkie.GFLUtils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import social.gfl.MochaMilkie.GFLUtils.HexForPrefix.HexChatListener;
import social.gfl.MochaMilkie.GFLUtils.HexForPrefix.HexConfig;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.ParticlePlayerJoinListener;

public final class GFLUtils extends JavaPlugin {
    public HexConfig hexConfig;

    @Override
    public void onEnable() {
        //SaveDefaultConfig ... xD
        //saveDefaultConfig();

        //Register events for HexForPrefix
        if(hexConfig.hexConfig().getBoolean("enabled")) {
            getLogger().info("GFLUtils module: Automatically decode hex codes before the players message is Enabled");
            Bukkit.getPluginManager().registerEvents(new HexChatListener(), this);
        }
        else{
            getLogger().info("GFLUtils module: Automatically decode hex codes before the players message is Disabled");
        }

        //Register Particle System
        Bukkit.getPluginManager().registerEvents(new ParticlePlayerJoinListener(this) , this);

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
