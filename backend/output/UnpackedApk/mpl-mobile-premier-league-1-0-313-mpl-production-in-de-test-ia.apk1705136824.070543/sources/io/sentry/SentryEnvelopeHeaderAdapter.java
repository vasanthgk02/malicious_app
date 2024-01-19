package io.sentry;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryPackage;
import java.io.IOException;
import java.util.List;
import org.jetbrains.annotations.ApiStatus.Internal;

@Internal
public final class SentryEnvelopeHeaderAdapter extends TypeAdapter<SentryEnvelopeHeader> {
    private boolean hasValidSdkVersion(SdkVersion sdkVersion) {
        return sdkVersion.getName() != null && !sdkVersion.getName().isEmpty() && sdkVersion.getVersion() != null && !sdkVersion.getVersion().isEmpty();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.SentryEnvelopeHeader read(com.google.gson.stream.JsonReader r14) throws java.io.IOException {
        /*
            r13 = this;
            com.google.gson.stream.JsonToken r0 = r14.peek()
            com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL
            r2 = 0
            if (r0 != r1) goto L_0x000d
            r14.nextNull()
            return r2
        L_0x000d:
            r14.beginObject()
            r0 = r2
            r1 = r0
        L_0x0012:
            boolean r3 = r14.hasNext()
            if (r3 == 0) goto L_0x0131
            java.lang.String r3 = r14.nextName()
            int r4 = r3.hashCode()
            r5 = 113722(0x1bc3a, float:1.59358E-40)
            r6 = 0
            r7 = -1
            r8 = 1
            if (r4 == r5) goto L_0x0038
            r5 = 278118624(0x1093c0e0, float:5.827845E-29)
            if (r4 == r5) goto L_0x002e
            goto L_0x0042
        L_0x002e:
            java.lang.String r4 = "event_id"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0042
            r3 = 0
            goto L_0x0043
        L_0x0038:
            java.lang.String r4 = "sdk"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0042
            r3 = 1
            goto L_0x0043
        L_0x0042:
            r3 = -1
        L_0x0043:
            if (r3 == 0) goto L_0x0126
            if (r3 == r8) goto L_0x004b
            r14.skipValue()
            goto L_0x0012
        L_0x004b:
            r14.beginObject()
            io.sentry.protocol.SdkVersion r1 = new io.sentry.protocol.SdkVersion
            r1.<init>()
        L_0x0053:
            boolean r3 = r14.hasNext()
            if (r3 == 0) goto L_0x0121
            java.lang.String r3 = r14.nextName()
            int r4 = r3.hashCode()
            java.lang.String r5 = "version"
            java.lang.String r9 = "name"
            r10 = 3
            r11 = 2
            switch(r4) {
                case 3373707: goto L_0x0088;
                case 351608024: goto L_0x0080;
                case 750867693: goto L_0x0076;
                case 1487029535: goto L_0x006c;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x0090
        L_0x006c:
            java.lang.String r4 = "integrations"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0090
            r3 = 2
            goto L_0x0091
        L_0x0076:
            java.lang.String r4 = "packages"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0090
            r3 = 3
            goto L_0x0091
        L_0x0080:
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0090
            r3 = 1
            goto L_0x0091
        L_0x0088:
            boolean r3 = r3.equals(r9)
            if (r3 == 0) goto L_0x0090
            r3 = 0
            goto L_0x0091
        L_0x0090:
            r3 = -1
        L_0x0091:
            if (r3 == 0) goto L_0x0118
            if (r3 == r8) goto L_0x010f
            if (r3 == r11) goto L_0x00f7
            if (r3 == r10) goto L_0x009d
            r14.skipValue()
            goto L_0x0053
        L_0x009d:
            r14.beginArray()
        L_0x00a0:
            boolean r3 = r14.hasNext()
            if (r3 == 0) goto L_0x00f2
            r14.beginObject()
            r3 = r2
            r4 = r3
        L_0x00ab:
            boolean r10 = r14.hasNext()
            if (r10 == 0) goto L_0x00e7
            java.lang.String r10 = r14.nextName()
            int r11 = r10.hashCode()
            r12 = 3373707(0x337a8b, float:4.72757E-39)
            if (r11 == r12) goto L_0x00cc
            r12 = 351608024(0x14f51cd8, float:2.4750055E-26)
            if (r11 == r12) goto L_0x00c4
            goto L_0x00d4
        L_0x00c4:
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto L_0x00d4
            r10 = 1
            goto L_0x00d5
        L_0x00cc:
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L_0x00d4
            r10 = 0
            goto L_0x00d5
        L_0x00d4:
            r10 = -1
        L_0x00d5:
            if (r10 == 0) goto L_0x00e2
            if (r10 == r8) goto L_0x00dd
            r14.skipValue()
            goto L_0x00ab
        L_0x00dd:
            java.lang.String r4 = r14.nextString()
            goto L_0x00ab
        L_0x00e2:
            java.lang.String r3 = r14.nextString()
            goto L_0x00ab
        L_0x00e7:
            if (r3 == 0) goto L_0x00ee
            if (r4 == 0) goto L_0x00ee
            r1.addPackage(r3, r4)
        L_0x00ee:
            r14.endObject()
            goto L_0x00a0
        L_0x00f2:
            r14.endArray()
            goto L_0x0053
        L_0x00f7:
            r14.beginArray()
        L_0x00fa:
            boolean r3 = r14.hasNext()
            if (r3 == 0) goto L_0x010a
            java.lang.String r3 = r14.nextString()
            if (r3 == 0) goto L_0x00fa
            r1.addIntegration(r3)
            goto L_0x00fa
        L_0x010a:
            r14.endArray()
            goto L_0x0053
        L_0x010f:
            java.lang.String r3 = r14.nextString()
            r1.setVersion(r3)
            goto L_0x0053
        L_0x0118:
            java.lang.String r3 = r14.nextString()
            r1.setName(r3)
            goto L_0x0053
        L_0x0121:
            r14.endObject()
            goto L_0x0012
        L_0x0126:
            io.sentry.protocol.SentryId r0 = new io.sentry.protocol.SentryId
            java.lang.String r3 = r14.nextString()
            r0.<init>(r3)
            goto L_0x0012
        L_0x0131:
            r14.endObject()
            io.sentry.SentryEnvelopeHeader r14 = new io.sentry.SentryEnvelopeHeader
            r14.<init>(r0, r1)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryEnvelopeHeaderAdapter.read(com.google.gson.stream.JsonReader):io.sentry.SentryEnvelopeHeader");
    }

    public void write(JsonWriter jsonWriter, SentryEnvelopeHeader sentryEnvelopeHeader) throws IOException {
        if (sentryEnvelopeHeader == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        if (sentryEnvelopeHeader.getEventId() != null) {
            jsonWriter.name("event_id");
            jsonWriter.value(sentryEnvelopeHeader.getEventId().toString());
        }
        SdkVersion sdkVersion = sentryEnvelopeHeader.getSdkVersion();
        if (sdkVersion != null && hasValidSdkVersion(sdkVersion)) {
            jsonWriter.name("sdk").beginObject();
            jsonWriter.name("name").value(sdkVersion.getName());
            jsonWriter.name("version").value(sdkVersion.getVersion());
            List<String> integrations = sdkVersion.getIntegrations();
            if (integrations != null) {
                jsonWriter.name("integrations").beginArray();
                for (String value : integrations) {
                    jsonWriter.value(value);
                }
                jsonWriter.endArray();
            }
            List<SentryPackage> packages = sdkVersion.getPackages();
            if (packages != null) {
                jsonWriter.name("packages").beginArray();
                for (SentryPackage next : packages) {
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(next.getName());
                    jsonWriter.name("version").value(next.getVersion());
                    jsonWriter.endObject();
                }
                jsonWriter.endArray();
            }
            jsonWriter.endObject();
        }
        jsonWriter.endObject();
    }
}
