package com.danielraybone.spirit;

public class SpiritCommon {


    public final InfluxDB influx;

    public SpiritCommon(String url, String token, String org, String bucket) {
        this.influx = new InfluxDB(url, token, org, bucket);
    }
}
