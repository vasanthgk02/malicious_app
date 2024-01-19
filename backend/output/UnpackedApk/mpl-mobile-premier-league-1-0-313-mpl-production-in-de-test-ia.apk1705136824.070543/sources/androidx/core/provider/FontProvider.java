package androidx.core.provider;

import java.util.Comparator;

public class FontProvider {
    public static final Comparator<byte[]> sByteArrayComparator = new Comparator<byte[]>() {
        public int compare(Object obj, Object obj2) {
            int i;
            int i2;
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = (byte[]) obj2;
            if (bArr.length != bArr2.length) {
                i2 = bArr.length;
                i = bArr2.length;
            } else {
                int i3 = 0;
                while (i3 < bArr.length) {
                    if (bArr[i3] != bArr2[i3]) {
                        i2 = bArr[i3];
                        i = bArr2[i3];
                    } else {
                        i3++;
                    }
                }
                return 0;
            }
            return i2 - i;
        }
    };

    /* JADX WARNING: type inference failed for: r5v0, types: [android.content.pm.ProviderInfo] */
    /* JADX WARNING: type inference failed for: r7v2, types: [androidx.core.provider.FontsContractCompat$FontInfo[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [android.content.pm.ProviderInfo] */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r7v2, types: [androidx.core.provider.FontsContractCompat$FontInfo[], android.database.Cursor]
      assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY]]
      uses: [?[OBJECT, ARRAY], ?[int, boolean, OBJECT, ARRAY, byte, short, char], android.database.Cursor, androidx.core.provider.FontsContractCompat$FontInfo[]]
      mth insns count: 139
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.core.provider.FontsContractCompat$FontFamilyResult getFontFamilyResult(android.content.Context r20, androidx.core.provider.FontRequest r21, android.os.CancellationSignal r22) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r0 = r21
            android.content.pm.PackageManager r1 = r20.getPackageManager()
            android.content.res.Resources r2 = r20.getResources()
            java.lang.String r3 = r0.mProviderAuthority
            r4 = 0
            android.content.pm.ProviderInfo r5 = r1.resolveContentProvider(r3, r4)
            if (r5 == 0) goto L_0x01af
            java.lang.String r6 = r5.packageName
            java.lang.String r7 = r0.mProviderPackage
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0198
            java.lang.String r3 = r5.packageName
            r6 = 64
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r3, r6)
            android.content.pm.Signature[] r1 = r1.signatures
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r6 = 0
        L_0x002d:
            int r7 = r1.length
            if (r6 >= r7) goto L_0x003c
            r7 = r1[r6]
            byte[] r7 = r7.toByteArray()
            r3.add(r7)
            int r6 = r6 + 1
            goto L_0x002d
        L_0x003c:
            java.util.Comparator<byte[]> r1 = sByteArrayComparator
            java.util.Collections.sort(r3, r1)
            java.util.List<java.util.List<byte[]>> r1 = r0.mCertificates
            if (r1 == 0) goto L_0x0046
            goto L_0x004c
        L_0x0046:
            int r1 = r0.mCertificatesArray
            java.util.List r1 = a.a.a.a.d.b.readCerts(r2, r1)
        L_0x004c:
            r2 = 0
        L_0x004d:
            int r6 = r1.size()
            r7 = 0
            r8 = 1
            if (r2 >= r6) goto L_0x0095
            java.util.ArrayList r6 = new java.util.ArrayList
            java.lang.Object r9 = r1.get(r2)
            java.util.Collection r9 = (java.util.Collection) r9
            r6.<init>(r9)
            java.util.Comparator<byte[]> r9 = sByteArrayComparator
            java.util.Collections.sort(r6, r9)
            int r9 = r3.size()
            int r10 = r6.size()
            if (r9 == r10) goto L_0x0070
            goto L_0x0089
        L_0x0070:
            r9 = 0
        L_0x0071:
            int r10 = r3.size()
            if (r9 >= r10) goto L_0x008e
            java.lang.Object r10 = r3.get(r9)
            byte[] r10 = (byte[]) r10
            java.lang.Object r11 = r6.get(r9)
            byte[] r11 = (byte[]) r11
            boolean r10 = java.util.Arrays.equals(r10, r11)
            if (r10 != 0) goto L_0x008b
        L_0x0089:
            r6 = 0
            goto L_0x008f
        L_0x008b:
            int r9 = r9 + 1
            goto L_0x0071
        L_0x008e:
            r6 = 1
        L_0x008f:
            if (r6 == 0) goto L_0x0092
            goto L_0x0096
        L_0x0092:
            int r2 = r2 + 1
            goto L_0x004d
        L_0x0095:
            r5 = r7
        L_0x0096:
            if (r5 != 0) goto L_0x009e
            androidx.core.provider.FontsContractCompat$FontFamilyResult r0 = new androidx.core.provider.FontsContractCompat$FontFamilyResult
            r0.<init>(r8, r7)
            return r0
        L_0x009e:
            java.lang.String r1 = r5.authority
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.net.Uri$Builder r3 = new android.net.Uri$Builder
            r3.<init>()
            java.lang.String r5 = "content"
            android.net.Uri$Builder r3 = r3.scheme(r5)
            android.net.Uri$Builder r3 = r3.authority(r1)
            android.net.Uri r3 = r3.build()
            android.net.Uri$Builder r6 = new android.net.Uri$Builder
            r6.<init>()
            android.net.Uri$Builder r5 = r6.scheme(r5)
            android.net.Uri$Builder r1 = r5.authority(r1)
            java.lang.String r5 = "file"
            android.net.Uri$Builder r1 = r1.appendPath(r5)
            android.net.Uri r1 = r1.build()
            java.lang.String r9 = "_id"
            java.lang.String r10 = "file_id"
            java.lang.String r11 = "font_ttc_index"
            java.lang.String r12 = "font_variation_settings"
            java.lang.String r13 = "font_weight"
            java.lang.String r14 = "font_italic"
            java.lang.String r15 = "result_code"
            java.lang.String[] r11 = new java.lang.String[]{r9, r10, r11, r12, r13, r14, r15}     // Catch:{ all -> 0x0191 }
            android.content.ContentResolver r9 = r20.getContentResolver()     // Catch:{ all -> 0x0191 }
            java.lang.String r12 = "query = ?"
            java.lang.String[] r13 = new java.lang.String[r8]     // Catch:{ all -> 0x0191 }
            java.lang.String r0 = r0.mQuery     // Catch:{ all -> 0x0191 }
            r13[r4] = r0     // Catch:{ all -> 0x0191 }
            r14 = 0
            r15 = 0
            r10 = r3
            android.database.Cursor r7 = r9.query(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x0191 }
            if (r7 == 0) goto L_0x017e
            int r0 = r7.getCount()     // Catch:{ all -> 0x0191 }
            if (r0 <= 0) goto L_0x017e
            java.lang.String r0 = "result_code"
            int r0 = r7.getColumnIndex(r0)     // Catch:{ all -> 0x0191 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0191 }
            r2.<init>()     // Catch:{ all -> 0x0191 }
            java.lang.String r5 = "_id"
            int r5 = r7.getColumnIndex(r5)     // Catch:{ all -> 0x0191 }
            java.lang.String r6 = "file_id"
            int r6 = r7.getColumnIndex(r6)     // Catch:{ all -> 0x0191 }
            java.lang.String r9 = "font_ttc_index"
            int r9 = r7.getColumnIndex(r9)     // Catch:{ all -> 0x0191 }
            java.lang.String r10 = "font_weight"
            int r10 = r7.getColumnIndex(r10)     // Catch:{ all -> 0x0191 }
            java.lang.String r11 = "font_italic"
            int r11 = r7.getColumnIndex(r11)     // Catch:{ all -> 0x0191 }
        L_0x0125:
            boolean r12 = r7.moveToNext()     // Catch:{ all -> 0x0191 }
            if (r12 == 0) goto L_0x017e
            r12 = -1
            if (r0 == r12) goto L_0x0135
            int r13 = r7.getInt(r0)     // Catch:{ all -> 0x0191 }
            r19 = r13
            goto L_0x0138
        L_0x0135:
            r13 = 0
            r19 = 0
        L_0x0138:
            if (r9 == r12) goto L_0x0141
            int r13 = r7.getInt(r9)     // Catch:{ all -> 0x0191 }
            r16 = r13
            goto L_0x0144
        L_0x0141:
            r13 = 0
            r16 = 0
        L_0x0144:
            if (r6 != r12) goto L_0x014f
            long r13 = r7.getLong(r5)     // Catch:{ all -> 0x0191 }
            android.net.Uri r13 = android.content.ContentUris.withAppendedId(r3, r13)     // Catch:{ all -> 0x0191 }
            goto L_0x0157
        L_0x014f:
            long r13 = r7.getLong(r6)     // Catch:{ all -> 0x0191 }
            android.net.Uri r13 = android.content.ContentUris.withAppendedId(r1, r13)     // Catch:{ all -> 0x0191 }
        L_0x0157:
            r15 = r13
            if (r10 == r12) goto L_0x0161
            int r13 = r7.getInt(r10)     // Catch:{ all -> 0x0191 }
            r17 = r13
            goto L_0x0165
        L_0x0161:
            r13 = 400(0x190, float:5.6E-43)
            r17 = 400(0x190, float:5.6E-43)
        L_0x0165:
            if (r11 == r12) goto L_0x0171
            int r12 = r7.getInt(r11)     // Catch:{ all -> 0x0191 }
            if (r12 != r8) goto L_0x0171
            r12 = 1
            r18 = 1
            goto L_0x0174
        L_0x0171:
            r12 = 0
            r18 = 0
        L_0x0174:
            androidx.core.provider.FontsContractCompat$FontInfo r12 = new androidx.core.provider.FontsContractCompat$FontInfo     // Catch:{ all -> 0x0191 }
            r14 = r12
            r14.<init>(r15, r16, r17, r18, r19)     // Catch:{ all -> 0x0191 }
            r2.add(r12)     // Catch:{ all -> 0x0191 }
            goto L_0x0125
        L_0x017e:
            if (r7 == 0) goto L_0x0183
            r7.close()
        L_0x0183:
            androidx.core.provider.FontsContractCompat$FontInfo[] r0 = new androidx.core.provider.FontsContractCompat$FontInfo[r4]
            java.lang.Object[] r0 = r2.toArray(r0)
            androidx.core.provider.FontsContractCompat$FontInfo[] r0 = (androidx.core.provider.FontsContractCompat$FontInfo[]) r0
            androidx.core.provider.FontsContractCompat$FontFamilyResult r1 = new androidx.core.provider.FontsContractCompat$FontFamilyResult
            r1.<init>(r4, r0)
            return r1
        L_0x0191:
            r0 = move-exception
            if (r7 == 0) goto L_0x0197
            r7.close()
        L_0x0197:
            throw r0
        L_0x0198:
            android.content.pm.PackageManager$NameNotFoundException r1 = new android.content.pm.PackageManager$NameNotFoundException
            java.lang.String r2 = "Found content provider "
            java.lang.String r4 = ", but package was not "
            java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline80(r2, r3, r4)
            java.lang.String r0 = r0.mProviderPackage
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x01af:
            android.content.pm.PackageManager$NameNotFoundException r0 = new android.content.pm.PackageManager$NameNotFoundException
            java.lang.String r1 = "No package found for authority: "
            java.lang.String r1 = com.android.tools.r8.GeneratedOutlineSupport.outline50(r1, r3)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontProvider.getFontFamilyResult(android.content.Context, androidx.core.provider.FontRequest, android.os.CancellationSignal):androidx.core.provider.FontsContractCompat$FontFamilyResult");
    }
}
