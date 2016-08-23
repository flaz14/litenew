package collections;

import org.junit.Test;

import java.util.Collection;

import static litenew.Builders.collection;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class OneItemCollectionTest {

    @Test
    public void whenOneItemCollectionIsCreated_itIsNotNull() throws Exception {
        final Collection<String> oneItemCollection = collection("String 1");

        assertNotNull(oneItemCollection);
    }

    @Test
    public void whenOneItemCollectionIsCreated_itContainsExactlyOneItem() throws Exception {
        final Collection<String> oneItemCollection = collection("String 1");

        assertThat(oneItemCollection.size(), is(1));
    }

    @Test
    public void whenOneItemCollectionIsCreated_itContainsTheSameItemAsSpecifiedByParameter() throws Exception {
        final Collection<String> oneItemCollection = collection("String 1");

        final String item = oneItemCollection.iterator().next();
        assertThat(item, equalTo("String 1"));
    }

    @Test
    public void itemsCanBeAddedToTheOnItemCollection() throws Exception {
        final Collection<String> oneItemCollection = collection("String 1");

        oneItemCollection.add("String 2");
        oneItemCollection.add("String 3");

        assertThat(oneItemCollection.size(), is(3));
    }

    @Test
    public void oneItemCollectionIsGeneric() throws Exception {
        final Collection<String> stringCollection = collection("String 1");
        final Collection<Integer> integerCollection = collection(65);
        final Collection<Boolean> booleanCollection = collection(true);

        assertNotNull(stringCollection);
        assertNotNull(integerCollection);
        assertNotNull(booleanCollection);
    }
}
