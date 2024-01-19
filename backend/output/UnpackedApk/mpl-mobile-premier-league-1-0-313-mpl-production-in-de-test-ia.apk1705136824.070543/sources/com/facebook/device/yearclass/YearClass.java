package com.facebook.device.yearclass;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;

public class YearClass {
    public static volatile Integer mYearCategory;

    public static int categorizeByYear2016Method(Context context) {
        Context context2 = context;
        MemoryInfo memoryInfo = new MemoryInfo();
        ((ActivityManager) context2.getSystemService("activity")).getMemoryInfo(memoryInfo);
        long j = memoryInfo.totalMem;
        int i = 2014;
        int i2 = 2013;
        int i3 = 2011;
        if (j == -1) {
            ArrayList arrayList = new ArrayList();
            int numberOfCPUCores = DeviceInfo.getNumberOfCPUCores();
            int i4 = -1;
            conditionallyAdd(arrayList, numberOfCPUCores < 1 ? -1 : numberOfCPUCores == 1 ? 2008 : numberOfCPUCores <= 3 ? 2011 : 2012);
            long cPUMaxFreqKHz = (long) DeviceInfo.getCPUMaxFreqKHz();
            conditionallyAdd(arrayList, cPUMaxFreqKHz == -1 ? -1 : cPUMaxFreqKHz <= 528000 ? 2008 : cPUMaxFreqKHz <= 620000 ? 2009 : cPUMaxFreqKHz <= 1020000 ? 2010 : cPUMaxFreqKHz <= 1220000 ? 2011 : cPUMaxFreqKHz <= 1520000 ? 2012 : cPUMaxFreqKHz <= 2020000 ? 2013 : 2014);
            MemoryInfo memoryInfo2 = new MemoryInfo();
            ((ActivityManager) context2.getSystemService("activity")).getMemoryInfo(memoryInfo2);
            long j2 = memoryInfo2.totalMem;
            if (j2 <= 0) {
                i = -1;
            } else if (j2 <= 201326592) {
                i = 2008;
            } else if (j2 <= 304087040) {
                i = 2009;
            } else if (j2 <= 536870912) {
                i = 2010;
            } else if (j2 <= 1073741824) {
                i = 2011;
            } else if (j2 <= 1610612736) {
                i = 2012;
            } else if (j2 <= 2147483648L) {
                i = 2013;
            }
            conditionallyAdd(arrayList, i);
            if (!arrayList.isEmpty()) {
                Collections.sort(arrayList);
                if ((arrayList.size() & 1) == 1) {
                    i4 = ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
                } else {
                    int size = (arrayList.size() / 2) - 1;
                    i4 = ((((Integer) arrayList.get(size + 1)).intValue() - ((Integer) arrayList.get(size)).intValue()) / 2) + ((Integer) arrayList.get(size)).intValue();
                }
            }
            return i4;
        } else if (j <= 805306368) {
            return DeviceInfo.getNumberOfCPUCores() <= 1 ? 2009 : 2010;
        } else if (j <= 1073741824) {
            if (DeviceInfo.getCPUMaxFreqKHz() >= 1300000) {
                i3 = 2012;
            }
            return i3;
        } else if (j <= 1610612736) {
            if (DeviceInfo.getCPUMaxFreqKHz() < 1800000) {
                i2 = 2012;
            }
            return i2;
        } else if (j <= 2147483648L) {
            return 2013;
        } else {
            if (j <= 3221225472L) {
                return 2014;
            }
            return j <= 5368709120L ? 2015 : 2016;
        }
    }

    public static void conditionallyAdd(ArrayList<Integer> arrayList, int i) {
        if (i != -1) {
            arrayList.add(Integer.valueOf(i));
        }
    }
}
