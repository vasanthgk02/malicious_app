package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* compiled from: GivenFunctionsMemberScope.kt */
public final class GivenFunctionsMemberScope$allDescriptors$2 extends Lambda implements Function0<List<? extends DeclarationDescriptor>> {
    public final /* synthetic */ GivenFunctionsMemberScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public GivenFunctionsMemberScope$allDescriptors$2(GivenFunctionsMemberScope givenFunctionsMemberScope) {
        // this.this$0 = givenFunctionsMemberScope;
        super(0);
    }

    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r9v0, types: [java.util.Collection] */
    /* JADX WARNING: type inference failed for: r7v7, types: [kotlin.collections.EmptyList] */
    /* JADX WARNING: type inference failed for: r7v18 */
    /* JADX WARNING: type inference failed for: r7v19 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke() {
        /*
            r12 = this;
            kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope r0 = r12.this$0
            java.util.List r0 = r0.computeDeclaredFunctions()
            kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope r1 = r12.this$0
            r2 = 0
            if (r1 == 0) goto L_0x013f
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 3
            r3.<init>(r4)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r5 = r1.containingClass
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r5 = r5.getTypeConstructor()
            java.util.Collection r5 = r5.getSupertypes()
            java.lang.String r6 = "containingClass.typeConstructor.supertypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x0029:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0041
            java.lang.Object r7 = r5.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r7
            kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r7 = r7.getMemberScope()
            java.util.Collection r7 = com.twitter.sdk.android.tweetui.TweetUtils.getContributedDescriptors$default(r7, r2, r2, r4, r2)
            com.twitter.sdk.android.tweetui.TweetUtils.addAll(r6, r7)
            goto L_0x0029
        L_0x0041:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r4 = r6.iterator()
        L_0x004a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x005c
            java.lang.Object r5 = r4.next()
            boolean r6 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r6 == 0) goto L_0x004a
            r2.add(r5)
            goto L_0x004a
        L_0x005c:
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0065:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x008a
            java.lang.Object r5 = r2.next()
            r6 = r5
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r6
            kotlin.reflect.jvm.internal.impl.name.Name r6 = r6.getName()
            java.lang.Object r7 = r4.get(r6)
            if (r7 != 0) goto L_0x0084
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r4.put(r6, r7)
        L_0x0084:
            java.util.List r7 = (java.util.List) r7
            r7.add(r5)
            goto L_0x0065
        L_0x008a:
            java.util.Set r2 = r4.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0092:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0136
            java.lang.Object r4 = r2.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            kotlin.reflect.jvm.internal.impl.name.Name r5 = (kotlin.reflect.jvm.internal.impl.name.Name) r5
            java.lang.Object r4 = r4.getValue()
            java.util.List r4 = (java.util.List) r4
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x00b3:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x00da
            java.lang.Object r7 = r4.next()
            r8 = r7
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r8
            boolean r8 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            java.lang.Object r9 = r6.get(r8)
            if (r9 != 0) goto L_0x00d4
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r6.put(r8, r9)
        L_0x00d4:
            java.util.List r9 = (java.util.List) r9
            r9.add(r7)
            goto L_0x00b3
        L_0x00da:
            java.util.Set r4 = r6.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x00e2:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0092
            java.lang.Object r6 = r4.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r7 = r6.getKey()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            java.lang.Object r6 = r6.getValue()
            r8 = r6
            java.util.List r8 = (java.util.List) r8
            kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil r6 = kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.DEFAULT
            if (r7 == 0) goto L_0x0127
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r9 = r0.iterator()
        L_0x010c:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0129
            java.lang.Object r10 = r9.next()
            r11 = r10
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r11 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r11
            kotlin.reflect.jvm.internal.impl.name.Name r11 = r11.getName()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r5)
            if (r11 == 0) goto L_0x010c
            r7.add(r10)
            goto L_0x010c
        L_0x0127:
            kotlin.collections.EmptyList r7 = kotlin.collections.EmptyList.INSTANCE
        L_0x0129:
            r9 = r7
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10 = r1.containingClass
            kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope$createFakeOverrides$4 r11 = new kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope$createFakeOverrides$4
            r11.<init>(r3, r1)
            r7 = r5
            r6.generateOverridesInFunctionGroup(r7, r8, r9, r10, r11)
            goto L_0x00e2
        L_0x0136:
            java.util.List r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.compact(r3)
            java.util.List r0 = kotlin.collections.ArraysKt___ArraysJvmKt.plus(r0, r1)
            return r0
        L_0x013f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope$allDescriptors$2.invoke():java.lang.Object");
    }
}
