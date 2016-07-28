package litenew.sets;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static com.github.flaz14.litenew.Builders.set;
import static org.junit.Assert.assertNotNull;

/**
 * @author flaz14
 */
public class MultiItemsSetTest {
    @Test
    public void integerSetsAreEqual() throws Exception {
        final Set<Integer> ordinarySet = new HashSet<Integer>();
        ordinarySet.add(1);
        ordinarySet.add(2);
        ordinarySet.add(3);

        final Set<Integer> set = set(1, 2, 3);
        assertEquals(ordinarySet, set);
    }

    @Test
    public void stringSetsAreEqual() throws Exception {
        final Set<String> ordinarySet = new HashSet<String>();
        ordinarySet.add("String 1");
        ordinarySet.add("String 2");
        ordinarySet.add("String 3");

        final Set<String> set = set("String 1", "String 2", "String 3");
        assertEquals(ordinarySet, set);
    }

    @Test
    public void multiItemsSetHaveToBeGeneric() throws Exception {
        final Set<String> stringSet = set("String 1", "String 2", "String 3");
        assertNotNull(stringSet);
        final Set<Integer> integerSet = set(1, 2, 3);
        assertNotNull(integerSet);
    }

    @Test
    public void moreItemsCanBeAddedToTheMultiItemsSet() throws Exception {
        final Set<String> multiItemsSet = set("String 1", "String 2");
        multiItemsSet.add("String 3");
        assertThat(multiItemsSet.size(), is(3));
    }
}
