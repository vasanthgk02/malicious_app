package com.android.vending.expansion.zipfile;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import co.hyperverge.hypersnapsdk.c.k;
import com.android.vending.expansion.zipfile.ZipResourceFile.ZipEntryRO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public abstract class APEZProvider extends ContentProvider {
    public static final String[] ALL_FIELDS = {"_id", "ZPFN", "ZFIL", "ZMOD", "ZCRC", "ZCOL", "ZUNL", "ZTYP"};
    public static final int[] ALL_FIELDS_INT = {0, 1, 2, 3, 4, 5, 6, 7};
    public ZipResourceFile mAPKExtensionFile;
    public boolean mInit;

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        initIfNecessary();
        return super.applyBatch(arrayList);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public abstract String getAuthority();

    public String getType(Uri uri) {
        return "vnd.android.cursor.item/asset";
    }

    public final boolean initIfNecessary() {
        int i;
        if (!this.mInit) {
            Context context = getContext();
            PackageManager packageManager = context.getPackageManager();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(getAuthority(), 128);
            try {
                int i2 = packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
                String[] strArr = null;
                Bundle bundle = resolveContentProvider.metaData;
                if (bundle != null) {
                    int i3 = bundle.getInt("mainVersion", i2);
                    int i4 = resolveContentProvider.metaData.getInt("patchVersion", i2);
                    String string = resolveContentProvider.metaData.getString("mainFilename", "N");
                    if ("N" != string) {
                        String string2 = resolveContentProvider.metaData.getString("patchFilename", "N");
                        if ("N" != string2) {
                            strArr = new String[]{string, string2};
                        } else {
                            strArr = new String[]{string};
                        }
                    }
                    i = i4;
                    i2 = i3;
                } else {
                    i = i2;
                }
                if (strArr == null) {
                    try {
                        this.mAPKExtensionFile = k.getAPKExpansionZipFile(context, i2, i);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    this.mAPKExtensionFile = k.getResourceZipFile(strArr);
                }
                this.mInit = true;
                return true;
            } catch (NameNotFoundException e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        initIfNecessary();
        String encodedPath = uri.getEncodedPath();
        if (encodedPath.startsWith("/")) {
            encodedPath = encodedPath.substring(1);
        }
        return this.mAPKExtensionFile.getAssetFileDescriptor(encodedPath);
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        initIfNecessary();
        AssetFileDescriptor openAssetFile = openAssetFile(uri, str);
        if (openAssetFile != null) {
            return openAssetFile.getParcelFileDescriptor();
        }
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        ZipEntryRO[] zipEntryROArr;
        int[] iArr;
        initIfNecessary();
        ZipResourceFile zipResourceFile = this.mAPKExtensionFile;
        if (zipResourceFile == null) {
            zipEntryROArr = new ZipEntryRO[0];
        } else {
            Collection<ZipEntryRO> values = zipResourceFile.mHashMap.values();
            zipEntryROArr = (ZipEntryRO[]) values.toArray(new ZipEntryRO[values.size()]);
        }
        if (strArr == null) {
            iArr = ALL_FIELDS_INT;
            strArr = ALL_FIELDS;
        } else {
            int length = strArr.length;
            iArr = new int[length];
            for (int i = 0; i < length; i++) {
                if (strArr[i].equals("_id")) {
                    iArr[i] = 0;
                } else if (strArr[i].equals("ZPFN")) {
                    iArr[i] = 1;
                } else if (strArr[i].equals("ZFIL")) {
                    iArr[i] = 2;
                } else if (strArr[i].equals("ZMOD")) {
                    iArr[i] = 3;
                } else if (strArr[i].equals("ZCRC")) {
                    iArr[i] = 4;
                } else if (strArr[i].equals("ZCOL")) {
                    iArr[i] = 5;
                } else if (strArr[i].equals("ZUNL")) {
                    iArr[i] = 6;
                } else if (strArr[i].equals("ZTYP")) {
                    iArr[i] = 7;
                } else {
                    throw new RuntimeException();
                }
            }
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr, zipEntryROArr.length);
        int length2 = iArr.length;
        for (ZipEntryRO zipEntryRO : zipEntryROArr) {
            RowBuilder newRow = matrixCursor.newRow();
            for (int i2 = 0; i2 < length2; i2++) {
                switch (iArr[i2]) {
                    case 0:
                        newRow.add(Integer.valueOf(i2));
                        break;
                    case 1:
                        newRow.add(zipEntryRO.mFileName);
                        break;
                    case 2:
                        newRow.add(zipEntryRO.mZipFileName);
                        break;
                    case 3:
                        newRow.add(Long.valueOf(zipEntryRO.mWhenModified));
                        break;
                    case 4:
                        newRow.add(Long.valueOf(zipEntryRO.mCRC32));
                        break;
                    case 5:
                        newRow.add(Long.valueOf(zipEntryRO.mCompressedLength));
                        break;
                    case 6:
                        newRow.add(Long.valueOf(zipEntryRO.mUncompressedLength));
                        break;
                    case 7:
                        newRow.add(Integer.valueOf(zipEntryRO.mMethod));
                        break;
                }
            }
        }
        return matrixCursor;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
