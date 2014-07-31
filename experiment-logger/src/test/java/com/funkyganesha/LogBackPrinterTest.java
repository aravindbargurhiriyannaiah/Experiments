package com.funkyganesha;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by barga009 on 7/30/14 at 9:59 PM. Comment {"$EXPR$"}
 */
public class LogBackPrinterTest {
    private static final Logger log = LoggerFactory.getLogger(LogBackPrinterTest.class);

    @Test
    public void test() {
        log.debug("Printing from debug");
        log.error("Printing from error");
        log.warn("Printing from warn");
        log.trace("Printing from trace");
        log.info("Printing from info");
        log.info("Printing from fine");

    }
}
