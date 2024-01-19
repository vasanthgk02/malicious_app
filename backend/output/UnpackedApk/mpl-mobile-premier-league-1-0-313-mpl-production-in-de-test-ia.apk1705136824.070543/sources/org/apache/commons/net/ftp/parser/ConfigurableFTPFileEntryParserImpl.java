package org.apache.commons.net.ftp.parser;

import java.text.ParseException;
import java.util.Calendar;
import org.apache.commons.net.ftp.Configurable;
import org.apache.commons.net.ftp.FTPClientConfig;

public abstract class ConfigurableFTPFileEntryParserImpl extends RegexFTPFileEntryParserImpl implements Configurable {
    private final FTPTimestampParser timestampParser = new FTPTimestampParserImpl();

    /* access modifiers changed from: protected */
    public abstract FTPClientConfig getDefaultConfiguration();

    public ConfigurableFTPFileEntryParserImpl(String str) {
        super(str);
    }

    public Calendar parseTimestamp(String str) throws ParseException {
        return this.timestampParser.parseTimestamp(str);
    }

    public void configure(FTPClientConfig fTPClientConfig) {
        if (this.timestampParser instanceof Configurable) {
            FTPClientConfig defaultConfiguration = getDefaultConfiguration();
            if (fTPClientConfig != null) {
                if (fTPClientConfig.getDefaultDateFormatStr() == null) {
                    fTPClientConfig.setDefaultDateFormatStr(defaultConfiguration.getDefaultDateFormatStr());
                }
                if (fTPClientConfig.getRecentDateFormatStr() == null) {
                    fTPClientConfig.setRecentDateFormatStr(defaultConfiguration.getRecentDateFormatStr());
                }
                ((Configurable) this.timestampParser).configure(fTPClientConfig);
                return;
            }
            ((Configurable) this.timestampParser).configure(defaultConfiguration);
        }
    }
}
