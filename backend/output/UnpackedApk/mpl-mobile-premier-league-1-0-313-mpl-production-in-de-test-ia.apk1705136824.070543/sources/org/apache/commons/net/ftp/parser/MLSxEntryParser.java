package org.apache.commons.net.ftp.parser;

import com.mpl.androidapp.updater.util.UpdaterConstant.Response;
import in.juspay.hypersdk.core.InflateView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileEntryParserImpl;
import org.apache.fontbox.cmap.CMap;

public class MLSxEntryParser extends FTPFileEntryParserImpl {
    private static final MLSxEntryParser PARSER = new MLSxEntryParser();
    private static final HashMap<String, Integer> TYPE_TO_INT = new HashMap<>();
    private static int[] UNIX_GROUPS = {0, 1, 2};
    private static int[][] UNIX_PERMS = {new int[0], new int[]{2}, new int[]{1}, new int[]{2, 1}, new int[]{0}, new int[]{0, 2}, new int[]{0, 1}, new int[]{0, 1, 2}};

    static {
        TYPE_TO_INT.put("file", Integer.valueOf(0));
        HashMap<String, Integer> hashMap = TYPE_TO_INT;
        Integer valueOf = Integer.valueOf(1);
        hashMap.put("cdir", valueOf);
        TYPE_TO_INT.put("pdir", valueOf);
        TYPE_TO_INT.put("dir", valueOf);
    }

    public FTPFile parseFTPEntry(String str) {
        SimpleDateFormat simpleDateFormat;
        String str2 = str;
        int i = 2;
        String[] split = str2.split(CMap.SPACE, 2);
        if (split.length != 2) {
            return null;
        }
        FTPFile fTPFile = new FTPFile();
        fTPFile.setRawListing(str2);
        fTPFile.setName(split[1]);
        String[] split2 = split[0].split(";");
        boolean contains = split[0].toLowerCase(Locale.ENGLISH).contains("unix.mode=");
        int length = split2.length;
        int i2 = 0;
        while (i2 < length) {
            String[] split3 = split2[i2].split(InflateView.SETTER_EQUALS);
            if (split3.length == i) {
                String lowerCase = split3[0].toLowerCase(Locale.ENGLISH);
                String str3 = split3[1];
                String lowerCase2 = str3.toLowerCase(Locale.ENGLISH);
                if (Response.SIZE.equals(lowerCase)) {
                    fTPFile.setSize(Long.parseLong(str3));
                } else if ("sizd".equals(lowerCase)) {
                    fTPFile.setSize(Long.parseLong(str3));
                } else if ("modify".equals(lowerCase)) {
                    if (str3.contains(".")) {
                        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
                    } else {
                        simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                    }
                    TimeZone timeZone = TimeZone.getTimeZone("GMT");
                    simpleDateFormat.setTimeZone(timeZone);
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone);
                    try {
                        gregorianCalendar.setTime(simpleDateFormat.parse(str3));
                    } catch (ParseException unused) {
                    }
                    fTPFile.setTimestamp(gregorianCalendar);
                } else if ("type".equals(lowerCase)) {
                    Integer num = TYPE_TO_INT.get(lowerCase2);
                    if (num == null) {
                        fTPFile.setType(3);
                    } else {
                        fTPFile.setType(num.intValue());
                    }
                } else if (lowerCase.startsWith("unix.")) {
                    String lowerCase3 = lowerCase.substring(5).toLowerCase(Locale.ENGLISH);
                    if ("group".equals(lowerCase3)) {
                        fTPFile.setGroup(str3);
                    } else if ("owner".equals(lowerCase3)) {
                        fTPFile.setUser(str3);
                    } else if ("mode".equals(lowerCase3)) {
                        int length2 = str3.length() - 3;
                        for (int i3 = 0; i3 < 3; i3++) {
                            int charAt = str3.charAt(length2 + i3) - '0';
                            if (charAt >= 0 && charAt <= 7) {
                                for (int permission : UNIX_PERMS[charAt]) {
                                    fTPFile.setPermission(UNIX_GROUPS[i3], permission, true);
                                }
                            }
                        }
                    }
                } else if (!contains && "perm".equals(lowerCase)) {
                    doUnixPerms(fTPFile, lowerCase2);
                    i2++;
                    i = 2;
                }
            }
            i2++;
            i = 2;
        }
        return fTPFile;
    }

    private void doUnixPerms(FTPFile fTPFile, String str) {
        for (char c2 : str.toCharArray()) {
            if (c2 == 'a') {
                fTPFile.setPermission(0, 1, true);
            } else if (c2 == 'p') {
                fTPFile.setPermission(0, 1, true);
            } else if (c2 == 'r') {
                fTPFile.setPermission(0, 0, true);
            } else if (c2 == 'w') {
                fTPFile.setPermission(0, 1, true);
            } else if (c2 == 'l') {
                fTPFile.setPermission(0, 2, true);
            } else if (c2 != 'm') {
                switch (c2) {
                    case 'c':
                        fTPFile.setPermission(0, 1, true);
                        break;
                    case 'd':
                        fTPFile.setPermission(0, 1, true);
                        break;
                    case 'e':
                        fTPFile.setPermission(0, 0, true);
                        break;
                }
            } else {
                fTPFile.setPermission(0, 1, true);
            }
        }
    }

    public static FTPFile parseEntry(String str) {
        return PARSER.parseFTPEntry(str);
    }

    public static MLSxEntryParser getInstance() {
        return PARSER;
    }
}
