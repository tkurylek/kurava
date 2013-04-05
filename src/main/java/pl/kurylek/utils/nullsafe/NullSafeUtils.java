package pl.kurylek.utils.nullsafe;


public class NullSafeUtils {

    public static String nullSafeToString(Object nullableObject) {
	return (nullableObject == null) ? "" : nullableObject.toString();
    }

    public static <T> T nullSafe(T nullableObject, OnNullBehavior<T> onNullObjectBevior) {
	return (nullableObject == null) ? onNullObjectBevior.onNull() : nullableObject;
    }
}
