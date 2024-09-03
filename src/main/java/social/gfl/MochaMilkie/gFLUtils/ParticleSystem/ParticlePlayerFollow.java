package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import social.gfl.MochaMilkie.GFLUtils.GFLUtils;

import java.io.IOException;
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
    public void onPlayerMove(PlayerMoveEvent e) throws IOException {
        YamlConfiguration data = plugin.particleConfig;
        //make player the player
        Player player = e.getPlayer();
        String UUID = player.getUniqueId().toString();
        if(!data.getBoolean(UUID+".enabled")){
            return;
        }
        String selection = data.getString(UUID + ".selection");
        x = player.getLocation().getX();
        y = player.getLocation().getY();
        z = player.getLocation().getZ();
        switch(selection){
            case "vEgg":
                player.getWorld().spawnParticle(Particle.ANGRY_VILLAGER, x, y, z, 1);
                return;
            case "redstone":
                Particle.DustOptions dust = new Particle.DustOptions(Color.fromRGB(255, 0, 0), 1);
                player.getWorld().spawnParticle(Particle.DUST, x, y, z, 1, 0, 0, 0, dust);
                return;
            case "waterBucket":
                player.getWorld().spawnParticle(Particle.DRIPPING_WATER, x, y, z, 1);
                return;
            case "damage":
                player.getWorld().spawnParticle(Particle.DAMAGE_INDICATOR , x,y,z, 2);
            case null:
                return;
            default:
                throw new IllegalStateException("Unexpected value: " + selection);
        }
    }
}
