package co.hyperverge.hvcamera.magicfilter.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.ExifInterface;
import android.os.AsyncTask;
import co.hyperverge.hvcamera.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class g extends AsyncTask<Bitmap, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    public a f2931a;

    /* renamed from: b  reason: collision with root package name */
    public File f2932b;

    /* renamed from: c  reason: collision with root package name */
    public int f2933c;

    public interface a {
        void a(String str);
    }

    static {
        Class<g> cls = g.class;
    }

    public g(File file, a aVar, int i) {
        this.f2931a = aVar;
        this.f2932b = file;
        this.f2933c = i;
    }

    public Object doInBackground(Object[] objArr) {
        Bitmap[] bitmapArr = (Bitmap[]) objArr;
        if (this.f2932b == null) {
            return null;
        }
        Bitmap bitmap = bitmapArr[0];
        b bVar = new b();
        bVar.a("SaveTask", "Copied exif");
        if (this.f2932b.exists()) {
            this.f2932b.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.f2932b);
            bitmap.compress(CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmap.recycle();
            ExifInterface exifInterface = new ExifInterface(this.f2932b.getAbsolutePath());
            exifInterface.setAttribute("Orientation", "" + this.f2933c);
            exifInterface.setAttribute("DateTimeOriginal", d.f2925a.format(new Date(System.currentTimeMillis())));
            exifInterface.saveAttributes();
            bVar.a("SaveTask", "Saved exif");
            return this.f2932b.toString();
        } catch (FileNotFoundException e2) {
            e2.getMessage();
            return null;
        } catch (IOException e3) {
            e3.getMessage();
            return null;
        }
    }

    public void onPostExecute(Object obj) {
        String str = (String) obj;
        if (str != null) {
            a aVar = this.f2931a;
            if (aVar != null) {
                aVar.a(str);
            }
        }
    }

    public void onPreExecute() {
        super.onPreExecute();
    }
}
