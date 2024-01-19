package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: ValueParameterDescriptorImpl.kt */
public class ValueParameterDescriptorImpl extends VariableDescriptorImpl implements ValueParameterDescriptor {
    public final boolean declaresDefaultValue;
    public final int index;
    public final boolean isCrossinline;
    public final boolean isNoinline;
    public final ValueParameterDescriptor original;
    public final KotlinType varargElementType;

    /* compiled from: ValueParameterDescriptorImpl.kt */
    public static final class WithDestructuringDeclaration extends ValueParameterDescriptorImpl {
        public final Lazy destructuringVariables$delegate;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public WithDestructuringDeclaration(CallableDescriptor callableDescriptor, ValueParameterDescriptor valueParameterDescriptor, int i, Annotations annotations, Name name, KotlinType kotlinType, boolean z, boolean z2, boolean z3, KotlinType kotlinType2, SourceElement sourceElement, Function0<? extends List<? extends VariableDescriptor>> function0) {
            // Intrinsics.checkNotNullParameter(callableDescriptor, "containingDeclaration");
            // Intrinsics.checkNotNullParameter(annotations, "annotations");
            // Intrinsics.checkNotNullParameter(name, "name");
            // Intrinsics.checkNotNullParameter(kotlinType, "outType");
            // Intrinsics.checkNotNullParameter(sourceElement, DefaultSettingsSpiCall.SOURCE_PARAM);
            // Intrinsics.checkNotNullParameter(function0, "destructuringVariables");
            super(callableDescriptor, valueParameterDescriptor, i, annotations, name, kotlinType, z, z2, z3, kotlinType2, sourceElement);
            this.destructuringVariables$delegate = TweetUtils.lazy(function0);
        }

        public ValueParameterDescriptor copy(CallableDescriptor callableDescriptor, Name name, int i) {
            CallableDescriptor callableDescriptor2 = callableDescriptor;
            Intrinsics.checkNotNullParameter(callableDescriptor2, "newOwner");
            Name name2 = name;
            Intrinsics.checkNotNullParameter(name2, "newName");
            Annotations annotations = getAnnotations();
            Intrinsics.checkNotNullExpressionValue(annotations, "annotations");
            KotlinType type = getType();
            Intrinsics.checkNotNullExpressionValue(type, "type");
            boolean declaresDefaultValue = declaresDefaultValue();
            boolean z = this.isCrossinline;
            boolean z2 = this.isNoinline;
            KotlinType kotlinType = this.varargElementType;
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            WithDestructuringDeclaration withDestructuringDeclaration = new WithDestructuringDeclaration(callableDescriptor2, null, i, annotations, name2, type, declaresDefaultValue, z, z2, kotlinType, sourceElement, new ValueParameterDescriptorImpl$WithDestructuringDeclaration$copy$1(this));
            return withDestructuringDeclaration;
        }
    }

    /* JADX WARNING: type inference failed for: r0v11, types: [kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor] */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ValueParameterDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r8, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r9, int r10, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r11, kotlin.reflect.jvm.internal.impl.name.Name r12, kotlin.reflect.jvm.internal.impl.types.KotlinType r13, boolean r14, boolean r15, boolean r16, kotlin.reflect.jvm.internal.impl.types.KotlinType r17, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r18) {
        /*
            r7 = this;
            r6 = r7
            java.lang.String r0 = "containingDeclaration"
            r1 = r8
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "annotations"
            r2 = r11
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "name"
            r3 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "outType"
            r4 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "source"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r10
            r6.index = r0
            r0 = r14
            r6.declaresDefaultValue = r0
            r0 = r15
            r6.isCrossinline = r0
            r0 = r16
            r6.isNoinline = r0
            r0 = r17
            r6.varargElementType = r0
            if (r9 != 0) goto L_0x003a
            r0 = r6
            goto L_0x003b
        L_0x003a:
            r0 = r9
        L_0x003b:
            r6.original = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, int, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.types.KotlinType, boolean, boolean, boolean, kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement):void");
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        Intrinsics.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitValueParameterDescriptor(this, d2);
    }

    public ValueParameterDescriptor copy(CallableDescriptor callableDescriptor, Name name, int i) {
        Intrinsics.checkNotNullParameter(callableDescriptor, "newOwner");
        Name name2 = name;
        Intrinsics.checkNotNullParameter(name2, "newName");
        Annotations annotations = getAnnotations();
        Intrinsics.checkNotNullExpressionValue(annotations, "annotations");
        KotlinType type = getType();
        Intrinsics.checkNotNullExpressionValue(type, "type");
        boolean declaresDefaultValue2 = declaresDefaultValue();
        boolean z = this.isCrossinline;
        boolean z2 = this.isNoinline;
        KotlinType kotlinType = this.varargElementType;
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        ValueParameterDescriptorImpl valueParameterDescriptorImpl = new ValueParameterDescriptorImpl(callableDescriptor, null, i, annotations, name2, type, declaresDefaultValue2, z, z2, kotlinType, sourceElement);
        return valueParameterDescriptorImpl;
    }

    public boolean declaresDefaultValue() {
        return this.declaresDefaultValue && ((CallableMemberDescriptor) getContainingDeclaration()).getKind().isReal();
    }

    public ConstantValue getCompileTimeInitializer() {
        return null;
    }

    public int getIndex() {
        return this.index;
    }

    public Collection<ValueParameterDescriptor> getOverriddenDescriptors() {
        Collection<? extends CallableDescriptor> overriddenDescriptors = getContainingDeclaration().getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "containingDeclaration.overriddenDescriptors");
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(overriddenDescriptors, 10));
        for (CallableDescriptor valueParameters : overriddenDescriptors) {
            arrayList.add(valueParameters.getValueParameters().get(this.index));
        }
        return arrayList;
    }

    public KotlinType getVarargElementType() {
        return this.varargElementType;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.LOCAL;
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "LOCAL");
        return descriptorVisibility;
    }

    public boolean isCrossinline() {
        return this.isCrossinline;
    }

    public boolean isLateInit() {
        Intrinsics.checkNotNullParameter(this, "this");
        return false;
    }

    public boolean isNoinline() {
        return this.isNoinline;
    }

    public boolean isVar() {
        return false;
    }

    public DeclarationDescriptorNonRoot substitute(TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(typeSubstitutor, "substitutor");
        if (typeSubstitutor.isEmpty()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    public CallableDescriptor getContainingDeclaration() {
        return (CallableDescriptor) super.getContainingDeclaration();
    }

    public ValueParameterDescriptor getOriginal() {
        ValueParameterDescriptor valueParameterDescriptor = this.original;
        return valueParameterDescriptor == this ? this : valueParameterDescriptor.getOriginal();
    }
}
