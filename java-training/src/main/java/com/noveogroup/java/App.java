package com.noveogroup.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world.
 *
 * @author username
 */
public final class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    private App() {
    }

    /**
     * Enter point in application.
     *
     * @param args application parameters
     */
    public static void main(final String[] args) {
        final String greeting = "Hello World!";
        System.out.println(greeting);
        LOG.info(greeting);
    }
	
	// just to get it built
}
