package homework;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class TestExecutor {

    private boolean executeTestMethods(Class<?> testClass, Method testMethod, Method beforeMethod, Method afterMethod) throws Exception {

        Object testObject = testClass.getConstructor().newInstance();
        boolean result;

        try{
            if (beforeMethod != null) {
                beforeMethod.invoke(testObject);
            }

            testMethod.invoke(testObject);
            result = true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result = false;
        } finally {
            if (afterMethod != null) {
                afterMethod.invoke(testObject);
            }
        }
        return result;
    }

    public static List<Boolean> runTest(String className) throws Exception {
        TestExecutor testExecutor = new TestExecutor();
        Class<?> testClass =  Class.forName(className);

        log.info("Run test for {}", testClass);
        List<Method> testMethods = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;
        List<Boolean> results = new ArrayList<>();

        for (Method method : testClass.getMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            } else if (method.isAnnotationPresent(Before.class)) {
                beforeMethod = method;
            } else if (method.isAnnotationPresent(After.class)) {
                afterMethod = method;
            }
        }

        for (Method testMethod : testMethods) {
            results.add(testExecutor.executeTestMethods(testClass, testMethod, beforeMethod, afterMethod));
        }

        return results;
    }

    public static void main(String[] args) throws Exception {
        List<Boolean> res = runTest("homework.AnnotationTest");
        long successCount = Collections.frequency(res, true);
        long failCount = Collections.frequency(res, false);

        log.info("Successfully done {} tests. Failed {} tests.", successCount, failCount);
    }
}
