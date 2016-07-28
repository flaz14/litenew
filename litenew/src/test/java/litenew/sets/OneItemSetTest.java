package litenew.sets;

import org.junit.Test;

import java.util.Set;

import static com.github.flaz14.litenew.Builders.set;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author flaz14
 */
public class OneItemSetTest {
    @Test
    public void oneItemSetIsNotNull() throws Exception {
        final Set<String> oneItemSet = set("A");
        assertNotNull(oneItemSet);
    }

    @Test
    public void oneItemSetContainsExactlyOneItem() throws Exception {
        final Set<String> oneItemSet = set("A");
        assertThat(oneItemSet.size(), is(1));
    }

    @Test
    public void oneItemSetContainsCertainItem() throws Exception {
        final Set<String> oneItemSet = set("A");
        final String item = oneItemSet.iterator().next();
        assertThat(item, is("A"));
    }

    @Test
    public void oneItemSetHaveToBeGeneric() throws Exception {
        final Set<Integer> integerSet = set(65);
        assertNotNull(integerSet);
        final Set<String> stringSet = set("String 1");
        assertNotNull(stringSet);
    }

    @Test
    public void moreItemsCanBeAddedToTheOneItemSet() throws Exception {
        final Set<String> oneItemSet = set("String 1");
        oneItemSet.add("String 2");
        assertThat(oneItemSet.size(), is(2));
    }
}
