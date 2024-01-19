package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

public abstract class FunctionDescriptorImpl extends DeclarationDescriptorNonRootImpl implements FunctionDescriptor {
    public ReceiverParameterDescriptor dispatchReceiverParameter;
    public ReceiverParameterDescriptor extensionReceiverParameter;
    public boolean hasStableParameterNames;
    public boolean hasSynthesizedParameterNames;
    public FunctionDescriptor initialSignatureDescriptor;
    public boolean isActual;
    public boolean isExpect;
    public boolean isExternal;
    public boolean isHiddenForResolutionEverywhereBesideSupercalls;
    public boolean isHiddenToOvercomeSignatureClash;
    public boolean isInfix;
    public boolean isInline;
    public boolean isOperator;
    public boolean isSuspend;
    public boolean isTailrec;
    public final Kind kind;
    public volatile Function0<Collection<FunctionDescriptor>> lazyOverriddenFunctionsTask;
    public Modality modality;
    public final FunctionDescriptor original;
    public Collection<? extends FunctionDescriptor> overriddenFunctions;
    public List<TypeParameterDescriptor> typeParameters;
    public KotlinType unsubstitutedReturnType;
    public List<ValueParameterDescriptor> unsubstitutedValueParameters;
    public Map<UserDataKey<?>, Object> userDataMap;
    public DescriptorVisibility visibility;

