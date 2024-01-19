package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.ClassRequest;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: NotFoundClasses.kt */
public final class NotFoundClasses$classes$1 extends Lambda implements Function1<ClassRequest, ClassDescriptor> {
    public final /* synthetic */ NotFoundClasses this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NotFoundClasses$classes$1(NotFoundClasses notFoundClasses) {
        // this.this$0 = notFoundClasses;
        super(1);
    }

    public Object invoke(Object obj) {
        ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor;
        ClassRequest classRequest = (ClassRequest) obj;
        Intrinsics.checkNotNullParameter(classRequest, "$dstr$classId$typeParametersCount");
        ClassId classId = classRequest.classId;
        List<Integer> list = classRequest.typeParametersCount;
        if (!classId.local) {
            ClassId outerClassId = classId.getOuterClassId();
            if (outerClassId == null) {
                classOrPackageFragmentDescriptor = null;
            } else {
                classOrPackageFragmentDescriptor = this.this$0.getClass(outerClassId, ArraysKt___ArraysJvmKt.drop(list, 1));
            }
            if (classOrPackageFragmentDescriptor == null) {
                MemoizedFunctionToNotNull<FqName, PackageFragmentDescriptor> memoizedFunctionToNotNull = this.this$0.packageFragments;
                FqName packageFqName = classId.getPackageFqName();
                Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
                classOrPackageFragmentDescriptor = (ClassOrPackageFragmentDescriptor) memoizedFunctionToNotNull.invoke(packageFqName);
            }
            ClassOrPackageFragmentDescriptor classOrPackageFragmentDescriptor2 = classOrPackageFragmentDescriptor;
            boolean isNestedClass = classId.isNestedClass();
            StorageManager storageManager = this.this$0.storageManager;
            Name shortClassName = classId.getShortClassName();
            Intrinsics.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
            Integer num = (Integer) ArraysKt___ArraysJvmKt.firstOrNull(list);
            MockClassDescriptor mockClassDescriptor = new MockClassDescriptor(storageManager, classOrPackageFragmentDescriptor2, shortClassName, isNestedClass, num == null ? 0 : num.intValue());
            return mockClassDescriptor;
        }
        throw new UnsupportedOperationException(Intrinsics.stringPlus("Unresolved local class: ", classId));
    }
}
