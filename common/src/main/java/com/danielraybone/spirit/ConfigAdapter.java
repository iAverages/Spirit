package com.danielraybone.spirit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://github.com/LuckPerms/LuckPerms/blob/master/bukkit/src/main/java/me/lucko/luckperms/bukkit/BukkitConfigAdapter.java
public interface ConfigAdapter {
    void reload();

    default String getString(String path) {
        return this.getString(path, "");
    }


    String getString(String path, String def);

    default int getInteger(String path) {
        return this.getInteger(path, 0);
    }

    int getInteger(String path, int def);

    default boolean getBoolean(String path) {
        return this.getBoolean(path, false);
    }

    boolean getBoolean(String path, boolean def);


    default List<String> getStringList(String path) {
        return this.getStringList(path, new ArrayList<>());
    }

    List<String> getStringList(String path, List<String> def);

    default Map<String, String> getStringMap(String path) {
        return this.getStringMap(path, new HashMap<>());
    }

    Map<String, String> getStringMap(String path, Map<String, String> def);

//    String getString(String path, String def);
//
//    int getInteger(String path);
//
//    int getInteger(String path, int def);
//
//    boolean getBoolean(String path);
//
//    boolean getBoolean(String path, boolean def);
//
//    List<String> getStringList(String path);
//
//    List<String> getStringList(String path, List<String> def);
//
//    Map<String, String> getStringMap(String path);
//
//    Map<String, String> getStringMap(String path, Map<String, String> def);

}
