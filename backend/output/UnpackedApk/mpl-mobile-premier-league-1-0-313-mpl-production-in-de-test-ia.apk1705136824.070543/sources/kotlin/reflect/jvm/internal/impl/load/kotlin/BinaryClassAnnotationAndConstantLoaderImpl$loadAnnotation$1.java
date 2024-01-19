package kotlin.reflect.jvm.internal.impl.load.kotlin;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue.ErrorValueWithMessage;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
public final class BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 implements AnnotationArgumentVisitor {
    public final /* synthetic */ ClassDescriptor $annotationClass;
    public final /* synthetic */ List<AnnotationDescriptor> $result;
    public final /* synthetic */ SourceElement $source;
    public final HashMap<Name, ConstantValue<?>> arguments = new HashMap<>();
    public final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl this$0;

    public BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1(ClassDescriptor classDescriptor, BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, List<AnnotationDescriptor> list, SourceElement sourceElement) {
        this.$annotationClass = classDescriptor;
        this.this$0 = binaryClassAnnotationAndConstantLoaderImpl;
        this.$result = list;
        this.$source = sourceElement;
    }

    public final ConstantValue<?> createConstant(Name name, Object obj) {
        ConstantValue<?> createConstantValue = ConstantValueFactory.createConstantValue(obj);
        if (createConstantValue != null) {
            return createConstantValue;
        }
        String stringPlus = Intrinsics.stringPlus("Unsupported annotation argument: ", name);
        Intrinsics.checkNotNullParameter(stringPlus, "message");
        return new ErrorValueWithMessage(stringPlus);
    }

    public void visit(Name name, Object obj) {
        if (name != null) {
            this.arguments.put(name, createConstant(name, obj));
        }
    }

    public AnnotationArgumentVisitor visitAnnotation(Name name, ClassId classId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ArrayList arrayList = new ArrayList();
        BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl = this.this$0;
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        AnnotationArgumentVisitor loadAnnotation = binaryClassAnnotationAndConstantLoaderImpl.loadAnnotation(classId, sourceElement, arrayList);
        Intrinsics.checkNotNull(loadAnnotation);
        return new BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitAnnotation$1(loadAnnotation, this, name, arrayList);
    }

    public AnnotationArrayArgumentVisitor visitArray(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitArray$1(this, name, this.$annotationClass);
    }

    public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(classLiteralValue, HSLCriteriaBuilder.VALUE);
        this.arguments.put(name, new KClassValue(classLiteralValue));
    }

    public void visitEnd() {
        this.$result.add(new AnnotationDescriptorImpl(this.$annotationClass.getDefaultType(), this.arguments, this.$source));
    }

    public void visitEnum(Name name, ClassId classId, Name name2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(classId, "enumClassId");
        Intrinsics.checkNotNullParameter(name2, "enumEntryName");
        this.arguments.put(name, new EnumValue(classId, name2));
    }
}
