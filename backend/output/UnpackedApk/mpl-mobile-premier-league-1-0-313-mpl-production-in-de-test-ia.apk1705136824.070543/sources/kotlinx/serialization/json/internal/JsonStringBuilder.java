package kotlinx.serialization.json.internal;

import com.facebook.react.modules.network.NetworkingModule;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0010\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0004@\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lkotlinx/serialization/json/internal/JsonStringBuilder;", "", "()V", "array", "", "([C)V", "size", "", "getSize", "()I", "setSize", "(I)V", "append", "", "ch", "", "value", "", "string", "", "appendQuoted", "appendStringSlowPath", "firstEscapedChar", "currentSize", "ensureAdditionalCapacity", "expected", "ensureTotalCapacity", "oldSize", "additional", "release", "toString", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonStringBuilder.kt */
public class JsonStringBuilder {
    public char[] array;
    public int size;

    public JsonStringBuilder() {
        char[] cArr;
        synchronized (CharArrayPool.INSTANCE) {
            ArrayDeque<char[]> arrayDeque = CharArrayPool.arrays;
            cArr = null;
            char[] cArr2 = (char[]) (arrayDeque.isEmpty() ? null : arrayDeque.removeLast());
            if (cArr2 != null) {
                CharArrayPool.charsTotal -= cArr2.length;
                cArr = cArr2;
            }
        }
        cArr = cArr == null ? new char[128] : cArr;
        Intrinsics.checkNotNullParameter(cArr, "array");
        this.array = cArr;
    }

    public final void append(long j) {
        append(String.valueOf(j));
    }

    public int ensureTotalCapacity(int i, int i2) {
        int i3 = i2 + i;
        char[] cArr = this.array;
        if (cArr.length <= i3) {
            int i4 = i * 2;
            if (i3 < i4) {
                i3 = i4;
            }
            char[] copyOf = Arrays.copyOf(cArr, i3);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            this.array = copyOf;
        }
        return i;
    }

    public void release() {
        CharArrayPool charArrayPool = CharArrayPool.INSTANCE;
        char[] cArr = this.array;
        Intrinsics.checkNotNullParameter(cArr, "array");
        synchronized (charArrayPool) {
            if (CharArrayPool.charsTotal + cArr.length < CharArrayPool.MAX_CHARS_IN_POOL) {
                CharArrayPool.charsTotal += cArr.length;
                CharArrayPool.arrays.addLast(cArr);
            }
        }
    }

    public String toString() {
        return new String(this.array, 0, this.size);
    }

    public final void append(String str) {
        Intrinsics.checkNotNullParameter(str, NetworkingModule.REQUEST_BODY_KEY_STRING);
        int length = str.length();
        ensureTotalCapacity(this.size, length);
        str.getChars(0, str.length(), this.array, this.size);
        this.size += length;
    }
}
