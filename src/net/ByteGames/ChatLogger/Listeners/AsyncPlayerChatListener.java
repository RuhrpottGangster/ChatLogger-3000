package net.ByteGames.ChatLogger.Listeners;

import net.ByteGames.ChatLogger.ChatLog;
import net.ByteGames.ChatLogger.Variables;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by **** on 20.07.2017.
 */
public class AsyncPlayerChatListener implements Listener {

    private ChatLog plugin;

    public AsyncPlayerChatListener(ChatLog plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();

        if(!event.isCancelled()) {

            final Variables variables = plugin.getVariables();
            final String name = player.getName();

            if(!variables.getMessages().containsKey(name)) {
                variables.getMessages().put(name, new LinkedList<>());
            }

            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            Date date = new Date(calendar.getTimeInMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm: ss");
            String dateString = simpleDateFormat.format(date);
            String[] splitDate = dateString.split(" ");

            LinkedList<String> messages = variables.getMessages().get(name);
            messages.addLast("§6" + splitDate[0] + " §8► §e" + splitDate[1] + " " + splitDate[2] + "§8 ➟ §7" + event.getMessage());

            variables.getMessages().put(name, messages);

        }

    }

}
