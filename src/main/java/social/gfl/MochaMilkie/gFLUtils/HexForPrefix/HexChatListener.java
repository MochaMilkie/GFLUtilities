package social.gfl.MochaMilkie.GFLUtils.HexForPrefix;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexChatListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onChat(AsyncPlayerChatEvent event){
        String message = event.getMessage();
        //Scary regex magic... Dx
        Pattern HEX_PATTERN = Pattern.compile("(#[A-Fa-f0-9]{6}(?=[^:]*$))");
        Matcher matcher = HEX_PATTERN.matcher(message);
        while (matcher.find()) {
            message = message.replace(matcher.group(), "" + ChatColor.of(matcher.group()));
        }
        message = ChatColor.translateAlternateColorCodes('&', message);
        event.setMessage(message);

    }

}
