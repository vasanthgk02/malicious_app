package kotlin.reflect.jvm.internal.impl.builtins.functions;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: FunctionClassScope.kt */
public final class FunctionClassScope extends GivenFunctionsMemberScope {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public FunctionClassScope(StorageManager storageManager, FunctionClassDescriptor functionClassDescriptor) {
        // Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        // Intrinsics.checkNotNullParameter(functionClassDescriptor, "containingClass");
        super(storageManager, functionClassDescriptor);
    }

    public List<FunctionDescriptor> computeDeclaredFunctions() {
        int ordinal = ((FunctionClassDescriptor) this.containingClass).functionKind.ordinal();
        if (ordinal == 0) {
            return TweetUtils.listOf(FunctionInvokeDescriptor.create((FunctionClassDescriptor) this.containingClass, false));
        }
        if (ordinal != 1) {
            return EmptyList.INSTANCE;
        }
        return TweetUtils.listOf(FunctionInvokeDescriptor.create((FunctionClassDescriptor) this.containingClass, true));
    }
}
