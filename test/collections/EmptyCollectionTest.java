package collections;

import org.junit.Test;

import java.util.Collection;

import static litenew.Builders.collection;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author flaz14
 */
public class EmptyCollectionTest {
    @Test
    public void emptyCollectionIsNotNull() throws Exception {
        final Collection<String> emptyCollection = collection();
        assertNotNull(emptyCollection);
    }

    @Test
    public void emptyCollectionIsReallyEmpty() throws Exception {
        final Collection<String> emptyCollection = collection();
        assertTrue(emptyCollection.isEmpty());
    }

    @Test
    public void emptyCollectionHaveToBeGeneric() throws Exception {
        final Collection<String> stringCollection = collection();
        assertNotNull(stringCollection);
        final Collection<Integer> integerCollection = collection();
        assertNotNull(integerCollection);
    }

    @Test
    public void itemsCanBeAddedToTheEmptyCollection() throws Exception {
        final Collection<String> emptyCollection = collection();
        emptyCollection.add("String 1");
        assertThat(emptyCollection.size(), is(1));
    }
}
