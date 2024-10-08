package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import social.gfl.MochaMilkie.GFLUtils.GFLUtils;


public class TrailCommand implements CommandExecutor {
    public GFLUtils plugin;
    public TrailCommand(GFLUtils plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if(!plugin.pluginConfig.getBoolean("ParticleTrail.enabled")){
            player.sendMessage(ChatColor.RED + "Particle Trails are currently disabled by the administrator.");
            return true;
        }

        if (!player.hasPermission("GFLUtils.particletrail")) {
            return false;
        }
        ParticleInventorySystem gui = new ParticleInventorySystem(plugin);
        gui.particleGUI(player);

        return true;
    }
}
