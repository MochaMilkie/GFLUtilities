package social.gfl.MochaMilkie.GFLUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import java.io.IOException;

public class ReloadCommand implements CommandExecutor {
    public GFLUtils plugin;

    public ReloadCommand(GFLUtils plugin){this.plugin = plugin;}
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        RegEvents events = new RegEvents(plugin);
        Player player = (Player) commandSender;
        if(player.hasPermission("GFLUtils.admin")){
            try {
                plugin.pluginConfig.load(plugin.pluginFile);
            } catch (IOException | InvalidConfigurationException e) {
                throw new RuntimeException(e);
            }

            events.registerMyMethods();
            player.sendMessage("GFLUtils has reloaded its configuration and registered events.");
            return true;
        }
        return false;
    }
}
