package org.apache.commons.net.ftp.parser;

import java.text.ParseException;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.fontbox.cmap.CMap;

public class OS2FTPEntryParser extends ConfigurableFTPFileEntryParserImpl {
    private static final String DEFAULT_DATE_FORMAT = "MM-dd-yy HH:mm";
    private static final String REGEX = "\\s*([0-9]+)\\s*(\\s+|[A-Z]+)\\s*(DIR|\\s+)\\s*(\\S+)\\s+(\\S+)\\s+(\\S.*)";

    public OS2FTPEntryParser() {
        this(null);
    }

    public OS2FTPEntryParser(FTPClientConfig fTPClientConfig) {
        super(REGEX);
        configure(fTPClientConfig);
    }

    public FTPFile parseFTPEntry(String str) {
        FTPFile fTPFile = new FTPFile();
        if (!matches(str)) {
            return null;
        }
        String group = group(1);
        String group2 = group(2);
        String group3 = group(3);
        String str2 = group(4) + CMap.SPACE + group(5);
        String group4 = group(6);
        try {
            fTPFile.setTimestamp(super.parseTimestamp(str2));
        } catch (ParseException unused) {
        }
        if (group3.trim().equals("DIR") || group2.trim().equals("DIR")) {
            fTPFile.setType(1);
        } else {
            fTPFile.setType(0);
        }
        fTPFile.setName(group4.trim());
        fTPFile.setSize(Long.parseLong(group.trim()));
        return fTPFile;
    }

    /* access modifiers changed from: protected */
    public FTPClientConfig getDefaultConfiguration() {
        FTPClientConfig fTPClientConfig = new FTPClientConfig("OS/2", DEFAULT_DATE_FORMAT, null, null, null, null);
        return fTPClientConfig;
    }
}
