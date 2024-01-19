package kotlin.reflect.jvm.internal.impl.types.error;

import com.google.firebase.crashlytics.internal.analytics.BreadcrumbAnalyticsEventReceiver;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;

public class ErrorSimpleFunctionDescriptorImpl extends SimpleFunctionDescriptorImpl {
    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 6 || i == 7) ? 2 : 3)];
        switch (i) {
            case 1:
                objArr[0] = "ownerScope";
                break;
            case 2:
                objArr[0] = "newOwner";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "annotations";
                break;
            case 5:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
                break;
            case 8:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 6) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 6:
            case 7:
                break;
            case 8:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 6 || i == 7) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ErrorSimpleFunctionDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r9, kotlin.reflect.jvm.internal.impl.types.ErrorUtils.ErrorScope r10) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L_0x0022
            if (r10 == 0) goto L_0x001d
            r3 = 0
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$Companion r10 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion
            if (r10 == 0) goto L_0x001c
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion.EMPTY
            java.lang.String r10 = "<ERROR FUNCTION>"
            kotlin.reflect.jvm.internal.impl.name.Name r5 = kotlin.reflect.jvm.internal.impl.name.Name.special(r10)
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind r6 = kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind.DECLARATION
            kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r7 = kotlin.reflect.jvm.internal.impl.descriptors.SourceElement.NO_SOURCE
            r1 = r8
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return
        L_0x001c:
            throw r0
        L_0x001d:
            r9 = 1
            $$$reportNull$$$0(r9)
            throw r0
        L_0x0022:
            r9 = 0
            $$$reportNull$$$0(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.error.ErrorSimpleFunctionDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor, kotlin.reflect.jvm.internal.impl.types.ErrorUtils$ErrorScope):void");
    }

    public CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, Kind kind, boolean z) {
        return this;
    }

    /* renamed from: copy  reason: collision with other method in class */
    public FunctionDescriptor m984copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, Kind kind, boolean z) {
        return this;
    }

    /* renamed from: copy  reason: collision with other method in class */
    public SimpleFunctionDescriptor m985copy(DeclarationDescriptor declarationDescriptor, Modality modality, DescriptorVisibility descriptorVisibility, Kind kind, boolean z) {
        return this;
    }

    public FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(2);
            throw null;
        } else if (kind == null) {
            $$$reportNull$$$0(3);
            throw null;
        } else if (annotations == null) {
            $$$reportNull$$$0(4);
            throw null;
        } else if (sourceElement != null) {
            return this;
        } else {
            $$$reportNull$$$0(5);
            throw null;
        }
    }

    public <V> V getUserData(UserDataKey<V> userDataKey) {
        return null;
    }

    public boolean isSuspend() {
        return false;
    }

    public CopyBuilder<? extends SimpleFunctionDescriptor> newCopyBuilder() {
        return new CopyBuilder<SimpleFunctionDescriptor>() {
            public static /* synthetic */ void $$$reportNull$$$0(int i) {
                String str;
                int i2;
                Throwable th;
                int i3 = i;
                if (!(i3 == 1 || i3 == 3 || i3 == 5 || i3 == 10 || i3 == 12 || i3 == 14 || i3 == 16 || i3 == 18 || i3 == 30 || i3 == 7 || i3 == 8)) {
                    switch (i3) {
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                            break;
                        default:
                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                            break;
                    }
                }
                str = "@NotNull method %s.%s must not return null";
                if (!(i3 == 1 || i3 == 3 || i3 == 5 || i3 == 10 || i3 == 12 || i3 == 14 || i3 == 16 || i3 == 18 || i3 == 30 || i3 == 7 || i3 == 8)) {
                    switch (i3) {
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                            break;
                        default:
                            i2 = 3;
                            break;
                    }
                }
                i2 = 2;
                Object[] objArr = new Object[i2];
                switch (i3) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                    case 14:
                    case 16:
                    case 18:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 30:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                        break;
                    case 2:
                        objArr[0] = "modality";
                        break;
                    case 4:
                        objArr[0] = "visibility";
                        break;
                    case 6:
                        objArr[0] = "kind";
                        break;
                    case 9:
                        objArr[0] = "name";
                        break;
                    case 11:
                    case 17:
                        objArr[0] = BreadcrumbAnalyticsEventReceiver.BREADCRUMB_PARAMS_KEY;
                        break;
                    case 13:
                        objArr[0] = "substitution";
                        break;
                    case 15:
                        objArr[0] = "userDataKey";
                        break;
                    case 19:
                        objArr[0] = "type";
                        break;
                    case 29:
                        objArr[0] = "additionalAnnotations";
                        break;
                    default:
                        objArr[0] = "owner";
                        break;
                }
                if (i3 == 1) {
                    objArr[1] = "setOwner";
                } else if (i3 == 3) {
                    objArr[1] = "setModality";
                } else if (i3 == 5) {
                    objArr[1] = "setVisibility";
                } else if (i3 == 10) {
                    objArr[1] = "setName";
                } else if (i3 == 12) {
                    objArr[1] = "setValueParameters";
                } else if (i3 == 14) {
                    objArr[1] = "setSubstitution";
                } else if (i3 == 16) {
                    objArr[1] = "putUserData";
                } else if (i3 == 18) {
                    objArr[1] = "setTypeParameters";
                } else if (i3 == 30) {
                    objArr[1] = "setAdditionalAnnotations";
                } else if (i3 == 7) {
                    objArr[1] = "setKind";
                } else if (i3 != 8) {
                    switch (i3) {
                        case 20:
                            objArr[1] = "setReturnType";
                            break;
                        case 21:
                            objArr[1] = "setExtensionReceiverParameter";
                            break;
                        case 22:
                            objArr[1] = "setDispatchReceiverParameter";
                            break;
                        case 23:
                            objArr[1] = "setOriginal";
                            break;
                        case 24:
                            objArr[1] = "setSignatureChange";
                            break;
                        case 25:
                            objArr[1] = "setPreserveSourceElement";
                            break;
                        case 26:
                            objArr[1] = "setDropOriginalInContainingParts";
                            break;
                        case 27:
                            objArr[1] = "setHiddenToOvercomeSignatureClash";
                            break;
                        case 28:
                            objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                            break;
                        default:
                            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/error/ErrorSimpleFunctionDescriptorImpl$1";
                            break;
                    }
                } else {
                    objArr[1] = "setCopyOverrides";
                }
                switch (i3) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                    case 14:
                    case 16:
                    case 18:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 30:
                        break;
                    case 2:
                        objArr[2] = "setModality";
                        break;
                    case 4:
                        objArr[2] = "setVisibility";
                        break;
                    case 6:
                        objArr[2] = "setKind";
                        break;
                    case 9:
                        objArr[2] = "setName";
                        break;
                    case 11:
                        objArr[2] = "setValueParameters";
                        break;
                    case 13:
                        objArr[2] = "setSubstitution";
                        break;
                    case 15:
                        objArr[2] = "putUserData";
                        break;
                    case 17:
                        objArr[2] = "setTypeParameters";
                        break;
                    case 19:
                        objArr[2] = "setReturnType";
                        break;
                    case 29:
                        objArr[2] = "setAdditionalAnnotations";
                        break;
                    default:
                        objArr[2] = "setOwner";
                        break;
                }
                String format = String.format(str, objArr);
                if (!(i3 == 1 || i3 == 3 || i3 == 5 || i3 == 10 || i3 == 12 || i3 == 14 || i3 == 16 || i3 == 18 || i3 == 30 || i3 == 7 || i3 == 8)) {
                    switch (i3) {
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                            break;
                        default:
                            th = new IllegalArgumentException(format);
                            break;
                    }
                }
                th = new IllegalStateException(format);
                throw th;
            }

            public FunctionDescriptor build() {
                return ErrorSimpleFunctionDescriptorImpl.this;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setAdditionalAnnotations(Annotations annotations) {
                if (annotations != null) {
                    return this;
                }
                $$$reportNull$$$0(29);
                throw null;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setCopyOverrides(boolean z) {
                return this;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setDispatchReceiverParameter(ReceiverParameterDescriptor receiverParameterDescriptor) {
                return this;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setHiddenForResolutionEverywhereBesideSupercalls() {
                return this;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setHiddenToOvercomeSignatureClash() {
                return this;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setKind(Kind kind) {
                if (kind != null) {
                    return this;
                }
                $$$reportNull$$$0(6);
                throw null;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setModality(Modality modality) {
                if (modality != null) {
                    return this;
                }
                $$$reportNull$$$0(2);
                throw null;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setName(Name name) {
                if (name != null) {
                    return this;
                }
                $$$reportNull$$$0(9);
                throw null;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setOriginal(CallableMemberDescriptor callableMemberDescriptor) {
                return this;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setOwner(DeclarationDescriptor declarationDescriptor) {
                if (declarationDescriptor != null) {
                    return this;
                }
                $$$reportNull$$$0(0);
                throw null;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setPreserveSourceElement() {
                return this;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setReturnType(KotlinType kotlinType) {
                if (kotlinType != null) {
                    return this;
                }
                $$$reportNull$$$0(19);
                throw null;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setSignatureChange() {
                return this;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setSubstitution(TypeSubstitution typeSubstitution) {
                if (typeSubstitution != null) {
                    return this;
                }
                $$$reportNull$$$0(13);
                throw null;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setTypeParameters(List<TypeParameterDescriptor> list) {
                return this;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setValueParameters(List<ValueParameterDescriptor> list) {
                return this;
            }

            public CopyBuilder<SimpleFunctionDescriptor> setVisibility(DescriptorVisibility descriptorVisibility) {
                if (descriptorVisibility != null) {
                    return this;
                }
                $$$reportNull$$$0(4);
                throw null;
            }
        };
    }

    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == null) {
            $$$reportNull$$$0(8);
            throw null;
        }
    }
}
