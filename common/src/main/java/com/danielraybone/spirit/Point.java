package com.danielraybone.spirit;

import com.influxdb.client.domain.WritePrecision;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Helper class so influx DB is not needed to be added to very project
 */
public class Point {

    private final String measurementName;
    private final Map<String, Object> fields;
    private final Map<String, String> tags;
    private Instant time;

    public Point(String measurementName) {
        this.fields = new HashMap<>();
        this.tags = new HashMap<>();
        this.measurementName = measurementName;
    }

    public static Point measurement(String measurement) {
        return new Point(measurement);
    }

    public Point addField(String key, Object value) {
        this.fields.put(key, value);
        return this;
    }

    public Point addFields(Map<String, Object> map) {
        this.fields.putAll(map);
        return this;
    }

    public Point addTag(String key, String value) {
        this.tags.put(key, value);
        return this;
    }

    public Point addTags(Map<String, String> map) {
        this.tags.putAll(map);
        return this;
    }

    public Point time(Instant time) {
        this.time = time;
        return this;
    }

    public com.influxdb.client.write.Point toInfluxPoint() {
        return com.influxdb.client.write.Point
                .measurement(this.measurementName)
                .addTags(this.tags)
                .addFields(this.fields)
                .addTag("server", "local")
                .time(this.time, WritePrecision.MS);
    }
}
