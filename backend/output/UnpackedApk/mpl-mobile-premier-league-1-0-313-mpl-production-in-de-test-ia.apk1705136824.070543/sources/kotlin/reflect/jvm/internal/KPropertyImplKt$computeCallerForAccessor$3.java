package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl.Accessor;
import kotlin.reflect.jvm.internal.calls.CallerImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"computeFieldCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KPropertyImpl.kt */
public final class KPropertyImplKt$computeCallerForAccessor$3 extends Lambda implements Function1<Field, CallerImpl<? extends Field>> {
    public final /* synthetic */ boolean $isGetter;
    public final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$1 $isJvmStaticProperty$1;
    public final /* synthetic */ KPropertyImplKt$computeCallerForAccessor$2 $isNotNullProperty$2;
    public final /* synthetic */ Accessor $this_computeCallerForAccessor;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KPropertyImplKt$computeCallerForAccessor$3(Accessor accessor, boolean z, KPropertyImplKt$computeCallerForAccessor$2 kPropertyImplKt$computeCallerForAccessor$2, KPropertyImplKt$computeCallerForAccessor$1 kPropertyImplKt$computeCallerForAccessor$1) {
        // this.$this_computeCallerForAccessor = accessor;
        // this.$isGetter = z;
        // this.$isNotNullProperty$2 = kPropertyImplKt$computeCallerForAccessor$2;
        // this.$isJvmStaticProperty$1 = kPropertyImplKt$computeCallerForAccessor$1;
        super(1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.reflect.jvm.internal.calls.CallerImpl<java.lang.reflect.Field> invoke(java.lang.reflect.Field r4) {
        /*
            r3 = this;
            java.lang.String r0 = "field"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.reflect.jvm.internal.KPropertyImpl$Accessor r0 = r3.$this_computeCallerForAccessor
            kotlin.reflect.jvm.internal.KPropertyImpl r0 = r0.getProperty()
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r0 = r0.getDescriptor()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r0.getContainingDeclaration()
            java.lang.String r2 = "containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            boolean r2 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isCompanionObject(r1)
            if (r2 != 0) goto L_0x001f
            goto L_0x0041
        L_0x001f:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r1.getContainingDeclaration()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r2 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE
            boolean r2 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isKindOf(r1, r2)
            if (r2 != 0) goto L_0x0031
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isAnnotationClass(r1)
            if (r1 == 0) goto L_0x003f
        L_0x0031:
            boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor
            if (r1 == 0) goto L_0x0041
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor r0 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor) r0
            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r0 = r0.proto
            boolean r0 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil.isMovedFromInterfaceCompanion(r0)
            if (r0 == 0) goto L_0x0041
        L_0x003f:
            r0 = 1
            goto L_0x0042
        L_0x0041:
            r0 = 0
        L_0x0042:
            if (r0 != 0) goto L_0x00a7
            int r0 = r4.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 != 0) goto L_0x004f
            goto L_0x00a7
        L_0x004f:
            kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$1 r0 = r3.$isJvmStaticProperty$1
            boolean r0 = r0.invoke()
            if (r0 == 0) goto L_0x0091
            boolean r0 = r3.$isGetter
            if (r0 == 0) goto L_0x0071
            kotlin.reflect.jvm.internal.KPropertyImpl$Accessor r0 = r3.$this_computeCallerForAccessor
            boolean r0 = r0.isBound()
            if (r0 == 0) goto L_0x006a
            kotlin.reflect.jvm.internal.calls.CallerImpl$FieldGetter$BoundJvmStaticInObject r0 = new kotlin.reflect.jvm.internal.calls.CallerImpl$FieldGetter$BoundJvmStaticInObject
            r0.<init>(r4)
            goto L_0x00ea
        L_0x006a:
            kotlin.reflect.jvm.internal.calls.CallerImpl$FieldGetter$JvmStaticInObject r0 = new kotlin.reflect.jvm.internal.calls.CallerImpl$FieldGetter$JvmStaticInObject
            r0.<init>(r4)
            goto L_0x00ea
        L_0x0071:
            kotlin.reflect.jvm.internal.KPropertyImpl$Accessor r0 = r3.$this_computeCallerForAccessor
            boolean r0 = r0.isBound()
            if (r0 == 0) goto L_0x0085
            kotlin.reflect.jvm.internal.calls.CallerImpl$FieldSetter$BoundJvmStaticInObject r0 = new kotlin.reflect.jvm.internal.calls.CallerImpl$FieldSetter$BoundJvmStaticInObject
            kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$2 r1 = r3.$isNotNullProperty$2
            boolean r1 = r1.invoke()
            r0.<init>(r4, r1)
            goto L_0x00ea
        L_0x0085:
            kotlin.reflect.jvm.internal.calls.CallerImpl$FieldSetter$JvmStaticInObject r0 = new kotlin.reflect.jvm.internal.calls.CallerImpl$FieldSetter$JvmStaticInObject
            kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$2 r1 = r3.$isNotNullProperty$2
            boolean r1 = r1.invoke()
            r0.<init>(r4, r1)
            goto L_0x00ea
        L_0x0091:
            boolean r0 = r3.$isGetter
            if (r0 == 0) goto L_0x009b
            kotlin.reflect.jvm.internal.calls.CallerImpl$FieldGetter$Static r0 = new kotlin.reflect.jvm.internal.calls.CallerImpl$FieldGetter$Static
            r0.<init>(r4)
            goto L_0x00ea
        L_0x009b:
            kotlin.reflect.jvm.internal.calls.CallerImpl$FieldSetter$Static r0 = new kotlin.reflect.jvm.internal.calls.CallerImpl$FieldSetter$Static
            kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$2 r1 = r3.$isNotNullProperty$2
            boolean r1 = r1.invoke()
            r0.<init>(r4, r1)
            goto L_0x00ea
        L_0x00a7:
            boolean r0 = r3.$isGetter
            if (r0 == 0) goto L_0x00c5
            kotlin.reflect.jvm.internal.KPropertyImpl$Accessor r0 = r3.$this_computeCallerForAccessor
            boolean r0 = r0.isBound()
            if (r0 == 0) goto L_0x00bf
            kotlin.reflect.jvm.internal.calls.CallerImpl$FieldGetter$BoundInstance r0 = new kotlin.reflect.jvm.internal.calls.CallerImpl$FieldGetter$BoundInstance
            kotlin.reflect.jvm.internal.KPropertyImpl$Accessor r1 = r3.$this_computeCallerForAccessor
            java.lang.Object r1 = com.twitter.sdk.android.tweetui.TweetUtils.getBoundReceiver(r1)
            r0.<init>(r4, r1)
            goto L_0x00ea
        L_0x00bf:
            kotlin.reflect.jvm.internal.calls.CallerImpl$FieldGetter$Instance r0 = new kotlin.reflect.jvm.internal.calls.CallerImpl$FieldGetter$Instance
            r0.<init>(r4)
            goto L_0x00ea
        L_0x00c5:
            kotlin.reflect.jvm.internal.KPropertyImpl$Accessor r0 = r3.$this_computeCallerForAccessor
            boolean r0 = r0.isBound()
            if (r0 == 0) goto L_0x00df
            kotlin.reflect.jvm.internal.calls.CallerImpl$FieldSetter$BoundInstance r0 = new kotlin.reflect.jvm.internal.calls.CallerImpl$FieldSetter$BoundInstance
            kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$2 r1 = r3.$isNotNullProperty$2
            boolean r1 = r1.invoke()
            kotlin.reflect.jvm.internal.KPropertyImpl$Accessor r2 = r3.$this_computeCallerForAccessor
            java.lang.Object r2 = com.twitter.sdk.android.tweetui.TweetUtils.getBoundReceiver(r2)
            r0.<init>(r4, r1, r2)
            goto L_0x00ea
        L_0x00df:
            kotlin.reflect.jvm.internal.calls.CallerImpl$FieldSetter$Instance r0 = new kotlin.reflect.jvm.internal.calls.CallerImpl$FieldSetter$Instance
            kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$2 r1 = r3.$isNotNullProperty$2
            boolean r1 = r1.invoke()
            r0.<init>(r4, r1)
        L_0x00ea:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPropertyImplKt$computeCallerForAccessor$3.invoke(java.lang.reflect.Field):kotlin.reflect.jvm.internal.calls.CallerImpl");
    }
}
