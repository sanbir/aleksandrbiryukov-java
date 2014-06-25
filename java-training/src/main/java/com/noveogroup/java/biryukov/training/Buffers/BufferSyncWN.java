package com.noveogroup.java.biryukov.training.Buffers;

/**
 *  Buffer for POJO transmission from Reader to Worker
 * implementing the synchronize-wait-notify approach.
 */
public class BufferSyncWN implements Buffer {
    
    private Object pojo;

    @Override
    public synchronized void put(final Object obj) throws InterruptedException {
        while (pojo != null) {
            wait();
        }
        pojo = obj;
        notify();
    } 

    @Override
    public synchronized Object take() throws InterruptedException {
        while (pojo == null) {
            wait();
        }
        final Object temp = pojo;
        pojo = null;
        notify();
        return temp;
    }
    
}
