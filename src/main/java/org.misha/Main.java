package org.misha;

import org.apache.log4j.Logger;

import static org.misha.domain.JsonWritable.GSON;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String... args) {
        log.debug("\n\n\n" + new TestOrderFactory().createTestOrder());
    }
}
