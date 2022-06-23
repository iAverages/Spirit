package com.danielraybone.spirit;

import java.util.List;
import java.util.Map;

// https://github.com/LuckPerms/LuckPerms/blob/master/bukkit/src/main/java/me/lucko/luckperms/bukkit/BukkitConfigAdapter.java
public interface ConfigAdapter {
    void reload();

    String getString(String path);

    String getString(String path, String def);

    int getInteger(String path);

    int getInteger(String path, int def);

    boolean getBoolean(String path);

    boolean getBoolean(String path, boolean def);

    List<String> getStringList(String path);

    List<String> getStringList(String path, List<String> def);

    Map<String, String> getStringMap(String path);

    Map<String, String> getStringMap(String path, Map<String, String> def);

}
