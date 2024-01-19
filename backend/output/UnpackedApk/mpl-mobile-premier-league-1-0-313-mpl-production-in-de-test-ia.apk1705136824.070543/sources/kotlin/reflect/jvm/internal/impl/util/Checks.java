package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.text.Regex;

/* compiled from: modifierChecks.kt */
public final class Checks {
    public final Function1<FunctionDescriptor, String> additionalCheck;
    public final Check[] checks;
    public final Name name;
    public final Collection<Name> nameList;
    public final Regex regex;

    public Checks(Name name2, Regex regex2, Collection<Name> collection, Function1<? super FunctionDescriptor, String> function1, Check... checkArr) {
        this.name = null;
        this.regex = regex2;
        this.nameList = collection;
        this.additionalCheck = function1;
        this.checks = checkArr;
    }

    public /* synthetic */ Checks(Name name2, Check[] checkArr, Function1 function1, int i) {
        this(name2, checkArr, (Function1<? super FunctionDescriptor, String>) (i & 4) != 0 ? AnonymousClass2.INSTANCE : null);
    }

    public Checks(Name name2, Check[] checkArr, Function1<? super FunctionDescriptor, String> function1) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(checkArr, "checks");
        Intrinsics.checkNotNullParameter(function1, "additionalChecks");
        Check[] checkArr2 = new Check[checkArr.length];
        System.arraycopy(checkArr, 0, checkArr2, 0, checkArr.length);
        this.name = name2;
        this.regex = null;
        this.nameList = null;
        this.additionalCheck = function1;
        this.checks = checkArr2;
    }

    public /* synthetic */ Checks(Collection collection, Check[] checkArr, Function1 function1, int i) {
        this(collection, checkArr, (Function1<? super FunctionDescriptor, String>) (i & 4) != 0 ? AnonymousClass4.INSTANCE : null);
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Checks(java.util.Collection<kotlin.reflect.jvm.internal.impl.name.Name> r8, kotlin.reflect.jvm.internal.impl.util.Check[] r9, kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.String> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "nameList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "checks"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "additionalChecks"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            int r0 = r9.length
            kotlin.reflect.jvm.internal.impl.util.Check[] r6 = new kotlin.reflect.jvm.internal.impl.util.Check[r0]
            int r0 = r9.length
            r1 = 0
            java.lang.System.arraycopy(r9, r1, r6, r1, r0)
            r2 = 0
            r3 = 0
            r1 = r7
            r4 = r8
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.Checks.<init>(java.util.Collection, kotlin.reflect.jvm.internal.impl.util.Check[], kotlin.jvm.functions.Function1):void");
    }
}
