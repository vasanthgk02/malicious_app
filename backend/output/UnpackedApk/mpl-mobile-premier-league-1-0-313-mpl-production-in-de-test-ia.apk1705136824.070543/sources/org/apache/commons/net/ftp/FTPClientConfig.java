package org.apache.commons.net.ftp;

import com.mpl.androidapp.imagepicker.HyperVergeKycCapture;
import java.text.DateFormatSymbols;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import sfs2x.client.requests.FindRoomsRequest;
import sfs2x.client.requests.game.JoinRoomInvitationRequest;

public class FTPClientConfig {
    private static final Map<String, Object> LANGUAGE_CODE_MAP = new TreeMap();
    public static final String SYST_AS400 = "AS/400";
    public static final String SYST_L8 = "TYPE: L8";
    public static final String SYST_MACOS_PETER = "MACOS PETER";
    public static final String SYST_MVS = "MVS";
    public static final String SYST_NETWARE = "NETWARE";
    public static final String SYST_NT = "WINDOWS";
    public static final String SYST_OS2 = "OS/2";
    public static final String SYST_OS400 = "OS/400";
    public static final String SYST_UNIX = "UNIX";
    public static final String SYST_VMS = "VMS";
    private String defaultDateFormatStr;
    private boolean lenientFutureDates;
    private String recentDateFormatStr;
    private String serverLanguageCode;
    private final String serverSystemKey;
    private String serverTimeZoneId;
    private String shortMonthNames;

    public FTPClientConfig(String str) {
        this.defaultDateFormatStr = null;
        this.recentDateFormatStr = null;
        this.lenientFutureDates = true;
        this.serverLanguageCode = null;
        this.shortMonthNames = null;
        this.serverTimeZoneId = null;
        this.serverSystemKey = str;
    }

    public FTPClientConfig() {
        this(SYST_UNIX);
    }

    public FTPClientConfig(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str);
        this.defaultDateFormatStr = str2;
        this.recentDateFormatStr = str3;
        this.serverLanguageCode = str4;
        this.shortMonthNames = str5;
        this.serverTimeZoneId = str6;
    }

    static {
        LANGUAGE_CODE_MAP.put(HyperVergeKycCapture.EN, Locale.ENGLISH);
        LANGUAGE_CODE_MAP.put("de", Locale.GERMAN);
        LANGUAGE_CODE_MAP.put("it", Locale.ITALIAN);
        LANGUAGE_CODE_MAP.put(JoinRoomInvitationRequest.KEY_EXPIRY_SECONDS, new Locale(JoinRoomInvitationRequest.KEY_EXPIRY_SECONDS, "", ""));
        LANGUAGE_CODE_MAP.put("pt", new Locale("pt", "", ""));
        LANGUAGE_CODE_MAP.put("da", new Locale("da", "", ""));
        LANGUAGE_CODE_MAP.put("sv", new Locale("sv", "", ""));
        LANGUAGE_CODE_MAP.put("no", new Locale("no", "", ""));
        LANGUAGE_CODE_MAP.put("nl", new Locale("nl", "", ""));
        LANGUAGE_CODE_MAP.put("ro", new Locale("ro", "", ""));
        LANGUAGE_CODE_MAP.put("sq", new Locale("sq", "", ""));
        LANGUAGE_CODE_MAP.put("sh", new Locale("sh", "", ""));
        LANGUAGE_CODE_MAP.put("sk", new Locale("sk", "", ""));
        LANGUAGE_CODE_MAP.put("sl", new Locale("sl", "", ""));
        LANGUAGE_CODE_MAP.put(FindRoomsRequest.KEY_FILTERED_ROOMS, "jan|fév|mar|avr|mai|jun|jui|aoû|sep|oct|nov|déc");
    }

    public String getServerSystemKey() {
        return this.serverSystemKey;
    }

    public String getDefaultDateFormatStr() {
        return this.defaultDateFormatStr;
    }

    public String getRecentDateFormatStr() {
        return this.recentDateFormatStr;
    }

    public String getServerTimeZoneId() {
        return this.serverTimeZoneId;
    }

    public String getShortMonthNames() {
        return this.shortMonthNames;
    }

    public String getServerLanguageCode() {
        return this.serverLanguageCode;
    }

    public boolean isLenientFutureDates() {
        return this.lenientFutureDates;
    }

    public void setDefaultDateFormatStr(String str) {
        this.defaultDateFormatStr = str;
    }

    public void setRecentDateFormatStr(String str) {
        this.recentDateFormatStr = str;
    }

    public void setLenientFutureDates(boolean z) {
        this.lenientFutureDates = z;
    }

    public void setServerTimeZoneId(String str) {
        this.serverTimeZoneId = str;
    }

    public void setShortMonthNames(String str) {
        this.shortMonthNames = str;
    }

    public void setServerLanguageCode(String str) {
        this.serverLanguageCode = str;
    }

    public static DateFormatSymbols lookupDateFormatSymbols(String str) {
        Object obj = LANGUAGE_CODE_MAP.get(str);
        if (obj != null) {
            if (obj instanceof Locale) {
                return new DateFormatSymbols((Locale) obj);
            }
            if (obj instanceof String) {
                return getDateFormatSymbols((String) obj);
            }
        }
        return new DateFormatSymbols(Locale.US);
    }

    public static DateFormatSymbols getDateFormatSymbols(String str) {
        String[] splitShortMonthString = splitShortMonthString(str);
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(Locale.US);
        dateFormatSymbols.setShortMonths(splitShortMonthString);
        return dateFormatSymbols;
    }

    private static String[] splitShortMonthString(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
        if (12 == stringTokenizer.countTokens()) {
            String[] strArr = new String[13];
            int i = 0;
            while (stringTokenizer.hasMoreTokens()) {
                strArr[i] = stringTokenizer.nextToken();
                i++;
            }
            strArr[i] = "";
            return strArr;
        }
        throw new IllegalArgumentException("expecting a pipe-delimited string containing 12 tokens");
    }

    public static Collection<String> getSupportedLanguageCodes() {
        return LANGUAGE_CODE_MAP.keySet();
    }
}
