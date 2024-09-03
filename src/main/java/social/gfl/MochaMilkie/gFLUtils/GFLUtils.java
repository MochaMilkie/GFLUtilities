package social.gfl.MochaMilkie.GFLUtils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.C;
import social.gfl.MochaMilkie.GFLUtils.ConfigGUISystem.ConfigHashMap;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.ParticleHashMap;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.ParticleInventorySystem;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public final class GFLUtils extends JavaPlugin {
    public HashMap<String , ItemStack> particleHash = new HashMap<>();
    public HashMap<String , ItemStack> configHash = new HashMap<>();
    public YamlConfiguration particleConfig;

    public YamlConfiguration pluginConfig;

    public File pluginFile;


    @Override
    public void onEnable() {
        //Set up the default config and assign it to pluginConfig
        DefaultConfig defaultConfig = new DefaultConfig(this);
        defaultConfig.setupConfig();


        //Display startup banner
        banner();

        //Declare particleConfig as a new YAMLConfiguration so that it is initialized.
        //This allows for other classes to call configs from this class' declared variables
        //which reduces calls to disc.
        particleConfig = new YamlConfiguration();

        //Assign the hashmap to this classes variable for ease of access
        particleHash = new ParticleHashMap(this).createParticleHash();

        configHash = new ConfigHashMap(this).createConfigHash();

        //Declare the plugin file to its location and declare pluginConfig to initiate it.
        pluginFile = new File(getDataFolder()+File.separator+"config.yml");
        pluginConfig = new YamlConfiguration();

        //Try to load pluginFile using pluginConfig (pluginFile is the config.yml located on the disc)
        try {
            pluginConfig.load(pluginFile);
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
        //Manually register my events and commands in a different method
        RegEvents events = new RegEvents(this);
        events.registerMyMethods();

        //Register GFLReload command as it will ALWAYS BE ACTIVE
        Objects.requireNonNull(getCommand("GFLReload")).setExecutor(new ReloadCommand(this));


    }

    @Override
    public void onDisable() {
        Bukkit.getPluginManager().disablePlugin(this);
    }

    public void banner(){
        getLogger().info(" ");
        getLogger().info(" ██████  ███████ ██      ██    ██ ████████ ██ ██      ███████");
        getLogger().info("██       ██      ██      ██    ██    ██    ██ ██      ██     ");
        getLogger().info("██   ███ █████   ██      ██    ██    ██    ██ ██      ███████");
        getLogger().info("██    ██ ██      ██      ██    ██    ██    ██ ██           ██");
        getLogger().info(" ██████  ██      ███████  ██████     ██    ██ ███████ ███████");
        getLogger().info("                                                             ");
        getLogger().info("By Mocha (:");
    }
}
