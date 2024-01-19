package kotlin.reflect.jvm.internal.impl.renderer;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.PromiseImpl;
import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.DelegatedDescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile.AnonymousClass1;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnresolvedType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.text.CharsKt__CharKt;
import org.apache.fontbox.cmap.CMap;

/* compiled from: DescriptorRendererImpl.kt */
public final class DescriptorRendererImpl extends DescriptorRenderer implements DescriptorRendererOptions {
    public final Lazy functionTypeAnnotationsRenderer$delegate;
    public final DescriptorRendererOptionsImpl options;

    /* compiled from: DescriptorRendererImpl.kt */
    public final class RenderDeclarationDescriptorVisitor implements DeclarationDescriptorVisitor<Unit, StringBuilder> {
        public final /* synthetic */ DescriptorRendererImpl this$0;

        public RenderDeclarationDescriptorVisitor(DescriptorRendererImpl descriptorRendererImpl) {
            Intrinsics.checkNotNullParameter(descriptorRendererImpl, "this$0");
            this.this$0 = descriptorRendererImpl;
        }

        public Object visitClassDescriptor(ClassDescriptor classDescriptor, Object obj) {
            String str;
            StringBuilder sb = (StringBuilder) obj;
            Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl descriptorRendererImpl = this.this$0;
            if (descriptorRendererImpl != null) {
                boolean z = classDescriptor.getKind() == ClassKind.ENUM_ENTRY;
                if (!descriptorRendererImpl.getStartFromName()) {
                    descriptorRendererImpl.renderAnnotations(sb, classDescriptor, null);
                    if (!z) {
                        DescriptorVisibility visibility = classDescriptor.getVisibility();
                        Intrinsics.checkNotNullExpressionValue(visibility, "klass.visibility");
                        descriptorRendererImpl.renderVisibility(visibility, sb);
                    }
                    if (!(classDescriptor.getKind() == ClassKind.INTERFACE && classDescriptor.getModality() == Modality.ABSTRACT) && (!classDescriptor.getKind().isSingleton() || classDescriptor.getModality() != Modality.FINAL)) {
                        Modality modality = classDescriptor.getModality();
                        Intrinsics.checkNotNullExpressionValue(modality, "klass.modality");
                        descriptorRendererImpl.renderModality(modality, sb, descriptorRendererImpl.implicitModalityWithoutExtensions(classDescriptor));
                    }
                    descriptorRendererImpl.renderMemberModifiers(classDescriptor, sb);
                    descriptorRendererImpl.renderModifier(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.INNER) && classDescriptor.isInner(), "inner");
                    descriptorRendererImpl.renderModifier(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.DATA) && classDescriptor.isData(), "data");
                    descriptorRendererImpl.renderModifier(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.INLINE) && classDescriptor.isInline(), "inline");
                    descriptorRendererImpl.renderModifier(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.VALUE) && classDescriptor.isValue(), HSLCriteriaBuilder.VALUE);
                    descriptorRendererImpl.renderModifier(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.FUN) && classDescriptor.isFun(), "fun");
                    Intrinsics.checkNotNullParameter(classDescriptor, "classifier");
                    if (classDescriptor instanceof TypeAliasDescriptor) {
                        str = "typealias";
                    } else if (classDescriptor.isCompanionObject()) {
                        str = "companion object";
                    } else {
                        int ordinal = classDescriptor.getKind().ordinal();
                        if (ordinal == 0) {
                            str = PromiseImpl.STACK_FRAME_KEY_CLASS;
                        } else if (ordinal == 1) {
                            str = "interface";
                        } else if (ordinal == 2) {
                            str = "enum class";
                        } else if (ordinal == 3) {
                            str = "enum entry";
                        } else if (ordinal == 4) {
                            str = "annotation class";
                        } else if (ordinal == 5) {
                            str = "object";
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                    sb.append(descriptorRendererImpl.renderKeyword(str));
                }
                if (!DescriptorUtils.isCompanionObject(classDescriptor)) {
                    if (!descriptorRendererImpl.getStartFromName()) {
                        descriptorRendererImpl.renderSpaceIfNeeded(sb);
                    }
                    descriptorRendererImpl.renderName(classDescriptor, sb, true);
                } else {
                    DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = descriptorRendererImpl.options;
                    if (((Boolean) descriptorRendererOptionsImpl.renderCompanionObjectName$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[30])).booleanValue()) {
                        if (descriptorRendererImpl.getStartFromName()) {
                            sb.append("companion object");
                        }
                        descriptorRendererImpl.renderSpaceIfNeeded(sb);
                        DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
                        if (containingDeclaration != null) {
                            sb.append("of ");
                            Name name = containingDeclaration.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "containingDeclaration.name");
                            sb.append(descriptorRendererImpl.renderName(name, false));
                        }
                    }
                    if (descriptorRendererImpl.getVerbose() || !Intrinsics.areEqual(classDescriptor.getName(), SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT)) {
                        if (!descriptorRendererImpl.getStartFromName()) {
                            descriptorRendererImpl.renderSpaceIfNeeded(sb);
                        }
                        Name name2 = classDescriptor.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "descriptor.name");
                        sb.append(descriptorRendererImpl.renderName(name2, true));
                    }
                }
                if (!z) {
                    List<TypeParameterDescriptor> declaredTypeParameters = classDescriptor.getDeclaredTypeParameters();
                    Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "klass.declaredTypeParameters");
                    descriptorRendererImpl.renderTypeParameters(declaredTypeParameters, sb, false);
                    descriptorRendererImpl.renderCapturedTypeParametersIfRequired(classDescriptor, sb);
                    if (!classDescriptor.getKind().isSingleton()) {
                        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl2 = descriptorRendererImpl.options;
                        if (((Boolean) descriptorRendererOptionsImpl2.classWithPrimaryConstructor$delegate.getValue(descriptorRendererOptionsImpl2, DescriptorRendererOptionsImpl.$$delegatedProperties[7])).booleanValue()) {
                            ClassConstructorDescriptor unsubstitutedPrimaryConstructor = classDescriptor.getUnsubstitutedPrimaryConstructor();
                            if (unsubstitutedPrimaryConstructor != null) {
                                sb.append(CMap.SPACE);
                                descriptorRendererImpl.renderAnnotations(sb, unsubstitutedPrimaryConstructor, null);
                                DescriptorVisibility visibility2 = unsubstitutedPrimaryConstructor.getVisibility();
                                Intrinsics.checkNotNullExpressionValue(visibility2, "primaryConstructor.visibility");
                                descriptorRendererImpl.renderVisibility(visibility2, sb);
                                sb.append(descriptorRendererImpl.renderKeyword("constructor"));
                                List<ValueParameterDescriptor> valueParameters = unsubstitutedPrimaryConstructor.getValueParameters();
                                Intrinsics.checkNotNullExpressionValue(valueParameters, "primaryConstructor.valueParameters");
                                descriptorRendererImpl.renderValueParameters(valueParameters, unsubstitutedPrimaryConstructor.hasSynthesizedParameterNames(), sb);
                            }
                        }
                    }
                    DescriptorRendererOptionsImpl descriptorRendererOptionsImpl3 = descriptorRendererImpl.options;
                    if (!((Boolean) descriptorRendererOptionsImpl3.withoutSuperTypes$delegate.getValue(descriptorRendererOptionsImpl3, DescriptorRendererOptionsImpl.$$delegatedProperties[21])).booleanValue() && !KotlinBuiltIns.isNothing(classDescriptor.getDefaultType())) {
                        Collection<KotlinType> supertypes = classDescriptor.getTypeConstructor().getSupertypes();
                        Intrinsics.checkNotNullExpressionValue(supertypes, "klass.typeConstructor.supertypes");
                        if (!supertypes.isEmpty() && (supertypes.size() != 1 || !KotlinBuiltIns.isAnyOrNullableAny(supertypes.iterator().next()))) {
                            descriptorRendererImpl.renderSpaceIfNeeded(sb);
                            sb.append(": ");
                            ArraysKt___ArraysJvmKt.joinTo$default(supertypes, sb, ", ", null, null, 0, null, new DescriptorRendererImpl$renderSuperTypes$1(descriptorRendererImpl), 60);
                        }
                    }
                    descriptorRendererImpl.renderWhereSuffix(declaredTypeParameters, sb);
                }
                return Unit.INSTANCE;
            }
            throw null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0075  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00db  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x013e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object visitConstructorDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r19, java.lang.Object r20) {
            /*
                r18 = this;
                r0 = r19
                r1 = r20
                java.lang.StringBuilder r1 = (java.lang.StringBuilder) r1
                java.lang.String r2 = "constructorDescriptor"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r2)
                java.lang.String r2 = "builder"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
                r2 = r18
                kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl r3 = r2.this$0
                r4 = 0
                r3.renderAnnotations(r1, r0, r4)
                kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r4 = r3.options
                kotlin.properties.ReadWriteProperty r5 = r4.renderDefaultVisibility$delegate
                kotlin.reflect.KProperty<java.lang.Object>[] r6 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.$$delegatedProperties
                r7 = 13
                r6 = r6[r7]
                java.lang.Object r4 = r5.getValue(r4, r6)
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                r5 = 0
                r6 = 1
                if (r4 != 0) goto L_0x003c
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = r19.getConstructedClass()
                kotlin.reflect.jvm.internal.impl.descriptors.Modality r4 = r4.getModality()
                kotlin.reflect.jvm.internal.impl.descriptors.Modality r7 = kotlin.reflect.jvm.internal.impl.descriptors.Modality.SEALED
                if (r4 == r7) goto L_0x004d
            L_0x003c:
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r4 = r19.getVisibility()
                java.lang.String r7 = "constructor.visibility"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
                boolean r4 = r3.renderVisibility(r4, r1)
                if (r4 == 0) goto L_0x004d
                r4 = 1
                goto L_0x004e
            L_0x004d:
                r4 = 0
            L_0x004e:
                r3.renderMemberKind(r0, r1)
                kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r7 = r3.options
                kotlin.properties.ReadWriteProperty r8 = r7.renderConstructorKeyword$delegate
                kotlin.reflect.KProperty<java.lang.Object>[] r9 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.$$delegatedProperties
                r10 = 39
                r9 = r9[r10]
                java.lang.Object r7 = r8.getValue(r7, r9)
                java.lang.Boolean r7 = (java.lang.Boolean) r7
                boolean r7 = r7.booleanValue()
                if (r7 != 0) goto L_0x0072
                boolean r7 = r19.isPrimary()
                if (r7 == 0) goto L_0x0072
                if (r4 == 0) goto L_0x0070
                goto L_0x0072
            L_0x0070:
                r4 = 0
                goto L_0x0073
            L_0x0072:
                r4 = 1
            L_0x0073:
                if (r4 == 0) goto L_0x007e
                java.lang.String r7 = "constructor"
                java.lang.String r7 = r3.renderKeyword(r7)
                r1.append(r7)
            L_0x007e:
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r7 = r19.getContainingDeclaration()
                java.lang.String r8 = "constructor.containingDeclaration"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
                boolean r8 = r3.getSecondaryConstructorsAsPrimary()
                java.lang.String r9 = "constructor.typeParameters"
                if (r8 == 0) goto L_0x00a3
                if (r4 == 0) goto L_0x0096
                java.lang.String r4 = " "
                r1.append(r4)
            L_0x0096:
                r3.renderName(r7, r1, r6)
                java.util.List r4 = r19.getTypeParameters()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
                r3.renderTypeParameters(r4, r1, r5)
            L_0x00a3:
                java.util.List r4 = r19.getValueParameters()
                java.lang.String r8 = "constructor.valueParameters"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r8)
                boolean r8 = r19.hasSynthesizedParameterNames()
                r3.renderValueParameters(r4, r8, r1)
                kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r4 = r3.options
                kotlin.properties.ReadWriteProperty r8 = r4.renderConstructorDelegation$delegate
                kotlin.reflect.KProperty<java.lang.Object>[] r10 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.$$delegatedProperties
                r11 = 15
                r10 = r10[r11]
                java.lang.Object r4 = r8.getValue(r4, r10)
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                if (r4 == 0) goto L_0x0138
                boolean r4 = r19.isPrimary()
                if (r4 != 0) goto L_0x0138
                boolean r4 = r7 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
                if (r4 == 0) goto L_0x0138
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r7
                kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r4 = r7.getUnsubstitutedPrimaryConstructor()
                if (r4 == 0) goto L_0x0138
                java.util.List r4 = r4.getValueParameters()
                java.lang.String r7 = "primaryConstructor.valueParameters"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r7)
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
                java.util.Iterator r4 = r4.iterator()
            L_0x00ed:
                boolean r7 = r4.hasNext()
                if (r7 == 0) goto L_0x010f
                java.lang.Object r7 = r4.next()
                r8 = r7
                kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r8 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r8
                boolean r11 = r8.declaresDefaultValue()
                if (r11 != 0) goto L_0x0108
                kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = r8.getVarargElementType()
                if (r8 != 0) goto L_0x0108
                r8 = 1
                goto L_0x0109
            L_0x0108:
                r8 = 0
            L_0x0109:
                if (r8 == 0) goto L_0x00ed
                r10.add(r7)
                goto L_0x00ed
            L_0x010f:
                boolean r4 = r10.isEmpty()
                r4 = r4 ^ r6
                if (r4 == 0) goto L_0x0138
                java.lang.String r4 = " : "
                r1.append(r4)
                java.lang.String r4 = "this"
                java.lang.String r4 = r3.renderKeyword(r4)
                r1.append(r4)
                r14 = 0
                r15 = 0
                kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderConstructor$1 r16 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$renderConstructor$1.INSTANCE
                r17 = 24
                java.lang.String r11 = ", "
                java.lang.String r12 = "("
                java.lang.String r13 = ")"
                java.lang.String r4 = kotlin.collections.ArraysKt___ArraysJvmKt.joinToString$default(r10, r11, r12, r13, r14, r15, r16, r17)
                r1.append(r4)
            L_0x0138:
                boolean r4 = r3.getSecondaryConstructorsAsPrimary()
                if (r4 == 0) goto L_0x0148
                java.util.List r0 = r19.getTypeParameters()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r9)
                r3.renderWhereSuffix(r0, r1)
            L_0x0148:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.RenderDeclarationDescriptorVisitor.visitConstructorDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor, java.lang.Object):java.lang.Object");
        }

        public /* bridge */ /* synthetic */ Object visitFunctionDescriptor(FunctionDescriptor functionDescriptor, Object obj) {
            visitFunctionDescriptor(functionDescriptor, (StringBuilder) obj);
            return Unit.INSTANCE;
        }

        public Object visitModuleDeclaration(ModuleDescriptor moduleDescriptor, Object obj) {
            StringBuilder sb = (StringBuilder) obj;
            Intrinsics.checkNotNullParameter(moduleDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            this.this$0.renderName(moduleDescriptor, sb, true);
            return Unit.INSTANCE;
        }

        public Object visitPackageFragmentDescriptor(PackageFragmentDescriptor packageFragmentDescriptor, Object obj) {
            StringBuilder sb = (StringBuilder) obj;
            Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl descriptorRendererImpl = this.this$0;
            if (descriptorRendererImpl != null) {
                descriptorRendererImpl.renderPackageHeader(packageFragmentDescriptor.getFqName(), "package-fragment", sb);
                if (descriptorRendererImpl.getDebugMode()) {
                    sb.append(" in ");
                    descriptorRendererImpl.renderName(packageFragmentDescriptor.getContainingDeclaration(), sb, false);
                }
                return Unit.INSTANCE;
            }
            throw null;
        }

        public Object visitPackageViewDescriptor(PackageViewDescriptor packageViewDescriptor, Object obj) {
            StringBuilder sb = (StringBuilder) obj;
            Intrinsics.checkNotNullParameter(packageViewDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl descriptorRendererImpl = this.this$0;
            if (descriptorRendererImpl != null) {
                descriptorRendererImpl.renderPackageHeader(packageViewDescriptor.getFqName(), "package", sb);
                if (descriptorRendererImpl.getDebugMode()) {
                    sb.append(" in context of ");
                    descriptorRendererImpl.renderName(packageViewDescriptor.getModule(), sb, false);
                }
                return Unit.INSTANCE;
            }
            throw null;
        }

        public final void visitPropertyAccessorDescriptor(PropertyAccessorDescriptor propertyAccessorDescriptor, StringBuilder sb, String str) {
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.this$0.options;
            int ordinal = ((PropertyAccessorRenderingPolicy) descriptorRendererOptionsImpl.propertyAccessorRenderingPolicy$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[31])).ordinal();
            if (ordinal == 0) {
                this.this$0.renderMemberModifiers(propertyAccessorDescriptor, sb);
                sb.append(Intrinsics.stringPlus(str, " for "));
                DescriptorRendererImpl descriptorRendererImpl = this.this$0;
                PropertyDescriptor correspondingProperty = propertyAccessorDescriptor.getCorrespondingProperty();
                Intrinsics.checkNotNullExpressionValue(correspondingProperty, "descriptor.correspondingProperty");
                DescriptorRendererImpl.access$renderProperty(descriptorRendererImpl, correspondingProperty, sb);
            } else if (ordinal == 1) {
                visitFunctionDescriptor((FunctionDescriptor) propertyAccessorDescriptor, sb);
            }
        }

        public Object visitPropertyDescriptor(PropertyDescriptor propertyDescriptor, Object obj) {
            StringBuilder sb = (StringBuilder) obj;
            Intrinsics.checkNotNullParameter(propertyDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl.access$renderProperty(this.this$0, propertyDescriptor, sb);
            return Unit.INSTANCE;
        }

        public Object visitPropertyGetterDescriptor(PropertyGetterDescriptor propertyGetterDescriptor, Object obj) {
            StringBuilder sb = (StringBuilder) obj;
            Intrinsics.checkNotNullParameter(propertyGetterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            visitPropertyAccessorDescriptor(propertyGetterDescriptor, sb, "getter");
            return Unit.INSTANCE;
        }

        public Object visitPropertySetterDescriptor(PropertySetterDescriptor propertySetterDescriptor, Object obj) {
            StringBuilder sb = (StringBuilder) obj;
            Intrinsics.checkNotNullParameter(propertySetterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            visitPropertyAccessorDescriptor(propertySetterDescriptor, sb, "setter");
            return Unit.INSTANCE;
        }

        public Object visitReceiverParameterDescriptor(ReceiverParameterDescriptor receiverParameterDescriptor, Object obj) {
            StringBuilder sb = (StringBuilder) obj;
            Intrinsics.checkNotNullParameter(receiverParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            sb.append(receiverParameterDescriptor.getName());
            return Unit.INSTANCE;
        }

        public Object visitTypeAliasDescriptor(TypeAliasDescriptor typeAliasDescriptor, Object obj) {
            StringBuilder sb = (StringBuilder) obj;
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            DescriptorRendererImpl descriptorRendererImpl = this.this$0;
            descriptorRendererImpl.renderAnnotations(sb, typeAliasDescriptor, null);
            DescriptorVisibility visibility = typeAliasDescriptor.getVisibility();
            Intrinsics.checkNotNullExpressionValue(visibility, "typeAlias.visibility");
            descriptorRendererImpl.renderVisibility(visibility, sb);
            descriptorRendererImpl.renderMemberModifiers(typeAliasDescriptor, sb);
            sb.append(descriptorRendererImpl.renderKeyword("typealias"));
            sb.append(CMap.SPACE);
            descriptorRendererImpl.renderName(typeAliasDescriptor, sb, true);
            List<TypeParameterDescriptor> declaredTypeParameters = typeAliasDescriptor.getDeclaredTypeParameters();
            Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "typeAlias.declaredTypeParameters");
            descriptorRendererImpl.renderTypeParameters(declaredTypeParameters, sb, false);
            descriptorRendererImpl.renderCapturedTypeParametersIfRequired(typeAliasDescriptor, sb);
            sb.append(" = ");
            sb.append(descriptorRendererImpl.renderType(typeAliasDescriptor.getUnderlyingType()));
            return Unit.INSTANCE;
        }

        public Object visitTypeParameterDescriptor(TypeParameterDescriptor typeParameterDescriptor, Object obj) {
            StringBuilder sb = (StringBuilder) obj;
            Intrinsics.checkNotNullParameter(typeParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            this.this$0.renderTypeParameter(typeParameterDescriptor, sb, true);
            return Unit.INSTANCE;
        }

        public Object visitValueParameterDescriptor(ValueParameterDescriptor valueParameterDescriptor, Object obj) {
            StringBuilder sb = (StringBuilder) obj;
            Intrinsics.checkNotNullParameter(valueParameterDescriptor, "descriptor");
            Intrinsics.checkNotNullParameter(sb, "builder");
            this.this$0.renderValueParameter(valueParameterDescriptor, true, sb, true);
            return Unit.INSTANCE;
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0084  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void visitFunctionDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r9, java.lang.StringBuilder r10) {
            /*
                r8 = this;
                java.lang.String r0 = "descriptor"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                java.lang.String r0 = "builder"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl r0 = r8.this$0
                boolean r1 = r0.getStartFromName()
                java.lang.String r2 = "function.typeParameters"
                r3 = 1
                if (r1 != 0) goto L_0x011a
                boolean r1 = r0.getStartFromDeclarationKeyword()
                if (r1 != 0) goto L_0x00ff
                r1 = 0
                r0.renderAnnotations(r10, r9, r1)
                kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility r1 = r9.getVisibility()
                java.lang.String r4 = "function.visibility"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
                r0.renderVisibility(r1, r10)
                r0.renderModalityForCallable(r9, r10)
                boolean r1 = r0.getIncludeAdditionalModifiers()
                if (r1 == 0) goto L_0x0037
                r0.renderMemberModifiers(r9, r10)
            L_0x0037:
                r0.renderOverride(r9, r10)
                boolean r1 = r0.getIncludeAdditionalModifiers()
                java.lang.String r4 = "suspend"
                if (r1 == 0) goto L_0x00d9
                boolean r1 = r9.isOperator()
                java.lang.String r5 = "functionDescriptor.overriddenDescriptors"
                r6 = 0
                if (r1 == 0) goto L_0x007d
                java.util.Collection r1 = r9.getOverriddenDescriptors()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
                boolean r7 = r1.isEmpty()
                if (r7 == 0) goto L_0x005a
                goto L_0x0072
            L_0x005a:
                java.util.Iterator r1 = r1.iterator()
            L_0x005e:
                boolean r7 = r1.hasNext()
                if (r7 == 0) goto L_0x0072
                java.lang.Object r7 = r1.next()
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r7
                boolean r7 = r7.isOperator()
                if (r7 == 0) goto L_0x005e
                r1 = 0
                goto L_0x0073
            L_0x0072:
                r1 = 1
            L_0x0073:
                if (r1 != 0) goto L_0x007b
                boolean r1 = r0.getAlwaysRenderModifiers()
                if (r1 == 0) goto L_0x007d
            L_0x007b:
                r1 = 1
                goto L_0x007e
            L_0x007d:
                r1 = 0
            L_0x007e:
                boolean r7 = r9.isInfix()
                if (r7 == 0) goto L_0x00b4
                java.util.Collection r7 = r9.getOverriddenDescriptors()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r5)
                boolean r5 = r7.isEmpty()
                if (r5 == 0) goto L_0x0092
                goto L_0x00aa
            L_0x0092:
                java.util.Iterator r5 = r7.iterator()
            L_0x0096:
                boolean r7 = r5.hasNext()
                if (r7 == 0) goto L_0x00aa
                java.lang.Object r7 = r5.next()
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r7
                boolean r7 = r7.isInfix()
                if (r7 == 0) goto L_0x0096
                r5 = 0
                goto L_0x00ab
            L_0x00aa:
                r5 = 1
            L_0x00ab:
                if (r5 != 0) goto L_0x00b3
                boolean r5 = r0.getAlwaysRenderModifiers()
                if (r5 == 0) goto L_0x00b4
            L_0x00b3:
                r6 = 1
            L_0x00b4:
                boolean r5 = r9.isTailrec()
                java.lang.String r7 = "tailrec"
                r0.renderModifier(r10, r5, r7)
                boolean r5 = r9.isSuspend()
                r0.renderModifier(r10, r5, r4)
                boolean r4 = r9.isInline()
                java.lang.String r5 = "inline"
                r0.renderModifier(r10, r4, r5)
                java.lang.String r4 = "infix"
                r0.renderModifier(r10, r6, r4)
                java.lang.String r4 = "operator"
                r0.renderModifier(r10, r1, r4)
                goto L_0x00e0
            L_0x00d9:
                boolean r1 = r9.isSuspend()
                r0.renderModifier(r10, r1, r4)
            L_0x00e0:
                r0.renderMemberKind(r9, r10)
                boolean r1 = r0.getVerbose()
                if (r1 == 0) goto L_0x00ff
                boolean r1 = r9.isHiddenToOvercomeSignatureClash()
                if (r1 == 0) goto L_0x00f4
                java.lang.String r1 = "/*isHiddenToOvercomeSignatureClash*/ "
                r10.append(r1)
            L_0x00f4:
                boolean r1 = r9.isHiddenForResolutionEverywhereBesideSupercalls()
                if (r1 == 0) goto L_0x00ff
                java.lang.String r1 = "/*isHiddenForResolutionEverywhereBesideSupercalls*/ "
                r10.append(r1)
            L_0x00ff:
                java.lang.String r1 = "fun"
                java.lang.String r1 = r0.renderKeyword(r1)
                r10.append(r1)
                java.lang.String r1 = " "
                r10.append(r1)
                java.util.List r1 = r9.getTypeParameters()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
                r0.renderTypeParameters(r1, r10, r3)
                r0.renderReceiver(r9, r10)
            L_0x011a:
                r0.renderName(r9, r10, r3)
                java.util.List r1 = r9.getValueParameters()
                java.lang.String r3 = "function.valueParameters"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                boolean r3 = r9.hasSynthesizedParameterNames()
                r0.renderValueParameters(r1, r3, r10)
                r0.renderReceiverAfterName(r9, r10)
                kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r9.getReturnType()
                kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r3 = r0.options
                kotlin.properties.ReadWriteProperty r4 = r3.withoutReturnType$delegate
                kotlin.reflect.KProperty<java.lang.Object>[] r5 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.$$delegatedProperties
                r6 = 10
                r5 = r5[r6]
                java.lang.Object r3 = r4.getValue(r3, r5)
                java.lang.Boolean r3 = (java.lang.Boolean) r3
                boolean r3 = r3.booleanValue()
                if (r3 != 0) goto L_0x0179
                kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r3 = r0.options
                kotlin.properties.ReadWriteProperty r4 = r3.unitReturnType$delegate
                kotlin.reflect.KProperty<java.lang.Object>[] r5 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.$$delegatedProperties
                r6 = 9
                r5 = r5[r6]
                java.lang.Object r3 = r4.getValue(r3, r5)
                java.lang.Boolean r3 = (java.lang.Boolean) r3
                boolean r3 = r3.booleanValue()
                if (r3 != 0) goto L_0x0168
                if (r1 == 0) goto L_0x0168
                boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isUnit(r1)
                if (r3 != 0) goto L_0x0179
            L_0x0168:
                java.lang.String r3 = ": "
                r10.append(r3)
                if (r1 != 0) goto L_0x0172
                java.lang.String r1 = "[NULL]"
                goto L_0x0176
            L_0x0172:
                java.lang.String r1 = r0.renderType(r1)
            L_0x0176:
                r10.append(r1)
            L_0x0179:
                java.util.List r9 = r9.getTypeParameters()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
                r0.renderWhereSuffix(r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.RenderDeclarationDescriptorVisitor.visitFunctionDescriptor(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, java.lang.StringBuilder):void");
        }
    }

    public DescriptorRendererImpl(DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        Intrinsics.checkNotNullParameter(descriptorRendererOptionsImpl, "options");
        this.options = descriptorRendererOptionsImpl;
        boolean z = descriptorRendererOptionsImpl.isLocked;
        if (!_Assertions.ENABLED || z) {
            this.functionTypeAnnotationsRenderer$delegate = TweetUtils.lazy((Function0<? extends T>) new DescriptorRendererImpl$functionTypeAnnotationsRenderer$2<Object>(this));
            return;
        }
        throw new AssertionError("Assertion failed");
    }

    public static final void access$renderProperty(DescriptorRendererImpl descriptorRendererImpl, PropertyDescriptor propertyDescriptor, StringBuilder sb) {
        if (!descriptorRendererImpl.getStartFromName()) {
            if (!descriptorRendererImpl.getStartFromDeclarationKeyword()) {
                if (descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
                    descriptorRendererImpl.renderAnnotations(sb, propertyDescriptor, null);
                    FieldDescriptor backingField = propertyDescriptor.getBackingField();
                    if (backingField != null) {
                        descriptorRendererImpl.renderAnnotations(sb, backingField, AnnotationUseSiteTarget.FIELD);
                    }
                    FieldDescriptor delegateField = propertyDescriptor.getDelegateField();
                    if (delegateField != null) {
                        descriptorRendererImpl.renderAnnotations(sb, delegateField, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
                    }
                    DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = descriptorRendererImpl.options;
                    if (((PropertyAccessorRenderingPolicy) descriptorRendererOptionsImpl.propertyAccessorRenderingPolicy$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[31])) == PropertyAccessorRenderingPolicy.NONE) {
                        PropertyGetterDescriptor getter = propertyDescriptor.getGetter();
                        if (getter != null) {
                            descriptorRendererImpl.renderAnnotations(sb, getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
                        }
                        PropertySetterDescriptor setter = propertyDescriptor.getSetter();
                        if (setter != null) {
                            descriptorRendererImpl.renderAnnotations(sb, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                            List<ValueParameterDescriptor> valueParameters = setter.getValueParameters();
                            Intrinsics.checkNotNullExpressionValue(valueParameters, "setter.valueParameters");
                            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) ArraysKt___ArraysJvmKt.single(valueParameters);
                            Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "it");
                            descriptorRendererImpl.renderAnnotations(sb, valueParameterDescriptor, AnnotationUseSiteTarget.SETTER_PARAMETER);
                        }
                    }
                }
                DescriptorVisibility visibility = propertyDescriptor.getVisibility();
                Intrinsics.checkNotNullExpressionValue(visibility, "property.visibility");
                descriptorRendererImpl.renderVisibility(visibility, sb);
                descriptorRendererImpl.renderModifier(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.CONST) && propertyDescriptor.isConst(), "const");
                descriptorRendererImpl.renderMemberModifiers(propertyDescriptor, sb);
                descriptorRendererImpl.renderModalityForCallable(propertyDescriptor, sb);
                descriptorRendererImpl.renderOverride(propertyDescriptor, sb);
                descriptorRendererImpl.renderModifier(sb, descriptorRendererImpl.getModifiers().contains(DescriptorRendererModifier.LATEINIT) && propertyDescriptor.isLateInit(), "lateinit");
                descriptorRendererImpl.renderMemberKind(propertyDescriptor, sb);
            }
            descriptorRendererImpl.renderValVarPrefix(propertyDescriptor, sb, false);
            List<TypeParameterDescriptor> typeParameters = propertyDescriptor.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "property.typeParameters");
            descriptorRendererImpl.renderTypeParameters(typeParameters, sb, true);
            descriptorRendererImpl.renderReceiver(propertyDescriptor, sb);
        }
        descriptorRendererImpl.renderName(propertyDescriptor, sb, true);
        sb.append(": ");
        KotlinType type = propertyDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "property.type");
        sb.append(descriptorRendererImpl.renderType(type));
        descriptorRendererImpl.renderReceiverAfterName(propertyDescriptor, sb);
        descriptorRendererImpl.renderInitializer(propertyDescriptor, sb);
        List<TypeParameterDescriptor> typeParameters2 = propertyDescriptor.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters2, "property.typeParameters");
        descriptorRendererImpl.renderWhereSuffix(typeParameters2, sb);
    }

    public static /* synthetic */ void renderAnnotations$default(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget, int i) {
        int i2 = i & 2;
        descriptorRendererImpl.renderAnnotations(sb, annotated, null);
    }

    public final void appendTypeProjections(StringBuilder sb, List<? extends TypeProjection> list) {
        ArraysKt___ArraysJvmKt.joinTo$default(list, sb, ", ", null, null, 0, null, new DescriptorRendererImpl$appendTypeProjections$1(this), 60);
    }

    public final boolean differsOnlyInNullability(String str, String str2) {
        if (!Intrinsics.areEqual(str, CharsKt__CharKt.replace$default(str2, (String) ColorPropConverter.PREFIX_ATTR, (String) "", false, 4)) && (!CharsKt__CharKt.endsWith$default(str2, (String) ColorPropConverter.PREFIX_ATTR, false, 2) || !Intrinsics.areEqual(Intrinsics.stringPlus(str, ColorPropConverter.PREFIX_ATTR), str2))) {
            if (!Intrinsics.areEqual('(' + str + ")?", str2)) {
                return false;
            }
        }
        return true;
    }

    public final String escape(String str) {
        return getTextFormat().escape(str);
    }

    public boolean getAlwaysRenderModifiers() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return ((Boolean) descriptorRendererOptionsImpl.alwaysRenderModifiers$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[38])).booleanValue();
    }

    public boolean getBoldOnlyForNamesInHtml() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return ((Boolean) descriptorRendererOptionsImpl.boldOnlyForNamesInHtml$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[46])).booleanValue();
    }

    public ClassifierNamePolicy getClassifierNamePolicy() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return (ClassifierNamePolicy) descriptorRendererOptionsImpl.classifierNamePolicy$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[0]);
    }

    public boolean getDebugMode() {
        return this.options.getDebugMode();
    }

    public boolean getEnhancedTypes() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return ((Boolean) descriptorRendererOptionsImpl.enhancedTypes$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[11])).booleanValue();
    }

    public Set<FqName> getExcludedTypeAnnotationClasses() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return (Set) descriptorRendererOptionsImpl.excludedTypeAnnotationClasses$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[35]);
    }

    public boolean getIncludeAdditionalModifiers() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return ((Boolean) descriptorRendererOptionsImpl.includeAdditionalModifiers$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[42])).booleanValue();
    }

    public Set<DescriptorRendererModifier> getModifiers() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return (Set) descriptorRendererOptionsImpl.modifiers$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[3]);
    }

    public boolean getSecondaryConstructorsAsPrimary() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return ((Boolean) descriptorRendererOptionsImpl.secondaryConstructorsAsPrimary$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[24])).booleanValue();
    }

    public boolean getStartFromDeclarationKeyword() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return ((Boolean) descriptorRendererOptionsImpl.startFromDeclarationKeyword$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[5])).booleanValue();
    }

    public boolean getStartFromName() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return ((Boolean) descriptorRendererOptionsImpl.startFromName$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[4])).booleanValue();
    }

    public RenderingFormat getTextFormat() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return (RenderingFormat) descriptorRendererOptionsImpl.textFormat$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[27]);
    }

    public ValueParametersHandler getValueParametersHandler() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return (ValueParametersHandler) descriptorRendererOptionsImpl.valueParametersHandler$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[26]);
    }

    public boolean getVerbose() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return ((Boolean) descriptorRendererOptionsImpl.verbose$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[8])).booleanValue();
    }

    public boolean getWithoutTypeParameters() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        return ((Boolean) descriptorRendererOptionsImpl.withoutTypeParameters$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[20])).booleanValue();
    }

    public final String gt() {
        return getTextFormat().escape(">");
    }

    public final Modality implicitModalityWithoutExtensions(MemberDescriptor memberDescriptor) {
        Modality modality;
        if (memberDescriptor instanceof ClassDescriptor) {
            return ((ClassDescriptor) memberDescriptor).getKind() == ClassKind.INTERFACE ? Modality.ABSTRACT : Modality.FINAL;
        }
        DeclarationDescriptor containingDeclaration = memberDescriptor.getContainingDeclaration();
        ClassDescriptor classDescriptor = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
        if (classDescriptor == null) {
            return Modality.FINAL;
        }
        if (!(memberDescriptor instanceof CallableMemberDescriptor)) {
            return Modality.FINAL;
        }
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) memberDescriptor;
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkNotNullExpressionValue(overriddenDescriptors, "this.overriddenDescriptors");
        if ((!overriddenDescriptors.isEmpty()) && classDescriptor.getModality() != Modality.FINAL) {
            return Modality.OPEN;
        }
        if (classDescriptor.getKind() != ClassKind.INTERFACE || Intrinsics.areEqual(callableMemberDescriptor.getVisibility(), DescriptorVisibilities.PRIVATE)) {
            modality = Modality.FINAL;
        } else {
            Modality modality2 = callableMemberDescriptor.getModality();
            modality = Modality.ABSTRACT;
            if (modality2 != modality) {
                modality = Modality.OPEN;
            }
        }
        return modality;
    }

    public final String lt() {
        return getTextFormat().escape("<");
    }

    public String render(DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        declarationDescriptor.accept(new RenderDeclarationDescriptorVisitor(this), sb);
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        if (((Boolean) descriptorRendererOptionsImpl.withDefinedIn$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[1])).booleanValue() && !(declarationDescriptor instanceof PackageFragmentDescriptor) && !(declarationDescriptor instanceof PackageViewDescriptor)) {
            if (declarationDescriptor instanceof ModuleDescriptor) {
                sb.append(" is a module");
            } else {
                DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
                if (containingDeclaration != null && !(containingDeclaration instanceof ModuleDescriptor)) {
                    sb.append(CMap.SPACE);
                    sb.append(renderMessage("defined in"));
                    sb.append(CMap.SPACE);
                    FqNameUnsafe fqName = DescriptorUtils.getFqName(containingDeclaration);
                    Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(containingDeclaration)");
                    sb.append(fqName.isRoot() ? "root package" : renderFqName(fqName));
                    DescriptorRendererOptionsImpl descriptorRendererOptionsImpl2 = this.options;
                    if (((Boolean) descriptorRendererOptionsImpl2.withSourceFileForTopLevel$delegate.getValue(descriptorRendererOptionsImpl2, DescriptorRendererOptionsImpl.$$delegatedProperties[2])).booleanValue() && (containingDeclaration instanceof PackageFragmentDescriptor) && (declarationDescriptor instanceof DeclarationDescriptorWithSource) && ((AnonymousClass1) ((DeclarationDescriptorWithSource) declarationDescriptor).getSource().getContainingFile()) == null) {
                        throw null;
                    }
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f3 A[LOOP:3: B:38:0x00ed->B:40:0x00f3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x018a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String renderAnnotation(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor r11, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget r12) {
        /*
            r10 = this;
            java.lang.String r0 = "annotation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 64
            r0.append(r1)
            if (r12 == 0) goto L_0x001e
            java.lang.String r12 = r12.getRenderName()
            java.lang.String r1 = ":"
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r12, r1)
            r0.append(r12)
        L_0x001e:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r12 = r11.getType()
            java.lang.String r1 = r10.renderType(r12)
            r0.append(r1)
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r1 = r10.options
            r2 = 0
            if (r1 == 0) goto L_0x01b2
            java.lang.String r3 = "this"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy r1 = r1.getAnnotationArgumentsRenderingPolicy()
            boolean r1 = r1.getIncludeAnnotationArguments()
            if (r1 == 0) goto L_0x018b
            java.util.Map r1 = r11.getAllValueArguments()
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r4 = r10.options
            kotlin.properties.ReadWriteProperty r5 = r4.renderDefaultAnnotationArguments$delegate
            kotlin.reflect.KProperty<java.lang.Object>[] r6 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.$$delegatedProperties
            r7 = 32
            r6 = r6[r7]
            java.lang.Object r4 = r5.getValue(r4, r6)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x005d
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r11 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.getAnnotationClass(r11)
            goto L_0x005e
        L_0x005d:
            r11 = r2
        L_0x005e:
            if (r11 != 0) goto L_0x0061
            goto L_0x0067
        L_0x0061:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r11 = r11.getUnsubstitutedPrimaryConstructor()
            if (r11 != 0) goto L_0x0069
        L_0x0067:
            r11 = r2
            goto L_0x006d
        L_0x0069:
            java.util.List r11 = r11.getValueParameters()
        L_0x006d:
            r4 = 10
            if (r11 != 0) goto L_0x0073
            r11 = r2
            goto L_0x00b4
        L_0x0073:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r11 = r11.iterator()
        L_0x007c:
            boolean r6 = r11.hasNext()
            if (r6 == 0) goto L_0x0093
            java.lang.Object r6 = r11.next()
            r7 = r6
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r7
            boolean r7 = r7.declaresDefaultValue()
            if (r7 == 0) goto L_0x007c
            r5.add(r6)
            goto L_0x007c
        L_0x0093:
            java.util.ArrayList r11 = new java.util.ArrayList
            int r6 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r5, r4)
            r11.<init>(r6)
            java.util.Iterator r5 = r5.iterator()
        L_0x00a0:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00b4
            java.lang.Object r6 = r5.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r6
            kotlin.reflect.jvm.internal.impl.name.Name r6 = r6.getName()
            r11.add(r6)
            goto L_0x00a0
        L_0x00b4:
            if (r11 == 0) goto L_0x00b7
            goto L_0x00b9
        L_0x00b7:
            kotlin.collections.EmptyList r11 = kotlin.collections.EmptyList.INSTANCE
        L_0x00b9:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r6 = r11.iterator()
        L_0x00c2:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00e0
            java.lang.Object r7 = r6.next()
            r8 = r7
            kotlin.reflect.jvm.internal.impl.name.Name r8 = (kotlin.reflect.jvm.internal.impl.name.Name) r8
            java.lang.String r9 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            boolean r8 = r1.containsKey(r8)
            r8 = r8 ^ 1
            if (r8 == 0) goto L_0x00c2
            r5.add(r7)
            goto L_0x00c2
        L_0x00e0:
            java.util.ArrayList r6 = new java.util.ArrayList
            int r7 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r5, r4)
            r6.<init>(r7)
            java.util.Iterator r5 = r5.iterator()
        L_0x00ed:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0107
            java.lang.Object r7 = r5.next()
            kotlin.reflect.jvm.internal.impl.name.Name r7 = (kotlin.reflect.jvm.internal.impl.name.Name) r7
            java.lang.String r7 = r7.asString()
            java.lang.String r8 = " = ..."
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r8)
            r6.add(r7)
            goto L_0x00ed
        L_0x0107:
            java.util.Set r1 = r1.entrySet()
            java.util.ArrayList r5 = new java.util.ArrayList
            int r4 = com.twitter.sdk.android.tweetui.TweetUtils.collectionSizeOrDefault(r1, r4)
            r5.<init>(r4)
            java.util.Iterator r1 = r1.iterator()
        L_0x0118:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0159
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r7 = r4.getKey()
            kotlin.reflect.jvm.internal.impl.name.Name r7 = (kotlin.reflect.jvm.internal.impl.name.Name) r7
            java.lang.Object r4 = r4.getValue()
            kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue r4 = (kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue) r4
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = r7.asString()
            r8.append(r9)
            java.lang.String r9 = " = "
            r8.append(r9)
            boolean r7 = r11.contains(r7)
            if (r7 != 0) goto L_0x014c
            java.lang.String r4 = r10.renderConstant(r4)
            goto L_0x014e
        L_0x014c:
            java.lang.String r4 = "..."
        L_0x014e:
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            r5.add(r4)
            goto L_0x0118
        L_0x0159:
            java.util.List r11 = kotlin.collections.ArraysKt___ArraysJvmKt.plus(r6, r5)
            java.util.List r1 = kotlin.collections.ArraysKt___ArraysJvmKt.sorted(r11)
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r11 = r10.options
            if (r11 == 0) goto L_0x018a
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r3)
            kotlin.reflect.jvm.internal.impl.renderer.AnnotationArgumentsRenderingPolicy r11 = r11.getAnnotationArgumentsRenderingPolicy()
            boolean r11 = r11.getIncludeEmptyAnnotationArguments()
            if (r11 != 0) goto L_0x017a
            boolean r11 = r1.isEmpty()
            r11 = r11 ^ 1
            if (r11 == 0) goto L_0x018b
        L_0x017a:
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 112(0x70, float:1.57E-43)
            java.lang.String r3 = ", "
            java.lang.String r4 = "("
            java.lang.String r5 = ")"
            r2 = r0
            kotlin.collections.ArraysKt___ArraysJvmKt.joinTo$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x018b
        L_0x018a:
            throw r2
        L_0x018b:
            boolean r11 = r10.getVerbose()
            if (r11 == 0) goto L_0x01a8
            boolean r11 = com.twitter.sdk.android.tweetui.TweetUtils.isError(r12)
            if (r11 != 0) goto L_0x01a3
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r11 = r12.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r11 = r11.getDeclarationDescriptor()
            boolean r11 = r11 instanceof kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor
            if (r11 == 0) goto L_0x01a8
        L_0x01a3:
            java.lang.String r11 = " /* annotation class not found */"
            r0.append(r11)
        L_0x01a8:
            java.lang.String r11 = r0.toString()
            java.lang.String r12 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r12)
            return r11
        L_0x01b2:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderAnnotation(kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget):java.lang.String");
    }

    public final void renderAnnotations(StringBuilder sb, Annotated annotated, AnnotationUseSiteTarget annotationUseSiteTarget) {
        Set set;
        if (getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            if (annotated instanceof KotlinType) {
                DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
                set = (Set) descriptorRendererOptionsImpl.excludedTypeAnnotationClasses$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[35]);
            } else {
                DescriptorRendererOptionsImpl descriptorRendererOptionsImpl2 = this.options;
                set = (Set) descriptorRendererOptionsImpl2.excludedAnnotationClasses$delegate.getValue(descriptorRendererOptionsImpl2, DescriptorRendererOptionsImpl.$$delegatedProperties[34]);
            }
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl3 = this.options;
            Function1 function1 = (Function1) descriptorRendererOptionsImpl3.annotationFilter$delegate.getValue(descriptorRendererOptionsImpl3, DescriptorRendererOptionsImpl.$$delegatedProperties[36]);
            for (AnnotationDescriptor annotationDescriptor : annotated.getAnnotations()) {
                if (!ArraysKt___ArraysJvmKt.contains(set, annotationDescriptor.getFqName()) && !Intrinsics.areEqual(annotationDescriptor.getFqName(), FqNames.parameterName)) {
                    if (function1 == null || ((Boolean) function1.invoke(annotationDescriptor)).booleanValue()) {
                        sb.append(renderAnnotation(annotationDescriptor, annotationUseSiteTarget));
                        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl4 = this.options;
                        if (((Boolean) descriptorRendererOptionsImpl4.eachAnnotationOnNewLine$delegate.getValue(descriptorRendererOptionsImpl4, DescriptorRendererOptionsImpl.$$delegatedProperties[33])).booleanValue()) {
                            sb.append(10);
                            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
                        } else {
                            sb.append(CMap.SPACE);
                        }
                    }
                }
            }
        }
    }

    public final void renderCapturedTypeParametersIfRequired(ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, StringBuilder sb) {
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        Intrinsics.checkNotNullExpressionValue(declaredTypeParameters, "classifier.declaredTypeParameters");
        List<TypeParameterDescriptor> parameters = classifierDescriptorWithTypeParameters.getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "classifier.typeConstructor.parameters");
        if (getVerbose() && classifierDescriptorWithTypeParameters.isInner() && parameters.size() > declaredTypeParameters.size()) {
            sb.append(" /*captured type parameters: ");
            renderTypeParameterList(sb, parameters.subList(declaredTypeParameters.size(), parameters.size()));
            sb.append("*/");
        }
    }

    public final String renderConstant(ConstantValue<?> constantValue) {
        if (constantValue instanceof ArrayValue) {
            return ArraysKt___ArraysJvmKt.joinToString$default((Iterable) ((ArrayValue) constantValue).value, ", ", "{", "}", 0, null, new DescriptorRendererImpl$renderConstant$1(this), 24);
        }
        if (constantValue instanceof AnnotationValue) {
            return CharsKt__CharKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, (AnnotationDescriptor) ((AnnotationValue) constantValue).value, null, 2, null), ColorPropConverter.PREFIX_RESOURCE);
        }
        if (!(constantValue instanceof KClassValue)) {
            return constantValue.toString();
        }
        Value value = (Value) ((KClassValue) constantValue).value;
        if (value instanceof LocalClass) {
            return ((LocalClass) value).type + "::class";
        } else if (value instanceof NormalClass) {
            NormalClass normalClass = (NormalClass) value;
            String asString = normalClass.value.classId.asSingleFqName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "classValue.classId.asSingleFqName().asString()");
            for (int i = 0; i < normalClass.value.arrayNestedness; i++) {
                asString = "kotlin.Array<" + asString + '>';
            }
            return Intrinsics.stringPlus(asString, "::class");
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void renderDefaultType(StringBuilder sb, KotlinType kotlinType) {
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = null;
        renderAnnotations(sb, kotlinType, null);
        if (TweetUtils.isError(kotlinType)) {
            if (kotlinType instanceof UnresolvedType) {
                DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
                if (((Boolean) descriptorRendererOptionsImpl.presentableUnresolvedTypes$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[45])).booleanValue()) {
                    sb.append(((UnresolvedType) kotlinType).presentableName);
                    sb.append(renderTypeArguments(kotlinType.getArguments()));
                }
            }
            if (kotlinType instanceof ErrorType) {
                DescriptorRendererOptionsImpl descriptorRendererOptionsImpl2 = this.options;
                if (!((Boolean) descriptorRendererOptionsImpl2.informativeErrorType$delegate.getValue(descriptorRendererOptionsImpl2, DescriptorRendererOptionsImpl.$$delegatedProperties[47])).booleanValue()) {
                    sb.append(((ErrorType) kotlinType).getPresentableName());
                    sb.append(renderTypeArguments(kotlinType.getArguments()));
                }
            }
            sb.append(kotlinType.getConstructor().toString());
            sb.append(renderTypeArguments(kotlinType.getArguments()));
        } else {
            TypeConstructor constructor = kotlinType.getConstructor();
            Intrinsics.checkNotNullParameter(kotlinType, "<this>");
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters) {
                classifierDescriptorWithTypeParameters = (ClassifierDescriptorWithTypeParameters) declarationDescriptor;
            }
            PossiblyInnerType buildPossiblyInnerType = TweetUtils.buildPossiblyInnerType(kotlinType, classifierDescriptorWithTypeParameters, 0);
            if (buildPossiblyInnerType == null) {
                sb.append(renderTypeConstructor(constructor));
                sb.append(renderTypeArguments(kotlinType.getArguments()));
            } else {
                renderPossiblyInnerType(sb, buildPossiblyInnerType);
            }
        }
        if (kotlinType.isMarkedNullable()) {
            sb.append(ColorPropConverter.PREFIX_ATTR);
        }
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (((UnwrappedType) kotlinType) instanceof DefinitelyNotNullType) {
            sb.append("!!");
        }
    }

    public String renderFlexibleType(String str, String str2, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.checkNotNullParameter(str, "lowerRendered");
        Intrinsics.checkNotNullParameter(str2, "upperRendered");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        if (!differsOnlyInNullability(str, str2)) {
            ClassifierNamePolicy classifierNamePolicy = getClassifierNamePolicy();
            ClassDescriptor builtInClassByFqName = kotlinBuiltIns.getBuiltInClassByFqName(FqNames.collection);
            if (builtInClassByFqName != null) {
                Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "builtIns.collection");
                String substringBefore$default = CharsKt__CharKt.substringBefore$default(classifierNamePolicy.renderClassifier(builtInClassByFqName, this), (String) "Collection", (String) null, 2);
                String stringPlus = Intrinsics.stringPlus(substringBefore$default, "Mutable");
                String replacePrefixes = replacePrefixes(str, stringPlus, str2, substringBefore$default, substringBefore$default + '(' + "Mutable" + ')');
                if (replacePrefixes != null) {
                    return replacePrefixes;
                }
                String replacePrefixes2 = replacePrefixes(str, Intrinsics.stringPlus(substringBefore$default, "MutableMap.MutableEntry"), str2, Intrinsics.stringPlus(substringBefore$default, "Map.Entry"), Intrinsics.stringPlus(substringBefore$default, "(Mutable)Map.(Mutable)Entry"));
                if (replacePrefixes2 != null) {
                    return replacePrefixes2;
                }
                ClassifierNamePolicy classifierNamePolicy2 = getClassifierNamePolicy();
                ClassDescriptor builtInClassByName = kotlinBuiltIns.getBuiltInClassByName("Array");
                Intrinsics.checkNotNullExpressionValue(builtInClassByName, "builtIns.array");
                String substringBefore$default2 = CharsKt__CharKt.substringBefore$default(classifierNamePolicy2.renderClassifier(builtInClassByName, this), (String) "Array", (String) null, 2);
                String replacePrefixes3 = replacePrefixes(str, Intrinsics.stringPlus(substringBefore$default2, getTextFormat().escape("Array<")), str2, Intrinsics.stringPlus(substringBefore$default2, getTextFormat().escape("Array<out ")), Intrinsics.stringPlus(substringBefore$default2, getTextFormat().escape("Array<(out) ")));
                if (replacePrefixes3 != null) {
                    return replacePrefixes3;
                }
                return '(' + str + ".." + str2 + ')';
            }
            KotlinBuiltIns.$$$reportNull$$$0(33);
            throw null;
        } else if (!CharsKt__CharKt.startsWith$default(str2, (String) "(", false, 2)) {
            return Intrinsics.stringPlus(str, "!");
        } else {
            return '(' + str + ")!";
        }
    }

    public String renderFqName(FqNameUnsafe fqNameUnsafe) {
        Intrinsics.checkNotNullParameter(fqNameUnsafe, "fqName");
        List<Name> pathSegments = fqNameUnsafe.pathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "fqName.pathSegments()");
        return getTextFormat().escape(TweetUtils.renderFqName(pathSegments));
    }

    public final void renderInitializer(VariableDescriptor variableDescriptor, StringBuilder sb) {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        if (((Boolean) descriptorRendererOptionsImpl.includePropertyConstant$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[19])).booleanValue()) {
            ConstantValue<?> compileTimeInitializer = variableDescriptor.getCompileTimeInitializer();
            if (compileTimeInitializer != null) {
                sb.append(" = ");
                sb.append(escape(renderConstant(compileTimeInitializer)));
            }
        }
    }

    public final String renderKeyword(String str) {
        int ordinal = getTextFormat().ordinal();
        if (ordinal == 0) {
            return str;
        }
        if (ordinal == 1) {
            return getBoldOnlyForNamesInHtml() ? str : GeneratedOutlineSupport.outline52("<b>", str, "</b>");
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void renderMemberKind(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND) && getVerbose() && callableMemberDescriptor.getKind() != Kind.DECLARATION) {
            sb.append("/*");
            String name = callableMemberDescriptor.getKind().name();
            if (name != null) {
                String lowerCase = name.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                sb.append(lowerCase);
                sb.append("*/ ");
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
    }

    public final void renderMemberModifiers(MemberDescriptor memberDescriptor, StringBuilder sb) {
        renderModifier(sb, memberDescriptor.isExternal(), "external");
        boolean z = false;
        renderModifier(sb, getModifiers().contains(DescriptorRendererModifier.EXPECT) && memberDescriptor.isExpect(), "expect");
        if (getModifiers().contains(DescriptorRendererModifier.ACTUAL) && memberDescriptor.isActual()) {
            z = true;
        }
        renderModifier(sb, z, "actual");
    }

    public String renderMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        int ordinal = getTextFormat().ordinal();
        if (ordinal == 0) {
            return str;
        }
        if (ordinal == 1) {
            return GeneratedOutlineSupport.outline52("<i>", str, "</i>");
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void renderModality(Modality modality, StringBuilder sb, Modality modality2) {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        if (((Boolean) descriptorRendererOptionsImpl.renderDefaultModality$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[14])).booleanValue() || modality != modality2) {
            boolean contains = getModifiers().contains(DescriptorRendererModifier.MODALITY);
            String name = modality.name();
            if (name != null) {
                String lowerCase = name.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                renderModifier(sb, contains, lowerCase);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    public final void renderModalityForCallable(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (!DescriptorUtils.isTopLevelDeclaration(callableMemberDescriptor) || callableMemberDescriptor.getModality() != Modality.FINAL) {
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
            if (((OverrideRenderingPolicy) descriptorRendererOptionsImpl.overrideRenderingPolicy$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[25])) != OverrideRenderingPolicy.RENDER_OVERRIDE || callableMemberDescriptor.getModality() != Modality.OPEN || !(!callableMemberDescriptor.getOverriddenDescriptors().isEmpty())) {
                Modality modality = callableMemberDescriptor.getModality();
                Intrinsics.checkNotNullExpressionValue(modality, "callable.modality");
                renderModality(modality, sb, implicitModalityWithoutExtensions(callableMemberDescriptor));
            }
        }
    }

    public final void renderModifier(StringBuilder sb, boolean z, String str) {
        if (z) {
            sb.append(renderKeyword(str));
            sb.append(CMap.SPACE);
        }
    }

    public String renderName(Name name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        String escape = escape(TweetUtils.render(name));
        return (!getBoldOnlyForNamesInHtml() || getTextFormat() != RenderingFormat.HTML || !z) ? escape : GeneratedOutlineSupport.outline52("<b>", escape, "</b>");
    }

    public final void renderNormalizedType(StringBuilder sb, KotlinType kotlinType) {
        UnwrappedType unwrap = kotlinType.unwrap();
        AbbreviatedType abbreviatedType = unwrap instanceof AbbreviatedType ? (AbbreviatedType) unwrap : null;
        if (abbreviatedType != null) {
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
            if (((Boolean) descriptorRendererOptionsImpl.renderTypeExpansions$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[41])).booleanValue()) {
                renderNormalizedTypeAsIs(sb, abbreviatedType.delegate);
            } else {
                renderNormalizedTypeAsIs(sb, abbreviatedType.abbreviation);
                DescriptorRendererOptionsImpl descriptorRendererOptionsImpl2 = this.options;
                if (((Boolean) descriptorRendererOptionsImpl2.renderUnabbreviatedType$delegate.getValue(descriptorRendererOptionsImpl2, DescriptorRendererOptionsImpl.$$delegatedProperties[40])).booleanValue()) {
                    if (getTextFormat() == RenderingFormat.HTML) {
                        sb.append("<font color=\"808080\"><i>");
                    }
                    sb.append(" /* = ");
                    renderNormalizedTypeAsIs(sb, abbreviatedType.delegate);
                    sb.append(" */");
                    if (getTextFormat() == RenderingFormat.HTML) {
                        sb.append("</i></font>");
                    }
                }
            }
            return;
        }
        renderNormalizedTypeAsIs(sb, kotlinType);
    }

    /* JADX WARNING: Removed duplicated region for block: B:93:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0162  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void renderNormalizedTypeAsIs(java.lang.StringBuilder r14, kotlin.reflect.jvm.internal.impl.types.KotlinType r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof kotlin.reflect.jvm.internal.impl.types.WrappedType
            if (r0 == 0) goto L_0x0019
            boolean r0 = r13.getDebugMode()
            if (r0 == 0) goto L_0x0019
            r0 = r15
            kotlin.reflect.jvm.internal.impl.types.WrappedType r0 = (kotlin.reflect.jvm.internal.impl.types.WrappedType) r0
            boolean r0 = r0.isComputed()
            if (r0 != 0) goto L_0x0019
            java.lang.String r15 = "<Not computed yet>"
            r14.append(r15)
            return
        L_0x0019:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r15 = r15.unwrap()
            boolean r0 = r15 instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType
            if (r0 == 0) goto L_0x002c
            kotlin.reflect.jvm.internal.impl.types.FlexibleType r15 = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) r15
            java.lang.String r15 = r15.render(r13, r13)
            r14.append(r15)
            goto L_0x020f
        L_0x002c:
            boolean r0 = r15 instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType
            if (r0 == 0) goto L_0x020f
            kotlin.reflect.jvm.internal.impl.types.SimpleType r15 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r15
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.CANT_INFER_FUNCTION_PARAM_TYPE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r15, r0)
            java.lang.String r1 = "???"
            if (r0 != 0) goto L_0x020c
            r0 = 1
            r2 = 0
            if (r15 == 0) goto L_0x004e
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = r15.getConstructor()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = kotlin.reflect.jvm.internal.impl.types.TypeUtils.DONT_CARE
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r4.getConstructor()
            if (r3 != r4) goto L_0x004e
            r3 = 1
            goto L_0x004f
        L_0x004e:
            r3 = 0
        L_0x004f:
            if (r3 == 0) goto L_0x0053
            goto L_0x020c
        L_0x0053:
            if (r15 == 0) goto L_0x005f
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r3 = r15.getConstructor()
            boolean r3 = r3 instanceof kotlin.reflect.jvm.internal.impl.types.ErrorUtils.UninferredParameterTypeConstructor
            if (r3 == 0) goto L_0x005f
            r3 = 1
            goto L_0x0060
        L_0x005f:
            r3 = 0
        L_0x0060:
            r4 = 0
            if (r3 == 0) goto L_0x008b
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r2 = r13.options
            kotlin.properties.ReadWriteProperty r3 = r2.uninferredTypeParameterAsName$delegate
            kotlin.reflect.KProperty<java.lang.Object>[] r5 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.$$delegatedProperties
            r6 = 18
            r5 = r5[r6]
            java.lang.Object r2 = r3.getValue(r2, r5)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0086
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r14 = r15.getConstructor()
            kotlin.reflect.jvm.internal.impl.types.ErrorUtils$UninferredParameterTypeConstructor r14 = (kotlin.reflect.jvm.internal.impl.types.ErrorUtils.UninferredParameterTypeConstructor) r14
            if (r14 == 0) goto L_0x0085
            kotlin.reflect.jvm.internal.impl.types.ErrorUtils.UninferredParameterTypeConstructor.$$$reportNull$$$0(r0)
            throw r4
        L_0x0085:
            throw r4
        L_0x0086:
            r14.append(r1)
            goto L_0x020f
        L_0x008b:
            boolean r1 = com.twitter.sdk.android.tweetui.TweetUtils.isError(r15)
            if (r1 == 0) goto L_0x0096
            r13.renderDefaultType(r14, r15)
            goto L_0x020f
        L_0x0096:
            boolean r1 = r13.shouldRenderAsPrettyFunctionType(r15)
            if (r1 == 0) goto L_0x0208
            int r1 = r14.length()
            kotlin.Lazy r3 = r13.functionTypeAnnotationsRenderer$delegate
            java.lang.Object r3 = r3.getValue()
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl r3 = (kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl) r3
            r5 = 2
            renderAnnotations$default(r3, r14, r15, r4, r5)
            int r3 = r14.length()
            if (r3 == r1) goto L_0x00b4
            r3 = 1
            goto L_0x00b5
        L_0x00b4:
            r3 = 0
        L_0x00b5:
            boolean r5 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isSuspendFunctionType(r15)
            boolean r6 = r15.isMarkedNullable()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r7 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getReceiverTypeFromFunctionType(r15)
            if (r6 != 0) goto L_0x00ca
            if (r3 == 0) goto L_0x00c8
            if (r7 == 0) goto L_0x00c8
            goto L_0x00ca
        L_0x00c8:
            r8 = 0
            goto L_0x00cb
        L_0x00ca:
            r8 = 1
        L_0x00cb:
            java.lang.String r9 = "("
            if (r8 == 0) goto L_0x0129
            if (r5 == 0) goto L_0x00d7
            r3 = 40
            r14.insert(r1, r3)
            goto L_0x0129
        L_0x00d7:
            if (r3 == 0) goto L_0x0126
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            int r1 = r14.length()
            if (r1 != 0) goto L_0x00e6
            r1 = 1
            goto L_0x00e7
        L_0x00e6:
            r1 = 0
        L_0x00e7:
            if (r1 != 0) goto L_0x011e
            int r1 = kotlin.text.CharsKt__CharKt.getLastIndex(r14)
            char r1 = r14.charAt(r1)
            r3 = 32
            if (r1 != r3) goto L_0x00f7
            r1 = 1
            goto L_0x00f8
        L_0x00f7:
            r1 = 0
        L_0x00f8:
            boolean r3 = kotlin._Assertions.ENABLED
            if (r3 == 0) goto L_0x0107
            if (r1 == 0) goto L_0x00ff
            goto L_0x0107
        L_0x00ff:
            java.lang.AssertionError r14 = new java.lang.AssertionError
            java.lang.String r15 = "Assertion failed"
            r14.<init>(r15)
            throw r14
        L_0x0107:
            int r1 = kotlin.text.CharsKt__CharKt.getLastIndex(r14)
            int r1 = r1 - r0
            char r1 = r14.charAt(r1)
            r3 = 41
            if (r1 == r3) goto L_0x0126
            int r1 = kotlin.text.CharsKt__CharKt.getLastIndex(r14)
            java.lang.String r3 = "()"
            r14.insert(r1, r3)
            goto L_0x0126
        L_0x011e:
            java.util.NoSuchElementException r14 = new java.util.NoSuchElementException
            java.lang.String r15 = "Char sequence is empty."
            r14.<init>(r15)
            throw r14
        L_0x0126:
            r14.append(r9)
        L_0x0129:
            java.lang.String r1 = "suspend"
            r13.renderModifier(r14, r5, r1)
            java.lang.String r1 = ")"
            if (r7 == 0) goto L_0x016a
            boolean r3 = r13.shouldRenderAsPrettyFunctionType(r7)
            if (r3 == 0) goto L_0x013f
            boolean r3 = r7.isMarkedNullable()
            if (r3 == 0) goto L_0x0155
        L_0x013f:
            boolean r3 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isSuspendFunctionType(r7)
            if (r3 != 0) goto L_0x0152
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r3 = r7.getAnnotations()
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0150
            goto L_0x0152
        L_0x0150:
            r3 = 0
            goto L_0x0153
        L_0x0152:
            r3 = 1
        L_0x0153:
            if (r3 == 0) goto L_0x0157
        L_0x0155:
            r3 = 1
            goto L_0x0158
        L_0x0157:
            r3 = 0
        L_0x0158:
            if (r3 == 0) goto L_0x015d
            r14.append(r9)
        L_0x015d:
            r13.renderNormalizedType(r14, r7)
            if (r3 == 0) goto L_0x0165
            r14.append(r1)
        L_0x0165:
            java.lang.String r3 = "."
            r14.append(r3)
        L_0x016a:
            r14.append(r9)
            java.util.List r3 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getValueParameterTypesFromFunctionType(r15)
            java.util.Iterator r3 = r3.iterator()
            r5 = 0
        L_0x0176:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x01c8
            int r7 = r5 + 1
            java.lang.Object r9 = r3.next()
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r9 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r9
            if (r5 <= 0) goto L_0x018b
            java.lang.String r5 = ", "
            r14.append(r5)
        L_0x018b:
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r5 = r13.options
            kotlin.properties.ReadWriteProperty r10 = r5.parameterNamesInFunctionalTypes$delegate
            kotlin.reflect.KProperty<java.lang.Object>[] r11 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.$$delegatedProperties
            r12 = 43
            r11 = r11[r12]
            java.lang.Object r5 = r10.getValue(r5, r11)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x01b0
            kotlin.reflect.jvm.internal.impl.types.KotlinType r5 = r9.getType()
            java.lang.String r10 = "typeProjection.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r10)
            kotlin.reflect.jvm.internal.impl.name.Name r5 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(r5)
            goto L_0x01b1
        L_0x01b0:
            r5 = r4
        L_0x01b1:
            if (r5 == 0) goto L_0x01bf
            java.lang.String r5 = r13.renderName(r5, r2)
            r14.append(r5)
            java.lang.String r5 = ": "
            r14.append(r5)
        L_0x01bf:
            java.lang.String r5 = r13.renderTypeProjection(r9)
            r14.append(r5)
            r5 = r7
            goto L_0x0176
        L_0x01c8:
            java.lang.String r2 = ") "
            r14.append(r2)
            kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat r2 = r13.getTextFormat()
            int r2 = r2.ordinal()
            if (r2 == 0) goto L_0x01e2
            if (r2 != r0) goto L_0x01dc
            java.lang.String r0 = "&rarr;"
            goto L_0x01ec
        L_0x01dc:
            kotlin.NoWhenBranchMatchedException r14 = new kotlin.NoWhenBranchMatchedException
            r14.<init>()
            throw r14
        L_0x01e2:
            kotlin.reflect.jvm.internal.impl.renderer.RenderingFormat r0 = r13.getTextFormat()
            java.lang.String r2 = "->"
            java.lang.String r0 = r0.escape(r2)
        L_0x01ec:
            r14.append(r0)
            java.lang.String r0 = " "
            r14.append(r0)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r15 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.getReturnTypeFromFunctionType(r15)
            r13.renderNormalizedType(r14, r15)
            if (r8 == 0) goto L_0x0200
            r14.append(r1)
        L_0x0200:
            if (r6 == 0) goto L_0x020f
            java.lang.String r15 = "?"
            r14.append(r15)
            goto L_0x020f
        L_0x0208:
            r13.renderDefaultType(r14, r15)
            goto L_0x020f
        L_0x020c:
            r14.append(r1)
        L_0x020f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderNormalizedTypeAsIs(java.lang.StringBuilder, kotlin.reflect.jvm.internal.impl.types.KotlinType):void");
    }

    public final void renderOverride(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (getModifiers().contains(DescriptorRendererModifier.OVERRIDE) && (!callableMemberDescriptor.getOverriddenDescriptors().isEmpty())) {
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
            if (((OverrideRenderingPolicy) descriptorRendererOptionsImpl.overrideRenderingPolicy$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[25])) != OverrideRenderingPolicy.RENDER_OPEN) {
                renderModifier(sb, true, "override");
                if (getVerbose()) {
                    sb.append("/*");
                    sb.append(callableMemberDescriptor.getOverriddenDescriptors().size());
                    sb.append("*/ ");
                }
            }
        }
    }

    public final void renderPackageHeader(FqName fqName, String str, StringBuilder sb) {
        sb.append(renderKeyword(str));
        FqNameUnsafe unsafe = fqName.toUnsafe();
        Intrinsics.checkNotNullExpressionValue(unsafe, "fqName.toUnsafe()");
        String renderFqName = renderFqName(unsafe);
        if (renderFqName.length() > 0) {
            sb.append(CMap.SPACE);
            sb.append(renderFqName);
        }
    }

    public final void renderPossiblyInnerType(StringBuilder sb, PossiblyInnerType possiblyInnerType) {
        StringBuilder sb2;
        PossiblyInnerType possiblyInnerType2 = possiblyInnerType.outerType;
        if (possiblyInnerType2 == null) {
            sb2 = null;
        } else {
            renderPossiblyInnerType(sb, possiblyInnerType2);
            sb.append('.');
            Name name = possiblyInnerType.classifierDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(renderName(name, false));
            sb2 = sb;
        }
        if (sb2 == null) {
            TypeConstructor typeConstructor = possiblyInnerType.classifierDescriptor.getTypeConstructor();
            Intrinsics.checkNotNullExpressionValue(typeConstructor, "possiblyInnerType.classifierDescriptor.typeConstructor");
            sb.append(renderTypeConstructor(typeConstructor));
        }
        sb.append(renderTypeArguments(possiblyInnerType.arguments));
    }

    public final void renderReceiver(CallableDescriptor callableDescriptor, StringBuilder sb) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        if (extensionReceiverParameter != null) {
            renderAnnotations(sb, extensionReceiverParameter, AnnotationUseSiteTarget.RECEIVER);
            KotlinType type = extensionReceiverParameter.getType();
            Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
            String renderType = renderType(type);
            if (shouldRenderAsPrettyFunctionType(type) && !TypeUtils.isNullableType(type)) {
                renderType = '(' + renderType + ')';
            }
            sb.append(renderType);
            sb.append(".");
        }
    }

    public final void renderReceiverAfterName(CallableDescriptor callableDescriptor, StringBuilder sb) {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        if (((Boolean) descriptorRendererOptionsImpl.receiverAfterName$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[29])).booleanValue()) {
            ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
            if (extensionReceiverParameter != null) {
                sb.append(" on ");
                KotlinType type = extensionReceiverParameter.getType();
                Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
                sb.append(renderType(type));
            }
        }
    }

    public final void renderSpaceIfNeeded(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    public String renderType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        StringBuilder sb = new StringBuilder();
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        renderNormalizedType(sb, (KotlinType) ((Function1) descriptorRendererOptionsImpl.typeNormalizer$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[22])).invoke(kotlinType));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public String renderTypeArguments(List<? extends TypeProjection> list) {
        Intrinsics.checkNotNullParameter(list, "typeArguments");
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lt());
        appendTypeProjections(sb, list);
        sb.append(gt());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public String renderTypeConstructor(TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        boolean z = true;
        if (!(declarationDescriptor instanceof TypeParameterDescriptor ? true : declarationDescriptor instanceof ClassDescriptor)) {
            z = declarationDescriptor instanceof TypeAliasDescriptor;
        }
        if (z) {
            Intrinsics.checkNotNullParameter(declarationDescriptor, "klass");
            if (ErrorUtils.isError(declarationDescriptor)) {
                return declarationDescriptor.getTypeConstructor().toString();
            }
            return getClassifierNamePolicy().renderClassifier(declarationDescriptor, this);
        } else if (declarationDescriptor == null) {
            return typeConstructor.toString();
        } else {
            throw new IllegalStateException(Intrinsics.stringPlus("Unexpected classifier: ", declarationDescriptor.getClass()).toString());
        }
    }

    public final void renderTypeParameter(TypeParameterDescriptor typeParameterDescriptor, StringBuilder sb, boolean z) {
        if (z) {
            sb.append(lt());
        }
        if (getVerbose()) {
            sb.append("/*");
            sb.append(typeParameterDescriptor.getIndex());
            sb.append("*/ ");
        }
        renderModifier(sb, typeParameterDescriptor.isReified(), "reified");
        String label = typeParameterDescriptor.getVariance().getLabel();
        boolean z2 = true;
        renderModifier(sb, label.length() > 0, label);
        renderAnnotations(sb, typeParameterDescriptor, null);
        renderName(typeParameterDescriptor, sb, z);
        int size = typeParameterDescriptor.getUpperBounds().size();
        if ((size > 1 && !z) || size == 1) {
            KotlinType next = typeParameterDescriptor.getUpperBounds().iterator().next();
            if (next == null) {
                KotlinBuiltIns.$$$reportNull$$$0(140);
                throw null;
            } else if (!KotlinBuiltIns.isNullableAny(next)) {
                sb.append(" : ");
                Intrinsics.checkNotNullExpressionValue(next, "upperBound");
                sb.append(renderType(next));
            }
        } else if (z) {
            for (KotlinType next2 : typeParameterDescriptor.getUpperBounds()) {
                if (next2 == null) {
                    KotlinBuiltIns.$$$reportNull$$$0(140);
                    throw null;
                } else if (!KotlinBuiltIns.isNullableAny(next2)) {
                    if (z2) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    Intrinsics.checkNotNullExpressionValue(next2, "upperBound");
                    sb.append(renderType(next2));
                    z2 = false;
                }
            }
        }
        if (z) {
            sb.append(gt());
        }
    }

    public final void renderTypeParameterList(StringBuilder sb, List<? extends TypeParameterDescriptor> list) {
        Iterator<? extends TypeParameterDescriptor> it = list.iterator();
        while (it.hasNext()) {
            renderTypeParameter((TypeParameterDescriptor) it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    public final void renderTypeParameters(List<? extends TypeParameterDescriptor> list, StringBuilder sb, boolean z) {
        if (!getWithoutTypeParameters() && (!list.isEmpty())) {
            sb.append(lt());
            renderTypeParameterList(sb, list);
            sb.append(gt());
            if (z) {
                sb.append(CMap.SPACE);
            }
        }
    }

    public String renderTypeProjection(TypeProjection typeProjection) {
        Intrinsics.checkNotNullParameter(typeProjection, "typeProjection");
        StringBuilder sb = new StringBuilder();
        appendTypeProjections(sb, TweetUtils.listOf(typeProjection));
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final void renderValVarPrefix(VariableDescriptor variableDescriptor, StringBuilder sb, boolean z) {
        if (z || !(variableDescriptor instanceof ValueParameterDescriptor)) {
            sb.append(renderKeyword(variableDescriptor.isVar() ? "var" : "val"));
            sb.append(CMap.SPACE);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void renderValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r9, boolean r10, java.lang.StringBuilder r11, boolean r12) {
        /*
            r8 = this;
            if (r12 == 0) goto L_0x0011
            java.lang.String r0 = "value-parameter"
            java.lang.String r0 = r8.renderKeyword(r0)
            r11.append(r0)
            java.lang.String r0 = " "
            r11.append(r0)
        L_0x0011:
            boolean r0 = r8.getVerbose()
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "/*"
            r11.append(r0)
            int r0 = r9.getIndex()
            r11.append(r0)
            java.lang.String r0 = "*/ "
            r11.append(r0)
        L_0x0028:
            r0 = 0
            r8.renderAnnotations(r11, r9, r0)
            boolean r1 = r9.isCrossinline()
            java.lang.String r2 = "crossinline"
            r8.renderModifier(r11, r1, r2)
            boolean r1 = r9.isNoinline()
            java.lang.String r2 = "noinline"
            r8.renderModifier(r11, r1, r2)
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r1 = r8.options
            kotlin.properties.ReadWriteProperty r2 = r1.renderPrimaryConstructorParametersAsProperties$delegate
            kotlin.reflect.KProperty<java.lang.Object>[] r3 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.$$delegatedProperties
            r4 = 16
            r3 = r3[r4]
            java.lang.Object r1 = r2.getValue(r1, r3)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0077
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r1 = r9.getContainingDeclaration()
            boolean r4 = r1 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor
            if (r4 == 0) goto L_0x0061
            kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor) r1
            goto L_0x0062
        L_0x0061:
            r1 = r0
        L_0x0062:
            if (r1 != 0) goto L_0x0065
            goto L_0x006d
        L_0x0065:
            boolean r0 = r1.isPrimary()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x006d:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x0077
            r0 = 1
            goto L_0x0078
        L_0x0077:
            r0 = 0
        L_0x0078:
            if (r0 == 0) goto L_0x0093
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r1 = r8.options
            kotlin.properties.ReadWriteProperty r4 = r1.actualPropertiesInPrimaryConstructor$delegate
            kotlin.reflect.KProperty<java.lang.Object>[] r5 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.$$delegatedProperties
            r6 = 17
            r5 = r5[r6]
            java.lang.Object r1 = r4.getValue(r1, r5)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            java.lang.String r4 = "actual"
            r8.renderModifier(r11, r1, r4)
        L_0x0093:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = r9.getType()
            java.lang.String r4 = "variable.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = r9.getVarargElementType()
            if (r4 != 0) goto L_0x00a5
            r5 = r1
            goto L_0x00a6
        L_0x00a5:
            r5 = r4
        L_0x00a6:
            if (r4 == 0) goto L_0x00aa
            r6 = 1
            goto L_0x00ab
        L_0x00aa:
            r6 = 0
        L_0x00ab:
            java.lang.String r7 = "vararg"
            r8.renderModifier(r11, r6, r7)
            if (r0 != 0) goto L_0x00bb
            if (r12 == 0) goto L_0x00be
            boolean r6 = r8.getStartFromName()
            if (r6 != 0) goto L_0x00be
        L_0x00bb:
            r8.renderValVarPrefix(r9, r11, r0)
        L_0x00be:
            if (r10 == 0) goto L_0x00c8
            r8.renderName(r9, r11, r12)
            java.lang.String r10 = ": "
            r11.append(r10)
        L_0x00c8:
            java.lang.String r10 = r8.renderType(r5)
            r11.append(r10)
            r8.renderInitializer(r9, r11)
            boolean r10 = r8.getVerbose()
            if (r10 == 0) goto L_0x00eb
            if (r4 == 0) goto L_0x00eb
            java.lang.String r10 = " /*"
            r11.append(r10)
            java.lang.String r10 = r8.renderType(r1)
            r11.append(r10)
            java.lang.String r10 = "*/"
            r11.append(r10)
        L_0x00eb:
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r10 = r8.options
            kotlin.properties.ReadWriteProperty r12 = r10.defaultParameterValueRenderer$delegate
            kotlin.reflect.KProperty<java.lang.Object>[] r0 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.$$delegatedProperties
            r1 = 23
            r0 = r0[r1]
            java.lang.Object r10 = r12.getValue(r10, r0)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            if (r10 == 0) goto L_0x010f
            boolean r10 = r8.getDebugMode()
            if (r10 == 0) goto L_0x0108
            boolean r10 = r9.declaresDefaultValue()
            goto L_0x010c
        L_0x0108:
            boolean r10 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.declaresOrInheritsDefaultValue(r9)
        L_0x010c:
            if (r10 == 0) goto L_0x010f
            r2 = 1
        L_0x010f:
            if (r2 == 0) goto L_0x012f
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r10 = r8.options
            kotlin.properties.ReadWriteProperty r12 = r10.defaultParameterValueRenderer$delegate
            kotlin.reflect.KProperty<java.lang.Object>[] r0 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.$$delegatedProperties
            r0 = r0[r1]
            java.lang.Object r10 = r12.getValue(r10, r0)
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.lang.Object r9 = r10.invoke(r9)
            java.lang.String r10 = " = "
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r9)
            r11.append(r9)
        L_0x012f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderValueParameter(kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor, boolean, java.lang.StringBuilder, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0024, code lost:
        if (r8 == false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void renderValueParameters(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor> r7, boolean r8, java.lang.StringBuilder r9) {
        /*
            r6 = this;
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl r0 = r6.options
            kotlin.properties.ReadWriteProperty r1 = r0.parameterNameRenderingPolicy$delegate
            kotlin.reflect.KProperty<java.lang.Object>[] r2 = kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.$$delegatedProperties
            r3 = 28
            r2 = r2[r3]
            java.lang.Object r0 = r1.getValue(r0, r2)
            kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy r0 = (kotlin.reflect.jvm.internal.impl.renderer.ParameterNameRenderingPolicy) r0
            int r0 = r0.ordinal()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0028
            if (r0 == r1) goto L_0x0024
            r8 = 2
            if (r0 != r8) goto L_0x001e
            goto L_0x0027
        L_0x001e:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L_0x0024:
            if (r8 != 0) goto L_0x0027
            goto L_0x0028
        L_0x0027:
            r1 = 0
        L_0x0028:
            int r8 = r7.size()
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler r0 = r6.getValueParametersHandler()
            r0.appendBeforeValueParameters(r8, r9)
            java.util.Iterator r7 = r7.iterator()
            r0 = 0
        L_0x0038:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x0059
            int r3 = r0 + 1
            java.lang.Object r4 = r7.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r4
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler r5 = r6.getValueParametersHandler()
            r5.appendBeforeValueParameter(r4, r0, r8, r9)
            r6.renderValueParameter(r4, r1, r9, r2)
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler r5 = r6.getValueParametersHandler()
            r5.appendAfterValueParameter(r4, r0, r8, r9)
            r0 = r3
            goto L_0x0038
        L_0x0059:
            kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$ValueParametersHandler r7 = r6.getValueParametersHandler()
            r7.appendAfterValueParameters(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderValueParameters(java.util.Collection, boolean, java.lang.StringBuilder):void");
    }

    public final boolean renderVisibility(DescriptorVisibility descriptorVisibility, StringBuilder sb) {
        if (!getModifiers().contains(DescriptorRendererModifier.VISIBILITY)) {
            return false;
        }
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        if (((Boolean) descriptorRendererOptionsImpl.normalizedVisibilities$delegate.getValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[12])).booleanValue()) {
            descriptorVisibility = descriptorVisibility.normalize();
        }
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl2 = this.options;
        if (!((Boolean) descriptorRendererOptionsImpl2.renderDefaultVisibility$delegate.getValue(descriptorRendererOptionsImpl2, DescriptorRendererOptionsImpl.$$delegatedProperties[13])).booleanValue() && Intrinsics.areEqual(descriptorVisibility, DescriptorVisibilities.DEFAULT_VISIBILITY)) {
            return false;
        }
        sb.append(renderKeyword(((DelegatedDescriptorVisibility) descriptorVisibility).delegate.getInternalDisplayName()));
        sb.append(CMap.SPACE);
        return true;
    }

    public final void renderWhereSuffix(List<? extends TypeParameterDescriptor> list, StringBuilder sb) {
        if (!getWithoutTypeParameters()) {
            ArrayList arrayList = new ArrayList(0);
            for (TypeParameterDescriptor typeParameterDescriptor : list) {
                List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
                for (T t : ArraysKt___ArraysJvmKt.drop(upperBounds, 1)) {
                    StringBuilder sb2 = new StringBuilder();
                    Name name = typeParameterDescriptor.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "typeParameter.name");
                    sb2.append(renderName(name, false));
                    sb2.append(" : ");
                    Intrinsics.checkNotNullExpressionValue(t, "it");
                    sb2.append(renderType(t));
                    arrayList.add(sb2.toString());
                }
            }
            if (!arrayList.isEmpty()) {
                sb.append(CMap.SPACE);
                sb.append(renderKeyword("where"));
                sb.append(CMap.SPACE);
                ArraysKt___ArraysJvmKt.joinTo$default(arrayList, sb, ", ", null, null, 0, null, null, 124);
            }
        }
    }

    public final String replacePrefixes(String str, String str2, String str3, String str4, String str5) {
        if (CharsKt__CharKt.startsWith$default(str, str2, false, 2) && CharsKt__CharKt.startsWith$default(str3, str4, false, 2)) {
            String substring = str.substring(str2.length());
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            String substring2 = str3.substring(str4.length());
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
            String stringPlus = Intrinsics.stringPlus(str5, substring);
            if (Intrinsics.areEqual(substring, substring2)) {
                return stringPlus;
            }
            if (differsOnlyInNullability(substring, substring2)) {
                return Intrinsics.stringPlus(stringPlus, "!");
            }
        }
        return null;
    }

    public void setAnnotationArgumentsRenderingPolicy(AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        Intrinsics.checkNotNullParameter(annotationArgumentsRenderingPolicy, "<set-?>");
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        if (descriptorRendererOptionsImpl != null) {
            Intrinsics.checkNotNullParameter(annotationArgumentsRenderingPolicy, "<set-?>");
            descriptorRendererOptionsImpl.annotationArgumentsRenderingPolicy$delegate.setValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[37], annotationArgumentsRenderingPolicy);
            return;
        }
        throw null;
    }

    public void setClassifierNamePolicy(ClassifierNamePolicy classifierNamePolicy) {
        Intrinsics.checkNotNullParameter(classifierNamePolicy, "<set-?>");
        this.options.setClassifierNamePolicy(classifierNamePolicy);
    }

    public void setDebugMode(boolean z) {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        descriptorRendererOptionsImpl.debugMode$delegate.setValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[6], Boolean.valueOf(z));
    }

    public void setExcludedTypeAnnotationClasses(Set<FqName> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        if (descriptorRendererOptionsImpl != null) {
            Intrinsics.checkNotNullParameter(set, "<set-?>");
            descriptorRendererOptionsImpl.excludedTypeAnnotationClasses$delegate.setValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[35], set);
            return;
        }
        throw null;
    }

    public void setModifiers(Set<? extends DescriptorRendererModifier> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.options.setModifiers(set);
    }

    public void setParameterNameRenderingPolicy(ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        Intrinsics.checkNotNullParameter(parameterNameRenderingPolicy, "<set-?>");
        this.options.setParameterNameRenderingPolicy(parameterNameRenderingPolicy);
    }

    public void setReceiverAfterName(boolean z) {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        descriptorRendererOptionsImpl.receiverAfterName$delegate.setValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[29], Boolean.valueOf(z));
    }

    public void setRenderCompanionObjectName(boolean z) {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        descriptorRendererOptionsImpl.renderCompanionObjectName$delegate.setValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[30], Boolean.valueOf(z));
    }

    public void setStartFromName(boolean z) {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        descriptorRendererOptionsImpl.startFromName$delegate.setValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[4], Boolean.valueOf(z));
    }

    public void setTextFormat(RenderingFormat renderingFormat) {
        Intrinsics.checkNotNullParameter(renderingFormat, "<set-?>");
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        if (descriptorRendererOptionsImpl != null) {
            Intrinsics.checkNotNullParameter(renderingFormat, "<set-?>");
            descriptorRendererOptionsImpl.textFormat$delegate.setValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[27], renderingFormat);
            return;
        }
        throw null;
    }

    public void setWithDefinedIn(boolean z) {
        this.options.setWithDefinedIn(z);
    }

    public void setWithoutSuperTypes(boolean z) {
        this.options.setWithoutSuperTypes(z);
    }

    public void setWithoutTypeParameters(boolean z) {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = this.options;
        descriptorRendererOptionsImpl.withoutTypeParameters$delegate.setValue(descriptorRendererOptionsImpl, DescriptorRendererOptionsImpl.$$delegatedProperties[20], Boolean.valueOf(z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean shouldRenderAsPrettyFunctionType(kotlin.reflect.jvm.internal.impl.types.KotlinType r4) {
        /*
            r3 = this;
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.isBuiltinFunctionalType(r4)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0032
            java.util.List r4 = r4.getArguments()
            boolean r0 = r4 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0018
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x0018
        L_0x0016:
            r4 = 1
            goto L_0x002f
        L_0x0018:
            java.util.Iterator r4 = r4.iterator()
        L_0x001c:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0016
            java.lang.Object r0 = r4.next()
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = (kotlin.reflect.jvm.internal.impl.types.TypeProjection) r0
            boolean r0 = r0.isStarProjection()
            if (r0 == 0) goto L_0x001c
            r4 = 0
        L_0x002f:
            if (r4 == 0) goto L_0x0032
            r1 = 1
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.shouldRenderAsPrettyFunctionType(kotlin.reflect.jvm.internal.impl.types.KotlinType):boolean");
    }

    public final void renderName(DeclarationDescriptor declarationDescriptor, StringBuilder sb, boolean z) {
        Name name = declarationDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "descriptor.name");
        sb.append(renderName(name, z));
    }
}
