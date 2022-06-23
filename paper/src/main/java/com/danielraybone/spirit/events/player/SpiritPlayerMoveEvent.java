package com.danielraybone.spirit.events.player;

import com.danielraybone.spirit.PaperEvent;
import com.danielraybone.spirit.Point;

import java.time.Instant;
import java.util.UUID;

public class SpiritPlayerMoveEvent extends PaperEvent {

    private final UUID uuid;
    private final String from;
    private final String to;
    private final Boolean hasChangedBlock;
    private final Boolean hasChangedOrientation;
    private final Boolean hasChangedPosition;
    private final Boolean hasExplicitlyChangedBlock;
    private final Boolean hasExplicitlyChangedPosition;
    private final Boolean isCancelled;
    private final Instant time;

    public SpiritPlayerMoveEvent(org.bukkit.event.player.PlayerMoveEvent event) {
        super();
        this.uuid = event.getPlayer().getUniqueId();
        this.from = event.getFrom().toString();
        this.to = event.getTo().toString();
        this.hasChangedBlock = event.hasChangedBlock();
        this.hasChangedOrientation = event.hasChangedOrientation();
        this.hasChangedPosition = event.hasChangedPosition();
        this.hasExplicitlyChangedBlock = event.hasExplicitlyChangedBlock();
        this.hasExplicitlyChangedPosition = event.hasExplicitlyChangedPosition();
        this.isCancelled = event.isCancelled();
        this.time = Instant.now();
    }

    @Override
    public Point toPoint() {
        return Point.measurement("player-events")
                .addTag("event", "player-move-event")
                .addTag("uuid", this.uuid.toString())

                .addField("from", this.from)
                .addField("to", this.to)
                .addField("hasChangedBlock", this.hasChangedBlock)
                .addField("hasChangedOrientation", this.hasChangedOrientation)
                .addField("hasChangedPosition", this.hasChangedPosition)
                .addField("hasExplicitlyChangedBlock", this.hasExplicitlyChangedBlock)
                .addField("hasExplicitlyChangedPosition", this.hasExplicitlyChangedPosition)
                .addField("isCancelled", this.isCancelled)

                .time(this.time);
    }
}
