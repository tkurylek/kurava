package pl.kurylek.utils.tests.assertion;

import static pl.kurylek.utils.tests.assertion.ThrowableAssertions.assertThrowable;

import org.junit.Test;

public class ThrowableAssertionsTest {

    private static final String EXCEPTION_MESSAGE = "Exception message";

    @Test
    public void shouldAssertThatExceptionIsThrown() {
	// when
	Exception exception = new Exception();

	// then
	assertThrowable(exception).isThrown();
    }

    @Test
    public void shouldAssertThatExceptionIsNotThrown() {
	// when
	Exception exception = null;

	// then
	assertThrowable(exception).isNotThrown();
    }

    @Test
    public void shouldAssertThatExceptionHasExpectedMessage() {
	// when
	Exception exception = new Exception(EXCEPTION_MESSAGE);

	// then
	assertThrowable(exception).withMessage(EXCEPTION_MESSAGE).isThrown();
    }
}