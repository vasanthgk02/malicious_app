package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso.LoadedFrom;
import java.io.IOException;
import okio.Source;

public abstract class RequestHandler {

    public static final class Result {
        public final Bitmap bitmap;
        public final int exifOrientation;
        public final LoadedFrom loadedFrom;
        public final Source source;

        public Result(Bitmap bitmap2, LoadedFrom loadedFrom2) {
            this((Bitmap) Utils.checkNotNull(bitmap2, "bitmap == null"), null, loadedFrom2, 0);
        }

        public Bitmap getBitmap() {
            return this.bitmap;
        }

        public int getExifOrientation() {
            return this.exifOrientation;
        }

        public LoadedFrom getLoadedFrom() {
            return this.loadedFrom;
        }

        public Source getSource() {
            return this.source;
        }

        public Result(Source source2, LoadedFrom loadedFrom2) {
            this(null, (Source) Utils.checkNotNull(source2, "source == null"), loadedFrom2, 0);
        }

        public Result(Bitmap bitmap2, Source source2, LoadedFrom loadedFrom2, int i) {
            boolean z = true;
            if ((bitmap2 != null) != (source2 == null ? false : z)) {
                this.bitmap = bitmap2;
                this.source = source2;
                this.loadedFrom = (LoadedFrom) Utils.checkNotNull(loadedFrom2, "loadedFrom == null");
                this.exifOrientation = i;
                return;
            }
            throw new AssertionError();
        }
    }

    public static void calculateInSampleSize(int i, int i2, Options options, Request request) {
        calculateInSampleSize(i, i2, options.outWidth, options.outHeight, options, request);
    }

    public static Options createBitmapOptions(Request request) {
        boolean hasSize = request.hasSize();
        boolean z = request.config != null;
        Options options = null;
        if (hasSize || z || request.purgeable) {
            options = new Options();
            options.inJustDecodeBounds = hasSize;
            boolean z2 = request.purgeable;
            options.inInputShareable = z2;
            options.inPurgeable = z2;
            if (z) {
                options.inPreferredConfig = request.config;
            }
        }
        return options;
    }

    public static boolean requiresInSampleSize(Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    public abstract boolean canHandleRequest(Request request);

    public int getRetryCount() {
        return 0;
    }

    public abstract Result load(Request request, int i) throws IOException;

    public boolean shouldRetry(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    public boolean supportsReplay() {
        return false;
    }

    public static void calculateInSampleSize(int i, int i2, int i3, int i4, Options options, Request request) {
        int i5;
        double floor;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                floor = Math.floor((double) (((float) i3) / ((float) i)));
            } else if (i == 0) {
                floor = Math.floor((double) (((float) i4) / ((float) i2)));
            } else {
                int floor2 = (int) Math.floor((double) (((float) i4) / ((float) i2)));
                int floor3 = (int) Math.floor((double) (((float) i3) / ((float) i)));
                i5 = request.centerInside ? Math.max(floor2, floor3) : Math.min(floor2, floor3);
            }
            i5 = (int) floor;
        } else {
            i5 = 1;
        }
        options.inSampleSize = i5;
        options.inJustDecodeBounds = false;
    }
}
