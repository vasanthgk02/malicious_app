package com.facebook.soloader;

import android.content.Context;
import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import com.facebook.soloader.UnpackingSoSource.Dso;
import com.facebook.soloader.UnpackingSoSource.DsoManifest;
import com.facebook.soloader.UnpackingSoSource.InputDso;
import com.facebook.soloader.UnpackingSoSource.InputDsoIterator;
import com.facebook.soloader.UnpackingSoSource.Unpacker;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ExtractFromZipSoSource extends UnpackingSoSource {
    public final File mZipFileName;
    public final String mZipSearchPattern;

    public static final class ZipDso extends Dso implements Comparable {
        public final int abiScore;
        public final ZipEntry backingEntry;

        public ZipDso(String str, ZipEntry zipEntry, int i) {
            super(str, String.format("pseudo-zip-hash-1-%s-%s-%s-%s", new Object[]{zipEntry.getName(), Long.valueOf(zipEntry.getSize()), Long.valueOf(zipEntry.getCompressedSize()), Long.valueOf(zipEntry.getCrc())}));
            this.backingEntry = zipEntry;
            this.abiScore = i;
        }

        public int compareTo(Object obj) {
            return this.name.compareTo(((ZipDso) obj).name);
        }
    }

    public class ZipUnpacker extends Unpacker {
        public ZipDso[] mDsos;
        public final UnpackingSoSource mSoSource;
        public final ZipFile mZipFile;

        public final class ZipBackedInputDsoIterator extends InputDsoIterator {
            public int mCurrentDso;

            public ZipBackedInputDsoIterator(AnonymousClass1 r2) {
            }

            public boolean hasNext() {
                ZipUnpacker.this.ensureDsos();
                return this.mCurrentDso < ZipUnpacker.this.mDsos.length;
            }

            public InputDso next() throws IOException {
                ZipUnpacker.this.ensureDsos();
                ZipUnpacker zipUnpacker = ZipUnpacker.this;
                ZipDso[] zipDsoArr = zipUnpacker.mDsos;
                int i = this.mCurrentDso;
                this.mCurrentDso = i + 1;
                ZipDso zipDso = zipDsoArr[i];
                InputStream inputStream = zipUnpacker.mZipFile.getInputStream(zipDso.backingEntry);
                try {
                    return new InputDso(zipDso, inputStream);
                } catch (Throwable th) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            }
        }

        public ZipUnpacker(UnpackingSoSource unpackingSoSource) throws IOException {
            this.mZipFile = new ZipFile(ExtractFromZipSoSource.this.mZipFileName);
            this.mSoSource = unpackingSoSource;
        }

        public void close() throws IOException {
            this.mZipFile.close();
        }

        public final ZipDso[] ensureDsos() {
            int i;
            if (this.mDsos == null) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                HashMap hashMap = new HashMap();
                Pattern compile = Pattern.compile(ExtractFromZipSoSource.this.mZipSearchPattern);
                String[] supportedAbis = ImageOriginUtils.getSupportedAbis();
                Enumeration<? extends ZipEntry> entries = this.mZipFile.entries();
                while (true) {
                    i = 0;
                    if (!entries.hasMoreElements()) {
                        break;
                    }
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    Matcher matcher = compile.matcher(zipEntry.getName());
                    if (matcher.matches()) {
                        String group = matcher.group(1);
                        String group2 = matcher.group(2);
                        while (true) {
                            if (i < supportedAbis.length) {
                                if (supportedAbis[i] != null && group.equals(supportedAbis[i])) {
                                    break;
                                }
                                i++;
                            } else {
                                i = -1;
                                break;
                            }
                        }
                        if (i >= 0) {
                            linkedHashSet.add(group);
                            ZipDso zipDso = (ZipDso) hashMap.get(group2);
                            if (zipDso == null || i < zipDso.abiScore) {
                                hashMap.put(group2, new ZipDso(group2, zipEntry, i));
                            }
                        }
                    }
                }
                UnpackingSoSource unpackingSoSource = this.mSoSource;
                String[] strArr = (String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]);
                if (unpackingSoSource != null) {
                    ZipDso[] zipDsoArr = (ZipDso[]) hashMap.values().toArray(new ZipDso[hashMap.size()]);
                    Arrays.sort(zipDsoArr);
                    int i2 = 0;
                    for (int i3 = 0; i3 < zipDsoArr.length; i3++) {
                        ZipDso zipDso2 = zipDsoArr[i3];
                        if (shouldExtract(zipDso2.backingEntry, zipDso2.name)) {
                            i2++;
                        } else {
                            zipDsoArr[i3] = null;
                        }
                    }
                    ZipDso[] zipDsoArr2 = new ZipDso[i2];
                    int i4 = 0;
                    while (i < zipDsoArr.length) {
                        ZipDso zipDso3 = zipDsoArr[i];
                        if (zipDso3 != null) {
                            zipDsoArr2[i4] = zipDso3;
                            i4++;
                        }
                        i++;
                    }
                    this.mDsos = zipDsoArr2;
                } else {
                    throw null;
                }
            }
            return this.mDsos;
        }

        public final DsoManifest getDsoManifest() throws IOException {
            return new DsoManifest(ensureDsos());
        }

        public final InputDsoIterator openDsoIterator() throws IOException {
            return new ZipBackedInputDsoIterator(null);
        }

        public abstract boolean shouldExtract(ZipEntry zipEntry, String str);
    }

    public ExtractFromZipSoSource(Context context, String str, File file, String str2) {
        super(context, str);
        this.mZipFileName = file;
        this.mZipSearchPattern = str2;
    }
}
