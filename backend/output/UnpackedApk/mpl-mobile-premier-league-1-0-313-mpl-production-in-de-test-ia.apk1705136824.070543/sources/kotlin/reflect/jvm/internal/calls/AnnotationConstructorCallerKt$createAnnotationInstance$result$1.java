package kotlin.reflect.jvm.internal.calls;

import com.razorpay.AnalyticsConstants;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062,\u0010\u0007\u001a(\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\b0\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "T", "<anonymous parameter 0>", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
/* compiled from: AnnotationConstructorCaller.kt */
public final class AnnotationConstructorCallerKt$createAnnotationInstance$result$1 implements InvocationHandler {
    public final /* synthetic */ Class $annotationClass;
    public final /* synthetic */ AnnotationConstructorCallerKt$createAnnotationInstance$2 $equals$2;
    public final /* synthetic */ Lazy $hashCode;
    public final /* synthetic */ KProperty $hashCode$metadata;
    public final /* synthetic */ Lazy $toString;
    public final /* synthetic */ KProperty $toString$metadata = null;
    public final /* synthetic */ Map $values;

    public AnnotationConstructorCallerKt$createAnnotationInstance$result$1(Class cls, Lazy lazy, KProperty kProperty, Lazy lazy2, KProperty kProperty2, AnnotationConstructorCallerKt$createAnnotationInstance$2 annotationConstructorCallerKt$createAnnotationInstance$2, Map map) {
        this.$annotationClass = cls;
        this.$toString = lazy;
        this.$hashCode = lazy2;
        this.$hashCode$metadata = null;
        this.$equals$2 = annotationConstructorCallerKt$createAnnotationInstance$2;
        this.$values = map;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Intrinsics.checkNotNullExpressionValue(method, AnalyticsConstants.METHOD);
        String name = method.getName();
        if (name != null) {
            int hashCode = name.hashCode();
            if (hashCode != -1776922004) {
                if (hashCode != 147696667) {
                    if (hashCode == 1444986633 && name.equals("annotationType")) {
                        return this.$annotationClass;
                    }
                } else if (name.equals("hashCode")) {
                    return this.$hashCode.getValue();
                }
            } else if (name.equals("toString")) {
                return this.$toString.getValue();
            }
        }
        if (Intrinsics.areEqual(name, "equals") && objArr != null && objArr.length == 1) {
            return Boolean.valueOf(this.$equals$2.invoke(TweetUtils.single((T[]) objArr)));
        }
        if (this.$values.containsKey(name)) {
            return this.$values.get(name);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Method is not supported: ");
        sb.append(method);
        sb.append(" (args: ");
        if (objArr == null) {
            objArr = new Object[0];
        }
        sb.append(TweetUtils.toList(objArr));
        sb.append(')');
        throw new KotlinReflectionInternalError(sb.toString());
    }
}
