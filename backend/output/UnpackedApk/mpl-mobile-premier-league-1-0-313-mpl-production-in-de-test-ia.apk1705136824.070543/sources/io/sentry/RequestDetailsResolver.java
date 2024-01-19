package io.sentry;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.sentry.util.Objects;
import java.net.URI;

public final class RequestDetailsResolver {
    public static final String SENTRY_AUTH = "X-Sentry-Auth";
    public static final String USER_AGENT = "User-Agent";
    public final SentryOptions options;

    public RequestDetailsResolver(SentryOptions sentryOptions) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "options is required");
    }

    public RequestDetails resolve() {
        Dsn dsn = new Dsn(this.options.getDsn());
        URI sentryUri = dsn.getSentryUri();
        String uri = sentryUri.resolve(sentryUri.getPath() + "/envelope/").toString();
        String publicKey = dsn.getPublicKey();
        String secretKey = dsn.getSecretKey();
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Sentry sentry_version=7,sentry_client=");
        outline73.append(this.options.getSentryClientName());
        outline73.append(",sentry_key=");
        outline73.append(publicKey);
        outline73.append((secretKey == null || secretKey.length() <= 0) ? "" : GeneratedOutlineSupport.outline50(",sentry_secret=", secretKey));
        return new RequestDetails(uri, GeneratedOutlineSupport.outline88("User-Agent", this.options.getSentryClientName(), SENTRY_AUTH, outline73.toString()));
    }
}
