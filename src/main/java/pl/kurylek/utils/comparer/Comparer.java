package pl.kurylek.utils.comparer;

public interface Comparer<T extends Comparable> {

    boolean areEqual(T first, T second);
}
