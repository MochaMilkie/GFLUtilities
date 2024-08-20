package social.gfl.MochaMilkie.GFLUtils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import social.gfl.MochaMilkie.GFLUtils.HexForPrefix.HexChatListener;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.ParticlePlayerJoinListener;

public final class GFLUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        //SaveDefaultConfig ... xD
        //saveDefaultConfig();

        //Register events for HexForPrefix
        Bukkit.getPluginManager().registerEvents(new HexChatListener(), this);

        //Register Particle System
        Bukkit.getPluginManager().registerEvents(new ParticlePlayerJoinListener(this) , this);

        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
