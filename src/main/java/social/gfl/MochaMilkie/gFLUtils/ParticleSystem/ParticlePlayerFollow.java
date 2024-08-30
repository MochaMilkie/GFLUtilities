package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import social.gfl.MochaMilkie.GFLUtils.GFLUtils;

import java.util.Objects;

public class ParticlePlayerFollow implements Listener {
    public GFLUtils plugin;
    double x;
    double y;
    double z;

    public ParticlePlayerFollow(GFLUtils plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        //make player the player
        Player player = e.getPlayer();
        String UUID = player.getUniqueId().toString();
        String selection = plugin.particleConfig.getString(UUID + ".selection");
        if (Objects.equals(selection, "vEgg")) {
            x = player.getLocation().getX();
            y = player.getLocation().getY();
            z = player.getLocation().getZ();
            Bukkit.getScheduler().runTaskLater(plugin, () -> player.getWorld().spawnParticle(Particle.ANGRY_VILLAGER, x, y, z, 10), 1);
            return;
        }
        if (Objects.equals(selection, "redstone")) {
            x = player.getLocation().getX();
            y = player.getLocation().getY();
            z = player.getLocation().getZ();
            Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(255, 0, 0), 5);
            Bukkit.getScheduler().runTaskLater(plugin, () -> player.getWorld().spawnParticle(Particle.DUST, x, y, z, 10, 0, 0, 0, dust), 1);
            return;
        }
        if (Objects.equals(selection, "waterBucket")) {
            x = player.getLocation().getX();
            y = player.getLocation().getY();
            z = player.getLocation().getZ();
            Bukkit.getScheduler().runTaskLater(plugin, () -> player.getWorld().spawnParticle(Particle.DRIPPING_WATER, x, y, z, 10), 1);
        }
    }
}
