package kotlin.reflect.jvm.internal.impl.renderer;

import com.mpl.androidapp.utils.Constant;
import java.lang.reflect.Field;
import kotlin._Assertions;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt__CharKt;

/* compiled from: DescriptorRendererImpl.kt */
public final class DescriptorRendererImpl$functionTypeAnnotationsRenderer$2 extends Lambda implements Function0<DescriptorRendererImpl> {
    public final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(DescriptorRendererImpl descriptorRendererImpl) {
        // this.this$0 = descriptorRendererImpl;
        super(0);
    }

    public Object invoke() {
        DescriptorRendererImpl descriptorRendererImpl = this.this$0;
        AnonymousClass1 r2 = AnonymousClass1.INSTANCE;
        if (descriptorRendererImpl != null) {
            Intrinsics.checkNotNullParameter(r2, "changeOptions");
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = descriptorRendererImpl.options;
            if (descriptorRendererOptionsImpl != null) {
                Class<DescriptorRendererOptionsImpl> cls = DescriptorRendererOptionsImpl.class;
                DescriptorRendererOptionsImpl descriptorRendererOptionsImpl2 = new DescriptorRendererOptionsImpl();
                Field[] declaredFields = cls.getDeclaredFields();
                Intrinsics.checkNotNullExpressionValue(declaredFields, "this::class.java.declaredFields");
                int length = declaredFields.length;
                int i = 0;
                while (i < length) {
                    Field field = declaredFields[i];
                    i++;
                    if ((field.getModifiers() & 8) == 0) {
                        field.setAccessible(true);
                        Object obj = field.get(descriptorRendererOptionsImpl);
                        ObservableProperty observableProperty = obj instanceof ObservableProperty ? (ObservableProperty) obj : null;
                        if (observableProperty == null) {
                            continue;
                        } else {
                            String name = field.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "field.name");
                            boolean z = !CharsKt__CharKt.startsWith$default(name, (String) "is", false, 2);
                            if (!_Assertions.ENABLED || z) {
                                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
                                String name2 = field.getName();
                                String name3 = field.getName();
                                Intrinsics.checkNotNullExpressionValue(name3, "field.name");
                                Object value = observableProperty.getValue(descriptorRendererOptionsImpl, new PropertyReference1Impl(orCreateKotlinClass, name2, Intrinsics.stringPlus(Constant.GET, CharsKt__CharKt.capitalize(name3))));
                                field.set(descriptorRendererOptionsImpl2, new DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(value, value, descriptorRendererOptionsImpl2));
                            } else {
                                throw new AssertionError("Fields named is* are not supported here yet");
                            }
                        }
                    }
                }
                r2.invoke(descriptorRendererOptionsImpl2);
                descriptorRendererOptionsImpl2.lock();
                return new DescriptorRendererImpl(descriptorRendererOptionsImpl2);
            }
            throw null;
        }
        throw null;
    }
}
