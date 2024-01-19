package net.sf.json.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public abstract class CycleDetectionStrategy {
    public static final JSONArray IGNORE_PROPERTY_ARR = new JSONArray();
    public static final JSONObject IGNORE_PROPERTY_OBJ = new JSONObject();
    public static final CycleDetectionStrategy STRICT = new StrictCycleDetectionStrategy(null);

    public static final class StrictCycleDetectionStrategy extends CycleDetectionStrategy {
        public StrictCycleDetectionStrategy(AnonymousClass1 r1) {
        }

        public JSONArray handleRepeatedReferenceAsArray(Object obj) {
            throw new JSONException((String) "There is a cycle in the hierarchy!");
        }

        public JSONObject handleRepeatedReferenceAsObject(Object obj) {
            throw new JSONException((String) "There is a cycle in the hierarchy!");
        }
    }

    public abstract JSONArray handleRepeatedReferenceAsArray(Object obj);

    public abstract JSONObject handleRepeatedReferenceAsObject(Object obj);
}
