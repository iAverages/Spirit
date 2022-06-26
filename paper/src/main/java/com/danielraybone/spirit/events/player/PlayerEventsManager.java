package com.danielraybone.spirit.events.player;

import com.danielraybone.spirit.BaseEventManager;
import com.danielraybone.spirit.SpiritEvent;
import com.danielraybone.spirit.SpiritPaper;
import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerEventsManager extends BaseEventManager {

    public PlayerEventsManager(SpiritPaper plugin) {
        super(plugin);
    }

    @EventHandler
    public void onAsyncChatEvent(AsyncChatEvent e) {
        SpiritEvent event = new SpiritAsyncChatEvent(e);
        this.plugin.getSpiritLogger().info(e.getPlayer().getName() + " sent a message");
        this.core.influx.addEventLog(event);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        SpiritEvent event = new SpiritPlayerJoinEvent(e);
        this.core.influx.addEventLog(event);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        SpiritEvent event = new SpiritPlayerMoveEvent(e);
        core.influx.addEventLog(event);
    }
}
