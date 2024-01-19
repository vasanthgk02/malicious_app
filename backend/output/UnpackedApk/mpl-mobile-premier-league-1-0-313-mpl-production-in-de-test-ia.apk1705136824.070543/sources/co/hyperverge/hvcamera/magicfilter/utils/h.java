package co.hyperverge.hvcamera.magicfilter.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import androidx.core.widget.CompoundButtonCompat;
import co.hyperverge.hvcamera.c.a.c;
import java.io.File;
import org.apache.pdfbox.pdfparser.BaseParser;

public class h extends AsyncTask<Boolean, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    public File f2934a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f2935b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f2936c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2937d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2938e;

    /* renamed from: f  reason: collision with root package name */
    public int f2939f;
    public boolean g = false;
    public c h;

    static {
        Class<h> cls = h.class;
    }

    public h(File file, byte[] bArr, c cVar) {
        this.f2934a = file;
        this.f2935b = bArr;
        this.h = cVar;
    }

    public Object doInBackground(Object[] objArr) {
        Boolean[] boolArr = (Boolean[]) objArr;
        if (this.f2934a == null) {
            return null;
        }
        int orientation = CompoundButtonCompat.getOrientation(this.f2935b);
        try {
            this.f2936c = BitmapFactory.decodeByteArray(this.f2935b, 0, this.f2935b.length);
        } catch (OutOfMemoryError e2) {
            e2.getMessage();
            System.gc();
            this.g = false;
            try {
                this.f2936c = BitmapFactory.decodeByteArray(this.f2935b, 0, this.f2935b.length);
                this.g = true;
            } catch (OutOfMemoryError e3) {
                e3.getMessage();
            }
        }
        if (!boolArr[0].booleanValue() || !boolArr[1].booleanValue()) {
            this.f2937d = false;
            this.f2938e = false;
        } else if (orientation == 0 || orientation == 1 || orientation == 3) {
            this.f2937d = true;
            this.f2938e = false;
        } else if (orientation == 6 || orientation == 8) {
            this.f2937d = false;
            this.f2938e = true;
        }
        this.f2939f = orientation;
        this.g = true;
        return BaseParser.TRUE;
    }

    public void onPostExecute(Object obj) {
        String str = (String) obj;
        if (this.g || this.f2936c == null) {
            this.h.a(this.f2936c, this.f2934a, this.f2937d, this.f2938e, this.f2939f);
        }
    }

    public void onPreExecute() {
        super.onPreExecute();
    }
}
