package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;

public abstract class BaseBitmapReferenceDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    public abstract void onNewResultImpl(CloseableReference<Bitmap> closeableReference);

    public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (dataSource.isFinished()) {
            CloseableReference closeableReference = (CloseableReference) dataSource.getResult();
            CloseableReference<Bitmap> closeableReference2 = null;
            if (closeableReference != null && (closeableReference.get() instanceof CloseableStaticBitmap)) {
                closeableReference2 = ((CloseableStaticBitmap) closeableReference.get()).cloneUnderlyingBitmapReference();
            }
            try {
                onNewResultImpl(closeableReference2);
            } finally {
                CloseableReference.closeSafely(closeableReference2);
                if (closeableReference != null) {
                    closeableReference.close();
                }
            }
        }
    }
}
