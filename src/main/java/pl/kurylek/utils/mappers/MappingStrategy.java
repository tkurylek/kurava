package pl.kurylek.utils.mappers;

public interface MappingStrategy<S, T> {

    void map(S source, T target);
}
