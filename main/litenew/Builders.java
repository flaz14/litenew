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
 * This utility class provides functions which allow to create and initialize collections in one line.
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
 * The intent of this class is to provide handy methods. Performance, thread safety, etc are not a goals. So use these
 * functions in test code only, not in production.
 */
public class Builders {

    /**
     * Creates empty list. But returned list is not equal to the {@link java.util.Collections#emptyList()}.
     * <p/>
     * Items can be added to the list later.
     */
    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    /**
     * Creates list which contains given items.
     * <p/>
     * Items in the list appear in the same order as in parameters. More items can be added to the list later.
     * <p/>
     * Usage scenario of this method:
     * <code>
     * List<Integer> list = list(1, 2, 3); // we have list with 3 items here
     * </code>
     */
    public static <T> List<T> list(final T... items) {
        return new ArrayList<T>(Arrays.asList(items));
    }

    /**
     * Creates empty set. But returned set is not equal to the {@link java.util.Collections#emptySet()}.
     * Items can be added to the set later.
     */
    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    /**
     * Creates set which contains given items.
     * <p/>
     * Created set is not sorted. There is not guarantee that order of items in the
     * result set will be the same as the order of parameters.
     * <p/>
     * Usage scenario of this method:
     * <code>
     * Set<Integer> set = set(1, 2, 3); // we have set with three items here
     * </code>
     */
    public static <T> Set<T> set(final T... items) {
        return new HashSet<T>(Arrays.asList(items));
    }

    /**
     * Creates empty queue. Items can be added to the queue later.
     * Note that created queue doesn't guarantee any specific
     * order when items have to be peaked.
     */
    public static <T> Queue<T> queue() {
        return new ArrayDeque<T>();
    }

    /**
     * Creates queue which contains given items. More items can be added to the queue later. Note that created queue
     * doesn't guarantee any specific order of peeking items. So the order in which items will be picked from the queue
     * can differ from the order of items in parameters.
     * <p/>
     * Usage scenario of this method:
     * <code>
     * Queue<Integer> queue = queue(1, 2, 3); // we have queue with three items here
     * </code>
     */
    public static <T> Queue<T> queue(final T... items) {
        return new ArrayDeque<T>(Arrays.asList(items));
    }

    /**
     * Creates empty map; items can be added later by calling
     * {@link litenew.Builders.MapBuilder#entry(java.lang.Object, java.lang.Object)} method.
     * <p/>
     * Usage scenario of this method:
     * <pre>
     * {@code
     *      Map<String, Integer> emptyMap = map(); // we have empty map here }      </pre>
     * or
     * <pre>
     * {@code
     *      Map<Integer, String> map = map().
     *                              entry(1, "String 1").
     *                              entry(2, "String 2").
     *                              entry(3, "String 3");   // we have map with
     *                                                      // three entries here } </pre>
     *
     * Created map is not sorted. So the order of entries in the result map can differ
     * from the order of entries in the chain of {@code entry()} calls.
     *
     * @param <K> type of the keys in the map
     * @param <V> type of the values in the map
     */
    public static <K, V> MapBuilder<K, V> map() {
        return new MapBuilder<K, V>();
    }

    /**
     * This class represents map by using {@link java.util.HashMap};
     * more entries can be pushed into the map by using {@code entry()} method.
     *
     * @param <K> type of the keys in the map
     * @param <V> type of the values in the map
     */
    public static class MapBuilder<K, V> extends HashMap<K, V> {

        /**
         * Pushes entry into the map and returns map which contains all
         * previously pushed entries and new one.
         * <p/>
         * The object on which method called doesn't change.
         * On each call of this method new {@link MapBuilder} instance
         * created and returned as result.
         * The result map contains all items including new one.
         *
         * @param key   key of the entry
         * @param value value of the entry
         * @param <K>   type of the key
         * @param <V>   type of the value
         */
        public <K, V> MapBuilder<K, V> entry(final K key, final V value) {
            // copy all values from this map into the new map
            final MapBuilder<K, V> newMap = new MapBuilder<K, V>(key, value);
            for (final Map.Entry<?, ?> oldEntry : this.entrySet()) {
                // when the entry() called in one chain like map().entry().entry()...
                // we are sure that all intermediate maps have the
                // same types of parameters; so we can eliminate warnings
                @SuppressWarnings("unchecked")
                final K oldKey = (K) oldEntry.getKey();
                @SuppressWarnings("unchecked")
                final V oldValue = (V) oldEntry.getValue();
                newMap.put(oldKey, oldValue);
            }
            return newMap;
        }

        // prohibit creations instances outside Builders class
        private MapBuilder() {
        }

        // creates instance with one entry
        private MapBuilder(final K key, final V value) {
            super.put(key, value);
        }
    }

    /**
     * Creates empty collection. Items can be added to created collection later.
     */
    public static <T> Collection<T> collection() {
        return new ArrayList<T>();
    }

    /**
     * Creates collection that contains given items.
     * Created collection contains items in the same order as listed in parameters.
     * <p/>
     * Usage scenario of this method:
     * <pre>
     * {@code
     *      Collection<String> collection = collection("String 1", "String 2", "String 3"); }
     * </pre>
     *
     * @param items items of the collection
     * @param <T>   type of the items in collection
     */
    public static <T> Collection<T> collection(final T... items) {
        return new ArrayList<T>(Arrays.asList(items));
    }

    // prohibit creation instances of utility class
    private Builders() {
        throw new UnsupportedOperationException("Creating instances of utility class is prohibited.");
    }
}
