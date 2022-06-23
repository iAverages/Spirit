package com.danielraybone.spirit;

import com.danielraybone.spirit.adapter.VelocityConfigAdapter;
import com.danielraybone.spirit.adapter.VelocityLoggerAdapter;
import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import lombok.Getter;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Plugin(
        id = "spirit",
        name = "Spirit",
        description = "Spirit Event Logger",
        url = "https://github.com/iAverages/Spirit",
        version = "@version@",
        authors = {"dan"}
)
public class SpiritVelocity implements SpiritPlugin {

    @Inject
    @Getter
    private ProxyServer proxy;
    @Inject
    @Getter
    private Logger logger;
    @Inject
    @Getter
    @DataDirectory
    private Path configPath;

    private VelocityLoggerAdapter spiritLogger;
    private VelocityConfigAdapter config;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        this.spiritLogger = new VelocityLoggerAdapter(this);
        this.config = this.setupConfig();
        this.getLogger().info(configPath.toString());
        this.getSpiritLogger().info("Velo config test: " + this.getSpiritConfig().getString("influx.host", "not found"));
    }

    private VelocityConfigAdapter setupConfig() {
        File folder = this.configPath.toFile();
        File file = new File(folder, "config.yml");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        if (!file.exists()) {
            try (InputStream input = this.getClass().getResourceAsStream("/" + file.getName())) {
                if (input != null) {
                    Files.copy(input, file.toPath());
                } else {
                    throw new RuntimeException("Failed to save default config.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.yml");
        if (inputStream == null) {
            this.getLogger().error("Failed to load config.yml from resources.");
            return null;
        }

        return new VelocityConfigAdapter(file.toPath());
    }

    @Override
    public LoggerAdapter getSpiritLogger() {
        return this.spiritLogger;
    }

    @Override
    public ConfigAdapter getSpiritConfig() {
        return this.config;
    }

    @Override
    public Platform getPlatform() {
        return Platform.VELOCITY;
    }
}