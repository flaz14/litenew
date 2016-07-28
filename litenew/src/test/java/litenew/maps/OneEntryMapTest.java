package litenew.maps;

import java.util.Map;

import static com.github.flaz14.litenew.Builders.map;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * @author flaz14
 */
public class OneEntryMapTest {
    @Test
    public void oneEntryMapIsNotNull() throws Exception {
        final Map<String, Integer> oneEntryMap = map().entry("A", 65);
        assertNotNull(oneEntryMap);
    }

    @Test
    public void oneEntryMapContainsExactlyOneEntry() throws Exception {
        final Map<String, Integer> oneEntryMap = map().entry("A", 65);
        assertThat(oneEntryMap.size(), is(1));
    }

    @Test
    public void oneEntryMapContainsCertainEntry() throws Exception {
        final Map<String, Integer> oneEntryMap = map().entry("A", 65);
        final Map.Entry<String, Integer> actualEntry = oneEntryMap.entrySet().iterator().next();
        assertThat(actualEntry.getKey(), is("A"));
        assertThat(actualEntry.getValue(), is(65));
    }

    @Test
    public void oneEntryMapHaveToBeGeneric() throws Exception {
        final Map<Integer, String> integerStringMap = map().entry(65, "A");
        assertNotNull(integerStringMap);
        final Map<String, Integer> stringIntegerMap = map().entry("A", 65);
        assertNotNull(stringIntegerMap);
    }
}
