package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysJvmKt$asList$3;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import org.apache.pdfbox.pdfparser.BaseParser;

/* compiled from: BuiltInsBinaryVersion.kt */
public final class BuiltInsBinaryVersion extends BinaryVersion {
    public static final Companion Companion = new Companion(null);
    public static final BuiltInsBinaryVersion INSTANCE = new BuiltInsBinaryVersion(1, 0, 7);

    /* compiled from: BuiltInsBinaryVersion.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final BuiltInsBinaryVersion readFrom(InputStream inputStream) {
            Intrinsics.checkNotNullParameter(inputStream, BaseParser.STREAM_STRING);
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            IntRange intRange = new IntRange(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(intRange, 10));
            IntIterator it = intRange.iterator();
            while (((IntProgressionIterator) it).hasNext) {
                it.nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] intArray = ArraysKt___ArraysJvmKt.toIntArray(arrayList);
            int[] iArr = new int[intArray.length];
            System.arraycopy(intArray, 0, iArr, 0, intArray.length);
            return new BuiltInsBinaryVersion(iArr);
        }
    }

    static {
        int[] iArr = new int[0];
        Intrinsics.checkNotNullParameter(iArr, "numbers");
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        Intrinsics.checkNotNullParameter(iArr2, "numbers");
        Integer orNull = TweetUtils.getOrNull(iArr2, 0);
        if (orNull != null) {
            orNull.intValue();
        }
        Integer orNull2 = TweetUtils.getOrNull(iArr2, 1);
        if (orNull2 != null) {
            orNull2.intValue();
        }
        Integer orNull3 = TweetUtils.getOrNull(iArr2, 2);
        if (orNull3 != null) {
            orNull3.intValue();
        }
        if (iArr2.length > 3) {
            Intrinsics.checkNotNullParameter(iArr2, "<this>");
            ArraysKt___ArraysJvmKt.toList(new ArraysKt___ArraysJvmKt$asList$3(iArr2).subList(3, iArr2.length));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BuiltInsBinaryVersion(int... r4) {
        /*
            r3 = this;
            java.lang.String r0 = "numbers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            int r0 = r4.length
            int[] r0 = new int[r0]
            int r1 = r4.length
            r2 = 0
            java.lang.System.arraycopy(r4, r2, r0, r2, r1)
            r3.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.builtins.BuiltInsBinaryVersion.<init>(int[]):void");
    }
}
