package kotlin.reflect.jvm.internal.impl.load.java.components;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* compiled from: JavaAnnotationMapper.kt */
public final class JavaTargetAnnotationDescriptor$allValueArguments$2 extends Lambda implements Function0<Map<Name, ? extends ConstantValue<? extends Object>>> {
    public final /* synthetic */ JavaTargetAnnotationDescriptor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JavaTargetAnnotationDescriptor$allValueArguments$2(JavaTargetAnnotationDescriptor javaTargetAnnotationDescriptor) {
        // this.this$0 = javaTargetAnnotationDescriptor;
        super(0);
    }

    public Object invoke() {
        Object obj;
        JavaAnnotationArgument javaAnnotationArgument = this.this$0.firstArgument;
        Map map = null;
        if (javaAnnotationArgument instanceof JavaArrayAnnotationArgument) {
            obj = JavaAnnotationTargetMapper.INSTANCE.mapJavaTargetArguments$descriptors_jvm(((JavaArrayAnnotationArgument) javaAnnotationArgument).getElements());
        } else {
            obj = javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument ? JavaAnnotationTargetMapper.INSTANCE.mapJavaTargetArguments$descriptors_jvm(TweetUtils.listOf(javaAnnotationArgument)) : null;
        }
        if (obj != null) {
            JavaAnnotationMapper javaAnnotationMapper = JavaAnnotationMapper.INSTANCE;
            map = TweetUtils.mapOf(new Pair(JavaAnnotationMapper.TARGET_ANNOTATION_ALLOWED_TARGETS, obj));
        }
        return map != null ? map : ArraysKt___ArraysJvmKt.emptyMap();
    }
}
