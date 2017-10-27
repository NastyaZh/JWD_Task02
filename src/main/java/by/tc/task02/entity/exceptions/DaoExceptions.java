package by.tc.task02.entity.exceptions;

public class DAOExceptions extends Exception{
    
    public DAOExceptions() {
        super();
    }

    public DAOExceptions(String message) {
        super(message);
    }

    public DAOExceptions(String message, Throwable exc) {
        super(message, exc);
    }

    public DAOExceptions(Throwable exc) {
        super(exc);
    }
}
