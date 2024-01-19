package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.paynimo.android.payment.util.Constant;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IndexedValue;
import kotlin.collections.IndexingIterable;
import kotlin.collections.IndexingIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: FunctionInvokeDescriptor.kt */
public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {
    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FunctionInvokeDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r9, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor r10, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r11, boolean r12) {
        /*
            r8 = this;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r0 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r0 == 0) goto L_0x001a
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            kotlin.reflect.jvm.internal.impl.name.Name r5 = kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions.INVOKE
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r7 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            r1 = r8
            r2 = r9
            r3 = r10
            r6 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r9 = 1
            r8.isOperator = r9
            r8.isSuspend = r12
            r9 = 0
            r8.hasStableParameterNames = r9
            return
        L_0x001a:
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, boolean):void");
    }

    public static final FunctionInvokeDescriptor create(FunctionClassDescriptor functionClassDescriptor, boolean z) {
        String str;
        FunctionClassDescriptor functionClassDescriptor2 = functionClassDescriptor;
        Intrinsics.checkNotNullParameter(functionClassDescriptor2, "functionClass");
        List<TypeParameterDescriptor> list = functionClassDescriptor2.parameters;
        Throwable th = null;
        FunctionInvokeDescriptor functionInvokeDescriptor = new FunctionInvokeDescriptor(functionClassDescriptor2, null, Kind.DECLARATION, z);
        ReceiverParameterDescriptor thisAsReceiverParameter = functionClassDescriptor.getThisAsReceiverParameter();
        EmptyList emptyList = EmptyList.INSTANCE;
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (!(((TypeParameterDescriptor) next).getVariance() == Variance.IN_VARIANCE)) {
                break;
            }
            arrayList.add(next);
        }
        Iterable withIndex = ArraysKt___ArraysJvmKt.withIndex(arrayList);
        ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(withIndex, 10));
        Iterator it = ((IndexingIterable) withIndex).iterator();
        while (true) {
            IndexingIterator indexingIterator = (IndexingIterator) it;
            if (indexingIterator.hasNext()) {
                IndexedValue indexedValue = (IndexedValue) indexingIterator.next();
                int i = indexedValue.index;
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) indexedValue.value;
                String asString = typeParameterDescriptor.getName().asString();
                Intrinsics.checkNotNullExpressionValue(asString, "typeParameter.name.asString()");
                if (Intrinsics.areEqual(asString, "T")) {
                    str = DefaultSettingsSpiCall.INSTANCE_PARAM;
                } else if (Intrinsics.areEqual(asString, Constant.PAYMENT_METHOD_TYPE_EMI)) {
                    str = "receiver";
                } else {
                    str = asString.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase()");
                }
                if (Annotations.Companion != null) {
                    Annotations annotations = Companion.EMPTY;
                    Name identifier = Name.identifier(str);
                    Intrinsics.checkNotNullExpressionValue(identifier, "identifier(name)");
                    SimpleType defaultType = typeParameterDescriptor.getDefaultType();
                    Intrinsics.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
                    SourceElement sourceElement = SourceElement.NO_SOURCE;
                    Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
                    ValueParameterDescriptorImpl valueParameterDescriptorImpl = r2;
                    EmptyList emptyList2 = emptyList;
                    ArrayList arrayList3 = arrayList2;
                    ValueParameterDescriptorImpl valueParameterDescriptorImpl2 = new ValueParameterDescriptorImpl(functionInvokeDescriptor, null, i, annotations, identifier, defaultType, false, false, false, null, sourceElement);
                    arrayList3.add(valueParameterDescriptorImpl);
                    th = null;
                    arrayList2 = arrayList3;
                    emptyList = emptyList2;
                } else {
                    throw th;
                }
            } else {
                functionInvokeDescriptor.initialize((ReceiverParameterDescriptor) null, thisAsReceiverParameter, (List) emptyList, (List) arrayList2, (KotlinType) ((TypeParameterDescriptor) ArraysKt___ArraysJvmKt.last(list)).getDefaultType(), Modality.ABSTRACT, DescriptorVisibilities.PUBLIC);
                functionInvokeDescriptor.hasSynthesizedParameterNames = true;
                return functionInvokeDescriptor;
            }
        }
    }

    public FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(sourceElement, DefaultSettingsSpiCall.SOURCE_PARAM);
        return new FunctionInvokeDescriptor(declarationDescriptor, (FunctionInvokeDescriptor) functionDescriptor, kind, this.isSuspend);
    }

    public FunctionDescriptor doSubstitute(CopyConfiguration copyConfiguration) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(copyConfiguration, "configuration");
        FunctionInvokeDescriptor functionInvokeDescriptor = (FunctionInvokeDescriptor) super.doSubstitute(copyConfiguration);
        if (functionInvokeDescriptor == null) {
            return null;
        }
        List<ValueParameterDescriptor> valueParameters = functionInvokeDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "substituted.valueParameters");
        boolean z4 = false;
        if (!valueParameters.isEmpty()) {
            Iterator<T> it = valueParameters.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                KotlinType type = ((ValueParameterDescriptor) it.next()).getType();
                Intrinsics.checkNotNullExpressionValue(type, "it.type");
                if (FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type) != null) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (z3) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            return functionInvokeDescriptor;
        }
        List<ValueParameterDescriptor> valueParameters2 = functionInvokeDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "substituted.valueParameters");
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(valueParameters2, 10));
        for (ValueParameterDescriptor type2 : valueParameters2) {
            KotlinType type3 = type2.getType();
            Intrinsics.checkNotNullExpressionValue(type3, "it.type");
            arrayList.add(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type3));
        }
        int size = functionInvokeDescriptor.getValueParameters().size() - arrayList.size();
        boolean z5 = size == 0 || size == 1;
        if (!_Assertions.ENABLED || z5) {
            List<ValueParameterDescriptor> valueParameters3 = functionInvokeDescriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters3, "valueParameters");
            ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(valueParameters3, 10));
            for (ValueParameterDescriptor valueParameterDescriptor : valueParameters3) {
                Name name = valueParameterDescriptor.getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.name");
                int index = valueParameterDescriptor.getIndex();
                int i = index - size;
                if (i >= 0) {
                    Name name2 = (Name) arrayList.get(i);
                    if (name2 != null) {
                        name = name2;
                    }
                }
                arrayList2.add(valueParameterDescriptor.copy(functionInvokeDescriptor, name, index));
            }
            CopyConfiguration newCopyBuilder = functionInvokeDescriptor.newCopyBuilder(TypeSubstitutor.EMPTY);
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((Name) it2.next()) == null) {
                            z2 = true;
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            z4 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            newCopyBuilder.newHasSynthesizedParameterNames = Boolean.valueOf(z4);
            newCopyBuilder.newValueParameterDescriptors = arrayList2;
            newCopyBuilder.original = functionInvokeDescriptor.getOriginal();
            Intrinsics.checkNotNullExpressionValue(newCopyBuilder, "newCopyBuilder(TypeSubstitutor.EMPTY)\n                .setHasSynthesizedParameterNames(parameterNames.any { it == null })\n                .setValueParameters(newValueParameters)\n                .setOriginal(original)");
            FunctionDescriptor doSubstitute = super.doSubstitute(newCopyBuilder);
            Intrinsics.checkNotNull(doSubstitute);
            return doSubstitute;
        }
        throw new AssertionError("Assertion failed");
    }

    public boolean isExternal() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isTailrec() {
        return false;
    }
}
