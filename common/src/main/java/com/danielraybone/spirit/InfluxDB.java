package com.danielraybone.spirit;

import com.influxdb.LogLevel;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;

public class InfluxDB {

    private final SpiritPlugin plugin;
    public final String url;
    public final String token;
    
    public final String org;
    public final String bucket;
    public InfluxDBClient client;
    public WriteApi writeApi;

    public InfluxDB(SpiritPlugin plugin, String url, String token, String org, String bucket) {
        this.plugin = plugin;
        this.url = url;
        this.token = token;
        this.org = org;
        this.bucket = bucket;
    }

    public void connect() {
        this.connect(LogLevel.NONE);
    }

    public void connect(LogLevel logLevel) {
        this.connect(logLevel, true);
    }

    public void connect(LogLevel logLevel, boolean gzip) {
        if (this.client != null) {
            this.plugin.getSpiritLogger().warn("Tried to connect to InfluxDB, connection is already setup.");
            return;
        }

        this.client = InfluxDBClientFactory.create(url, token.toCharArray(), org, bucket);

        if (gzip) this.client.enableGzip();
        this.client.setLogLevel(logLevel);

        this.writeApi = this.client.makeWriteApi();
    }

    public void disconnect() {
        this.client.close();
    }

    public void addEventLog(SpiritEvent event) {
        this.writeApi.writePoint(event.toPoint().toInfluxPoint());
    }
}
