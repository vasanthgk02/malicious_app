package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: ClassDeserializer.kt */
public final class ClassDeserializer {
    public static final Set<ClassId> BLACK_LIST = TweetUtils.setOf(ClassId.topLevel(FqNames.cloneable.toSafe()));
    public static final ClassDeserializer Companion = null;
    public final Function1<ClassKey, ClassDescriptor> classes;
    public final DeserializationComponents components;

    /* compiled from: ClassDeserializer.kt */
    public static final class ClassKey {
        public final ClassData classData;
        public final ClassId classId;

        public ClassKey(ClassId classId2, ClassData classData2) {
            Intrinsics.checkNotNullParameter(classId2, "classId");
            this.classId = classId2;
            this.classData = classData2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ClassKey) && Intrinsics.areEqual(this.classId, ((ClassKey) obj).classId);
        }

        public int hashCode() {
            return this.classId.hashCode();
        }
    }

    public ClassDeserializer(DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "components");
        this.components = deserializationComponents;
        this.classes = deserializationComponents.storageManager.createMemoizedFunctionWithNullableValues(new ClassDeserializer$classes$1(this));
    }

    public static ClassDescriptor deserializeClass$default(ClassDeserializer classDeserializer, ClassId classId, ClassData classData, int i) {
        int i2 = i & 2;
        if (classDeserializer != null) {
            Intrinsics.checkNotNullParameter(classId, "classId");
            return (ClassDescriptor) classDeserializer.classes.invoke(new ClassKey(classId, null));
        }
        throw null;
    }
}
