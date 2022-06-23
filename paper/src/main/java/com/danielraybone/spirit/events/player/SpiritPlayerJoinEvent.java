package com.danielraybone.spirit.events.player;

import com.danielraybone.spirit.PaperEvent;
import com.danielraybone.spirit.Point;

import java.time.Instant;
import java.util.UUID;

public class SpiritPlayerJoinEvent extends PaperEvent {

    private final UUID uuid;
    private final String joinMessage;
    private final Instant time;

    public SpiritPlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent event) {
        this.uuid = event.getPlayer().getUniqueId();
        this.joinMessage = event.joinMessage() == null ? "" : this.serialize(event.joinMessage());
        this.time = Instant.now();
    }

    @Override
    public Point toPoint() {
        return Point.measurement("player-events")
                .addTag("event", "player-join-event")
                .addTag("uuid", this.uuid.toString())
                .addField("join-message", this.joinMessage)
                .time(this.time);
    }
}
