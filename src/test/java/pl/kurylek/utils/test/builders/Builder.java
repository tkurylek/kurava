package pl.kurylek.utils.test.builders;

import static pl.kurylek.utils.NullSafeUtils.nullSafeToString;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public abstract class Builder<T> {

    private final T buildedObject;

    protected Builder() {
	buildedObject = createBuildedObject();
    }

    protected Builder(T buildedObject) {
	this.buildedObject = buildedObject;
    }

    public final <V> Builder<T> with(String fieldName, V fieldValue) {
	try {
	    setBuildedObjectField(fieldName, fieldValue);
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
	    throw new WithMethodBindingException(e, fieldName, nullSafeToString(fieldValue));
	}
	return this;
    }

    private <V> void setBuildedObjectField(String fieldName, V fieldValue) throws NoSuchFieldException, IllegalAccessException {
	Field field = buildedObject.getClass().getDeclaredField(fieldName);
	try {
	    field.setAccessible(true);
	    field.set(buildedObject, fieldValue);
	} finally {
	    field.setAccessible(false);
	}
    }

    private T createBuildedObject() {
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

    protected final T getBuildedObject() {
	return buildedObject;
    }

    public final T build() {
	return buildedObject;
    }
}
