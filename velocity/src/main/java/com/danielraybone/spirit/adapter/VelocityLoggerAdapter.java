package com.danielraybone.spirit.adapter;

import com.danielraybone.spirit.LoggerAdapter;
import com.danielraybone.spirit.SpiritVelocity;

public class VelocityLoggerAdapter implements LoggerAdapter {

    private final SpiritVelocity plugin;

    public VelocityLoggerAdapter(SpiritVelocity plugin) {
        this.plugin = plugin;
    }

    @Override
    public void info(String msg) {
        this.plugin.getLogger().info(msg);
    }

    @Override
    public void error(String msg) {
        this.plugin.getLogger().error(msg);
    }

    @Override
    public void warn(String msg) {
        this.plugin.getLogger().warn(msg);
    }
}
