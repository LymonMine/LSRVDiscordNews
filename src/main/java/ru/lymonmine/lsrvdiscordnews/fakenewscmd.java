package ru.lymonmine.lsrvdiscordnews;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class fakenewscmd implements CommandExecutor {
    private main plugin;

    public fakenewscmd(main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("lsrvdn.fake")) {
            String s = plugin.getConfig().getString("lang.noperm");
            s = ChatColor.translateAlternateColorCodes('&', s);
            sender.sendMessage(s);
            return true;
        }
        if (args.length >= 0)
            for (String s : main.instance.getConfig().getStringList("news")) {
            s = ChatColor.translateAlternateColorCodes('&', s);
            Bukkit.broadcastMessage(s);
        }
        return true;
    }
}





