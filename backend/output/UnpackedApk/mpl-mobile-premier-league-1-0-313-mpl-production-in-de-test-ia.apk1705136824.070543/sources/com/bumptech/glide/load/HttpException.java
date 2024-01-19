package com.bumptech.glide.load;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;

public final class HttpException extends IOException {
    public static final long serialVersionUID = 1;

    public HttpException(int i) {
        super(GeneratedOutlineSupport.outline41("Http request failed with status code: ", i), null);
    }

    public HttpException(String str) {
        super(str, null);
    }

    public HttpException(String str, int i) {
        super(str, null);
    }
}
