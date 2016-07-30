import litenew.Builders;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author flaz14
 */
public class BuildersTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void buildersClassCannotBeInstantiated() throws Exception {
        final Constructor<Builders> defaultConstructor = Builders.class.getDeclaredConstructor();
        defaultConstructor.setAccessible(true);
        expectedException.expect(InvocationTargetException.class);
        defaultConstructor.newInstance();
    }
}
