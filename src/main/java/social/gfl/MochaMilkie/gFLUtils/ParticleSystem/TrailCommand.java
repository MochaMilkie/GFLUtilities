package social.gfl.MochaMilkie.GFLUtils.ParticleSystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;



public class TrailCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (!player.hasPermission("GFLUtils.particletrail")) {
            return false;
        }
        ParticleInventorySystem gui = new ParticleInventorySystem();
        gui.particleGUI(player);

        return true;
    }
}
