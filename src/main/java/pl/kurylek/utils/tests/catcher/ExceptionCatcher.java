package pl.kurylek.utils.tests.catcher;

public class ExceptionCatcher {

    @SuppressWarnings("unchecked")
    public static <E extends Exception> E tryToCatch(Class<E> exceptionType,
	    ThrowableOperation throwableOperation) {
	try {
	    throwableOperation.operate();
	} catch (Exception e) {
	    if (exceptionType.isInstance(e)) {
		return (E) e;
	    }
	    throw new ExceptionCatcherException(exceptionType, e);
	}
	throw new ExceptionCatcherException(exceptionType);
    }
}