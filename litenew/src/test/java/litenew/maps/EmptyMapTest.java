package litenew.maps;

import java.util.Map;

import static com.github.flaz14.litenew.Builders.map;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author flaz14
 */
public class EmptyMapTest {
    @Test
    public void emptyMapIsNotNull() throws Exception {
        final Map<String, Integer> emptyMap = map();
        assertNotNull(emptyMap);
    }

    @Test
    public void emptyMapIsReallyEmpty() throws Exception {
        final Map<String, Integer> emptyMap = map();
        assertTrue(emptyMap.isEmpty());
    }

    @Test
    public void emptyMapHaveToBeGeneric() throws Exception {
        final Map<String, Integer> stringMap = map();
        assertNotNull(stringMap);
        final Map<String, Integer> integerMap = map();
        assertNotNull(integerMap);
    }
}
