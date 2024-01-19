package io.sentry;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import com.razorpay.AnalyticsConstants;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import io.sentry.Session.State;
import io.sentry.util.Objects;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SessionAdapter extends TypeAdapter<Session> {
    public final SentryOptions options;

    public SessionAdapter(SentryOptions sentryOptions) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "The SentryOptions is required.");
    }

    private Date converTimeStamp(String str, String str2) {
        try {
            return DateUtils.getDateTime(str);
        } catch (IllegalArgumentException e2) {
            this.options.getLogger().log(SentryLevel.ERROR, e2, "Error converting session (%s) field.", str2);
            return null;
        }
    }

    private boolean initAttrs(JsonWriter jsonWriter, boolean z) throws IOException {
        if (!z) {
            jsonWriter.name("attrs").beginObject();
        }
        return true;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.Session read(com.google.gson.stream.JsonReader r21) throws java.io.IOException {
        /*
            r20 = this;
            r0 = r20
            com.google.gson.stream.JsonToken r1 = r21.peek()
            com.google.gson.stream.JsonToken r2 = com.google.gson.stream.JsonToken.NULL
            r3 = 0
            if (r1 != r2) goto L_0x000f
            r21.nextNull()
            return r3
        L_0x000f:
            r21.beginObject()
            r5 = r3
            r6 = r5
            r7 = r6
            r9 = r7
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
            r17 = r16
            r8 = 0
        L_0x0021:
            boolean r2 = r21.hasNext()
            if (r2 == 0) goto L_0x0193
            java.lang.String r2 = r21.nextName()
            int r4 = r2.hashCode()
            java.lang.String r3 = "timestamp"
            java.lang.String r1 = "started"
            r18 = -1
            r19 = r15
            r15 = 1
            switch(r4) {
                case -1992012396: goto L_0x0099;
                case -1897185151: goto L_0x0091;
                case -1294635157: goto L_0x0087;
                case -892481550: goto L_0x007c;
                case 99455: goto L_0x0072;
                case 113759: goto L_0x0068;
                case 113870: goto L_0x005d;
                case 3237136: goto L_0x0053;
                case 55126294: goto L_0x004a;
                case 93152418: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x00a3
        L_0x003f:
            java.lang.String r4 = "attrs"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00a3
            r2 = 9
            goto L_0x00a4
        L_0x004a:
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00a3
            r2 = 8
            goto L_0x00a4
        L_0x0053:
            java.lang.String r4 = "init"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00a3
            r2 = 2
            goto L_0x00a4
        L_0x005d:
            java.lang.String r4 = "sid"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00a3
            r2 = 0
            goto L_0x00a4
        L_0x0068:
            java.lang.String r4 = "seq"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00a3
            r2 = 6
            goto L_0x00a4
        L_0x0072:
            java.lang.String r4 = "did"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00a3
            r2 = 1
            goto L_0x00a4
        L_0x007c:
            java.lang.String r4 = "status"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00a3
            r2 = 4
            goto L_0x00a4
        L_0x0087:
            java.lang.String r4 = "errors"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00a3
            r2 = 5
            goto L_0x00a4
        L_0x0091:
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x00a3
            r2 = 3
            goto L_0x00a4
        L_0x0099:
            java.lang.String r4 = "duration"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x00a3
            r2 = 7
            goto L_0x00a4
        L_0x00a3:
            r2 = -1
        L_0x00a4:
            switch(r2) {
                case 0: goto L_0x0173;
                case 1: goto L_0x016c;
                case 2: goto L_0x0163;
                case 3: goto L_0x015a;
                case 4: goto L_0x0136;
                case 5: goto L_0x0131;
                case 6: goto L_0x0128;
                case 7: goto L_0x011f;
                case 8: goto L_0x0116;
                case 9: goto L_0x00ac;
                default: goto L_0x00a7;
            }
        L_0x00a7:
            r21.skipValue()
            goto L_0x0170
        L_0x00ac:
            r21.beginObject()
        L_0x00af:
            boolean r1 = r21.hasNext()
            if (r1 == 0) goto L_0x0112
            java.lang.String r1 = r21.nextName()
            int r2 = r1.hashCode()
            switch(r2) {
                case -85904877: goto L_0x00e0;
                case 1090594823: goto L_0x00d6;
                case 1480014044: goto L_0x00cc;
                case 1917799825: goto L_0x00c1;
                default: goto L_0x00c0;
            }
        L_0x00c0:
            goto L_0x00ea
        L_0x00c1:
            java.lang.String r2 = "user_agent"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ea
            r1 = 3
            goto L_0x00eb
        L_0x00cc:
            java.lang.String r2 = "ip_address"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ea
            r1 = 2
            goto L_0x00eb
        L_0x00d6:
            java.lang.String r2 = "release"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ea
            r1 = 0
            goto L_0x00eb
        L_0x00e0:
            java.lang.String r2 = "environment"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00ea
            r1 = 1
            goto L_0x00eb
        L_0x00ea:
            r1 = -1
        L_0x00eb:
            if (r1 == 0) goto L_0x010b
            if (r1 == r15) goto L_0x0104
            r2 = 2
            if (r1 == r2) goto L_0x00fe
            r3 = 3
            if (r1 == r3) goto L_0x00f9
            r21.skipValue()
            goto L_0x00af
        L_0x00f9:
            java.lang.String r19 = r21.nextString()
            goto L_0x00af
        L_0x00fe:
            r3 = 3
            java.lang.String r14 = r21.nextString()
            goto L_0x00af
        L_0x0104:
            r2 = 2
            r3 = 3
            java.lang.String r16 = r21.nextString()
            goto L_0x00af
        L_0x010b:
            r2 = 2
            r3 = 3
            java.lang.String r17 = r21.nextString()
            goto L_0x00af
        L_0x0112:
            r21.endObject()
            goto L_0x0170
        L_0x0116:
            java.lang.String r1 = r21.nextString()
            java.util.Date r7 = r0.converTimeStamp(r1, r3)
            goto L_0x0170
        L_0x011f:
            double r1 = r21.nextDouble()
            java.lang.Double r13 = java.lang.Double.valueOf(r1)
            goto L_0x0170
        L_0x0128:
            long r1 = r21.nextLong()
            java.lang.Long r12 = java.lang.Long.valueOf(r1)
            goto L_0x0170
        L_0x0131:
            int r8 = r21.nextInt()
            goto L_0x0170
        L_0x0136:
            java.lang.String r1 = r21.nextString()     // Catch:{ IllegalArgumentException -> 0x0146 }
            java.lang.String r1 = io.sentry.util.StringUtils.capitalize(r1)     // Catch:{ IllegalArgumentException -> 0x0146 }
            if (r1 == 0) goto L_0x0170
            io.sentry.Session$State r1 = io.sentry.Session.State.valueOf(r1)     // Catch:{ IllegalArgumentException -> 0x0147 }
            r5 = r1
            goto L_0x0170
        L_0x0146:
            r1 = 0
        L_0x0147:
            io.sentry.SentryOptions r2 = r0.options
            io.sentry.ILogger r2 = r2.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r4 = new java.lang.Object[r15]
            r15 = 0
            r4[r15] = r1
            java.lang.String r1 = "%s status is not valid."
            r2.log(r3, r1, r4)
            goto L_0x0170
        L_0x015a:
            java.lang.String r2 = r21.nextString()
            java.util.Date r6 = r0.converTimeStamp(r2, r1)
            goto L_0x0170
        L_0x0163:
            boolean r1 = r21.nextBoolean()
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r1)
            goto L_0x0170
        L_0x016c:
            java.lang.String r9 = r21.nextString()
        L_0x0170:
            r15 = r19
            goto L_0x0190
        L_0x0173:
            java.lang.String r1 = r21.nextString()     // Catch:{ IllegalArgumentException -> 0x017c }
            java.util.UUID r10 = java.util.UUID.fromString(r1)     // Catch:{ IllegalArgumentException -> 0x017d }
            goto L_0x0170
        L_0x017c:
            r1 = 0
        L_0x017d:
            io.sentry.SentryOptions r2 = r0.options
            io.sentry.ILogger r2 = r2.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r4 = new java.lang.Object[r15]
            r15 = 0
            r4[r15] = r1
            java.lang.String r1 = "%s sid is not valid."
            r2.log(r3, r1, r4)
            goto L_0x0170
        L_0x0190:
            r3 = 0
            goto L_0x0021
        L_0x0193:
            r19 = r15
            r21.endObject()
            if (r5 == 0) goto L_0x01ae
            if (r6 == 0) goto L_0x01ae
            if (r17 == 0) goto L_0x01ae
            boolean r1 = r17.isEmpty()
            if (r1 == 0) goto L_0x01a5
            goto L_0x01ae
        L_0x01a5:
            io.sentry.Session r1 = new io.sentry.Session
            r4 = r1
            r15 = r19
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r1
        L_0x01ae:
            io.sentry.SentryOptions r1 = r0.options
            io.sentry.ILogger r1 = r1.getLogger()
            io.sentry.SentryLevel r2 = io.sentry.SentryLevel.ERROR
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = "Session is gonna be dropped due to invalid fields."
            r1.log(r2, r4, r3)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SessionAdapter.read(com.google.gson.stream.JsonReader):io.sentry.Session");
    }

    public void write(JsonWriter jsonWriter, Session session) throws IOException {
        if (session == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        if (session.getSessionId() != null) {
            jsonWriter.name("sid").value(session.getSessionId().toString());
        }
        if (session.getDistinctId() != null) {
            jsonWriter.name("did").value(session.getDistinctId());
        }
        if (session.getInit() != null) {
            jsonWriter.name(AnalyticsConstants.INIT).value(session.getInit());
        }
        Date started = session.getStarted();
        if (started != null) {
            jsonWriter.name("started").value(DateUtils.getTimestamp(started));
        }
        State status = session.getStatus();
        if (status != null) {
            jsonWriter.name("status").value(status.name().toLowerCase(Locale.ROOT));
        }
        if (session.getSequence() != null) {
            jsonWriter.name(Values.SEQ).value((Number) session.getSequence());
        }
        int errorCount = session.errorCount();
        if (errorCount > 0) {
            jsonWriter.name("errors").value((long) errorCount);
        }
        if (session.getDuration() != null) {
            jsonWriter.name(InlineAnimation.DURATION).value((Number) session.getDuration());
        }
        if (session.getTimestamp() != null) {
            jsonWriter.name("timestamp").value(DateUtils.getTimestamp(session.getTimestamp()));
        }
        boolean initAttrs = initAttrs(jsonWriter, false);
        jsonWriter.name("release").value(session.getRelease());
        if (session.getEnvironment() != null) {
            initAttrs = initAttrs(jsonWriter, initAttrs);
            jsonWriter.name(PaymentConstants.ENV).value(session.getEnvironment());
        }
        if (session.getIpAddress() != null) {
            initAttrs = initAttrs(jsonWriter, initAttrs);
            jsonWriter.name("ip_address").value(session.getIpAddress());
        }
        if (session.getUserAgent() != null) {
            initAttrs = initAttrs(jsonWriter, initAttrs);
            jsonWriter.name(AnalyticsConstants.USER_AGENT).value(session.getUserAgent());
        }
        if (initAttrs) {
            jsonWriter.endObject();
        }
        jsonWriter.endObject();
    }
}
