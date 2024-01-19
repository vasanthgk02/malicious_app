package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;

/* compiled from: RuntimeErrorReporter.kt */
public final class RuntimeErrorReporter implements ErrorReporter {
    public static final RuntimeErrorReporter INSTANCE = new RuntimeErrorReporter();

    public void reportCannotInferVisibility(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "descriptor");
        throw new IllegalStateException(Intrinsics.stringPlus("Cannot infer visibility for ", callableMemberDescriptor));
    }

    public void reportIncompleteHierarchy(ClassDescriptor classDescriptor, List<String> list) {
        Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(list, "unresolvedSuperClasses");
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Incomplete hierarchy for class ");
        outline73.append(classDescriptor.getName());
        outline73.append(", unresolved classes ");
        outline73.append(list);
        throw new IllegalStateException(outline73.toString());
    }
}
