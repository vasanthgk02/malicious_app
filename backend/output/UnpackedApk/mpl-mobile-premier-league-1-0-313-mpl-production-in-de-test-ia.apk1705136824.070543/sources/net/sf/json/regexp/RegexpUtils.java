package net.sf.json.regexp;

public class RegexpUtils {
    public static String javaVersion = System.getProperty("java.version");

    public static RegexpMatcher getMatchera(String str) {
        if (javaVersion.indexOf("1.3") != -1) {
            return new Perl5RegexpMatcher(str, true);
        }
        return new JdkRegexpMatcher(str, true);
    }
}
