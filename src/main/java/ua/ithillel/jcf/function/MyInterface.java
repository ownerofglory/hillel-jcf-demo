package ua.ithillel.jcf.function;

public interface MyInterface {
    void doSomething();

    static void printSomething() {
        System.out.println("Something");
    }

    default void doSomethingElse() {
        doSomething();

        System.out.println("Doing something else");
    }
}
