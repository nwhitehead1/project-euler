package runner;

import java.util.concurrent.Callable;

public interface ProjectEulerCallable extends Callable<String> {

    default void printCallableThread() {
        System.out.println("Running: " + this.getClass().getSimpleName() + " -> On Thread: " + Thread.currentThread().getName());
    }
}