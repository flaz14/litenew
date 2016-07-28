package litenew.lists;

import java.util.List;

import static com.github.flaz14.litenew.Builders.list;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author flaz14
 */
public class EmptyListTest {
    @Test
    public void emptyListNotNull() throws Exception {
        final List<String> emptyList = list();
        assertNotNull(emptyList);
    }

    @Test
    public void emptyListIsReallyEmpty() throws Exception {
        final List<String> emptyList = list();
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void emptyListHaveToBeGeneric() throws Exception {
        final List<String> stringList = list();
        assertNotNull(stringList);
        final List<String> integerList = list();
        assertNotNull(integerList);
    }

    @Test
    public void moreItemsCanBeAddedToTheEmptyList() throws Exception {
        final List<String> emptyList = list();
        emptyList.add("String 1");
        assertThat(emptyList.size(), is(1));
    }
}


