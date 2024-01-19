package com.badlogic.gdx.utils;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.InputStream;
import java.util.HashSet;
import org.apache.commons.lang.SystemUtils;

public class SharedLibraryLoader {
    public static boolean is64Bit;
    public static boolean isARM = (System.getProperty("os.arch").startsWith("arm") || System.getProperty("os.arch").startsWith("aarch64"));
    public static boolean isAndroid;
    public static boolean isIos;
    public static boolean isLinux;
    public static boolean isMac;
    public static boolean isWindows;
    public static final HashSet<String> loadedLibraries = new HashSet<>();

    static {
        isWindows = System.getProperty("os.name").contains(SystemUtils.OS_NAME_WINDOWS_PREFIX);
        isLinux = System.getProperty("os.name").contains("Linux");
        isMac = System.getProperty("os.name").contains("Mac");
        isIos = false;
        isAndroid = false;
        is64Bit = System.getProperty("os.arch").contains("64") || System.getProperty("os.arch").startsWith("armv8");
        String property = System.getProperty("java.runtime.name");
        if (property != null && property.contains("Android Runtime")) {
            isAndroid = true;
            isWindows = false;
            isLinux = false;
            isMac = false;
            is64Bit = false;
        }
        if (!isAndroid && !isWindows && !isLinux && !isMac) {
            isIos = true;
            isAndroid = false;
            isWindows = false;
            isLinux = false;
            isMac = false;
            is64Bit = false;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String crc(java.io.InputStream r5) {
        /*
            r4 = this;
            java.util.zip.CRC32 r0 = new java.util.zip.CRC32
            r0.<init>()
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]
        L_0x0009:
            int r2 = r5.read(r1)     // Catch:{ Exception -> 0x001b, all -> 0x0016 }
            r3 = -1
            if (r2 != r3) goto L_0x0011
            goto L_0x001b
        L_0x0011:
            r3 = 0
            r0.update(r1, r3, r2)     // Catch:{ Exception -> 0x001b, all -> 0x0016 }
            goto L_0x0009
        L_0x0016:
            r0 = move-exception
            r5.close()     // Catch:{ all -> 0x001a }
        L_0x001a:
            throw r0
        L_0x001b:
            r5.close()     // Catch:{ all -> 0x001e }
        L_0x001e:
            long r0 = r0.getValue()
            r5 = 16
            java.lang.String r5 = java.lang.Long.toString(r0, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.SharedLibraryLoader.crc(java.io.InputStream):java.lang.String");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0038 */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035 A[SYNTHETIC, Splitter:B:19:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x007a A[SYNTHETIC, Splitter:B:43:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007f A[SYNTHETIC, Splitter:B:47:0x007f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.io.File extractFile(java.lang.String r7, java.lang.String r8, java.io.File r9) throws java.io.IOException {
        /*
            r6 = this;
            boolean r0 = r9.exists()
            r1 = 0
            if (r0 == 0) goto L_0x0011
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0011 }
            r0.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0011 }
            java.lang.String r0 = r6.crc(r0)     // Catch:{ FileNotFoundException -> 0x0011 }
            goto L_0x0012
        L_0x0011:
            r0 = r1
        L_0x0012:
            if (r0 == 0) goto L_0x001a
            boolean r8 = r0.equals(r8)
            if (r8 != 0) goto L_0x003b
        L_0x001a:
            java.io.InputStream r8 = r6.readFile(r7)     // Catch:{ IOException -> 0x004f, all -> 0x004c }
            java.io.File r0 = r9.getParentFile()     // Catch:{ IOException -> 0x0047, all -> 0x0043 }
            r0.mkdirs()     // Catch:{ IOException -> 0x0047, all -> 0x0043 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0047, all -> 0x0043 }
            r0.<init>(r9)     // Catch:{ IOException -> 0x0047, all -> 0x0043 }
            r1 = 4096(0x1000, float:5.74E-42)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x0041 }
        L_0x002e:
            int r2 = r8.read(r1)     // Catch:{ IOException -> 0x0041 }
            r3 = -1
            if (r2 != r3) goto L_0x003c
            r8.close()     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r0.close()     // Catch:{ all -> 0x003b }
        L_0x003b:
            return r9
        L_0x003c:
            r3 = 0
            r0.write(r1, r3, r2)     // Catch:{ IOException -> 0x0041 }
            goto L_0x002e
        L_0x0041:
            r1 = move-exception
            goto L_0x0053
        L_0x0043:
            r7 = move-exception
            r0 = r1
        L_0x0045:
            r1 = r8
            goto L_0x0078
        L_0x0047:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0053
        L_0x004c:
            r7 = move-exception
            r0 = r1
            goto L_0x0078
        L_0x004f:
            r8 = move-exception
            r0 = r1
            r1 = r8
            r8 = r0
        L_0x0053:
            com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ all -> 0x0076 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r3.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r4 = "Error extracting file: "
            r3.append(r4)     // Catch:{ all -> 0x0076 }
            r3.append(r7)     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = "\nTo: "
            r3.append(r7)     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = r9.getAbsolutePath()     // Catch:{ all -> 0x0076 }
            r3.append(r7)     // Catch:{ all -> 0x0076 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0076 }
            r2.<init>(r7, r1)     // Catch:{ all -> 0x0076 }
            throw r2     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r7 = move-exception
            goto L_0x0045
        L_0x0078:
            if (r1 == 0) goto L_0x007d
            r1.close()     // Catch:{ all -> 0x007d }
        L_0x007d:
            if (r0 == 0) goto L_0x0082
            r0.close()     // Catch:{ all -> 0x0082 }
        L_0x0082:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.SharedLibraryLoader.extractFile(java.lang.String, java.lang.String, java.io.File):java.io.File");
    }

    public void load(String str) {
        boolean contains;
        Class<SharedLibraryLoader> cls = SharedLibraryLoader.class;
        if (!isIos) {
            synchronized (cls) {
                synchronized (cls) {
                    contains = loadedLibraries.contains(str);
                }
            }
            if (contains) {
                return;
            }
            String mapLibraryName = mapLibraryName(str);
            try {
                if (isAndroid) {
                    System.loadLibrary(mapLibraryName);
                } else {
                    loadFile(mapLibraryName);
                }
                synchronized (cls) {
                    loadedLibraries.add(str);
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't load shared library '");
                sb.append(mapLibraryName);
                sb.append("' for target: ");
                sb.append(System.getProperty("os.name"));
                sb.append(is64Bit ? ", 64-bit" : ", 32-bit");
                throw new GdxRuntimeException(sb.toString(), th);
            }
        }
    }

    public final void loadFile(String str) {
        String crc = crc(readFile(str));
        String name = new File(str).getName();
        Throwable loadFile = loadFile(str, crc, new File(System.getProperty(SystemUtils.JAVA_IO_TMPDIR_KEY) + "/libgdx" + System.getProperty("user.name") + "/" + crc, name));
        if (loadFile != null) {
            try {
                File createTempFile = File.createTempFile(crc, null);
                if (createTempFile.delete() && loadFile(str, crc, createTempFile) == null) {
                    return;
                }
            } catch (Throwable unused) {
            }
            if (loadFile(str, crc, new File(System.getProperty(SystemUtils.USER_HOME_KEY) + "/.libgdx/" + crc, name)) != null && loadFile(str, crc, new File(GeneratedOutlineSupport.outline50(".temp/", crc), name)) != null) {
                File file = new File(System.getProperty("java.library.path"), str);
                if (file.exists()) {
                    System.load(file.getAbsolutePath());
                    return;
                }
                throw new GdxRuntimeException(loadFile);
            }
        }
    }

    public String mapLibraryName(String str) {
        if (isWindows) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(str);
            outline73.append(is64Bit ? "64.dll" : ".dll");
            return outline73.toString();
        } else if (isLinux) {
            StringBuilder outline78 = GeneratedOutlineSupport.outline78("lib", str);
            outline78.append(isARM ? "arm" : "");
            outline78.append(is64Bit ? "64.so" : ".so");
            return outline78.toString();
        } else {
            if (isMac) {
                StringBuilder outline782 = GeneratedOutlineSupport.outline78("lib", str);
                outline782.append(is64Bit ? "64.dylib" : ".dylib");
                str = outline782.toString();
            }
            return str;
        }
    }

    public final InputStream readFile(String str) {
        InputStream resourceAsStream = SharedLibraryLoader.class.getResourceAsStream("/" + str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        throw new GdxRuntimeException(GeneratedOutlineSupport.outline50("Unable to read file for extraction: ", str));
    }

    public final Throwable loadFile(String str, String str2, File file) {
        try {
            extractFile(str, str2, file);
            System.load(file.getAbsolutePath());
            return null;
        } catch (Throwable th) {
            return th;
        }
    }
}
