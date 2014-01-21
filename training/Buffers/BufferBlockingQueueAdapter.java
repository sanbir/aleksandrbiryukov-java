package training.Buffers;

import java.util.concurrent.BlockingQueue; 

/**
 *  This class allows to use BlockingQueue with the same
 * interface as a handwritten buffer 
 */
public class BufferBlockingQueueAdapter implements Buffer {
    
    BlockingQueue queue;

    public BufferBlockingQueueAdapter(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void put(Object e) throws InterruptedException {
        queue.put(e);
    }

    @Override
    public Object take() throws InterruptedException {
        return queue.take();
    }

}
