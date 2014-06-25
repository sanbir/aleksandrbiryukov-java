package com.noveogroup.java.biryukov.training.Buffers;

/**
 *  Common interface for both synchronize-wait-notify 
 * and java concurrency framework implementations of
 * the producer/consumer pattern.
 */
public interface Buffer {
    void put(Object obj) throws InterruptedException;
    Object take() throws InterruptedException;
}
