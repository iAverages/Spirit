package com.danielraybone.spirit;

public class SpiritCommon {


    public final InfluxDB influx;

    public SpiritCommon(SpiritPlugin plugin, String url, String token, String org, String bucket) {
        this.influx = new InfluxDB(plugin, url, token, org, bucket);
    }
}
