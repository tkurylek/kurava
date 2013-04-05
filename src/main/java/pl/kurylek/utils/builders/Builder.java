package pl.kurylek.utils.builders;

import static pl.kurylek.utils.nullsafe.NullSafeUtils.nullSafeToString;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public abstract class Builder<T> {

    private final T builtObject;

    protected Builder(T builtObject) {
	this.builtObject = builtObject;
    }

    protected Builder() {
	builtObject = createObjectFromParametrizedType();
    }

    private T createObjectFromParametrizedType() {
	try {
	    return getClassFromParameterizedType().newInstance();
	} catch (Exception e) {
	    throw new RuntimeException("Cannot create the builder class", e);
	}
    }

    @SuppressWarnings("unchecked")
    private Class<T> getClassFromParameterizedType() {
	return (Class<T>) getParameterizedType().getActualTypeArguments()[0];
    }

    private ParameterizedType getParameterizedType() {
	return (ParameterizedType) getClass().getGenericSuperclass();
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

    protected final T getBuildedObject() {
	return builtObject;
    }

    public final T build() {
	return builtObject;
    }
}