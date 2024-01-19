package kotlinx.serialization.json;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"kotlinx/serialization/json/JsonElementSerializersKt$defer$1", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementsCount", "", "getElementsCount", "()I", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "original", "getOriginal", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "original$delegate", "Lkotlin/Lazy;", "serialName", "", "getSerialName", "()Ljava/lang/String;", "getElementAnnotations", "", "", "index", "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: JsonElementSerializers.kt */
public final class JsonElementSerializersKt$defer$1 implements SerialDescriptor {
    public final /* synthetic */ Function0<SerialDescriptor> $deferred;
    public final Lazy original$delegate = TweetUtils.lazy(this.$deferred);

    public JsonElementSerializersKt$defer$1(Function0<? extends SerialDescriptor> function0) {
        this.$deferred = function0;
    }

    public List<Annotation> getAnnotations() {
        return TypeUtilsKt.getAnnotations(this);
    }

    public List<Annotation> getElementAnnotations(int i) {
        return getOriginal().getElementAnnotations(i);
    }

    public SerialDescriptor getElementDescriptor(int i) {
        return getOriginal().getElementDescriptor(i);
    }

    public int getElementIndex(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return getOriginal().getElementIndex(str);
    }

    public String getElementName(int i) {
        return getOriginal().getElementName(i);
    }

    public int getElementsCount() {
        return getOriginal().getElementsCount();
    }

    public SerialKind getKind() {
        return getOriginal().getKind();
    }

    public final SerialDescriptor getOriginal() {
        return (SerialDescriptor) this.original$delegate.getValue();
    }

    public String getSerialName() {
        return getOriginal().getSerialName();
    }

    public boolean isElementOptional(int i) {
        return getOriginal().isElementOptional(i);
    }

    public boolean isInline() {
        TypeUtilsKt.isInline(this);
        return false;
    }

    public boolean isNullable() {
        TypeUtilsKt.isNullable(this);
        return false;
    }
}
