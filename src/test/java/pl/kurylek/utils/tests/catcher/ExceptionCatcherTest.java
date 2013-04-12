package pl.kurylek.utils.tests.catcher;

import static pl.kurylek.utils.tests.assertion.ThrowableAssertions.assertThrowable;
import static pl.kurylek.utils.tests.catcher.ExceptionCatcher.tryToCatch;

import org.junit.Test;

public class ExceptionCatcherTest {

    @SuppressWarnings("serial")
    class ExpectedException extends Exception {
    }

    @SuppressWarnings("serial")
    class OtherException extends Exception {
    }

    @Test
    public void shouldTryToCatchAnException() {
	// when
	ExpectedException caughtException = tryToCatch(ExpectedException.class, new ThrowableOperation() {

	    @Override
	    public void operate() throws Exception {
		operationThatWillThrowException();
	    }
	});

	// then
	assertThrowable(caughtException).isThrown();
    }

    private void operationThatWillThrowException() throws ExpectedException {
	throw new ExpectedException();
    }

    @Test
    public void shouldThrowExceptionWhenNothingWasCaught() {
	// when
	ExceptionCatcherAssertionError caughtException = null;
	try {
	    tryToCatch(ExpectedException.class, new ThrowableOperation() {

		@Override
		public void operate() throws Exception {
		    operationThatWillNotThrowAnyException();
		}
	    });
	} catch (ExceptionCatcherAssertionError e) {
	    caughtException = e;
	}

	// then
	assertThrowable(caughtException).isThrown();
    }

    private void operationThatWillNotThrowAnyException() {
    }

    @Test
    public void shouldThrowExceptionWhenCaughtExceptionWasDifferentThanExpected() {
	// when
	ExceptionCatcherAssertionError caughtException = null;
	try {
	    tryToCatch(ExpectedException.class, new ThrowableOperation() {

		@Override
		public void operate() throws Exception {
		    operationThatWillThrowOtherException();
		}
	    });
	} catch (ExceptionCatcherAssertionError e) {
	    caughtException = e;
	}

	// then
	assertThrowable(caughtException).isThrown();
    }

    private void operationThatWillThrowOtherException() throws Exception {
	throw new OtherException();
    }
}