package pl.kurylek.utils.comparer.byId;

import pl.kurylek.utils.comparer.Comparer;

public class CompererById<T extends ComparableById> implements Comparer<T> {

    @Override
    public boolean areEqual(T first, T second) {
	return first.getId().equals(second.getId());
    }
}