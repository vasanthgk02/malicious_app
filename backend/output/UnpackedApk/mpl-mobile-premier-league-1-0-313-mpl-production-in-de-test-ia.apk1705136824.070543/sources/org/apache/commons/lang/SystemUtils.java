package org.apache.commons.lang;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.PrintStream;
import org.apache.pdfbox.pdfparser.COSParser;

public class SystemUtils {
    public static final String AWT_TOOLKIT = getSystemProperty("awt.toolkit");
    public static final String FILE_ENCODING = getSystemProperty("file.encoding");
    public static final String FILE_SEPARATOR = getSystemProperty("file.separator");
    public static final boolean IS_JAVA_1_1 = getJavaVersionMatches("1.1");
    public static final boolean IS_JAVA_1_2 = getJavaVersionMatches("1.2");
    public static final boolean IS_JAVA_1_3 = getJavaVersionMatches("1.3");
    public static final boolean IS_JAVA_1_4 = getJavaVersionMatches(COSParser.PDF_DEFAULT_VERSION);
    public static final boolean IS_JAVA_1_5 = getJavaVersionMatches("1.5");
    public static final boolean IS_JAVA_1_6 = getJavaVersionMatches("1.6");
    public static final boolean IS_OS_AIX = getOSMatches("AIX");
    public static final boolean IS_OS_HP_UX = getOSMatches("HP-UX");
    public static final boolean IS_OS_IRIX = getOSMatches("Irix");
    public static final boolean IS_OS_LINUX = (getOSMatches("Linux") || getOSMatches("LINUX"));
    public static final boolean IS_OS_MAC = getOSMatches("Mac");
    public static final boolean IS_OS_MAC_OSX = getOSMatches("Mac OS X");
    public static final boolean IS_OS_OS2 = getOSMatches("OS/2");
    public static final boolean IS_OS_SOLARIS = getOSMatches("Solaris");
    public static final boolean IS_OS_SUN_OS;
    public static final boolean IS_OS_UNIX;
    public static final boolean IS_OS_WINDOWS = getOSMatches(OS_NAME_WINDOWS_PREFIX);
    public static final boolean IS_OS_WINDOWS_2000 = getOSMatches(OS_NAME_WINDOWS_PREFIX, "5.0");
    public static final boolean IS_OS_WINDOWS_95 = getOSMatches("Windows 9", "4.0");
    public static final boolean IS_OS_WINDOWS_98 = getOSMatches("Windows 9", "4.1");
    public static final boolean IS_OS_WINDOWS_ME = getOSMatches(OS_NAME_WINDOWS_PREFIX, "4.9");
    public static final boolean IS_OS_WINDOWS_NT = getOSMatches("Windows NT");
    public static final boolean IS_OS_WINDOWS_VISTA = getOSMatches(OS_NAME_WINDOWS_PREFIX, "6.0");
    public static final boolean IS_OS_WINDOWS_XP = getOSMatches(OS_NAME_WINDOWS_PREFIX, "5.1");
    public static final String JAVA_AWT_FONTS = getSystemProperty("java.awt.fonts");
    public static final String JAVA_AWT_GRAPHICSENV = getSystemProperty("java.awt.graphicsenv");
    public static final String JAVA_AWT_HEADLESS = getSystemProperty("java.awt.headless");
    public static final String JAVA_AWT_PRINTERJOB = getSystemProperty("java.awt.printerjob");
    public static final String JAVA_CLASS_PATH = getSystemProperty("java.class.path");
    public static final String JAVA_CLASS_VERSION = getSystemProperty("java.class.version");
    public static final String JAVA_COMPILER = getSystemProperty("java.compiler");
    public static final String JAVA_ENDORSED_DIRS = getSystemProperty("java.endorsed.dirs");
    public static final String JAVA_EXT_DIRS = getSystemProperty("java.ext.dirs");
    public static final String JAVA_HOME = getSystemProperty(JAVA_HOME_KEY);
    public static final String JAVA_HOME_KEY = "java.home";
    public static final String JAVA_IO_TMPDIR = getSystemProperty(JAVA_IO_TMPDIR_KEY);
    public static final String JAVA_IO_TMPDIR_KEY = "java.io.tmpdir";
    public static final String JAVA_LIBRARY_PATH = getSystemProperty("java.library.path");
    public static final String JAVA_RUNTIME_NAME = getSystemProperty("java.runtime.name");
    public static final String JAVA_RUNTIME_VERSION = getSystemProperty("java.runtime.version");
    public static final String JAVA_SPECIFICATION_NAME = getSystemProperty("java.specification.name");
    public static final String JAVA_SPECIFICATION_VENDOR = getSystemProperty("java.specification.vendor");
    public static final String JAVA_SPECIFICATION_VERSION = getSystemProperty("java.specification.version");
    public static final String JAVA_UTIL_PREFS_PREFERENCES_FACTORY = getSystemProperty("java.util.prefs.PreferencesFactory");
    public static final String JAVA_VENDOR = getSystemProperty("java.vendor");
    public static final String JAVA_VENDOR_URL = getSystemProperty("java.vendor.url");
    public static final String JAVA_VERSION = getSystemProperty("java.version");
    public static final float JAVA_VERSION_FLOAT = getJavaVersionAsFloat();
    public static final int JAVA_VERSION_INT = getJavaVersionAsInt();
    public static final String JAVA_VERSION_TRIMMED = getJavaVersionTrimmed();
    public static final String JAVA_VM_INFO = getSystemProperty("java.vm.info");
    public static final String JAVA_VM_NAME = getSystemProperty("java.vm.name");
    public static final String JAVA_VM_SPECIFICATION_NAME = getSystemProperty("java.vm.specification.name");
    public static final String JAVA_VM_SPECIFICATION_VENDOR = getSystemProperty("java.vm.specification.vendor");
    public static final String JAVA_VM_SPECIFICATION_VERSION = getSystemProperty("java.vm.specification.version");
    public static final String JAVA_VM_VENDOR = getSystemProperty("java.vm.vendor");
    public static final String JAVA_VM_VERSION = getSystemProperty("java.vm.version");
    public static final String LINE_SEPARATOR = getSystemProperty("line.separator");
    public static final String OS_ARCH = getSystemProperty("os.arch");
    public static final String OS_NAME = getSystemProperty("os.name");
    public static final String OS_NAME_WINDOWS_PREFIX = "Windows";
    public static final String OS_VERSION = getSystemProperty("os.version");
    public static final String PATH_SEPARATOR = getSystemProperty("path.separator");
    public static final String USER_COUNTRY;
    public static final String USER_DIR = getSystemProperty(USER_DIR_KEY);
    public static final String USER_DIR_KEY = "user.dir";
    public static final String USER_HOME = getSystemProperty(USER_HOME_KEY);
    public static final String USER_HOME_KEY = "user.home";
    public static final String USER_LANGUAGE = getSystemProperty("user.language");
    public static final String USER_NAME = getSystemProperty("user.name");
    public static final String USER_TIMEZONE = getSystemProperty("user.timezone");

