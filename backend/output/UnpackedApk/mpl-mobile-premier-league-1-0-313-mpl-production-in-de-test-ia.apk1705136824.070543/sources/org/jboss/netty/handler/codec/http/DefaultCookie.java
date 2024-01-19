package org.jboss.netty.handler.codec.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class DefaultCookie implements Cookie {
    public static final Set<String> RESERVED_NAMES;
    public String comment;
    public String commentUrl;
    public boolean discard;
    public String domain;
    public boolean httpOnly;
    public int maxAge = -1;
    public final String name;
    public String path;
    public Set<Integer> ports;
    public boolean secure;
    public Set<Integer> unmodifiablePorts;
    public String value;
    public int version;

    static {
        TreeSet treeSet = new TreeSet(CaseIgnoringComparator.INSTANCE);
        RESERVED_NAMES = treeSet;
        treeSet.add(CookieHeaderNames.DOMAIN);
        RESERVED_NAMES.add(CookieHeaderNames.PATH);
        RESERVED_NAMES.add("Comment");
        RESERVED_NAMES.add(CookieHeaderNames.COMMENTURL);
        RESERVED_NAMES.add(CookieHeaderNames.DISCARD);
        RESERVED_NAMES.add(CookieHeaderNames.PORT);
        RESERVED_NAMES.add(CookieHeaderNames.MAX_AGE);
        RESERVED_NAMES.add("Expires");
        RESERVED_NAMES.add("Version");
        RESERVED_NAMES.add(CookieHeaderNames.SECURE);
        RESERVED_NAMES.add(CookieHeaderNames.HTTPONLY);
    }

    public DefaultCookie(String str, String str2) {
        Set<Integer> emptySet = Collections.emptySet();
        this.ports = emptySet;
        this.unmodifiablePorts = emptySet;
        if (str != null) {
            String trim = str.trim();
            if (trim.length() != 0) {
                int i = 0;
                while (i < trim.length()) {
                    char charAt = trim.charAt(i);
                    if (charAt <= 127) {
                        if (!(charAt == ' ' || charAt == ',' || charAt == ';' || charAt == '=')) {
                            switch (charAt) {
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                    break;
                                default:
                                    i++;
                            }
                        }
                        throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("name contains one of the following prohibited characters: =,; \\t\\r\\n\\v\\f: ", trim));
                    }
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("name contains non-ascii character: ", trim));
                }
                if (!RESERVED_NAMES.contains(trim)) {
                    this.name = trim;
                    setValue(str2);
                    return;
                }
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("reserved name: ", trim));
            }
            throw new IllegalArgumentException("empty name");
        }
        throw new NullPointerException("name");
    }

    public static String validateValue(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        String trim = str2.trim();
        if (trim.length() == 0) {
            return null;
        }
        int i = 0;
        while (i < trim.length()) {
            char charAt = trim.charAt(i);
            if (charAt != ';') {
                switch (charAt) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        i++;
                }
            }
            throw new IllegalArgumentException(str + " contains one of the following prohibited characters: " + ";\\r\\n\\f\\v (" + trim + ')');
        }
        return trim;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        if (!getName().equalsIgnoreCase(cookie.getName())) {
            return false;
        }
        if ((getPath() == null && cookie.getPath() != null) || cookie.getPath() == null || !getPath().equals(cookie.getPath())) {
            return false;
        }
        if ((getDomain() != null || cookie.getDomain() == null) && cookie.getDomain() != null && getDomain().equalsIgnoreCase(cookie.getDomain())) {
            return true;
        }
        return false;
    }

    public String getComment() {
        return this.comment;
    }

    public String getCommentUrl() {
        return this.commentUrl;
    }

    public String getDomain() {
        return this.domain;
    }

    public int getMaxAge() {
        return this.maxAge;
    }

    public String getName() {
        return this.name;
    }

    public String getPath() {
        return this.path;
    }

    public Set<Integer> getPorts() {
        if (this.unmodifiablePorts == null) {
            this.unmodifiablePorts = Collections.unmodifiableSet(this.ports);
        }
        return this.unmodifiablePorts;
    }

    public String getValue() {
        return this.value;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public boolean isDiscard() {
        return this.discard;
    }

    public boolean isHttpOnly() {
        return this.httpOnly;
    }

    public boolean isSecure() {
        return this.secure;
    }

    public void setComment(String str) {
        this.comment = validateValue("comment", str);
    }

    public void setCommentUrl(String str) {
        this.commentUrl = validateValue("commentUrl", str);
    }

    public void setDiscard(boolean z) {
        this.discard = z;
    }

    public void setDomain(String str) {
        this.domain = validateValue("domain", str);
    }

    public void setHttpOnly(boolean z) {
        this.httpOnly = z;
    }

    public void setMaxAge(int i) {
        if (i >= -1) {
            this.maxAge = i;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("maxAge must be either -1, 0, or a positive integer: ", i));
    }

    public void setPath(String str) {
        this.path = validateValue("path", str);
    }

    public void setPorts(int... iArr) {
        if (iArr != null) {
            int[] iArr2 = (int[]) iArr.clone();
            if (iArr2.length == 0) {
                Set<Integer> emptySet = Collections.emptySet();
                this.ports = emptySet;
                this.unmodifiablePorts = emptySet;
                return;
            }
            TreeSet treeSet = new TreeSet();
            for (int i : iArr2) {
                if (i <= 0 || i > 65535) {
                    throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("port out of range: ", i));
                }
                treeSet.add(Integer.valueOf(i));
            }
            this.ports = treeSet;
            this.unmodifiablePorts = null;
            return;
        }
        throw new NullPointerException("ports");
    }

    public void setSecure(boolean z) {
        this.secure = z;
    }

    public void setValue(String str) {
        if (str != null) {
            this.value = str;
            return;
        }
        throw new NullPointerException(HSLCriteriaBuilder.VALUE);
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append('=');
        sb.append(getValue());
        if (getDomain() != null) {
            sb.append(", domain=");
            sb.append(getDomain());
        }
        if (getPath() != null) {
            sb.append(", path=");
            sb.append(getPath());
        }
        if (getComment() != null) {
            sb.append(", comment=");
            sb.append(getComment());
        }
        if (getMaxAge() >= 0) {
            sb.append(", maxAge=");
            sb.append(getMaxAge());
            sb.append('s');
        }
        if (isSecure()) {
            sb.append(", secure");
        }
        if (isHttpOnly()) {
            sb.append(", HTTPOnly");
        }
        return sb.toString();
    }

    public int compareTo(Cookie cookie) {
        int compareToIgnoreCase = getName().compareToIgnoreCase(cookie.getName());
        if (compareToIgnoreCase != 0) {
            return compareToIgnoreCase;
        }
        if (getPath() == null && cookie.getPath() != null) {
            return -1;
        }
        if (cookie.getPath() == null) {
            return 1;
        }
        int compareTo = getPath().compareTo(cookie.getPath());
        if (compareTo != 0) {
            return compareTo;
        }
        if (getDomain() == null && cookie.getDomain() != null) {
            return -1;
        }
        if (cookie.getDomain() == null) {
            return 1;
        }
        return getDomain().compareToIgnoreCase(cookie.getDomain());
    }

    public void setPorts(Iterable<Integer> iterable) {
        TreeSet treeSet = new TreeSet();
        for (Integer intValue : iterable) {
            int intValue2 = intValue.intValue();
            if (intValue2 <= 0 || intValue2 > 65535) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("port out of range: ", intValue2));
            }
            treeSet.add(Integer.valueOf(intValue2));
        }
        if (treeSet.isEmpty()) {
            Set<Integer> emptySet = Collections.emptySet();
            this.ports = emptySet;
            this.unmodifiablePorts = emptySet;
            return;
        }
        this.ports = treeSet;
        this.unmodifiablePorts = null;
    }
}
