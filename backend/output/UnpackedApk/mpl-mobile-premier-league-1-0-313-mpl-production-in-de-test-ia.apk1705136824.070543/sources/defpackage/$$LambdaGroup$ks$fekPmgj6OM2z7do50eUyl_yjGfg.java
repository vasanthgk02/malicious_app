package defpackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.CharsKt__CharKt;
import sfs2x.client.entities.variables.SFSBuddyVariable;

/* renamed from: -$$LambdaGroup$ks$fekPmgj6OM2z7do50eUyl_yjGfg  reason: invalid class name and default package */
/* compiled from: com.android.tools.r8.jetbrains.kotlin-style lambda group */
public final class $$LambdaGroup$ks$fekPmgj6OM2z7do50eUyl_yjGfg extends Lambda implements Function0<String> {
    public final /* synthetic */ Object $capture$0;
    public final /* synthetic */ int $id$;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public $$LambdaGroup$ks$fekPmgj6OM2z7do50eUyl_yjGfg(int i, Object obj) {
        // this.$id$ = i;
        // this.$capture$0 = obj;
        super(0);
    }

    public final Object invoke() {
        String str;
        int i = this.$id$;
        String str2 = null;
        if (i == 0) {
            if (!KClassImpl.this.jClass.isAnonymousClass()) {
                ClassId classId = KClassImpl.this.getClassId();
                if (!classId.local) {
                    str2 = classId.asSingleFqName().asString();
                }
            }
            return str2;
        } else if (i == 1) {
            if (!KClassImpl.this.jClass.isAnonymousClass()) {
                ClassId classId2 = KClassImpl.this.getClassId();
                if (classId2.local) {
                    Class<T> cls = KClassImpl.this.jClass;
                    String simpleName = cls.getSimpleName();
                    Method enclosingMethod = cls.getEnclosingMethod();
                    if (enclosingMethod != null) {
                        Intrinsics.checkNotNullExpressionValue(simpleName, "name");
                        str = CharsKt__CharKt.substringAfter$default(simpleName, enclosingMethod.getName() + SFSBuddyVariable.OFFLINE_PREFIX, (String) null, 2);
                    } else {
                        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                        if (enclosingConstructor != null) {
                            Intrinsics.checkNotNullExpressionValue(simpleName, "name");
                            str = CharsKt__CharKt.substringAfter$default(simpleName, enclosingConstructor.getName() + SFSBuddyVariable.OFFLINE_PREFIX, (String) null, 2);
                        } else {
                            Intrinsics.checkNotNullExpressionValue(simpleName, "name");
                            str = CharsKt__CharKt.substringAfter$default(simpleName, '$', (String) null, 2);
                        }
                    }
                } else {
                    str = classId2.getShortClassName().asString();
                    Intrinsics.checkNotNullExpressionValue(str, "classId.shortClassName.asString()");
                }
                str2 = str;
            }
            return str2;
        } else {
            throw null;
        }
    }
}
