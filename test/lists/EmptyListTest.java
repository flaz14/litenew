package lists;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static litenew.Builders.list;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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
        final List<Integer> integerList = list();
        final List<Boolean> booleanList = list();

        assertNotNull(stringList);
        assertNotNull(integerList);
        assertNotNull(booleanList);
    }

    @Test
    public void emptyListIsPlainArrayList() throws Exception {
        final List<String> list = list();

        final Class implementation = list.getClass();

        assertThat(implementation, CoreMatchers.<Class>is(ArrayList.class));
    }
}


