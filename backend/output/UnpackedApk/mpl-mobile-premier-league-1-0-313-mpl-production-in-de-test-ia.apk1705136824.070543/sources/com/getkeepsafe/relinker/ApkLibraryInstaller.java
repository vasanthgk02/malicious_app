package com.getkeepsafe.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ApkLibraryInstaller implements ReLinker$LibraryInstaller {

    public static class ZipFileInZipEntry {
        public ZipEntry zipEntry;
        public ZipFile zipFile;

        public ZipFileInZipEntry(ZipFile zipFile2, ZipEntry zipEntry2) {
            this.zipFile = zipFile2;
            this.zipEntry = zipEntry2;
        }
    }

    public final ZipFileInZipEntry findAPKWithLibrary(Context context, String[] strArr, String str, ReLinkerInstance reLinkerInstance) {
        int i;
        ZipFile zipFile;
        String[] strArr2 = strArr;
        String[] sourceDirectories = sourceDirectories(context);
        int length = sourceDirectories.length;
        char c2 = 0;
        int i2 = 0;
        while (i2 < length) {
            String str2 = sourceDirectories[i2];
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                i = 5;
                if (i3 >= 5) {
                    zipFile = null;
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i3 = i4;
                }
            }
            if (zipFile == null) {
                String str3 = str;
            } else {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (i5 < i) {
                        int length2 = strArr2.length;
                        int i7 = 0;
                        while (i7 < length2) {
                            String str4 = strArr2[i7];
                            StringBuilder outline73 = GeneratedOutlineSupport.outline73("lib");
                            outline73.append(File.separatorChar);
                            outline73.append(str4);
                            outline73.append(File.separatorChar);
                            outline73.append(str);
                            String sb = outline73.toString();
                            Object[] objArr = new Object[2];
                            objArr[c2] = sb;
                            objArr[1] = str2;
                            if (reLinkerInstance != null) {
                                String.format(Locale.US, "Looking for %s in APK %s...", objArr);
                                ZipEntry entry = zipFile.getEntry(sb);
                                if (entry != null) {
                                    return new ZipFileInZipEntry(zipFile, entry);
                                }
                                i7++;
                                c2 = 0;
                                i = 5;
                            } else {
                                throw null;
                            }
                        }
                        String str5 = str;
                        i5 = i6;
                    } else {
                        String str6 = str;
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i2++;
            c2 = 0;
        }
        return null;
    }

    public final String[] getSupportedABIs(Context context, String str) {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("lib");
        outline73.append(File.separatorChar);
        outline73.append("([^\\");
        outline73.append(File.separatorChar);
        outline73.append("]*)");
        outline73.append(File.separatorChar);
        outline73.append(str);
        Pattern compile = Pattern.compile(outline73.toString());
        HashSet hashSet = new HashSet();
        for (String file : sourceDirectories(context)) {
            try {
                Enumeration<? extends ZipEntry> entries = new ZipFile(new File(file), 1).entries();
                while (entries.hasMoreElements()) {
                    Matcher matcher = compile.matcher(((ZipEntry) entries.nextElement()).getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final String[] sourceDirectories(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }
}
