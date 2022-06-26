package com.danielraybone.spirit.events.player;

import com.danielraybone.spirit.PaperEvent;
import com.danielraybone.spirit.Point;
import io.papermc.paper.event.player.AsyncChatEvent;

import java.time.Instant;
import java.util.UUID;

public class SpiritAsyncChatEvent extends PaperEvent {

    private final UUID uuid;
    private final String message;

    public SpiritAsyncChatEvent(AsyncChatEvent e) {
        this.uuid = e.getPlayer().getUniqueId();
        this.message = this.serialize(e.message());
    }

    @Override
    public Point toPoint() {
        System.out.println(this.message);
        return Point.measurement("player-events")
                .addTag("event", "async-chat-event")
                .addTag("uuid", uuid.toString())
                .addField("message", this.message)
                .time(Instant.now());
    }
}
