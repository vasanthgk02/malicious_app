package kotlin.reflect.jvm.internal.impl.types;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.DefaultBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorSimpleFunctionDescriptorImpl;
import org.apache.fontbox.cmap.CMapParser;

public class ErrorUtils {
    public static final ErrorClassDescriptor ERROR_CLASS = new ErrorClassDescriptor(Name.special("<ERROR CLASS>"));
    public static final ModuleDescriptor ERROR_MODULE = new ModuleDescriptor() {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            Throwable th;
            if (!(i == 1 || i == 4 || i == 5 || i == 6 || i == 13 || i == 14)) {
                switch (i) {
                    case 8:
                    case 9:
                    case 10:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            }
            str = "@NotNull method %s.%s must not return null";
            if (!(i == 1 || i == 4 || i == 5 || i == 6 || i == 13 || i == 14)) {
                switch (i) {
                    case 8:
                    case 9:
                    case 10:
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
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 13:
                case 14:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                    break;
                case 2:
                case 7:
                    objArr[0] = "fqName";
                    break;
                case 3:
                    objArr[0] = "nameFilter";
                    break;
                case 11:
                    objArr[0] = "visitor";
                    break;
                case 12:
                    objArr[0] = "targetModule";
                    break;
                default:
                    objArr[0] = "capability";
                    break;
            }
            if (i == 1) {
                objArr[1] = "getAnnotations";
            } else if (i == 4) {
                objArr[1] = "getSubPackagesOf";
            } else if (i == 5) {
                objArr[1] = "getName";
            } else if (i == 6) {
                objArr[1] = "getStableName";
            } else if (i == 13) {
                objArr[1] = "getOriginal";
            } else if (i != 14) {
                switch (i) {
                    case 8:
                        objArr[1] = "getAllDependencyModules";
                        break;
                    case 9:
                        objArr[1] = "getExpectedByModules";
                        break;
                    case 10:
                        objArr[1] = "getAllExpectedByModules";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                        break;
                }
            } else {
                objArr[1] = "getBuiltIns";
            }
            switch (i) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 13:
                case 14:
                    break;
                case 2:
                case 3:
                    objArr[2] = "getSubPackagesOf";
                    break;
                case 7:
                    objArr[2] = "getPackage";
                    break;
                case 11:
                    objArr[2] = "accept";
                    break;
                case 12:
                    objArr[2] = "shouldSeeInternalsOf";
                    break;
                default:
                    objArr[2] = "getCapability";
                    break;
            }
            String format = String.format(str, objArr);
            if (!(i == 1 || i == 4 || i == 5 || i == 6 || i == 13 || i == 14)) {
                switch (i) {
                    case 8:
                    case 9:
                    case 10:
                        break;
                    default:
                        th = new IllegalArgumentException(format);
                        break;
                }
            }
            th = new IllegalStateException(format);
            throw th;
        }

        public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d2) {
            if (declarationDescriptorVisitor != null) {
                return null;
            }
            $$$reportNull$$$0(11);
            throw null;
        }

        public Annotations getAnnotations() {
            if (Annotations.Companion != null) {
                Annotations annotations = Companion.EMPTY;
                if (annotations != null) {
                    return annotations;
                }
                $$$reportNull$$$0(1);
                throw null;
            }
            throw null;
        }

        public KotlinBuiltIns getBuiltIns() {
            DefaultBuiltIns defaultBuiltIns = DefaultBuiltIns.Instance;
            if (defaultBuiltIns != null) {
                return defaultBuiltIns;
            }
            $$$reportNull$$$0(14);
            throw null;
        }

        public <T> T getCapability(ModuleCapability<T> moduleCapability) {
            if (moduleCapability != null) {
                return null;
            }
            $$$reportNull$$$0(0);
            throw null;
        }

        public DeclarationDescriptor getContainingDeclaration() {
            return null;
        }

