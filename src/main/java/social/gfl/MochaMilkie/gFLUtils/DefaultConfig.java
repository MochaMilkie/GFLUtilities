package social.gfl.MochaMilkie.GFLUtils;

public class DefaultConfig {
    public GFLUtils plugin;
    public DefaultConfig(GFLUtils plugin){this.plugin = plugin;}

    public void setupConfig(){
        plugin.getConfig().addDefault("Hex.enabled" , false);
        plugin.getConfig().addDefault("ParticleTrail.enabled" , false);
        plugin.getConfig().addDefault("GUIConfig.enabled" , true);


        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
    }
}
