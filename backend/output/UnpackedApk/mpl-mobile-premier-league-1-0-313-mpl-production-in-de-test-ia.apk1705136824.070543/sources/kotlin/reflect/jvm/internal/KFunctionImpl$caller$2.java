package kotlin.reflect.jvm.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.FakeJavaAnnotationConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.JavaMethod;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinConstructor;
import kotlin.reflect.jvm.internal.JvmFunctionSignature.KotlinFunction;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundInstance;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundJvmStaticInObject;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.Instance;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.JvmStaticInObject;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KFunctionImpl.kt */
public final class KFunctionImpl$caller$2 extends Lambda implements Function0<Caller<? extends Member>> {
    public final /* synthetic */ KFunctionImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KFunctionImpl$caller$2(KFunctionImpl kFunctionImpl) {
        // this.this$0 = kFunctionImpl;
        super(0);
    }

    public Object invoke() {
        Object obj;
        Caller caller;
        Caller boundJvmStaticInObject;
        RuntimeTypeMapper runtimeTypeMapper = RuntimeTypeMapper.INSTANCE;
        JvmFunctionSignature mapSignature = RuntimeTypeMapper.mapSignature(this.this$0.getDescriptor());
        if (mapSignature instanceof KotlinConstructor) {
            if (this.this$0.isAnnotationConstructor()) {
                Class<?> jClass = this.this$0.container.getJClass();
                List<KParameter> parameters = this.this$0.getParameters();
                ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(parameters, 10));
                for (KParameter name : parameters) {
                    String name2 = name.getName();
                    Intrinsics.checkNotNull(name2);
                    arrayList.add(name2);
                }
                AnnotationConstructorCaller annotationConstructorCaller = new AnnotationConstructorCaller(jClass, arrayList, CallMode.POSITIONAL_CALL, Origin.KOTLIN, null, 16);
                return annotationConstructorCaller;
            }
            KDeclarationContainerImpl kDeclarationContainerImpl = this.this$0.container;
            String str = ((KotlinConstructor) mapSignature).signature.desc;
            if (kDeclarationContainerImpl != null) {
                Intrinsics.checkNotNullParameter(str, "desc");
                obj = kDeclarationContainerImpl.tryGetConstructor(kDeclarationContainerImpl.getJClass(), kDeclarationContainerImpl.loadParameterTypes(str));
            } else {
                throw null;
            }
        } else if (mapSignature instanceof KotlinFunction) {
            KDeclarationContainerImpl kDeclarationContainerImpl2 = this.this$0.container;
            Method method = ((KotlinFunction) mapSignature).signature;
            obj = kDeclarationContainerImpl2.findMethodBySignature(method.name, method.desc);
        } else if (mapSignature instanceof JavaMethod) {
            obj = ((JavaMethod) mapSignature).method;
        } else if (mapSignature instanceof JavaConstructor) {
            obj = ((JavaConstructor) mapSignature).constructor;
        } else if (mapSignature instanceof FakeJavaAnnotationConstructor) {
            List<java.lang.reflect.Method> list = ((FakeJavaAnnotationConstructor) mapSignature).methods;
            Class<?> jClass2 = this.this$0.container.getJClass();
            ArrayList arrayList2 = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
            for (java.lang.reflect.Method method2 : list) {
                Intrinsics.checkNotNullExpressionValue(method2, "it");
                arrayList2.add(method2.getName());
            }
            AnnotationConstructorCaller annotationConstructorCaller2 = new AnnotationConstructorCaller(jClass2, arrayList2, CallMode.POSITIONAL_CALL, Origin.JAVA, list);
            return annotationConstructorCaller2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (obj instanceof Constructor) {
            KFunctionImpl kFunctionImpl = this.this$0;
            caller = KFunctionImpl.access$createConstructorCaller(kFunctionImpl, (Constructor) obj, kFunctionImpl.getDescriptor());
        } else if (obj instanceof java.lang.reflect.Method) {
            java.lang.reflect.Method method3 = (java.lang.reflect.Method) obj;
            if (!Modifier.isStatic(method3.getModifiers())) {
                KFunctionImpl kFunctionImpl2 = this.this$0;
                if (kFunctionImpl2.isBound()) {
                    caller = new BoundInstance(method3, kFunctionImpl2.getBoundReceiver());
                } else {
                    boundJvmStaticInObject = new Instance(method3);
                }
            } else if (this.this$0.getDescriptor().getAnnotations().findAnnotation(UtilKt.JVM_STATIC) != null) {
                boundJvmStaticInObject = this.this$0.isBound() ? new BoundJvmStaticInObject(method3) : new JvmStaticInObject(method3);
            } else {
                caller = KFunctionImpl.access$createStaticMethodCaller(this.this$0, method3);
            }
            caller = boundJvmStaticInObject;
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Could not compute caller for function: ");
            outline73.append(this.this$0.getDescriptor());
            outline73.append(" (member = ");
            outline73.append(obj);
            outline73.append(')');
            throw new KotlinReflectionInternalError(outline73.toString());
        }
        return TweetUtils.createInlineClassAwareCallerIfNeeded(caller, this.this$0.getDescriptor(), false);
    }
}
