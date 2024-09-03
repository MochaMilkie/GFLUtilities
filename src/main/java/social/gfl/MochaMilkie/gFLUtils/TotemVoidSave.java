package social.gfl.MochaMilkie.GFLUtils;

import org.bukkit.Location;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityResurrectEvent;

public class TotemVoidSave implements Listener {
    public GFLUtils plugin;
    public TotemVoidSave(GFLUtils plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onVoidDamage(EntityResurrectEvent event){
        Entity entity = event.getEntity();

        if(entity instanceof Player){
            EntityDamageEvent damage = event.getEntity().getLastDamageCause();
            assert damage != null;
            if(damage.getCause() == EntityDamageEvent.DamageCause.VOID){
                Player player = (Player)event.getEntity();
                Location loc = player.getRespawnLocation();
                player.teleport(loc);
            }

        }
    }
}
