package ru.lymonmine.lsrvdiscordnews;

import net.dv8tion.jda.api.JDABuilder;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;
import java.io.File;

public final class main extends JavaPlugin {
    public static main instance;
    @Override
    public void onEnable() {
        //конфиг
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if(!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
        //конфиг
        //команды
        getCommand("latnews").setExecutor(new latnewscmd(this));
        getCommand("fakenews").setExecutor(new fakenewscmd(this));
        //команды
        //discordapi
        JDABuilder builder = JDABuilder.createDefault(getConfig().getString("bot.token"));
        builder.addEventListeners(new discordlistener());
        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        //discordapi
        instance = this;


    }

}
