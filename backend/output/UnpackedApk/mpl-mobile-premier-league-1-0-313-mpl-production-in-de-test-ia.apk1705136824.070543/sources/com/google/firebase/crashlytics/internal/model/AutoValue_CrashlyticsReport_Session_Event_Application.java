package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution;

public final class AutoValue_CrashlyticsReport_Session_Event_Application extends Application {
    public final Boolean background;
    public final ImmutableList<CustomAttribute> customAttributes;
    public final Execution execution;
    public final ImmutableList<CustomAttribute> internalKeys;
    public final int uiOrientation;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder {
        public Boolean background;
        public ImmutableList<CustomAttribute> customAttributes;
        public Execution execution;
        public ImmutableList<CustomAttribute> internalKeys;
        public Integer uiOrientation;

        public Application build() {
            String str = this.execution == null ? " execution" : "";
            if (this.uiOrientation == null) {
                str = GeneratedOutlineSupport.outline50(str, " uiOrientation");
            }
            if (str.isEmpty()) {
                AutoValue_CrashlyticsReport_Session_Event_Application autoValue_CrashlyticsReport_Session_Event_Application = new AutoValue_CrashlyticsReport_Session_Event_Application(this.execution, this.customAttributes, this.internalKeys, this.background, this.uiOrientation.intValue());
                return autoValue_CrashlyticsReport_Session_Event_Application;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder setBackground(Boolean bool) {
            this.background = bool;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder setCustomAttributes(ImmutableList<CustomAttribute> immutableList) {
            this.customAttributes = immutableList;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder setExecution(Execution execution2) {
            if (execution2 != null) {
                this.execution = execution2;
                return this;
            }
            throw new NullPointerException("Null execution");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder setInternalKeys(ImmutableList<CustomAttribute> immutableList) {
            this.internalKeys = immutableList;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder setUiOrientation(int i) {
            this.uiOrientation = Integer.valueOf(i);
            return this;
        }

        public Builder() {
        }

        public Builder(Application application) {
            this.execution = application.getExecution();
            this.customAttributes = application.getCustomAttributes();
            this.internalKeys = application.getInternalKeys();
            this.background = application.getBackground();
            this.uiOrientation = Integer.valueOf(application.getUiOrientation());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
        if (r4.uiOrientation == r5.getUiOrientation()) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
            r2 = 0
            if (r1 == 0) goto L_0x0061
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application r5 = (com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application) r5
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution r1 = r4.execution
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution r3 = r5.getExecution()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x005f
            com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute> r1 = r4.customAttributes
            if (r1 != 0) goto L_0x0022
            com.google.firebase.crashlytics.internal.model.ImmutableList r1 = r5.getCustomAttributes()
            if (r1 != 0) goto L_0x005f
            goto L_0x002c
        L_0x0022:
            com.google.firebase.crashlytics.internal.model.ImmutableList r3 = r5.getCustomAttributes()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x005f
        L_0x002c:
            com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport$CustomAttribute> r1 = r4.internalKeys
            if (r1 != 0) goto L_0x0037
            com.google.firebase.crashlytics.internal.model.ImmutableList r1 = r5.getInternalKeys()
            if (r1 != 0) goto L_0x005f
            goto L_0x0041
        L_0x0037:
            com.google.firebase.crashlytics.internal.model.ImmutableList r3 = r5.getInternalKeys()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x005f
        L_0x0041:
            java.lang.Boolean r1 = r4.background
            if (r1 != 0) goto L_0x004c
            java.lang.Boolean r1 = r5.getBackground()
            if (r1 != 0) goto L_0x005f
            goto L_0x0056
        L_0x004c:
            java.lang.Boolean r3 = r5.getBackground()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x005f
        L_0x0056:
            int r1 = r4.uiOrientation
            int r5 = r5.getUiOrientation()
            if (r1 != r5) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r0 = 0
        L_0x0060:
            return r0
        L_0x0061:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application.equals(java.lang.Object):boolean");
    }

    public Boolean getBackground() {
        return this.background;
    }

    public ImmutableList<CustomAttribute> getCustomAttributes() {
        return this.customAttributes;
    }

    public Execution getExecution() {
        return this.execution;
    }

    public ImmutableList<CustomAttribute> getInternalKeys() {
        return this.internalKeys;
    }

    public int getUiOrientation() {
        return this.uiOrientation;
    }

    public int hashCode() {
        int hashCode = (this.execution.hashCode() ^ 1000003) * 1000003;
        ImmutableList<CustomAttribute> immutableList = this.customAttributes;
        int i = 0;
        int hashCode2 = (hashCode ^ (immutableList == null ? 0 : immutableList.hashCode())) * 1000003;
        ImmutableList<CustomAttribute> immutableList2 = this.internalKeys;
        int hashCode3 = (hashCode2 ^ (immutableList2 == null ? 0 : immutableList2.hashCode())) * 1000003;
        Boolean bool = this.background;
        if (bool != null) {
            i = bool.hashCode();
        }
        return ((hashCode3 ^ i) * 1000003) ^ this.uiOrientation;
    }

    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Application{execution=");
        outline73.append(this.execution);
        outline73.append(", customAttributes=");
        outline73.append(this.customAttributes);
        outline73.append(", internalKeys=");
        outline73.append(this.internalKeys);
        outline73.append(", background=");
        outline73.append(this.background);
        outline73.append(", uiOrientation=");
        return GeneratedOutlineSupport.outline57(outline73, this.uiOrientation, "}");
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application(Execution execution2, ImmutableList<CustomAttribute> immutableList, ImmutableList<CustomAttribute> immutableList2, Boolean bool, int i) {
        this.execution = execution2;
        this.customAttributes = immutableList;
        this.internalKeys = immutableList2;
        this.background = bool;
        this.uiOrientation = i;
    }
}
