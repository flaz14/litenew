package maps;

import litenew.Builders;
import org.junit.Test;

import static litenew.Builders.map;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;

/**
 * @author flaz14
 */
public class MapBuilderTest {
    @Test
    public void entryMethodReturnsNewBuilderInstanceWhenCalled() throws Exception {
        final Builders.MapBuilder<Integer, String> firstBuilder = map().entry(1, "String 1");
        final Builders.MapBuilder<Integer, String> secondBuilder = firstBuilder.entry(2, "String 2");
        assertFalse(firstBuilder.equals(secondBuilder));
        assertNotSame(firstBuilder, secondBuilder);
    }

    @Test
    public void entryMethodDoesNotChangeOriginalBuilder() throws Exception {
        final Builders.MapBuilder<Integer, String> builder = map().entry(1, "String 1");
        builder.entry(2, "String 2");
        assertThat(builder.size(), is(1));
    }
}
