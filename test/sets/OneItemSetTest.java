package sets;

import org.junit.Test;

import java.util.Set;

import static litenew.Builders.set;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class OneItemSetTest {

    @Test
    public void whenOneItemSetIsCreated_itIsNotNull() throws Exception {
        final Set<String> oneItemSet = set("A");

        assertNotNull(oneItemSet);
    }

    @Test
    public void whenOneItemSetIsCreated_itContainsExactlyOneItem() throws Exception {
        final Set<String> oneItemSet = set("A");

        assertThat(oneItemSet.size(), is(1));
    }

    @Test
    public void whenOneItemSetIsCreated_itContainsTheSameItemAsSpecifiedByParameter() throws Exception {
        final Set<String> oneItemSet = set("A");

        final String item = oneItemSet.iterator().next();

        assertThat(item, equalTo("A"));
    }

    @Test
    public void moreItemsCanBeAddedToTheOneItemSet() throws Exception {
        final Set<String> oneItemSet = set("String 1");

        oneItemSet.add("String 2");

        assertThat(oneItemSet.size(), equalTo(2));
    }

    @Test
    public void oneItemSetIsGeneric() throws Exception {
        final Set<Integer> integerSet = set(65);
        final Set<String> stringSet = set("String 1");
        final Set<Boolean> booleanSet = set(true);

        assertNotNull(integerSet);
        assertNotNull(stringSet);
        assertNotNull(booleanSet);
    }
}
