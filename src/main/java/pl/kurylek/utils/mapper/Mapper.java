package pl.kurylek.utils.mapper;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public abstract class Mapper<S, T> {

    public List<T> map(Collection<S> sources) {
	List<T> targets = new LinkedList<>();
	for (S source : sources) {
	    targets.add(map(source));
	}
	return targets;
    }

    public T map(S source) {
	return getMappingStrategy().map(source);
    }

    public List<S> mapReversely(Collection<T> targets) {
	List<S> sources = new LinkedList<>();
	for (T target : targets) {
	    sources.add(mapReversely(target));
	}
	return sources;
    }

    public S mapReversely(T target) {
	return getMappingStrategy().mapReversely(target);
    }

    protected abstract MappingStrategy<S, T> getMappingStrategy();
}