package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import social.gfl.MochaMilkie.GFLUtils.DataManager;
import social.gfl.MochaMilkie.GFLUtils.GFLUtils;

import java.io.IOException;

public class ParticlePlayerFollow implements Listener {
    public GFLUtils plugin;
    public ParticlePlayerFollow(GFLUtils plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) throws IOException {
        DataManager data = new DataManager(plugin);
        YamlConfiguration config = data.customConfig("Particle");
        //make player the player
        Player player = e.getPlayer();
        String UUID = player.getUniqueId().toString();
        if(!player.hasPermission("GFLUtils.particletrail")){
            return;
        } else if (!config.getBoolean(UUID + ".enabled")) {
            return;
        }
        if(config.getString(UUID+".selection") == "vEgg"){
            double x = player.getLocation().getX();
            double y = player.getLocation().getY();
            double z = player.getLocation().getZ();
            Bukkit.getScheduler().runTaskLater(plugin, () -> player.getWorld().spawnParticle(Particle.ANGRY_VILLAGER, x,y,z,10), 1);
        }
    }
}
