package co.hyperverge.crashguard.data.network;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B3\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J!\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eHÇ\u0001R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lco/hyperverge/crashguard/data/network/SentryErrorResponse;", "", "seen1", "", "detail", "", "causes", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/util/List;)V", "getCauses", "()Ljava/util/List;", "getDetail", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Serializable
/* compiled from: SentryResponse.kt */
public final class SentryErrorResponse {
    public static final Companion Companion = new Companion(null);
    public final List<String> causes;
    public final String detail;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lco/hyperverge/crashguard/data/network/SentryErrorResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lco/hyperverge/crashguard/data/network/SentryErrorResponse;", "crashguard_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SentryResponse.kt */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<SentryErrorResponse> serializer() {
            return SentryErrorResponse$$serializer.INSTANCE;
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public SentryErrorResponse() {
        this.detail = null;
        this.causes = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SentryErrorResponse)) {
            return false;
        }
        SentryErrorResponse sentryErrorResponse = (SentryErrorResponse) obj;
        return Intrinsics.areEqual(this.detail, sentryErrorResponse.detail) && Intrinsics.areEqual(this.causes, sentryErrorResponse.causes);
    }

    public int hashCode() {
        String str = this.detail;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.causes;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SentryErrorResponse(detail=");
        outline73.append(this.detail);
        outline73.append(", causes=");
        outline73.append(this.causes);
        outline73.append(')');
        return outline73.toString();
    }

    public /* synthetic */ SentryErrorResponse(int i, String str, List list) {
        if ((i & 0) == 0) {
            if ((i & 1) == 0) {
                this.detail = null;
            } else {
                this.detail = str;
            }
            if ((i & 2) == 0) {
                this.causes = null;
            } else {
                this.causes = list;
            }
        } else {
            TypeUtilsKt.throwMissingFieldException(i, 0, SentryErrorResponse$$serializer.INSTANCE.getDescriptor());
            throw null;
        }
    }
}
