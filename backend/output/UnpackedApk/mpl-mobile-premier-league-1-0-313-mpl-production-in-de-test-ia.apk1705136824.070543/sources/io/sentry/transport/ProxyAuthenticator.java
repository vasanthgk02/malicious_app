package io.sentry.transport;

import io.sentry.util.Objects;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.PasswordAuthentication;

public final class ProxyAuthenticator extends Authenticator {
    public final String password;
    public final String user;

    public ProxyAuthenticator(String str, String str2) {
        this.user = (String) Objects.requireNonNull(str, "user is required");
        this.password = (String) Objects.requireNonNull(str2, "password is required");
    }

    public String getPassword() {
        return this.password;
    }

    public PasswordAuthentication getPasswordAuthentication() {
        if (getRequestorType() == RequestorType.PROXY) {
            return new PasswordAuthentication(this.user, this.password.toCharArray());
        }
        return null;
    }

    public String getUser() {
        return this.user;
    }
}
