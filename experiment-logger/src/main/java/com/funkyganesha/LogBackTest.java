package com.funkyganesha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBackTest {
    private static final Logger log = LoggerFactory.getLogger(LogBackTest.class);
    //https://wiki.base22.com/display/btg/How+to+setup+SLF4J+and+LOGBack+in+a+web+app+-+fast

    public static void main(String[] args) {
        log.debug("Hello world - debug");
        log.error("Hello world - error");
        log.warn("Hello world - warn");
        log.trace("Hello world - trace");
        log.info("Hello world - info");

    }
}
