package exception;

import java.io.IOException;

/**
 * Created by Bird on 19.03.2017.
 */
public class ReadException extends IOException {

    public ReadException(){}
    public ReadException(String message){
        super(message);
    }
    public ReadException(String message,Throwable cause){
        super(message,cause);
    }
    public ReadException(Throwable cause){
        super(cause);
    }

}
