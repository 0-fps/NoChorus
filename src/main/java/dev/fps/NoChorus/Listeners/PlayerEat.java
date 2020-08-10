package dev.fps.NoChorus.Listeners;


import dev.fps.NoChorus.NoChorus;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerEat implements Listener {

    private NoChorus plugin;

    public PlayerEat(NoChorus plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void cancelEat(PlayerItemConsumeEvent event){
        FileConfiguration config = plugin.getConfig();
        Player player = event.getPlayer();
        ItemStack handitem = player.getInventory().getItemInMainHand();
        ItemStack offhanditem = player.getInventory().getItemInOffHand();

        if(handitem.getType() == Material.CHORUS_FRUIT || offhanditem.getType() == Material.CHORUS_FRUIT){
            String message = config.getString("Eat");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
            event.setCancelled(true);
        }
    }
}
