package org.jboss.netty.handler.codec.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CookieDecoder {
    public static final String COMMA = ",";
    public static final Pattern PATTERN = Pattern.compile("(?:\\s|[;,])*\\$*([^;=]+)(?:=(?:[\"']((?:\\\\.|[^\"])*)[\"']|([^;,]*)))?(\\s*(?:[;,]+\\s*|$))");

    private String decodeValue(String str) {
        return str == null ? str : str.replace("\\\"", "\"").replace("\\\\", "\\");
    }

    private void extractKeyValuePairs(String str, List<String> list, List<String> list2) {
        Matcher matcher = PATTERN.matcher(str);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (matcher.find(i)) {
            i = matcher.end();
            String group = matcher.group(1);
            String group2 = matcher.group(3);
            if (group2 == null) {
                group2 = decodeValue(matcher.group(2));
            }
            String group3 = matcher.group(4);
            if (str2 == null) {
                if (group2 == null) {
                    group2 = "";
                }
            } else if (group2 != null || CookieHeaderNames.DISCARD.equalsIgnoreCase(group) || CookieHeaderNames.SECURE.equalsIgnoreCase(group) || CookieHeaderNames.HTTPONLY.equalsIgnoreCase(group)) {
                list.add(str2);
                list2.add(str3);
            } else {
                str3 = GeneratedOutlineSupport.outline52(str3, str4, group);
                str4 = group3;
            }
            str2 = group;
            str3 = group2;
            str4 = group3;
        }
        if (str2 != null) {
            list.add(str2);
            list2.add(str3);
        }
    }

    public Set<Cookie> decode(String str) {
        int i;
        int i2;
        ArrayList arrayList;
        ArrayList arrayList2;
        String str2;
        String str3;
        int i3;
        ArrayList arrayList3 = new ArrayList(8);
        ArrayList arrayList4 = new ArrayList(8);
        extractKeyValuePairs(str, arrayList3, arrayList4);
        if (arrayList3.isEmpty()) {
            return Collections.emptySet();
        }
        if (((String) arrayList3.get(0)).equalsIgnoreCase("Version")) {
            try {
                i2 = Integer.parseInt((String) arrayList4.get(0));
            } catch (NumberFormatException unused) {
                i2 = 0;
            }
            i = 1;
        } else {
            i2 = 0;
            i = 0;
        }
        if (arrayList3.size() <= i) {
            return Collections.emptySet();
        }
        TreeSet treeSet = new TreeSet();
        while (i < arrayList3.size()) {
            String str4 = (String) arrayList3.get(i);
            String str5 = (String) arrayList4.get(i);
            if (str5 == null) {
                str5 = "";
            }
            DefaultCookie defaultCookie = new DefaultCookie(str4, str5);
            treeSet.add(defaultCookie);
            int i4 = -1;
            ArrayList arrayList5 = new ArrayList(2);
            int i5 = i + 1;
            String str6 = null;
            TreeSet treeSet2 = treeSet;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            while (true) {
                if (i5 >= arrayList3.size()) {
                    arrayList = arrayList3;
                    arrayList2 = arrayList4;
                    str2 = str6;
                    str3 = str8;
                    break;
                }
                String str10 = (String) arrayList3.get(i5);
                arrayList = arrayList3;
                String str11 = (String) arrayList4.get(i5);
                arrayList2 = arrayList4;
                if (CookieHeaderNames.DISCARD.equalsIgnoreCase(str10)) {
                    z3 = true;
                } else if (CookieHeaderNames.SECURE.equalsIgnoreCase(str10)) {
                    z2 = true;
                } else if (CookieHeaderNames.HTTPONLY.equalsIgnoreCase(str10)) {
                    z = true;
                } else if ("Comment".equalsIgnoreCase(str10)) {
                    str6 = str11;
                } else if (CookieHeaderNames.COMMENTURL.equalsIgnoreCase(str10)) {
                    str8 = str11;
                } else if (CookieHeaderNames.DOMAIN.equalsIgnoreCase(str10)) {
                    str9 = str11;
                } else if (CookieHeaderNames.PATH.equalsIgnoreCase(str10)) {
                    str7 = str11;
                } else {
                    if ("Expires".equalsIgnoreCase(str10)) {
                        try {
                            long time = new CookieDateFormat().parse(str11).getTime() - System.currentTimeMillis();
                            if (time <= 0) {
                                str2 = str6;
                                str3 = str8;
                                i3 = 0;
                            } else {
                                str2 = str6;
                                str3 = str8;
                                try {
                                    i3 = ((int) (time / 1000)) + (time % 1000 != 0 ? 1 : 0);
                                } catch (ParseException unused2) {
                                }
                            }
                        } catch (ParseException unused3) {
                            str2 = str6;
                            str3 = str8;
                        }
                    } else {
                        str2 = str6;
                        str3 = str8;
                        if (CookieHeaderNames.MAX_AGE.equalsIgnoreCase(str10)) {
                            i3 = Integer.parseInt(str11);
                        } else {
                            if (!"Version".equalsIgnoreCase(str10)) {
                                if (!CookieHeaderNames.PORT.equalsIgnoreCase(str10)) {
                                    break;
                                }
                                for (String valueOf : str11.split(",")) {
                                    try {
                                        arrayList5.add(Integer.valueOf(valueOf));
                                    } catch (NumberFormatException unused4) {
                                    }
                                }
                            } else {
                                i2 = Integer.parseInt(str11);
                            }
                            str6 = str2;
                            str8 = str3;
                        }
                    }
                    i4 = i3;
                    str6 = str2;
                    str8 = str3;
                }
                i5++;
                i++;
                arrayList4 = arrayList2;
                arrayList3 = arrayList;
            }
            defaultCookie.setVersion(i2);
            defaultCookie.setMaxAge(i4);
            defaultCookie.setPath(str7);
            defaultCookie.setDomain(str9);
            defaultCookie.setSecure(z2);
            defaultCookie.setHttpOnly(z);
            if (i2 > 0) {
                defaultCookie.setComment(str2);
            }
            if (i2 > 1) {
                defaultCookie.setCommentUrl(str3);
                defaultCookie.setPorts((Iterable<Integer>) arrayList5);
                defaultCookie.setDiscard(z3);
            }
            i++;
            treeSet = treeSet2;
            arrayList4 = arrayList2;
            arrayList3 = arrayList;
        }
        return treeSet;
    }
}
