package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* compiled from: LazyJavaClassDescriptor.kt */
public final class LazyJavaClassDescriptor$declaredParameters$1 extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
    public final /* synthetic */ LazyJavaClassDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaClassDescriptor$declaredParameters$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        // this.this$0 = lazyJavaClassDescriptor;
        super(0);
    }

    public Object invoke() {
        List<JavaTypeParameter> typeParameters = this.this$0.jClass.getTypeParameters();
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.this$0;
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(typeParameters, 10));
        for (JavaTypeParameter javaTypeParameter : typeParameters) {
            TypeParameterDescriptor resolveTypeParameter = lazyJavaClassDescriptor.f5941c.typeParameterResolver.resolveTypeParameter(javaTypeParameter);
            if (resolveTypeParameter != null) {
                arrayList.add(resolveTypeParameter);
            } else {
                throw new AssertionError("Parameter " + javaTypeParameter + " surely belongs to class " + lazyJavaClassDescriptor.jClass + ", so it must be resolved");
            }
        }
        return arrayList;
    }
}
