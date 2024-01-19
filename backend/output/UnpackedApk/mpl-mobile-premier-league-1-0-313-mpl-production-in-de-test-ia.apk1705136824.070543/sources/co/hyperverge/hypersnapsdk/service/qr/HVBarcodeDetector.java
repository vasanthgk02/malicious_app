package co.hyperverge.hypersnapsdk.service.qr;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import com.google.android.gms.vision.Frame.Builder;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class HVBarcodeDetector {
    public BarcodeDetector detector;

    public String detect(Bitmap bitmap) throws NoClassDefFoundError {
        if (this.detector != null) {
            SparseArray detect = this.detector.detect(new Builder().setBitmap(bitmap).build());
            if (detect.size() != 0) {
                return ((Barcode) detect.valueAt(0)).rawValue;
            }
        }
        return "";
    }

    public void initialiseHVBarcodeDetector(Context context, int i) throws NoClassDefFoundError {
        if (context != null) {
            this.detector = new BarcodeDetector.Builder(context).setBarcodeFormats(i).build();
        }
    }
}
