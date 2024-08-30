package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import social.gfl.MochaMilkie.GFLUtils.GFLUtils;

import java.io.File;
import java.io.IOException;

public class ParticleConfigManager{

    public GFLUtils plugin;

    public ParticleConfigManager(GFLUtils plugin) {
        this.plugin = plugin;
    }

    File configFile;
    YamlConfiguration config;

    public YamlConfiguration customConfig() throws IOException {
        //String being passed along is to know which config to load.
        //Declare file path
        //ALWAYS DELCARE CONFIG AS NEW YAMLCONFIGURATION OR NO WORK
        configFile = new File(plugin.getDataFolder() + File.separator + "Particle");
        try {
            //Attempt to load the file
            config = new YamlConfiguration();
            config.load(configFile);
        } catch (InvalidConfigurationException | IOException e) {
            createConfigFile();
        }
        return config;
    }
    public void saveConfig() throws IOException {
        try {
            config.save(configFile);
            customConfig();
            plugin.particleConfig = config;

        } catch (IOException e) {
            createConfigFile();
        }


    }
    public void createConfigFile() throws IOException {
        //if no file, now file.
        //ALWAYS DELCARE CONFIG AS NEW YAMLCONFIGURATION OR NO WORK
        config = new YamlConfiguration();
        configFile = new File(plugin.getDataFolder()+File.separator + "Particle");
        config.addDefault("enabled" , false);
        config.save(configFile);
        plugin.particleConfig = config;
    }
}
