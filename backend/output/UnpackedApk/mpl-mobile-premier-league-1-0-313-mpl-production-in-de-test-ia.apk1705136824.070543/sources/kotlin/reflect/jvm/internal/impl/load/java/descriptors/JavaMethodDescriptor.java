package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class JavaMethodDescriptor extends SimpleFunctionDescriptorImpl implements JavaCallableMemberDescriptor {
    public static final UserDataKey<ValueParameterDescriptor> ORIGINAL_VALUE_PARAMETER_FOR_EXTENSION_RECEIVER = new UserDataKey<ValueParameterDescriptor>() {
    };
    public final boolean isForRecordComponent;
    public ParameterNamesStatus parameterNamesStatus;

    public enum ParameterNamesStatus {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);
        
        public final boolean isStable;
        public final boolean isSynthesized;

        /* access modifiers changed from: public */
        ParameterNamesStatus(boolean z, boolean z2) {
            this.isStable = z;
            this.isSynthesized = z2;
        }

        public static ParameterNamesStatus get(boolean z, boolean z2) {
            ParameterNamesStatus parameterNamesStatus = z ? z2 ? STABLE_SYNTHESIZED : STABLE_DECLARED : z2 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            if (parameterNamesStatus == null) {
                $$$reportNull$$$0(0);
            }
            return parameterNamesStatus;
        }
    }

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 12 || i == 17 || i == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 12 || i == 17 || i == 20) ? 2 : 3)];
        switch (i) {
            case 1:
            case 6:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 14:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 16:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 9:
                objArr[0] = "typeParameters";
                break;
            case 10:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 11:
                objArr[0] = "visibility";
                break;
            case 12:
            case 17:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 13:
                objArr[0] = "newOwner";
                break;
            case 18:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 19:
                objArr[0] = "enhancedReturnType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 12) {
            objArr[1] = "initialize";
        } else if (i == 17) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
                objArr[2] = "initialize";
                break;
            case 12:
            case 17:
            case 20:
                break;
            case 13:
            case 14:
            case 15:
            case 16:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 18:
            case 19:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 12 || i == 17 || i == 20) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JavaMethodDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r3, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4, kotlin.reflect.jvm.internal.impl.name.Name r5, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r6, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r7, boolean r8) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x0027
            if (r4 == 0) goto L_0x0022
            if (r5 == 0) goto L_0x001d
            if (r6 == 0) goto L_0x0018
            if (r7 == 0) goto L_0x0013
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r1.parameterNamesStatus = r0
            r1.isForRecordComponent = r8
            return
        L_0x0013:
            r2 = 4
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0018:
            r2 = 3
            $$$reportNull$$$0(r2)
            throw r0
        L_0x001d:
            r2 = 2
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0022:
            r2 = 1
            $$$reportNull$$$0(r2)
            throw r0
        L_0x0027:
            r2 = 0
            $$$reportNull$$$0(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement, boolean):void");
    }

    public static JavaMethodDescriptor createJavaMethod(DeclarationDescriptor declarationDescriptor, Annotations annotations, Name name, SourceElement sourceElement, boolean z) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(5);
            throw null;
        } else if (name == null) {
            $$$reportNull$$$0(7);
            throw null;
        } else if (sourceElement != null) {
            JavaMethodDescriptor javaMethodDescriptor = new JavaMethodDescriptor(declarationDescriptor, null, annotations, name, Kind.DECLARATION, sourceElement, z);
            return javaMethodDescriptor;
        } else {
            $$$reportNull$$$0(8);
            throw null;
        }
    }

    public FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(13);
            throw null;
        } else if (kind == null) {
            $$$reportNull$$$0(14);
            throw null;
        } else if (annotations == null) {
            $$$reportNull$$$0(15);
            throw null;
        } else if (sourceElement != null) {
            SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) functionDescriptor;
            if (name == null) {
                name = getName();
            }
            JavaMethodDescriptor javaMethodDescriptor = new JavaMethodDescriptor(declarationDescriptor, simpleFunctionDescriptor, annotations, name, kind, sourceElement, this.isForRecordComponent);
            ParameterNamesStatus parameterNamesStatus2 = this.parameterNamesStatus;
            javaMethodDescriptor.setParameterNamesStatus(parameterNamesStatus2.isStable, parameterNamesStatus2.isSynthesized);
            return javaMethodDescriptor;
        } else {
            $$$reportNull$$$0(16);
            throw null;
        }
    }

    public JavaCallableMemberDescriptor enhance(KotlinType kotlinType, List list, KotlinType kotlinType2, Pair pair) {
        ReceiverParameterDescriptor receiverParameterDescriptor;
        if (kotlinType2 != null) {
            List<ValueParameterDescriptor> copyValueParameters = TweetUtils.copyValueParameters(list, getValueParameters(), this);
            if (kotlinType == null) {
                receiverParameterDescriptor = null;
            } else if (Annotations.Companion != null) {
                receiverParameterDescriptor = TweetUtils.createExtensionReceiverParameterForCallable(this, kotlinType, Companion.EMPTY);
            } else {
                throw null;
            }
            CopyConfiguration copyConfiguration = (CopyConfiguration) newCopyBuilder();
            copyConfiguration.setValueParameters(copyValueParameters);
            copyConfiguration.setReturnType(kotlinType2);
            copyConfiguration.newExtensionReceiverParameter = receiverParameterDescriptor;
            copyConfiguration.dropOriginalInContainingParts = true;
            copyConfiguration.preserveSourceElement = true;
            JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) copyConfiguration.build();
            if (pair != null) {
                javaMethodDescriptor.putInUserDataMap((UserDataKey) pair.first, pair.second);
            }
            if (javaMethodDescriptor != null) {
                return javaMethodDescriptor;
            }
            $$$reportNull$$$0(20);
            throw null;
        }
        $$$reportNull$$$0(19);
        throw null;
    }

    public boolean hasSynthesizedParameterNames() {
        return this.parameterNamesStatus.isSynthesized;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        if (r4.regex.matches(r5) == false) goto L_0x0062;
     */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0068 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl initialize(kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r2, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r3, java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor> r4, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r5, kotlin.reflect.jvm.internal.impl.types.KotlinType r6, kotlin.reflect.jvm.internal.impl.descriptors.Modality r7, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r8, java.util.Map<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey<?>, ?> r9) {
        /*
            r1 = this;
            r0 = 0
            if (r4 == 0) goto L_0x00a8
            if (r5 == 0) goto L_0x00a2
            if (r8 == 0) goto L_0x009c
            super.initialize(r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.reflect.jvm.internal.impl.util.OperatorChecks r2 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks.INSTANCE
            java.lang.String r2 = "functionDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            java.util.List<kotlin.reflect.jvm.internal.impl.util.Checks> r3 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks.checks
            java.util.Iterator r3 = r3.iterator()
        L_0x0017:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0095
            java.lang.Object r4 = r3.next()
            kotlin.reflect.jvm.internal.impl.util.Checks r4 = (kotlin.reflect.jvm.internal.impl.util.Checks) r4
            if (r4 == 0) goto L_0x0094
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.reflect.jvm.internal.impl.name.Name r5 = r4.name
            r6 = 0
            if (r5 == 0) goto L_0x003a
            kotlin.reflect.jvm.internal.impl.name.Name r5 = r1.getName()
            kotlin.reflect.jvm.internal.impl.name.Name r7 = r4.name
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r7)
            if (r5 != 0) goto L_0x003a
            goto L_0x0062
        L_0x003a:
            kotlin.text.Regex r5 = r4.regex
            if (r5 == 0) goto L_0x0054
            kotlin.reflect.jvm.internal.impl.name.Name r5 = r1.getName()
            java.lang.String r5 = r5.asString()
            java.lang.String r7 = "functionDescriptor.name.asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            kotlin.text.Regex r7 = r4.regex
            boolean r5 = r7.matches(r5)
            if (r5 != 0) goto L_0x0054
            goto L_0x0062
        L_0x0054:
            java.util.Collection<kotlin.reflect.jvm.internal.impl.name.Name> r5 = r4.nameList
            if (r5 == 0) goto L_0x0064
            kotlin.reflect.jvm.internal.impl.name.Name r7 = r1.getName()
            boolean r5 = r5.contains(r7)
            if (r5 != 0) goto L_0x0064
        L_0x0062:
            r5 = 0
            goto L_0x0065
        L_0x0064:
            r5 = 1
        L_0x0065:
            if (r5 != 0) goto L_0x0068
            goto L_0x0017
        L_0x0068:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            kotlin.reflect.jvm.internal.impl.util.Check[] r2 = r4.checks
            int r3 = r2.length
        L_0x006e:
            if (r6 >= r3) goto L_0x0080
            r5 = r2[r6]
            int r6 = r6 + 1
            java.lang.String r5 = r5.invoke(r1)
            if (r5 == 0) goto L_0x006e
            kotlin.reflect.jvm.internal.impl.util.CheckResult$IllegalSignature r2 = new kotlin.reflect.jvm.internal.impl.util.CheckResult$IllegalSignature
            r2.<init>(r5)
            goto L_0x0097
        L_0x0080:
            kotlin.jvm.functions.Function1<kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.String> r2 = r4.additionalCheck
            java.lang.Object r2 = r2.invoke(r1)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x0091
            kotlin.reflect.jvm.internal.impl.util.CheckResult$IllegalSignature r3 = new kotlin.reflect.jvm.internal.impl.util.CheckResult$IllegalSignature
            r3.<init>(r2)
            r2 = r3
            goto L_0x0097
        L_0x0091:
            kotlin.reflect.jvm.internal.impl.util.CheckResult$SuccessCheck r2 = kotlin.reflect.jvm.internal.impl.util.CheckResult.SuccessCheck.INSTANCE
            goto L_0x0097
        L_0x0094:
            throw r0
        L_0x0095:
            kotlin.reflect.jvm.internal.impl.util.CheckResult$IllegalFunctionName r2 = kotlin.reflect.jvm.internal.impl.util.CheckResult.IllegalFunctionName.INSTANCE
        L_0x0097:
            boolean r2 = r2.isSuccess
            r1.isOperator = r2
            return r1
        L_0x009c:
            r2 = 11
            $$$reportNull$$$0(r2)
            throw r0
        L_0x00a2:
            r2 = 10
            $$$reportNull$$$0(r2)
            throw r0
        L_0x00a8:
            r2 = 9
            $$$reportNull$$$0(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor.initialize(kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor, java.util.List, java.util.List, kotlin.reflect.jvm.internal.impl.types.KotlinType, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility, java.util.Map):kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl");
    }

    public void setParameterNamesStatus(boolean z, boolean z2) {
        this.parameterNamesStatus = ParameterNamesStatus.get(z, z2);
    }
}
