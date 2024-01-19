package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.datatransport.runtime.time.Clock;

public final class AutoValue_CreationContext extends CreationContext {
    public final Context applicationContext;
    public final String backendName;
    public final Clock monotonicClock;
    public final Clock wallClock;

    public AutoValue_CreationContext(Context context, Clock clock, Clock clock2, String str) {
        if (context != null) {
            this.applicationContext = context;
            if (clock != null) {
                this.wallClock = clock;
                if (clock2 != null) {
                    this.monotonicClock = clock2;
                    if (str != null) {
                        this.backendName = str;
                        return;
                    }
                    throw new NullPointerException("Null backendName");
                }
                throw new NullPointerException("Null monotonicClock");
            }
            throw new NullPointerException("Null wallClock");
        }
        throw new NullPointerException("Null applicationContext");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CreationContext)) {
            return false;
        }
        AutoValue_CreationContext autoValue_CreationContext = (AutoValue_CreationContext) ((CreationContext) obj);
        if (!this.applicationContext.equals(autoValue_CreationContext.applicationContext) || !this.wallClock.equals(autoValue_CreationContext.wallClock) || !this.monotonicClock.equals(autoValue_CreationContext.monotonicClock) || !this.backendName.equals(autoValue_CreationContext.backendName)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((((((this.applicationContext.hashCode() ^ 1000003) * 1000003) ^ this.wallClock.hashCode()) * 1000003) ^ this.monotonicClock.hashCode()) * 1000003) ^ this.backendName.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CreationContext{applicationContext=");
        outline73.append(this.applicationContext);
        outline73.append(", wallClock=");
        outline73.append(this.wallClock);
        outline73.append(", monotonicClock=");
        outline73.append(this.monotonicClock);
        outline73.append(", backendName=");
        return GeneratedOutlineSupport.outline62(outline73, this.backendName, "}");
    }
}
