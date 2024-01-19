package org.apache.commons.net.ftp.parser;

import java.util.regex.Pattern;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFileEntryParser;

public class DefaultFTPFileEntryParserFactory implements FTPFileEntryParserFactory {
    private static final String JAVA_IDENTIFIER = "\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*";
    private static final String JAVA_QUALIFIED_NAME = "(\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*\\.)+\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*";
    private static final Pattern JAVA_QUALIFIED_NAME_PATTERN = Pattern.compile(JAVA_QUALIFIED_NAME);

    public FTPFileEntryParser createFileEntryParser(String str) {
        if (str != null) {
            return createFileEntryParser(str, null);
        }
        throw new ParserInitializationException("Parser key cannot be null");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.commons.net.ftp.FTPFileEntryParser createFileEntryParser(java.lang.String r5, org.apache.commons.net.ftp.FTPClientConfig r6) {
        /*
            r4 = this;
            java.lang.String r0 = "Error initializing parser"
            java.util.regex.Pattern r1 = JAVA_QUALIFIED_NAME_PATTERN
            java.util.regex.Matcher r1 = r1.matcher(r5)
            boolean r1 = r1.matches()
            if (r1 == 0) goto L_0x0048
            java.lang.Class r1 = java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException -> 0x0048 }
            java.lang.Object r2 = r1.newInstance()     // Catch:{ ClassCastException -> 0x0027, Exception -> 0x0020, ExceptionInInitializerError -> 0x0019 }
            org.apache.commons.net.ftp.FTPFileEntryParser r2 = (org.apache.commons.net.ftp.FTPFileEntryParser) r2     // Catch:{ ClassCastException -> 0x0027, Exception -> 0x0020, ExceptionInInitializerError -> 0x0019 }
            goto L_0x0049
        L_0x0019:
            r1 = move-exception
            org.apache.commons.net.ftp.parser.ParserInitializationException r2 = new org.apache.commons.net.ftp.parser.ParserInitializationException     // Catch:{ ClassNotFoundException -> 0x0048 }
            r2.<init>(r0, r1)     // Catch:{ ClassNotFoundException -> 0x0048 }
            throw r2     // Catch:{ ClassNotFoundException -> 0x0048 }
        L_0x0020:
            r1 = move-exception
            org.apache.commons.net.ftp.parser.ParserInitializationException r2 = new org.apache.commons.net.ftp.parser.ParserInitializationException     // Catch:{ ClassNotFoundException -> 0x0048 }
            r2.<init>(r0, r1)     // Catch:{ ClassNotFoundException -> 0x0048 }
            throw r2     // Catch:{ ClassNotFoundException -> 0x0048 }
        L_0x0027:
            r0 = move-exception
            org.apache.commons.net.ftp.parser.ParserInitializationException r2 = new org.apache.commons.net.ftp.parser.ParserInitializationException     // Catch:{ ClassNotFoundException -> 0x0048 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0048 }
            r3.<init>()     // Catch:{ ClassNotFoundException -> 0x0048 }
            java.lang.String r1 = r1.getName()     // Catch:{ ClassNotFoundException -> 0x0048 }
            r3.append(r1)     // Catch:{ ClassNotFoundException -> 0x0048 }
            java.lang.String r1 = " does not implement the interface "
            r3.append(r1)     // Catch:{ ClassNotFoundException -> 0x0048 }
            java.lang.String r1 = "org.apache.commons.net.ftp.FTPFileEntryParser."
            r3.append(r1)     // Catch:{ ClassNotFoundException -> 0x0048 }
            java.lang.String r1 = r3.toString()     // Catch:{ ClassNotFoundException -> 0x0048 }
            r2.<init>(r1, r0)     // Catch:{ ClassNotFoundException -> 0x0048 }
            throw r2     // Catch:{ ClassNotFoundException -> 0x0048 }
        L_0x0048:
            r2 = 0
        L_0x0049:
            if (r2 != 0) goto L_0x00ef
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r0 = r5.toUpperCase(r0)
            java.lang.String r1 = "UNIX"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x0060
            org.apache.commons.net.ftp.parser.UnixFTPEntryParser r2 = new org.apache.commons.net.ftp.parser.UnixFTPEntryParser
            r2.<init>(r6)
            goto L_0x00ef
        L_0x0060:
            java.lang.String r1 = "VMS"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x006f
            org.apache.commons.net.ftp.parser.VMSVersioningFTPEntryParser r2 = new org.apache.commons.net.ftp.parser.VMSVersioningFTPEntryParser
            r2.<init>(r6)
            goto L_0x00ef
        L_0x006f:
            java.lang.String r1 = "WINDOWS"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x007d
            org.apache.commons.net.ftp.FTPFileEntryParser r2 = r4.createNTFTPEntryParser(r6)
            goto L_0x00ef
        L_0x007d:
            java.lang.String r1 = "OS/2"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x008b
            org.apache.commons.net.ftp.parser.OS2FTPEntryParser r2 = new org.apache.commons.net.ftp.parser.OS2FTPEntryParser
            r2.<init>(r6)
            goto L_0x00ef
        L_0x008b:
            java.lang.String r1 = "OS/400"
            int r1 = r0.indexOf(r1)
            if (r1 >= 0) goto L_0x00eb
            java.lang.String r1 = "AS/400"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x009c
            goto L_0x00eb
        L_0x009c:
            java.lang.String r1 = "MVS"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x00aa
            org.apache.commons.net.ftp.parser.MVSFTPEntryParser r2 = new org.apache.commons.net.ftp.parser.MVSFTPEntryParser
            r2.<init>()
            goto L_0x00ef
        L_0x00aa:
            java.lang.String r1 = "NETWARE"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x00b8
            org.apache.commons.net.ftp.parser.NetwareFTPEntryParser r2 = new org.apache.commons.net.ftp.parser.NetwareFTPEntryParser
            r2.<init>(r6)
            goto L_0x00ef
        L_0x00b8:
            java.lang.String r1 = "MACOS PETER"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x00c6
            org.apache.commons.net.ftp.parser.MacOsPeterFTPEntryParser r2 = new org.apache.commons.net.ftp.parser.MacOsPeterFTPEntryParser
            r2.<init>(r6)
            goto L_0x00ef
        L_0x00c6:
            java.lang.String r1 = "TYPE: L8"
            int r0 = r0.indexOf(r1)
            if (r0 < 0) goto L_0x00d4
            org.apache.commons.net.ftp.parser.UnixFTPEntryParser r2 = new org.apache.commons.net.ftp.parser.UnixFTPEntryParser
            r2.<init>(r6)
            goto L_0x00ef
        L_0x00d4:
            org.apache.commons.net.ftp.parser.ParserInitializationException r6 = new org.apache.commons.net.ftp.parser.ParserInitializationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown parser type: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.<init>(r5)
            throw r6
        L_0x00eb:
            org.apache.commons.net.ftp.FTPFileEntryParser r2 = r4.createOS400FTPEntryParser(r6)
        L_0x00ef:
            boolean r5 = r2 instanceof org.apache.commons.net.ftp.Configurable
            if (r5 == 0) goto L_0x00f9
            r5 = r2
            org.apache.commons.net.ftp.Configurable r5 = (org.apache.commons.net.ftp.Configurable) r5
            r5.configure(r6)
        L_0x00f9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.DefaultFTPFileEntryParserFactory.createFileEntryParser(java.lang.String, org.apache.commons.net.ftp.FTPClientConfig):org.apache.commons.net.ftp.FTPFileEntryParser");
    }

    public FTPFileEntryParser createFileEntryParser(FTPClientConfig fTPClientConfig) throws ParserInitializationException {
        return createFileEntryParser(fTPClientConfig.getServerSystemKey(), fTPClientConfig);
    }

    public FTPFileEntryParser createUnixFTPEntryParser() {
        return new UnixFTPEntryParser();
    }

    public FTPFileEntryParser createVMSVersioningFTPEntryParser() {
        return new VMSVersioningFTPEntryParser();
    }

    public FTPFileEntryParser createNetwareFTPEntryParser() {
        return new NetwareFTPEntryParser();
    }

    public FTPFileEntryParser createNTFTPEntryParser() {
        return createNTFTPEntryParser(null);
    }

    private FTPFileEntryParser createNTFTPEntryParser(FTPClientConfig fTPClientConfig) {
        if (fTPClientConfig != null && FTPClientConfig.SYST_NT.equals(fTPClientConfig.getServerSystemKey())) {
            return new NTFTPEntryParser(fTPClientConfig);
        }
        return new CompositeFileEntryParser(new FTPFileEntryParser[]{new NTFTPEntryParser(fTPClientConfig), new UnixFTPEntryParser(fTPClientConfig)});
    }

    public FTPFileEntryParser createOS2FTPEntryParser() {
        return new OS2FTPEntryParser();
    }

    public FTPFileEntryParser createOS400FTPEntryParser() {
        return createOS400FTPEntryParser(null);
    }

    private FTPFileEntryParser createOS400FTPEntryParser(FTPClientConfig fTPClientConfig) {
        if (fTPClientConfig != null && FTPClientConfig.SYST_OS400.equals(fTPClientConfig.getServerSystemKey())) {
            return new OS400FTPEntryParser(fTPClientConfig);
        }
        return new CompositeFileEntryParser(new FTPFileEntryParser[]{new OS400FTPEntryParser(fTPClientConfig), new UnixFTPEntryParser(fTPClientConfig)});
    }

    public FTPFileEntryParser createMVSEntryParser() {
        return new MVSFTPEntryParser();
    }
}
