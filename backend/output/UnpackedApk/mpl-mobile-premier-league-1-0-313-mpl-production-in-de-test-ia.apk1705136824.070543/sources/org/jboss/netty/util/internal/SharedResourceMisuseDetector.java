package org.jboss.netty.util.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

public class SharedResourceMisuseDetector {
    public static final int MAX_ACTIVE_INSTANCES = 256;
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(SharedResourceMisuseDetector.class);
    public final AtomicLong activeInstances = new AtomicLong();
    public final AtomicBoolean logged = new AtomicBoolean();
    public final Class<?> type;

    public SharedResourceMisuseDetector(Class<?> cls) {
        if (cls != null) {
            this.type = cls;
            return;
        }
        throw new NullPointerException("type");
    }

    public void decrease() {
        this.activeInstances.decrementAndGet();
    }

    public void increase() {
        if (this.activeInstances.incrementAndGet() > 256 && this.logged.compareAndSet(false, true)) {
            InternalLogger internalLogger = logger;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("You are creating too many ");
            outline73.append(this.type.getSimpleName());
            outline73.append(" instances.  ");
            outline73.append(this.type.getSimpleName());
            outline73.append(" is a shared resource that must be reused across the");
            outline73.append(" application, so that only a few instances are created.");
            internalLogger.warn(outline73.toString());
        }
    }
}
