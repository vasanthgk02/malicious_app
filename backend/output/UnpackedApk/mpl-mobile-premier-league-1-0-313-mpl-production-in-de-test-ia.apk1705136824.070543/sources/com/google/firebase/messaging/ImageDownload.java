package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.material.resources.TextAppearanceConfig;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Future;

public class ImageDownload implements Closeable {
    public volatile Future<?> future;
    public Task<Bitmap> task;
    public final URL url;

    public ImageDownload(URL url2) {
        this.url = url2;
    }

    public Bitmap blockingDownload() throws IOException {
        if (Log.isLoggable("FirebaseMessaging", 4)) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Starting download of: ");
            outline73.append(this.url);
            outline73.toString();
        }
        URLConnection openConnection = this.url.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                byte[] byteArray = TextAppearanceConfig.toByteArray(new ByteStreams$LimitedInputStream(inputStream, 1048577));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable("FirebaseMessaging", 2)) {
                    StringBuilder outline732 = GeneratedOutlineSupport.outline73("Downloaded ");
                    outline732.append(byteArray.length);
                    outline732.append(" bytes from ");
                    outline732.append(this.url);
                    outline732.toString();
                }
                if (byteArray.length <= 1048576) {
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    if (decodeByteArray != null) {
                        if (Log.isLoggable("FirebaseMessaging", 3)) {
                            StringBuilder outline733 = GeneratedOutlineSupport.outline73("Successfully downloaded image: ");
                            outline733.append(this.url);
                            outline733.toString();
                        }
                        return decodeByteArray;
                    }
                    StringBuilder outline734 = GeneratedOutlineSupport.outline73("Failed to decode image: ");
                    outline734.append(this.url);
                    throw new IOException(outline734.toString());
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        throw th;
    }

    public void close() {
        this.future.cancel(true);
    }

    public /* synthetic */ void lambda$start$0$ImageDownload(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(blockingDownload());
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }
}
