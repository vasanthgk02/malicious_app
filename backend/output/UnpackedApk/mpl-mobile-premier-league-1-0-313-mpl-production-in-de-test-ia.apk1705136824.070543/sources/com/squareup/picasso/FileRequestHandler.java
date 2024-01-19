package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import androidx.exifinterface.media.ExifInterface.ExifAttribute;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import okio.Okio;

public class FileRequestHandler extends ContentStreamRequestHandler {
    public FileRequestHandler(Context context) {
        super(context);
    }

    public static int getFileExifRotation(Uri uri) throws IOException {
        ExifInterface exifInterface = new ExifInterface(uri.getPath());
        ExifAttribute exifAttribute = exifInterface.getExifAttribute("Orientation");
        if (exifAttribute != null) {
            try {
                return exifAttribute.getIntValue(exifInterface.mExifByteOrder);
            } catch (NumberFormatException unused) {
            }
        }
        return 1;
    }

    public boolean canHandleRequest(Request request) {
        return "file".equals(request.uri.getScheme());
    }

    public Result load(Request request, int i) throws IOException {
        return new Result(null, Okio.source(getInputStream(request)), LoadedFrom.DISK, getFileExifRotation(request.uri));
    }
}
