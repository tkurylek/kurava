package pl.kurylek.utils.builder;

import static pl.kurylek.utils.nullsafe.NullSafeUtils.nullSafeToString;

import java.lang.reflect.Field;

import pl.kurylek.utils.creator.InstanceFromParametrizedTypeCreator;

public abstract class Builder<T> {

    private final T builtObject;
    private final InstanceFromParametrizedTypeCreator instanceFromParametrizedTypeCreator = new InstanceFromParametrizedTypeCreator(getClass());

    protected Builder(T builtObject) {
	this.builtObject = builtObject;
    }

    protected Builder() {
	builtObject = instanceFromParametrizedTypeCreator.createObjectFromParametrizedType();
    }

    public final <V> Builder<T> with(String fieldName, V fieldValue) {
	try {
	    setBuildedObjectField(fieldName, fieldValue);
	} catch (Exception e) {
	    throw new WithMethodBindingException(e, fieldName, nullSafeToString(fieldValue));
	}
	return this;
    }

    private <V> void setBuildedObjectField(String fieldName, V fieldValue) throws NoSuchFieldException,
	    IllegalAccessException {
	Field field = builtObject.getClass().getDeclaredField(fieldName);
	try {
	    field.setAccessible(true);
	    field.set(builtObject, fieldValue);
	} finally {
	    field.setAccessible(false);
	}
    }

    protected final T getBuiltObject() {
	return builtObject;
    }

    public final T build() {
	return builtObject;
    }
}