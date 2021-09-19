package random.java8;

@java.lang.FunctionalInterface
interface PiValue{
    void getValue();

    static void staticFun(){
        System.out.println("Hello Static");
    }
    default void defaultFun(){
        System.out.println("Hello Default");
    }
}

@java.lang.FunctionalInterface
interface FindSum{
    int sum(int a, int b);
}

@java.lang.FunctionalInterface
interface GenericInterface<T> {
    T justPrint(T t);
}

public class FunctionalInterface {
    public static void main(String[] args) {
        PiValue.staticFun();

        Thread thread = new Thread(new Runnable(){
            @Override
            public void run(){
            System.out.println("Implemented SAM(Single Abstract Method)");
            }
        });
        thread.start();
        lambda1();
        lambda2();
        lambda3();
        lambda4();
    }

    private static void lambda4() {
        GenericInterface<String> genericInterface = (t) -> {
            return t.trim();
        };
        System.out.println(genericInterface.justPrint("Himanshu   Singh      "));
    }

    private static void lambda3() {
        FindSum sum = (a,b) -> {
            a = a+10;
            b = b-10;
            return a+b;
        };
        System.out.println(sum.sum(129,98));
    }

    private static void lambda2() {
        PiValue val = () -> {
            System.out.println("Pi Value = 3.141");
        };
        val.getValue();
    }

    private static void lambda1() {
        new Thread(() -> System.out.println("Lambda 1")).start();
        new Thread(() -> System.out.println("Lambda 2")).start();
    }

}
