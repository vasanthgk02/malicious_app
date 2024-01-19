package com.facebook.login;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt__CharKt;
import org.apache.pdfbox.filter.ASCII85InputStream;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB!\b\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006B+\b\u0016\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/facebook/login/LoginConfiguration;", "", "permissions", "", "", "nonce", "(Ljava/util/Collection;Ljava/lang/String;)V", "codeVerifier", "(Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;)V", "getCodeVerifier", "()Ljava/lang/String;", "getNonce", "", "getPermissions", "()Ljava/util/Set;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginConfiguration.kt */
public final class LoginConfiguration {
    public final String codeVerifier;
    public final String nonce;
    public final Set<String> permissions;

    public LoginConfiguration(Collection collection, String str, int i) {
        String str2;
        boolean z;
        HashSet hashSet;
        Collection collection2 = collection;
        if ((i & 2) != 0) {
            str2 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(str2, "randomUUID().toString()");
        } else {
            str2 = null;
        }
        Intrinsics.checkNotNullParameter(str2, "nonce");
        IntRange intRange = new IntRange(43, 128);
        Default defaultR = Random.Default;
        Intrinsics.checkNotNullParameter(intRange, "<this>");
        Intrinsics.checkNotNullParameter(defaultR, "random");
        try {
            int nextInt = TweetUtils.nextInt(defaultR, intRange);
            List plus = ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) ArraysKt___ArraysJvmKt.plus((Collection<? extends T>) ArraysKt___ArraysJvmKt.plus((Iterable<? extends T>) new CharRange<Object>('a', 'z'), (Iterable<? extends T>) new CharRange<Object>('A', 'Z')), (Iterable<? extends T>) new CharRange<Object>('0', '9')), Character.valueOf('-')), Character.valueOf('.')), Character.valueOf('_')), Character.valueOf(ASCII85InputStream.TERMINATOR));
            ArrayList arrayList = new ArrayList(nextInt);
            int i2 = 0;
            while (i2 < nextInt) {
                Default defaultR2 = Random.Default;
                Intrinsics.checkNotNullParameter(plus, "<this>");
                Intrinsics.checkNotNullParameter(defaultR2, "random");
                ArrayList arrayList2 = (ArrayList) plus;
                if (!arrayList2.isEmpty()) {
                    int nextInt2 = defaultR2.nextInt(arrayList2.size());
                    Intrinsics.checkNotNullParameter(plus, "<this>");
                    arrayList.add(Character.valueOf(((Character) arrayList2.get(nextInt2)).charValue()));
                    i2++;
                } else {
                    throw new NoSuchElementException("Collection is empty.");
                }
            }
            String joinToString$default = ArraysKt___ArraysJvmKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62);
            Intrinsics.checkNotNullParameter(str2, "nonce");
            Intrinsics.checkNotNullParameter(joinToString$default, "codeVerifier");
            boolean z2 = true;
            if (str2.length() == 0) {
                z = false;
            } else {
                z = !(CharsKt__CharKt.indexOf$default((CharSequence) str2, ' ', 0, false, 6) >= 0);
            }
            if ((!z || !PKCEUtil.isValidCodeVerifier(joinToString$default)) ? false : z2) {
                if (collection2 != null) {
                    hashSet = new HashSet(collection2);
                } else {
                    hashSet = new HashSet();
                }
                hashSet.add("openid");
                Set<String> unmodifiableSet = Collections.unmodifiableSet(hashSet);
                Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(permissions)");
                this.permissions = unmodifiableSet;
                this.nonce = str2;
                this.codeVerifier = joinToString$default;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        } catch (IllegalArgumentException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
