package ua.ithillel.jcf.generic;

public class ContainerUtil {
    public static <V> Container<V> createContainer(V value) {
        return new Container<>(value);
    }

    public static <T> Container<T> createEmptyContainer() {
        return new Container<>(null);
    }

    public static <K, V> void someMethod(K key, V val) {

    }

    public static <V> void processContainer(Container<V> container) {

    }


}
