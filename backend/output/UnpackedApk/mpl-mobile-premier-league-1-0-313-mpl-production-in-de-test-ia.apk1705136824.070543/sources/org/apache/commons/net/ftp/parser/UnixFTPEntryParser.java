package org.apache.commons.net.ftp.parser;

import java.util.List;
import java.util.ListIterator;
import org.apache.commons.net.ftp.FTPClientConfig;

public class UnixFTPEntryParser extends ConfigurableFTPFileEntryParserImpl {
    static final String DEFAULT_DATE_FORMAT = "MMM d yyyy";
    static final String DEFAULT_RECENT_DATE_FORMAT = "MMM d HH:mm";
    public static final FTPClientConfig NUMERIC_DATE_CONFIG;
    static final String NUMERIC_DATE_FORMAT = "yyyy-MM-dd HH:mm";
    private static final String REGEX = "([bcdelfmpSs-])(((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-])))\\+?\\s*(\\d+)\\s+(?:(\\S+(?:\\s\\S+)*?)\\s+)?(?:(\\S+(?:\\s\\S+)*)\\s+)?(\\d+(?:,\\s*\\d+)?)\\s+((?:\\d+[-/]\\d+[-/]\\d+)|(?:\\S{3}\\s+\\d{1,2})|(?:\\d{1,2}\\s+\\S{3}))\\s+(\\d+(?::\\d+)?)\\s+(\\S*)(\\s*.*)";

    static {
        FTPClientConfig fTPClientConfig = new FTPClientConfig(FTPClientConfig.SYST_UNIX, NUMERIC_DATE_FORMAT, null, null, null, null);
        NUMERIC_DATE_CONFIG = fTPClientConfig;
    }

    public UnixFTPEntryParser() {
        this(null);
    }

    public UnixFTPEntryParser(FTPClientConfig fTPClientConfig) {
        super(REGEX);
        configure(fTPClientConfig);
    }

    public List<String> preParse(List<String> list) {
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().matches("^total \\d+$")) {
                listIterator.remove();
            }
        }
        return list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c9 A[SYNTHETIC, Splitter:B:27:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.commons.net.ftp.FTPFile parseFTPEntry(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r16
            org.apache.commons.net.ftp.FTPFile r1 = new org.apache.commons.net.ftp.FTPFile
            r1.<init>()
            r2 = r17
            r1.setRawListing(r2)
            boolean r2 = r16.matches(r17)
            if (r2 == 0) goto L_0x0117
            r2 = 1
            java.lang.String r3 = r0.group(r2)
            r4 = 15
            java.lang.String r4 = r0.group(r4)
            r5 = 16
            java.lang.String r5 = r0.group(r5)
            r6 = 17
            java.lang.String r6 = r0.group(r6)
            r7 = 18
            java.lang.String r7 = r0.group(r7)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r9 = 19
            java.lang.String r9 = r0.group(r9)
            r8.append(r9)
            java.lang.String r9 = " "
            r8.append(r9)
            r9 = 20
            java.lang.String r9 = r0.group(r9)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r9 = 21
            java.lang.String r9 = r0.group(r9)
            r10 = 22
            java.lang.String r10 = r0.group(r10)
            java.util.Calendar r8 = super.parseTimestamp(r8)     // Catch:{ ParseException -> 0x0062 }
            r1.setTimestamp(r8)     // Catch:{ ParseException -> 0x0062 }
        L_0x0062:
            r8 = 0
            char r3 = r3.charAt(r8)
            r11 = 45
            r12 = 3
            if (r3 == r11) goto L_0x007d
            r11 = 108(0x6c, float:1.51E-43)
            if (r3 == r11) goto L_0x0076
            switch(r3) {
                case 98: goto L_0x007a;
                case 99: goto L_0x007a;
                case 100: goto L_0x0078;
                case 101: goto L_0x0076;
                case 102: goto L_0x007d;
                default: goto L_0x0073;
            }
        L_0x0073:
            r3 = 3
        L_0x0074:
            r11 = 0
            goto L_0x007f
        L_0x0076:
            r3 = 2
            goto L_0x0074
        L_0x0078:
            r3 = 1
            goto L_0x0074
        L_0x007a:
            r3 = 0
            r11 = 1
            goto L_0x007f
        L_0x007d:
            r3 = 0
            goto L_0x0074
        L_0x007f:
            r1.setType(r3)
            r14 = 4
            r15 = 0
        L_0x0084:
            if (r15 >= r12) goto L_0x00c7
            java.lang.String r12 = r0.group(r14)
            java.lang.String r13 = "-"
            boolean r12 = r12.equals(r13)
            r12 = r12 ^ r2
            r1.setPermission(r15, r8, r12)
            int r12 = r14 + 1
            java.lang.String r12 = r0.group(r12)
            boolean r12 = r12.equals(r13)
            r12 = r12 ^ r2
            r1.setPermission(r15, r2, r12)
            int r12 = r14 + 2
            java.lang.String r12 = r0.group(r12)
            boolean r13 = r12.equals(r13)
            if (r13 != 0) goto L_0x00bd
            char r12 = r12.charAt(r8)
            boolean r12 = java.lang.Character.isUpperCase(r12)
            if (r12 != 0) goto L_0x00bd
            r12 = 2
            r1.setPermission(r15, r12, r2)
            goto L_0x00c1
        L_0x00bd:
            r12 = 2
            r1.setPermission(r15, r12, r8)
        L_0x00c1:
            int r15 = r15 + 1
            int r14 = r14 + 4
            r12 = 3
            goto L_0x0084
        L_0x00c7:
            if (r11 != 0) goto L_0x00d0
            int r2 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x00d0 }
            r1.setHardLinkCount(r2)     // Catch:{ NumberFormatException -> 0x00d0 }
        L_0x00d0:
            r1.setUser(r5)
            r1.setGroup(r6)
            long r4 = java.lang.Long.parseLong(r7)     // Catch:{ NumberFormatException -> 0x00dd }
            r1.setSize(r4)     // Catch:{ NumberFormatException -> 0x00dd }
        L_0x00dd:
            if (r10 != 0) goto L_0x00e3
            r1.setName(r9)
            goto L_0x0116
        L_0x00e3:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r9)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r4 = 2
            if (r3 != r4) goto L_0x0113
            java.lang.String r3 = " -> "
            int r3 = r2.indexOf(r3)
            r4 = -1
            if (r3 != r4) goto L_0x0102
            r1.setName(r2)
            goto L_0x0116
        L_0x0102:
            java.lang.String r4 = r2.substring(r8, r3)
            r1.setName(r4)
            r4 = 4
            int r3 = r3 + r4
            java.lang.String r2 = r2.substring(r3)
            r1.setLink(r2)
            goto L_0x0116
        L_0x0113:
            r1.setName(r2)
        L_0x0116:
            return r1
        L_0x0117:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.UnixFTPEntryParser.parseFTPEntry(java.lang.String):org.apache.commons.net.ftp.FTPFile");
    }

    /* access modifiers changed from: protected */
    public FTPClientConfig getDefaultConfiguration() {
        FTPClientConfig fTPClientConfig = new FTPClientConfig(FTPClientConfig.SYST_UNIX, "MMM d yyyy", "MMM d HH:mm", null, null, null);
        return fTPClientConfig;
    }
}
