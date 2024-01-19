package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.UnpackingSoSource.Dso;
import com.facebook.soloader.UnpackingSoSource.DsoManifest;
import com.facebook.soloader.UnpackingSoSource.InputDso;
import com.facebook.soloader.UnpackingSoSource.InputDsoIterator;
import com.facebook.soloader.UnpackingSoSource.Unpacker;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class ExoSoSource extends UnpackingSoSource {

    public final class ExoUnpacker extends Unpacker {
        public final FileDso[] mDsos;

        public final class FileBackedInputDsoIterator extends InputDsoIterator {
            public int mCurrentDso;

            public FileBackedInputDsoIterator(AnonymousClass1 r2) {
            }

            public boolean hasNext() {
                return this.mCurrentDso < ExoUnpacker.this.mDsos.length;
            }

            public InputDso next() throws IOException {
                FileDso[] fileDsoArr = ExoUnpacker.this.mDsos;
                int i = this.mCurrentDso;
                this.mCurrentDso = i + 1;
                FileDso fileDso = fileDsoArr[i];
                FileInputStream fileInputStream = new FileInputStream(fileDso.backingFile);
                try {
                    return new InputDso(fileDso, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r7.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00dc, code lost:
            r9.close();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ExoUnpacker(com.facebook.soloader.ExoSoSource r17, com.facebook.soloader.UnpackingSoSource r18) throws java.io.IOException {
            /*
                r16 = this;
                r16.<init>()
                r0 = r17
                android.content.Context r0 = r0.mContext
                java.io.File r1 = new java.io.File
                java.lang.String r2 = "/data/local/tmp/exopackage/"
                java.lang.StringBuilder r2 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r2)
                java.lang.String r0 = r0.getPackageName()
                r2.append(r0)
                java.lang.String r0 = "/native-libs/"
                r2.append(r0)
                java.lang.String r0 = r2.toString()
                r1.<init>(r0)
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.LinkedHashSet r2 = new java.util.LinkedHashSet
                r2.<init>()
                java.lang.String[] r3 = com.facebook.drawee.backends.pipeline.info.ImageOriginUtils.getSupportedAbis()
                int r4 = r3.length
                r5 = 0
                r6 = 0
            L_0x0033:
                if (r6 >= r4) goto L_0x0101
                r7 = r3[r6]
                java.io.File r8 = new java.io.File
                r8.<init>(r1, r7)
                boolean r9 = r8.isDirectory()
                if (r9 != 0) goto L_0x0044
                goto L_0x00df
            L_0x0044:
                r2.add(r7)
                java.io.File r7 = new java.io.File
                java.lang.String r9 = "metadata.txt"
                r7.<init>(r8, r9)
                boolean r9 = r7.isFile()
                if (r9 != 0) goto L_0x0056
                goto L_0x00df
            L_0x0056:
                java.io.FileReader r9 = new java.io.FileReader
                r9.<init>(r7)
                java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ all -> 0x00f2 }
                r7.<init>(r9)     // Catch:{ all -> 0x00f2 }
            L_0x0060:
                java.lang.String r10 = r7.readLine()     // Catch:{ all -> 0x00e3 }
                if (r10 == 0) goto L_0x00d9
                int r11 = r10.length()     // Catch:{ all -> 0x00e3 }
                if (r11 != 0) goto L_0x006d
                goto L_0x0060
            L_0x006d:
                r11 = 32
                int r11 = r10.indexOf(r11)     // Catch:{ all -> 0x00e3 }
                r12 = -1
                if (r11 == r12) goto L_0x00bd
                java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e3 }
                r12.<init>()     // Catch:{ all -> 0x00e3 }
                java.lang.String r13 = r10.substring(r5, r11)     // Catch:{ all -> 0x00e3 }
                r12.append(r13)     // Catch:{ all -> 0x00e3 }
                java.lang.String r13 = ".so"
                r12.append(r13)     // Catch:{ all -> 0x00e3 }
                java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00e3 }
                int r13 = r0.size()     // Catch:{ all -> 0x00e3 }
                r14 = 0
            L_0x0090:
                if (r14 >= r13) goto L_0x00a5
                java.lang.Object r15 = r0.get(r14)     // Catch:{ all -> 0x00e3 }
                com.facebook.soloader.ExoSoSource$FileDso r15 = (com.facebook.soloader.ExoSoSource.FileDso) r15     // Catch:{ all -> 0x00e3 }
                java.lang.String r15 = r15.name     // Catch:{ all -> 0x00e3 }
                boolean r15 = r15.equals(r12)     // Catch:{ all -> 0x00e3 }
                if (r15 == 0) goto L_0x00a2
                r13 = 1
                goto L_0x00a6
            L_0x00a2:
                int r14 = r14 + 1
                goto L_0x0090
            L_0x00a5:
                r13 = 0
            L_0x00a6:
                if (r13 == 0) goto L_0x00a9
                goto L_0x0060
            L_0x00a9:
                int r11 = r11 + 1
                java.lang.String r10 = r10.substring(r11)     // Catch:{ all -> 0x00e3 }
                com.facebook.soloader.ExoSoSource$FileDso r11 = new com.facebook.soloader.ExoSoSource$FileDso     // Catch:{ all -> 0x00e3 }
                java.io.File r13 = new java.io.File     // Catch:{ all -> 0x00e3 }
                r13.<init>(r8, r10)     // Catch:{ all -> 0x00e3 }
                r11.<init>(r12, r10, r13)     // Catch:{ all -> 0x00e3 }
                r0.add(r11)     // Catch:{ all -> 0x00e3 }
                goto L_0x0060
            L_0x00bd:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x00e3 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e3 }
                r1.<init>()     // Catch:{ all -> 0x00e3 }
                java.lang.String r2 = "illegal line in exopackage metadata: ["
                r1.append(r2)     // Catch:{ all -> 0x00e3 }
                r1.append(r10)     // Catch:{ all -> 0x00e3 }
                java.lang.String r2 = "]"
                r1.append(r2)     // Catch:{ all -> 0x00e3 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e3 }
                r0.<init>(r1)     // Catch:{ all -> 0x00e3 }
                throw r0     // Catch:{ all -> 0x00e3 }
            L_0x00d9:
                r7.close()     // Catch:{ all -> 0x00f2 }
                r9.close()
            L_0x00df:
                int r6 = r6 + 1
                goto L_0x0033
            L_0x00e3:
                r0 = move-exception
                r1 = r0
                throw r1     // Catch:{ all -> 0x00e6 }
            L_0x00e6:
                r0 = move-exception
                r2 = r0
                r7.close()     // Catch:{ all -> 0x00ec }
                goto L_0x00f1
            L_0x00ec:
                r0 = move-exception
                r3 = r0
                r1.addSuppressed(r3)     // Catch:{ all -> 0x00f2 }
            L_0x00f1:
                throw r2     // Catch:{ all -> 0x00f2 }
            L_0x00f2:
                r0 = move-exception
                r1 = r0
                throw r1     // Catch:{ all -> 0x00f5 }
            L_0x00f5:
                r0 = move-exception
                r2 = r0
                r9.close()     // Catch:{ all -> 0x00fb }
                goto L_0x0100
            L_0x00fb:
                r0 = move-exception
                r3 = r0
                r1.addSuppressed(r3)
            L_0x0100:
                throw r2
            L_0x0101:
                int r1 = r2.size()
                java.lang.String[] r1 = new java.lang.String[r1]
                java.lang.Object[] r1 = r2.toArray(r1)
                java.lang.String[] r1 = (java.lang.String[]) r1
                int r1 = r0.size()
                com.facebook.soloader.ExoSoSource$FileDso[] r1 = new com.facebook.soloader.ExoSoSource.FileDso[r1]
                java.lang.Object[] r0 = r0.toArray(r1)
                com.facebook.soloader.ExoSoSource$FileDso[] r0 = (com.facebook.soloader.ExoSoSource.FileDso[]) r0
                r1 = r16
                r1.mDsos = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.ExoSoSource.ExoUnpacker.<init>(com.facebook.soloader.ExoSoSource, com.facebook.soloader.UnpackingSoSource):void");
        }

        public DsoManifest getDsoManifest() throws IOException {
            return new DsoManifest(this.mDsos);
        }

        public InputDsoIterator openDsoIterator() throws IOException {
            return new FileBackedInputDsoIterator(null);
        }
    }

    public static final class FileDso extends Dso {
        public final File backingFile;

        public FileDso(String str, String str2, File file) {
            super(str, str2);
            this.backingFile = file;
        }
    }

    public ExoSoSource(Context context, String str) {
        super(context, str);
    }

    public Unpacker makeUnpacker() throws IOException {
        return new ExoUnpacker(this, this);
    }
}
