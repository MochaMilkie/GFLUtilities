package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import social.gfl.MochaMilkie.GFLUtils.GFLUtils;


public class ParticlePlayerJoinListener implements Listener {
    public GFLUtils plugin;
    public ParticlePlayerJoinListener(GFLUtils plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(player.hasPermission("GFLUtils.particlesOnJoin")){
            Location loc = player.getLocation();
            double x = loc.getX()+1;
            double y = loc.getY()+1;
            double z = loc.getZ();
            Bukkit.getScheduler().runTaskLater(plugin, () -> player.getWorld().spawnParticle(Particle.TOTEM_OF_UNDYING , x, y , z, 5), 20);
        }
    }
}
