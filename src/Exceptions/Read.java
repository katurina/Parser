package Exceptions;

/**
 * Created by Bird on 19.03.2017.
 */
public class Read extends Throwable implements AutoCloseable {
    @Override
    public void close() throws Exception {

    }
}
