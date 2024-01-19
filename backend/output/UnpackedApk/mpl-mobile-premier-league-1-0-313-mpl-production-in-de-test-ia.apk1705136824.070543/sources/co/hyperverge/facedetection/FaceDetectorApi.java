package co.hyperverge.facedetection;

import android.content.Context;
import co.hyperverge.facedetection.Detectors.HVFaceDetector;
import co.hyperverge.facedetection.Detectors.MediaDetector;
import co.hyperverge.facedetection.Detectors.NDPDetector;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class FaceDetectorApi {
    public static HVFaceDetector mDetector;

    public static ArrayList<ArrayList<Float>> detectFacesFromByteArray(byte[] bArr, int i, int i2, int i3) {
        HVFaceDetector hVFaceDetector = mDetector;
        ArrayList<ArrayList<Float>> arrayList = null;
        if (hVFaceDetector == null) {
            return null;
        }
        NDPDetector nDPDetector = (NDPDetector) hVFaceDetector;
        if (nDPDetector != null) {
            if (bArr != null) {
                try {
                    JSONArray jSONArray = new JSONArray(nDPDetector.detectFaces(bArr, i, i2, i3, null));
                    ArrayList<ArrayList<Float>> arrayList2 = new ArrayList<>(jSONArray.length());
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        try {
                            JSONArray jSONArray2 = jSONArray.getJSONArray(i4);
                            arrayList2.add(new ArrayList(jSONArray2.length()));
                            ArrayList arrayList3 = arrayList2.get(i4);
                            for (int i5 = 0; i5 < jSONArray2.length(); i5 += 2) {
                                arrayList3.add(i5, Float.valueOf(((float) jSONArray2.getInt(i5)) / ((float) i)));
                                int i6 = i5 + 1;
                                arrayList3.add(i6, Float.valueOf(((float) jSONArray2.getInt(i6)) / ((float) i2)));
                            }
                        } catch (JSONException e2) {
                            e2.getMessage();
                        }
                    }
                    arrayList = arrayList2;
                } catch (JSONException e3) {
                    e3.getMessage();
                }
            }
            return arrayList;
        }
        throw null;
    }

    public static int getAvgIntensity(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        int i7;
        int i8 = i3;
        int i9 = i4;
        int i10 = i5;
        int i11 = i6;
        HVFaceDetector hVFaceDetector = mDetector;
        if (hVFaceDetector == null) {
            return -1;
        }
        NDPDetector nDPDetector = (NDPDetector) hVFaceDetector;
        if (nDPDetector != null) {
            if (z) {
                int round = Math.round((((float) i9) / 2.0f) + (((float) i8) / 2.0f));
                int round2 = Math.round((((float) i11) / 2.0f) + (((float) i10) / 2.0f));
                int round3 = Math.round(((float) (i9 - i8)) / 4.0f);
                int round4 = Math.round(((float) (i11 - i10)) / 4.0f);
                i7 = nDPDetector.getAverageIntensity(bArr, i, i2, round - round3, round + round3, round2 - round4, round2 + round4, z);
            } else {
                i7 = nDPDetector.getAverageIntensity(bArr, i, i2, i3, i4, i5, i6, z);
            }
            return i7;
        }
        throw null;
    }

    public static void initialize(Context context, int i) {
        HVFaceDetector hVFaceDetector = mDetector;
        if (hVFaceDetector != null) {
            hVFaceDetector.release();
            mDetector = null;
        }
        if (i == 0) {
            mDetector = new MediaDetector();
        } else if (i == 2) {
            NDPDetector nDPDetector = new NDPDetector();
            mDetector = nDPDetector;
            nDPDetector.initialize(context);
        }
    }
}
