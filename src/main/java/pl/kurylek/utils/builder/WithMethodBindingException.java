package pl.kurylek.utils.builder;

@SuppressWarnings("serial")
class WithMethodBindingException extends RuntimeException {

    public WithMethodBindingException(Exception e, String fieldName, String fieldValue) {
	super("Could not set field " + fieldName + " to value " + fieldValue, e);
    }
}
