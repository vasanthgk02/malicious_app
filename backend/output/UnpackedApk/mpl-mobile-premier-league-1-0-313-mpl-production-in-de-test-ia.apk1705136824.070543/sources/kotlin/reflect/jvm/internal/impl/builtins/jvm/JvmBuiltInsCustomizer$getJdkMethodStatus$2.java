package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer.JDKMemberStatus;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.utils.DFS$AbstractNodeHandler;

/* compiled from: JvmBuiltInsCustomizer.kt */
public final class JvmBuiltInsCustomizer$getJdkMethodStatus$2 extends DFS$AbstractNodeHandler<ClassDescriptor, JDKMemberStatus> {
    public final /* synthetic */ String $jvmDescriptor;
    public final /* synthetic */ Ref$ObjectRef<JDKMemberStatus> $result;

    public JvmBuiltInsCustomizer$getJdkMethodStatus$2(String str, Ref$ObjectRef<JDKMemberStatus> ref$ObjectRef) {
        this.$jvmDescriptor = str;
        this.$result = ref$ObjectRef;
    }

    public boolean beforeChildren(Object obj) {
        ClassDescriptor classDescriptor = (ClassDescriptor) obj;
        Intrinsics.checkNotNullParameter(classDescriptor, "javaClassDescriptor");
        String signature = TweetUtils.signature(SignatureBuildingComponents.INSTANCE, classDescriptor, this.$jvmDescriptor);
        JvmBuiltInsSignatures jvmBuiltInsSignatures = JvmBuiltInsSignatures.INSTANCE;
        if (JvmBuiltInsSignatures.HIDDEN_METHOD_SIGNATURES.contains(signature)) {
            this.$result.element = JDKMemberStatus.HIDDEN;
        } else {
            JvmBuiltInsSignatures jvmBuiltInsSignatures2 = JvmBuiltInsSignatures.INSTANCE;
            if (JvmBuiltInsSignatures.VISIBLE_METHOD_SIGNATURES.contains(signature)) {
                this.$result.element = JDKMemberStatus.VISIBLE;
            } else {
                JvmBuiltInsSignatures jvmBuiltInsSignatures3 = JvmBuiltInsSignatures.INSTANCE;
                if (JvmBuiltInsSignatures.DROP_LIST_METHOD_SIGNATURES.contains(signature)) {
                    this.$result.element = JDKMemberStatus.DROP;
                }
            }
        }
        return this.$result.element == null;
    }

    public Object result() {
        JDKMemberStatus jDKMemberStatus = (JDKMemberStatus) this.$result.element;
        return jDKMemberStatus == null ? JDKMemberStatus.NOT_CONSIDERED : jDKMemberStatus;
    }
}
