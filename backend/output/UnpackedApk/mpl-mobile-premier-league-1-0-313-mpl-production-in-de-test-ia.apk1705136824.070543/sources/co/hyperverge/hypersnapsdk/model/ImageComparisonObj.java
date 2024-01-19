package co.hyperverge.hypersnapsdk.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImageComparisonObj {
    public float blueChannelDistance;
    public int captureHeight;
    public int captureWidth;
    public List<Long> frameDataLength = new ArrayList(Collections.nCopies(10, Long.valueOf(0)));
    public List<Integer> frameDistanceValue = new ArrayList();
    public float greenChannelDistance;
    public int imageHeight;
    public int imageWidth;
    public float redChannelDistance;
    public float similarityScore;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImageComparisonObj)) {
            return false;
        }
        ImageComparisonObj imageComparisonObj = (ImageComparisonObj) obj;
        if (imageComparisonObj == null) {
            throw null;
        } else if (Float.compare(this.redChannelDistance, imageComparisonObj.redChannelDistance) != 0 || Float.compare(this.greenChannelDistance, imageComparisonObj.greenChannelDistance) != 0 || Float.compare(this.blueChannelDistance, imageComparisonObj.blueChannelDistance) != 0 || Float.compare(this.similarityScore, imageComparisonObj.similarityScore) != 0 || this.captureWidth != imageComparisonObj.captureWidth || this.captureHeight != imageComparisonObj.captureHeight || this.imageWidth != imageComparisonObj.imageWidth || this.imageHeight != imageComparisonObj.imageHeight) {
            return false;
        } else {
            List<Integer> list = this.frameDistanceValue;
            List<Integer> list2 = imageComparisonObj.frameDistanceValue;
            if (list != null ? !list.equals(list2) : list2 != null) {
                return false;
            }
            List<Long> list3 = this.frameDataLength;
            List<Long> list4 = imageComparisonObj.frameDataLength;
            return list3 != null ? list3.equals(list4) : list4 == null;
        }
    }

    public int hashCode() {
        int i;
        int floatToIntBits = Float.floatToIntBits(this.greenChannelDistance);
        int floatToIntBits2 = Float.floatToIntBits(this.blueChannelDistance);
        int floatToIntBits3 = ((((((((Float.floatToIntBits(this.similarityScore) + ((floatToIntBits2 + ((floatToIntBits + ((Float.floatToIntBits(this.redChannelDistance) + 59) * 59)) * 59)) * 59)) * 59) + this.captureWidth) * 59) + this.captureHeight) * 59) + this.imageWidth) * 59) + this.imageHeight;
        List<Integer> list = this.frameDistanceValue;
        int i2 = floatToIntBits3 * 59;
        int i3 = 43;
        if (list == null) {
            i = 43;
        } else {
            i = list.hashCode();
        }
        int i4 = i2 + i;
        List<Long> list2 = this.frameDataLength;
        int i5 = i4 * 59;
        if (list2 != null) {
            i3 = list2.hashCode();
        }
        return i5 + i3;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ImageComparisonObj(redChannelDistance=");
        outline73.append(this.redChannelDistance);
        outline73.append(", greenChannelDistance=");
        outline73.append(this.greenChannelDistance);
        outline73.append(", blueChannelDistance=");
        outline73.append(this.blueChannelDistance);
        outline73.append(", similarityScore=");
        outline73.append(this.similarityScore);
        outline73.append(", frameDistanceValue=");
        outline73.append(this.frameDistanceValue);
        outline73.append(", frameDataLength=");
        outline73.append(this.frameDataLength);
        outline73.append(", captureWidth=");
        outline73.append(this.captureWidth);
        outline73.append(", captureHeight=");
        outline73.append(this.captureHeight);
        outline73.append(", imageWidth=");
        outline73.append(this.imageWidth);
        outline73.append(", imageHeight=");
        return GeneratedOutlineSupport.outline57(outline73, this.imageHeight, ")");
    }
}
