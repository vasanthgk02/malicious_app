package java8.util.concurrent;

public class CompletionException extends RuntimeException {
    public static final long serialVersionUID = 7830266012832686185L;

    public CompletionException() {
    }

    public CompletionException(Throwable th) {
        super(th);
    }
}
