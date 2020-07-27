package helper;

import java.util.concurrent.Future;

public class FutureAssertionHelper<T> {

    private Future<T> future;
    private String assertion;

    public FutureAssertionHelper(Future<T> future, String assertion) {
        this.future = future;
        this.assertion = assertion;
    }

    public Future<T> getFuture() {
        return future;
    }

    public String getAssertion() {
        return assertion;
    }
}
