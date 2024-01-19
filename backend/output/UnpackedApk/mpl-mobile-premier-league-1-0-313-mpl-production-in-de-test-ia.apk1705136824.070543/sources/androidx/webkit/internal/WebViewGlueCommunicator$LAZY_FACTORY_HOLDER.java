package androidx.webkit.internal;

import androidx.core.widget.CompoundButtonCompat;
import java.lang.reflect.InvocationTargetException;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebViewGlueCommunicator$LAZY_FACTORY_HOLDER {
    public static final WebViewProviderFactory INSTANCE;

    static {
        WebViewProviderFactory webViewProviderFactory;
        try {
            webViewProviderFactory = new WebViewProviderFactoryAdapter((WebViewProviderFactoryBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderFactoryBoundaryInterface.class, CompoundButtonCompat.fetchGlueProviderFactoryImpl()));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        } catch (ClassNotFoundException unused) {
            webViewProviderFactory = new IncompatibleApkWebViewProviderFactory();
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException(e4);
        }
        INSTANCE = webViewProviderFactory;
    }
}
