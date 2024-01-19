package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;

@TargetApi(19)
@DoNotStrip
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder {
    public final FlexByteArrayPool mFlexByteArrayPool;

    @DoNotStrip
    public KitKatPurgeableDecoder(FlexByteArrayPool flexByteArrayPool) {
        this.mFlexByteArrayPool = flexByteArrayPool;
    }

    public static void putEOI(byte[] bArr, int i) {
        bArr[i] = -1;
        bArr[i + 1] = -39;
    }

    public Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, Options options) {
        PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) closeableReference.get();
        int size = pooledByteBuffer.size();
        CloseableReference<byte[]> closeableReference2 = this.mFlexByteArrayPool.get(size);
        try {
            byte[] bArr = (byte[]) closeableReference2.get();
            pooledByteBuffer.read(0, bArr, 0, size);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, size, options);
            k.checkNotNull(decodeByteArray, (Object) "BitmapFactory returned null");
            Bitmap bitmap = decodeByteArray;
            closeableReference2.close();
            return bitmap;
        } catch (Throwable th) {
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
            throw th;
        }
    }

    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i, Options options) {
        byte[] bArr = DalvikPurgeableDecoder.endsWithEOI(closeableReference, i) ? null : DalvikPurgeableDecoder.EOI;
        PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) closeableReference.get();
        k.checkArgument(i <= pooledByteBuffer.size());
        int i2 = i + 2;
        CloseableReference<byte[]> closeableReference2 = this.mFlexByteArrayPool.get(i2);
        try {
            byte[] bArr2 = (byte[]) closeableReference2.get();
            pooledByteBuffer.read(0, bArr2, 0, i);
            if (bArr != null) {
                putEOI(bArr2, i);
                i = i2;
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, i, options);
            k.checkNotNull(decodeByteArray, (Object) "BitmapFactory returned null");
            Bitmap bitmap = decodeByteArray;
            closeableReference2.close();
            return bitmap;
        } catch (Throwable th) {
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
            throw th;
        }
    }
}
