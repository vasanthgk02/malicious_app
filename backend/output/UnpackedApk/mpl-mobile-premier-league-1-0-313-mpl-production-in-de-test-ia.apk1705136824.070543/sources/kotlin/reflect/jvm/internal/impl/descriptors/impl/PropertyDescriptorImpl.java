package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

public class PropertyDescriptorImpl extends VariableDescriptorWithInitializerImpl implements PropertyDescriptor {
    public FieldDescriptor backingField;
    public FieldDescriptor delegateField;
    public ReceiverParameterDescriptor dispatchReceiverParameter;
    public ReceiverParameterDescriptor extensionReceiverParameter;
    public PropertyGetterDescriptorImpl getter;
    public final boolean isActual;
    public final boolean isConst;
    public final boolean isDelegated;
    public final boolean isExpect;
    public final boolean isExternal;
    public final Kind kind;
    public final boolean lateInit;
    public final Modality modality;
    public final PropertyDescriptor original;
    public Collection<? extends PropertyDescriptor> overriddenProperties;
    public PropertySetterDescriptor setter;
    public boolean setterProjectedOut;
    public List<TypeParameterDescriptor> typeParameters;
    public DescriptorVisibility visibility;

    public class CopyConfiguration {
        public boolean copyOverrides = true;
        public ReceiverParameterDescriptor dispatchReceiverParameter;
        public Kind kind = PropertyDescriptorImpl.this.getKind();
        public Modality modality = PropertyDescriptorImpl.this.getModality();
        public Name name;
        public List<TypeParameterDescriptor> newTypeParameters;
        public PropertyDescriptor original = null;
        public DeclarationDescriptor owner = PropertyDescriptorImpl.this.getContainingDeclaration();
        public boolean preserveSourceElement = false;
        public KotlinType returnType;
        public TypeSubstitution substitution = TypeSubstitution.EMPTY;
        public DescriptorVisibility visibility = PropertyDescriptorImpl.this.getVisibility();

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            int i2 = i;
            String str = (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? 2 : 3)];
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i2 == 1) {
                objArr[1] = "setOwner";
            } else if (i2 == 2) {
                objArr[1] = "setOriginal";
            } else if (i2 == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i2 == 5) {
                objArr[1] = "setReturnType";
            } else if (i2 == 7) {
                objArr[1] = "setModality";
            } else if (i2 == 9) {
                objArr[1] = "setVisibility";
            } else if (i2 == 11) {
                objArr[1] = "setKind";
            } else if (i2 == 19) {
                objArr[1] = "setName";
            } else if (i2 == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i2 == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i2 == 16) {
                objArr[1] = "setSubstitution";
            } else if (i2 != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            throw ((i2 == 1 || i2 == 2 || i2 == 3 || i2 == 5 || i2 == 7 || i2 == 9 || i2 == 11 || i2 == 19 || i2 == 13 || i2 == 14 || i2 == 16 || i2 == 17) ? new IllegalStateException(format) : new IllegalArgumentException(format));
        }

        public CopyConfiguration() {
            PropertyDescriptorImpl propertyDescriptorImpl = PropertyDescriptorImpl.this;
            this.dispatchReceiverParameter = propertyDescriptorImpl.dispatchReceiverParameter;
            this.newTypeParameters = null;
            this.name = propertyDescriptorImpl.getName();
            this.returnType = PropertyDescriptorImpl.this.getType();
        }

        public PropertyDescriptor build() {
            SourceElement sourceElement;
            ReceiverParameterDescriptor receiverParameterDescriptor;
            ReceiverParameterDescriptor receiverParameterDescriptor2;
            PropertyGetterDescriptorImpl propertyGetterDescriptorImpl;
            PropertySetterDescriptorImpl propertySetterDescriptorImpl;
            PropertySetterDescriptor propertySetterDescriptor;
            PropertyGetterDescriptor propertyGetterDescriptor;
            PropertyDescriptor propertyDescriptor;
            PropertyDescriptorImpl propertyDescriptorImpl = PropertyDescriptorImpl.this;
            FieldDescriptorImpl fieldDescriptorImpl = null;
            if (propertyDescriptorImpl != null) {
                DeclarationDescriptor declarationDescriptor = this.owner;
                Modality modality2 = this.modality;
                DescriptorVisibility descriptorVisibility = this.visibility;
                PropertyDescriptor propertyDescriptor2 = this.original;
                Kind kind2 = this.kind;
                Name name2 = this.name;
                if (this.preserveSourceElement) {
                    if (propertyDescriptor2 != null) {
                        propertyDescriptor = propertyDescriptor2;
                    } else {
                        propertyDescriptor = propertyDescriptorImpl.getOriginal();
                    }
                    sourceElement = propertyDescriptor.getSource();
                } else {
                    sourceElement = SourceElement.NO_SOURCE;
                }
                SourceElement sourceElement2 = sourceElement;
                if (sourceElement2 != null) {
                    PropertyDescriptorImpl createSubstitutedCopy = propertyDescriptorImpl.createSubstitutedCopy(declarationDescriptor, modality2, descriptorVisibility, propertyDescriptor2, kind2, name2, sourceElement2);
                    List<TypeParameterDescriptor> list = this.newTypeParameters;
                    if (list == null) {
                        list = propertyDescriptorImpl.getTypeParameters();
                    }
                    ArrayList arrayList = new ArrayList(list.size());
                    TypeSubstitutor substituteTypeParameters = TweetUtils.substituteTypeParameters(list, this.substitution, createSubstitutedCopy, arrayList);
                    KotlinType substitute = substituteTypeParameters.substitute(this.returnType, Variance.OUT_VARIANCE);
                    if (substitute == null) {
                        return null;
                    }
                    ReceiverParameterDescriptor receiverParameterDescriptor3 = this.dispatchReceiverParameter;
                    if (receiverParameterDescriptor3 != null) {
                        receiverParameterDescriptor = receiverParameterDescriptor3.substitute(substituteTypeParameters);
                        if (receiverParameterDescriptor == null) {
                            return null;
                        }
                    } else {
                        receiverParameterDescriptor = null;
                    }
                    ReceiverParameterDescriptor receiverParameterDescriptor4 = propertyDescriptorImpl.extensionReceiverParameter;
                    if (receiverParameterDescriptor4 != null) {
                        KotlinType substitute2 = substituteTypeParameters.substitute(receiverParameterDescriptor4.getType(), Variance.IN_VARIANCE);
                        if (substitute2 == null) {
                            return null;
                        }
                        receiverParameterDescriptor2 = new ReceiverParameterDescriptorImpl(createSubstitutedCopy, new ExtensionReceiver(createSubstitutedCopy, substitute2, propertyDescriptorImpl.extensionReceiverParameter.getValue()), propertyDescriptorImpl.extensionReceiverParameter.getAnnotations());
                    } else {
                        receiverParameterDescriptor2 = null;
                    }
                    createSubstitutedCopy.setType(substitute, arrayList, receiverParameterDescriptor, receiverParameterDescriptor2);
                    PropertyGetterDescriptorImpl propertyGetterDescriptorImpl2 = propertyDescriptorImpl.getter;
                    if (propertyGetterDescriptorImpl2 == null) {
                        propertyGetterDescriptorImpl = null;
                    } else {
                        Annotations annotations = propertyGetterDescriptorImpl2.getAnnotations();
                        Modality modality3 = this.modality;
                        DescriptorVisibility visibility2 = propertyDescriptorImpl.getter.getVisibility();
                        if (this.kind == Kind.FAKE_OVERRIDE && DescriptorVisibilities.isPrivate(visibility2.normalize())) {
                            visibility2 = DescriptorVisibilities.INVISIBLE_FAKE;
                        }
                        DescriptorVisibility descriptorVisibility2 = visibility2;
                        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl3 = propertyDescriptorImpl.getter;
                        boolean z = propertyGetterDescriptorImpl3.isDefault;
                        boolean z2 = propertyGetterDescriptorImpl3.isExternal;
                        boolean z3 = propertyGetterDescriptorImpl3.isInline;
                        Kind kind3 = this.kind;
                        PropertyDescriptor propertyDescriptor3 = this.original;
                        if (propertyDescriptor3 == null) {
                            propertyGetterDescriptor = null;
                        } else {
                            propertyGetterDescriptor = propertyDescriptor3.getGetter();
                        }
                        propertyGetterDescriptorImpl = new PropertyGetterDescriptorImpl(createSubstitutedCopy, annotations, modality3, descriptorVisibility2, z, z2, z3, kind3, propertyGetterDescriptor, SourceElement.NO_SOURCE);
                    }
                    if (propertyGetterDescriptorImpl != null) {
                        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl4 = propertyDescriptorImpl.getter;
                        KotlinType kotlinType = propertyGetterDescriptorImpl4.returnType;
                        propertyGetterDescriptorImpl.initialSignatureDescriptor = PropertyDescriptorImpl.getSubstitutedInitialSignatureDescriptor(substituteTypeParameters, propertyGetterDescriptorImpl4);
                        propertyGetterDescriptorImpl.initialize(kotlinType != null ? substituteTypeParameters.substitute(kotlinType, Variance.OUT_VARIANCE) : null);
                    }
                    PropertySetterDescriptor propertySetterDescriptor2 = propertyDescriptorImpl.setter;
                    if (propertySetterDescriptor2 == null) {
                        propertySetterDescriptorImpl = null;
                    } else {
                        Annotations annotations2 = propertySetterDescriptor2.getAnnotations();
                        Modality modality4 = this.modality;
                        DescriptorVisibility visibility3 = propertyDescriptorImpl.setter.getVisibility();
                        if (this.kind == Kind.FAKE_OVERRIDE && DescriptorVisibilities.isPrivate(visibility3.normalize())) {
                            visibility3 = DescriptorVisibilities.INVISIBLE_FAKE;
                        }
                        DescriptorVisibility descriptorVisibility3 = visibility3;
                        boolean isDefault = propertyDescriptorImpl.setter.isDefault();
                        boolean isExternal = propertyDescriptorImpl.setter.isExternal();
                        boolean isInline = propertyDescriptorImpl.setter.isInline();
                        Kind kind4 = this.kind;
                        PropertyDescriptor propertyDescriptor4 = this.original;
                        if (propertyDescriptor4 == null) {
                            propertySetterDescriptor = null;
                        } else {
                            propertySetterDescriptor = propertyDescriptor4.getSetter();
                        }
                        propertySetterDescriptorImpl = new PropertySetterDescriptorImpl(createSubstitutedCopy, annotations2, modality4, descriptorVisibility3, isDefault, isExternal, isInline, kind4, propertySetterDescriptor, SourceElement.NO_SOURCE);
                    }
                    if (propertySetterDescriptorImpl != null) {
                        List<ValueParameterDescriptor> substitutedValueParameters = FunctionDescriptorImpl.getSubstitutedValueParameters(propertySetterDescriptorImpl, propertyDescriptorImpl.setter.getValueParameters(), substituteTypeParameters, false, false, null);
                        if (substitutedValueParameters == null) {
                            createSubstitutedCopy.setterProjectedOut = true;
                            substitutedValueParameters = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter(propertySetterDescriptorImpl, DescriptorUtilsKt.getBuiltIns(this.owner).getNothingType(), propertyDescriptorImpl.setter.getValueParameters().get(0).getAnnotations()));
                        }
                        if (substitutedValueParameters.size() == 1) {
                            propertySetterDescriptorImpl.initialSignatureDescriptor = PropertyDescriptorImpl.getSubstitutedInitialSignatureDescriptor(substituteTypeParameters, propertyDescriptorImpl.setter);
                            propertySetterDescriptorImpl.initialize(substitutedValueParameters.get(0));
                        } else {
                            throw new IllegalStateException();
                        }
                    }
                    FieldDescriptor fieldDescriptor = propertyDescriptorImpl.backingField;
                    FieldDescriptor fieldDescriptorImpl2 = fieldDescriptor == null ? null : new FieldDescriptorImpl(fieldDescriptor.getAnnotations(), createSubstitutedCopy);
                    FieldDescriptor fieldDescriptor2 = propertyDescriptorImpl.delegateField;
                    if (fieldDescriptor2 != null) {
                        fieldDescriptorImpl = new FieldDescriptorImpl(fieldDescriptor2.getAnnotations(), createSubstitutedCopy);
                    }
                    createSubstitutedCopy.initialize(propertyGetterDescriptorImpl, propertySetterDescriptorImpl, fieldDescriptorImpl2, fieldDescriptorImpl);
                    if (this.copyOverrides) {
                        SmartSet create = SmartSet.create();
                        for (PropertyDescriptor substitute3 : propertyDescriptorImpl.getOverriddenDescriptors()) {
                            create.add(substitute3.substitute(substituteTypeParameters));
                        }
                        createSubstitutedCopy.setOverriddenDescriptors(create);
                    }
                    if (propertyDescriptorImpl.isConst()) {
                        NullableLazyValue<ConstantValue<?>> nullableLazyValue = propertyDescriptorImpl.compileTimeInitializer;
                        if (nullableLazyValue != null) {
                            createSubstitutedCopy.setCompileTimeInitializer(nullableLazyValue);
                        }
                    }
                    return createSubstitutedCopy;
                }
                PropertyDescriptorImpl.$$$reportNull$$$0(23);
                throw null;
            }
            throw null;
        }
    }

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        Throwable th;
        if (!(i == 23 || i == 33 || i == 34 || i == 36 || i == 37)) {
            switch (i) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        }
        str = "@NotNull method %s.%s must not return null";
        if (!(i == 23 || i == 33 || i == 34 || i == 36 || i == 37)) {
            switch (i) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    break;
                default:
                    i2 = 3;
                    break;
            }
        }
        i2 = 2;
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 8:
                objArr[0] = "annotations";
                break;
            case 2:
            case 9:
                objArr[0] = "modality";
                break;
            case 3:
            case 10:
            case 16:
                objArr[0] = "visibility";
                break;
            case 4:
            case 11:
                objArr[0] = "name";
                break;
            case 5:
            case 12:
            case 30:
                objArr[0] = "kind";
                break;
            case 6:
            case 13:
            case 32:
                objArr[0] = DefaultSettingsSpiCall.SOURCE_PARAM;
                break;
            case 14:
                objArr[0] = "outType";
                break;
            case 15:
                objArr[0] = "typeParameters";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 33:
            case 34:
            case 36:
            case 37:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                break;
            case 22:
                objArr[0] = "originalSubstitutor";
                break;
            case 24:
                objArr[0] = "copyConfiguration";
                break;
            case 25:
                objArr[0] = "substitutor";
                break;
            case 26:
                objArr[0] = "accessorDescriptor";
                break;
            case 27:
                objArr[0] = "newOwner";
                break;
            case 28:
                objArr[0] = "newModality";
                break;
            case 29:
                objArr[0] = "newVisibility";
                break;
            case 31:
                objArr[0] = "newName";
                break;
            case 35:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i == 23) {
            objArr[1] = "getSourceToUseForCopy";
        } else if (i == 33) {
            objArr[1] = "getOriginal";
        } else if (i == 34) {
            objArr[1] = "getKind";
        } else if (i == 36) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i != 37) {
            switch (i) {
                case 17:
                    objArr[1] = "getTypeParameters";
                    break;
                case 18:
                    objArr[1] = "getReturnType";
                    break;
                case 19:
                    objArr[1] = "getModality";
                    break;
                case 20:
                    objArr[1] = "getVisibility";
                    break;
                case 21:
                    objArr[1] = "getAccessors";
                    break;
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
                    break;
            }
        } else {
            objArr[1] = "copy";
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[2] = "create";
                break;
            case 14:
            case 15:
                objArr[2] = "setType";
                break;
            case 16:
                objArr[2] = "setVisibility";
                break;
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 23:
            case 33:
            case 34:
            case 36:
            case 37:
                break;
            case 22:
                objArr[2] = "substitute";
                break;
            case 24:
                objArr[2] = "doSubstitute";
                break;
            case 25:
            case 26:
                objArr[2] = "getSubstitutedInitialSignatureDescriptor";
                break;
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 35:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (!(i == 23 || i == 33 || i == 34 || i == 36 || i == 37)) {
            switch (i) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                    break;
                default:
                    th = new IllegalArgumentException(format);
                    break;
            }
        }
        th = new IllegalStateException(format);
        throw th;
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor] */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PropertyDescriptorImpl(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r13, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r14, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r15, kotlin.reflect.jvm.internal.impl.descriptors.Modality r16, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r17, boolean r18, kotlin.reflect.jvm.internal.impl.name.Name r19, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind r20, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27) {
        /*
            r12 = this;
            r7 = r12
            r8 = r16
            r9 = r17
            r10 = r20
            r11 = 0
            if (r13 == 0) goto L_0x0069
            if (r15 == 0) goto L_0x0064
            if (r8 == 0) goto L_0x005f
            if (r9 == 0) goto L_0x005a
            if (r19 == 0) goto L_0x0055
            if (r10 == 0) goto L_0x0050
            if (r21 == 0) goto L_0x004b
            r4 = 0
            r0 = r12
            r1 = r13
            r2 = r15
            r3 = r19
            r5 = r18
            r6 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.overriddenProperties = r11
            r7.modality = r8
            r7.visibility = r9
            if (r14 != 0) goto L_0x002d
            r0 = r7
            goto L_0x002e
        L_0x002d:
            r0 = r14
        L_0x002e:
            r7.original = r0
            r7.kind = r10
            r0 = r22
            r7.lateInit = r0
            r0 = r23
            r7.isConst = r0
            r0 = r24
            r7.isExpect = r0
            r0 = r25
            r7.isActual = r0
            r0 = r26
            r7.isExternal = r0
            r0 = r27
            r7.isDelegated = r0
            return
        L_0x004b:
            r0 = 6
            $$$reportNull$$$0(r0)
            throw r11
        L_0x0050:
            r0 = 5
            $$$reportNull$$$0(r0)
            throw r11
        L_0x0055:
            r0 = 4
            $$$reportNull$$$0(r0)
            throw r11
        L_0x005a:
            r0 = 3
            $$$reportNull$$$0(r0)
            throw r11
        L_0x005f:
            r0 = 2
            $$$reportNull$$$0(r0)
            throw r11
        L_0x0064:
            r0 = 1
            $$$reportNull$$$0(r0)
            throw r11
        L_0x0069:
            r0 = 0
            $$$reportNull$$$0(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations, kotlin.reflect.jvm.internal.impl.descriptors.Modality, kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility, boolean, kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor$Kind, kotlin.reflect.jvm.internal.impl.descriptors.SourceElement, boolean, boolean, boolean, boolean, boolean, boolean):void");
    }

    public static FunctionDescriptor getSubstitutedInitialSignatureDescriptor(TypeSubstitutor typeSubstitutor, PropertyAccessorDescriptor propertyAccessorDescriptor) {
        if (propertyAccessorDescriptor == null) {
            $$$reportNull$$$0(26);
            throw null;
        } else if (propertyAccessorDescriptor.getInitialSignatureDescriptor() != null) {
            return propertyAccessorDescriptor.getInitialSignatureDescriptor().substitute(typeSubstitutor);
        } else {
            return null;
        }
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
        return declarationDescriptorVisitor.visitPropertyDescriptor(this, d2);
    }

    public CallableMemberDescriptor copy(DeclarationDescriptor declarationDescriptor, Modality modality2, DescriptorVisibility descriptorVisibility, Kind kind2, boolean z) {
        CopyConfiguration copyConfiguration = new CopyConfiguration();
        copyConfiguration.owner = declarationDescriptor;
        copyConfiguration.original = null;
        if (modality2 != null) {
            copyConfiguration.modality = modality2;
            if (descriptorVisibility != null) {
                copyConfiguration.visibility = descriptorVisibility;
                if (kind2 != null) {
                    copyConfiguration.kind = kind2;
                    copyConfiguration.copyOverrides = z;
                    PropertyDescriptor build = copyConfiguration.build();
                    if (build != null) {
                        return build;
                    }
                    $$$reportNull$$$0(37);
                    throw null;
                }
                CopyConfiguration.$$$reportNull$$$0(10);
                throw null;
            }
            CopyConfiguration.$$$reportNull$$$0(8);
            throw null;
        }
        CopyConfiguration.$$$reportNull$$$0(6);
        throw null;
    }

    public PropertyDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, Modality modality2, DescriptorVisibility descriptorVisibility, PropertyDescriptor propertyDescriptor, Kind kind2, Name name, SourceElement sourceElement) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(27);
            throw null;
        } else if (modality2 == null) {
            $$$reportNull$$$0(28);
            throw null;
        } else if (descriptorVisibility == null) {
            $$$reportNull$$$0(29);
            throw null;
        } else if (kind2 == null) {
            $$$reportNull$$$0(30);
            throw null;
        } else if (name == null) {
            $$$reportNull$$$0(31);
            throw null;
        } else if (sourceElement != null) {
            PropertyDescriptorImpl propertyDescriptorImpl = new PropertyDescriptorImpl(declarationDescriptor, propertyDescriptor, getAnnotations(), modality2, descriptorVisibility, this.isVar, name, kind2, sourceElement, this.lateInit, isConst(), this.isExpect, this.isActual, isExternal(), this.isDelegated);
            return propertyDescriptorImpl;
        } else {
            $$$reportNull$$$0(32);
            throw null;
        }
    }

    public List<PropertyAccessorDescriptor> getAccessors() {
        ArrayList arrayList = new ArrayList(2);
        PropertyGetterDescriptorImpl propertyGetterDescriptorImpl = this.getter;
        if (propertyGetterDescriptorImpl != null) {
            arrayList.add(propertyGetterDescriptorImpl);
        }
        PropertySetterDescriptor propertySetterDescriptor = this.setter;
        if (propertySetterDescriptor != null) {
            arrayList.add(propertySetterDescriptor);
        }
        return arrayList;
    }

    public FieldDescriptor getBackingField() {
        return this.backingField;
    }

    public FieldDescriptor getDelegateField() {
        return this.delegateField;
    }

    public ReceiverParameterDescriptor getDispatchReceiverParameter() {
        return this.dispatchReceiverParameter;
    }

    public ReceiverParameterDescriptor getExtensionReceiverParameter() {
        return this.extensionReceiverParameter;
    }

    public PropertyGetterDescriptor getGetter() {
        return this.getter;
    }

    public Kind getKind() {
        Kind kind2 = this.kind;
        if (kind2 != null) {
            return kind2;
        }
        $$$reportNull$$$0(34);
        throw null;
    }

    public Modality getModality() {
        Modality modality2 = this.modality;
        if (modality2 != null) {
            return modality2;
        }
        $$$reportNull$$$0(19);
        throw null;
    }

    public Collection<? extends PropertyDescriptor> getOverriddenDescriptors() {
        Collection<? extends PropertyDescriptor> collection = this.overriddenProperties;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection != null) {
            return collection;
        }
        $$$reportNull$$$0(36);
        throw null;
    }

    public KotlinType getReturnType() {
        KotlinType type = getType();
        if (type != null) {
            return type;
        }
        $$$reportNull$$$0(18);
        throw null;
    }

    public PropertySetterDescriptor getSetter() {
        return this.setter;
    }

    public List<TypeParameterDescriptor> getTypeParameters() {
        List<TypeParameterDescriptor> list = this.typeParameters;
        if (list != null) {
            return list;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("typeParameters == null for ");
        outline73.append(DeclarationDescriptorImpl.toString(this));
        throw new IllegalStateException(outline73.toString());
    }

    public <V> V getUserData(UserDataKey<V> userDataKey) {
        return null;
    }

    public DescriptorVisibility getVisibility() {
        DescriptorVisibility descriptorVisibility = this.visibility;
        if (descriptorVisibility != null) {
            return descriptorVisibility;
        }
        $$$reportNull$$$0(20);
        throw null;
    }

    public void initialize(PropertyGetterDescriptorImpl propertyGetterDescriptorImpl, PropertySetterDescriptor propertySetterDescriptor, FieldDescriptor fieldDescriptor, FieldDescriptor fieldDescriptor2) {
        this.getter = propertyGetterDescriptorImpl;
        this.setter = propertySetterDescriptor;
        this.backingField = fieldDescriptor;
        this.delegateField = fieldDescriptor2;
    }

    public boolean isActual() {
        return this.isActual;
    }

    public boolean isConst() {
        return this.isConst;
    }

    public boolean isDelegated() {
        return this.isDelegated;
    }

    public boolean isExpect() {
        return this.isExpect;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public boolean isLateInit() {
        return this.lateInit;
    }

    public void setOverriddenDescriptors(Collection<? extends CallableMemberDescriptor> collection) {
        if (collection != null) {
            this.overriddenProperties = collection;
        } else {
            $$$reportNull$$$0(35);
            throw null;
        }
    }

    public void setType(KotlinType kotlinType, List<? extends TypeParameterDescriptor> list, ReceiverParameterDescriptor receiverParameterDescriptor, ReceiverParameterDescriptor receiverParameterDescriptor2) {
        if (kotlinType == null) {
            $$$reportNull$$$0(14);
            throw null;
        } else if (list != null) {
            this.outType = kotlinType;
            this.typeParameters = new ArrayList(list);
            this.extensionReceiverParameter = receiverParameterDescriptor2;
            this.dispatchReceiverParameter = receiverParameterDescriptor;
        } else {
            $$$reportNull$$$0(15);
            throw null;
        }
    }

    public PropertyDescriptor substitute(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            $$$reportNull$$$0(22);
            throw null;
        } else if (typeSubstitutor.isEmpty()) {
            return this;
        } else {
            CopyConfiguration copyConfiguration = new CopyConfiguration();
            TypeSubstitution substitution = typeSubstitutor.getSubstitution();
            if (substitution != null) {
                copyConfiguration.substitution = substitution;
                copyConfiguration.original = getOriginal();
                return copyConfiguration.build();
            }
            CopyConfiguration.$$$reportNull$$$0(15);
            throw null;
        }
    }

    public PropertyDescriptor getOriginal() {
        PropertyDescriptor propertyDescriptor = this.original;
        PropertyDescriptor original2 = propertyDescriptor == this ? this : propertyDescriptor.getOriginal();
        if (original2 != 0) {
            return original2;
        }
        $$$reportNull$$$0(33);
        throw null;
    }
}
