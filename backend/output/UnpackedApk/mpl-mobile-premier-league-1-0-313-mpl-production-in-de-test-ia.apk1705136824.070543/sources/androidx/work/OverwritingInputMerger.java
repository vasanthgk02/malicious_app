package androidx.work;

import androidx.work.Data.Builder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class OverwritingInputMerger extends InputMerger {
    public Data merge(List<Data> list) {
        Builder builder = new Builder();
        HashMap hashMap = new HashMap();
        for (Data data : list) {
            hashMap.putAll(Collections.unmodifiableMap(data.mValues));
        }
        builder.putAll(hashMap);
        return builder.build();
    }
}
