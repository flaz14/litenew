package queues;

import org.junit.Test;

import java.util.Queue;

import static litenew.Builders.queue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class OneItemQueueTest {

    @Test
    public void whenOneItemQueueIsCreated_itIsNotNull() throws Exception {
        final Queue<String> oneItemQueue = queue("A");

        assertNotNull(oneItemQueue);
    }

    @Test
    public void whenOneItemQueueIsCreated_itContainsExactlyOneItem() throws Exception {
        final Queue<String> oneItemQueue = queue("A");

        assertThat(oneItemQueue.size(), is(1));
    }

    @Test
    public void whenOneItemQueueIsCreated_itContainsTheSameItemAsSpecifiedByParameter() throws Exception {
        final Queue<String> oneItemQueue = queue("A");

        final String item = oneItemQueue.peek();
        assertThat(item, equalTo("A"));
    }

    @Test
    public void moreItemsCanBeAddedToTheOneItemQueue() throws Exception {
        final Queue<String> oneItemQueue = queue("String 1");

        oneItemQueue.add("String 2");

        assertThat(oneItemQueue.size(), is(2));
    }

    @Test
    public void oneItemQueueIsGeneric() throws Exception {
        final Queue<String> stringQueue = queue("A");
        final Queue<Integer> integerQueue = queue(65);
        final Queue<Character> characterQueue = queue('q');

        assertNotNull(stringQueue);
        assertNotNull(integerQueue);
        assertNotNull(characterQueue);
    }
}
