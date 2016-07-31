package collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static litenew.Builders.collection;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class MultipleItemsCollectionTest {

    @Test
    public void equalityExample_forStringCollection() throws Exception {
        final Collection<String> ordinaryCollection = new ArrayList<String>();
        ordinaryCollection.add("String 1");
        ordinaryCollection.add("String 2");
        ordinaryCollection.add("String 3");

        final Collection<String> testCollection = collection("String 1", "String 2", "String 3");

        assertThat(testCollection, equalTo(ordinaryCollection));
    }

    @Test
    public void equalityExample_forIntegerCollection() throws Exception {
        final Collection<Integer> ordinaryCollection = new ArrayList<Integer>();
        ordinaryCollection.add(1);
        ordinaryCollection.add(2);
        ordinaryCollection.add(3);

        final Collection<Integer> testCollection = collection(1, 2, 3);

        assertThat(testCollection, equalTo(ordinaryCollection));
    }

    @Test
    public void multipleItemsCollectionIsGeneric() throws Exception {
        final Collection<String> stringCollection = collection("String 1", "String 2", "String 3");
        final Collection<Integer> integerCollection = collection(1, 2, 3);

        assertNotNull(stringCollection);
        assertNotNull(integerCollection);
    }

    @Test
    public void itemsCanBeAdded() throws Exception {
        final Collection<String> multipleItemsCollection = collection("String 1", "String 2");

        multipleItemsCollection.add("String 3");
        multipleItemsCollection.add("String 4");

        assertThat(multipleItemsCollection.size(), is(4));
    }

    @Test
    public void itemsAppearsInCollectionInTheSameOrderAsInParameters() throws Exception {
        final Collection<String> collection = collection("String 1", "String 2", "String 3");

        final Iterator<String> iterator = collection.iterator();
        final String firstItem = iterator.next();
        final String secondItem = iterator.next();
        final String thirdItem = iterator.next();
        assertThat(firstItem, is("String 1"));
        assertThat(secondItem, is("String 2"));
        assertThat(thirdItem, is("String 3"));
    }
}
