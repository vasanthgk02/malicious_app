package com.facebook.appevents;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.FacebookException;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Utility;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 '2\u00020\u0001:\u0002'(BE\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB)\b\u0012\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\b\u0010\u001d\u001a\u00020\u0003H\u0002J\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\u0017J;\u0010 \u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u0003H\u0016J\u001e\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030$2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020&H\u0002R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/facebook/appevents/AppEvent;", "Ljava/io/Serializable;", "contextName", "", "eventName", "valueToSum", "", "parameters", "Landroid/os/Bundle;", "isImplicitlyLogged", "", "isInBackground", "currentSessionId", "Ljava/util/UUID;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;ZZLjava/util/UUID;)V", "jsonString", "isImplicit", "inBackground", "checksum", "(Ljava/lang/String;ZZLjava/lang/String;)V", "isChecksumValid", "()Z", "jsonObject", "Lorg/json/JSONObject;", "getJsonObject", "()Lorg/json/JSONObject;", "name", "getName", "()Ljava/lang/String;", "calculateChecksum", "getIsImplicit", "getJSONObject", "getJSONObjectForAppEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Landroid/os/Bundle;Ljava/util/UUID;)Lorg/json/JSONObject;", "toString", "validateParameters", "", "writeReplace", "", "Companion", "SerializationProxyV2", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEvent.kt */
public final class AppEvent implements Serializable {
    public static final Companion Companion = new Companion(null);
    public static final long serialVersionUID = 1;
    public static final HashSet<String> validatedIdentifiers = new HashSet<>();
    public final String checksum;
    public final boolean inBackground;
    public final boolean isImplicit;
    public final JSONObject jsonObject;
    public final String name;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/appevents/AppEvent$Companion;", "", "()V", "MAX_IDENTIFIER_LENGTH", "", "serialVersionUID", "", "validatedIdentifiers", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "md5Checksum", "toHash", "validateIdentifier", "", "identifier", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEvent.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final void access$validateIdentifier(Companion companion, String str) {
            boolean contains;
            if (str != null) {
                if (!(str.length() == 0) && str.length() <= 40) {
                    synchronized (AppEvent.validatedIdentifiers) {
                        contains = AppEvent.validatedIdentifiers.contains(str);
                    }
                    if (contains) {
                        return;
                    }
                    if (new Regex((String) "^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$").matches(str)) {
                        synchronized (AppEvent.validatedIdentifiers) {
                            AppEvent.validatedIdentifiers.add(str);
                        }
                        return;
                    }
                    throw new FacebookException(GeneratedOutlineSupport.outline70(new Object[]{str}, 1, "Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen.", "java.lang.String.format(format, *args)"));
                }
            }
            if (str == null) {
                str = "<None Provided>";
            }
            String format = String.format(Locale.ROOT, "Identifier '%s' must be less than %d characters", Arrays.copyOf(new Object[]{str, Integer.valueOf(40)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
            throw new FacebookException(format);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/AppEvent$SerializationProxyV2;", "Ljava/io/Serializable;", "jsonString", "", "isImplicit", "", "inBackground", "checksum", "(Ljava/lang/String;ZZLjava/lang/String;)V", "readResolve", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEvent.kt */
    public static final class SerializationProxyV2 implements Serializable {
        public static final long serialVersionUID = 20160803001L;
        public final String checksum;
        public final boolean inBackground;
        public final boolean isImplicit;
        public final String jsonString;

        public SerializationProxyV2(String str, boolean z, boolean z2, String str2) {
            Intrinsics.checkNotNullParameter(str, "jsonString");
            this.jsonString = str;
            this.isImplicit = z;
            this.inBackground = z2;
            this.checksum = str2;
        }

        private final Object readResolve() throws JSONException, ObjectStreamException {
            AppEvent appEvent = new AppEvent(this.jsonString, this.isImplicit, this.inBackground, this.checksum, null);
            return appEvent;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        r10 = "_removed_";
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049 A[Catch:{ all -> 0x0042, all -> 0x004c }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b A[Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0086 A[Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppEvent(java.lang.String r9, java.lang.String r10, java.lang.Double r11, android.os.Bundle r12, boolean r13, boolean r14, java.util.UUID r15) throws org.json.JSONException, com.facebook.FacebookException {
        /*
            r8 = this;
            java.lang.String r0 = "contextName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "eventName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r8.<init>()
            r8.isImplicit = r13
            r8.inBackground = r14
            r8.name = r10
            java.lang.Class<com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager> r13 = com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager.class
            java.lang.String r14 = "1"
            com.facebook.appevents.AppEvent$Companion r1 = Companion
            com.facebook.appevents.AppEvent.Companion.access$validateIdentifier(r1, r10)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager r2 = com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager.INSTANCE
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r13)
            r3 = 0
            if (r2 == 0) goto L_0x002b
            goto L_0x0050
        L_0x002b:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)     // Catch:{ all -> 0x004c }
            boolean r2 = com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager.enabled     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x0051
            com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager r2 = com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager.INSTANCE     // Catch:{ all -> 0x004c }
            boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r2)     // Catch:{ all -> 0x004c }
            if (r4 == 0) goto L_0x003b
            goto L_0x0046
        L_0x003b:
            java.util.Set<java.lang.String> r4 = com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager.restrictedEvents     // Catch:{ all -> 0x0042 }
            boolean r2 = r4.contains(r10)     // Catch:{ all -> 0x0042 }
            goto L_0x0047
        L_0x0042:
            r4 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r4, r2)     // Catch:{ all -> 0x004c }
        L_0x0046:
            r2 = 0
        L_0x0047:
            if (r2 == 0) goto L_0x0051
            java.lang.String r10 = "_removed_"
            goto L_0x0051
        L_0x004c:
            r10 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r10, r13)
        L_0x0050:
            r10 = 0
        L_0x0051:
            java.lang.String r2 = "_eventName"
            r1.put(r2, r10)
            java.lang.String r2 = "Failed to generate checksum: "
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }
            java.lang.String r5 = "UTF-8"
            java.nio.charset.Charset r5 = java.nio.charset.Charset.forName(r5)     // Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }
            java.lang.String r6 = "Charset.forName(charsetName)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }
            if (r10 == 0) goto L_0x0086
            byte[] r10 = r10.getBytes(r5)     // Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }
            java.lang.String r5 = "(this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r5)     // Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }
            int r5 = r10.length     // Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }
            r4.update(r10, r3, r5)     // Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }
            byte[] r10 = r4.digest()     // Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }
            java.lang.String r4 = "digest.digest()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)     // Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }
            java.lang.String r10 = com.facebook.appevents.internal.AppEventUtility.bytesToHex(r10)     // Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }
            goto L_0x009a
        L_0x0086:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException     // Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            r10.<init>(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }
            throw r10     // Catch:{ NoSuchAlgorithmException -> 0x0094, UnsupportedEncodingException -> 0x008e }
        L_0x008e:
            r10 = move-exception
            com.facebook.internal.Utility.logd(r2, r10)
            r10 = r14
            goto L_0x009a
        L_0x0094:
            r10 = move-exception
            com.facebook.internal.Utility.logd(r2, r10)
            java.lang.String r10 = "0"
        L_0x009a:
            java.lang.String r2 = "_eventName_md5"
            r1.put(r2, r10)
            long r4 = java.lang.System.currentTimeMillis()
            r10 = 1000(0x3e8, float:1.401E-42)
            long r6 = (long) r10
            long r4 = r4 / r6
            java.lang.String r10 = "_logTime"
            r1.put(r10, r4)
            java.lang.String r10 = "_ui"
            r1.put(r10, r9)
            if (r15 == 0) goto L_0x00b8
            java.lang.String r9 = "_session_id"
            r1.put(r9, r15)
        L_0x00b8:
            r9 = 1
            if (r12 == 0) goto L_0x028d
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.Set r15 = r12.keySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x00c8:
            boolean r2 = r15.hasNext()
            if (r2 == 0) goto L_0x0108
            java.lang.Object r2 = r15.next()
            java.lang.String r2 = (java.lang.String) r2
            com.facebook.appevents.AppEvent$Companion r4 = Companion
            java.lang.String r5 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.facebook.appevents.AppEvent.Companion.access$validateIdentifier(r4, r2)
            java.lang.Object r4 = r12.get(r2)
            boolean r5 = r4 instanceof java.lang.String
            if (r5 != 0) goto L_0x0100
            boolean r5 = r4 instanceof java.lang.Number
            if (r5 == 0) goto L_0x00eb
            goto L_0x0100
        L_0x00eb:
            com.facebook.FacebookException r10 = new com.facebook.FacebookException
            r11 = 2
            java.lang.Object[] r12 = new java.lang.Object[r11]
            r12[r3] = r4
            r12[r9] = r2
            java.lang.String r9 = "Parameter value '%s' for key '%s' should be a string or a numeric type."
            java.lang.String r13 = "java.lang.String.format(format, *args)"
            java.lang.String r9 = com.android.tools.r8.GeneratedOutlineSupport.outline70(r12, r11, r9, r13)
            r10.<init>(r9)
            throw r10
        L_0x0100:
            java.lang.String r4 = r4.toString()
            r10.put(r2, r4)
            goto L_0x00c8
        L_0x0108:
            java.lang.Class<com.facebook.appevents.integrity.IntegrityManager> r12 = com.facebook.appevents.integrity.IntegrityManager.class
            boolean r15 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            java.lang.String r2 = "parameters"
            if (r15 == 0) goto L_0x0114
            goto L_0x018c
        L_0x0114:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)     // Catch:{ all -> 0x0188 }
            boolean r15 = com.facebook.appevents.integrity.IntegrityManager.enabled     // Catch:{ all -> 0x0188 }
            if (r15 == 0) goto L_0x018c
            boolean r15 = r10.isEmpty()     // Catch:{ all -> 0x0188 }
            if (r15 == 0) goto L_0x0122
            goto L_0x018c
        L_0x0122:
            java.util.Set r15 = r10.keySet()     // Catch:{ Exception -> 0x0186 }
            java.util.List r15 = kotlin.collections.ArraysKt___ArraysJvmKt.toList(r15)     // Catch:{ Exception -> 0x0186 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0186 }
            r4.<init>()     // Catch:{ Exception -> 0x0186 }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ Exception -> 0x0186 }
        L_0x0133:
            boolean r5 = r15.hasNext()     // Catch:{ Exception -> 0x0186 }
            if (r5 == 0) goto L_0x0171
            java.lang.Object r5 = r15.next()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0186 }
            java.lang.Object r6 = r10.get(r5)     // Catch:{ Exception -> 0x0186 }
            if (r6 == 0) goto L_0x0165
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0186 }
            com.facebook.appevents.integrity.IntegrityManager r7 = com.facebook.appevents.integrity.IntegrityManager.INSTANCE     // Catch:{ Exception -> 0x0186 }
            boolean r7 = r7.shouldFilter(r5)     // Catch:{ Exception -> 0x0186 }
            if (r7 != 0) goto L_0x0157
            com.facebook.appevents.integrity.IntegrityManager r7 = com.facebook.appevents.integrity.IntegrityManager.INSTANCE     // Catch:{ Exception -> 0x0186 }
            boolean r7 = r7.shouldFilter(r6)     // Catch:{ Exception -> 0x0186 }
            if (r7 == 0) goto L_0x0133
        L_0x0157:
            r10.remove(r5)     // Catch:{ Exception -> 0x0186 }
            boolean r7 = com.facebook.appevents.integrity.IntegrityManager.isSampleEnabled     // Catch:{ Exception -> 0x0186 }
            if (r7 == 0) goto L_0x015f
            goto L_0x0161
        L_0x015f:
            java.lang.String r6 = ""
        L_0x0161:
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0186 }
            goto L_0x0133
        L_0x0165:
            java.lang.String r15 = "Required value was null."
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x0186 }
            java.lang.String r15 = r15.toString()     // Catch:{ Exception -> 0x0186 }
            r4.<init>(r15)     // Catch:{ Exception -> 0x0186 }
            throw r4     // Catch:{ Exception -> 0x0186 }
        L_0x0171:
            int r15 = r4.length()     // Catch:{ Exception -> 0x0186 }
            if (r15 == 0) goto L_0x018c
            java.lang.String r15 = "_onDeviceParams"
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0186 }
            java.lang.String r5 = "restrictiveParamJson.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ Exception -> 0x0186 }
            r10.put(r15, r4)     // Catch:{ Exception -> 0x0186 }
            goto L_0x018c
        L_0x0186:
            goto L_0x018c
        L_0x0188:
            r15 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r15, r12)
        L_0x018c:
            com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager r12 = com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager.INSTANCE
            java.lang.String r12 = r8.name
            boolean r15 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r13)
            if (r15 == 0) goto L_0x0198
            goto L_0x0210
        L_0x0198:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)     // Catch:{ all -> 0x020c }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)     // Catch:{ all -> 0x020c }
            boolean r15 = com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager.enabled     // Catch:{ all -> 0x020c }
            if (r15 != 0) goto L_0x01a3
            goto L_0x0210
        L_0x01a3:
            java.util.HashMap r15 = new java.util.HashMap     // Catch:{ all -> 0x020c }
            r15.<init>()     // Catch:{ all -> 0x020c }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x020c }
            java.util.Set r5 = r10.keySet()     // Catch:{ all -> 0x020c }
            r4.<init>(r5)     // Catch:{ all -> 0x020c }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x020c }
        L_0x01b5:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x020c }
            if (r5 == 0) goto L_0x01d0
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x020c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x020c }
            com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager r6 = com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager.INSTANCE     // Catch:{ all -> 0x020c }
            java.lang.String r6 = r6.getMatchedRuleType(r12, r5)     // Catch:{ all -> 0x020c }
            if (r6 == 0) goto L_0x01b5
            r15.put(r5, r6)     // Catch:{ all -> 0x020c }
            r10.remove(r5)     // Catch:{ all -> 0x020c }
            goto L_0x01b5
        L_0x01d0:
            boolean r12 = r15.isEmpty()     // Catch:{ all -> 0x020c }
            r12 = r12 ^ r9
            if (r12 == 0) goto L_0x0210
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x020a }
            r12.<init>()     // Catch:{ JSONException -> 0x020a }
            java.util.Set r15 = r15.entrySet()     // Catch:{ JSONException -> 0x020a }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ JSONException -> 0x020a }
        L_0x01e4:
            boolean r4 = r15.hasNext()     // Catch:{ JSONException -> 0x020a }
            if (r4 == 0) goto L_0x0200
            java.lang.Object r4 = r15.next()     // Catch:{ JSONException -> 0x020a }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ JSONException -> 0x020a }
            java.lang.Object r5 = r4.getKey()     // Catch:{ JSONException -> 0x020a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ JSONException -> 0x020a }
            java.lang.Object r4 = r4.getValue()     // Catch:{ JSONException -> 0x020a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x020a }
            r12.put(r5, r4)     // Catch:{ JSONException -> 0x020a }
            goto L_0x01e4
        L_0x0200:
            java.lang.String r15 = "_restrictedParams"
            java.lang.String r12 = r12.toString()     // Catch:{ JSONException -> 0x020a }
            r10.put(r15, r12)     // Catch:{ JSONException -> 0x020a }
            goto L_0x0210
        L_0x020a:
            goto L_0x0210
        L_0x020c:
            r12 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r12, r13)
        L_0x0210:
            com.facebook.appevents.eventdeactivation.EventDeactivationManager r12 = com.facebook.appevents.eventdeactivation.EventDeactivationManager.INSTANCE
            java.lang.String r12 = r8.name
            java.lang.Class<com.facebook.appevents.eventdeactivation.EventDeactivationManager> r13 = com.facebook.appevents.eventdeactivation.EventDeactivationManager.class
            boolean r15 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r13)
            if (r15 == 0) goto L_0x021d
            goto L_0x0271
        L_0x021d:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)     // Catch:{ all -> 0x026d }
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)     // Catch:{ all -> 0x026d }
            boolean r15 = com.facebook.appevents.eventdeactivation.EventDeactivationManager.enabled     // Catch:{ all -> 0x026d }
            if (r15 != 0) goto L_0x0228
            goto L_0x0271
        L_0x0228:
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x026d }
            java.util.Set r0 = r10.keySet()     // Catch:{ all -> 0x026d }
            r15.<init>(r0)     // Catch:{ all -> 0x026d }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x026d }
            java.util.List<com.facebook.appevents.eventdeactivation.EventDeactivationManager$DeprecatedParamFilter> r2 = com.facebook.appevents.eventdeactivation.EventDeactivationManager.deprecatedParamFilters     // Catch:{ all -> 0x026d }
            r0.<init>(r2)     // Catch:{ all -> 0x026d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x026d }
        L_0x023c:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x026d }
            if (r2 == 0) goto L_0x0271
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x026d }
            com.facebook.appevents.eventdeactivation.EventDeactivationManager$DeprecatedParamFilter r2 = (com.facebook.appevents.eventdeactivation.EventDeactivationManager.DeprecatedParamFilter) r2     // Catch:{ all -> 0x026d }
            java.lang.String r4 = r2.eventName     // Catch:{ all -> 0x026d }
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r12)     // Catch:{ all -> 0x026d }
            if (r4 != 0) goto L_0x0251
            goto L_0x023c
        L_0x0251:
            java.util.Iterator r4 = r15.iterator()     // Catch:{ all -> 0x026d }
        L_0x0255:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x026d }
            if (r5 == 0) goto L_0x023c
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x026d }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x026d }
            java.util.List<java.lang.String> r6 = r2.deprecateParams     // Catch:{ all -> 0x026d }
            boolean r6 = r6.contains(r5)     // Catch:{ all -> 0x026d }
            if (r6 == 0) goto L_0x0255
            r10.remove(r5)     // Catch:{ all -> 0x026d }
            goto L_0x0255
        L_0x026d:
            r12 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r12, r13)
        L_0x0271:
            java.util.Set r12 = r10.keySet()
            java.util.Iterator r12 = r12.iterator()
        L_0x0279:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x028d
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r15 = r10.get(r13)
            r1.put(r13, r15)
            goto L_0x0279
        L_0x028d:
            if (r11 == 0) goto L_0x0298
            double r10 = r11.doubleValue()
            java.lang.String r12 = "_valueToSum"
            r1.put(r12, r10)
        L_0x0298:
            boolean r10 = r8.inBackground
            if (r10 == 0) goto L_0x02a1
            java.lang.String r10 = "_inBackground"
            r1.put(r10, r14)
        L_0x02a1:
            boolean r10 = r8.isImplicit
            if (r10 == 0) goto L_0x02ab
            java.lang.String r9 = "_implicitlyLogged"
            r1.put(r9, r14)
            goto L_0x02c3
        L_0x02ab:
            com.facebook.internal.Logger$Companion r10 = com.facebook.internal.Logger.Companion
            com.facebook.LoggingBehavior r11 = com.facebook.LoggingBehavior.APP_EVENTS
            java.lang.Object[] r9 = new java.lang.Object[r9]
            java.lang.String r12 = r1.toString()
            java.lang.String r13 = "eventObject.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            r9[r3] = r12
            java.lang.String r12 = "AppEvents"
            java.lang.String r13 = "Created app event '%s'"
            r10.log(r11, r12, r13, r9)
        L_0x02c3:
            r8.jsonObject = r1
            java.lang.String r9 = r8.calculateChecksum()
            r8.checksum = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEvent.<init>(java.lang.String, java.lang.String, java.lang.Double, android.os.Bundle, boolean, boolean, java.util.UUID):void");
    }

    private final Object writeReplace() throws ObjectStreamException {
        String jSONObject = this.jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
        return new SerializationProxyV2(jSONObject, this.isImplicit, this.inBackground, this.checksum);
    }

    public final String calculateChecksum() {
        String jSONObject = this.jsonObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonObject.toString()");
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
            byte[] bytes = jSONObject.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            instance.update(bytes, 0, bytes.length);
            byte[] digest = instance.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "digest.digest()");
            return AppEventUtility.bytesToHex(digest);
        } catch (NoSuchAlgorithmException e2) {
            Utility.logd("Failed to generate checksum: ", e2);
            return "0";
        } catch (UnsupportedEncodingException e3) {
            Utility.logd("Failed to generate checksum: ", e3);
            return "1";
        }
    }

    public String toString() {
        return GeneratedOutlineSupport.outline70(new Object[]{this.jsonObject.optString("_eventName"), Boolean.valueOf(this.isImplicit), this.jsonObject.toString()}, 3, "\"%s\", implicit: %b, json: %s", "java.lang.String.format(format, *args)");
    }

    public AppEvent(String str, boolean z, boolean z2, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        JSONObject jSONObject = new JSONObject(str);
        this.jsonObject = jSONObject;
        this.isImplicit = z;
        String optString = jSONObject.optString("_eventName");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(Constants.EVENT_NAME_EVENT_KEY)");
        this.name = optString;
        this.checksum = str2;
        this.inBackground = z2;
    }
}