    public class CopyConfiguration implements CopyBuilder<FunctionDescriptor> {
        public Annotations additionalAnnotations;
        public boolean copyOverrides;
        public ReceiverParameterDescriptor dispatchReceiverParameter;
        public boolean dropOriginalInContainingParts;
        public boolean isHiddenForResolutionEverywhereBesideSupercalls;
        public boolean isHiddenToOvercomeSignatureClash;
        public boolean justForTypeSubstitution;
        public Kind kind;
        public Name name;
        public ReceiverParameterDescriptor newExtensionReceiverParameter;
        public Boolean newHasSynthesizedParameterNames;
        public Modality newModality;
        public DeclarationDescriptor newOwner;
        public KotlinType newReturnType;
        public List<TypeParameterDescriptor> newTypeParameters;
        public List<ValueParameterDescriptor> newValueParameterDescriptors;
        public DescriptorVisibility newVisibility;
        public FunctionDescriptor original;
        public boolean preserveSourceElement;
        public boolean signatureChange;
        public TypeSubstitution substitution;
        public final /* synthetic */ FunctionDescriptorImpl this$0;
        public Map<UserDataKey<?>, Object> userDataMap;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            Throwable th;
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    i2 = 2;
                    break;
                default:
                    i2 = 3;
                    break;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 13:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newReturnType";
                    break;
                case 7:
                    objArr[0] = "owner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 9:
                    objArr[0] = "modality";
                    break;
                case 11:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "name";
                    break;
                case 18:
                case 20:
                    objArr[0] = BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY;
                    break;
                case 22:
                    objArr[0] = "type";
                    break;
                case 32:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 36:
                    objArr[0] = "userDataKey";
                    break;
                default:
                    objArr[0] = "substitution";
                    break;
            }
            switch (i) {
                case 8:
                    objArr[1] = "setOwner";
                    break;
                case 10:
                    objArr[1] = "setModality";
                    break;
                case 12:
                    objArr[1] = "setVisibility";
                    break;
                case 14:
                    objArr[1] = "setKind";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
                case 19:
                    objArr[1] = "setValueParameters";
                    break;
                case 21:
                    objArr[1] = "setTypeParameters";
                    break;
                case 23:
                    objArr[1] = "setReturnType";
                    break;
                case 24:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 25:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 26:
                    objArr[1] = "setOriginal";
                    break;
                case 27:
                    objArr[1] = "setSignatureChange";
                    break;
                case 28:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 29:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 30:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 31:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 33:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 35:
                    objArr[1] = "setSubstitution";
                    break;
                case 37:
                    objArr[1] = "putUserData";
                    break;
                case 38:
                    objArr[1] = "getSubstitution";
                    break;
                case 39:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
            }
            switch (i) {
                case 7:
                    objArr[2] = "setOwner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    break;
                case 9:
                    objArr[2] = "setModality";
                    break;
                case 11:
                    objArr[2] = "setVisibility";
                    break;
                case 13:
                    objArr[2] = "setKind";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                case 18:
                    objArr[2] = "setValueParameters";
                    break;
                case 20:
                    objArr[2] = "setTypeParameters";
                    break;
                case 22:
                    objArr[2] = "setReturnType";
                    break;
                case 32:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 34:
                    objArr[2] = "setSubstitution";
                    break;
                case 36:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    th = new IllegalStateException(format);
                    break;
                default:
                    th = new IllegalArgumentException(format);
                    break;
            }
            throw th;
        }

        public CopyConfiguration(FunctionDescriptorImpl functionDescriptorImpl, TypeSubstitution typeSubstitution, DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, Kind kind2, List<ValueParameterDescriptor> list, ReceiverParameterDescriptor receiverParameterDescriptor, KotlinType kotlinType, Name name2) {
            if (typeSubstitution == null) {
                $$$reportNull$$$0(0);
                throw null;
            } else if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
                throw null;
            } else if (modality == null) {
                $$$reportNull$$$0(2);
                throw null;
            } else if (descriptorVisibility == null) {
                $$$reportNull$$$0(3);
                throw null;
            } else if (kind2 == null) {
                $$$reportNull$$$0(4);
                throw null;
            } else if (list == null) {
                $$$reportNull$$$0(5);
                throw null;
            } else if (kotlinType != null) {
                this.this$0 = functionDescriptorImpl;
                this.original = null;
                FunctionDescriptorImpl functionDescriptorImpl2 = this.this$0;
                this.dispatchReceiverParameter = functionDescriptorImpl2.dispatchReceiverParameter;
                this.copyOverrides = true;
                this.signatureChange = false;
                this.preserveSourceElement = false;
                this.dropOriginalInContainingParts = false;
                this.isHiddenToOvercomeSignatureClash = functionDescriptorImpl2.isHiddenToOvercomeSignatureClash;
                this.newTypeParameters = null;
                this.additionalAnnotations = null;
                this.isHiddenForResolutionEverywhereBesideSupercalls = functionDescriptorImpl2.isHiddenForResolutionEverywhereBesideSupercalls;
                this.userDataMap = new LinkedHashMap();
                this.newHasSynthesizedParameterNames = null;
                this.justForTypeSubstitution = false;
                this.substitution = typeSubstitution;
                this.newOwner = declarationDescriptor;
                this.newModality = modality;
                this.newVisibility = descriptorVisibility;
                this.kind = kind2;
                this.newValueParameterDescriptors = list;
                this.newExtensionReceiverParameter = receiverParameterDescriptor;
                this.newReturnType = kotlinType;
                this.name = null;
            } else {
                $$$reportNull$$$0(6);
                throw null;
            }
        }

        public FunctionDescriptor build() {
            return this.this$0.doSubstitute(this);
        }

        public CopyBuilder setAdditionalAnnotations(Annotations annotations) {
            if (annotations != null) {
                this.additionalAnnotations = annotations;
                return this;
            }
            $$$reportNull$$$0(32);
            throw null;
        }

        public CopyBuilder setCopyOverrides(boolean z) {
            this.copyOverrides = z;
            return this;
        }

        public CopyBuilder setDispatchReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
            this.dispatchReceiverParameter = receiverParameterDescriptor;
            return this;
        }

        public CopyBuilder setHiddenForResolutionEverywhereBesideSupercalls() {
            this.isHiddenForResolutionEverywhereBesideSupercalls = true;
            return this;
        }

        public CopyBuilder setHiddenToOvercomeSignatureClash() {
            this.isHiddenToOvercomeSignatureClash = true;
            return this;
        }

        public CopyBuilder setKind(Kind kind2) {
            if (kind2 != null) {
                this.kind = kind2;
                return this;
            }
            $$$reportNull$$$0(13);
            throw null;
        }

        public CopyBuilder setModality(Modality modality) {
            if (modality != null) {
                this.newModality = modality;
                return this;
            }
            $$$reportNull$$$0(9);
            throw null;
        }

        public CopyBuilder setName(Name name2) {
            if (name2 != null) {
                this.name = name2;
                return this;
            }
            $$$reportNull$$$0(16);
            throw null;
        }

        public CopyBuilder setOriginal(CallableMemberDescriptor callableMemberDescriptor) {
            this.original = (FunctionDescriptor) callableMemberDescriptor;
            return this;
        }

        public CopyBuilder setOwner(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor != null) {
                this.newOwner = declarationDescriptor;
                return this;
            }
            $$$reportNull$$$0(7);
            throw null;
        }

        public CopyBuilder setPreserveSourceElement() {
            this.preserveSourceElement = true;
            return this;
        }

        public CopyBuilder setReturnType(KotlinType kotlinType) {
            if (kotlinType != null) {
                this.newReturnType = kotlinType;
                return this;
            }
            $$$reportNull$$$0(22);
            throw null;
        }

        public CopyBuilder setSignatureChange() {
            this.signatureChange = true;
            return this;
        }

        public CopyBuilder setSubstitution(TypeSubstitution typeSubstitution) {
            if (typeSubstitution != null) {
                this.substitution = typeSubstitution;
                return this;
            }
            $$$reportNull$$$0(34);
            throw null;
        }

        public CopyBuilder setTypeParameters(List list) {
            this.newTypeParameters = list;
            return this;
        }

        public CopyBuilder setValueParameters(List list) {
            this.newValueParameterDescriptors = list;
            return this;
        }

        public CopyBuilder setVisibility(DescriptorVisibility descriptorVisibility) {
            if (descriptorVisibility != null) {
                this.newVisibility = descriptorVisibility;
                return this;
            }
            $$$reportNull$$$0(11);
            throw null;
        }
    }

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 5:
                objArr[0] = "typeParameters";
                break;
            case 6:
            case 26:
            case 28:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 7:
            case 9:
                objArr[0] = "visibility";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 10:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 11:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
            case 27:
            case 29:
                objArr[0] = "substitutor";
                break;
            case 23:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 8:
                objArr[1] = "initialize";
                break;
            case 12:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 13:
                objArr[1] = "getModality";
                break;
            case 14:
                objArr[1] = "getVisibility";
                break;
            case 16:
                objArr[1] = "getTypeParameters";
                break;
            case 17:
                objArr[1] = "getValueParameters";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 19:
                objArr[1] = "getKind";
                break;
            case 21:
                objArr[1] = "newCopyBuilder";
                break;
            case 24:
                objArr[1] = "copy";
                break;
            case 25:
                objArr[1] = "getSourceToUseForCopy";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
        }
        switch (i) {
            case 5:
            case 6:
            case 7:
                objArr[2] = "initialize";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setReturnType";
                break;
            case 11:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "newCopyBuilder";
                break;
            case 23:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                th = new IllegalStateException(format);
                break;
            default:
                th = new IllegalArgumentException(format);
                break;
        }
        throw th;
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FunctionDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r5, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r6, kotlin.reflect.jvm.internal.impl.name.Name r7, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r8, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r9) {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            if (r4 == 0) goto L_0x004f
            r2 = 1
            if (r6 == 0) goto L_0x004b
            if (r7 == 0) goto L_0x0046
            if (r8 == 0) goto L_0x0041
            if (r9 == 0) goto L_0x003c
            r3.<init>(r4, r6, r7, r9)
            kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r4 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.UNKNOWN
            r3.visibility = r4
            r3.isOperator = r1
            r3.isInfix = r1
            r3.isExternal = r1
            r3.isInline = r1
            r3.isTailrec = r1
            r3.isExpect = r1
            r3.isActual = r1
            r3.isHiddenToOvercomeSignatureClash = r1
            r3.isHiddenForResolutionEverywhereBesideSupercalls = r1
            r3.isSuspend = r1
            r3.hasStableParameterNames = r2
            r3.hasSynthesizedParameterNames = r1
            r3.overriddenFunctions = r0
            r3.lazyOverriddenFunctionsTask = r0
            r3.initialSignatureDescriptor = r0
            r3.userDataMap = r0
            if (r5 != 0) goto L_0x0037
            r5 = r3
        L_0x0037:
            r3.original = r5
            r3.kind = r8
            return
        L_0x003c:
            r4 = 4
            $$$reportNull$$$0(r4)
            throw r0
        L_0x0041:
            r4 = 3
            $$$reportNull$$$0(r4)
            throw r0
        L_0x0046:
            r4 = 2
            $$$reportNull$$$0(r4)
            throw r0
        L_0x004b:
            $$$reportNull$$$0(r2)
            throw r0
        L_0x004f:
            $$$reportNull$$$0(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement):void");
    }

    /* JADX WARNING: type inference failed for: r5v8, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r7v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl$WithDestructuringDeclaration] */
    /* JADX WARNING: type inference failed for: r7v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl] */
    /* JADX WARNING: type inference failed for: r7v4, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl$WithDestructuringDeclaration] */
    /* JADX WARNING: type inference failed for: r7v5, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl] */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v4, types: [kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl$WithDestructuringDeclaration]
      assigns: [kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl$WithDestructuringDeclaration, kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl]
      uses: [kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl$WithDestructuringDeclaration, java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl]
      mth insns count: 70
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> getSubstitutedValueParameters(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r20, java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r21, kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r22, boolean r23, boolean r24, boolean[] r25) {
        /*
            r0 = r22
            r1 = 0
            if (r21 == 0) goto L_0x00cb
            if (r0 == 0) goto L_0x00c5
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r21.size()
            r2.<init>(r3)
            java.util.Iterator r3 = r21.iterator()
        L_0x0014:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00c4
            java.lang.Object r4 = r3.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r4.getType()
            kotlin.reflect.jvm.internal.impl.types.Variance r6 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
            kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = r0.substitute(r5, r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r4.getVarargElementType()
            if (r5 != 0) goto L_0x0032
            r6 = r1
            goto L_0x0038
        L_0x0032:
            kotlin.reflect.jvm.internal.impl.types.Variance r6 = kotlin.reflect.jvm.internal.impl.types.Variance.IN_VARIANCE
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r0.substitute(r5, r6)
        L_0x0038:
            if (r13 != 0) goto L_0x003b
            return r1
        L_0x003b:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = r4.getType()
            if (r13 != r7) goto L_0x0043
            if (r5 == r6) goto L_0x0049
        L_0x0043:
            if (r25 == 0) goto L_0x0049
            r5 = 0
            r7 = 1
            r25[r5] = r7
        L_0x0049:
            boolean r5 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.WithDestructuringDeclaration
            if (r5 == 0) goto L_0x0060
            r5 = r4
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl$WithDestructuringDeclaration r5 = (kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl.WithDestructuringDeclaration) r5
            kotlin.Lazy r5 = r5.destructuringVariables$delegate
            java.lang.Object r5 = r5.getValue()
            java.util.List r5 = (java.util.List) r5
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$2 r7 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$2
            r7.<init>(r5)
            r19 = r7
            goto L_0x0062
        L_0x0060:
            r19 = r1
        L_0x0062:
            if (r23 == 0) goto L_0x0066
            r9 = r1
            goto L_0x0067
        L_0x0066:
            r9 = r4
        L_0x0067:
            int r10 = r4.getIndex()
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r11 = r4.getAnnotations()
            kotlin.reflect.jvm.internal.impl.name.Name r12 = r4.getName()
            boolean r14 = r4.declaresDefaultValue()
            boolean r15 = r4.isCrossinline()
            boolean r16 = r4.isNoinline()
            if (r24 == 0) goto L_0x0086
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r4 = r4.getSource()
            goto L_0x0088
        L_0x0086:
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r4 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
        L_0x0088:
            java.lang.String r5 = "containingDeclaration"
            r8 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r5)
            java.lang.String r5 = "annotations"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r5)
            java.lang.String r5 = "name"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r5)
            java.lang.String r5 = "outType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r5)
            java.lang.String r5 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            if (r19 != 0) goto L_0x00b3
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl r5 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl
            r7 = r5
            r8 = r20
            r17 = r6
            r18 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x00bf
        L_0x00b3:
            kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl$WithDestructuringDeclaration r5 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl$WithDestructuringDeclaration
            r7 = r5
            r8 = r20
            r17 = r6
            r18 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
        L_0x00bf:
            r2.add(r5)
            goto L_0x0014
        L_0x00c4:
            return r2
        L_0x00c5:
            r0 = 29
            $$$reportNull$$$0(r0)
            throw r1
        L_0x00cb:
            r0 = 28
            $$$reportNull$$$0(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.getSubstitutedValueParameters(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.util.List, kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor, boolean, boolean, boolean[]):java.util.List");
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        return declarationDescriptorVisitor.visitFunctionDescriptor(this, d2);
    }

    public abstract FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind2, Name name, Annotations annotations, SourceElement sourceElement);

    public FunctionDescriptor doSubstitute(CopyConfiguration copyConfiguration) {
        SourceElement sourceElement;
        ReceiverParameterDescriptor receiverParameterDescriptor;
        ReceiverParameterDescriptor receiverParameterDescriptor2;
        FunctionDescriptor functionDescriptor;
        CopyConfiguration copyConfiguration2 = copyConfiguration;
        boolean[] zArr = new boolean[1];
        Annotations composeAnnotations = copyConfiguration2.additionalAnnotations != null ? TweetUtils.composeAnnotations(getAnnotations(), copyConfiguration2.additionalAnnotations) : getAnnotations();
        DeclarationDescriptor declarationDescriptor = copyConfiguration2.newOwner;
        FunctionDescriptor functionDescriptor2 = copyConfiguration2.original;
        Kind kind2 = copyConfiguration2.kind;
        Name name = copyConfiguration2.name;
        if (copyConfiguration2.preserveSourceElement) {
            if (functionDescriptor2 != null) {
                functionDescriptor = functionDescriptor2;
            } else {
                functionDescriptor = getOriginal();
            }
            sourceElement = functionDescriptor.getSource();
        } else {
            sourceElement = SourceElement.NO_SOURCE;
        }
        SourceElement sourceElement2 = sourceElement;
        if (sourceElement2 != null) {
            FunctionDescriptorImpl createSubstitutedCopy = createSubstitutedCopy(declarationDescriptor, functionDescriptor2, kind2, name, composeAnnotations, sourceElement2);
            List<TypeParameterDescriptor> list = copyConfiguration2.newTypeParameters;
            if (list == null) {
                list = getTypeParameters();
            }
            zArr[0] = zArr[0] | (!list.isEmpty());
            ArrayList arrayList = new ArrayList(list.size());
            TypeSubstitutor substituteTypeParameters = TweetUtils.substituteTypeParameters(list, copyConfiguration2.substitution, createSubstitutedCopy, arrayList, zArr);
            if (substituteTypeParameters == null) {
                return null;
            }
            ReceiverParameterDescriptor receiverParameterDescriptor3 = copyConfiguration2.newExtensionReceiverParameter;
            if (receiverParameterDescriptor3 != null) {
                KotlinType substitute = substituteTypeParameters.substitute(receiverParameterDescriptor3.getType(), Variance.IN_VARIANCE);
                if (substitute == null) {
                    return null;
                }
                ReceiverParameterDescriptorImpl receiverParameterDescriptorImpl = new ReceiverParameterDescriptorImpl(createSubstitutedCopy, new ExtensionReceiver(createSubstitutedCopy, substitute, copyConfiguration2.newExtensionReceiverParameter.getValue()), copyConfiguration2.newExtensionReceiverParameter.getAnnotations());
                zArr[0] = (substitute != copyConfiguration2.newExtensionReceiverParameter.getType()) | zArr[0];
                receiverParameterDescriptor = receiverParameterDescriptorImpl;
            } else {
                receiverParameterDescriptor = null;
            }
            ReceiverParameterDescriptor receiverParameterDescriptor4 = copyConfiguration2.dispatchReceiverParameter;
            if (receiverParameterDescriptor4 != null) {
                ReceiverParameterDescriptor substitute2 = receiverParameterDescriptor4.substitute(substituteTypeParameters);
                if (substitute2 == null) {
                    return null;
                }
                zArr[0] = zArr[0] | (substitute2 != copyConfiguration2.dispatchReceiverParameter);
                receiverParameterDescriptor2 = substitute2;
            } else {
                receiverParameterDescriptor2 = null;
            }
            List<ValueParameterDescriptor> substitutedValueParameters = getSubstitutedValueParameters(createSubstitutedCopy, copyConfiguration2.newValueParameterDescriptors, substituteTypeParameters, copyConfiguration2.dropOriginalInContainingParts, copyConfiguration2.preserveSourceElement, zArr);
            if (substitutedValueParameters == null) {
                return null;
            }
            KotlinType substitute3 = substituteTypeParameters.substitute(copyConfiguration2.newReturnType, Variance.OUT_VARIANCE);
            if (substitute3 == null) {
                return null;
            }
            zArr[0] = zArr[0] | (substitute3 != copyConfiguration2.newReturnType);
            if (!zArr[0] && copyConfiguration2.justForTypeSubstitution) {
                return this;
            }
            final TypeSubstitutor typeSubstitutor = substituteTypeParameters;
            createSubstitutedCopy.initialize(receiverParameterDescriptor, receiverParameterDescriptor2, arrayList, substitutedValueParameters, substitute3, copyConfiguration2.newModality, copyConfiguration2.newVisibility);
            createSubstitutedCopy.isOperator = this.isOperator;
            createSubstitutedCopy.isInfix = this.isInfix;
            createSubstitutedCopy.isExternal = this.isExternal;
            createSubstitutedCopy.isInline = this.isInline;
            createSubstitutedCopy.isTailrec = this.isTailrec;
            createSubstitutedCopy.isSuspend = this.isSuspend;
            createSubstitutedCopy.isExpect = this.isExpect;
            createSubstitutedCopy.isActual = this.isActual;
            createSubstitutedCopy.setHasStableParameterNames(this.hasStableParameterNames);
            createSubstitutedCopy.isHiddenToOvercomeSignatureClash = copyConfiguration2.isHiddenToOvercomeSignatureClash;
            createSubstitutedCopy.isHiddenForResolutionEverywhereBesideSupercalls = copyConfiguration2.isHiddenForResolutionEverywhereBesideSupercalls;
            Boolean bool = copyConfiguration2.newHasSynthesizedParameterNames;
            createSubstitutedCopy.setHasSynthesizedParameterNames(bool != null ? bool.booleanValue() : this.hasSynthesizedParameterNames);
            if (!copyConfiguration2.userDataMap.isEmpty() || this.userDataMap != null) {
                Map<UserDataKey<?>, Object> map = copyConfiguration2.userDataMap;
                Map<UserDataKey<?>, Object> map2 = this.userDataMap;
                if (map2 != null) {
                    for (Entry next : map2.entrySet()) {
                        if (!map.containsKey(next.getKey())) {
                            map.put(next.getKey(), next.getValue());
                        }
                    }
                }
                if (map.size() == 1) {
                    createSubstitutedCopy.userDataMap = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
                } else {
                    createSubstitutedCopy.userDataMap = map;
                }
            }
            if (copyConfiguration2.signatureChange || this.initialSignatureDescriptor != null) {
                FunctionDescriptor functionDescriptor3 = this.initialSignatureDescriptor;
                if (functionDescriptor3 == 0) {
                    functionDescriptor3 = this;
                }
                createSubstitutedCopy.initialSignatureDescriptor = functionDescriptor3.substitute(typeSubstitutor);
            }
            if (copyConfiguration2.copyOverrides && !getOriginal().getOverriddenDescriptors().isEmpty()) {
                if (copyConfiguration2.substitution.isEmpty()) {
                    Function0<Collection<FunctionDescriptor>> function0 = this.lazyOverriddenFunctionsTask;
                    if (function0 != null) {
                        createSubstitutedCopy.lazyOverriddenFunctionsTask = function0;
                    } else {
                        createSubstitutedCopy.setOverriddenDescriptors(getOverriddenDescriptors());
                    }
                } else {
                    createSubstitutedCopy.lazyOverriddenFunctionsTask = new Function0<Collection<FunctionDescriptor>>() {
                        public Object invoke() {
                            SmartList smartList = new SmartList();
                            for (FunctionDescriptor substitute : FunctionDescriptorImpl.this.getOverriddenDescriptors()) {
                                smartList.add(substitute.substitute(typeSubstitutor));
                            }
                            return smartList;
                        }
                    };
                }
            }
            return createSubstitutedCopy;
        }
        $$$reportNull$$$0(25);
        throw null;
    }

    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    public FunctionDescriptor getInitialSignatureDescriptor() {
        return this.initialSignatureDescriptor;
    }

    public Kind getKind() {
        Kind kind2 = this.kind;
        if (kind2 != null) {
            return kind2;
        }
        $$$reportNull$$$0(19);
        throw null;
    }

    public Modality getModality() {
        Modality modality2 = this.modality;
        if (modality2 != null) {
            return modality2;
        }
        $$$reportNull$$$0(13);
        throw null;
    }

    public Collection<? extends FunctionDescriptor> getOverriddenDescriptors() {
        Function0<Collection<FunctionDescriptor>> function0 = this.lazyOverriddenFunctionsTask;
        if (function0 != null) {
            this.overriddenFunctions = (Collection) function0.invoke();
            this.lazyOverriddenFunctionsTask = null;
        }
        Collection<? extends FunctionDescriptor> collection = this.overriddenFunctions;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection != null) {
            return collection;
        }
        $$$reportNull$$$0(12);
        throw null;
    }

    public KotlinType getReturnType() {
        return this.unsubstitutedReturnType;
    }

    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.typeParameters;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    public <V> V getUserData(UserDataKey<V> userDataKey) {
        Map<UserDataKey<?>, Object> map = this.userDataMap;
        if (map == null) {
            return null;
        }
        return map.get(userDataKey);
    }

    public List<ValueParameterDescriptor> getValueParameters() {
        List<ValueParameterDescriptor> list = this.unsubstitutedValueParameters;
        if (list != null) {
            return list;
        }
        $$$reportNull$$$0(17);
        throw null;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.visibility;
        if (descriptorVisibility != null) {
            return descriptorVisibility;
        }
        $$$reportNull$$$0(14);
        throw null;
    }

    public boolean hasSynthesizedParameterNames() {
        return this.hasSynthesizedParameterNames;
    }

    public FunctionDescriptorImpl initialize(ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2, List<? extends TypeParameterDescriptor> list, List<ValueParameterDescriptor> list2, KotlinType kotlinType, Modality modality2, DescriptorVisibility descriptorVisibility) {
        if (list == null) {
            $$$reportNull$$$0(5);
            throw null;
        } else if (list2 == null) {
            $$$reportNull$$$0(6);
            throw null;
        } else if (descriptorVisibility != null) {
            this.typeParameters = ArraysKt___ArraysJvmKt.toList(list);
            this.unsubstitutedValueParameters = ArraysKt___ArraysJvmKt.toList(list2);
            this.unsubstitutedReturnType = kotlinType;
            this.modality = modality2;
            this.visibility = descriptorVisibility;
            this.extensionReceiverParameter = receiverParameterDescriptor;
            this.dispatchReceiverParameter = receiverParameterDescriptor2;
            int i = 0;
            int i2 = 0;
            while (i2 < list.size()) {
                TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) list.get(i2);
                if (typeParameterDescriptor.getIndex() == i2) {
                    i2++;
                } else {
                    throw new IllegalStateException(typeParameterDescriptor + " index is " + typeParameterDescriptor.getIndex() + " but position is " + i2);
                }
            }
            while (i < list2.size()) {
                ValueParameterDescriptor valueParameterDescriptor = list2.get(i);
                if (valueParameterDescriptor.getIndex() == i + 0) {
                    i++;
                } else {
                    throw new IllegalStateException(valueParameterDescriptor + "index is " + valueParameterDescriptor.getIndex() + " but position is " + i);
                }
            }
            return this;
        } else {
            $$$reportNull$$$0(7);
            throw null;
        }
    }

    public boolean isActual() {
        return this.isActual;
    }

    public boolean isExpect() {
        return this.isExpect;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public boolean isHiddenForResolutionEverywhereBesideSupercalls() {
        return this.isHiddenForResolutionEverywhereBesideSupercalls;
    }

    public boolean isHiddenToOvercomeSignatureClash() {
        return this.isHiddenToOvercomeSignatureClash;
    }

    public boolean isInfix() {
        if (this.isInfix) {
            return true;
        }
        for (FunctionDescriptor isInfix2 : getOriginal().getOverriddenDescriptors()) {
            if (isInfix2.isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInline() {
        return this.isInline;
    }

    public boolean isOperator() {
        if (this.isOperator) {
            return true;
        }
        for (FunctionDescriptor isOperator2 : getOriginal().getOverriddenDescriptors()) {
            if (isOperator2.isOperator()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSuspend() {
        return this.isSuspend;
    }

    public boolean isTailrec() {
        return this.isTailrec;
    }

    public CopyBuilder<? extends FunctionDescriptor> newCopyBuilder() {
        return newCopyBuilder(TypeSubstitutor.EMPTY);
    }

    public <V> void putInUserDataMap(UserDataKey<V> userDataKey, Object obj) {
        if (this.userDataMap == null) {
            this.userDataMap = new LinkedHashMap();
        }
        this.userDataMap.put(userDataKey, obj);
    }

    public void setHasStableParameterNames(boolean z) {
        this.hasStableParameterNames = z;
    }

    public void setHasSynthesizedParameterNames(boolean z) {
        this.hasSynthesizedParameterNames = z;
    }

    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection != null) {
            this.overriddenFunctions = collection;
            Iterator<? extends CallableMemberDescriptor> it = collection.iterator();
            while (it.hasNext()) {
                if (((FunctionDescriptor) it.next()).isHiddenForResolutionEverywhereBesideSupercalls()) {
                    this.isHiddenForResolutionEverywhereBesideSupercalls = true;
                    return;
                }
            }
            return;
        }
        $$$reportNull$$$0(15);
        throw null;
    }

    public void setReturnType(KotlinType kotlinType) {
        if (kotlinType != null) {
            this.unsubstitutedReturnType = kotlinType;
        } else {
            $$$reportNull$$$0(10);
            throw null;
        }
    }

    public FunctionDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality2, DescriptorVisibility descriptorVisibility, Kind kind2, boolean z) {
        FunctionDescriptor build = newCopyBuilder().setOwner(declarationDescriptor).setModality(modality2).setVisibility(descriptorVisibility).setKind(kind2).setCopyOverrides(z).build();
        if (build != null) {
            return build;
        }
        $$$reportNull$$$0(24);
        throw null;
    }

    public CopyConfiguration newCopyBuilder(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor != null) {
            CopyConfiguration copyConfiguration = new CopyConfiguration(this, typeSubstitutor.getSubstitution(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), this.extensionReceiverParameter, getReturnType(), null);
            return copyConfiguration;
        }
        $$$reportNull$$$0(22);
        throw null;
    }

    public FunctionDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(20);
            throw null;
        } else if (typeSubstitutor.isEmpty()) {
            return this;
        } else {
            CopyConfiguration newCopyBuilder = newCopyBuilder(typeSubstitutor);
            newCopyBuilder.original = getOriginal();
            newCopyBuilder.preserveSourceElement = true;
            newCopyBuilder.justForTypeSubstitution = true;
            return newCopyBuilder.build();
        }
    }

    public FunctionDescriptor getOriginal() {
        FunctionDescriptor functionDescriptor = this.original;
        FunctionDescriptor original2 = functionDescriptor == this ? this : functionDescriptor.getOriginal();
        if (original2 != 0) {
            return original2;
        }
        $$$reportNull$$$0(18);
        throw null;
    }
}
