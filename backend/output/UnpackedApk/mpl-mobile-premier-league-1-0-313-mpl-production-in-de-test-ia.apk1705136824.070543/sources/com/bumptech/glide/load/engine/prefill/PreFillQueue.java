package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class PreFillQueue {
    public final Map<PreFillType, Integer> bitmapsPerType;
    public int bitmapsRemaining;
    public int keyIndex;
    public final List<PreFillType> keyList;

    public PreFillQueue(Map<PreFillType, Integer> map) {
        this.bitmapsPerType = map;
        this.keyList = new ArrayList(map.keySet());
        for (Integer intValue : map.values()) {
            this.bitmapsRemaining = intValue.intValue() + this.bitmapsRemaining;
        }
    }
}
