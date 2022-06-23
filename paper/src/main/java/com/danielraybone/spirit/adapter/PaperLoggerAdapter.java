package com.danielraybone.spirit.adapter;

import com.danielraybone.spirit.LoggerAdapter;
import com.danielraybone.spirit.SpiritPaper;

public class PaperLoggerAdapter implements LoggerAdapter {

    private final SpiritPaper plugin;

    public PaperLoggerAdapter(SpiritPaper plugin) {
        this.plugin = plugin;
    }

    @Override
    public void info(String msg) {
        this.plugin.getLogger().info(msg);
    }

    @Override
    public void error(String msg) {
        this.plugin.getLogger().severe(msg);
    }

    @Override
    public void warn(String msg) {
        this.plugin.getLogger().warning(msg);
    }
}
