package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\tH\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lkotlinx/serialization/json/internal/Composer;", "sb", "Lkotlinx/serialization/json/internal/JsonStringBuilder;", "(Lkotlinx/serialization/json/internal/JsonStringBuilder;)V", "print", "", "v", "", "", "", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Composers.kt */
public final class ComposerForUnsignedNumbers extends Composer {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ComposerForUnsignedNumbers(JsonStringBuilder jsonStringBuilder) {
        // Intrinsics.checkNotNullParameter(jsonStringBuilder, "sb");
        super(jsonStringBuilder);
    }

    public void print(long j) {
        super.print(ULong.m885toStringimpl(j));
    }

    public void print(byte b2) {
        super.print(String.valueOf(b2 & 255));
    }

    public void print(short s) {
        super.print(String.valueOf(s & 65535));
    }

    public void print(int i) {
        super.print(String.valueOf(((long) i) & 4294967295L));
    }
}
