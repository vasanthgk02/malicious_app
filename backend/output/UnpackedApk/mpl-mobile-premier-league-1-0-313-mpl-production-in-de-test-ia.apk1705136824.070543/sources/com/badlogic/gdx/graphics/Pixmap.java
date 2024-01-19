package com.badlogic.gdx.graphics;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Pixmap implements Disposable {
    public Blending blending = Blending.SourceOver;
    public int color = 0;
    public boolean disposed;
    public Filter filter = Filter.BiLinear;
    public final Gdx2DPixmap pixmap;

    public enum Blending {
        None,
        SourceOver
    }

    public interface DownloadPixmapResponseListener {
        void downloadComplete(Pixmap pixmap);

        void downloadFailed(Throwable th);
    }

    public enum Filter {
        NearestNeighbour,
        BiLinear
    }

    public enum Format {
        Alpha,
        Intensity,
        LuminanceAlpha,
        RGB565,
        RGBA4444,
        RGB888,
        RGBA8888;

        public static Format fromGdx2DPixmapFormat(int i) {
            if (i == 1) {
                return Alpha;
            }
            if (i == 2) {
                return LuminanceAlpha;
            }
            if (i == 5) {
                return RGB565;
            }
            if (i == 6) {
                return RGBA4444;
            }
            if (i == 3) {
                return RGB888;
            }
            if (i == 4) {
                return RGBA8888;
            }
            throw new GdxRuntimeException(GeneratedOutlineSupport.outline41("Unknown Gdx2DPixmap Format: ", i));
        }

        public static int toGdx2DPixmapFormat(Format format) {
            if (format == Alpha || format == Intensity) {
                return 1;
            }
            if (format == LuminanceAlpha) {
                return 2;
            }
            if (format == RGB565) {
                return 5;
            }
            if (format == RGBA4444) {
                return 6;
            }
            if (format == RGB888) {
                return 3;
            }
            if (format == RGBA8888) {
                return 4;
            }
            throw new GdxRuntimeException("Unknown Format: " + format);
        }

        public static int toGlFormat(Format format) {
            return Gdx2DPixmap.toGlFormat(toGdx2DPixmapFormat(format));
        }

        public static int toGlType(Format format) {
            return Gdx2DPixmap.toGlType(toGdx2DPixmapFormat(format));
        }
    }

    public Pixmap(int i, int i2, Format format) {
        this.pixmap = new Gdx2DPixmap(i, i2, Format.toGdx2DPixmapFormat(format));
        setColor(0.0f, 0.0f, 0.0f, 0.0f);
        fill();
    }

    public static Pixmap createFromFrameBuffer(int i, int i2, int i3, int i4) {
        k.gl.glPixelStorei(3333, 1);
        Pixmap pixmap2 = new Pixmap(i3, i4, Format.RGBA8888);
        k.gl.glReadPixels(i, i2, i3, i4, GL20.GL_RGBA, GL20.GL_UNSIGNED_BYTE, pixmap2.getPixels());
        return pixmap2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ba A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d5 A[Catch:{ Exception -> 0x0107 }, LOOP:0: B:37:0x00cf->B:39:0x00d5, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void downloadFromUrl(java.lang.String r9, final com.badlogic.gdx.graphics.Pixmap.DownloadPixmapResponseListener r10) {
        /*
            com.badlogic.gdx.Net$HttpRequest r6 = new com.badlogic.gdx.Net$HttpRequest
            java.lang.String r0 = "GET"
            r6.<init>(r0)
            r6.url = r9
            com.badlogic.gdx.Net r9 = co.hyperverge.hypersnapsdk.c.k.f3111net
            com.badlogic.gdx.graphics.Pixmap$1 r7 = new com.badlogic.gdx.graphics.Pixmap$1
            r7.<init>(r10)
            com.badlogic.gdx.backends.android.AndroidNet r9 = (com.badlogic.gdx.backends.android.AndroidNet) r9
            com.badlogic.gdx.net.NetJavaImpl r9 = r9.netJavaImpl
            if (r9 == 0) goto L_0x0114
            java.lang.String r10 = r6.url
            if (r10 != 0) goto L_0x0026
            com.badlogic.gdx.utils.GdxRuntimeException r9 = new com.badlogic.gdx.utils.GdxRuntimeException
            java.lang.String r10 = "can't process a HTTP request without URL set"
            r9.<init>(r10)
            r7.failed(r9)
            goto L_0x010e
        L_0x0026:
            java.lang.String r10 = r6.httpMethod     // Catch:{ Exception -> 0x0107 }
            java.lang.String r0 = "HEAD"
            boolean r0 = r10.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0107 }
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            java.lang.String r3 = "POST"
            boolean r3 = r10.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0107 }
            if (r3 != 0) goto L_0x004f
            java.lang.String r3 = "PUT"
            boolean r3 = r10.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0107 }
            if (r3 != 0) goto L_0x004f
            java.lang.String r3 = "PATCH"
            boolean r3 = r10.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0107 }
            if (r3 == 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r2 = 0
        L_0x004f:
            java.lang.String r1 = "GET"
            boolean r1 = r10.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0107 }
            if (r1 != 0) goto L_0x0068
            java.lang.String r1 = "HEAD"
            boolean r1 = r10.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0107 }
            if (r1 == 0) goto L_0x0060
            goto L_0x0068
        L_0x0060:
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0107 }
            java.lang.String r3 = r6.url     // Catch:{ Exception -> 0x0107 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x0107 }
            goto L_0x009e
        L_0x0068:
            java.lang.String r1 = ""
            java.lang.String r3 = r6.content     // Catch:{ Exception -> 0x0107 }
            if (r3 == 0) goto L_0x0087
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x0107 }
            if (r4 != 0) goto L_0x0087
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0107 }
            r1.<init>()     // Catch:{ Exception -> 0x0107 }
            java.lang.String r4 = "?"
            r1.append(r4)     // Catch:{ Exception -> 0x0107 }
            r1.append(r3)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0107 }
        L_0x0087:
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x0107 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0107 }
            r4.<init>()     // Catch:{ Exception -> 0x0107 }
            java.lang.String r5 = r6.url     // Catch:{ Exception -> 0x0107 }
            r4.append(r5)     // Catch:{ Exception -> 0x0107 }
            r4.append(r1)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0107 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0107 }
            r1 = r3
        L_0x009e:
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0107 }
            java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ Exception -> 0x0107 }
            java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ Exception -> 0x0107 }
            r4 = r1
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x0107 }
            r4.setDoOutput(r2)     // Catch:{ Exception -> 0x0107 }
            r4.setDoInput(r0)     // Catch:{ Exception -> 0x0107 }
            r4.setRequestMethod(r10)     // Catch:{ Exception -> 0x0107 }
            boolean r10 = r6.followRedirects     // Catch:{ Exception -> 0x0107 }
            java.net.HttpURLConnection.setFollowRedirects(r10)     // Catch:{ Exception -> 0x0107 }
            monitor-enter(r9)     // Catch:{ Exception -> 0x0107 }
            com.badlogic.gdx.utils.ObjectMap<com.badlogic.gdx.Net$HttpRequest, java.net.HttpURLConnection> r10 = r9.connections     // Catch:{ all -> 0x0104 }
            r10.put(r6, r4)     // Catch:{ all -> 0x0104 }
            com.badlogic.gdx.utils.ObjectMap<com.badlogic.gdx.Net$HttpRequest, com.badlogic.gdx.Net$HttpResponseListener> r10 = r9.listeners     // Catch:{ all -> 0x0104 }
            r10.put(r6, r7)     // Catch:{ all -> 0x0104 }
            monitor-exit(r9)     // Catch:{ Exception -> 0x0107 }
            java.util.Map<java.lang.String, java.lang.String> r10 = r6.headers     // Catch:{ Exception -> 0x0107 }
            java.util.Set r10 = r10.entrySet()     // Catch:{ Exception -> 0x0107 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x0107 }
        L_0x00cf:
            boolean r0 = r10.hasNext()     // Catch:{ Exception -> 0x0107 }
            if (r0 == 0) goto L_0x00eb
            java.lang.Object r0 = r10.next()     // Catch:{ Exception -> 0x0107 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ Exception -> 0x0107 }
            java.lang.Object r1 = r0.getKey()     // Catch:{ Exception -> 0x0107 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0107 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ Exception -> 0x0107 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0107 }
            r4.addRequestProperty(r1, r0)     // Catch:{ Exception -> 0x0107 }
            goto L_0x00cf
        L_0x00eb:
            int r10 = r6.timeOut     // Catch:{ Exception -> 0x0107 }
            r4.setConnectTimeout(r10)     // Catch:{ Exception -> 0x0107 }
            int r10 = r6.timeOut     // Catch:{ Exception -> 0x0107 }
            r4.setReadTimeout(r10)     // Catch:{ Exception -> 0x0107 }
            java.util.concurrent.ExecutorService r10 = r9.executorService     // Catch:{ Exception -> 0x0107 }
            com.badlogic.gdx.net.NetJavaImpl$2 r8 = new com.badlogic.gdx.net.NetJavaImpl$2     // Catch:{ Exception -> 0x0107 }
            r0 = r8
            r1 = r9
            r3 = r6
            r5 = r7
            r0.<init>(r2, r3, r4, r5)     // Catch:{ Exception -> 0x0107 }
            r10.submit(r8)     // Catch:{ Exception -> 0x0107 }
            goto L_0x010e
        L_0x0104:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ Exception -> 0x0107 }
            throw r10     // Catch:{ Exception -> 0x0107 }
        L_0x0107:
            r10 = move-exception
            r7.failed(r10)     // Catch:{ all -> 0x010f }
            r9.removeFromConnectionsAndListeners(r6)
        L_0x010e:
            return
        L_0x010f:
            r10 = move-exception
            r9.removeFromConnectionsAndListeners(r6)
            throw r10
        L_0x0114:
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.graphics.Pixmap.downloadFromUrl(java.lang.String, com.badlogic.gdx.graphics.Pixmap$DownloadPixmapResponseListener):void");
    }

    public void dispose() {
        if (!this.disposed) {
            this.pixmap.dispose();
            this.disposed = true;
            return;
        }
        throw new GdxRuntimeException((String) "Pixmap already disposed!");
    }

    public void drawCircle(int i, int i2, int i3) {
        this.pixmap.drawCircle(i, i2, i3, this.color);
    }

    public void drawLine(int i, int i2, int i3, int i4) {
        this.pixmap.drawLine(i, i2, i3, i4, this.color);
    }

    public void drawPixel(int i, int i2) {
        this.pixmap.setPixel(i, i2, this.color);
    }

    public void drawPixmap(Pixmap pixmap2, int i, int i2) {
        drawPixmap(pixmap2, i, i2, 0, 0, pixmap2.getWidth(), pixmap2.getHeight());
    }

    public void drawRectangle(int i, int i2, int i3, int i4) {
        this.pixmap.drawRect(i, i2, i3, i4, this.color);
    }

    public void fill() {
        this.pixmap.clear(this.color);
    }

    public void fillCircle(int i, int i2, int i3) {
        this.pixmap.fillCircle(i, i2, i3, this.color);
    }

    public void fillRectangle(int i, int i2, int i3, int i4) {
        this.pixmap.fillRect(i, i2, i3, i4, this.color);
    }

    public void fillTriangle(int i, int i2, int i3, int i4, int i5, int i6) {
        this.pixmap.fillTriangle(i, i2, i3, i4, i5, i6, this.color);
    }

    public Blending getBlending() {
        return this.blending;
    }

    public Filter getFilter() {
        return this.filter;
    }

    public Format getFormat() {
        return Format.fromGdx2DPixmapFormat(this.pixmap.getFormat());
    }

    public int getGLFormat() {
        return this.pixmap.getGLFormat();
    }

    public int getGLInternalFormat() {
        return this.pixmap.getGLInternalFormat();
    }

    public int getGLType() {
        return this.pixmap.getGLType();
    }

    public int getHeight() {
        return this.pixmap.getHeight();
    }

    public int getPixel(int i, int i2) {
        return this.pixmap.getPixel(i, i2);
    }

    public ByteBuffer getPixels() {
        if (!this.disposed) {
            return this.pixmap.getPixels();
        }
        throw new GdxRuntimeException((String) "Pixmap already disposed");
    }

    public int getWidth() {
        return this.pixmap.getWidth();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public void setBlending(Blending blending2) {
        this.blending = blending2;
        this.pixmap.setBlend(blending2 == Blending.None ? 0 : 1);
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setFilter(Filter filter2) {
        this.filter = filter2;
        this.pixmap.setScale(filter2 == Filter.NearestNeighbour ? 0 : 1);
    }

    public void setPixels(ByteBuffer byteBuffer) {
        ByteBuffer pixels = this.pixmap.getPixels();
        BufferUtils.copy(byteBuffer, pixels, pixels.limit());
    }

    public void drawPixel(int i, int i2, int i3) {
        this.pixmap.setPixel(i, i2, i3);
    }

    public void drawPixmap(Pixmap pixmap2, int i, int i2, int i3, int i4, int i5, int i6) {
        this.pixmap.drawPixmap(pixmap2.pixmap, i3, i4, i, i2, i5, i6);
    }

    public void setColor(float f2, float f3, float f4, float f5) {
        this.color = Color.rgba8888(f2, f3, f4, f5);
    }

    public void drawPixmap(Pixmap pixmap2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.pixmap.drawPixmap(pixmap2.pixmap, i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void setColor(Color color2) {
        this.color = Color.rgba8888(color2.r, color2.g, color2.f3307b, color2.f3306a);
    }

    public Pixmap(byte[] bArr, int i, int i2) {
        try {
            this.pixmap = new Gdx2DPixmap(bArr, i, i2, 0);
        } catch (IOException e2) {
            throw new GdxRuntimeException("Couldn't load pixmap from image data", e2);
        }
    }

    public Pixmap(FileHandle fileHandle) {
        try {
            byte[] readBytes = fileHandle.readBytes();
            this.pixmap = new Gdx2DPixmap(readBytes, 0, readBytes.length, 0);
        } catch (Exception e2) {
            throw new GdxRuntimeException("Couldn't load file: " + fileHandle, e2);
        }
    }

    public Pixmap(Gdx2DPixmap gdx2DPixmap) {
        this.pixmap = gdx2DPixmap;
    }
}
