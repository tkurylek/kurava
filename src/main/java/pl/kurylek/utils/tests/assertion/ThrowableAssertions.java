package pl.kurylek.utils.tests.assertion;

public class ThrowableAssertions {

    public static ExceptionAssert assertThrowable(Throwable throwable) {
	return new ExceptionAssert(throwable);
    }
}