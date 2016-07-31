package maps;

import org.junit.Test;

import java.util.Map;

import static litenew.Builders.map;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EmptyMapTest {

    @Test
    public void whenEmptyMapIsCreated_itIsNotNull() throws Exception {
        final Map<String, Integer> emptyMap = map();

        assertNotNull(emptyMap);
    }

    @Test
    public void whenEmptyMapIsCreated_itIsReallyEmpty() throws Exception {
        final Map<String, Integer> emptyMap = map();

        assertThat(emptyMap.size(), is(0));
    }

    @Test
    public void emptyMapIsGeneric() throws Exception {
        final Map<String, Integer> stringMap = map();
        final Map<Integer, Integer> integerMap = map();
        final Map<Integer, Boolean> mixedMap = map();

        assertNotNull(stringMap);
        assertNotNull(integerMap);
        assertNotNull(mixedMap);
    }
}
