package a.a.a.a.c;

import android.support.v4.media.session.PlaybackStateCompat;
import com.mpl.network.modules.listeners.IResponseListener;
import java.io.File;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

public class a extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public final File f2407a;

    /* renamed from: b  reason: collision with root package name */
    public final IResponseListener f2408b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2409c;

    public a(File file, String str, IResponseListener iResponseListener) {
        this.f2407a = file;
        this.f2409c = str;
        this.f2408b = iResponseListener;
    }

    public long contentLength() {
        return this.f2407a.length();
    }

    public MediaType contentType() {
        return MediaType.parse(this.f2409c);
    }

    public void writeTo(BufferedSink bufferedSink) {
        Source source = null;
        try {
            source = Okio.source(this.f2407a);
            long j = 0;
            while (true) {
                long read = source.read(bufferedSink.buffer(), PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH);
                if (read != -1) {
                    j += read;
                    bufferedSink.flush();
                    this.f2408b.progressResponse(j, this.f2407a.length(), false);
                } else {
                    this.f2408b.progressResponse(j, this.f2407a.length(), true);
                    return;
                }
            }
        } finally {
            Util.closeQuietly(source);
        }
    }
}
