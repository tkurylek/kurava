package pl.kurylek.utils.tests.catcher;

@SuppressWarnings("serial")
public class ExceptionCatcherException extends RuntimeException {

    public ExceptionCatcherException(Class<?> exceptionType, Exception e) {
	super("Expected exception " + exceptionType + " but was " + e.getClass(), e);
    }

    public ExceptionCatcherException(Class<?> exceptionType) {
	super("Expected exception " + exceptionType + ".");
    }
}