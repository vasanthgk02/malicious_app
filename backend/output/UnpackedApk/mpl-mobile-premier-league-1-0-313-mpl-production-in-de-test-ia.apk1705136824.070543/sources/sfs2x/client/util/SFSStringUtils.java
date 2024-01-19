package sfs2x.client.util;

public class SFSStringUtils {
    public static boolean isEmptyOrNull(String str) {
        return str == null || str.trim().length() <= 0;
    }
}
