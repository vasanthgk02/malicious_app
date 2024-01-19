package androidx.webkit.internal;

import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

public interface WebViewProviderFactory {
    String[] getWebViewFeatures();

    WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter();
}
