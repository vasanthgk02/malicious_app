package com.facebook.device.yearclass;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;

public class DeviceInfo {
    public static final FileFilter CPU_FILTER = new FileFilter() {
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i = 3; i < name.length(); i++) {
                if (!Character.isDigit(name.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    };

    public static int extractValue(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            if (Character.isDigit(bArr[i])) {
                int i2 = i + 1;
                while (i2 < bArr.length && Character.isDigit(bArr[i2])) {
                    i2++;
                }
                return Integer.parseInt(new String(bArr, 0, i, i2 - i));
            }
            i++;
        }
        return -1;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0062 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCPUMaxFreqKHz() {
        /*
            r0 = 0
            r1 = -1
            r2 = 0
            r3 = -1
        L_0x0004:
            int r4 = getNumberOfCPUCores()     // Catch:{ IOException -> 0x008c }
            if (r2 >= r4) goto L_0x006e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008c }
            r4.<init>()     // Catch:{ IOException -> 0x008c }
            java.lang.String r5 = "/sys/devices/system/cpu/cpu"
            r4.append(r5)     // Catch:{ IOException -> 0x008c }
            r4.append(r2)     // Catch:{ IOException -> 0x008c }
            java.lang.String r5 = "/cpufreq/cpuinfo_max_freq"
            r4.append(r5)     // Catch:{ IOException -> 0x008c }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x008c }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x008c }
            r5.<init>(r4)     // Catch:{ IOException -> 0x008c }
            boolean r4 = r5.exists()     // Catch:{ IOException -> 0x008c }
            if (r4 == 0) goto L_0x006b
            boolean r4 = r5.canRead()     // Catch:{ IOException -> 0x008c }
            if (r4 == 0) goto L_0x006b
            r4 = 128(0x80, float:1.8E-43)
            byte[] r6 = new byte[r4]     // Catch:{ IOException -> 0x008c }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x008c }
            r7.<init>(r5)     // Catch:{ IOException -> 0x008c }
            r7.read(r6)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            r5 = 0
        L_0x003e:
            byte r8 = r6[r5]     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            boolean r8 = java.lang.Character.isDigit(r8)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            if (r8 == 0) goto L_0x004b
            if (r5 >= r4) goto L_0x004b
            int r5 = r5 + 1
            goto L_0x003e
        L_0x004b:
            java.lang.String r4 = new java.lang.String     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            r4.<init>(r6, r0, r5)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            int r5 = r4.intValue()     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
            if (r5 <= r3) goto L_0x0062
            int r3 = r4.intValue()     // Catch:{ NumberFormatException -> 0x0062, all -> 0x0066 }
        L_0x0062:
            r7.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x006b
        L_0x0066:
            r0 = move-exception
            r7.close()     // Catch:{ IOException -> 0x008c }
            throw r0     // Catch:{ IOException -> 0x008c }
        L_0x006b:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x006e:
            if (r3 != r1) goto L_0x008b
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x008c }
            java.lang.String r2 = "/proc/cpuinfo"
            r0.<init>(r2)     // Catch:{ IOException -> 0x008c }
            java.lang.String r2 = "cpu MHz"
            int r2 = parseFileForValue(r2, r0)     // Catch:{ all -> 0x0086 }
            int r2 = r2 * 1000
            if (r2 <= r3) goto L_0x0082
            r3 = r2
        L_0x0082:
            r0.close()     // Catch:{ IOException -> 0x008c }
            goto L_0x008b
        L_0x0086:
            r2 = move-exception
            r0.close()     // Catch:{ IOException -> 0x008c }
            throw r2     // Catch:{ IOException -> 0x008c }
        L_0x008b:
            r1 = r3
        L_0x008c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.yearclass.DeviceInfo.getCPUMaxFreqKHz():int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003e A[SYNTHETIC, Splitter:B:21:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0045 A[SYNTHETIC, Splitter:B:27:0x0045] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCoresFromFileInfo(java.lang.String r3) {
        /*
            r0 = -1
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0042, all -> 0x003b }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0042, all -> 0x003b }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0039, all -> 0x0036 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0039, all -> 0x0036 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0039, all -> 0x0036 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0039, all -> 0x0036 }
            java.lang.String r1 = r3.readLine()     // Catch:{ IOException -> 0x0039, all -> 0x0036 }
            r3.close()     // Catch:{ IOException -> 0x0039, all -> 0x0036 }
            if (r1 == 0) goto L_0x0032
            java.lang.String r3 = "0-[\\d]+$"
            boolean r3 = r1.matches(r3)     // Catch:{ IOException -> 0x0039, all -> 0x0036 }
            if (r3 != 0) goto L_0x0023
            goto L_0x0032
        L_0x0023:
            r3 = 2
            java.lang.String r3 = r1.substring(r3)     // Catch:{ IOException -> 0x0039, all -> 0x0036 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x0039, all -> 0x0036 }
            int r3 = r3.intValue()     // Catch:{ IOException -> 0x0039, all -> 0x0036 }
            int r0 = r3 + 1
        L_0x0032:
            r2.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0035:
            return r0
        L_0x0036:
            r3 = move-exception
            r1 = r2
            goto L_0x003c
        L_0x0039:
            r1 = r2
            goto L_0x0043
        L_0x003b:
            r3 = move-exception
        L_0x003c:
            if (r1 == 0) goto L_0x0041
            r1.close()     // Catch:{ IOException -> 0x0041 }
        L_0x0041:
            throw r3
        L_0x0042:
        L_0x0043:
            if (r1 == 0) goto L_0x0048
            r1.close()     // Catch:{ IOException -> 0x0048 }
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.device.yearclass.DeviceInfo.getCoresFromFileInfo(java.lang.String):int");
    }

    public static int getNumberOfCPUCores() {
        try {
            int coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/possible");
            if (coresFromFileInfo == -1) {
                coresFromFileInfo = getCoresFromFileInfo("/sys/devices/system/cpu/present");
            }
            return coresFromFileInfo == -1 ? new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length : coresFromFileInfo;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    public static int parseFileForValue(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i = 0;
            while (i < read) {
                if (bArr[i] == 10 || i == 0) {
                    if (bArr[i] == 10) {
                        i++;
                    }
                    int i2 = i;
                    while (true) {
                        if (i2 >= read) {
                            continue;
                            break;
                        }
                        int i3 = i2 - i;
                        if (bArr[i2] != str.charAt(i3)) {
                            break;
                        } else if (i3 == str.length() - 1) {
                            return extractValue(bArr, i2);
                        } else {
                            i2++;
                        }
                    }
                }
                i++;
            }
        } catch (IOException | NumberFormatException unused) {
        }
        return -1;
    }
}
