package androidx.window.core;

import androidx.window.core.SpecificationComputer.VerificationMode;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import in.juspay.hypersdk.mystique.AnimationHolder.InlineAnimation;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B-\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000f\u0010\u001b\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0017J/\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\b H\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Landroidx/window/core/FailedSpecification;", "T", "", "Landroidx/window/core/SpecificationComputer;", "value", "tag", "", "message", "logger", "Landroidx/window/core/Logger;", "verificationMode", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Landroidx/window/core/Logger;Landroidx/window/core/SpecificationComputer$VerificationMode;)V", "exception", "Landroidx/window/core/WindowStrictModeException;", "getException", "()Landroidx/window/core/WindowStrictModeException;", "getLogger", "()Landroidx/window/core/Logger;", "getMessage", "()Ljava/lang/String;", "getTag", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getVerificationMode", "()Landroidx/window/core/SpecificationComputer$VerificationMode;", "compute", "require", "condition", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpecificationComputer.kt */
public final class FailedSpecification<T> extends SpecificationComputer<T> {
    public final WindowStrictModeException exception;
    public final Logger logger;
    public final String message;
    public final String tag;
    public final T value;
    public final VerificationMode verificationMode;

    public FailedSpecification(T t, String str, String str2, Logger logger2, VerificationMode verificationMode2) {
        Collection collection;
        Intrinsics.checkNotNullParameter(t, HSLCriteriaBuilder.VALUE);
        Intrinsics.checkNotNullParameter(str, InlineAnimation.TAG);
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(verificationMode2, "verificationMode");
        this.value = t;
        this.tag = str;
        this.message = str2;
        this.logger = logger2;
        this.verificationMode = verificationMode2;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(createMessage(this.value, this.message));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
        Intrinsics.checkNotNullParameter(stackTrace, "<this>");
        int length = stackTrace.length - 2;
        length = length < 0 ? 0 : length;
        Intrinsics.checkNotNullParameter(stackTrace, "<this>");
        if (length >= 0) {
            if (length == 0) {
                collection = EmptyList.INSTANCE;
            } else {
                int length2 = stackTrace.length;
                if (length >= length2) {
                    collection = TweetUtils.toList(stackTrace);
                } else if (length == 1) {
                    collection = TweetUtils.listOf(stackTrace[length2 - 1]);
                } else {
                    ArrayList arrayList = new ArrayList(length);
                    for (int i = length2 - length; i < length2; i++) {
                        arrayList.add(stackTrace[i]);
                    }
                    collection = arrayList;
                }
            }
            Object[] array = collection.toArray(new StackTraceElement[0]);
            if (array != null) {
                windowStrictModeException.setStackTrace((StackTraceElement[]) array);
                this.exception = windowStrictModeException;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline42("Requested element count ", length, " is less than zero.").toString());
    }

    public T compute() {
        int ordinal = this.verificationMode.ordinal();
        if (ordinal != 0) {
            if (ordinal == 1) {
                this.logger.debug(this.tag, createMessage(this.value, this.message));
            } else if (ordinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return null;
        }
        throw this.exception;
    }

    public SpecificationComputer<T> require(String str, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(function1, HSLCriteriaBuilder.CONDITION);
        return this;
    }
}
