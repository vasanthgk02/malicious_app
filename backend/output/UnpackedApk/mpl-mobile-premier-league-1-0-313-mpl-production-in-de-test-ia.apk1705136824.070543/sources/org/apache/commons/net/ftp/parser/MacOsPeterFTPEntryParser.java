package org.apache.commons.net.ftp.parser;

import org.apache.commons.net.ftp.FTPClientConfig;

public class MacOsPeterFTPEntryParser extends ConfigurableFTPFileEntryParserImpl {
    static final String DEFAULT_DATE_FORMAT = "MMM d yyyy";
    static final String DEFAULT_RECENT_DATE_FORMAT = "MMM d HH:mm";
    private static final String REGEX = "([bcdelfmpSs-])(((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-])))\\+?\\s+((folder\\s+)|((\\d+)\\s+(\\d+)\\s+))(\\d+)\\s+((?:\\d+[-/]\\d+[-/]\\d+)|(?:\\S{3}\\s+\\d{1,2})|(?:\\d{1,2}\\s+\\S{3}))\\s+(\\d+(?::\\d+)?)\\s+(\\S*)(\\s*.*)";

    public MacOsPeterFTPEntryParser() {
        this(null);
    }

    public MacOsPeterFTPEntryParser(FTPClientConfig fTPClientConfig) {
        super(REGEX);
        configure(fTPClientConfig);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b9 A[SYNTHETIC, Splitter:B:27:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d3  */
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
            r3 = 0
            if (r2 == 0) goto L_0x0106
            r2 = 1
            java.lang.String r4 = r0.group(r2)
            java.lang.String r5 = "0"
            r6 = 20
            java.lang.String r6 = r0.group(r6)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r8 = 21
            java.lang.String r8 = r0.group(r8)
            r7.append(r8)
            java.lang.String r8 = " "
            r7.append(r8)
            r8 = 22
            java.lang.String r8 = r0.group(r8)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r8 = 23
            java.lang.String r8 = r0.group(r8)
            r9 = 24
            java.lang.String r9 = r0.group(r9)
            java.util.Calendar r7 = super.parseTimestamp(r7)     // Catch:{ ParseException -> 0x0053 }
            r1.setTimestamp(r7)     // Catch:{ ParseException -> 0x0053 }
        L_0x0053:
            r7 = 0
            char r4 = r4.charAt(r7)
            r10 = 45
            r11 = 3
            r12 = 2
            if (r4 == r10) goto L_0x006f
            r10 = 108(0x6c, float:1.51E-43)
            if (r4 == r10) goto L_0x0068
            switch(r4) {
                case 98: goto L_0x006c;
                case 99: goto L_0x006c;
                case 100: goto L_0x006a;
                case 101: goto L_0x0068;
                case 102: goto L_0x006f;
                default: goto L_0x0065;
            }
        L_0x0065:
            r4 = 3
        L_0x0066:
            r10 = 0
            goto L_0x0071
        L_0x0068:
            r4 = 2
            goto L_0x0066
        L_0x006a:
            r4 = 1
            goto L_0x0066
        L_0x006c:
            r4 = 0
            r10 = 1
            goto L_0x0071
        L_0x006f:
            r4 = 0
            goto L_0x0066
        L_0x0071:
            r1.setType(r4)
            r14 = 0
            r15 = 4
        L_0x0076:
            if (r14 >= r11) goto L_0x00b7
            java.lang.String r11 = r0.group(r15)
            java.lang.String r13 = "-"
            boolean r11 = r11.equals(r13)
            r11 = r11 ^ r2
            r1.setPermission(r14, r7, r11)
            int r11 = r15 + 1
            java.lang.String r11 = r0.group(r11)
            boolean r11 = r11.equals(r13)
            r11 = r11 ^ r2
            r1.setPermission(r14, r2, r11)
            int r11 = r15 + 2
            java.lang.String r11 = r0.group(r11)
            boolean r13 = r11.equals(r13)
            if (r13 != 0) goto L_0x00ae
            char r11 = r11.charAt(r7)
            boolean r11 = java.lang.Character.isUpperCase(r11)
            if (r11 != 0) goto L_0x00ae
            r1.setPermission(r14, r12, r2)
            goto L_0x00b1
        L_0x00ae:
            r1.setPermission(r14, r12, r7)
        L_0x00b1:
            int r14 = r14 + 1
            int r15 = r15 + 4
            r11 = 3
            goto L_0x0076
        L_0x00b7:
            if (r10 != 0) goto L_0x00c0
            int r2 = java.lang.Integer.parseInt(r5)     // Catch:{ NumberFormatException -> 0x00c0 }
            r1.setHardLinkCount(r2)     // Catch:{ NumberFormatException -> 0x00c0 }
        L_0x00c0:
            r1.setUser(r3)
            r1.setGroup(r3)
            long r2 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x00cd }
            r1.setSize(r2)     // Catch:{ NumberFormatException -> 0x00cd }
        L_0x00cd:
            if (r9 != 0) goto L_0x00d3
            r1.setName(r8)
            goto L_0x0105
        L_0x00d3:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r8)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            if (r4 != r12) goto L_0x0102
            java.lang.String r3 = " -> "
            int r3 = r2.indexOf(r3)
            r4 = -1
            if (r3 != r4) goto L_0x00f1
            r1.setName(r2)
            goto L_0x0105
        L_0x00f1:
            java.lang.String r4 = r2.substring(r7, r3)
            r1.setName(r4)
            r4 = 4
            int r3 = r3 + r4
            java.lang.String r2 = r2.substring(r3)
            r1.setLink(r2)
            goto L_0x0105
        L_0x0102:
            r1.setName(r2)
        L_0x0105:
            return r1
        L_0x0106:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.MacOsPeterFTPEntryParser.parseFTPEntry(java.lang.String):org.apache.commons.net.ftp.FTPFile");
    }

    /* access modifiers changed from: protected */
    public FTPClientConfig getDefaultConfiguration() {
        FTPClientConfig fTPClientConfig = new FTPClientConfig(FTPClientConfig.SYST_UNIX, "MMM d yyyy", "MMM d HH:mm", null, null, null);
        return fTPClientConfig;
    }
}
