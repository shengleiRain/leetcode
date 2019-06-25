package proxy.sample;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class ProxyTest {
    public static void main(String[] args){
        Person zhangsan = new Student("张三");

        InvocationHandler stuHandler= new StuInvocationHandler<>(zhangsan);

        Person proxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class<?>[]{Person.class},stuHandler);

        proxy.provideFee();
    }
}
