package org.jsoup;

import java.io.IOException;

public class HttpStatusException extends IOException {
    public String toString() {
        return super.toString() + ". Status=" + 0 + ", URL=" + null;
    }
}
