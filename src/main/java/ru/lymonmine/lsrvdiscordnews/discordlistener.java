package ru.lymonmine.lsrvdiscordnews;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class discordlistener extends ListenerAdapter {
    public static String url;
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String idchannel = event.getChannel().getId();
        String ids = event.getGuild().getId();
        url = "https://discord.com/channels/" + ids + "/" + idchannel + "/" + event.getMessageId();
        String cidchannel = main.instance.getConfig().getString("bot.channel");
        if (idchannel.equals(cidchannel)) {
            for (String s : main.instance.getConfig().getStringList("news")) {
                s = ChatColor.translateAlternateColorCodes('&', s);
                Bukkit.getServer().broadcastMessage(s);
            }
        }
    }
}