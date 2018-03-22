package net.ByteGames.ChatLogger.Commands;

import net.ByteGames.ChatLogger.ChatLog;
import net.ByteGames.ChatLogger.Variables;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by **** on 20.07.2017.
 */
public class ChatLogCommand implements CommandExecutor {

    private ChatLog plugin;

    public ChatLogCommand(ChatLog plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {

        final Variables variables = plugin.getVariables();
        final String prefix = variables.getPrefix();
        final String noPermissions = variables.getNoPermissions();

        if(sender.hasPermission("chatlog.see")) {

            if(arguments.length == 0) {
                sender.sendMessage(" ");
                sender.sendMessage(prefix + "§eThis plugin is written by §6ByteGames§e.");
                sender.sendMessage(prefix + "§4Error§8: §cYou must write a playername.");
                sender.sendMessage(" ");
                return true;
            }
            String name = Bukkit.getOfflinePlayer(arguments[0]).getName();

            if(!variables.getMessages().containsKey(name)) {
                sender.sendMessage(prefix + "§4Error§8: §cThe player §e" + name + "§c wrote no messages.");
                return true;
            }

            sender.sendMessage(" ");
            sender.sendMessage("§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»");
            sender.sendMessage(" ");
            sender.sendMessage("§8 » §7Chatlog from§8: §a" + name);

            for(String messages : variables.getMessages().get(name)) {

                sender.sendMessage(messages);
            }

            sender.sendMessage(" ");
            sender.sendMessage("§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»§7×§4«§c»");
            sender.sendMessage(" ");

            return true;
        } else {
            sender.sendMessage(prefix + noPermissions);
        }

        return true;
    }

}
