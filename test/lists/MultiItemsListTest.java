package lists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static litenew.Builders.list;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class MultiItemsListTest {

    @Test
    public void equalityExample_forIntegerList() throws Exception {
        final List<Integer> ordinaryList = new ArrayList<Integer>();
        ordinaryList.add(1);
        ordinaryList.add(2);
        ordinaryList.add(3);

        final List<Integer> testList = list(1, 2, 3);

        assertThat(testList, is(ordinaryList));
    }

    @Test
    public void equalityExample_forStringList() throws Exception {
        final List<String> ordinaryList = new ArrayList<String>();
        ordinaryList.add("String 1");
        ordinaryList.add("String 2");
        ordinaryList.add("String 3");

        final List<String> testList = list("String 1", "String 2", "String 3");

        assertThat(testList, is(ordinaryList));
    }

    @Test
    public void moreItemsCanBeAddedToTheMultiItemsList() throws Exception {
        final List<String> multiItemsList = list("String 1", "String 2");
        multiItemsList.add("String 3");
        assertThat(multiItemsList.size(), is(3));
    }

    @Test
    public void itemsInTheListAreInTheSameOrderAsInParameters() throws Exception {
        final List<String> list = list("String 1", "String 2", "String 3");
        final Iterator<String> iterator = list.iterator();
        final String firstItem = iterator.next();
        final String secondItem = iterator.next();
        final String thirdItem = iterator.next();
        assertThat(firstItem, is("String 1"));
        assertThat(secondItem, is("String 2"));
        assertThat(thirdItem, is("String 3"));
    }

    @Test
    public void multipleItemsListIsGeneric() throws Exception {
        final List<String> stringList = list("String 1", "String 2", "String 3");
        final List<Integer> integerList = list(1, 2, 3);
        final List<Boolean> booleanList = list(true, false, true);

        assertNotNull(stringList);
        assertNotNull(integerList);
        assertNotNull(booleanList);
    }
}
