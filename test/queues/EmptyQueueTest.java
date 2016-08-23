package queues;

import org.junit.Test;

import java.util.Queue;

import static litenew.Builders.queue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class EmptyQueueTest {

    @Test
    public void whenEmptyQueueIsCreated_itIsNotNull() throws Exception {
        final Queue<String> emptyQueue = queue();

        assertNotNull(emptyQueue);
    }

    @Test
    public void whenEmptyQueueIsCreated_itIsReallyEmpty() throws Exception {
        final Queue<String> emptyQueue = queue();

        assertThat(emptyQueue.size(), is(0));
    }

    @Test
    public void itemsCanBeAddedToTheEmptyQueue() throws Exception {
        final Queue<String> emptyQueue = queue();
        emptyQueue.add("String 2");
        assertThat(emptyQueue.size(), is(1));
    }

    @Test
    public void emptyQueueHaveToBeGeneric() throws Exception {
        final Queue<String> stringQueue = queue();
        final Queue<Integer> integerQueue = queue();
        final Queue<Character> characterQueue = queue();

        assertNotNull(stringQueue);
        assertNotNull(integerQueue);
        assertNotNull(characterQueue);
    }
}
