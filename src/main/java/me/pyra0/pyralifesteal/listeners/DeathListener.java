package me.pyra0.pyralifesteal.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player victim = e.getEntity();
        Player killer = victim.getKiller();

        if (victim == killer || killer == null) {
            // treat as if they died to environment - check if hearts should be lost to environment
            return;
        }

        // Remove hearts from victim, add hearts to killer, ensuring they don't go over limit or eliminate if need to
    }
}
