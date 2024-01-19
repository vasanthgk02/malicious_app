package com.appsflyer.internal.components.network.http.exceptions;

import com.appsflyer.internal.br;
import java.io.IOException;

public class ParsingException extends IOException {
    public final br<String> AFInAppEventParameterName;

    public ParsingException(String str, Throwable th, br<String> brVar) {
        super(str, th);
        this.AFInAppEventParameterName = brVar;
    }

    public br<String> getRawResponse() {
        return this.AFInAppEventParameterName;
    }
}
