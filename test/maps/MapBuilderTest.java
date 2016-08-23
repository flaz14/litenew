package maps;

import litenew.Builders;
import org.junit.Test;

import static litenew.Builders.map;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;

public class MapBuilderTest {
    @Test
    public void entryMethodReturnsNewBuilderInstance_everyTimeItIsCalled() throws Exception {
        final Builders.MapBuilder<Integer, String> firstBuilder = map().entry(1, "String 1");
        final Builders.MapBuilder<Integer, String> secondBuilder = firstBuilder.entry(2, "String 2");

        assertThat(secondBuilder, not(equalTo(firstBuilder)));
        assertThat(secondBuilder, not(sameInstance(firstBuilder)));
    }

    @Test
    public void entryMethodDoesNotPutItemIntoOriginalBuilder() throws Exception {
        final Builders.MapBuilder<Integer, String> originalBuilder = map().entry(1, "String 1");
        originalBuilder.entry(2, "String 2");

        assertThat(originalBuilder.size(), is(1));
    }
}
