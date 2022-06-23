package com.danielraybone.spirit;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;

public abstract class PaperEvent implements SpiritEvent {

    protected String serialize(Component component) {
        return GsonComponentSerializer.gson().serialize(component);
    }

}
