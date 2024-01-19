package com.facebook.appevents.codeless.internal;

import android.widget.TextView;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\rH\u0007¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/codeless/internal/SensitiveUserDataUtils;", "", "()V", "isCreditCard", "", "view", "Landroid/widget/TextView;", "isEmail", "isPassword", "isPersonName", "isPhoneNumber", "isPostalAddress", "isSensitiveUserData", "Landroid/view/View;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SensitiveUserDataUtils.kt */
public final class SensitiveUserDataUtils {
    public static final SensitiveUserDataUtils INSTANCE = new SensitiveUserDataUtils();

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00d6, code lost:
        if (r7 == false) goto L_0x00d9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004b A[SYNTHETIC, Splitter:B:23:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005e A[Catch:{ all -> 0x002d, all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007d A[Catch:{ all -> 0x002d, all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009b A[Catch:{ all -> 0x002d, all -> 0x00da }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean isSensitiveUserData(android.view.View r7) {
        /*
            java.lang.Class<com.facebook.appevents.codeless.internal.SensitiveUserDataUtils> r0 = com.facebook.appevents.codeless.internal.SensitiveUserDataUtils.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r0)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            boolean r1 = r7 instanceof android.widget.TextView     // Catch:{ all -> 0x00da }
            if (r1 == 0) goto L_0x00d9
            com.facebook.appevents.codeless.internal.SensitiveUserDataUtils r1 = INSTANCE     // Catch:{ all -> 0x00da }
            r3 = r7
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ all -> 0x00da }
            boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ all -> 0x00da }
            r5 = 1
            if (r4 == 0) goto L_0x001c
        L_0x001a:
            r1 = 0
            goto L_0x0032
        L_0x001c:
            int r4 = r3.getInputType()     // Catch:{ all -> 0x002d }
            r6 = 128(0x80, float:1.8E-43)
            if (r4 != r6) goto L_0x0026
            r1 = 1
            goto L_0x0032
        L_0x0026:
            android.text.method.TransformationMethod r3 = r3.getTransformationMethod()     // Catch:{ all -> 0x002d }
            boolean r1 = r3 instanceof android.text.method.PasswordTransformationMethod     // Catch:{ all -> 0x002d }
            goto L_0x0032
        L_0x002d:
            r3 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r1)     // Catch:{ all -> 0x00da }
            goto L_0x001a
        L_0x0032:
            if (r1 != 0) goto L_0x00d8
            com.facebook.appevents.codeless.internal.SensitiveUserDataUtils r1 = INSTANCE     // Catch:{ all -> 0x00da }
            r3 = r7
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ all -> 0x00da }
            boolean r1 = r1.isCreditCard(r3)     // Catch:{ all -> 0x00da }
            if (r1 != 0) goto L_0x00d8
            com.facebook.appevents.codeless.internal.SensitiveUserDataUtils r1 = INSTANCE     // Catch:{ all -> 0x00da }
            r3 = r7
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ all -> 0x00da }
            boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ all -> 0x00da }
            if (r4 == 0) goto L_0x004b
            goto L_0x0055
        L_0x004b:
            int r1 = r3.getInputType()     // Catch:{ all -> 0x0057 }
            r3 = 96
            if (r1 != r3) goto L_0x0055
            r1 = 1
            goto L_0x005c
        L_0x0055:
            r1 = 0
            goto L_0x005c
        L_0x0057:
            r3 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r1)     // Catch:{ all -> 0x00da }
            goto L_0x0055
        L_0x005c:
            if (r1 != 0) goto L_0x00d8
            com.facebook.appevents.codeless.internal.SensitiveUserDataUtils r1 = INSTANCE     // Catch:{ all -> 0x00da }
            r3 = r7
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ all -> 0x00da }
            boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ all -> 0x00da }
            if (r4 == 0) goto L_0x006a
            goto L_0x0074
        L_0x006a:
            int r1 = r3.getInputType()     // Catch:{ all -> 0x0076 }
            r3 = 112(0x70, float:1.57E-43)
            if (r1 != r3) goto L_0x0074
            r1 = 1
            goto L_0x007b
        L_0x0074:
            r1 = 0
            goto L_0x007b
        L_0x0076:
            r3 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r1)     // Catch:{ all -> 0x00da }
            goto L_0x0074
        L_0x007b:
            if (r1 != 0) goto L_0x00d8
            com.facebook.appevents.codeless.internal.SensitiveUserDataUtils r1 = INSTANCE     // Catch:{ all -> 0x00da }
            r3 = r7
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ all -> 0x00da }
            boolean r4 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ all -> 0x00da }
            if (r4 == 0) goto L_0x0089
            goto L_0x0092
        L_0x0089:
            int r1 = r3.getInputType()     // Catch:{ all -> 0x0094 }
            r3 = 3
            if (r1 != r3) goto L_0x0092
            r1 = 1
            goto L_0x0099
        L_0x0092:
            r1 = 0
            goto L_0x0099
        L_0x0094:
            r3 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r3, r1)     // Catch:{ all -> 0x00da }
            goto L_0x0092
        L_0x0099:
            if (r1 != 0) goto L_0x00d8
            com.facebook.appevents.codeless.internal.SensitiveUserDataUtils r1 = INSTANCE     // Catch:{ all -> 0x00da }
            android.widget.TextView r7 = (android.widget.TextView) r7     // Catch:{ all -> 0x00da }
            boolean r3 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ all -> 0x00da }
            if (r3 == 0) goto L_0x00a6
            goto L_0x00cf
        L_0x00a6:
            int r3 = r7.getInputType()     // Catch:{ all -> 0x00d1 }
            r4 = 32
            if (r3 != r4) goto L_0x00b0
            r7 = 1
            goto L_0x00d6
        L_0x00b0:
            com.facebook.appevents.codeless.internal.ViewHierarchy r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE     // Catch:{ all -> 0x00d1 }
            java.lang.String r7 = com.facebook.appevents.codeless.internal.ViewHierarchy.getTextOfView(r7)     // Catch:{ all -> 0x00d1 }
            if (r7 == 0) goto L_0x00cf
            int r3 = r7.length()     // Catch:{ all -> 0x00d1 }
            if (r3 != 0) goto L_0x00c0
            r3 = 1
            goto L_0x00c1
        L_0x00c0:
            r3 = 0
        L_0x00c1:
            if (r3 == 0) goto L_0x00c4
            goto L_0x00cf
        L_0x00c4:
            java.util.regex.Pattern r3 = android.util.Patterns.EMAIL_ADDRESS     // Catch:{ all -> 0x00d1 }
            java.util.regex.Matcher r7 = r3.matcher(r7)     // Catch:{ all -> 0x00d1 }
            boolean r7 = r7.matches()     // Catch:{ all -> 0x00d1 }
            goto L_0x00d6
        L_0x00cf:
            r7 = 0
            goto L_0x00d6
        L_0x00d1:
            r7 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r1)     // Catch:{ all -> 0x00da }
            goto L_0x00cf
        L_0x00d6:
            if (r7 == 0) goto L_0x00d9
        L_0x00d8:
            r2 = 1
        L_0x00d9:
            return r2
        L_0x00da:
            r7 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.SensitiveUserDataUtils.isSensitiveUserData(android.view.View):boolean");
    }

    public final boolean isCreditCard(TextView textView) {
        int i;
        boolean z = false;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            ViewHierarchy viewHierarchy = ViewHierarchy.INSTANCE;
            String replace = new Regex((String) "\\s").replace(ViewHierarchy.getTextOfView(textView), "");
            int length = replace.length();
            if (length >= 12) {
                if (length <= 19) {
                    int i2 = length - 1;
                    if (i2 >= 0) {
                        boolean z2 = false;
                        i = 0;
                        while (true) {
                            int i3 = i2 - 1;
                            char charAt = replace.charAt(i2);
                            if (!Character.isDigit(charAt)) {
                                return false;
                            }
                            int digit = Character.digit(charAt, 10);
                            if (digit >= 0) {
                                if (z2) {
                                    digit *= 2;
                                    if (digit > 9) {
                                        digit = (digit % 10) + 1;
                                    }
                                }
                                i += digit;
                                z2 = !z2;
                                if (i3 < 0) {
                                    break;
                                }
                                i2 = i3;
                            } else {
                                throw new IllegalArgumentException("Char " + charAt + " is not a decimal digit");
                            }
                        }
                    } else {
                        i = 0;
                    }
                    if (i % 10 == 0) {
                        z = true;
                    }
                }
            }
            return z;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
