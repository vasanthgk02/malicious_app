package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public abstract class ErrorValue extends ConstantValue<Unit> {

    /* compiled from: constantValues.kt */
    public static final class ErrorValueWithMessage extends ErrorValue {
        public final String message;

        public ErrorValueWithMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public KotlinType getType(ModuleDescriptor moduleDescriptor) {
            Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
            SimpleType createErrorType = ErrorUtils.createErrorType(this.message);
            Intrinsics.checkNotNullExpressionValue(createErrorType, "createErrorType(message)");
            return createErrorType;
        }

        public String toString() {
            return this.message;
        }
    }

    public ErrorValue() {
        super(Unit.INSTANCE);
    }

    public Object getValue() {
        throw new UnsupportedOperationException();
    }
}
