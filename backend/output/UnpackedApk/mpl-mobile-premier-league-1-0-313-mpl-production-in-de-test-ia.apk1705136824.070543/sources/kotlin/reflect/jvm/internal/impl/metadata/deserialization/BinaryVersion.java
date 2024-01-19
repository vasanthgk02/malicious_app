package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysJvmKt$asList$3;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BinaryVersion.kt */
public abstract class BinaryVersion {
    public final int major;
    public final int minor;
    public final int[] numbers;
    public final int patch;
    public final List<Integer> rest;

    public BinaryVersion(int... iArr) {
        List<Integer> list;
        Intrinsics.checkNotNullParameter(iArr, "numbers");
        this.numbers = iArr;
        Integer orNull = TweetUtils.getOrNull(iArr, 0);
        int i = -1;
        this.major = orNull == null ? -1 : orNull.intValue();
        Integer orNull2 = TweetUtils.getOrNull(this.numbers, 1);
        this.minor = orNull2 == null ? -1 : orNull2.intValue();
        Integer orNull3 = TweetUtils.getOrNull(this.numbers, 2);
        this.patch = orNull3 != null ? orNull3.intValue() : i;
        int[] iArr2 = this.numbers;
        if (iArr2.length > 3) {
            Intrinsics.checkNotNullParameter(iArr2, "<this>");
            list = ArraysKt___ArraysJvmKt.toList(new ArraysKt___ArraysJvmKt$asList$3(iArr2).subList(3, this.numbers.length));
        } else {
            list = EmptyList.INSTANCE;
        }
        this.rest = list;
    }

    public boolean equals(Object obj) {
        if (obj != null && Intrinsics.areEqual(getClass(), obj.getClass())) {
            BinaryVersion binaryVersion = (BinaryVersion) obj;
            if (this.major == binaryVersion.major && this.minor == binaryVersion.minor && this.patch == binaryVersion.patch && Intrinsics.areEqual(this.rest, binaryVersion.rest)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.major;
        int i2 = (i * 31) + this.minor + i;
        int i3 = (i2 * 31) + this.patch + i2;
        return this.rest.hashCode() + (i3 * 31) + i3;
    }

    public final boolean isAtLeast(int i, int i2, int i3) {
        int i4 = this.major;
        boolean z = true;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return false;
        }
        int i5 = this.minor;
        if (i5 > i2) {
            return true;
        }
        if (i5 < i2) {
            return false;
        }
        if (this.patch < i3) {
            z = false;
        }
        return z;
    }

    public final boolean isCompatibleTo(BinaryVersion binaryVersion) {
        Intrinsics.checkNotNullParameter(binaryVersion, "ourVersion");
        int i = this.major;
        if (i == 0) {
            if (binaryVersion.major == 0 && this.minor == binaryVersion.minor) {
                return true;
            }
        } else if (i == binaryVersion.major && this.minor <= binaryVersion.minor) {
            return true;
        }
        return false;
    }

    public String toString() {
        int[] iArr = this.numbers;
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (!(i2 != -1)) {
                break;
            }
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList.isEmpty() ? "unknown" : ArraysKt___ArraysJvmKt.joinToString$default(arrayList, ".", null, null, 0, null, null, 62);
    }
}
