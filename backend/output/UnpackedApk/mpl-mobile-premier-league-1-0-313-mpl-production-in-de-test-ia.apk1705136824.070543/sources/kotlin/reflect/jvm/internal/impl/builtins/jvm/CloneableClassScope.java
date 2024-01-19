package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: CloneableClassScope.kt */
public final class CloneableClassScope extends GivenFunctionsMemberScope {
    public static final Name CLONE_NAME;
    public static final CloneableClassScope Companion = null;

    static {
        Name identifier = Name.identifier("clone");
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(\"clone\")");
        CLONE_NAME = identifier;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CloneableClassScope(StorageManager storageManager, ClassDescriptor classDescriptor) {
        // Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        // Intrinsics.checkNotNullParameter(classDescriptor, "containingClass");
        super(storageManager, classDescriptor);
    }

    public List<FunctionDescriptor> computeDeclaredFunctions() {
        ClassDescriptor classDescriptor = this.containingClass;
        if (Annotations.Companion != null) {
            SimpleFunctionDescriptorImpl create = SimpleFunctionDescriptorImpl.create(classDescriptor, Companion.EMPTY, CLONE_NAME, Kind.DECLARATION, SourceElement.NO_SOURCE);
            ReceiverParameterDescriptor thisAsReceiverParameter = this.containingClass.getThisAsReceiverParameter();
            EmptyList emptyList = EmptyList.INSTANCE;
            create.initialize((ReceiverParameterDescriptor) null, thisAsReceiverParameter, (List) emptyList, (List) emptyList, (KotlinType) DescriptorUtilsKt.getBuiltIns(this.containingClass).getAnyType(), Modality.OPEN, DescriptorVisibilities.PROTECTED);
            return TweetUtils.listOf(create);
        }
        throw null;
    }
}
