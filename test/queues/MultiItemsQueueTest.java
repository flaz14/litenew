package queues;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static litenew.Builders.queue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class MultiItemsQueueTest {

    @Test
    public void equalityExample_forIntegerQueue() throws Exception {
        final Queue<Integer> ordinaryQueue = new ArrayDeque<Integer>();
        ordinaryQueue.add(1);
        ordinaryQueue.add(2);
        ordinaryQueue.add(3);

        final Queue<Integer> testQueue = queue(1, 2, 3);

        // standard queue classes don't implement their own equals() method,
        // equals() from Object class is used.
        // so we don't compare queues itself,
        // but compare arrays which represents each queue.
        assertThat(testQueue.toArray(), equalTo(ordinaryQueue.toArray()));
    }

    @Test
    public void equalityExample_forStringQueue() throws Exception {
        final Queue<String> ordinaryQueue = new ArrayDeque<String>();
        ordinaryQueue.add("String 1");
        ordinaryQueue.add("String 2");
        ordinaryQueue.add("String 3");

        final Queue<String> testQueue = queue("String 1", "String 2", "String 3");

        assertThat(testQueue.toArray(), equalTo(ordinaryQueue.toArray()));
    }

    @Test
    public void moreItemsCanBeAddedToTheMultipleItemsQueue() throws Exception {
        final Queue<String> multiItemsQueue = queue("String 1", "String 2");

        multiItemsQueue.add("String 3");

        assertThat(multiItemsQueue.size(), is(3));
    }

    @Test
    public void multipleItemsQueueIsGeneric() throws Exception {
        final Queue<Integer> integerQueue = queue(1, 2, 3);
        final Queue<String> stringQueue = queue("String 1", "String 2", "String 3");
        final Queue<Boolean> booleanQueue = queue(false, false, true);

        assertNotNull(integerQueue);
        assertNotNull(stringQueue);
        assertNotNull(booleanQueue);
    }
}
