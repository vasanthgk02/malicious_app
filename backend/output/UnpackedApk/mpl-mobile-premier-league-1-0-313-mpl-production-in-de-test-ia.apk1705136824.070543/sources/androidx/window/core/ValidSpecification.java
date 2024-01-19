package androidx.window.core;

import androidx.window.core.SpecificationComputer.VerificationMode;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\r\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J/\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0017\u001a\u00020\u00062\u0017\u0010\u0018\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0002\b\u001bH\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Landroidx/window/core/ValidSpecification;", "T", "", "Landroidx/window/core/SpecificationComputer;", "value", "tag", "", "verificationMode", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "logger", "Landroidx/window/core/Logger;", "(Ljava/lang/Object;Ljava/lang/String;Landroidx/window/core/SpecificationComputer$VerificationMode;Landroidx/window/core/Logger;)V", "getLogger", "()Landroidx/window/core/Logger;", "getTag", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getVerificationMode", "()Landroidx/window/core/SpecificationComputer$VerificationMode;", "compute", "require", "message", "condition", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpecificationComputer.kt */
public final class ValidSpecification<T> extends SpecificationComputer<T> {
    public final Logger logger;
    public final String tag;
    public final T value;
    public final VerificationMode verificationMode;

    public ValidSpecification(T t, String str, VerificationMode verificationMode2, Logger logger2) {
        Intrinsics.checkNotNullParameter(t, HSLCriteriaBuilder.VALUE);
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(verificationMode2, "verificationMode");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.value = t;
        this.tag = str;
        this.verificationMode = verificationMode2;
        this.logger = logger2;
    }

    public T compute() {
        return this.value;
    }

    public SpecificationComputer<T> require(String str, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(function1, HSLCriteriaBuilder.CONDITION);
        if (((Boolean) function1.invoke(this.value)).booleanValue()) {
            return this;
        }
        FailedSpecification failedSpecification = new FailedSpecification(this.value, this.tag, str, this.logger, this.verificationMode);
        return failedSpecification;
    }
}
