package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

public class WebkitToCompatConverter {
    public final WebkitToCompatConverterBoundaryInterface mImpl;

    public WebkitToCompatConverter(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.mImpl = webkitToCompatConverterBoundaryInterface;
    }
}
