package social.gfl.MochaMilkie.GFLUtils.HexForPrefix;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.error.YAMLException;
import social.gfl.MochaMilkie.GFLUtils.GFLUtils;

import java.io.File;
import java.io.IOException;

public class HexConfig {
    public GFLUtils plugin;
    public HexConfig(GFLUtils plugin){
        this.plugin = plugin;
    }

    public File configFile;
    public YamlConfiguration config;

    public void createConfig() throws IOException, InvalidConfigurationException {
        configFile = new File(plugin.getDataFolder()+File.separator+"Hex.yml");
        config = new YamlConfiguration();
        config.save(configFile);

    }

    public void loadConfig() throws IOException, InvalidConfigurationException {
        configFile = new File(plugin.getDataFolder() + File.separator + "Hex.yml");
        config = new YamlConfiguration();
        config.load(configFile);
    }

    public YamlConfiguration hexConfig(){
        return this.config;
    }
}
