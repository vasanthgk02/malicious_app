package org.apache.commons.net.ftp.parser;

import org.apache.commons.net.ftp.Configurable;
import org.apache.commons.net.ftp.FTPClientConfig;

public class NTFTPEntryParser extends ConfigurableFTPFileEntryParserImpl {
    private static final String DEFAULT_DATE_FORMAT = "MM-dd-yy hh:mma";
    private static final String DEFAULT_DATE_FORMAT2 = "MM-dd-yy kk:mm";
    private static final String REGEX = "(\\S+)\\s+(\\S+)\\s+(?:(<DIR>)|([0-9]+))\\s+(\\S.*)";
    private final FTPTimestampParser timestampParser;

    public NTFTPEntryParser() {
        this(null);
    }

    public NTFTPEntryParser(FTPClientConfig fTPClientConfig) {
        super(REGEX);
        configure(fTPClientConfig);
        FTPClientConfig fTPClientConfig2 = new FTPClientConfig(FTPClientConfig.SYST_NT, DEFAULT_DATE_FORMAT2, null, null, null, null);
        fTPClientConfig2.setDefaultDateFormatStr(DEFAULT_DATE_FORMAT2);
        this.timestampParser = new FTPTimestampParserImpl();
        ((Configurable) this.timestampParser).configure(fTPClientConfig2);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.commons.net.ftp.FTPFile parseFTPEntry(java.lang.String r8) {
        /*
            r7 = this;
            org.apache.commons.net.ftp.FTPFile r0 = new org.apache.commons.net.ftp.FTPFile
            r0.<init>()
            r0.setRawListing(r8)
            boolean r8 = r7.matches(r8)
            r1 = 0
            if (r8 == 0) goto L_0x0084
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r2 = 1
            java.lang.String r3 = r7.group(r2)
            r8.append(r3)
            java.lang.String r3 = " "
            r8.append(r3)
            r3 = 2
            java.lang.String r3 = r7.group(r3)
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            r3 = 3
            java.lang.String r3 = r7.group(r3)
            r4 = 4
            java.lang.String r4 = r7.group(r4)
            r5 = 5
            java.lang.String r5 = r7.group(r5)
            java.util.Calendar r6 = super.parseTimestamp(r8)     // Catch:{ ParseException -> 0x0044 }
            r0.setTimestamp(r6)     // Catch:{ ParseException -> 0x0044 }
            goto L_0x004f
        L_0x0044:
            org.apache.commons.net.ftp.parser.FTPTimestampParser r6 = r7.timestampParser     // Catch:{ ParseException -> 0x004e }
            java.util.Calendar r8 = r6.parseTimestamp(r8)     // Catch:{ ParseException -> 0x004e }
            r0.setTimestamp(r8)     // Catch:{ ParseException -> 0x004e }
            goto L_0x004f
        L_0x004e:
        L_0x004f:
            if (r5 == 0) goto L_0x0084
            java.lang.String r8 = "."
            boolean r8 = r5.equals(r8)
            if (r8 != 0) goto L_0x0084
            java.lang.String r8 = ".."
            boolean r8 = r5.equals(r8)
            if (r8 == 0) goto L_0x0062
            goto L_0x0084
        L_0x0062:
            r0.setName(r5)
            java.lang.String r8 = "<DIR>"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0076
            r0.setType(r2)
            r1 = 0
            r0.setSize(r1)
            goto L_0x0083
        L_0x0076:
            r8 = 0
            r0.setType(r8)
            if (r4 == 0) goto L_0x0083
            long r1 = java.lang.Long.parseLong(r4)
            r0.setSize(r1)
        L_0x0083:
            return r0
        L_0x0084:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.NTFTPEntryParser.parseFTPEntry(java.lang.String):org.apache.commons.net.ftp.FTPFile");
    }

    public FTPClientConfig getDefaultConfiguration() {
        FTPClientConfig fTPClientConfig = new FTPClientConfig(FTPClientConfig.SYST_NT, DEFAULT_DATE_FORMAT, null, null, null, null);
        return fTPClientConfig;
    }
}
