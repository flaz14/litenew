package collections;

import litenew.Builders;
import org.junit.Test;

import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author flaz14
 */
public class OneItemCollectionTest {
    @Test
    public void oneItemCollectionIsNotNull() throws Exception {
        final Collection<String> oneItemCollection = Builders.collection("String 1");
        assertNotNull(oneItemCollection);
    }

    @Test
    public void oneItemCollectionContainsExactlyOneItem() throws Exception {
        final Collection<String> oneItemCollection = Builders.collection("String 1");
        assertThat(oneItemCollection.size(), is(1));
    }

    @Test
    public void oneItemCollectionContainsCertainItem() throws Exception {
        final Collection<String> oneItemCollection = Builders.collection("String 1");
        final String item = oneItemCollection.iterator().next();
        assertThat(item, is("String 1"));
    }

    @Test
    public void oneItemCollectionHaveToBeGeneric() throws Exception {
        final Collection<String> stringCollection = Builders.collection("String 1");
        assertNotNull(stringCollection);
        final Collection<Integer> integerCollection = Builders.collection(65);
        assertNotNull(integerCollection);
    }

    @Test
    public void itemsCanBeAddedToTheOnItemCollection() throws Exception {
        final Collection<String> oneItemCollection = Builders.collection("String 1");
        oneItemCollection.add("String 2");
        assertThat(oneItemCollection.size(), is(2));
    }
}
