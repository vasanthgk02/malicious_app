package co.hyperverge.hypersnapsdk.model;

import co.hyperverge.hypersnapsdk.c.e.a;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.List;

public class FaceDetectorObj {
    public a faceCoordinateObject;
    public boolean isStraight;
    public List<ArrayList<Integer>> multipleFaces;
    public ArrayList<Integer> rectPoints = new ArrayList<>();
    public int viewHeight;
    public int viewWidth;

    public FaceDetectorObj(ArrayList<Integer> arrayList, a aVar, int i, int i2, List<ArrayList<Integer>> list) {
        this.rectPoints = arrayList;
        this.faceCoordinateObject = aVar;
        this.viewHeight = i2;
        this.viewWidth = i;
        this.multipleFaces = list;
        this.isStraight = true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FaceDetectorObj)) {
            return false;
        }
        FaceDetectorObj faceDetectorObj = (FaceDetectorObj) obj;
        if (faceDetectorObj == null) {
            throw null;
        } else if (this.viewWidth != faceDetectorObj.viewWidth || this.viewHeight != faceDetectorObj.viewHeight || this.isStraight != faceDetectorObj.isStraight) {
            return false;
        } else {
            ArrayList<Integer> arrayList = this.rectPoints;
            ArrayList<Integer> arrayList2 = faceDetectorObj.rectPoints;
            if (arrayList != null ? !arrayList.equals(arrayList2) : arrayList2 != null) {
                return false;
            }
            a aVar = this.faceCoordinateObject;
            a aVar2 = faceDetectorObj.faceCoordinateObject;
            if (aVar != null ? !aVar.equals(aVar2) : aVar2 != null) {
                return false;
            }
            List<ArrayList<Integer>> list = this.multipleFaces;
            List<ArrayList<Integer>> list2 = faceDetectorObj.multipleFaces;
            return list != null ? list.equals(list2) : list2 == null;
        }
    }

    public int hashCode() {
        int i;
        int i2;
        int i3 = ((((this.viewWidth + 59) * 59) + this.viewHeight) * 59) + (this.isStraight ? 79 : 97);
        ArrayList<Integer> arrayList = this.rectPoints;
        int i4 = i3 * 59;
        int i5 = 43;
        if (arrayList == null) {
            i = 43;
        } else {
            i = arrayList.hashCode();
        }
        int i6 = i4 + i;
        a aVar = this.faceCoordinateObject;
        int i7 = i6 * 59;
        if (aVar == null) {
            i2 = 43;
        } else {
            i2 = aVar.hashCode();
        }
        int i8 = i7 + i2;
        List<ArrayList<Integer>> list = this.multipleFaces;
        int i9 = i8 * 59;
        if (list != null) {
            i5 = list.hashCode();
        }
        return i9 + i5;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("FaceDetectorObj(rectPoints=");
        outline73.append(this.rectPoints);
        outline73.append(", faceCoordinateObject=");
        outline73.append(this.faceCoordinateObject);
        outline73.append(", viewWidth=");
        outline73.append(this.viewWidth);
        outline73.append(", viewHeight=");
        outline73.append(this.viewHeight);
        outline73.append(", multipleFaces=");
        outline73.append(this.multipleFaces);
        outline73.append(", isStraight=");
        return GeneratedOutlineSupport.outline66(outline73, this.isStraight, ")");
    }

    public FaceDetectorObj(ArrayList<Integer> arrayList, a aVar, int i, int i2, List<ArrayList<Integer>> list, boolean z) {
        this.rectPoints = arrayList;
        this.faceCoordinateObject = aVar;
        this.viewHeight = i2;
        this.viewWidth = i;
        this.multipleFaces = list;
        this.isStraight = z;
    }
}
