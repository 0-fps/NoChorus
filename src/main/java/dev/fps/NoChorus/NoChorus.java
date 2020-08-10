package dev.fps.NoChorus;

import dev.fps.NoChorus.Commands.ReloadCMD;
import dev.fps.NoChorus.Listeners.PlayerEat;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class NoChorus extends JavaPlugin {

    public String ConfigRute;


    public void onEnable(){
        registerCommands();
        registerListeners();
        registerConfig();
        Bukkit.getConsoleSender().sendMessage("NoChorus has been enabled");

    }
    public void onDisable(){
        Bukkit.getConsoleSender().sendMessage("NoChorus has been disabled");
    }
    public void registerCommands(){
        getCommand("nochorus").setExecutor(new ReloadCMD(this));
    }
    public void registerListeners(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerEat(this), this);
    }
    public void registerConfig(){
        File config = new File(this.getDataFolder(),"config.yml");
        ConfigRute = config.getPath();
        if(!config.exists()){
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }
}
