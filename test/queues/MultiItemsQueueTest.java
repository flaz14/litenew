package queues;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static litenew.Builders.queue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * @author flaz14
 */
public class MultiItemsQueueTest {
    @Test
    public void integerQueuesAreEqual() throws Exception {
        final Queue<Integer> ordinaryQueue = new ArrayDeque<Integer>();
        ordinaryQueue.add(1);
        ordinaryQueue.add(2);
        ordinaryQueue.add(3);

        final Queue<Integer> queue = queue(1, 2, 3);
        // standard queue classes don't implement their own equals() method,
        // equals() from Object class is used.
        // so we don't compare queues itself,
        // but compare arrays which represents each queue.
        assertArrayEquals(ordinaryQueue.toArray(), queue.toArray());
    }

    @Test
    public void stringQueuesAreEqual() throws Exception {
        final Queue<String> ordinaryQueue = new ArrayDeque<String>();
        ordinaryQueue.add("String 1");
        ordinaryQueue.add("String 2");
        ordinaryQueue.add("String 3");

        final Queue<String> queue = queue("String 1", "String 2", "String 3");
        assertArrayEquals(ordinaryQueue.toArray(), queue.toArray());
    }

    @Test
    public void multiItemsQueueHaveToBeGeneric() throws Exception {
        final Queue<Integer> integerQueue = queue(1, 2, 3);
        assertNotNull(integerQueue);
        final Queue<String> stringQueue = queue("String 1", "String 2", "String 3");
        assertNotNull(stringQueue);
    }

    @Test
    public void moreItemsCanBeAddedToTheMultiItemsQueue() throws Exception {
        final Queue<String> multiItemsQueue = queue("String 1", "String 2");
        multiItemsQueue.add("String 3");
        assertThat(multiItemsQueue.size(), is(3));
    }
}
