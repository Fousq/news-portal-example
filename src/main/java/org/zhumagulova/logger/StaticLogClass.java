package org.zhumagulova.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Redundant, because it doesn't have any logic for logging
public class StaticLogClass {
    private static final Logger logger = LoggerFactory.getLogger(StaticLogClass.class);

    public StaticLogClass() {
    }

    public Logger getLogger() {
        return logger;
    }
}

