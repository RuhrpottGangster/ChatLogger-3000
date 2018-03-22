package net.ByteGames.ChatLogger;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by Marcel Feuß on 19.07.2017.
 */
public class Variables {

    private String prefix = "§8[§4ChatLog§8] §7";
    private String noPermissions = "§cYou do not have permission to use this command";

    private LinkedHashMap<String, LinkedList<String>> messages;

    public String getPrefix() {
        return prefix;
    }
    public String getNoPermissions() {
        return noPermissions;
    }
    public LinkedHashMap<String, LinkedList<String>> getMessages() {
        return messages;
    }

    public void create() {

        messages = new LinkedHashMap<>();

    }

}
