package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import social.gfl.MochaMilkie.GFLUtils.GFLUtils;

public class ParticlePlayerFollow implements Listener {
    public GFLUtils plugin;
    public ParticlePlayerFollow(GFLUtils plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player player = e.getPlayer();
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            @Override
            public void run() {
                player.getWorld().spawnParticle(Particle.ANGRY_VILLAGER, x,y,z,1);

            }
        }, 5);
    }
}
