package io.antmedia.android.broadcaster.encoder.gles;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.nio.FloatBuffer;
import org.apache.fontbox.cmap.CMapParser;

public class Drawable2d {
    public static final FloatBuffer FULL_RECTANGLE_BUF;
    public static final float[] FULL_RECTANGLE_COORDS;
    public static final FloatBuffer FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(FULL_RECTANGLE_TEX_COORDS);
    public static final float[] FULL_RECTANGLE_TEX_COORDS = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer RECTANGLE_BUF;
    public static final float[] RECTANGLE_COORDS;
    public static final FloatBuffer RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(RECTANGLE_TEX_COORDS);
    public static final float[] RECTANGLE_TEX_COORDS = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final int SIZEOF_FLOAT = 4;
    public static final FloatBuffer TRIANGLE_BUF;
    public static final float[] TRIANGLE_COORDS;
    public static final FloatBuffer TRIANGLE_TEX_BUF = GlUtil.createFloatBuffer(TRIANGLE_TEX_COORDS);
    public static final float[] TRIANGLE_TEX_COORDS = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public int mCoordsPerVertex;
    public Prefab mPrefab;
    public FloatBuffer mTexCoordArray;
    public int mTexCoordStride;
    public FloatBuffer mVertexArray;
    public int mVertexCount;
    public int mVertexStride;

    /* renamed from: io.antmedia.android.broadcaster.encoder.gles.Drawable2d$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Drawable2d$Prefab;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                io.antmedia.android.broadcaster.encoder.gles.Drawable2d$Prefab[] r0 = io.antmedia.android.broadcaster.encoder.gles.Drawable2d.Prefab.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Drawable2d$Prefab = r0
                r1 = 1
                io.antmedia.android.broadcaster.encoder.gles.Drawable2d$Prefab r2 = io.antmedia.android.broadcaster.encoder.gles.Drawable2d.Prefab.TRIANGLE     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Drawable2d$Prefab     // Catch:{ NoSuchFieldError -> 0x0016 }
                io.antmedia.android.broadcaster.encoder.gles.Drawable2d$Prefab r3 = io.antmedia.android.broadcaster.encoder.gles.Drawable2d.Prefab.RECTANGLE     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = $SwitchMap$io$antmedia$android$broadcaster$encoder$gles$Drawable2d$Prefab     // Catch:{ NoSuchFieldError -> 0x001d }
                io.antmedia.android.broadcaster.encoder.gles.Drawable2d$Prefab r2 = io.antmedia.android.broadcaster.encoder.gles.Drawable2d.Prefab.FULL_RECTANGLE     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.antmedia.android.broadcaster.encoder.gles.Drawable2d.AnonymousClass1.<clinit>():void");
        }
    }

    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        TRIANGLE_COORDS = fArr;
        TRIANGLE_BUF = GlUtil.createFloatBuffer(fArr);
        float[] fArr2 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        RECTANGLE_COORDS = fArr2;
        RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr2);
        float[] fArr3 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_COORDS = fArr3;
        FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr3);
    }

    public Drawable2d(Prefab prefab) {
        int ordinal = prefab.ordinal();
        if (ordinal == 0) {
            this.mVertexArray = TRIANGLE_BUF;
            this.mTexCoordArray = TRIANGLE_TEX_BUF;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = TRIANGLE_COORDS.length / 2;
        } else if (ordinal == 1) {
            this.mVertexArray = RECTANGLE_BUF;
            this.mTexCoordArray = RECTANGLE_TEX_BUF;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = RECTANGLE_COORDS.length / 2;
        } else if (ordinal == 2) {
            this.mVertexArray = FULL_RECTANGLE_BUF;
            this.mTexCoordArray = RECTANGLE_TEX_BUF;
            this.mCoordsPerVertex = 2;
            this.mVertexStride = 2 * 4;
            this.mVertexCount = FULL_RECTANGLE_COORDS.length / 2;
        } else {
            throw new RuntimeException("Unknown shape " + prefab);
        }
        this.mTexCoordStride = 8;
        this.mPrefab = prefab;
    }

    public int getCoordsPerVertex() {
        return this.mCoordsPerVertex;
    }

    public FloatBuffer getTexCoordArray() {
        return this.mTexCoordArray;
    }

    public int getTexCoordStride() {
        return this.mTexCoordStride;
    }

    public FloatBuffer getVertexArray() {
        return this.mVertexArray;
    }

    public int getVertexCount() {
        return this.mVertexCount;
    }

    public int getVertexStride() {
        return this.mVertexStride;
    }

    public String toString() {
        if (this.mPrefab == null) {
            return "[Drawable2d: ...]";
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("[Drawable2d: ");
        outline73.append(this.mPrefab);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}
