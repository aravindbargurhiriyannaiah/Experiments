package com.funkyganesha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class LogWriterImpl implements Writer {
    private static final Logger log = LoggerFactory.getLogger(LogWriterImpl.class);

    public void write(String s) {
        if (log.isDebugEnabled()) {
            log.debug("Writing using a logger [" + s + "]");
        }
    }
}
