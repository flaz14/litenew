package litenew;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * This utility class provides functions which help to create and initialize collections in one line.
 * <p/>
 * Five types of collections are supported:
 * <ol>
 * <li>{@link List}</li>
 * <li>{@link Map}</li>
 * <li>{@link Set}</li>
 * <li>{@link Queue}</li>
 * <li>{@link Collection}</li>
 * </ol>
 * <p/>
 */
public class Builders {

    /**
     * Creates empty list. Returned list is plain {@link java.util.ArrayList}. So items can be added to the list later.
     */
    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    /**
     * Creates list that contains given items. This method is similar to {@link Builders#list()}.
     */
    public static <T> List<T> list(final T... items) {
        // `Arrays.asList()` is great. But that method returns very specific list. For example, it's impossible to add
        // items into such list later. Perhaps, it will be better to return well-known `ArrayList`.
        final List<T> plainList = new ArrayList<T>();
        for (final T item : items)
            plainList.add(item);
        return plainList;
    }

    /**
     * Creates empty set. But returned set is not equal to {@link java.util.Collections#emptySet()} (items can be
     * added to the set later).
     */
    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    public static <T> Set<T> set(final T... items) {
        return new HashSet<T>(Arrays.asList(items));
    }

    public static <T> Queue<T> queue() {
        return new ArrayDeque<T>();
    }

    public static <T> Queue<T> queue(final T... items) {
        return new ArrayDeque<T>(Arrays.asList(items));
    }

    /**
     * Creates empty map. Items can be added to the map later by calling
     * {@link litenew.Builders.MapBuilder#entry(java.lang.Object, java.lang.Object)} method.
     * <p/>
     * Usage scenario of this method:
     * <pre>
     *      Map<String, Integer> emptyMap = map(); // we have empty map here
     * </pre>
     * or
     * <pre>
     *      Map<Integer, String> map = map().
     *                                 entry(1, "String 1").
     *                                 entry(2, "String 2").
     *                                 entry(3, "String 3");   // we have map with three entries here
     * </pre>
     * <p/>
     */
    public static <K, V> MapBuilder<K, V> map() {
        return new MapBuilder<K, V>();
    }

    /**
     * This builder helps to put several entries into map within one chain.
     */
    public static class MapBuilder<K, V> extends HashMap<K, V> {

        /**
         * Pushes entry into the map and returns builder that contains all already existing items and new one. Note that
         * this method returns new instance of builder every time.
         */
        public <K, V> MapBuilder<K, V> entry(final K key, final V value) {
            final MapBuilder<K, V> newMap = new MapBuilder<K, V>(key, value);
            // copy all existing values into new instance of builder
            for (final Map.Entry<?, ?> oldEntry : this.entrySet()) {
                // When `entry()` is called several times within one chain like `map().entry().entry()...`
                // we can be sure that all intermediate maps have the same types of parameters. This is why
                // we eliminate `unchecked` warnings.
                @SuppressWarnings("unchecked")
                final K oldKey = (K) oldEntry.getKey();
                @SuppressWarnings("unchecked")
                final V oldValue = (V) oldEntry.getValue();
                newMap.put(oldKey, oldValue);
            }
            return newMap;
        }

        /**
         * Prohibit instantiating builder outside itself.
         */
        private MapBuilder() {
        }

        private MapBuilder(final K key, final V value) {
            super.put(key, value);
        }
    }

    public static <T> Collection<T> collection() {
        return new ArrayList<T>();
    }

    public static <T> Collection<T> collection(final T... items) {
        return new ArrayList<T>(Arrays.asList(items));
    }

    private Builders() {
        throw new UnsupportedOperationException("Creating instances of utility class is prohibited. Use static methods.");
    }
}