        public List<ModuleDescriptor> getExpectedByModules() {
            return EmptyList.INSTANCE;
        }

        public Name getName() {
            return Name.special("<ERROR MODULE>");
        }

        public DeclarationDescriptor getOriginal() {
            return this;
        }

        public PackageViewDescriptor getPackage(FqName fqName) {
            if (fqName == null) {
                $$$reportNull$$$0(7);
                throw null;
            }
            throw new IllegalStateException("Should not be called!");
        }

        public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
            if (fqName != null) {
                return EmptyList.INSTANCE;
            }
            $$$reportNull$$$0(2);
            throw null;
        }

        public boolean shouldSeeInternalsOf(ModuleDescriptor moduleDescriptor) {
            if (moduleDescriptor != null) {
                return false;
            }
            $$$reportNull$$$0(12);
            throw null;
        }
    };
    public static final PropertyDescriptor ERROR_PROPERTY;
    public static final Set<PropertyDescriptor> ERROR_PROPERTY_GROUP;
    public static final KotlinType ERROR_PROPERTY_TYPE = createErrorType("<ERROR PROPERTY TYPE>");
    public static final SimpleType ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES = createErrorType("<LOOP IN SUPERTYPES>");

    public static class ErrorClassDescriptor extends ClassDescriptorImpl {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = (i == 2 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 2 || i == 5 || i == 8) ? 2 : 3)];
            switch (i) {
                case 1:
                    objArr[0] = "substitutor";
                    break;
                case 2:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                    break;
                case 3:
                    objArr[0] = "typeArguments";
                    break;
                case 4:
                case 7:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                case 6:
                    objArr[0] = "typeSubstitution";
                    break;
                default:
                    objArr[0] = "name";
                    break;
            }
            if (i == 2) {
                objArr[1] = "substitute";
            } else if (i == 5 || i == 8) {
                objArr[1] = "getMemberScope";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
            }
            switch (i) {
                case 1:
                    objArr[2] = "substitute";
                    break;
                case 2:
                case 5:
                case 8:
                    break;
                case 3:
                case 4:
                case 6:
                case 7:
                    objArr[2] = "getMemberScope";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            throw ((i == 2 || i == 5 || i == 8) ? new IllegalStateException(format) : new IllegalArgumentException(format));
        }

        public ErrorClassDescriptor(Name name) {
            super(ErrorUtils.getErrorModule(), name, Modality.OPEN, ClassKind.CLASS, Collections.emptyList(), SourceElement.NO_SOURCE, false, LockBasedStorageManager.NO_LOCKS);
            if (Annotations.Companion != null) {
                Annotations annotations = Companion.EMPTY;
                SourceElement sourceElement = SourceElement.NO_SOURCE;
                if (annotations != null) {
                    ClassConstructorDescriptorImpl classConstructorDescriptorImpl = new ClassConstructorDescriptorImpl(this, null, annotations, true, Kind.DECLARATION, sourceElement);
                    classConstructorDescriptorImpl.initialize(Collections.emptyList(), DescriptorVisibilities.INTERNAL);
                    MemberScope createErrorScope = ErrorUtils.createErrorScope(getName().asString());
                    classConstructorDescriptorImpl.setReturnType(new ErrorType(ErrorUtils.createErrorTypeConstructorWithCustomDebugName("<ERROR>", this), createErrorScope));
                    initialize(createErrorScope, Collections.singleton(classConstructorDescriptorImpl), classConstructorDescriptorImpl);
                    return;
                }
                ClassConstructorDescriptorImpl.$$$reportNull$$$0(5);
                throw null;
            }
            throw null;
        }

        public MemberScope getMemberScope(TypeSubstitution typeSubstitution, KotlinTypeRefiner kotlinTypeRefiner) {
            if (typeSubstitution == null) {
                $$$reportNull$$$0(6);
                throw null;
            } else if (kotlinTypeRefiner != null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Error scope for class ");
                outline73.append(getName());
                outline73.append(" with arguments: ");
                outline73.append(typeSubstitution);
                return ErrorUtils.createErrorScope(outline73.toString());
            } else {
                $$$reportNull$$$0(7);
                throw null;
            }
        }

        public ClassDescriptor substitute(TypeSubstitutor typeSubstitutor) {
            if (typeSubstitutor != null) {
                return this;
            }
            $$$reportNull$$$0(1);
            throw null;
        }

        /* renamed from: substitute  reason: collision with other method in class */
        public DeclarationDescriptorNonRoot m978substitute(TypeSubstitutor typeSubstitutor) {
            if (typeSubstitutor != null) {
                return this;
            }
            $$$reportNull$$$0(1);
            throw null;
        }

        public String toString() {
            return getName().asString();
        }
    }

    public static class ErrorScope implements MemberScope {
        public final String debugMessage;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str;
            int i2;
            Throwable th;
            if (!(i == 7 || i == 18)) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            }
            str = "@NotNull method %s.%s must not return null";
            if (!(i == 7 || i == 18)) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
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
                case 3:
                case 5:
                case 8:
                case 14:
                case 19:
                    objArr[0] = "name";
                    break;
                case 2:
                case 4:
                case 6:
                case 9:
                case 15:
                    objArr[0] = "location";
                    break;
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                    break;
                case 16:
                    objArr[0] = "kindFilter";
                    break;
                case 17:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "debugMessage";
                    break;
            }
            if (i == 7) {
                objArr[1] = "getContributedVariables";
            } else if (i != 18) {
                switch (i) {
                    case 10:
                        objArr[1] = "getContributedFunctions";
                        break;
                    case 11:
                        objArr[1] = "getFunctionNames";
                        break;
                    case 12:
                        objArr[1] = "getVariableNames";
                        break;
                    case 13:
                        objArr[1] = "getClassifierNames";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                        break;
                }
            } else {
                objArr[1] = "getContributedDescriptors";
            }
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    break;
                case 8:
                case 9:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 14:
                case 15:
                    objArr[2] = "recordLookup";
                    break;
                case 16:
                case 17:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 19:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 20:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (!(i == 7 || i == 18)) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        th = new IllegalArgumentException(format);
                        break;
                }
            }
            th = new IllegalStateException(format);
            throw th;
        }

        public ErrorScope(String str, AnonymousClass1 r2) {
            if (str != null) {
                this.debugMessage = str;
            } else {
                $$$reportNull$$$0(0);
                throw null;
            }
        }

        public Set<Name> getClassifierNames() {
            Set<Name> emptySet = Collections.emptySet();
            if (emptySet != null) {
                return emptySet;
            }
            $$$reportNull$$$0(13);
            throw null;
        }

        public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(1);
                throw null;
            } else if (lookupLocation != null) {
                String asString = name.asString();
                if (asString != null) {
                    return new ErrorClassDescriptor(Name.special("<ERROR CLASS: " + asString + ">"));
                }
                ErrorUtils.$$$reportNull$$$0(1);
                throw null;
            } else {
                $$$reportNull$$$0(2);
                throw null;
            }
        }

        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            if (descriptorKindFilter == null) {
                $$$reportNull$$$0(16);
                throw null;
            } else if (function1 != null) {
                List emptyList = Collections.emptyList();
                if (emptyList != null) {
                    return emptyList;
                }
                $$$reportNull$$$0(18);
                throw null;
            } else {
                $$$reportNull$$$0(17);
                throw null;
            }
        }

        public Collection getContributedFunctions(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(8);
                throw null;
            } else if (lookupLocation != null) {
                ErrorSimpleFunctionDescriptorImpl errorSimpleFunctionDescriptorImpl = new ErrorSimpleFunctionDescriptorImpl(ErrorUtils.ERROR_CLASS, this);
                errorSimpleFunctionDescriptorImpl.initialize((ReceiverParameterDescriptor) null, (ReceiverParameterDescriptor) null, Collections.emptyList(), Collections.emptyList(), (KotlinType) ErrorUtils.createErrorType("<ERROR FUNCTION RETURN TYPE>"), Modality.OPEN, DescriptorVisibilities.PUBLIC);
                Set singleton = Collections.singleton(errorSimpleFunctionDescriptorImpl);
                if (singleton != null) {
                    return singleton;
                }
                $$$reportNull$$$0(10);
                throw null;
            } else {
                $$$reportNull$$$0(9);
                throw null;
            }
        }

        public Collection getContributedVariables(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(5);
                throw null;
            } else if (lookupLocation != null) {
                Set<PropertyDescriptor> set = ErrorUtils.ERROR_PROPERTY_GROUP;
                if (set != null) {
                    return set;
                }
                $$$reportNull$$$0(7);
                throw null;
            } else {
                $$$reportNull$$$0(6);
                throw null;
            }
        }

        public Set<Name> getFunctionNames() {
            Set<Name> emptySet = Collections.emptySet();
            if (emptySet != null) {
                return emptySet;
            }
            $$$reportNull$$$0(11);
            throw null;
        }

        public Set<Name> getVariableNames() {
            Set<Name> emptySet = Collections.emptySet();
            if (emptySet != null) {
                return emptySet;
            }
            $$$reportNull$$$0(12);
            throw null;
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("ErrorScope{"), this.debugMessage, '}');
        }
    }

    public static class ThrowingScope implements MemberScope {
        public final String debugMessage;

        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                    objArr[0] = "name";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 12:
                    objArr[0] = "location";
                    break;
                case 9:
                    objArr[0] = "kindFilter";
                    break;
                case 10:
                    objArr[0] = "nameFilter";
                    break;
                case 14:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "message";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 8:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 9:
                case 10:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 11:
                case 12:
                    objArr[2] = "recordLookup";
                    break;
                case 13:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 14:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public ThrowingScope(String str, AnonymousClass1 r2) {
            if (str != null) {
                this.debugMessage = str;
            } else {
                $$$reportNull$$$0(0);
                throw null;
            }
        }

        public Set<Name> getClassifierNames() {
            throw new IllegalStateException();
        }

        public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(1);
                throw null;
            } else if (lookupLocation == null) {
                $$$reportNull$$$0(2);
                throw null;
            } else {
                throw new IllegalStateException(this.debugMessage + ", required name: " + name);
            }
        }

        public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
            if (descriptorKindFilter == null) {
                $$$reportNull$$$0(9);
                throw null;
            } else if (function1 == null) {
                $$$reportNull$$$0(10);
                throw null;
            } else {
                throw new IllegalStateException(this.debugMessage);
            }
        }

        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(7);
                throw null;
            } else if (lookupLocation == null) {
                $$$reportNull$$$0(8);
                throw null;
            } else {
                throw new IllegalStateException(this.debugMessage + ", required name: " + name);
            }
        }

        public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
            if (name == null) {
                $$$reportNull$$$0(5);
                throw null;
            } else if (lookupLocation == null) {
                $$$reportNull$$$0(6);
                throw null;
            } else {
                throw new IllegalStateException(this.debugMessage + ", required name: " + name);
            }
        }

        public Set<Name> getFunctionNames() {
            throw new IllegalStateException();
        }

        public Set<Name> getVariableNames() {
            throw new IllegalStateException();
        }

        public String toString() {
            return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline73("ThrowingScope{"), this.debugMessage, '}');
        }
    }

    public static class UninferredParameterTypeConstructor implements TypeConstructor {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[((i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? 2 : 3)];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
                    break;
                case 5:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            if (i == 1) {
                objArr[1] = "getTypeParameterDescriptor";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getSupertypes";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i != 6) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
            } else {
                objArr[1] = "refine";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    break;
                case 5:
                    objArr[2] = "refine";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            throw ((i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? new IllegalStateException(format) : new IllegalArgumentException(format));
        }

        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = DescriptorUtilsKt.getBuiltIns(null);
            if (builtIns != null) {
                return builtIns;
            }
            $$$reportNull$$$0(4);
            throw null;
        }

        public ClassifierDescriptor getDeclarationDescriptor() {
            throw null;
        }

        public List<TypeParameterDescriptor> getParameters() {
            throw null;
        }

        public Collection<KotlinType> getSupertypes() {
            throw null;
        }

        public boolean isDenotable() {
            throw null;
        }
    }

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 4 || i == 6 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 4 || i == 6 || i == 19) ? 2 : 3)];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = "function";
                break;
        }
        if (i == 4) {
            objArr[1] = "createErrorProperty";
        } else if (i == 6) {
            objArr[1] = "createErrorFunction";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        } else {
            objArr[1] = "getErrorModule";
        }
        switch (i) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String format = String.format(str, objArr);
        throw ((i == 4 || i == 6 || i == 19) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    static {
        ErrorClassDescriptor errorClassDescriptor = ERROR_CLASS;
        if (Annotations.Companion != null) {
            Annotations annotations = Companion.EMPTY;
            Modality modality = Modality.OPEN;
            DescriptorVisibility descriptorVisibility = DescriptorVisibilities.PUBLIC;
            Name special = Name.special("<ERROR PROPERTY>");
            Kind kind = Kind.DECLARATION;
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            if (errorClassDescriptor == null) {
                PropertyDescriptorImpl.$$$reportNull$$$0(7);
                throw null;
            } else if (annotations == null) {
                PropertyDescriptorImpl.$$$reportNull$$$0(8);
                throw null;
            } else if (modality == null) {
                PropertyDescriptorImpl.$$$reportNull$$$0(9);
                throw null;
            } else if (descriptorVisibility == null) {
                PropertyDescriptorImpl.$$$reportNull$$$0(10);
                throw null;
            } else if (kind != null) {
                PropertyDescriptorImpl propertyDescriptorImpl = r1;
                PropertyDescriptorImpl propertyDescriptorImpl2 = new PropertyDescriptorImpl(errorClassDescriptor, null, annotations, modality, descriptorVisibility, true, special, kind, sourceElement, false, false, false, false, false, false);
                PropertyDescriptorImpl propertyDescriptorImpl3 = propertyDescriptorImpl;
                propertyDescriptorImpl3.setType(ERROR_PROPERTY_TYPE, Collections.emptyList(), null, null);
                ERROR_PROPERTY = propertyDescriptorImpl3;
                ERROR_PROPERTY_GROUP = Collections.singleton(propertyDescriptorImpl3);
            } else {
                PropertyDescriptorImpl.$$$reportNull$$$0(12);
                throw null;
            }
        } else {
            throw null;
        }
    }

    public static MemberScope createErrorScope(String str) {
        if (str != null) {
            return createErrorScope(str, false);
        }
        $$$reportNull$$$0(2);
        throw null;
    }

    public static SimpleType createErrorType(String str) {
        if (str != null) {
            return createErrorTypeWithArguments(str, Collections.emptyList());
        }
        $$$reportNull$$$0(7);
        throw null;
    }

    public static TypeConstructor createErrorTypeConstructor(String str) {
        if (str != null) {
            return createErrorTypeConstructorWithCustomDebugName(GeneratedOutlineSupport.outline52("[ERROR : ", str, CMapParser.MARK_END_OF_ARRAY), ERROR_CLASS);
        }
        $$$reportNull$$$0(15);
        throw null;
    }

    public static TypeConstructor createErrorTypeConstructorWithCustomDebugName(final String str, final ErrorClassDescriptor errorClassDescriptor) {
        if (str == null) {
            $$$reportNull$$$0(17);
            throw null;
        } else if (errorClassDescriptor != null) {
            return new TypeConstructor() {
                public static /* synthetic */ void $$$reportNull$$$0(int i) {
                    String str = i != 3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    Object[] objArr = new Object[(i != 3 ? 2 : 3)];
                    if (i != 3) {
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
                    } else {
                        objArr[0] = "kotlinTypeRefiner";
                    }
                    if (i == 1) {
                        objArr[1] = "getSupertypes";
                    } else if (i == 2) {
                        objArr[1] = "getBuiltIns";
                    } else if (i == 3) {
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
                    } else if (i != 4) {
                        objArr[1] = "getParameters";
                    } else {
                        objArr[1] = "refine";
                    }
                    if (i == 3) {
                        objArr[2] = "refine";
                    }
                    String format = String.format(str, objArr);
                    throw (i != 3 ? new IllegalStateException(format) : new IllegalArgumentException(format));
                }

                public KotlinBuiltIns getBuiltIns() {
                    DefaultBuiltIns defaultBuiltIns = DefaultBuiltIns.Instance;
                    if (defaultBuiltIns != null) {
                        return defaultBuiltIns;
                    }
                    $$$reportNull$$$0(2);
                    throw null;
                }

                public ClassifierDescriptor getDeclarationDescriptor() {
                    return errorClassDescriptor;
                }

                public List<TypeParameterDescriptor> getParameters() {
                    return EmptyList.INSTANCE;
                }

                public Collection<KotlinType> getSupertypes() {
                    return EmptyList.INSTANCE;
                }

                public boolean isDenotable() {
                    return false;
                }

                public String toString() {
                    return str;
                }
            };
        } else {
            $$$reportNull$$$0(18);
            throw null;
        }
    }

    public static SimpleType createErrorTypeWithArguments(String str, List<TypeProjection> list) {
        if (str == null) {
            $$$reportNull$$$0(11);
            throw null;
        } else if (list != null) {
            TypeConstructor createErrorTypeConstructor = createErrorTypeConstructor(str);
            MemberScope createErrorScope = createErrorScope(str);
            Intrinsics.checkNotNullParameter(createErrorTypeConstructor, "constructor");
            Intrinsics.checkNotNullParameter(createErrorScope, "memberScope");
            Intrinsics.checkNotNullParameter(list, "arguments");
            ErrorType errorType = new ErrorType(createErrorTypeConstructor, createErrorScope, list, false, null, 16);
            return errorType;
        } else {
            $$$reportNull$$$0(12);
            throw null;
        }
    }

    public static SimpleType createErrorTypeWithCustomConstructor(String str, TypeConstructor typeConstructor) {
        if (str == null) {
            $$$reportNull$$$0(9);
            throw null;
        } else if (typeConstructor != null) {
            return new ErrorType(typeConstructor, createErrorScope(str));
        } else {
            $$$reportNull$$$0(10);
            throw null;
        }
    }

    public static ModuleDescriptor getErrorModule() {
        ModuleDescriptor moduleDescriptor = ERROR_MODULE;
        if (moduleDescriptor != null) {
            return moduleDescriptor;
        }
        $$$reportNull$$$0(19);
        throw null;
    }

    public static boolean isError(DeclarationDescriptor declarationDescriptor) {
        boolean z = false;
        if (declarationDescriptor == null) {
            return false;
        }
        if ((declarationDescriptor instanceof ErrorClassDescriptor) || (declarationDescriptor.getContainingDeclaration() instanceof ErrorClassDescriptor) || declarationDescriptor == ERROR_MODULE) {
            z = true;
        }
        return z;
    }

    public static MemberScope createErrorScope(String str, boolean z) {
        if (str == null) {
            $$$reportNull$$$0(3);
            throw null;
        } else if (z) {
            return new ThrowingScope(str, null);
        } else {
            return new ErrorScope(str, null);
        }
    }
}
