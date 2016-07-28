package litenew.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static com.github.flaz14.litenew.Builders.collection;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author flaz14
 */
public class MultiItemsCollectionTest {
    @Test
    public void stringCollectionsAreEqual() throws Exception {
        final Collection<String> ordinaryCollection = new ArrayList<String>();
        ordinaryCollection.add("String 1");
        ordinaryCollection.add("String 2");
        ordinaryCollection.add("String 3");

        final Collection<String> collection = collection("String 1", "String 2", "String 3");
        assertEquals(ordinaryCollection, collection);
    }

    @Test
    public void integerCollectionsAreEqual() throws Exception {
        final Collection<Integer> ordinaryCollection = new ArrayList<Integer>();
        ordinaryCollection.add(1);
        ordinaryCollection.add(2);
        ordinaryCollection.add(3);

        final Collection<Integer> collection = collection(1, 2, 3);
        assertEquals(ordinaryCollection, collection);
    }

    @Test
    public void multiItemsCollectionHaveToBeGeneric() throws Exception {
        final Collection<String> stringCollection = collection("String 1", "String 2", "String 3");
        assertNotNull(stringCollection);
        final Collection<Integer> integerCollection = collection(1, 2, 3);
        assertNotNull(integerCollection);
    }

    @Test
    public void itemsCanBeAddedToTheMultiItemsCollection() throws Exception {
        final Collection<String> multiItemsCollection = collection("String 1", "String 2");
        multiItemsCollection.add("String 3");
        assertThat(multiItemsCollection.size(), is(3));
    }

    @Test
    public void itemsInTheCollectionAreInTheSameOrderAsInParameters() throws Exception {
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
