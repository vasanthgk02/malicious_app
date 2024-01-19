package org.apache.pdfbox.pdmodel.font;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.fontbox.cff.CFFFont;
import org.apache.fontbox.ttf.TrueTypeFont;
import org.apache.fontbox.type1.Type1Font;
import org.apache.fontbox.util.autodetect.FontFileFinder;

public final class FileSystemFontProvider extends FontProvider {
    public final Map<String, File> cffFontFiles = new HashMap();
    public final Map<String, CFFFont> cffFonts = new HashMap();
    public final Map<String, File> ttfFontFiles = new HashMap();
    public final Map<String, TrueTypeFont> ttfFonts = new HashMap();
    public final Map<String, File> type1FontFiles = new HashMap();
    public final Map<String, Type1Font> type1Fonts = new HashMap();

    public FileSystemFontProvider() {
        for (URI file : new FontFileFinder().find()) {
            File file2 = new File(file);
            try {
                if (!file2.getPath().toLowerCase().endsWith(".ttf")) {
                    if (!file2.getPath().toLowerCase().endsWith(".otf")) {
                        if (file2.getPath().toLowerCase().endsWith(".pfb")) {
                            addType1Font(file2);
                        }
                    }
                }
                addOpenTypeFont(file2);
            } catch (IOException unused) {
                file2.getPath();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[Catch:{ all -> 0x0034 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0049 A[Catch:{ all -> 0x0034 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f A[SYNTHETIC, Splitter:B:9:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addOpenTypeFont(java.io.File r5) throws java.io.IOException {
        /*
            r4 = this;
            java.lang.String r0 = "Could not load font file: "
            org.apache.fontbox.ttf.TTFParser r1 = new org.apache.fontbox.ttf.TTFParser
            r2 = 0
            r3 = 1
            r1.<init>(r2, r3)
            r2 = 0
            org.apache.fontbox.ttf.TrueTypeFont r0 = r1.parse(r5)     // Catch:{ NullPointerException -> 0x001e, IOException -> 0x000f }
            goto L_0x002d
        L_0x000f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r5)
            r1.toString()
            goto L_0x002c
        L_0x001e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r5)
            r1.toString()
        L_0x002c:
            r0 = r2
        L_0x002d:
            if (r0 == 0) goto L_0x0036
            org.apache.fontbox.ttf.NamingTable r2 = r0.getNaming()     // Catch:{ all -> 0x0034 }
            goto L_0x0036
        L_0x0034:
            r5 = move-exception
            goto L_0x0096
        L_0x0036:
            if (r2 != 0) goto L_0x0049
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r1.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "Missing 'name' table in font "
            r1.append(r2)     // Catch:{ all -> 0x0034 }
            r1.append(r5)     // Catch:{ all -> 0x0034 }
            r1.toString()     // Catch:{ all -> 0x0034 }
            goto L_0x0090
        L_0x0049:
            java.lang.String r1 = r2.getPostScriptName()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0080
            r2.getPostScriptName()     // Catch:{ all -> 0x0034 }
            java.util.Map r1 = r0.getTableMap()     // Catch:{ all -> 0x0034 }
            java.lang.String r3 = "CFF "
            java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x006c
            java.util.Map<java.lang.String, java.io.File> r1 = r4.cffFontFiles     // Catch:{ all -> 0x0034 }
            java.util.Set r3 = r4.getNames(r0)     // Catch:{ all -> 0x0034 }
            java.util.Map r5 = r4.toMap(r3, r5)     // Catch:{ all -> 0x0034 }
            r1.putAll(r5)     // Catch:{ all -> 0x0034 }
            goto L_0x0079
        L_0x006c:
            java.util.Map<java.lang.String, java.io.File> r1 = r4.ttfFontFiles     // Catch:{ all -> 0x0034 }
            java.util.Set r3 = r4.getNames(r0)     // Catch:{ all -> 0x0034 }
            java.util.Map r5 = r4.toMap(r3, r5)     // Catch:{ all -> 0x0034 }
            r1.putAll(r5)     // Catch:{ all -> 0x0034 }
        L_0x0079:
            r2.getFontFamily()     // Catch:{ all -> 0x0034 }
            r2.getFontSubFamily()     // Catch:{ all -> 0x0034 }
            goto L_0x0090
        L_0x0080:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0034 }
            r1.<init>()     // Catch:{ all -> 0x0034 }
            java.lang.String r2 = "Missing 'name' entry for PostScript name in font "
            r1.append(r2)     // Catch:{ all -> 0x0034 }
            r1.append(r5)     // Catch:{ all -> 0x0034 }
            r1.toString()     // Catch:{ all -> 0x0034 }
        L_0x0090:
            if (r0 == 0) goto L_0x0095
            r0.close()
        L_0x0095:
            return
        L_0x0096:
            if (r0 == 0) goto L_0x009b
            r0.close()
        L_0x009b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.font.FileSystemFontProvider.addOpenTypeFont(java.io.File):void");
    }

    private void addType1Font(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Type1Font createWithPFB = Type1Font.createWithPFB((InputStream) fileInputStream);
            createWithPFB.getFontName();
            this.type1FontFiles.putAll(toMap(getNames(createWithPFB), file));
            createWithPFB.getFamilyName();
            createWithPFB.getWeight();
        } finally {
            fileInputStream.close();
        }
    }

    private Map<String, File> toMap(Set<String> set, File file) {
        HashMap hashMap = new HashMap();
        for (String put : set) {
            hashMap.put(put, file);
        }
        return hashMap;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:27|28|29|30|33|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0069, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        "Could not load font file: " + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        org.apache.pdfbox.io.IOUtils.closeQuietly(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0087, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.apache.fontbox.cff.CFFFont getCFFFont(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.Map<java.lang.String, org.apache.fontbox.cff.CFFFont> r0 = r7.cffFonts     // Catch:{ all -> 0x0088 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0088 }
            org.apache.fontbox.cff.CFFFont r0 = (org.apache.fontbox.cff.CFFFont) r0     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r7)
            return r0
        L_0x000d:
            java.util.Map<java.lang.String, java.io.File> r0 = r7.cffFontFiles     // Catch:{ all -> 0x0088 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0088 }
            java.io.File r0 = (java.io.File) r0     // Catch:{ all -> 0x0088 }
            r1 = 0
            if (r0 == 0) goto L_0x0086
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            r2.<init>(r0)     // Catch:{ IOException -> 0x006d, all -> 0x006b }
            byte[] r3 = org.apache.pdfbox.io.IOUtils.toByteArray(r2)     // Catch:{ IOException -> 0x006e }
            org.apache.fontbox.cff.CFFParser r4 = new org.apache.fontbox.cff.CFFParser     // Catch:{ IOException -> 0x006e }
            r4.<init>()     // Catch:{ IOException -> 0x006e }
            java.util.List r3 = r4.parse(r3)     // Catch:{ IOException -> 0x006e }
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch:{ IOException -> 0x006e }
            org.apache.fontbox.cff.CFFFont r3 = (org.apache.fontbox.cff.CFFFont) r3     // Catch:{ IOException -> 0x006e }
            java.util.Set r4 = r7.getNames(r3)     // Catch:{ IOException -> 0x006e }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x006e }
        L_0x0039:
            boolean r5 = r4.hasNext()     // Catch:{ IOException -> 0x006e }
            if (r5 == 0) goto L_0x004b
            java.lang.Object r5 = r4.next()     // Catch:{ IOException -> 0x006e }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x006e }
            java.util.Map<java.lang.String, org.apache.fontbox.cff.CFFFont> r6 = r7.cffFonts     // Catch:{ IOException -> 0x006e }
            r6.put(r5, r3)     // Catch:{ IOException -> 0x006e }
            goto L_0x0039
        L_0x004b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x006e }
            r4.<init>()     // Catch:{ IOException -> 0x006e }
            java.lang.String r5 = "Loaded "
            r4.append(r5)     // Catch:{ IOException -> 0x006e }
            r4.append(r8)     // Catch:{ IOException -> 0x006e }
            java.lang.String r8 = " from "
            r4.append(r8)     // Catch:{ IOException -> 0x006e }
            r4.append(r0)     // Catch:{ IOException -> 0x006e }
            r4.toString()     // Catch:{ IOException -> 0x006e }
            org.apache.pdfbox.io.IOUtils.closeQuietly(r2)     // Catch:{ all -> 0x0088 }
            monitor-exit(r7)
            return r3
        L_0x0068:
            r8 = move-exception
            r1 = r2
            goto L_0x0082
        L_0x006b:
            r8 = move-exception
            goto L_0x0082
        L_0x006d:
            r2 = r1
        L_0x006e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            r8.<init>()     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = "Could not load font file: "
            r8.append(r3)     // Catch:{ all -> 0x0068 }
            r8.append(r0)     // Catch:{ all -> 0x0068 }
            r8.toString()     // Catch:{ all -> 0x0068 }
            org.apache.pdfbox.io.IOUtils.closeQuietly(r2)     // Catch:{ all -> 0x0088 }
            goto L_0x0086
        L_0x0082:
            org.apache.pdfbox.io.IOUtils.closeQuietly(r1)     // Catch:{ all -> 0x0088 }
            throw r8     // Catch:{ all -> 0x0088 }
        L_0x0086:
            monitor-exit(r7)
            return r1
        L_0x0088:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.font.FileSystemFontProvider.getCFFFont(java.lang.String):org.apache.fontbox.cff.CFFFont");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0056 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.apache.fontbox.ttf.TrueTypeFont getTrueTypeFont(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.Map<java.lang.String, org.apache.fontbox.ttf.TrueTypeFont> r0 = r5.ttfFonts     // Catch:{ all -> 0x007a }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x007a }
            org.apache.fontbox.ttf.TrueTypeFont r0 = (org.apache.fontbox.ttf.TrueTypeFont) r0     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r5)
            return r0
        L_0x000d:
            java.util.Map<java.lang.String, java.io.File> r0 = r5.ttfFontFiles     // Catch:{ all -> 0x007a }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x007a }
            java.io.File r0 = (java.io.File) r0     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0077
            org.apache.fontbox.ttf.TTFParser r1 = new org.apache.fontbox.ttf.TTFParser     // Catch:{ all -> 0x007a }
            r2 = 0
            r3 = 1
            r1.<init>(r2, r3)     // Catch:{ all -> 0x007a }
            org.apache.fontbox.ttf.TrueTypeFont r1 = r1.parse(r0)     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            java.util.Set r2 = r5.getNames(r1)     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
        L_0x002a:
            boolean r3 = r2.hasNext()     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            if (r3 == 0) goto L_0x003c
            java.lang.Object r3 = r2.next()     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            java.util.Map<java.lang.String, org.apache.fontbox.ttf.TrueTypeFont> r4 = r5.ttfFonts     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            r4.put(r3, r1)     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            goto L_0x002a
        L_0x003c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            r2.<init>()     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            java.lang.String r3 = "Loaded "
            r2.append(r3)     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            r2.append(r6)     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            java.lang.String r6 = " from "
            r2.append(r6)     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            r2.append(r0)     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            r2.toString()     // Catch:{ NullPointerException -> 0x0067, IOException -> 0x0056 }
            monitor-exit(r5)
            return r1
        L_0x0056:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
            r6.<init>()     // Catch:{ all -> 0x007a }
            java.lang.String r1 = "Could not load font file: "
            r6.append(r1)     // Catch:{ all -> 0x007a }
            r6.append(r0)     // Catch:{ all -> 0x007a }
            r6.toString()     // Catch:{ all -> 0x007a }
            goto L_0x0077
        L_0x0067:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
            r6.<init>()     // Catch:{ all -> 0x007a }
            java.lang.String r1 = "Could not load font file: "
            r6.append(r1)     // Catch:{ all -> 0x007a }
            r6.append(r0)     // Catch:{ all -> 0x007a }
            r6.toString()     // Catch:{ all -> 0x007a }
        L_0x0077:
            r6 = 0
            monitor-exit(r5)
            return r6
        L_0x007a:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.font.FileSystemFontProvider.getTrueTypeFont(java.lang.String):org.apache.fontbox.ttf.TrueTypeFont");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:27|28|29|30|33|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        "Could not load font file: " + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        org.apache.pdfbox.io.IOUtils.closeQuietly(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0077, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized org.apache.fontbox.type1.Type1Font getType1Font(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.Map<java.lang.String, org.apache.fontbox.type1.Type1Font> r0 = r7.type1Fonts     // Catch:{ all -> 0x0078 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0078 }
            org.apache.fontbox.type1.Type1Font r0 = (org.apache.fontbox.type1.Type1Font) r0     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r7)
            return r0
        L_0x000d:
            java.util.Map<java.lang.String, java.io.File> r0 = r7.type1FontFiles     // Catch:{ all -> 0x0078 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0078 }
            java.io.File r0 = (java.io.File) r0     // Catch:{ all -> 0x0078 }
            r1 = 0
            if (r0 == 0) goto L_0x0076
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x005d, all -> 0x005b }
            r2.<init>(r0)     // Catch:{ IOException -> 0x005d, all -> 0x005b }
            org.apache.fontbox.type1.Type1Font r3 = org.apache.fontbox.type1.Type1Font.createWithPFB(r2)     // Catch:{ IOException -> 0x005e }
            java.util.Set r4 = r7.getNames(r3)     // Catch:{ IOException -> 0x005e }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ IOException -> 0x005e }
        L_0x0029:
            boolean r5 = r4.hasNext()     // Catch:{ IOException -> 0x005e }
            if (r5 == 0) goto L_0x003b
            java.lang.Object r5 = r4.next()     // Catch:{ IOException -> 0x005e }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x005e }
            java.util.Map<java.lang.String, org.apache.fontbox.type1.Type1Font> r6 = r7.type1Fonts     // Catch:{ IOException -> 0x005e }
            r6.put(r5, r3)     // Catch:{ IOException -> 0x005e }
            goto L_0x0029
        L_0x003b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x005e }
            r4.<init>()     // Catch:{ IOException -> 0x005e }
            java.lang.String r5 = "Loaded "
            r4.append(r5)     // Catch:{ IOException -> 0x005e }
            r4.append(r8)     // Catch:{ IOException -> 0x005e }
            java.lang.String r8 = " from "
            r4.append(r8)     // Catch:{ IOException -> 0x005e }
            r4.append(r0)     // Catch:{ IOException -> 0x005e }
            r4.toString()     // Catch:{ IOException -> 0x005e }
            org.apache.pdfbox.io.IOUtils.closeQuietly(r2)     // Catch:{ all -> 0x0078 }
            monitor-exit(r7)
            return r3
        L_0x0058:
            r8 = move-exception
            r1 = r2
            goto L_0x0072
        L_0x005b:
            r8 = move-exception
            goto L_0x0072
        L_0x005d:
            r2 = r1
        L_0x005e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0058 }
            r8.<init>()     // Catch:{ all -> 0x0058 }
            java.lang.String r3 = "Could not load font file: "
            r8.append(r3)     // Catch:{ all -> 0x0058 }
            r8.append(r0)     // Catch:{ all -> 0x0058 }
            r8.toString()     // Catch:{ all -> 0x0058 }
            org.apache.pdfbox.io.IOUtils.closeQuietly(r2)     // Catch:{ all -> 0x0078 }
            goto L_0x0076
        L_0x0072:
            org.apache.pdfbox.io.IOUtils.closeQuietly(r1)     // Catch:{ all -> 0x0078 }
            throw r8     // Catch:{ all -> 0x0078 }
        L_0x0076:
            monitor-exit(r7)
            return r1
        L_0x0078:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.font.FileSystemFontProvider.getType1Font(java.lang.String):org.apache.fontbox.type1.Type1Font");
    }

    public String toDebugString() {
        StringBuilder sb = new StringBuilder();
        for (Entry next : this.ttfFontFiles.entrySet()) {
            sb.append("TTF: ");
            sb.append((String) next.getKey());
            sb.append(": ");
            sb.append(((File) next.getValue()).getPath());
            sb.append(10);
        }
        for (Entry next2 : this.cffFontFiles.entrySet()) {
            sb.append("OTF: ");
            sb.append((String) next2.getKey());
            sb.append(": ");
            sb.append(((File) next2.getValue()).getPath());
            sb.append(10);
        }
        for (Entry next3 : this.type1FontFiles.entrySet()) {
            sb.append("PFB: ");
            sb.append((String) next3.getKey());
            sb.append(": ");
            sb.append(((File) next3.getValue()).getPath());
            sb.append(10);
        }
        return sb.toString();
    }
}
