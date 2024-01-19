package com.google.firebase.abt;

import com.netcore.android.SMTConfigConstants;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class AbtExperimentInfo {
    public static final String[] ALL_REQUIRED_KEYS = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};
    public static final DateFormat protoTimestampStringParser = new SimpleDateFormat(SMTConfigConstants.SERVER_TIME_FORMAT, Locale.US);
    public final String experimentId;
    public final Date experimentStartTime;
    public final long timeToLiveInMillis;
    public final String triggerEventName;
    public final long triggerTimeoutInMillis;
    public final String variantId;

    public AbtExperimentInfo(String str, String str2, String str3, Date date, long j, long j2) {
        this.experimentId = str;
        this.variantId = str2;
        this.triggerEventName = str3;
        this.experimentStartTime = date;
        this.triggerTimeoutInMillis = j;
        this.timeToLiveInMillis = j2;
    }

    public static AbtExperimentInfo fromMap(Map<String, String> map) throws AbtException {
        ArrayList arrayList = new ArrayList();
        for (String str : ALL_REQUIRED_KEYS) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            try {
                AbtExperimentInfo abtExperimentInfo = new AbtExperimentInfo(map.get("experimentId"), map.get("variantId"), map.containsKey("triggerEvent") ? map.get("triggerEvent") : "", protoTimestampStringParser.parse(map.get("experimentStartTime")), Long.parseLong(map.get("triggerTimeoutMillis")), Long.parseLong(map.get("timeToLiveMillis")));
                return abtExperimentInfo;
            } catch (ParseException e2) {
                throw new AbtException("Could not process experiment: parsing experiment start time failed.", e2);
            } catch (NumberFormatException e3) {
                throw new AbtException("Could not process experiment: one of the durations could not be converted into a long.", e3);
            }
        } else {
            throw new AbtException(String.format("The following keys are missing from the experiment info map: %s", new Object[]{arrayList}));
        }
    }
}
