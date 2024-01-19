package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread extends Thread {
    public final ImmutableList<Frame> frames;
    public final int importance;
    public final String name;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder {
        public ImmutableList<Frame> frames;
        public Integer importance;
        public String name;

        public Thread build() {
            String str = this.name == null ? " name" : "";
            if (this.importance == null) {
                str = GeneratedOutlineSupport.outline50(str, " importance");
            }
            if (this.frames == null) {
                str = GeneratedOutlineSupport.outline50(str, " frames");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(this.name, this.importance.intValue(), this.frames);
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setFrames(ImmutableList<Frame> immutableList) {
            if (immutableList != null) {
                this.frames = immutableList;
                return this;
            }
            throw new NullPointerException("Null frames");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setImportance(int i) {
            this.importance = Integer.valueOf(i);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setName(String str) {
            if (str != null) {
                this.name = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Thread)) {
            return false;
        }
        Thread thread = (Thread) obj;
        if (!this.name.equals(thread.getName()) || this.importance != thread.getImportance() || !this.frames.equals(thread.getFrames())) {
            z = false;
        }
        return z;
    }

    public ImmutableList<Frame> getFrames() {
        return this.frames;
    }

    public int getImportance() {
        return this.importance;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return ((((this.name.hashCode() ^ 1000003) * 1000003) ^ this.importance) * 1000003) ^ this.frames.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Thread{name=");
        outline73.append(this.name);
        outline73.append(", importance=");
        outline73.append(this.importance);
        outline73.append(", frames=");
        outline73.append(this.frames);
        outline73.append("}");
        return outline73.toString();
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(String str, int i, ImmutableList<Frame> immutableList) {
        this.name = str;
        this.importance = i;
        this.frames = immutableList;
    }
}
