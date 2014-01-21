package training;

import training.Buffers.Buffer;
import java.io.*;


/**
 *
 * Reader is the producer part of a producer/consumer pattern
 */
public class Reader implements Runnable {
    
    protected static ObjectInputStream ois; 
    private final Buffer buffer;
     
    protected Reader(Buffer b) throws IOException{
        ois = new ObjectInputStream ( new FileInputStream("serial.bin") );
        buffer = b;
    }
    
    @Override
    public void run() {
        while (true) { // repeat over and over again
            try {
                try {
                    //put an object from the file to the buffer
                    buffer.put(ois.readObject()); 
                } catch (IOException | ClassNotFoundException ex) {
                    // when the end of file is reached, put a corresponding marker
                    buffer.put(new EofMarker());  
                    // and quit the cycle
                    break;
                }
            } catch (InterruptedException ex1) {
                System.err.println(ex1.toString());
            }
        }
    }
    
    /**
     * End of file marker
     */
    public static class EofMarker {}

}
