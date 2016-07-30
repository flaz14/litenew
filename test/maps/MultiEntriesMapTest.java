package maps;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static litenew.Builders.map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author flaz14
 */
public class MultiEntriesMapTest {
    @Test
    public void integerStringMapsAreEqual() throws Exception {
        final Map<Integer, String> ordinaryMap = new HashMap<Integer, String>();
        ordinaryMap.put(1, "String 1");
        ordinaryMap.put(2, "String 2");
        ordinaryMap.put(3, "String 3");
        final Map<Integer, String> map = map().
                entry(1, "String 1").
                entry(2, "String 2").
                entry(3, "String 3");
        assertEquals(ordinaryMap, map);
    }

    @Test
    public void stringIntegerMapsAreEqual() throws Exception {
        final Map<String, Integer> ordinaryMap = new HashMap<String, Integer>();
        ordinaryMap.put("String 1", 1);
        ordinaryMap.put("String 2", 2);
        ordinaryMap.put("String 3", 3);
        final Map<String, Integer> map = map().
                entry("String 1", 1).
                entry("String 2", 2).
                entry("String 3", 3);
        assertEquals(ordinaryMap, map);
    }

    @Test
    public void multiEntriesMapHaveToBeGeneric() throws Exception {
        final Map<String, Integer> stringIntegerMap = map().entry("A", 65).entry("B", 66).entry("C", 67);
        assertNotNull(stringIntegerMap);
        final Map<Integer, String> integerStringMap = map().entry(65, "A").entry(66, "B").entry(67, "C");
        assertNotNull(integerStringMap);
    }
}
