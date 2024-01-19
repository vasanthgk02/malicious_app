package com.netcore.android.inapp;

import android.app.Activity;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.netcore.android.SMTActivityLifecycleCallback;
import com.netcore.android.SMTConfigConstants;
import com.netcore.android.inapp.h.b;
import com.netcore.android.inapp.h.b.C0012b;
import com.netcore.android.logger.SMTLogger;
import com.netcore.android.utility.SMTCommonUtility;
import com.userexperior.models.recording.enums.UeCustomType;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.CharsKt__CharKt;
import org.jboss.netty.channel.ChannelPipelineCoverage;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SMTInAppUtility.kt */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1212a = "g";

    /* renamed from: b  reason: collision with root package name */
    public static final a f1213b = new a(null);

    /* compiled from: SMTInAppUtility.kt */
    public static final class a {

        /* renamed from: com.netcore.android.inapp.g$a$a  reason: collision with other inner class name */
        /* compiled from: SMTInAppUtility.kt */
        public static final class C0011a extends Lambda implements Function0<Unit> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ InAppCustomHTMLListener f1214a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ JSONObject f1215b;

            /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
            public C0011a(InAppCustomHTMLListener inAppCustomHTMLListener, JSONObject jSONObject) {
                // this.f1214a = inAppCustomHTMLListener;
                // this.f1215b = jSONObject;
                super(0);
            }

            public final void a() {
                this.f1214a.customHTMLCallback(SMTCommonUtility.INSTANCE.jsonToMap(this.f1215b));
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        public a() {
        }

        private final boolean b(String str, C0012b bVar) {
            if (str == null) {
                return false;
            }
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String d2 = bVar.d();
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "Locale.getDefault()");
            if (d2 != null) {
                String lowerCase2 = d2.toLowerCase(locale2);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                String c2 = bVar.c();
                if (c2 != null) {
                    String obj = CharsKt__CharKt.trim(c2).toString();
                    switch (obj.hashCode()) {
                        case -1555538761:
                            if (obj.equals("startsWith")) {
                                return CharsKt__CharKt.startsWith$default(lowerCase, lowerCase2, false, 2);
                            }
                            return false;
                        case -567445985:
                            if (obj.equals("contains")) {
                                return CharsKt__CharKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2);
                            }
                            return false;
                        case -235965991:
                            if (obj.equals("doesNotContains")) {
                                return !CharsKt__CharKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2);
                            }
                            return false;
                        case 3370:
                            if (obj.equals("is")) {
                                return Intrinsics.areEqual(lowerCase, lowerCase2);
                            }
                            return false;
                        case 1743158238:
                            if (obj.equals("endsWith")) {
                                return CharsKt__CharKt.endsWith$default(lowerCase, lowerCase2, false, 2);
                            }
                            return false;
                        default:
                            return false;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }

        public final Activity a() {
            WeakReference<Activity> activity = SMTActivityLifecycleCallback.Companion.getInstance().getActivity();
            if (activity != null) {
                return (Activity) activity.get();
            }
            return null;
        }

        public final boolean a(int i) {
            switch (i) {
                case 41:
                case 42:
                case 43:
                    return true;
                default:
                    return false;
            }
        }

        public final boolean c() {
            return SMTActivityLifecycleCallback.Companion.getInstance().isAppInForeground();
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int a(String str) {
            if (Pattern.matches("^[^.]+\\[]\\.[^.]+$", str)) {
                return 2;
            }
            if (Pattern.matches("^[^.]+\\[]$", str)) {
                return 1;
            }
            if (Pattern.matches("^[^.]+\\.[^.]+$", str)) {
                return 4;
            }
            return Pattern.matches("^[^.]+$", str) ? 3 : 5;
        }

        private final String a(String str, int i, boolean z) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return str;
                    }
                    if (i == 4) {
                        if (z) {
                            int indexOf$default = CharsKt__CharKt.indexOf$default((CharSequence) str, (String) ".", 0, false, 6);
                            if (str != null) {
                                String substring = str.substring(0, indexOf$default);
                                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                return substring;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        int indexOf$default2 = CharsKt__CharKt.indexOf$default((CharSequence) str, (String) ".", 0, false, 6) + 1;
                        if (str != null) {
                            String substring2 = str.substring(indexOf$default2);
                            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                            return substring2;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else if (z) {
                    int indexOf$default3 = CharsKt__CharKt.indexOf$default((CharSequence) str, (String) "^", 0, false, 6) + 1;
                    int indexOf$default4 = CharsKt__CharKt.indexOf$default((CharSequence) str, (String) "[", 0, false, 6);
                    if (str != null) {
                        String substring3 = str.substring(indexOf$default3, indexOf$default4);
                        Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        return substring3;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                } else {
                    int indexOf$default5 = CharsKt__CharKt.indexOf$default((CharSequence) str, (String) ".", 0, false, 6) + 1;
                    if (str != null) {
                        String substring4 = str.substring(indexOf$default5);
                        Intrinsics.checkNotNullExpressionValue(substring4, "(this as java.lang.String).substring(startIndex)");
                        return substring4;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (z) {
                int indexOf$default6 = CharsKt__CharKt.indexOf$default((CharSequence) str, (String) "[", 0, false, 6);
                if (str != null) {
                    String substring5 = str.substring(0, indexOf$default6);
                    Intrinsics.checkNotNullExpressionValue(substring5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    return substring5;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            return null;
        }

        private final boolean a(String str, C0012b bVar) {
            if (str == null) {
                return false;
            }
            String d2 = bVar.d();
            if (d2 != null) {
                String obj = CharsKt__CharKt.trim(d2).toString();
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
                if (obj != null) {
                    String lowerCase = obj.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String c2 = bVar.c();
                    if (c2 != null) {
                        String obj2 = CharsKt__CharKt.trim(c2).toString();
                        int hashCode = obj2.hashCode();
                        if (hashCode != 60) {
                            if (hashCode != 62) {
                                if (hashCode != 1084) {
                                    if (hashCode != 1921) {
                                        if (hashCode != 1952) {
                                            if (hashCode != 1983 || !obj2.equals(">=") || Float.parseFloat(str) < Float.parseFloat(lowerCase)) {
                                                return false;
                                            }
                                        } else if (!obj2.equals("==") || Float.parseFloat(str) != Float.parseFloat(lowerCase)) {
                                            return false;
                                        }
                                    } else if (!obj2.equals("<=") || Float.parseFloat(str) > Float.parseFloat(lowerCase)) {
                                        return false;
                                    }
                                } else if (!obj2.equals("!=") || Float.parseFloat(str) == Float.parseFloat(lowerCase)) {
                                    return false;
                                }
                            } else if (!obj2.equals(">") || Float.parseFloat(str) <= Float.parseFloat(lowerCase)) {
                                return false;
                            }
                        } else if (!obj2.equals("<") || Float.parseFloat(str) >= Float.parseFloat(lowerCase)) {
                            return false;
                        }
                        return true;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }

        public final boolean b(b bVar, Date date) {
            Intrinsics.checkNotNullParameter(bVar, "inAppRule");
            Intrinsics.checkNotNullParameter(date, DatePickerDialogModule.ARG_DATE);
            if (bVar.o().b().size() <= 0 || bVar.o().b().size() != 1) {
                return true;
            }
            Date parse = new SimpleDateFormat("HH:mm", Locale.getDefault()).parse(new SimpleDateFormat("HH:mm", Locale.getDefault()).format(date));
            Date parse2 = new SimpleDateFormat("HH:mm", Locale.getDefault()).parse(bVar.o().b().get(0).b());
            Date parse3 = new SimpleDateFormat("HH:mm", Locale.getDefault()).parse(bVar.o().b().get(0).a());
            if (!parse2.after(parse) || !parse3.before(parse)) {
                return false;
            }
            return true;
        }

        public final long b() {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            Intrinsics.checkNotNullExpressionValue(instance, "calendar");
            Date time = instance.getTime();
            Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
            return time.getTime();
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x0099 A[Catch:{ Exception -> 0x014f }] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00d0 A[Catch:{ Exception -> 0x014f }] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00fb A[Catch:{ Exception -> 0x014f }] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0123 A[Catch:{ Exception -> 0x014f }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(java.util.ArrayList<com.netcore.android.inapp.h.b.C0012b> r18, java.lang.String r19, java.util.HashMap<java.lang.String, java.lang.Object> r20) {
            /*
                r17 = this;
                r1 = r17
                r0 = r18
                r2 = r19
                r3 = r20
                java.lang.String r4 = "filterType"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
                java.lang.String r4 = "eventPayLoad"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
                com.netcore.android.utility.SMTCommonUtility r4 = com.netcore.android.utility.SMTCommonUtility.INSTANCE
                org.json.JSONObject r5 = new org.json.JSONObject
                r5.<init>(r3)
                r3 = 1
                org.json.JSONObject r5 = r4.jsonKeyCaseConverter(r5, r3)
                java.util.HashMap r4 = r4.jsonToHashMap(r5)
                java.lang.String r5 = "TAG"
                r6 = 0
                if (r0 == 0) goto L_0x016b
                int r7 = r18.size()     // Catch:{ Exception -> 0x014f }
                if (r7 <= 0) goto L_0x016b
                int r7 = r18.size()     // Catch:{ Exception -> 0x014f }
                r8 = 0
                r9 = 0
            L_0x0033:
                if (r8 >= r7) goto L_0x016b
                java.lang.Object r10 = r0.get(r8)     // Catch:{ Exception -> 0x014f }
                com.netcore.android.inapp.h.b$b r10 = (com.netcore.android.inapp.h.b.C0012b) r10     // Catch:{ Exception -> 0x014f }
                java.lang.String r10 = r10.b()     // Catch:{ Exception -> 0x014f }
                int r11 = r1.a(r10)     // Catch:{ Exception -> 0x014f }
                java.lang.Object r12 = r0.get(r8)     // Catch:{ Exception -> 0x014f }
                com.netcore.android.inapp.h.b$b r12 = (com.netcore.android.inapp.h.b.C0012b) r12     // Catch:{ Exception -> 0x014f }
                java.lang.String r12 = r12.a()     // Catch:{ Exception -> 0x014f }
                java.lang.String r13 = "string"
                boolean r12 = kotlin.text.CharsKt__CharKt.equals(r12, r13, r3)     // Catch:{ Exception -> 0x014f }
                java.lang.String r13 = "payload"
                java.lang.Object r13 = r4.get(r13)     // Catch:{ Exception -> 0x014f }
                java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ Exception -> 0x014f }
                int r14 = r13.length()     // Catch:{ Exception -> 0x014f }
                if (r14 != 0) goto L_0x0065
                r14 = 1
                goto L_0x0066
            L_0x0065:
                r14 = 0
            L_0x0066:
                if (r14 != 0) goto L_0x0134
                org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x014f }
                java.lang.CharSequence r13 = kotlin.text.CharsKt__CharKt.trim(r13)     // Catch:{ Exception -> 0x014f }
                java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x014f }
                r14.<init>(r13)     // Catch:{ Exception -> 0x014f }
                java.lang.String r13 = "filters[i]"
                if (r11 == r3) goto L_0x0111
                r15 = 2
                if (r11 == r15) goto L_0x00e7
                r15 = 3
                if (r11 == r15) goto L_0x00be
                r15 = 4
                if (r11 == r15) goto L_0x0085
                r9 = 0
                goto L_0x0134
            L_0x0085:
                java.lang.String r11 = r1.a(r10, r15, r3)     // Catch:{ Exception -> 0x014f }
                if (r11 == 0) goto L_0x0095
                int r16 = r11.length()     // Catch:{ Exception -> 0x014f }
                if (r16 != 0) goto L_0x0092
                goto L_0x0095
            L_0x0092:
                r16 = 0
                goto L_0x0097
            L_0x0095:
                r16 = 1
            L_0x0097:
                if (r16 != 0) goto L_0x0134
                org.json.JSONObject r11 = r14.optJSONObject(r11)     // Catch:{ Exception -> 0x014f }
                if (r11 == 0) goto L_0x0134
                java.lang.String r10 = r1.a(r10, r15, r6)     // Catch:{ Exception -> 0x014f }
                if (r10 == 0) goto L_0x0134
                java.lang.Object r9 = r11.opt(r10)     // Catch:{ Exception -> 0x014f }
                java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x014f }
                com.netcore.android.inapp.g$a r10 = com.netcore.android.inapp.g.f1213b     // Catch:{ Exception -> 0x014f }
                java.lang.Object r11 = r0.get(r8)     // Catch:{ Exception -> 0x014f }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)     // Catch:{ Exception -> 0x014f }
                com.netcore.android.inapp.h.b$b r11 = (com.netcore.android.inapp.h.b.C0012b) r11     // Catch:{ Exception -> 0x014f }
                boolean r9 = r10.a(r9, r11, r12)     // Catch:{ Exception -> 0x014f }
                goto L_0x0134
            L_0x00be:
                java.lang.String r10 = r1.a(r10, r15, r3)     // Catch:{ Exception -> 0x014f }
                if (r10 == 0) goto L_0x00cd
                int r11 = r10.length()     // Catch:{ Exception -> 0x014f }
                if (r11 != 0) goto L_0x00cb
                goto L_0x00cd
            L_0x00cb:
                r11 = 0
                goto L_0x00ce
            L_0x00cd:
                r11 = 1
            L_0x00ce:
                if (r11 != 0) goto L_0x0134
                java.lang.String r9 = r14.optString(r10)     // Catch:{ Exception -> 0x014f }
                java.lang.String r10 = "payLoadValue"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ Exception -> 0x014f }
                java.lang.Object r10 = r0.get(r8)     // Catch:{ Exception -> 0x014f }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r13)     // Catch:{ Exception -> 0x014f }
                com.netcore.android.inapp.h.b$b r10 = (com.netcore.android.inapp.h.b.C0012b) r10     // Catch:{ Exception -> 0x014f }
                boolean r9 = r1.a(r9, r10, r12)     // Catch:{ Exception -> 0x014f }
                goto L_0x0134
            L_0x00e7:
                java.lang.String r11 = r1.a(r10, r15, r3)     // Catch:{ Exception -> 0x014f }
                if (r11 == 0) goto L_0x00f7
                int r16 = r11.length()     // Catch:{ Exception -> 0x014f }
                if (r16 != 0) goto L_0x00f4
                goto L_0x00f7
            L_0x00f4:
                r16 = 0
                goto L_0x00f9
            L_0x00f7:
                r16 = 1
            L_0x00f9:
                if (r16 != 0) goto L_0x0134
                org.json.JSONArray r9 = r14.optJSONArray(r11)     // Catch:{ Exception -> 0x014f }
                java.lang.String r10 = r1.a(r10, r15, r6)     // Catch:{ Exception -> 0x014f }
                java.lang.Object r11 = r0.get(r8)     // Catch:{ Exception -> 0x014f }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)     // Catch:{ Exception -> 0x014f }
                com.netcore.android.inapp.h.b$b r11 = (com.netcore.android.inapp.h.b.C0012b) r11     // Catch:{ Exception -> 0x014f }
                boolean r9 = r1.a(r9, r11, r12, r10)     // Catch:{ Exception -> 0x014f }
                goto L_0x0134
            L_0x0111:
                java.lang.String r10 = r1.a(r10, r3, r3)     // Catch:{ Exception -> 0x014f }
                if (r10 == 0) goto L_0x0120
                int r11 = r10.length()     // Catch:{ Exception -> 0x014f }
                if (r11 != 0) goto L_0x011e
                goto L_0x0120
            L_0x011e:
                r11 = 0
                goto L_0x0121
            L_0x0120:
                r11 = 1
            L_0x0121:
                if (r11 != 0) goto L_0x0134
                org.json.JSONArray r9 = r14.optJSONArray(r10)     // Catch:{ Exception -> 0x014f }
                java.lang.Object r10 = r0.get(r8)     // Catch:{ Exception -> 0x014f }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r13)     // Catch:{ Exception -> 0x014f }
                com.netcore.android.inapp.h.b$b r10 = (com.netcore.android.inapp.h.b.C0012b) r10     // Catch:{ Exception -> 0x014f }
                boolean r9 = r1.a(r9, r10, r12)     // Catch:{ Exception -> 0x014f }
            L_0x0134:
                java.lang.String r10 = "all"
                boolean r10 = kotlin.text.CharsKt__CharKt.equals(r2, r10, r3)     // Catch:{ Exception -> 0x014f }
                if (r10 == 0) goto L_0x013f
                if (r9 != 0) goto L_0x014b
                goto L_0x0149
            L_0x013f:
                java.lang.String r10 = "any"
                boolean r10 = kotlin.text.CharsKt__CharKt.equals(r2, r10, r3)     // Catch:{ Exception -> 0x014f }
                if (r10 == 0) goto L_0x014b
                if (r9 == 0) goto L_0x014b
            L_0x0149:
                r3 = r9
                goto L_0x016b
            L_0x014b:
                int r8 = r8 + 1
                goto L_0x0033
            L_0x014f:
                r0 = move-exception
                com.netcore.android.logger.SMTLogger r2 = com.netcore.android.logger.SMTLogger.INSTANCE
                java.lang.String r3 = com.netcore.android.inapp.g.f1212a
                java.lang.String r4 = "Json parsing error: "
                java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline79(r3, r5, r4)
                java.lang.String r0 = r0.getLocalizedMessage()
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r2.e(r3, r0)
                r3 = 0
            L_0x016b:
                com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE
                java.lang.String r2 = com.netcore.android.inapp.g.f1212a
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r5 = "InApp 1: "
                r4.append(r5)
                r4.append(r3)
                java.lang.String r4 = r4.toString()
                r0.i(r2, r4)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.inapp.g.a.a(java.util.ArrayList, java.lang.String, java.util.HashMap):boolean");
        }

        public final String b(String str) {
            Intrinsics.checkNotNullParameter(str, "time");
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SMTConfigConstants.SERVER_TIME_FORMAT, Locale.getDefault());
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date parse = simpleDateFormat.parse(str);
                Intrinsics.checkNotNullExpressionValue(parse, "simpleDateFormat.parse(time)");
                return String.valueOf(parse.getTime());
            } catch (Exception unused) {
                return "";
            }
        }

        public final boolean b(b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "inAppRule");
            return bVar.l() <= bVar.b();
        }

        private final boolean a(JSONArray jSONArray, C0012b bVar, boolean z, String str) {
            if (jSONArray == null || str == null) {
                return false;
            }
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                Object obj = jSONArray.get(i);
                if (obj != null) {
                    boolean a2 = a(((JSONObject) obj).get(str).toString(), bVar, z);
                    if (a2) {
                        return a2;
                    }
                    i++;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                }
            }
            return false;
        }

        private final boolean a(JSONArray jSONArray, C0012b bVar, boolean z) {
            if (jSONArray == null) {
                return false;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                boolean a2 = a(jSONArray.get(i).toString(), bVar, z);
                if (a2) {
                    return a2;
                }
            }
            return false;
        }

        private final boolean a(String str, C0012b bVar, boolean z) {
            if (z) {
                if (str != null) {
                    return b(CharsKt__CharKt.trim(str).toString(), bVar);
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            } else if (str != null) {
                return a(CharsKt__CharKt.trim(str).toString(), bVar);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }

        public final boolean a(b bVar, Date date) {
            Intrinsics.checkNotNullParameter(bVar, "inAppRule");
            Intrinsics.checkNotNullParameter(date, DatePickerDialogModule.ARG_DATE);
            int i = Calendar.getInstance().get(7) - 1;
            if (bVar.o().a().size() <= 0) {
                return false;
            }
            boolean contains = bVar.o().a().contains(String.valueOf(i));
            return contains ? b(bVar, date) : contains;
        }

        public final void a(InAppCustomHTMLListener inAppCustomHTMLListener, String str) {
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (inAppCustomHTMLListener != null) {
                        new C0011a(inAppCustomHTMLListener, jSONObject);
                    }
                } catch (Exception e2) {
                    SMTLogger sMTLogger = SMTLogger.INSTANCE;
                    String a2 = g.f1212a;
                    StringBuilder outline79 = GeneratedOutlineSupport.outline79(a2, UeCustomType.TAG, "Netcore Error: ");
                    outline79.append(e2.getMessage());
                    sMTLogger.e(a2, outline79.toString());
                }
            }
        }

        public final boolean a(b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "inAppRule");
            return Intrinsics.areEqual(bVar.q().d(), ChannelPipelineCoverage.ALL) && Intrinsics.areEqual(bVar.q().e(), ChannelPipelineCoverage.ALL);
        }

        public final boolean a(b bVar, List<String> list, List<String> list2) {
            boolean z;
            Intrinsics.checkNotNullParameter(bVar, "inAppRule");
            Intrinsics.checkNotNullParameter(list, "listIds");
            Intrinsics.checkNotNullParameter(list2, "segIds");
            int size = bVar.q().b().size();
            int size2 = bVar.q().c().size();
            if (size > 0 || size2 > 0) {
                try {
                    SMTCommonUtility sMTCommonUtility = SMTCommonUtility.INSTANCE;
                    if (!sMTCommonUtility.compareLists(list, bVar.q().b())) {
                        z = sMTCommonUtility.compareLists(list2, bVar.q().c());
                        SMTLogger sMTLogger = SMTLogger.INSTANCE;
                        String a2 = g.f1212a;
                        Intrinsics.checkNotNullExpressionValue(a2, UeCustomType.TAG);
                        sMTLogger.i(a2, "InApp 3: " + z);
                        return z;
                    }
                } catch (Exception e2) {
                    SMTLogger sMTLogger2 = SMTLogger.INSTANCE;
                    String a3 = g.f1212a;
                    GeneratedOutlineSupport.outline96(a3, UeCustomType.TAG, e2, sMTLogger2, a3);
                }
            }
            z = true;
            SMTLogger sMTLogger3 = SMTLogger.INSTANCE;
            String a22 = g.f1212a;
            Intrinsics.checkNotNullExpressionValue(a22, UeCustomType.TAG);
            sMTLogger3.i(a22, "InApp 3: " + z);
            return z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ff, code lost:
            if (r6.size() == 0) goto L_0x0101;
         */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0089 A[Catch:{ Exception -> 0x0172 }] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0108 A[Catch:{ Exception -> 0x0172 }] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x015a A[Catch:{ Exception -> 0x0172 }] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x015d A[Catch:{ Exception -> 0x0172 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(android.content.Context r20, com.netcore.android.inapp.h.b r21) {
            /*
                r19 = this;
                r1 = r19
                r0 = r20
                java.lang.String r2 = "TAG"
                java.lang.String r3 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
                java.lang.String r3 = "inAppRule"
                r4 = r21
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
                r3 = 1
                com.netcore.android.inapp.h.b$h r5 = r21.q()     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.inapp.h.b$a r5 = r5.a()     // Catch:{ Exception -> 0x0172 }
                java.util.ArrayList r5 = r5.a()     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.inapp.h.b$h r4 = r21.q()     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.inapp.h.b$a r4 = r4.a()     // Catch:{ Exception -> 0x0172 }
                java.lang.String r4 = r4.b()     // Catch:{ Exception -> 0x0172 }
                int r6 = r5.size()     // Catch:{ Exception -> 0x0172 }
                if (r6 <= 0) goto L_0x017c
                java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0172 }
                r6.<init>()     // Catch:{ Exception -> 0x0172 }
                int r7 = r5.size()     // Catch:{ Exception -> 0x0172 }
                r8 = 0
                r9 = 0
                r10 = 0
            L_0x003d:
                if (r9 >= r7) goto L_0x017d
                java.lang.Object r11 = r5.get(r9)     // Catch:{ Exception -> 0x0172 }
                java.lang.String r12 = "multiEventsRules[i]"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.inapp.h.b$c r11 = (com.netcore.android.inapp.h.b.c) r11     // Catch:{ Exception -> 0x0172 }
                java.lang.String r12 = "all"
                if (r6 == 0) goto L_0x0065
                int r13 = r6.size()     // Catch:{ Exception -> 0x0172 }
                if (r13 <= 0) goto L_0x0065
                boolean r3 = kotlin.text.CharsKt__CharKt.equals(r4, r12, r3)     // Catch:{ Exception -> 0x0172 }
                if (r3 == 0) goto L_0x0065
                java.lang.Object r3 = r6.get(r8)     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.inapp.h.a r3 = (com.netcore.android.inapp.h.a) r3     // Catch:{ Exception -> 0x0172 }
                java.lang.String r3 = r3.a()     // Catch:{ Exception -> 0x0172 }
                goto L_0x0067
            L_0x0065:
                java.lang.String r3 = "0"
            L_0x0067:
                r11.c(r3)     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.event.c r6 = com.netcore.android.event.c.f1074a     // Catch:{ Exception -> 0x0172 }
                java.util.HashMap r6 = r6.a(r11)     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.e.b$a r13 = com.netcore.android.e.b.f1030c     // Catch:{ Exception -> 0x0172 }
                java.lang.ref.WeakReference r14 = new java.lang.ref.WeakReference     // Catch:{ Exception -> 0x0172 }
                android.content.Context r15 = r20.getApplicationContext()     // Catch:{ Exception -> 0x0172 }
                r14.<init>(r15)     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.e.b r13 = r13.b(r14)     // Catch:{ Exception -> 0x0172 }
                java.util.List r6 = r13.b(r6)     // Catch:{ Exception -> 0x0172 }
                java.lang.String r13 = r11.e()     // Catch:{ Exception -> 0x0172 }
                if (r6 == 0) goto L_0x0150
                java.util.ArrayList r10 = r11.d()     // Catch:{ Exception -> 0x0172 }
                java.lang.String r14 = "yes"
                boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)     // Catch:{ Exception -> 0x0172 }
                if (r14 == 0) goto L_0x00c7
                int r14 = r6.size()     // Catch:{ Exception -> 0x0172 }
                if (r14 <= 0) goto L_0x00c7
                java.lang.Object r3 = r6.get(r8)     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.inapp.h.a r3 = (com.netcore.android.inapp.h.a) r3     // Catch:{ Exception -> 0x0172 }
                int r8 = r10.size()     // Catch:{ Exception -> 0x0172 }
                if (r8 <= 0) goto L_0x00c0
                java.lang.String r8 = r11.c()     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.utility.SMTCommonUtility r11 = com.netcore.android.utility.SMTCommonUtility.INSTANCE     // Catch:{ Exception -> 0x0172 }
                org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ Exception -> 0x0172 }
                java.lang.String r3 = r3.b()     // Catch:{ Exception -> 0x0172 }
                r13.<init>(r3)     // Catch:{ Exception -> 0x0172 }
                java.util.HashMap r3 = r11.jsonToHashMap(r13)     // Catch:{ Exception -> 0x0172 }
                boolean r10 = r1.a(r10, r8, r3)     // Catch:{ Exception -> 0x0172 }
                goto L_0x0150
            L_0x00c0:
                r3 = 1
                r8 = r5
                r21 = r6
                r10 = 1
                goto L_0x0153
            L_0x00c7:
                java.lang.String r14 = "no"
                boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)     // Catch:{ Exception -> 0x0172 }
                if (r13 == 0) goto L_0x014a
                int r13 = r6.size()     // Catch:{ Exception -> 0x0172 }
                if (r13 <= 0) goto L_0x00fb
                int r13 = r10.size()     // Catch:{ Exception -> 0x0172 }
                if (r13 <= 0) goto L_0x00fb
                java.lang.Object r8 = r6.get(r8)     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.inapp.h.a r8 = (com.netcore.android.inapp.h.a) r8     // Catch:{ Exception -> 0x0172 }
                java.lang.String r13 = r11.c()     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.utility.SMTCommonUtility r14 = com.netcore.android.utility.SMTCommonUtility.INSTANCE     // Catch:{ Exception -> 0x0172 }
                org.json.JSONObject r15 = new org.json.JSONObject     // Catch:{ Exception -> 0x0172 }
                java.lang.String r8 = r8.b()     // Catch:{ Exception -> 0x0172 }
                r15.<init>(r8)     // Catch:{ Exception -> 0x0172 }
                java.util.HashMap r8 = r14.jsonToHashMap(r15)     // Catch:{ Exception -> 0x0172 }
                boolean r8 = r1.a(r10, r13, r8)     // Catch:{ Exception -> 0x0172 }
                if (r8 != 0) goto L_0x0104
                goto L_0x0101
            L_0x00fb:
                int r8 = r6.size()     // Catch:{ Exception -> 0x0172 }
                if (r8 != 0) goto L_0x0104
            L_0x0101:
                r8 = 1
                r10 = 1
                goto L_0x0106
            L_0x0104:
                r8 = 0
                r10 = 0
            L_0x0106:
                if (r10 == 0) goto L_0x0150
                long r13 = r11.f()     // Catch:{ Exception -> 0x0172 }
                r8 = r5
                r21 = r6
                r5 = 0
                int r11 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
                if (r11 <= 0) goto L_0x0153
                long r15 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0172 }
                long r17 = java.lang.Long.parseLong(r3)     // Catch:{ Exception -> 0x0172 }
                long r15 = r15 - r17
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x0172 }
                long r13 = r3.toMillis(r13)     // Catch:{ Exception -> 0x0172 }
                java.lang.String r3 = "smt_inapp_wait_time"
                r11 = 0
                int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r17 <= 0) goto L_0x0140
                com.netcore.android.preference.SMTPreferenceHelper$Companion r5 = com.netcore.android.preference.SMTPreferenceHelper.Companion     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.preference.SMTPreferenceHelper r6 = r5.getAppPreferenceInstance(r0, r11)     // Catch:{ Exception -> 0x0172 }
                long r13 = r13 - r15
                r6.setLong(r3, r13)     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.preference.SMTPreferenceHelper r3 = r5.getAppPreferenceInstance(r0, r11)     // Catch:{ Exception -> 0x0172 }
                java.lang.String r5 = "smt_inapp_me_pos"
                r3.setInt(r5, r9)     // Catch:{ Exception -> 0x0172 }
                goto L_0x0153
            L_0x0140:
                com.netcore.android.preference.SMTPreferenceHelper$Companion r13 = com.netcore.android.preference.SMTPreferenceHelper.Companion     // Catch:{ Exception -> 0x0172 }
                com.netcore.android.preference.SMTPreferenceHelper r11 = r13.getAppPreferenceInstance(r0, r11)     // Catch:{ Exception -> 0x0172 }
                r11.setLong(r3, r5)     // Catch:{ Exception -> 0x0172 }
                goto L_0x0153
            L_0x014a:
                r8 = r5
                r21 = r6
                r3 = 0
                r10 = 0
                goto L_0x0153
            L_0x0150:
                r8 = r5
                r21 = r6
            L_0x0153:
                r3 = 1
                boolean r5 = kotlin.text.CharsKt__CharKt.equals(r4, r12, r3)     // Catch:{ Exception -> 0x0172 }
                if (r5 == 0) goto L_0x015d
                if (r10 != 0) goto L_0x0168
                goto L_0x017d
            L_0x015d:
                java.lang.String r5 = "any"
                boolean r3 = kotlin.text.CharsKt__CharKt.equals(r4, r5, r3)     // Catch:{ Exception -> 0x0172 }
                if (r3 == 0) goto L_0x0168
                if (r10 == 0) goto L_0x0168
                goto L_0x017d
            L_0x0168:
                int r9 = r9 + 1
                r3 = 1
                r5 = 0
                r6 = r21
                r5 = r8
                r8 = 0
                goto L_0x003d
            L_0x0172:
                r0 = move-exception
                com.netcore.android.logger.SMTLogger r3 = com.netcore.android.logger.SMTLogger.INSTANCE
                java.lang.String r4 = com.netcore.android.inapp.g.f1212a
                com.android.tools.r8.GeneratedOutlineSupport.outline96(r4, r2, r0, r3, r4)
            L_0x017c:
                r10 = 1
            L_0x017d:
                com.netcore.android.logger.SMTLogger r0 = com.netcore.android.logger.SMTLogger.INSTANCE
                java.lang.String r3 = com.netcore.android.inapp.g.f1212a
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r4 = "InApp 4: "
                r2.append(r4)
                r2.append(r10)
                java.lang.String r2 = r2.toString()
                r0.i(r3, r2)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.netcore.android.inapp.g.a.a(android.content.Context, com.netcore.android.inapp.h.b):boolean");
        }
    }
}
