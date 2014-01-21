package training.Buffers;

/**
 *  Common interface for both synchronize-wait-notify 
 * and java concurrency framework implementations of
 * the producer/consumer pattern
 */
public interface Buffer {
    public void put(Object obj) throws InterruptedException;
    public Object take() throws InterruptedException;
}
