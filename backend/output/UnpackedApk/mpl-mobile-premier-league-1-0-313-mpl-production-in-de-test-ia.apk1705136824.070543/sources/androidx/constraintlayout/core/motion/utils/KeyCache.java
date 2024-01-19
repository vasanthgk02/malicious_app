package androidx.constraintlayout.core.motion.utils;

import java.util.HashMap;

public class KeyCache {
    public HashMap<Object, HashMap<String, float[]>> map = new HashMap<>();

    public float getFloatValue(Object obj, String str, int i) {
        if (!this.map.containsKey(obj)) {
            return Float.NaN;
        }
        HashMap hashMap = this.map.get(obj);
        if (hashMap != null && hashMap.containsKey(str)) {
            float[] fArr = (float[]) hashMap.get(str);
            if (fArr != null && fArr.length > i) {
                return fArr[i];
            }
        }
        return Float.NaN;
    }
}
