package org.jsoup;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;

public class UnsupportedMimeTypeException extends IOException {
    public String toString() {
        StringBuilder sb = new StringBuilder();
        GeneratedOutlineSupport.outline103(sb, super.toString(), ". Mimetype=", null, ", URL=");
        sb.append(null);
        return sb.toString();
    }
}
