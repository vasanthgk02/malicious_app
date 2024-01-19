package com.mpl.network.modules.request;

import androidx.annotation.Keep;

@Keep
public enum RequestType {
    GET,
    POST,
    PUT,
    DELETE,
    PATCH,
    OPTIONS,
    LINK,
    UNLINK,
    PURGE,
    COPY,
    HEAD
}
