package pl.kurylek.utils.tests.assertion;

public final class ExceptionAssert {

    private final Throwable throwable;

    ExceptionAssert(Throwable throwable) {
	this.throwable = throwable;
    }

    public ExceptionAssert isNotThrown() {
	if (throwable == null) {
	    return this;
	}
	throw new AssertionError("Expected exception NOT to be thrown.");
    }

    public ExceptionAssert isThrown() {
	if (throwable != null) {
	    return this;
	}
	throw new AssertionError("Expected exception to be thrown.");
    }

    public ExceptionAssert withMessage(String exceptionMessage) {
	if (throwable.getMessage().equals(exceptionMessage)) {
	    return this;
	}
	throw new AssertionError("Expected message [" + exceptionMessage + "] but was ["
		+ throwable.getMessage() + "].");
    }
}