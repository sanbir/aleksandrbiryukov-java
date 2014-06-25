package com.noveogroup.java.biryukov.training;

import com.noveogroup.java.biryukov.training.Buffers.Buffer;
import com.noveogroup.java.biryukov.training.Buffers.BufferBlockingQueueAdapter;
import com.noveogroup.java.biryukov.training.Buffers.BufferSyncWN;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The second stage - reading POJOs from file and validation.
 */
final class Stage2 {

    private Stage2() { }

    /**
     *  The second stage - reading POJOs from file and validation.
     */
    public static void stage2() throws IOException {
        /* Receiving user input */
        System.out.println("Would you like to do synchronize-wait-notify [0]"
                + System.lineSeparator()
                + "or java concurrency framework? [1]"
                + System.lineSeparator()
                + "(Default: 0)");
        int n;
        try {
            n = UTF8Scanner.getScanner().nextInt();
        } catch (Exception ex) {
            n = 0;
        }

        /* choice between synchronize-wait-notify and java concurrency framework */
        Buffer buffer;
        if (n == 1) {
            buffer = new BufferBlockingQueueAdapter(new LinkedBlockingQueue());
        } else {
            buffer = new BufferSyncWN();
        }

        final Reader producer = new Reader(buffer);
        final Worker consumer = new Worker(buffer);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

}
