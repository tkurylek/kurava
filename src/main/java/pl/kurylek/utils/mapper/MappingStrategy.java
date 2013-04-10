package pl.kurylek.utils.mapper;

public interface MappingStrategy<S, T> {

    T map(S source);

    S mapReversely(T target);
}