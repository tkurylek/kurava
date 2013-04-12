package pl.kurylek.utils.creator;

@SuppressWarnings("serial")
class InstanceCreationException extends RuntimeException {

    public InstanceCreationException(String message, Throwable cause) {
	super(message, cause);
    }
}