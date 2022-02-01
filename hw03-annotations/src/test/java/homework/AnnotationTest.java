package homework;

import lombok.extern.slf4j.Slf4j;

public class AnnotationTest {

    @Before
    public void beforeTest(){
        System.out.println("Running before test.");
    }

    @After
    public void afterTest(){
        System.out.println("Running after test.");
    }

    @Test
    public void annotationTest1(){
        System.out.println("Running test 1.");
    }

    @Test
    public void annotationTest2(){
        System.out.println("Running test 2.");
        //throw new RuntimeException("Exception during test 2.");
    }

    @Test
    public void annotationTest3(){
        System.out.println("Running test 3.");
        //throw new RuntimeException("Exception during test 3.");
    }

    @Test
    public void annotationTest4(){
        System.out.println("Running test 4.");
        //throw new RuntimeException("Exception during test 4.");
    }

    @Test
    public void annotationTest5(){
        System.out.println("Running test 5.");
    }
}
