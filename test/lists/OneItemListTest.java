package lists;

import org.junit.Test;

import java.util.List;

import static litenew.Builders.list;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class OneItemListTest {
    @Test
    public void whenOneItemListIsCreated_itIsNotNull() throws Exception {
        final List<String> oneItemList = list("A");

        assertNotNull(oneItemList);
    }

    @Test
    public void whenOneItemListIsCreated_itContainsExactlyOneItem() throws Exception {
        final List<String> oneItemList = list("A");

        assertThat(oneItemList.size(), is(1));
    }

    @Test
    public void whenOneItemListIsCreated_itContainsTheSameItemAsSpecifiedByParameter() throws Exception {
        final List<String> oneItemList = list("A");

        final String item = oneItemList.get(0);
        assertThat(item, equalTo("A"));
    }

    @Test
    public void moreItemsCanBeAdded() throws Exception {
        final List<String> oneItemList = list("String 1");

        oneItemList.add("String 2");

        assertThat(oneItemList.size(), is(2));
    }

    @Test
    public void oneItemListIsGeneric() throws Exception {
        final List<Integer> integerList = list(65);
        final List<String> stringList = list("String 1");
        final List<Boolean> booleanList = list(true);

        assertNotNull(stringList);
        assertNotNull(integerList);
        assertNotNull(booleanList);
    }
}
