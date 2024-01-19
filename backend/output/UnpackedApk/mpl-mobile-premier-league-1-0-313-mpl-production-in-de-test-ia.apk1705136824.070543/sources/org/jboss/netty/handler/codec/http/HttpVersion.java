package org.jboss.netty.handler.codec.http;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpVersion implements Comparable<HttpVersion> {
    public static final HttpVersion HTTP_1_0 = new HttpVersion("HTTP", 1, 0, false);
    public static final HttpVersion HTTP_1_1 = new HttpVersion("HTTP", 1, 1, true);
    public static final Pattern VERSION_PATTERN = Pattern.compile("(\\S+)/(\\d+)\\.(\\d+)");
    public final boolean keepAliveDefault;
    public final int majorVersion;
    public final int minorVersion;
    public final String protocolName;
    public final String text;

    @Deprecated
    public HttpVersion(String str) {
        this(str, true);
    }

    public static HttpVersion valueOf(String str) {
        if (str != null) {
            String upperCase = str.trim().toUpperCase();
            if (upperCase.equals("HTTP/1.1")) {
                return HTTP_1_1;
            }
            if (upperCase.equals("HTTP/1.0")) {
                return HTTP_1_0;
            }
            return new HttpVersion(upperCase, true);
        }
        throw new NullPointerException("text");
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof HttpVersion)) {
            return false;
        }
        HttpVersion httpVersion = (HttpVersion) obj;
        if (getMinorVersion() == httpVersion.getMinorVersion() && getMajorVersion() == httpVersion.getMajorVersion() && getProtocolName().equals(httpVersion.getProtocolName())) {
            z = true;
        }
        return z;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public String getProtocolName() {
        return this.protocolName;
    }

    public String getText() {
        return this.text;
    }

    public int hashCode() {
        int majorVersion2 = getMajorVersion();
        return getMinorVersion() + ((majorVersion2 + (getProtocolName().hashCode() * 31)) * 31);
    }

    public boolean isKeepAliveDefault() {
        return this.keepAliveDefault;
    }

    public String toString() {
        return getText();
    }

    public HttpVersion(String str, boolean z) {
        if (str != null) {
            String upperCase = str.trim().toUpperCase();
            if (upperCase.length() != 0) {
                Matcher matcher = VERSION_PATTERN.matcher(upperCase);
                if (matcher.matches()) {
                    this.protocolName = matcher.group(1);
                    this.majorVersion = Integer.parseInt(matcher.group(2));
                    this.minorVersion = Integer.parseInt(matcher.group(3));
                    this.text = this.protocolName + '/' + this.majorVersion + '.' + this.minorVersion;
                    this.keepAliveDefault = z;
                    return;
                }
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50("invalid version format: ", upperCase));
            }
            throw new IllegalArgumentException("empty text");
        }
        throw new NullPointerException("text");
    }

    public int compareTo(HttpVersion httpVersion) {
        int compareTo = getProtocolName().compareTo(httpVersion.getProtocolName());
        if (compareTo != 0) {
            return compareTo;
        }
        int majorVersion2 = getMajorVersion() - httpVersion.getMajorVersion();
        if (majorVersion2 != 0) {
            return majorVersion2;
        }
        return getMinorVersion() - httpVersion.getMinorVersion();
    }

    @Deprecated
    public HttpVersion(String str, int i, int i2) {
        this(str, i, i2, true);
    }

    public HttpVersion(String str, int i, int i2, boolean z) {
        if (str != null) {
            String upperCase = str.trim().toUpperCase();
            if (upperCase.length() != 0) {
                for (int i3 = 0; i3 < upperCase.length(); i3++) {
                    if (Character.isISOControl(upperCase.charAt(i3)) || Character.isWhitespace(upperCase.charAt(i3))) {
                        throw new IllegalArgumentException("invalid character in protocolName");
                    }
                }
                if (i < 0) {
                    throw new IllegalArgumentException("negative majorVersion");
                } else if (i2 >= 0) {
                    this.protocolName = upperCase;
                    this.majorVersion = i;
                    this.minorVersion = i2;
                    this.text = upperCase + '/' + i + '.' + i2;
                    this.keepAliveDefault = z;
                } else {
                    throw new IllegalArgumentException("negative minorVersion");
                }
            } else {
                throw new IllegalArgumentException("empty protocolName");
            }
        } else {
            throw new NullPointerException("protocolName");
        }
    }
}
