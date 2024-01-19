package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder.Request;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.FindClassRequest;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.Found;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.NotFound;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder.Result.ClassFileContent;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.ClassKey;

/* compiled from: LazyJavaPackageScope.kt */
public final class LazyJavaPackageScope$classes$1 extends Lambda implements Function1<FindClassRequest, ClassDescriptor> {
    public final /* synthetic */ LazyJavaResolverContext $c;
    public final /* synthetic */ LazyJavaPackageScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaPackageScope$classes$1(LazyJavaPackageScope lazyJavaPackageScope, LazyJavaResolverContext lazyJavaResolverContext) {
        // this.this$0 = lazyJavaPackageScope;
        // this.$c = lazyJavaResolverContext;
        super(1);
    }

    public Object invoke(Object obj) {
        Result result;
        KotlinJvmBinaryClass kotlinJvmBinaryClass;
        ClassId classId;
        Object obj2;
        LightClassOriginKind lightClassOriginKind;
        FqName fqName;
        ClassDescriptor classDescriptor;
        FindClassRequest findClassRequest = (FindClassRequest) obj;
        Intrinsics.checkNotNullParameter(findClassRequest, "request");
        ClassId classId2 = new ClassId(this.this$0.ownerDescriptor.fqName, findClassRequest.name);
        JavaClass javaClass = findClassRequest.javaClass;
        if (javaClass != null) {
            result = this.$c.components.kotlinClassFinder.findKotlinClassOrContent(javaClass);
        } else {
            result = this.$c.components.kotlinClassFinder.findKotlinClassOrContent(classId2);
        }
        KotlinJvmBinaryClass kotlinJvmBinaryClass2 = null;
        if (result == null) {
            kotlinJvmBinaryClass = null;
        } else {
            kotlinJvmBinaryClass = result.toKotlinJvmBinaryClass();
        }
        if (kotlinJvmBinaryClass == null) {
            classId = null;
        } else {
            classId = kotlinJvmBinaryClass.getClassId();
        }
        if (classId != null && (classId.isNestedClass() || classId.local)) {
            return null;
        }
        LazyJavaPackageScope lazyJavaPackageScope = this.this$0;
        if (lazyJavaPackageScope != null) {
            if (kotlinJvmBinaryClass == null) {
                obj2 = NotFound.INSTANCE;
            } else if (kotlinJvmBinaryClass.getClassHeader().kind == Kind.CLASS) {
                DeserializedDescriptorResolver deserializedDescriptorResolver = lazyJavaPackageScope.f5943c.components.deserializedDescriptorResolver;
                if (deserializedDescriptorResolver != null) {
                    Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
                    ClassData readClassData$descriptors_jvm = deserializedDescriptorResolver.readClassData$descriptors_jvm(kotlinJvmBinaryClass);
                    if (readClassData$descriptors_jvm == null) {
                        classDescriptor = null;
                    } else {
                        ClassDeserializer classDeserializer = deserializedDescriptorResolver.getComponents().classDeserializer;
                        ClassId classId3 = kotlinJvmBinaryClass.getClassId();
                        if (classDeserializer != null) {
                            Intrinsics.checkNotNullParameter(classId3, "classId");
                            classDescriptor = (ClassDescriptor) classDeserializer.classes.invoke(new ClassKey(classId3, readClassData$descriptors_jvm));
                        } else {
                            throw null;
                        }
                    }
                    obj2 = classDescriptor != null ? new Found(classDescriptor) : NotFound.INSTANCE;
                } else {
                    throw null;
                }
            } else {
                obj2 = SyntheticClass.INSTANCE;
            }
            if (obj2 instanceof Found) {
                return ((Found) obj2).descriptor;
            }
            if (obj2 instanceof SyntheticClass) {
                return null;
            }
            if (obj2 instanceof NotFound) {
                JavaClass javaClass2 = findClassRequest.javaClass;
                if (javaClass2 == null) {
                    JavaClassFinder javaClassFinder = this.$c.components.finder;
                    if (result != null) {
                        if (!(result instanceof ClassFileContent)) {
                            result = null;
                        }
                        ClassFileContent classFileContent = (ClassFileContent) result;
                    }
                    javaClass2 = javaClassFinder.findClass(new Request(classId2, null, null, 4));
                }
                if (javaClass2 == null) {
                    lightClassOriginKind = null;
                } else {
                    lightClassOriginKind = javaClass2.getLightClassOriginKind();
                }
                if (lightClassOriginKind == LightClassOriginKind.BINARY) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Couldn't find kotlin binary class for light class created by kotlin binary file\nJavaClass: ");
                    sb.append(javaClass2);
                    sb.append("\nClassId: ");
                    sb.append(classId2);
                    sb.append("\nfindKotlinClass(JavaClass) = ");
                    KotlinClassFinder kotlinClassFinder = this.$c.components.kotlinClassFinder;
                    Intrinsics.checkNotNullParameter(kotlinClassFinder, "<this>");
                    Intrinsics.checkNotNullParameter(javaClass2, "javaClass");
                    Result findKotlinClassOrContent = kotlinClassFinder.findKotlinClassOrContent(javaClass2);
                    if (findKotlinClassOrContent != null) {
                        kotlinJvmBinaryClass2 = findKotlinClassOrContent.toKotlinJvmBinaryClass();
                    }
                    sb.append(kotlinJvmBinaryClass2);
                    sb.append("\nfindKotlinClass(ClassId) = ");
                    sb.append(TweetUtils.findKotlinClass(this.$c.components.kotlinClassFinder, classId2));
                    sb.append(10);
                    throw new IllegalStateException(sb.toString());
                }
                if (javaClass2 == null) {
                    fqName = null;
                } else {
                    fqName = javaClass2.getFqName();
                }
                if (fqName == null || fqName.isRoot() || !Intrinsics.areEqual(fqName.parent(), this.this$0.ownerDescriptor.fqName)) {
                    return null;
                }
                LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(this.$c, this.this$0.ownerDescriptor, javaClass2, null);
                this.$c.components.javaClassesTracker.reportClass(lazyJavaClassDescriptor);
                return lazyJavaClassDescriptor;
            }
            throw new NoWhenBranchMatchedException();
        }
        throw null;
    }
}
