package sets;

import org.junit.Test;

import java.util.Set;

import static litenew.Builders.set;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EmptySetTest {

    @Test
    public void whenEmptySetIsCreated_itIsNotNull() throws Exception {
        final Set<String> emptySet = set();

        assertNotNull(emptySet);
    }

    @Test
    public void whenEmptySetIsCreated_itIsReallyEmpty() throws Exception {
        final Set<String> emptySet = set();

        assertThat(emptySet.size(), is(0));
    }

    @Test
    public void itemsCanBeAddedToTheEmptySet() throws Exception {
        final Set<String> emptySet = set();

        emptySet.add("String 1");

        assertThat(emptySet.size(), is(1));
    }

    @Test
    public void emptySetIsGeneric() throws Exception {
        final Set<String> stringSet = set();
        final Set<Integer> integerSet = set();
        final Set<Boolean> booleanSet = set();

        assertNotNull(stringSet);
        assertNotNull(integerSet);
        assertNotNull(booleanSet);
    }
}
