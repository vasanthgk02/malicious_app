package io.hansel.core.security.murmur;

import android.util.Pair;
import io.hansel.core.json.CoreJSONArray;
import io.hansel.core.security.b;
import java.util.ArrayList;

public class HSLMurmurAllocation {
    public long mBoundValue;
    public ArrayList<Pair<Long, Long>> mPairs = new ArrayList<>();

    public HSLMurmurAllocation(long j, long j2, long j3) {
        this.mPairs.add(new Pair(Long.valueOf(j), Long.valueOf(j2)));
        this.mBoundValue = j3;
    }

    public HSLMurmurAllocation(CoreJSONArray coreJSONArray, long j) {
        int length = coreJSONArray == null ? 0 : coreJSONArray.length();
        for (int i = 0; i < length; i++) {
            CoreJSONArray optJSONArray = coreJSONArray.optJSONArray(i);
            this.mPairs.add(new Pair(Long.valueOf(optJSONArray.optLong(0)), Long.valueOf(optJSONArray.optLong(1))));
        }
        this.mBoundValue = j;
    }

    public boolean validateAllocation(String str) {
        long b2 = b.b(str) % this.mBoundValue;
        int size = this.mPairs.size();
        for (int i = 0; i < size; i++) {
            Pair pair = this.mPairs.get(i);
            long longValue = ((Long) pair.first).longValue();
            long longValue2 = ((Long) pair.second).longValue();
            if (b2 >= longValue && b2 < longValue2) {
                return true;
            }
        }
        return false;
    }
}
