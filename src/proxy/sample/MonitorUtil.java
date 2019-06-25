package proxy.sample;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class MonitorUtil {
    private static ThreadLocal<Long> t1 = new ThreadLocal<>();

    public static void start(){
        t1.set(System.currentTimeMillis());
    }

    public static void finish(String methodName){
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName+"方法耗时："+(finishTime-t1.get())+"毫秒");
    }
}
