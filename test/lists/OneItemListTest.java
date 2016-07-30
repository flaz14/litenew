package lists;

import org.junit.Test;

import java.util.List;

import static litenew.Builders.list;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author flaz14
 */
public class OneItemListTest {
    @Test
    public void oneItemListIsNotNull() throws Exception {
        final List<String> oneItemList = list("A");
        assertNotNull(oneItemList);
    }

    @Test
    public void oneItemListContainsExactlyOneItem() throws Exception {
        final List<String> oneItemList = list("A");
        assertThat(oneItemList.size(), is(1));
    }

    @Test
    public void oneItemListContainsCertainItem() throws Exception {
        final List<String> oneItemList = list("A");
        final String item = oneItemList.get(0);
        assertThat(item, is("A"));
    }

    @Test
    public void oneItemListHaveToBeGeneric() throws Exception {
        final List<Integer> integerList = list(65);
        assertNotNull(integerList);
        final List<String> stringList = list("String 1");
        assertNotNull(stringList);
    }

    @Test
    public void moreItemsCanBeAddedToTheOneItemList() throws Exception {
        final List<String> oneItemList = list("String 1");
        oneItemList.add("String 2");
        assertThat(oneItemList.size(), is(2));
    }
}
