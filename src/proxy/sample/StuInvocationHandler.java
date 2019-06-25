package proxy.sample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class StuInvocationHandler<T> implements InvocationHandler {
    T target;

    public StuInvocationHandler(T target) {
        this.target = target;
    }

    /**
     *
     * @param proxy 代理的对象
     * @param method 代表正在执行的方法
     * @param args 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行"+method.getName()+"方法");

        MonitorUtil.start();
        Object result = method.invoke(target, args);
        MonitorUtil.finish(method.getName());
        return result;
    }
}
