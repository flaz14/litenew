package maps;

import org.junit.Test;

import java.util.Map;

import static litenew.Builders.map;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class OneEntryMapTest {

    @Test
    public void whenOneEntryMapIsCreated_itIsNotNull() throws Exception {
        final Map<String, Integer> oneEntryMap = map().entry("A", 65);

        assertNotNull(oneEntryMap);
    }

    @Test
    public void whenOneEntryMapIsCreated_itContainsExactlyOneEntry() throws Exception {
        final Map<String, Integer> oneEntryMap = map().entry("A", 65);

        assertThat(oneEntryMap.size(), is(1));
    }

    @Test
    public void whenOneEntryMapIsCreated_itContainsTheSameEntryAsSpecifiedByParameters() throws Exception {
        final Map<String, Integer> oneEntryMap = map().entry("A", 65);

        final Map.Entry<String, Integer> actualEntry = oneEntryMap.entrySet().iterator().next();
        assertThat(actualEntry.getKey(), equalTo("A"));
        assertThat(actualEntry.getValue(), equalTo(65));
    }

    @Test
    public void oneEntryMapIsGeneric() throws Exception {
        final Map<Integer, String> integerString = map().entry(65, "A");
        final Map<String, Integer> stringInteger = map().entry("A", 65);
        final Map<Boolean, String> booleanString = map().entry(true, "true");

        assertNotNull(integerString);
        assertNotNull(stringInteger);
        assertNotNull(booleanString);
    }
}