    static {
        String str = "user.country";
        if (getSystemProperty(str) == null) {
            str = "user.region";
        }
        USER_COUNTRY = getSystemProperty(str);
        boolean z = false;
        boolean oSMatches = getOSMatches("SunOS");
        IS_OS_SUN_OS = oSMatches;
        if (IS_OS_AIX || IS_OS_HP_UX || IS_OS_IRIX || IS_OS_LINUX || IS_OS_MAC_OSX || IS_OS_SOLARIS || oSMatches) {
            z = true;
        }
        IS_OS_UNIX = z;
    }

    public static File getJavaHome() {
        return new File(System.getProperty(JAVA_HOME_KEY));
    }

    public static File getJavaIoTmpDir() {
        return new File(System.getProperty(JAVA_IO_TMPDIR_KEY));
    }

    public static float getJavaVersion() {
        return JAVA_VERSION_FLOAT;
    }

    public static float getJavaVersionAsFloat() {
        String str = JAVA_VERSION_TRIMMED;
        if (str == null) {
            return 0.0f;
        }
        String substring = str.substring(0, 3);
        if (JAVA_VERSION_TRIMMED.length() >= 5) {
            StringBuffer outline71 = GeneratedOutlineSupport.outline71(substring);
            outline71.append(JAVA_VERSION_TRIMMED.substring(4, 5));
            substring = outline71.toString();
        }
        try {
            return Float.parseFloat(substring);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static int getJavaVersionAsInt() {
        String str;
        String str2 = JAVA_VERSION_TRIMMED;
        if (str2 == null) {
            return 0;
        }
        StringBuffer outline71 = GeneratedOutlineSupport.outline71(str2.substring(0, 1));
        outline71.append(JAVA_VERSION_TRIMMED.substring(2, 3));
        String stringBuffer = outline71.toString();
        if (JAVA_VERSION_TRIMMED.length() >= 5) {
            StringBuffer outline712 = GeneratedOutlineSupport.outline71(stringBuffer);
            outline712.append(JAVA_VERSION_TRIMMED.substring(4, 5));
            str = outline712.toString();
        } else {
            str = GeneratedOutlineSupport.outline49(stringBuffer, "0");
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean getJavaVersionMatches(String str) {
        String str2 = JAVA_VERSION_TRIMMED;
        if (str2 == null) {
            return false;
        }
        return str2.startsWith(str);
    }

    public static String getJavaVersionTrimmed() {
        if (JAVA_VERSION != null) {
            for (int i = 0; i < JAVA_VERSION.length(); i++) {
                char charAt = JAVA_VERSION.charAt(i);
                if (charAt >= '0' && charAt <= '9') {
                    return JAVA_VERSION.substring(i);
                }
            }
        }
        return null;
    }

    public static boolean getOSMatches(String str) {
        String str2 = OS_NAME;
        if (str2 == null) {
            return false;
        }
        return str2.startsWith(str);
    }

    public static String getSystemProperty(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Caught a SecurityException reading the system property '");
            stringBuffer.append(str);
            stringBuffer.append("'; the SystemUtils property value will default to null.");
            printStream.println(stringBuffer.toString());
            return null;
        }
    }

    public static File getUserDir() {
        return new File(System.getProperty(USER_DIR_KEY));
    }

    public static File getUserHome() {
        return new File(System.getProperty(USER_HOME_KEY));
    }

    public static boolean isJavaAwtHeadless() {
        String str = JAVA_AWT_HEADLESS;
        if (str != null) {
            return str.equals(Boolean.TRUE.toString());
        }
        return false;
    }

    public static boolean isJavaVersionAtLeast(float f2) {
        return JAVA_VERSION_FLOAT >= f2;
    }

    public static boolean isJavaVersionAtLeast(int i) {
        return JAVA_VERSION_INT >= i;
    }

    public static boolean getOSMatches(String str, String str2) {
        String str3 = OS_NAME;
        if (str3 == null || OS_VERSION == null || !str3.startsWith(str) || !OS_VERSION.startsWith(str2)) {
            return false;
        }
        return true;
    }
}
