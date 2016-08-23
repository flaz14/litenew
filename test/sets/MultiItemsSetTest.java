package sets;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static litenew.Builders.set;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class MultiItemsSetTest {

    @Test
    public void equalityExample_forIntegerSet() throws Exception {
        final Set<Integer> ordinarySet = new HashSet<Integer>();
        ordinarySet.add(1);
        ordinarySet.add(2);
        ordinarySet.add(3);

        final Set<Integer> testSet = set(1, 2, 3);

        assertThat(testSet, equalTo(ordinarySet));
    }

    @Test
    public void stringSetsAreEqual() throws Exception {
        final Set<String> ordinarySet = new HashSet<String>();
        ordinarySet.add("String 1");
        ordinarySet.add("String 2");
        ordinarySet.add("String 3");

        final Set<String> testSet = set("String 1", "String 2", "String 3");

        assertThat(testSet, equalTo(ordinarySet));
    }

    @Test
    public void moreItemsCanBeAddedToTheMultipleItemsSet() throws Exception {
        final Set<String> multiItemsSet = set("String 1", "String 2");

        multiItemsSet.add("String 3");

        assertThat(multiItemsSet.size(), is(3));
    }

    @Test
    public void multiItemsSetHaveToBeGeneric() throws Exception {
        final Set<String> stringSet = set("String 1", "String 2", "String 3");
        final Set<Integer> integerSet = set(1, 2, 3);
        final Set<Boolean> booleanSet = set(true, false);

        assertNotNull(stringSet);
        assertNotNull(integerSet);
        assertNotNull(booleanSet);
    }
}
