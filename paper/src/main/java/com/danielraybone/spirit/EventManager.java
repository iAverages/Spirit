package com.danielraybone.spirit;


import com.danielraybone.spirit.events.player.PlayerEventsManager;
import org.bukkit.event.Listener;


public class EventManager implements Listener {

    private final PlayerEventsManager playerEventsManager;

    public EventManager(SpiritPaper plugin) {
        this.playerEventsManager = new PlayerEventsManager(plugin);
    }


}
