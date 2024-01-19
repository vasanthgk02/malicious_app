package com.clevertap.android.sdk.validation;

import androidx.core.app.FrameMetricsAggregator;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.BuildConfig;
import com.mpl.payment.gopay.GopayLinkingHandler;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sfs2x.client.entities.variables.SFSBuddyVariable;

public final class Validator {
    public static final String[] eventNameCharsNotAllowed = {".", ":", SFSBuddyVariable.OFFLINE_PREFIX, "'", "\"", "\\"};
    public static final String[] objectKeyCharsNotAllowed = {".", ":", SFSBuddyVariable.OFFLINE_PREFIX, "'", "\"", "\\"};
    public static final String[] objectValueCharsNotAllowed = {"'", "\"", "\\"};
    public static final String[] restrictedNames = {"Stayed", "Notification Clicked", "Notification Viewed", "UTM Visited", "Notification Sent", "App Launched", "wzrk_d", "App Uninstalled", "Notification Bounced", "Geocluster Entered", "Geocluster Exited", "DCOutgoing", "DCIncoming", "DCEnd"};
    public ArrayList<String> discardedEvents;

    public enum RestrictedMultiValueFields {
        Name,
        Email,
        Education,
        Married,
        DOB,
        Gender,
        Phone,
        Age,
        FBID,
        GPID,
        Birthday
    }

    public enum ValidationContext {
        Profile,
        Event
    }

    public ValidationResult cleanEventName(String str) {
        ValidationResult validationResult = new ValidationResult();
        String trim = str.trim();
        for (String replace : eventNameCharsNotAllowed) {
            trim = trim.replace(replace, "");
        }
        if (trim.length() > 512) {
            trim = trim.substring(0, FrameMetricsAggregator.EVERY_DURATION);
            ValidationResult create = k.create(510, 11, trim.trim(), "512");
            validationResult.errorDesc = create.errorDesc;
            validationResult.errorCode = create.errorCode;
        }
        validationResult.object = trim.trim();
        return validationResult;
    }

    public ValidationResult cleanMultiValuePropertyValue(String str) {
        ValidationResult validationResult = new ValidationResult();
        String lowerCase = str.trim().toLowerCase();
        for (String replace : objectValueCharsNotAllowed) {
            lowerCase = lowerCase.replace(replace, "");
        }
        try {
            if (lowerCase.length() > 512) {
                lowerCase = lowerCase.substring(0, FrameMetricsAggregator.EVERY_DURATION);
                ValidationResult create = k.create(521, 11, lowerCase, "512");
                validationResult.errorDesc = create.errorDesc;
                validationResult.errorCode = create.errorCode;
            }
        } catch (Exception unused) {
        }
        validationResult.object = lowerCase;
        return validationResult;
    }

    public ValidationResult cleanObjectKey(String str) {
        ValidationResult validationResult = new ValidationResult();
        String trim = str.trim();
        for (String replace : objectKeyCharsNotAllowed) {
            trim = trim.replace(replace, "");
        }
        if (trim.length() > 120) {
            trim = trim.substring(0, 119);
            ValidationResult create = k.create(BuildConfig.VERSION_CODE, 11, trim.trim(), GopayLinkingHandler.CRC_NO_GOPAY_PIN);
            validationResult.errorDesc = create.errorDesc;
            validationResult.errorCode = create.errorCode;
        }
        validationResult.object = trim.trim();
        return validationResult;
    }

