package social.gfl.MochaMilkie.GFLUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

import java.io.Console;
import java.io.IOException;

public class ReloadCommand implements CommandExecutor {
    public GFLUtils plugin;
    private Player player;

    public ReloadCommand(GFLUtils plugin){this.plugin = plugin;}
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        RegEvents events = new RegEvents(plugin);

        if (commandSender instanceof Player) player = (Player) commandSender;
        if(commandSender instanceof ConsoleCommandSender || player.hasPermission("GFLUtils.admin")){
            try {
                plugin.pluginConfig.load(plugin.pluginFile);
            } catch (IOException | InvalidConfigurationException e) {
                throw new RuntimeException(e);
            }

            events.registerMyMethods();
            commandSender.sendMessage("GFLUtils has reloaded its configuration and registered events.");
            return true;
        }
        return false;
    }
}
