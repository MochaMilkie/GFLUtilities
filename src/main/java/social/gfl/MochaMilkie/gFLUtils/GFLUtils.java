package social.gfl.MochaMilkie.GFLUtils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import social.gfl.MochaMilkie.GFLUtils.ParticleSystem.ParticleHashMap;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public final class GFLUtils extends JavaPlugin {
    public HashMap<String , ItemStack> particleHash = new HashMap<>();
    public YamlConfiguration particleConfig;

    public YamlConfiguration pluginConfig;

    public File pluginFile;


    @Override
    public void onEnable() {
        DefaultConfig defaultConfig = new DefaultConfig(this);
        defaultConfig.setupConfig();
        banner();
        RegEvents events = new RegEvents(this);
        particleConfig = new YamlConfiguration();
        //register other classes.
        ParticleHashMap particleHashMap = new ParticleHashMap(this);
        //assign the hashmap to this classes variable for ease of access
        particleHash = particleHashMap.createParticleHash();
        pluginFile = new File(getDataFolder()+File.separator+"config.yml");
        pluginConfig = new YamlConfiguration();
        try {
            pluginConfig.load(pluginFile);
        } catch (IOException | InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

        events.registerMyMethods();

        Objects.requireNonNull(getCommand("GFLReload")).setExecutor(new ReloadCommand(this));


    }

    @Override
    public void onDisable() {
        Bukkit.getPluginManager().disablePlugin(this);
    }
    public void banner(){
        getLogger().info(" o-o  o--o o    o   o o-O-o o-O-o o     o-o  ");
        getLogger().info("o     |    |    |   |   |     |   |    |     ");
        getLogger().info("|  -o O-o  |    |   |   |     |   |     o-o  ");
        getLogger().info("o   | |    |    |   |   |     |   |        | ");
        getLogger().info(" o-o  o    O---o o-o    o   o-O-o O---oo--o  ");
        getLogger().info("                                             ");
        getLogger().info("                                             ");
        getLogger().info("o--o  o   o     o   o  o-o    o-o o  o   O   ");
        getLogger().info("|   |  \\ /      |\\ /| o   o  /    |  |  / \\  ");
        getLogger().info("O--o    O       | O | |   | O     O--O o---o ");
        getLogger().info("|   |   |       |   | o   o  \\    |  | |   | ");
        getLogger().info("o--o    o       o   o  o-o    o-o o  o o   o ");
    }
}
