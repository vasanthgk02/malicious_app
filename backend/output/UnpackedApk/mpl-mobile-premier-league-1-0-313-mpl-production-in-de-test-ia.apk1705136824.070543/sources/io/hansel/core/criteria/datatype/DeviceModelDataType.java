package io.hansel.core.criteria.datatype;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import io.hansel.core.criteria.b;
import io.hansel.core.filters.HSLFiltersInternal;
import io.hansel.core.json.CoreJSONObject;
import java.io.Serializable;
import java.util.ArrayList;

public class DeviceModelDataType extends b implements Serializable {
    private String[] getDeviceManufacturer(String str) {
        String[] split = str.split(HSLCriteriaBuilder.DIFF_CHAR);
        String str2 = null;
        String str3 = !split[0].isEmpty() ? split[0] : null;
        if (split.length > 1 && !split[1].isEmpty()) {
            str2 = split[1];
        }
        return new String[]{str2, str3};
    }

    public boolean equal(Object obj, String str) {
        if (!(obj instanceof ArrayList)) {
            return false;
        }
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return false;
        }
        String[] deviceManufacturer = getDeviceManufacturer(((CoreJSONObject) arrayList.get(0)).optString("id"));
        String str2 = deviceManufacturer[0];
        String str3 = deviceManufacturer[1];
        return (str2 != null ? str2.equalsIgnoreCase(HSLFiltersInternal.getInstance().getString("device")) : true) && (str3 != null ? str3.equalsIgnoreCase(HSLFiltersInternal.getInstance().getString("manufacturer")) : true);
    }

    public boolean in(Object obj, String str) {
        if (!(obj instanceof ArrayList)) {
            return false;
        }
        ArrayList arrayList = (ArrayList) obj;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String[] deviceManufacturer = getDeviceManufacturer(((CoreJSONObject) arrayList.get(i)).optString("id"));
            String str2 = deviceManufacturer[0];
            String str3 = deviceManufacturer[1];
            if (str2 != null) {
                arrayList2.add(str2.toLowerCase());
            }
            if (str3 != null) {
                arrayList3.add(str3.toLowerCase());
            }
        }
        return (!arrayList2.isEmpty() ? arrayList2.contains(HSLFiltersInternal.getInstance().getString("device").toLowerCase()) : true) && (!arrayList3.isEmpty() ? arrayList3.contains(HSLFiltersInternal.getInstance().getString("manufacturer").toLowerCase()) : true);
    }

    public boolean notEqual(Object obj, String str) {
        if (!(obj instanceof ArrayList)) {
            return false;
        }
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return false;
        }
        String[] deviceManufacturer = getDeviceManufacturer(((CoreJSONObject) arrayList.get(0)).optString("id"));
        String str2 = deviceManufacturer[0];
        String str3 = deviceManufacturer[1];
        return (str2 != null ? str2.equalsIgnoreCase(HSLFiltersInternal.getInstance().getString("device")) ^ true : true) && (str3 != null ? str3.equalsIgnoreCase(HSLFiltersInternal.getInstance().getString("manufacturer")) ^ true : true);
    }

    public boolean notIn(Object obj, String str) {
        if (!(obj instanceof ArrayList)) {
            return false;
        }
        ArrayList arrayList = (ArrayList) obj;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String[] deviceManufacturer = getDeviceManufacturer(((CoreJSONObject) arrayList.get(i)).optString("id"));
            String str2 = deviceManufacturer[0];
            String str3 = deviceManufacturer[1];
            if (str2 != null) {
                arrayList2.add(str2.toLowerCase());
            }
            if (str3 != null) {
                arrayList3.add(str3.toLowerCase());
            }
        }
        return (!arrayList2.isEmpty() ? arrayList2.contains(HSLFiltersInternal.getInstance().getString("device").toLowerCase()) ^ true : true) && (!arrayList3.isEmpty() ? arrayList3.contains(HSLFiltersInternal.getInstance().getString("manufacturer").toLowerCase()) ^ true : true);
    }
}
