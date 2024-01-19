package com.badlogic.gdx.graphics.profiling;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.GdxRuntimeException;

public interface GLErrorListener {
    public static final GLErrorListener LOGGING_LISTENER = new GLErrorListener() {
        public void onError(int i) {
            String str = null;
            try {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                int i2 = 0;
                while (true) {
                    if (i2 >= stackTrace.length) {
                        break;
                    } else if ("check".equals(stackTrace[i2].getMethodName())) {
                        int i3 = i2 + 1;
                        if (i3 < stackTrace.length) {
                            str = stackTrace[i3].getMethodName();
                        }
                    } else {
                        i2++;
                    }
                }
            } catch (Exception unused) {
            }
            if (str != null) {
                Application application = k.app;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error ");
                outline73.append(GLInterceptor.resolveErrorNumber(i));
                outline73.append(" from ");
                outline73.append(str);
                application.error("GLProfiler", outline73.toString());
                return;
            }
            Application application2 = k.app;
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Error ");
            outline732.append(GLInterceptor.resolveErrorNumber(i));
            outline732.append(" at: ");
            application2.error("GLProfiler", outline732.toString(), new Exception());
        }
    };
    public static final GLErrorListener THROWING_LISTENER = new GLErrorListener() {
        public void onError(int i) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("GLProfiler: Got GL error ");
            outline73.append(GLInterceptor.resolveErrorNumber(i));
            throw new GdxRuntimeException(outline73.toString());
        }
    };

    void onError(int i);
}
