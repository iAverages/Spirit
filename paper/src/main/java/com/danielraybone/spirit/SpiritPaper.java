package com.danielraybone.spirit;

import com.danielraybone.spirit.adapter.PaperConfigAdapter;
import com.danielraybone.spirit.adapter.PaperLoggerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class SpiritPaper extends JavaPlugin implements SpiritPlugin {

    public SpiritCommon common;
    public PaperConfigAdapter configAdapter;
    public PaperLoggerAdapter loggerAdapter;

    @Override
    public void onEnable() {
        this.configAdapter = new PaperConfigAdapter(this.getConfigFile());
        this.loggerAdapter = new PaperLoggerAdapter(this);

        String url = this.getSpiritConfig().getString("influx.host", "");
        String token = this.getSpiritConfig().getString("influx.token", "");
        String org = this.getSpiritConfig().getString("influx.org", "");
        String bucket = this.getSpiritConfig().getString("influx.bucket", "");
        this.getSpiritLogger().info(url);
        this.getSpiritLogger().info(org);
        if (url.equals("") || token.equals("") || org.equals("") || bucket.equals("")) {
            this.getSpiritLogger().error("Not setup, please ensure all config variables are set");
            this.getSpiritLogger().error("Plugin will now be disabled");
            this.setEnabled(false);
            return;
        }
        this.common = new SpiritCommon(this, url, token, org, bucket);
        this.common.influx.connect();

    }


    @Override
    public void onDisable() {
        if (this.common != null) {
            this.common.influx.disconnect();
        }
        HandlerList.unregisterAll(this);
        Bukkit.getScheduler().cancelTasks(this);
    }

    private File getConfigFile() {
        File file = new File(this.getDataFolder(), "config.yml");
        if (!file.exists())
            this.saveResource("config.yml", false);
        return file;
    }

    @Override
    public LoggerAdapter getSpiritLogger() {
        return this.loggerAdapter;
    }

    @Override
    public ConfigAdapter getSpiritConfig() {
        return this.configAdapter;
    }

    @Override
    public Platform getPlatform() {
        return Platform.PAPER;
    }
}