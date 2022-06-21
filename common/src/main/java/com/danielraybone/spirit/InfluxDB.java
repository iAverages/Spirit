package com.danielraybone.spirit;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;

public class InfluxDB {

    public final String url;
    public final String token;
    public final String org;
    public final String bucket;
    public InfluxDBClient client = null;

    public  InfluxDB(String url, String token, String  org, String bucket){
        this.url = url;
        this.token = token;
        this.org = org;
        this.bucket = bucket;
    }

    public void connect() {
//        if (this.client) {
//
//            return;
//        }
        this.client = InfluxDBClientFactory.create(url, token.toCharArray(), org, bucket);
    }

    public void disconnect() {

    }
}
