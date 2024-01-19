package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class EnumValue extends ConstantValue<Pair<? extends ClassId, ? extends Name>> {
    public final ClassId enumClassId;
    public final Name enumEntryName;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public EnumValue(ClassId classId, Name name) {
        // Intrinsics.checkNotNullParameter(classId, "enumClassId");
        // Intrinsics.checkNotNullParameter(name, "enumEntryName");
        super(new Pair(classId, name));
        this.enumClassId = classId;
        this.enumEntryName = name;
    }

    public KotlinType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        ClassDescriptor findClassAcrossModuleDependencies = TweetUtils.findClassAcrossModuleDependencies(moduleDescriptor, this.enumClassId);
        SimpleType simpleType = null;
        if (findClassAcrossModuleDependencies != null) {
            if (!DescriptorUtils.isEnumClass(findClassAcrossModuleDependencies)) {
                findClassAcrossModuleDependencies = null;
            }
            if (findClassAcrossModuleDependencies != null) {
                simpleType = findClassAcrossModuleDependencies.getDefaultType();
            }
        }
        if (simpleType != null) {
            return simpleType;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Containing class for error-class based enum entry ");
        outline73.append(this.enumClassId);
        outline73.append('.');
        outline73.append(this.enumEntryName);
        SimpleType createErrorType = ErrorUtils.createErrorType(outline73.toString());
        Intrinsics.checkNotNullExpressionValue(createErrorType, "createErrorType(\"Containing class for error-class based enum entry $enumClassId.$enumEntryName\")");
        return createErrorType;
    }

    public String toString() {
        return this.enumClassId.getShortClassName() + '.' + this.enumEntryName;
    }
}
