package retrofit2;

import java.util.Objects;
import org.apache.fontbox.cmap.CMap;

public class HttpException extends RuntimeException {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public HttpException(Response<?> response) {
        // Objects.requireNonNull(response, "response == null");
        super("HTTP " + response.code() + CMap.SPACE + response.rawResponse.message());
        response.code();
        response.rawResponse.message();
    }
}
