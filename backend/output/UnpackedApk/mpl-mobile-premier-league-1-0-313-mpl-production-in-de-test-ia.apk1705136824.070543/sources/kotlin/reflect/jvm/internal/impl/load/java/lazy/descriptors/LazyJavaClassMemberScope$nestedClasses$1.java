package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder.Request;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;

/* compiled from: LazyJavaClassMemberScope.kt */
public final class LazyJavaClassMemberScope$nestedClasses$1 extends Lambda implements Function1<Name, ClassDescriptorBase> {
    public final /* synthetic */ LazyJavaResolverContext $c;
    public final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaClassMemberScope$nestedClasses$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        // this.this$0 = lazyJavaClassMemberScope;
        // this.$c = lazyJavaResolverContext;
        super(1);
    }

    public Object invoke(Object obj) {
        Name name = (Name) obj;
        Intrinsics.checkNotNullParameter(name, "name");
        if (!((Set) this.this$0.nestedClassIndex.invoke()).contains(name)) {
            JavaField javaField = (JavaField) ((Map) this.this$0.enumEntryIndex.invoke()).get(name);
            if (javaField == null) {
                return null;
            }
            NotNullLazyValue createLazyValue = this.$c.components.storageManager.createLazyValue(new LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(this.this$0));
            LazyJavaResolverContext lazyJavaResolverContext = this.$c;
            return EnumEntrySyntheticClassDescriptor.create(lazyJavaResolverContext.components.storageManager, this.this$0.ownerDescriptor, name, createLazyValue, TweetUtils.resolveAnnotations(lazyJavaResolverContext, javaField), this.$c.components.sourceElementFactory.source(javaField));
        }
        JavaClassFinder javaClassFinder = this.$c.components.finder;
        ClassId classId = DescriptorUtilsKt.getClassId(this.this$0.ownerDescriptor);
        Intrinsics.checkNotNull(classId);
        ClassId createNestedClassId = classId.createNestedClassId(name);
        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "ownerDescriptor.classId!!.createNestedClassId(name)");
        JavaClass findClass = javaClassFinder.findClass(new Request(createNestedClassId, null, this.this$0.jClass, 2));
        if (findClass == null) {
            return null;
        }
        LazyJavaResolverContext lazyJavaResolverContext2 = this.$c;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(lazyJavaResolverContext2, this.this$0.ownerDescriptor, findClass, null);
        lazyJavaResolverContext2.components.javaClassesTracker.reportClass(lazyJavaClassDescriptor);
        return lazyJavaClassDescriptor;
    }
}
