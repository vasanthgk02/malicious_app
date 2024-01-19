package co.hyperverge.hypersnapsdk.objects;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;

public class HyperKYCConfigs {
    public HashMap<String, String> hyperKYCValueMap;
    public String sentryEndPoint;
    public String sentryFilter;
    public String sentryKey;

    public static class HyperKYCConfigsBuilder {
        public HashMap<String, String> hyperKYCValueMap;
        public String sentryEndPoint;
        public String sentryFilter;
        public String sentryKey;

        public HyperKYCConfigs build() {
            return new HyperKYCConfigs(this.sentryKey, this.sentryEndPoint, this.sentryFilter, this.hyperKYCValueMap);
        }

        public HyperKYCConfigsBuilder hyperKYCValueMap(HashMap<String, String> hashMap) {
            this.hyperKYCValueMap = hashMap;
            return this;
        }

        public HyperKYCConfigsBuilder sentryEndPoint(String str) {
            this.sentryEndPoint = str;
            return this;
        }

        public HyperKYCConfigsBuilder sentryFilter(String str) {
            this.sentryFilter = str;
            return this;
        }

        public HyperKYCConfigsBuilder sentryKey(String str) {
            this.sentryKey = str;
            return this;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("HyperKYCConfigs.HyperKYCConfigsBuilder(sentryKey=");
            outline73.append(this.sentryKey);
            outline73.append(", sentryEndPoint=");
            outline73.append(this.sentryEndPoint);
            outline73.append(", sentryFilter=");
            outline73.append(this.sentryFilter);
            outline73.append(", hyperKYCValueMap=");
            outline73.append(this.hyperKYCValueMap);
            outline73.append(")");
            return outline73.toString();
        }
    }

    public HyperKYCConfigs(String str, String str2, String str3, HashMap<String, String> hashMap) {
        this.sentryKey = str;
        this.sentryEndPoint = str2;
        this.sentryFilter = str3;
        this.hyperKYCValueMap = hashMap;
    }

    public static HyperKYCConfigsBuilder builder() {
        return new HyperKYCConfigsBuilder();
    }

    public boolean canEqual(Object obj) {
        return obj instanceof HyperKYCConfigs;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HyperKYCConfigs)) {
            return false;
        }
        HyperKYCConfigs hyperKYCConfigs = (HyperKYCConfigs) obj;
        if (!hyperKYCConfigs.canEqual(this)) {
            return false;
        }
        String sentryKey2 = getSentryKey();
        String sentryKey3 = hyperKYCConfigs.getSentryKey();
        if (sentryKey2 != null ? !sentryKey2.equals(sentryKey3) : sentryKey3 != null) {
            return false;
        }
        String sentryEndPoint2 = getSentryEndPoint();
        String sentryEndPoint3 = hyperKYCConfigs.getSentryEndPoint();
        if (sentryEndPoint2 != null ? !sentryEndPoint2.equals(sentryEndPoint3) : sentryEndPoint3 != null) {
            return false;
        }
        String sentryFilter2 = getSentryFilter();
        String sentryFilter3 = hyperKYCConfigs.getSentryFilter();
        if (sentryFilter2 != null ? !sentryFilter2.equals(sentryFilter3) : sentryFilter3 != null) {
            return false;
        }
        HashMap<String, String> hyperKYCValueMap2 = getHyperKYCValueMap();
        HashMap<String, String> hyperKYCValueMap3 = hyperKYCConfigs.getHyperKYCValueMap();
        return hyperKYCValueMap2 != null ? hyperKYCValueMap2.equals(hyperKYCValueMap3) : hyperKYCValueMap3 == null;
    }

    public HashMap<String, String> getHyperKYCValueMap() {
        return this.hyperKYCValueMap;
    }

    public String getSentryEndPoint() {
        return this.sentryEndPoint;
    }

    public String getSentryFilter() {
        return this.sentryFilter;
    }

    public String getSentryKey() {
        return this.sentryKey;
    }

    public int hashCode() {
        String sentryKey2 = getSentryKey();
        int i = 43;
        int hashCode = sentryKey2 == null ? 43 : sentryKey2.hashCode();
        String sentryEndPoint2 = getSentryEndPoint();
        int hashCode2 = ((hashCode + 59) * 59) + (sentryEndPoint2 == null ? 43 : sentryEndPoint2.hashCode());
        String sentryFilter2 = getSentryFilter();
        int hashCode3 = (hashCode2 * 59) + (sentryFilter2 == null ? 43 : sentryFilter2.hashCode());
        HashMap<String, String> hyperKYCValueMap2 = getHyperKYCValueMap();
        int i2 = hashCode3 * 59;
        if (hyperKYCValueMap2 != null) {
            i = hyperKYCValueMap2.hashCode();
        }
        return i2 + i;
    }

    public void setHyperKYCValueMap(HashMap<String, String> hashMap) {
        this.hyperKYCValueMap = hashMap;
    }

    public void setSentryEndPoint(String str) {
        this.sentryEndPoint = str;
    }

    public void setSentryFilter(String str) {
        this.sentryFilter = str;
    }

    public void setSentryKey(String str) {
        this.sentryKey = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("HyperKYCConfigs(sentryKey=");
        outline73.append(getSentryKey());
        outline73.append(", sentryEndPoint=");
        outline73.append(getSentryEndPoint());
        outline73.append(", sentryFilter=");
        outline73.append(getSentryFilter());
        outline73.append(", hyperKYCValueMap=");
        outline73.append(getHyperKYCValueMap());
        outline73.append(")");
        return outline73.toString();
    }
}
