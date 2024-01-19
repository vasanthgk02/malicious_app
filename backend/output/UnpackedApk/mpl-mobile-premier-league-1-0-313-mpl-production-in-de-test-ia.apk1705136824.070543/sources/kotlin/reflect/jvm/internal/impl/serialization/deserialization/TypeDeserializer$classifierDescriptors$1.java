package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: TypeDeserializer.kt */
public final class TypeDeserializer$classifierDescriptors$1 extends Lambda implements Function1<Integer, ClassifierDescriptor> {
    public final /* synthetic */ TypeDeserializer this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TypeDeserializer$classifierDescriptors$1(TypeDeserializer typeDeserializer) {
        // this.this$0 = typeDeserializer;
        super(1);
    }

    public Object invoke(Object obj) {
        int intValue = ((Number) obj).intValue();
        TypeDeserializer typeDeserializer = this.this$0;
        ClassId classId = TweetUtils.getClassId(typeDeserializer.f5949c.nameResolver, intValue);
        if (classId.local) {
            return typeDeserializer.f5949c.components.deserializeClass(classId);
        }
        return TweetUtils.findClassifierAcrossModuleDependencies(typeDeserializer.f5949c.components.moduleDescriptor, classId);
    }
}
