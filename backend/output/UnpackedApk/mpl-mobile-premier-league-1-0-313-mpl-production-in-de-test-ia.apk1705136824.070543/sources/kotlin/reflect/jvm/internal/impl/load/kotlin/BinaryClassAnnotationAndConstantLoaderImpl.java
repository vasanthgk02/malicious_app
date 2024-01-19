package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.mpl.androidapp.login.LoginReactModule;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
public final class BinaryClassAnnotationAndConstantLoaderImpl extends AbstractBinaryClassAnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {
    public final AnnotationDeserializer annotationDeserializer;
    public final ModuleDescriptor module;
    public final NotFoundClasses notFoundClasses;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public BinaryClassAnnotationAndConstantLoaderImpl(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses2, StorageManager storageManager, KotlinClassFinder kotlinClassFinder) {
        // Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        // Intrinsics.checkNotNullParameter(notFoundClasses2, "notFoundClasses");
        // Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        // Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        super(storageManager, kotlinClassFinder);
        this.module = moduleDescriptor;
        this.notFoundClasses = notFoundClasses2;
        this.annotationDeserializer = new AnnotationDeserializer(moduleDescriptor, notFoundClasses2);
    }

    public AnnotationArgumentVisitor loadAnnotation(ClassId classId, SourceElement sourceElement, List<AnnotationDescriptor> list) {
        Intrinsics.checkNotNullParameter(classId, "annotationClassId");
        Intrinsics.checkNotNullParameter(sourceElement, DefaultSettingsSpiCall.SOURCE_PARAM);
        Intrinsics.checkNotNullParameter(list, LoginReactModule.RESULT);
        return new BinaryClassAnnotationAndConstantLoaderImpl$loadAnnotation$1(TweetUtils.findNonGenericClassAcrossDependencies(this.module, classId, this.notFoundClasses), this, list, sourceElement);
    }
}
