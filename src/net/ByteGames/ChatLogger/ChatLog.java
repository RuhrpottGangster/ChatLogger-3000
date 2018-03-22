package net.ByteGames.ChatLogger;

import net.ByteGames.ChatLogger.Commands.ChatLogCommand;
import net.ByteGames.ChatLogger.Listeners.AsyncPlayerChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Marcel Feuß on 19.07.2017.
 */
public class ChatLog extends JavaPlugin {

    private Variables variables;

    @Override
    public void onEnable() {
        variables = new Variables();

        getVariables().create();
        intit();

        Bukkit.getConsoleSender().sendMessage(getVariables().getPrefix() + "§a AKTIVATED §8| §7This plugin is written by§8: §bByteGames");
    }

    @Override
    public void onDisable() {

    }

    private void intit() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new AsyncPlayerChatListener(this), this);

        this.getCommand("chatlog").setExecutor(new ChatLogCommand(this));

    }

    public Variables getVariables() {
        return variables;
    }

}
