package com.danielraybone.spirit;

public interface LoggerAdapter {
    void info(String msg);

    void error(String msg);

    void warn(String msg);
}
