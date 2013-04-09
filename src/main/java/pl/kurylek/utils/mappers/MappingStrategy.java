package pl.kurylek.utils.mappers;

public interface MappingStrategy<S, T> {

    T map(S source);

    S mapReversely(T target);
}