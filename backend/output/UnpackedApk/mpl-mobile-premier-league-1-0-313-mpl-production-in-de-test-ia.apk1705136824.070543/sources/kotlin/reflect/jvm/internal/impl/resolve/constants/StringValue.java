package kotlin.reflect.jvm.internal.impl.resolve.constants;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.apache.commons.lang.StringEscapeUtils;

/* compiled from: constantValues.kt */
public final class StringValue extends ConstantValue<String> {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public StringValue(String str) {
        // Intrinsics.checkNotNullParameter(str, HSLCriteriaBuilder.VALUE);
        super(str);
    }

    public KotlinType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        SimpleType stringType = moduleDescriptor.getBuiltIns().getStringType();
        Intrinsics.checkNotNullExpressionValue(stringType, "module.builtIns.stringType");
        return stringType;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline59(GeneratedOutlineSupport.outline72(StringEscapeUtils.CSV_QUOTE), (String) this.value, StringEscapeUtils.CSV_QUOTE);
    }
}
