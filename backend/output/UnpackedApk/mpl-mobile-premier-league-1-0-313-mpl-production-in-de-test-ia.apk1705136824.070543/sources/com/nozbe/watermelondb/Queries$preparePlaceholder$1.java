package com.nozbe.watermelondb;

import com.facebook.react.bridge.ColorPropConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Queries.kt */
public final class Queries$preparePlaceholder$1 extends Lambda implements Function1<Object, CharSequence> {
    public static final Queries$preparePlaceholder$1 INSTANCE = new Queries$preparePlaceholder$1();

    public Queries$preparePlaceholder$1() {
        super(1);
    }

    public Object invoke(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        return ColorPropConverter.PREFIX_ATTR;
    }
}
