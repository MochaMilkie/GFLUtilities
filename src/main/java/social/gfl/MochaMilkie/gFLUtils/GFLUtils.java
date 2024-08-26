package social.gfl.MochaMilkie.GFLUtils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import social.gfl.MochaMilkie.GFLUtils.HexForPrefix.HexChatListener;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.ParticleHashMap;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.ParticleInventoryClick;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.ParticlePlayerFollow;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.TrailCommand;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public final class GFLUtils extends JavaPlugin {
    public HashMap<String , ItemStack> particleHash = new HashMap<>();



    @Override
    public void onEnable() {
        //register other classes.
        DataManager data = new DataManager(this);
        ParticleHashMap particleHashMap = new ParticleHashMap(this);
        //assign the hashmap to this classes variable for ease of access
        particleHash = particleHashMap.createParticleHash();


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
        Bukkit.getPluginManager().registerEvents(new ParticleInventoryClick(this) , this);
        Objects.requireNonNull(getCommand("trail")).setExecutor(new TrailCommand(this));

        // Plugin startup logic


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
