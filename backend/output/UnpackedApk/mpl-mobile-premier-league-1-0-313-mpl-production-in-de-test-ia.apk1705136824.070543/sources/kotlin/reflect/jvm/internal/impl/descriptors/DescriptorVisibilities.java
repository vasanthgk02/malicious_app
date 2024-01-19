package kotlin.reflect.jvm.internal.impl.descriptors;

import com.google.gson.internal.bind.TypeAdapters.AnonymousClass27;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Inherited;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Internal;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.InvisibleFake;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Local;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.PrivateToThis;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Protected;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Public;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Unknown;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper.EMPTY;

public class DescriptorVisibilities {
    public static final ReceiverValue ALWAYS_SUITABLE_RECEIVER = new ReceiverValue() {
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    public static final DescriptorVisibility DEFAULT_VISIBILITY = PUBLIC;
    @Deprecated
    public static final ReceiverValue FALSE_IF_PROTECTED = new ReceiverValue() {
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    public static final DescriptorVisibility INHERITED = new DelegatedDescriptorVisibility(Inherited.INSTANCE) {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
                throw null;
            } else if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
                throw null;
            } else {
                throw new IllegalStateException("Visibility is unknown yet");
            }
        }
    };
    public static final DescriptorVisibility INTERNAL = new DelegatedDescriptorVisibility(Internal.INSTANCE) {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
                throw null;
            } else if (declarationDescriptor != null) {
                if (!DescriptorUtils.getContainingModule(declarationDescriptor).shouldSeeInternalsOf(DescriptorUtils.getContainingModule(declarationDescriptorWithVisibility))) {
                    return false;
                }
                return DescriptorVisibilities.MODULE_VISIBILITY_HELPER.isInFriendModule(declarationDescriptorWithVisibility, declarationDescriptor);
            } else {
                $$$reportNull$$$0(1);
                throw null;
            }
        }
    };
    public static final DescriptorVisibility INVISIBLE_FAKE = new DelegatedDescriptorVisibility(InvisibleFake.INSTANCE) {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
                throw null;
            } else if (declarationDescriptor != null) {
                return false;
            } else {
                $$$reportNull$$$0(1);
                throw null;
            }
        }
    };
    public static final ReceiverValue IRRELEVANT_RECEIVER = new ReceiverValue() {
        public KotlinType getType() {
            throw new IllegalStateException("This method should not be called");
        }
    };
    public static final DescriptorVisibility LOCAL = new DelegatedDescriptorVisibility(Local.INSTANCE) {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
                throw null;
            } else if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
                throw null;
            } else {
                throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
            }
        }
    };
    public static final ModuleVisibilityHelper MODULE_VISIBILITY_HELPER;
    public static final DescriptorVisibility PRIVATE = new DelegatedDescriptorVisibility(Private.INSTANCE) {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "what";
            } else if (i != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i == 1 || i == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, code=kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, for r5v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isVisible(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue r4, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r5, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6) {
            /*
                r3 = this;
                r4 = 0
                r0 = 1
                if (r5 == 0) goto L_0x00a5
                if (r6 == 0) goto L_0x00a0
                boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isTopLevelDeclaration(r5)
                r2 = 0
                if (r1 == 0) goto L_0x0025
                if (r6 == 0) goto L_0x0021
                kotlin.reflect.jvm.internal.impl.descriptors.SourceFile r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getContainingSourceFile(r6)
                kotlin.reflect.jvm.internal.impl.descriptors.SourceFile r1 = kotlin.reflect.jvm.internal.impl.descriptors.SourceFile.NO_SOURCE_FILE
                if (r4 == r1) goto L_0x0019
                r4 = 1
                goto L_0x001a
            L_0x0019:
                r4 = 0
            L_0x001a:
                if (r4 == 0) goto L_0x0025
                boolean r4 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.inSameFile(r5, r6)
                return r4
            L_0x0021:
                $$$reportNull$$$0(r2)
                throw r4
            L_0x0025:
                boolean r4 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
                if (r4 == 0) goto L_0x0051
                r4 = r5
                kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) r4
                kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters r4 = r4.getContainingDeclaration()
                boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isSealedClass(r4)
                if (r1 == 0) goto L_0x0051
                boolean r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isTopLevelDeclaration(r4)
                if (r4 == 0) goto L_0x0051
                boolean r4 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
                if (r4 == 0) goto L_0x0051
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = r6.getContainingDeclaration()
                boolean r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isTopLevelDeclaration(r4)
                if (r4 == 0) goto L_0x0051
                boolean r4 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.inSameFile(r5, r6)
                if (r4 == 0) goto L_0x0051
                return r0
            L_0x0051:
                if (r5 == 0) goto L_0x0065
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r5 = r5.getContainingDeclaration()
                boolean r4 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
                if (r4 == 0) goto L_0x0061
                boolean r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isCompanionObject(r5)
                if (r4 == 0) goto L_0x0065
            L_0x0061:
                boolean r4 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
                if (r4 == 0) goto L_0x0051
            L_0x0065:
                if (r5 != 0) goto L_0x0068
                return r2
            L_0x0068:
                if (r6 == 0) goto L_0x009f
                if (r5 != r6) goto L_0x006d
                return r0
            L_0x006d:
                boolean r4 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
                if (r4 == 0) goto L_0x009a
                boolean r4 = r5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
                if (r4 == 0) goto L_0x0098
                r4 = r5
                kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r4
                kotlin.reflect.jvm.internal.impl.name.FqName r4 = r4.getFqName()
                r1 = r6
                kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor) r1
                kotlin.reflect.jvm.internal.impl.name.FqName r1 = r1.getFqName()
                boolean r4 = r4.equals(r1)
                if (r4 == 0) goto L_0x0098
                kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getContainingModule(r6)
                kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r5 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getContainingModule(r5)
                boolean r4 = r4.equals(r5)
                if (r4 == 0) goto L_0x0098
                goto L_0x0099
            L_0x0098:
                r0 = 0
            L_0x0099:
                return r0
            L_0x009a:
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6 = r6.getContainingDeclaration()
                goto L_0x0068
            L_0x009f:
                return r2
            L_0x00a0:
                r5 = 2
                $$$reportNull$$$0(r5)
                throw r4
            L_0x00a5:
                $$$reportNull$$$0(r0)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.AnonymousClass1.isVisible(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor):boolean");
        }
    };
    public static final DescriptorVisibility PRIVATE_TO_THIS = new DelegatedDescriptorVisibility(PrivateToThis.INSTANCE) {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
                throw null;
            } else if (declarationDescriptor != null) {
                if (DescriptorVisibilities.PRIVATE.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor)) {
                    if (receiverValue == DescriptorVisibilities.ALWAYS_SUITABLE_RECEIVER) {
                        return true;
                    }
                    if (receiverValue == DescriptorVisibilities.IRRELEVANT_RECEIVER) {
                        return false;
                    }
                    DeclarationDescriptor parentOfType = DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, ClassDescriptor.class);
                    if (parentOfType != null && (receiverValue instanceof ThisClassReceiver)) {
                        return ((ThisClassReceiver) receiverValue).getClassDescriptor().getOriginal().equals(parentOfType.getOriginal());
                    }
                }
                return false;
            } else {
                $$$reportNull$$$0(1);
                throw null;
            }
        }
    };
    public static final DescriptorVisibility PROTECTED = new DelegatedDescriptorVisibility(Protected.INSTANCE) {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "from";
            } else if (i == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i == 2 || i == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0079, code lost:
            if (com.twitter.sdk.android.tweetui.TweetUtils.isDynamic(r0) == false) goto L_0x007c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isVisible(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue r7, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility r8, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r9) {
            /*
                r6 = this;
                java.lang.Class<kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor> r0 = kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor.class
                r1 = 0
                r2 = 0
                if (r8 == 0) goto L_0x0091
                r3 = 1
                if (r9 == 0) goto L_0x008d
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(r8, r0)
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r9 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(r9, r0, r2)
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r9
                if (r9 != 0) goto L_0x0018
                return r2
            L_0x0018:
                if (r4 == 0) goto L_0x002f
                boolean r5 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isCompanionObject(r4)
                if (r5 == 0) goto L_0x002f
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(r4, r0)
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
                if (r4 == 0) goto L_0x002f
                boolean r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isSubclass(r9, r4)
                if (r4 == 0) goto L_0x002f
                return r3
            L_0x002f:
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility r4 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(r8)
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.getParentOfType(r4, r0)
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
                if (r0 != 0) goto L_0x003c
                return r2
            L_0x003c:
                boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isSubclass(r9, r0)
                if (r0 == 0) goto L_0x0084
                if (r4 == 0) goto L_0x007f
                kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue r0 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.FALSE_IF_PROTECTED
                if (r7 != r0) goto L_0x0049
                goto L_0x007c
            L_0x0049:
                boolean r0 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
                if (r0 != 0) goto L_0x004e
                goto L_0x007b
            L_0x004e:
                boolean r0 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
                if (r0 == 0) goto L_0x0053
                goto L_0x007b
            L_0x0053:
                kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue r0 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.ALWAYS_SUITABLE_RECEIVER
                if (r7 != r0) goto L_0x0058
                goto L_0x007b
            L_0x0058:
                kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue r0 = kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.IRRELEVANT_RECEIVER
                if (r7 == r0) goto L_0x007c
                if (r7 != 0) goto L_0x005f
                goto L_0x007c
            L_0x005f:
                boolean r0 = r7 instanceof kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue
                if (r0 == 0) goto L_0x006b
                r0 = r7
                kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue r0 = (kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue) r0
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r0.getThisType()
                goto L_0x006f
            L_0x006b:
                kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r7.getType()
            L_0x006f:
                boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils.isSubtypeOfClass(r0, r9)
                if (r1 != 0) goto L_0x007b
                boolean r0 = com.twitter.sdk.android.tweetui.TweetUtils.isDynamic(r0)
                if (r0 == 0) goto L_0x007c
            L_0x007b:
                r2 = 1
            L_0x007c:
                if (r2 == 0) goto L_0x0084
                return r3
            L_0x007f:
                r7 = 2
                $$$reportNull$$$0(r7)
                throw r1
            L_0x0084:
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r9 = r9.getContainingDeclaration()
                boolean r7 = r6.isVisible(r7, r8, r9)
                return r7
            L_0x008d:
                $$$reportNull$$$0(r3)
                throw r1
            L_0x0091:
                $$$reportNull$$$0(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities.AnonymousClass3.isVisible(kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor):boolean");
        }
    };
    public static final DescriptorVisibility PUBLIC = new DelegatedDescriptorVisibility(Public.INSTANCE) {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
                throw null;
            } else if (declarationDescriptor != null) {
                return true;
            } else {
                $$$reportNull$$$0(1);
                throw null;
            }
        }
    };
    public static final DescriptorVisibility UNKNOWN = new DelegatedDescriptorVisibility(Unknown.INSTANCE) {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
                throw null;
            } else if (declarationDescriptor != null) {
                return false;
            } else {
                $$$reportNull$$$0(1);
                throw null;
            }
        }
    };
    public static final Map<Visibility, DescriptorVisibility> visibilitiesMapping = new HashMap();

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = i != 16 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i != 16 ? 3 : 2)];
        if (!(i == 1 || i == 3 || i == 5 || i == 7)) {
            switch (i) {
                case 9:
                    break;
                case 10:
                case 12:
                    objArr[0] = "first";
                    break;
                case 11:
                case 13:
                    objArr[0] = AnonymousClass27.SECOND;
                    break;
                case 14:
                case 15:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
        }
        objArr[0] = "from";
        if (i != 16) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities";
        } else {
            objArr[1] = "toDescriptorVisibility";
        }
        switch (i) {
            case 2:
            case 3:
                objArr[2] = "isVisibleIgnoringReceiver";
                break;
            case 4:
            case 5:
                objArr[2] = "isVisibleWithAnyReceiver";
                break;
            case 6:
            case 7:
                objArr[2] = "inSameFile";
                break;
            case 8:
            case 9:
                objArr[2] = "findInvisibleMember";
                break;
            case 10:
            case 11:
                objArr[2] = "compareLocal";
                break;
            case 12:
            case 13:
                objArr[2] = "compare";
                break;
            case 14:
                objArr[2] = "isPrivate";
                break;
            case 15:
                objArr[2] = "toDescriptorVisibility";
                break;
            case 16:
                break;
            default:
                objArr[2] = "isVisible";
                break;
        }
        String format = String.format(str, objArr);
        throw (i != 16 ? new IllegalArgumentException(format) : new IllegalStateException(format));
    }

    static {
        Class<ModuleVisibilityHelper> cls = ModuleVisibilityHelper.class;
        DescriptorVisibility descriptorVisibility = PRIVATE;
        Integer valueOf = Integer.valueOf(0);
        DescriptorVisibility descriptorVisibility2 = PRIVATE_TO_THIS;
        Integer valueOf2 = Integer.valueOf(1);
        Collections.unmodifiableSet(TweetUtils.setOf((T[]) new DescriptorVisibility[]{descriptorVisibility, descriptorVisibility2, INTERNAL, LOCAL}));
        HashMap newHashMapWithExpectedSize = TypeUtilsKt.newHashMapWithExpectedSize(4);
        newHashMapWithExpectedSize.put(PRIVATE_TO_THIS, valueOf);
        newHashMapWithExpectedSize.put(PRIVATE, valueOf);
        newHashMapWithExpectedSize.put(INTERNAL, valueOf2);
        newHashMapWithExpectedSize.put(PROTECTED, valueOf2);
        newHashMapWithExpectedSize.put(PUBLIC, Integer.valueOf(2));
        Collections.unmodifiableMap(newHashMapWithExpectedSize);
        Iterator<S> it = ServiceLoader.load(cls, cls.getClassLoader()).iterator();
        MODULE_VISIBILITY_HELPER = it.hasNext() ? (ModuleVisibilityHelper) it.next() : EMPTY.INSTANCE;
        recordVisibilityMapping(PRIVATE);
        recordVisibilityMapping(PRIVATE_TO_THIS);
        recordVisibilityMapping(PROTECTED);
        recordVisibilityMapping(INTERNAL);
        recordVisibilityMapping(PUBLIC);
        recordVisibilityMapping(LOCAL);
        recordVisibilityMapping(INHERITED);
        recordVisibilityMapping(INVISIBLE_FAKE);
        recordVisibilityMapping(UNKNOWN);
    }

    public static Integer compare(DescriptorVisibility descriptorVisibility, DescriptorVisibility descriptorVisibility2) {
        if (descriptorVisibility == null) {
            $$$reportNull$$$0(12);
            throw null;
        } else if (descriptorVisibility2 != null) {
            Intrinsics.checkNotNullParameter(descriptorVisibility2, "visibility");
            DelegatedDescriptorVisibility delegatedDescriptorVisibility = (DelegatedDescriptorVisibility) descriptorVisibility;
            DelegatedDescriptorVisibility delegatedDescriptorVisibility2 = (DelegatedDescriptorVisibility) descriptorVisibility2;
            Integer compareTo = delegatedDescriptorVisibility.delegate.compareTo(delegatedDescriptorVisibility2.delegate);
            if (compareTo != null) {
                return compareTo;
            }
            Intrinsics.checkNotNullParameter(descriptorVisibility, "visibility");
            Integer compareTo2 = delegatedDescriptorVisibility2.delegate.compareTo(delegatedDescriptorVisibility.delegate);
            if (compareTo2 != null) {
                return Integer.valueOf(-compareTo2.intValue());
            }
            return null;
        } else {
            $$$reportNull$$$0(13);
            throw null;
        }
    }

    public static DeclarationDescriptorWithVisibility findInvisibleMember(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(8);
            throw null;
        } else if (declarationDescriptor != null) {
            DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) declarationDescriptorWithVisibility.getOriginal();
            while (declarationDescriptorWithVisibility2 != null && declarationDescriptorWithVisibility2.getVisibility() != LOCAL) {
                if (!declarationDescriptorWithVisibility2.getVisibility().isVisible(receiverValue, declarationDescriptorWithVisibility2, declarationDescriptor)) {
                    return declarationDescriptorWithVisibility2;
                }
                declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility2, DeclarationDescriptorWithVisibility.class);
            }
            if (declarationDescriptorWithVisibility instanceof TypeAliasConstructorDescriptor) {
                DeclarationDescriptorWithVisibility findInvisibleMember = findInvisibleMember(receiverValue, ((TypeAliasConstructorDescriptor) declarationDescriptorWithVisibility).getUnderlyingConstructorDescriptor(), declarationDescriptor);
                if (findInvisibleMember != null) {
                    return findInvisibleMember;
                }
            }
            return null;
        } else {
            $$$reportNull$$$0(9);
            throw null;
        }
    }

    public static boolean inSameFile(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor != null) {
            SourceFile containingSourceFile = DescriptorUtils.getContainingSourceFile(declarationDescriptor2);
            if (containingSourceFile != SourceFile.NO_SOURCE_FILE) {
                return containingSourceFile.equals(DescriptorUtils.getContainingSourceFile(declarationDescriptor));
            }
            return false;
        }
        $$$reportNull$$$0(6);
        throw null;
    }

    public static boolean isPrivate(DescriptorVisibility descriptorVisibility) {
        if (descriptorVisibility != null) {
            return descriptorVisibility == PRIVATE || descriptorVisibility == PRIVATE_TO_THIS;
        }
        $$$reportNull$$$0(14);
        throw null;
    }

    public static boolean isVisibleIgnoringReceiver(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            return findInvisibleMember(ALWAYS_SUITABLE_RECEIVER, declarationDescriptorWithVisibility, declarationDescriptor) == null;
        }
        $$$reportNull$$$0(3);
        throw null;
    }

    public static void recordVisibilityMapping(DescriptorVisibility descriptorVisibility) {
        visibilitiesMapping.put(((DelegatedDescriptorVisibility) descriptorVisibility).delegate, descriptorVisibility);
    }

    public static DescriptorVisibility toDescriptorVisibility(Visibility visibility) {
        if (visibility != null) {
            DescriptorVisibility descriptorVisibility = visibilitiesMapping.get(visibility);
            if (descriptorVisibility != null) {
                return descriptorVisibility;
            }
            throw new IllegalArgumentException("Inapplicable visibility: " + visibility);
        }
        $$$reportNull$$$0(15);
        throw null;
    }
}
