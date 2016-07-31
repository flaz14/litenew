package lists;

import org.junit.Test;

import java.util.List;

import static litenew.Builders.list;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EmptyListTest {

    @Test
    public void whenEmptyListIsCreated_itIsNotNull() throws Exception {
        final List<String> emptyList = list();

        assertNotNull(emptyList);
    }

    @Test
    public void whenEmptyListIsCreated_itIsReallyEmpty() throws Exception {
        final List<String> emptyList = list();

        assertThat(emptyList.size(), is(0));
    }

    @Test
    public void moreItemsCanBeAddedIntoTheEmptyList() throws Exception {
        final List<String> emptyList = list();

        emptyList.add("String 1");

        assertThat(emptyList.size(), is(1));
    }

    @Test
    public void emptyListIsGeneric() throws Exception {
        final List<String> stringList = list();
        final List<String> integerList = list();
        final List<Boolean> booleanList = list();

        assertNotNull(stringList);
        assertNotNull(integerList);
        assertNotNull(booleanList);
    }
}


