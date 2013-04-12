package pl.kurylek.utils.tests.catcher;

@SuppressWarnings("serial")
class ExceptionCatcherAssertionError extends AssertionError {

    public ExceptionCatcherAssertionError(Class<?> exceptionType, Exception e) {
	super("Expected exception " + exceptionType + " but was " + e.getClass(), e);
    }

    public ExceptionCatcherAssertionError(Class<?> exceptionType) {
	super("Expected exception " + exceptionType + ".");
    }
}