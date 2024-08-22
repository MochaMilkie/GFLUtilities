package social.gfl.MochaMilkie.GFLUtils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataManager {
    public GFLUtils plugin;

    public DataManager(GFLUtils plugin) {
        this.plugin = plugin;
    }

    File configFile;
    YamlConfiguration config;

    public YamlConfiguration customConfig(String s) throws IOException {
        //String being passed along is to know which config to load.
        //Declare file path
        configFile = new File(plugin.getDataFolder() + File.separator + s);
        try {
            //Attempt to load the file
            config.load(configFile);
        } catch (InvalidConfigurationException | IOException e) {
            createConfigFile(s);
        }
        return config;
    }
    public void createConfigFile(String s) throws IOException {
        //if no file, now file.
        configFile = new File(plugin.getDataFolder()+File.separator + s);
        config.save(configFile);
    }
}
