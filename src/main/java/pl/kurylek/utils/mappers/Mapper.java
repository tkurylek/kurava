package pl.kurylek.utils.mappers;

import java.lang.reflect.ParameterizedType;

public abstract class Mapper<S, T> {

    public T map(S source) {
	T target = createObjectFromParametrizedType();
	getMappingStrategy().map(source, target);
	return target;
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
	return (Class<T>) getParameterizedType().getActualTypeArguments()[1];
    }

    private ParameterizedType getParameterizedType() {
	return (ParameterizedType) getClass().getGenericSuperclass();
    }

    protected abstract MappingStrategy<S, T> getMappingStrategy();
}