package com.danielraybone.spirit;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class BaseEventManager implements Listener {

    public SpiritPaper plugin;
    public SpiritCommon core;

    public BaseEventManager(SpiritPaper plugin) {
        this.plugin = plugin;
        this.core = plugin.common;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
}
