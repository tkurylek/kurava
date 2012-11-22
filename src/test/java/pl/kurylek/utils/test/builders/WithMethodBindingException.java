package pl.kurylek.utils.test.builders;

@SuppressWarnings("serial")
public class WithMethodBindingException extends RuntimeException {

    public WithMethodBindingException(Exception e, String fieldName, String fieldValue) {
	super("Could not set field " + fieldName + " to value " + fieldValue, e);
    }
}
