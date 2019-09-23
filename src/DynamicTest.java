import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Rain
 * @date 2019/9/6.
 */
public class DynamicTest {
}

class DataProxy extends Proxy {

    /**
     * Constructs a new {@code Proxy} instance from a subclass
     * (typically, a dynamic proxy class) with the specified value
     * for its invocation handler.
     *
     * @param h the invocation handler for this proxy instance
     * @throws NullPointerException if the given invocation handler, {@code h},
     *                              is {@code null}.
     */
    protected DataProxy(InvocationHandler h) {
        super(h);
    }


}
