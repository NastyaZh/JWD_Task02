package by.tc.task02.entity.exceptions;

public class ServiceExceptions extends Exception{
    public ServiceExceptions() {
        super();
    }

    public ServiceExceptions(String message) {
        super(message);
    }

    public ServiceExceptions(String message, Throwable exc) {
        super(message, exc);
    }

    public ServiceExceptions(Throwable exc) {
        super(exc);
    }
}
