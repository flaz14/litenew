import litenew.Builders;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.hamcrest.CoreMatchers.isA;
import static org.junit.rules.ExpectedException.none;

public class BuildersTest {

    @Rule
    public final ExpectedException expectedException = none();

    @Test
    public void buildersClassCannotBeInstantiated() throws Exception {
        final Constructor<Builders> defaultConstructor = Builders.class.getDeclaredConstructor();
        defaultConstructor.setAccessible(true);

        expectedException.expect(InvocationTargetException.class);
        expectedException.expectCause(isA(UnsupportedOperationException.class));
        defaultConstructor.newInstance();
    }
}
