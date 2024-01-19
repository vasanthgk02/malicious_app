package com.midtrans.sdk.gopaycheckout.core.transaction;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\t\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/transaction/SingleMetadata;", "", "metadata", "", "", "(Ljava/util/Map;)V", "getMetadata", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class SingleMetadata {
    @Json(name = "metadata")
    public final Map<String, String> metadata;

    public SingleMetadata(Map<String, String> map) {
        this.metadata = map;
    }

    public static /* synthetic */ SingleMetadata copy$default(SingleMetadata singleMetadata, Map<String, String> map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = singleMetadata.metadata;
        }
        return singleMetadata.copy(map);
    }

    public final Map<String, String> component1() {
        return this.metadata;
    }

    public final SingleMetadata copy(Map<String, String> map) {
        return new SingleMetadata(map);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof SingleMetadata) && Intrinsics.areEqual(this.metadata, ((SingleMetadata) obj).metadata));
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        Map<String, String> map = this.metadata;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SingleMetadata(metadata=");
        outline73.append(this.metadata);
        outline73.append(")");
        return outline73.toString();
    }
}
