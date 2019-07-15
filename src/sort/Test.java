package sort;

import java.util.*;
import java.util.function.Supplier;

/**
 * @author Rain
 * @date 2019/6/25.
 */
public class Test {
    public static Test create(Supplier<Test> testSupplier) {
        return testSupplier.get();
    }

    private static void aStatic(final String str) {
        System.out.println("static:" + str);
    }

    private void aCommon(String str) {
        System.out.println("common:" + str);
    }

    private void aNoParam() {
        System.out.println("no param");
    }
    public static void main(String[] args) {

        final Test test = Test.create(Test::new);
        final List<Test> tests = Arrays.asList(test);
        tests.forEach(Test::aStatic);

    }

    private static void aStatic(Test test) {
    }
}
