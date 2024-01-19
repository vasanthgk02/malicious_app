package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory$createArrayValue$1;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
public final class BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitArray$1 implements AnnotationArrayArgumentVisitor {
    public final /* synthetic */ ClassDescriptor $annotationClass;
    public final /* synthetic */ Name $name;
    public final ArrayList<ConstantValue<?>> elements = new ArrayList<>();
    public final /* synthetic */ BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 this$0;

    public BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1$visitArray$1(BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1 binaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1, Name name, ClassDescriptor classDescriptor) {
        this.this$0 = binaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1;
        this.$name = name;
        this.$annotationClass = classDescriptor;
    }

    public void visit(Object obj) {
        this.elements.add(this.this$0.createConstant(this.$name, obj));
    }

    public void visitClassLiteral(ClassLiteralValue classLiteralValue) {
        Intrinsics.checkNotNullParameter(classLiteralValue, HSLCriteriaBuilder.VALUE);
        this.elements.add(new KClassValue(classLiteralValue));
    }

    public void visitEnd() {
        ValueParameterDescriptor annotationParameterByName = TweetUtils.getAnnotationParameterByName(this.$name, this.$annotationClass);
        if (annotationParameterByName != null) {
            HashMap<Name, ConstantValue<?>> hashMap = this.this$0.arguments;
            Name name = this.$name;
            List<T> compact = TypeUtilsKt.compact(this.elements);
            KotlinType type = annotationParameterByName.getType();
            Intrinsics.checkNotNullExpressionValue(type, "parameter.type");
            Intrinsics.checkNotNullParameter(compact, HSLCriteriaBuilder.VALUE);
            Intrinsics.checkNotNullParameter(type, "type");
            hashMap.put(name, new ArrayValue(compact, new ConstantValueFactory$createArrayValue$1(type)));
        }
    }

    public void visitEnum(ClassId classId, Name name) {
        Intrinsics.checkNotNullParameter(classId, "enumClassId");
        Intrinsics.checkNotNullParameter(name, "enumEntryName");
        this.elements.add(new EnumValue(classId, name));
    }
}
