package sets;

import org.junit.Test;

import java.util.Set;

import static litenew.Builders.set;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author flaz14
 */
public class EmptySetTest {
    @Test
    public void emptySetIsNotNull() throws Exception {
        final Set<String> emptySet = set();
        assertNotNull(emptySet);
    }

    @Test
    public void emptySetIsReallyEmpty() throws Exception {
        final Set<String> emptySet = set();
        assertTrue(emptySet.isEmpty());
    }

    @Test
    public void emptySetHaveToBeGeneric() throws Exception {
        final Set<String> stringSet = set();
        assertNotNull(stringSet);
        final Set<Integer> integerSet = set();
        assertNotNull(integerSet);
    }

    @Test
    public void itemsCanBeAddedToTheEmptySet() throws Exception {
        final Set<String> emptySet = set();
        emptySet.add("String 1");
        assertThat(emptySet.size(), is(1));
    }
}
