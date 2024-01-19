package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MemberVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.MethodAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
public final class AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 implements MemberVisitor {
    public final /* synthetic */ HashMap<MemberSignature, List<A>> $memberAnnotations;
    public final /* synthetic */ HashMap<MemberSignature, C> $propertyConstants;
    public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader<A, C> this$0;

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public final class AnnotationVisitorForMethod extends MemberAnnotationVisitor implements MethodAnnotationVisitor {
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 this$0;

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public AnnotationVisitorForMethod(AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature memberSignature) {
            // Intrinsics.checkNotNullParameter(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, "this$0");
            // Intrinsics.checkNotNullParameter(memberSignature, "signature");
            // this.this$0 = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
            super(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, memberSignature);
        }

        public AnnotationArgumentVisitor visitParameterAnnotation(int i, ClassId classId, SourceElement sourceElement) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(sourceElement, DefaultSettingsSpiCall.SOURCE_PARAM);
            MemberSignature memberSignature = this.signature;
            Intrinsics.checkNotNullParameter(memberSignature, "signature");
            MemberSignature memberSignature2 = new MemberSignature(memberSignature.signature + '@' + i, null);
            List list = this.this$0.$memberAnnotations.get(memberSignature2);
            if (list == null) {
                list = new ArrayList();
                this.this$0.$memberAnnotations.put(memberSignature2, list);
            }
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.this$0.this$0, classId, sourceElement, list);
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public class MemberAnnotationVisitor implements AnnotationVisitor {
        public final ArrayList<A> result = new ArrayList<>();
        public final MemberSignature signature;
        public final /* synthetic */ AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 this$0;

        public MemberAnnotationVisitor(AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1 abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, MemberSignature memberSignature) {
            Intrinsics.checkNotNullParameter(abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1, "this$0");
            Intrinsics.checkNotNullParameter(memberSignature, "signature");
            this.this$0 = abstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1;
            this.signature = memberSignature;
        }

        public AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement sourceElement) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            Intrinsics.checkNotNullParameter(sourceElement, DefaultSettingsSpiCall.SOURCE_PARAM);
            return AbstractBinaryClassAnnotationAndConstantLoader.access$loadAnnotationIfNotSpecial(this.this$0.this$0, classId, sourceElement, this.result);
        }

        public void visitEnd() {
            if (!this.result.isEmpty()) {
                this.this$0.$memberAnnotations.put(this.signature, this.result);
            }
        }
    }

    public AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1(AbstractBinaryClassAnnotationAndConstantLoader<A, C> abstractBinaryClassAnnotationAndConstantLoader, HashMap<MemberSignature, List<A>> hashMap, HashMap<MemberSignature, C> hashMap2) {
        this.this$0 = abstractBinaryClassAnnotationAndConstantLoader;
        this.$memberAnnotations = hashMap;
        this.$propertyConstants = hashMap2;
    }

    public AnnotationVisitor visitField(Name name, String str, Object obj) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(str, "desc");
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        Intrinsics.checkNotNullParameter(asString, "name");
        Intrinsics.checkNotNullParameter(str, "desc");
        return new MemberAnnotationVisitor(this, new MemberSignature(asString + '#' + str, null));
    }

    public MethodAnnotationVisitor visitMethod(Name name, String str) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(str, "desc");
        String asString = name.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "name.asString()");
        Intrinsics.checkNotNullParameter(asString, "name");
        Intrinsics.checkNotNullParameter(str, "desc");
        return new AnnotationVisitorForMethod(this, new MemberSignature(Intrinsics.stringPlus(asString, str), null));
    }
}
