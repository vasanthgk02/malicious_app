package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JvmBuiltInsCustomizer.kt */
public final class JvmBuiltInsCustomizer$cloneableType$2 extends Lambda implements Function0<SimpleType> {
    public final /* synthetic */ StorageManager $storageManager;
    public final /* synthetic */ JvmBuiltInsCustomizer this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JvmBuiltInsCustomizer$cloneableType$2(JvmBuiltInsCustomizer jvmBuiltInsCustomizer, StorageManager storageManager) {
        // this.this$0 = jvmBuiltInsCustomizer;
        // this.$storageManager = storageManager;
        super(0);
    }

    public Object invoke() {
        ModuleDescriptor moduleDescriptor = this.this$0.getSettings().ownerModuleDescriptor;
        JvmBuiltInClassDescriptorFactory jvmBuiltInClassDescriptorFactory = JvmBuiltInClassDescriptorFactory.Companion;
        return TweetUtils.findNonGenericClassAcrossDependencies(moduleDescriptor, JvmBuiltInClassDescriptorFactory.CLONEABLE_CLASS_ID, new NotFoundClasses(this.$storageManager, this.this$0.getSettings().ownerModuleDescriptor)).getDefaultType();
    }
}
