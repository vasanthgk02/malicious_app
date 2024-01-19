package kotlin.reflect.jvm.internal.impl.renderer;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;

/* compiled from: ClassifierNamePolicy.kt */
public interface ClassifierNamePolicy {

    /* compiled from: ClassifierNamePolicy.kt */
    public static final class FULLY_QUALIFIED implements ClassifierNamePolicy {
        public static final FULLY_QUALIFIED INSTANCE = new FULLY_QUALIFIED();

        public String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer descriptorRenderer) {
            Intrinsics.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                Name name = ((TypeParameterDescriptor) classifierDescriptor).getName();
                Intrinsics.checkNotNullExpressionValue(name, "classifier.name");
                return descriptorRenderer.renderName(name, false);
            }
            FqNameUnsafe fqName = DescriptorUtils.getFqName(classifierDescriptor);
            Intrinsics.checkNotNullExpressionValue(fqName, "getFqName(classifier)");
            return descriptorRenderer.renderFqName(fqName);
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    public static final class SHORT implements ClassifierNamePolicy {
        public static final SHORT INSTANCE = new SHORT();

        /* JADX WARNING: Incorrect type for immutable var: ssa=kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, code=kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, for r2v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, java.lang.Object, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String renderClassifier(kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2, kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer r3) {
            /*
                r1 = this;
                java.lang.String r0 = "classifier"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.String r0 = "renderer"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                boolean r0 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
                if (r0 == 0) goto L_0x001f
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r2
                kotlin.reflect.jvm.internal.impl.name.Name r2 = r2.getName()
                java.lang.String r0 = "classifier.name"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
                r0 = 0
                java.lang.String r2 = r3.renderName(r2, r0)
                return r2
            L_0x001f:
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
            L_0x0024:
                kotlin.reflect.jvm.internal.impl.name.Name r0 = r2.getName()
                r3.add(r0)
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r2 = r2.getContainingDeclaration()
                boolean r0 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
                if (r0 != 0) goto L_0x0024
                java.lang.String r2 = "<this>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r2)
                kotlin.collections.ReversedList r2 = new kotlin.collections.ReversedList
                r2.<init>(r3)
                java.lang.String r2 = com.twitter.sdk.android.tweetui.TweetUtils.renderFqName(r2)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy.SHORT.renderClassifier(kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor, kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer):java.lang.String");
        }
    }

    /* compiled from: ClassifierNamePolicy.kt */
    public static final class SOURCE_CODE_QUALIFIED implements ClassifierNamePolicy {
        public static final SOURCE_CODE_QUALIFIED INSTANCE = new SOURCE_CODE_QUALIFIED();

        public final String qualifiedNameForSourceCode(ClassifierDescriptor classifierDescriptor) {
            String str;
            Name name = classifierDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name, "descriptor.name");
            String render = TweetUtils.render(name);
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                return render;
            }
            DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof ClassDescriptor) {
                str = qualifiedNameForSourceCode((ClassifierDescriptor) containingDeclaration);
            } else if (containingDeclaration instanceof PackageFragmentDescriptor) {
                FqNameUnsafe unsafe = ((PackageFragmentDescriptor) containingDeclaration).getFqName().toUnsafe();
                Intrinsics.checkNotNullExpressionValue(unsafe, "descriptor.fqName.toUnsafe()");
                Intrinsics.checkNotNullParameter(unsafe, "<this>");
                List<Name> pathSegments = unsafe.pathSegments();
                Intrinsics.checkNotNullExpressionValue(pathSegments, "pathSegments()");
                str = TweetUtils.renderFqName(pathSegments);
            } else {
                str = null;
            }
            if (str != null && !Intrinsics.areEqual(str, "")) {
                render = str + '.' + render;
            }
            return render;
        }

        public String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer descriptorRenderer) {
            Intrinsics.checkNotNullParameter(classifierDescriptor, "classifier");
            Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
            return qualifiedNameForSourceCode(classifierDescriptor);
        }
    }

    String renderClassifier(ClassifierDescriptor classifierDescriptor, DescriptorRenderer descriptorRenderer);
}
