package com.microsoft.codepush.react;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

public class CodePushUpdateUtils {
    public static final String NEW_LINE = System.getProperty("line.separator");

    public static void addContentsOfFolderToManifest(String str, String str2, ArrayList<String> arrayList) {
        for (File file : new File(str).listFiles()) {
            String name = file.getName();
            String absolutePath = file.getAbsolutePath();
            String outline62 = GeneratedOutlineSupport.outline62(new StringBuilder(), str2.isEmpty() ? "" : GeneratedOutlineSupport.outline50(str2, "/"), name);
            if (!(outline62.startsWith("__MACOSX/") || outline62.equals(".DS_Store") || outline62.endsWith("/.DS_Store") || outline62.equals(".codepushrelease") || outline62.endsWith("/.codepushrelease"))) {
                if (file.isDirectory()) {
                    addContentsOfFolderToManifest(absolutePath, outline62, arrayList);
                } else {
                    try {
                        arrayList.add(outline62 + ":" + computeHash(new FileInputStream(file)));
                    } catch (FileNotFoundException e2) {
                        throw new CodePushUnknownException("Unable to compute hash of update contents.", e2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051 A[SYNTHETIC, Splitter:B:25:0x0051] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String computeHash(java.io.InputStream r5) {
        /*
            r0 = 0
            java.lang.String r1 = "SHA-256"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ NoSuchAlgorithmException -> 0x0041, IOException -> 0x003f, all -> 0x003d }
            java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0041, IOException -> 0x003f, all -> 0x003d }
            r2.<init>(r5, r1)     // Catch:{ NoSuchAlgorithmException -> 0x0041, IOException -> 0x003f, all -> 0x003d }
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r0 = new byte[r0]     // Catch:{ NoSuchAlgorithmException -> 0x003b, IOException -> 0x0039 }
        L_0x0010:
            int r3 = r2.read(r0)     // Catch:{ NoSuchAlgorithmException -> 0x003b, IOException -> 0x0039 }
            r4 = -1
            if (r3 == r4) goto L_0x0018
            goto L_0x0010
        L_0x0018:
            r2.close()     // Catch:{ IOException -> 0x001f }
            r5.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0023:
            byte[] r5 = r1.digest()
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            java.math.BigInteger r3 = new java.math.BigInteger
            r3.<init>(r0, r5)
            r1[r2] = r3
            java.lang.String r5 = "%064x"
            java.lang.String r5 = java.lang.String.format(r5, r1)
            return r5
        L_0x0039:
            r0 = move-exception
            goto L_0x0044
        L_0x003b:
            r0 = move-exception
            goto L_0x0044
        L_0x003d:
            r1 = move-exception
            goto L_0x004f
        L_0x003f:
            r1 = move-exception
            goto L_0x0042
        L_0x0041:
            r1 = move-exception
        L_0x0042:
            r2 = r0
            r0 = r1
        L_0x0044:
            com.microsoft.codepush.react.CodePushUnknownException r1 = new com.microsoft.codepush.react.CodePushUnknownException     // Catch:{ all -> 0x004c }
            java.lang.String r3 = "Unable to compute hash of update contents."
            r1.<init>(r3, r0)     // Catch:{ all -> 0x004c }
            throw r1     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            r1 = r0
            r0 = r2
        L_0x004f:
            if (r0 == 0) goto L_0x0057
            r0.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0057
        L_0x0055:
            r5 = move-exception
            goto L_0x005b
        L_0x0057:
            r5.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x005e
        L_0x005b:
            r5.printStackTrace()
        L_0x005e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.codepush.react.CodePushUpdateUtils.computeHash(java.io.InputStream):java.lang.String");
    }

    public static void copyNecessaryFilesFromCurrentPackage(String str, String str2, String str3) throws IOException {
        TextAppearanceConfig.copyDirectoryContents(str2, str3);
        try {
            JSONArray jSONArray = TextAppearanceConfig.getJsonObjectFromFile(str).getJSONArray("deletedFiles");
            for (int i = 0; i < jSONArray.length(); i++) {
                File file = new File(str3, jSONArray.getString(i));
                if (file.exists()) {
                    file.delete();
                }
            }
        } catch (JSONException e2) {
            throw new CodePushUnknownException("Unable to copy files from current package during diff update", e2);
        }
    }

    public static String findJSBundleInUpdateContents(String str, String str2) {
        for (File file : new File(str).listFiles()) {
            String appendPathComponent = TextAppearanceConfig.appendPathComponent(str, file.getName());
            if (file.isDirectory()) {
                String findJSBundleInUpdateContents = findJSBundleInUpdateContents(appendPathComponent, str2);
                if (findJSBundleInUpdateContents != null) {
                    return TextAppearanceConfig.appendPathComponent(file.getName(), findJSBundleInUpdateContents);
                }
            } else {
                String name = file.getName();
                if (name.equals(str2)) {
                    return name;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001d, code lost:
        return com.google.android.material.resources.TextAppearanceConfig.getStringFromInputStream(r1.getAssets().open("CodePushHash.json"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getHashForBinaryContents(android.content.Context r1, boolean r2) {
        /*
            android.content.res.AssetManager r2 = r1.getAssets()     // Catch:{ IOException -> 0x000f }
            java.lang.String r0 = "CodePushHash"
            java.io.InputStream r2 = r2.open(r0)     // Catch:{ IOException -> 0x000f }
            java.lang.String r1 = com.google.android.material.resources.TextAppearanceConfig.getStringFromInputStream(r2)     // Catch:{ IOException -> 0x000f }
            return r1
        L_0x000f:
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ IOException -> 0x001e }
            java.lang.String r2 = "CodePushHash.json"
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ IOException -> 0x001e }
            java.lang.String r1 = com.google.android.material.resources.TextAppearanceConfig.getStringFromInputStream(r1)     // Catch:{ IOException -> 0x001e }
            return r1
        L_0x001e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microsoft.codepush.react.CodePushUpdateUtils.getHashForBinaryContents(android.content.Context, boolean):java.lang.String");
    }

    public static void verifyFolderHash(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        addContentsOfFolderToManifest(str, "", arrayList);
        Collections.sort(arrayList);
        JSONArray jSONArray = new JSONArray();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        if (!str2.equals(computeHash(new ByteArrayInputStream(jSONArray.toString().replace("\\/", "/").getBytes())))) {
            throw new CodePushInvalidUpdateException("The update contents failed the data integrity check.");
        }
    }
}