    public ValidationResult cleanObjectValue(Object obj, ValidationContext validationContext) throws IllegalArgumentException {
        String str;
        ValidationResult validationResult = new ValidationResult();
        if ((obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Long)) {
            validationResult.object = obj;
            return validationResult;
        }
        if ((obj instanceof String) || (obj instanceof Character)) {
            if (obj instanceof Character) {
                str = String.valueOf(obj);
            } else {
                str = (String) obj;
            }
            String trim = str.trim();
            for (String replace : objectValueCharsNotAllowed) {
                trim = trim.replace(replace, "");
            }
            try {
                if (trim.length() > 512) {
                    trim = trim.substring(0, FrameMetricsAggregator.EVERY_DURATION);
                    ValidationResult create = k.create(521, 11, trim.trim(), "512");
                    validationResult.errorDesc = create.errorDesc;
                    validationResult.errorCode = create.errorCode;
                }
            } catch (Exception unused) {
            }
            validationResult.object = trim.trim();
            return validationResult;
        } else if (obj instanceof Date) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("$D_");
            outline73.append(((Date) obj).getTime() / 1000);
            validationResult.object = outline73.toString();
            return validationResult;
        } else {
            boolean z = obj instanceof String[];
            if ((z || (obj instanceof ArrayList)) && validationContext.equals(ValidationContext.Profile)) {
                String[] strArr = null;
                ArrayList arrayList = obj instanceof ArrayList ? (ArrayList) obj : null;
                if (z) {
                    strArr = (String[]) obj;
                }
                ArrayList arrayList2 = new ArrayList();
                if (strArr != null) {
                    for (String add : strArr) {
                        try {
                            arrayList2.add(add);
                        } catch (Exception unused2) {
                        }
                    }
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        try {
                            arrayList2.add((String) it.next());
                        } catch (Exception unused3) {
                        }
                    }
                }
                String[] strArr2 = (String[]) arrayList2.toArray(new String[0]);
                if (strArr2.length <= 0 || strArr2.length > 100) {
                    ValidationResult create2 = k.create(521, 13, GeneratedOutlineSupport.outline57(new StringBuilder(), strArr2.length, ""), "100");
                    validationResult.errorDesc = create2.errorDesc;
                    validationResult.errorCode = create2.errorCode;
                } else {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    for (String put : strArr2) {
                        jSONArray.put(put);
                    }
                    try {
                        jSONObject.put("$set", jSONArray);
                    } catch (JSONException unused4) {
                    }
                    validationResult.object = jSONObject;
                }
                return validationResult;
            }
            throw new IllegalArgumentException("Not a String, Boolean, Long, Integer, Float, Double, or Date");
        }
    }

    public ValidationResult mergeMultiValuePropertyForKey(JSONArray jSONArray, JSONArray jSONArray2, String str, String str2) {
        JSONArray jSONArray3 = jSONArray;
        JSONArray jSONArray4 = jSONArray2;
        ValidationResult validationResult = new ValidationResult();
        boolean equals = "multiValuePropertyRemoveValues".equals(str);
        JSONArray jSONArray5 = new JSONArray();
        HashSet hashSet = new HashSet();
        int length = jSONArray.length();
        int length2 = jSONArray2.length();
        BitSet bitSet = !equals ? new BitSet(length + length2) : null;
        int scan = scan(jSONArray4, hashSet, bitSet, length);
        int scan2 = (equals || hashSet.size() >= 100) ? 0 : scan(jSONArray3, hashSet, bitSet, 0);
        for (int i = scan2; i < length; i++) {
            if (equals) {
                try {
                    String str3 = (String) jSONArray3.get(i);
                    if (!hashSet.contains(str3)) {
                        jSONArray5.put(str3);
                    }
                } catch (Throwable unused) {
                }
            } else if (!bitSet.get(i)) {
                jSONArray5.put(jSONArray3.get(i));
            }
        }
        if (!equals && jSONArray5.length() < 100) {
            for (int i2 = scan; i2 < length2; i2++) {
                try {
                    if (!bitSet.get(i2 + length)) {
                        jSONArray5.put(jSONArray4.get(i2));
                    }
                } catch (Throwable unused2) {
                }
            }
        }
        if (scan > 0 || scan2 > 0) {
            ValidationResult create = k.create(521, 12, str2, "100");
            validationResult.errorCode = create.errorCode;
            validationResult.errorDesc = create.errorDesc;
        }
        validationResult.object = jSONArray5;
        return validationResult;
    }

    public final int scan(JSONArray jSONArray, Set<String> set, BitSet bitSet, int i) {
        for (int length = jSONArray.length() - 1; length >= 0; length--) {
            try {
                Object obj = jSONArray.get(length);
                String obj2 = obj != null ? obj.toString() : null;
                if (bitSet != null) {
                    if (obj2 != null) {
                        if (!set.contains(obj2)) {
                            set.add(obj2);
                            if (set.size() == 100) {
                                return length;
                            }
                        }
                    }
                    bitSet.set(length + i, true);
                } else if (obj2 != null) {
                    set.add(obj2);
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }
}
