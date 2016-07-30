package queues;

import org.junit.Test;

import java.util.Queue;

import static litenew.Builders.queue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author flaz14
 */
public class EmptyQueueTest {
    @Test
    public void emptyQueueIsNotNull() throws Exception {
        final Queue<String> emptyQueue = queue();
        assertNotNull(emptyQueue);
    }

    @Test
    public void emptyQueueIsReallyEmpty() throws Exception {
        final Queue<String> emptyQueue = queue();
        assertTrue(emptyQueue.isEmpty());
    }

    @Test
    public void emptyQueueHaveToBeGeneric() throws Exception {
        final Queue<String> stringQueue = queue();
        assertNotNull(stringQueue);
        final Queue<Integer> integerQueue = queue();
        assertNotNull(integerQueue);
    }

    @Test
    public void itemsCanBeAddedToTheEmptyQueue() throws Exception {
        final Queue<String> emptyQueue = queue();
        emptyQueue.add("String 2");
        assertThat(emptyQueue.size(), is(1));
    }
}
