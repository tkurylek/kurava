package pl.kurylek.utils.comparers;

public interface Comparer<T extends Comparable> {

    boolean areEqual(T hulk, T captainAmerica);
}
