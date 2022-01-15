package ru.lymonmine.lsrvdiscordnews;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class latnewscmd implements CommandExecutor {
    private main plugin;

    public latnewscmd(main plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("lsrvdn.lat")) {
            String s = plugin.getConfig().getString("lang.noperm");
            s = ChatColor.translateAlternateColorCodes('&', s);
            sender.sendMessage(s);
            return true;
        }
        if (discordlistener.url == null) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.instance.getConfig().getString("lang.last-post.nolast")));
            return true;
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.instance.getConfig().getString("lang.last-post.last")));
            sender.sendMessage(ChatColor.LIGHT_PURPLE + discordlistener.url);
            return true;
        }
    }
}



