package collections;

import org.junit.Test;

import java.util.Collection;

import static litenew.Builders.collection;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class EmptyCollectionTest {

    @Test
    public void whenEmptyCollectionIsCreated_itIsNotNull() throws Exception {
        final Collection<String> emptyCollection = collection();

        assertNotNull(emptyCollection);
    }

    @Test
    public void whenEmptyCollectionIsCreated_itIsReallyEmpty() throws Exception {
        final Collection<String> emptyCollection = collection();

        assertThat(emptyCollection.size(), is(0));
    }

    @Test
    public void itemsCanBeAddedIntoEmptyCollection() throws Exception {
        final Collection<String> emptyCollection = collection();
        emptyCollection.add("String 1");

        assertThat(emptyCollection.size(), is(1));
    }

    @Test
    public void emptyCollectionIsGeneric() throws Exception {
        final Collection<String> stringCollection = collection();
        final Collection<Integer> integerCollection = collection();
        final Collection<Boolean> booleanCollection = collection();

        assertNotNull(stringCollection);
        assertNotNull(integerCollection);
        assertNotNull(booleanCollection);
    }
}
