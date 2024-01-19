package org.apache.fontbox.util.autodetect;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.net.ftp.FTPClientConfig;

public class WindowsFontDirFinder implements FontDirFinder {
    private String getWinDir(String str) throws IOException {
        Process process;
        Runtime runtime = Runtime.getRuntime();
        if (str.startsWith("Windows 9")) {
            process = runtime.exec("command.com /c echo %windir%");
        } else {
            process = runtime.exec("cmd.exe /c echo %windir%");
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String readLine = bufferedReader.readLine();
        bufferedReader.close();
        return readLine;
    }

    public List<File> find() {
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            str = System.getProperty("env.windir");
        } catch (SecurityException unused) {
            str = null;
        }
        String property = System.getProperty("os.name");
        if (str == null) {
            try {
                str = getWinDir(property);
            } catch (IOException unused2) {
            }
        }
        if (str == null) {
            String str2 = property.endsWith("NT") ? "WINNT" : FTPClientConfig.SYST_NT;
            char c2 = 'C';
            char c3 = 'C';
            while (true) {
                if (c3 > 'E') {
                    break;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(c3);
                sb.append(":");
                sb.append(File.separator);
                sb.append(str2);
                File file = new File(GeneratedOutlineSupport.outline62(sb, File.separator, "FONTS"));
                if (file.exists() && file.canRead()) {
                    arrayList.add(file);
                    break;
                }
                c3 = (char) (c3 + 1);
            }
            while (true) {
                if (c2 > 'E') {
                    break;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(c2);
                sb2.append(":");
                File file2 = new File(GeneratedOutlineSupport.outline62(sb2, File.separator, "PSFONTS"));
                if (file2.exists() && file2.canRead()) {
                    arrayList.add(file2);
                    break;
                }
                c2 = (char) (c2 + 1);
            }
        } else {
            if (str.endsWith("/")) {
                str = str.substring(0, str.length() - 1);
            }
            File file3 = new File(GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73(str), File.separator, "FONTS"));
            if (file3.exists() && file3.canRead()) {
                arrayList.add(file3);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str.substring(0, 2));
            File file4 = new File(GeneratedOutlineSupport.outline62(sb3, File.separator, "PSFONTS"));
            if (file4.exists() && file4.canRead()) {
                arrayList.add(file4);
            }
        }
        return arrayList;
    }
}
