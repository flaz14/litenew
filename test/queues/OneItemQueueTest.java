package queues;

import org.junit.Test;

import java.util.Queue;

import static litenew.Builders.queue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author flaz14
 */
public class OneItemQueueTest {
    @Test
    public void oneItemQueueIsNotNull() throws Exception {
        final Queue<String> oneItemQueue = queue("A");
        assertNotNull(oneItemQueue);
    }

    @Test
    public void oneItemQueueContainsExactlyOneItem() throws Exception {
        final Queue<String> oneItemQueue = queue("A");
        assertThat(oneItemQueue.size(), is(1));
    }

    @Test
    public void oneItemQueueContainsCertainItem() throws Exception {
        final Queue<String> oneItemQueue = queue("A");
        final String item = oneItemQueue.peek();
        assertThat(item, is("A"));
    }

    @Test
    public void oneItemQueueHaveToBeGeneric() throws Exception {
        final Queue<String> stringQueue = queue("A");
        assertNotNull(stringQueue);
        final Queue<Integer> integerQueue = queue(65);
        assertNotNull(integerQueue);
    }

    @Test
    public void moreItemsCanBeAddedToTheOneItemQueue() throws Exception {
        final Queue<String> oneItemQueue = queue("String 1");
        oneItemQueue.add("String 2");
        assertThat(oneItemQueue.size(), is(2));
    }
}
