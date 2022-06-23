package com.danielraybone.spirit;

public interface SpiritPlugin {
    LoggerAdapter getSpiritLogger();

    ConfigAdapter getSpiritConfig();

    Platform getPlatform();
}
