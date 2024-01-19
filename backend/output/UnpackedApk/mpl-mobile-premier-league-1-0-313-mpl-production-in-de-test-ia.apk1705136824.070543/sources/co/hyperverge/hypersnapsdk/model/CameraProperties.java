package co.hyperverge.hypersnapsdk.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;

public class CameraProperties {
    public byte[] data;
    public int height;
    public boolean isCapturedFramePreviewed;
    public boolean isFrontFacingCam;
    public int orientation;
    public long rgbDataLength;
    public int rotation;
    public int viewHeight;
    public int viewWidth;
    public int width;

    public CameraProperties(int i, int i2, int i3, int i4, long j, int i5, int i6, byte[] bArr, boolean z, boolean z2) {
        this.width = i;
        this.height = i2;
        this.viewWidth = i3;
        this.viewHeight = i4;
        this.rgbDataLength = j;
        this.orientation = i5;
        this.rotation = i6;
        this.data = bArr;
        this.isFrontFacingCam = z;
        this.isCapturedFramePreviewed = z2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraProperties)) {
            return false;
        }
        CameraProperties cameraProperties = (CameraProperties) obj;
        if (cameraProperties != null) {
            return this.width == cameraProperties.width && this.height == cameraProperties.height && this.viewWidth == cameraProperties.viewWidth && this.viewHeight == cameraProperties.viewHeight && this.rgbDataLength == cameraProperties.rgbDataLength && this.orientation == cameraProperties.orientation && this.rotation == cameraProperties.rotation && this.isFrontFacingCam == cameraProperties.isFrontFacingCam && this.isCapturedFramePreviewed == cameraProperties.isCapturedFramePreviewed && Arrays.equals(this.data, cameraProperties.data);
        }
        throw null;
    }

    public int hashCode() {
        int i = ((((((this.width + 59) * 59) + this.height) * 59) + this.viewWidth) * 59) + this.viewHeight;
        long j = this.rgbDataLength;
        int i2 = 79;
        int i3 = ((((((((i * 59) + ((int) (j ^ (j >>> 32)))) * 59) + this.orientation) * 59) + this.rotation) * 59) + (this.isFrontFacingCam ? 79 : 97)) * 59;
        if (!this.isCapturedFramePreviewed) {
            i2 = 97;
        }
        return Arrays.hashCode(this.data) + ((i3 + i2) * 59);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CameraProperties(width=");
        outline73.append(this.width);
        outline73.append(", height=");
        outline73.append(this.height);
        outline73.append(", viewWidth=");
        outline73.append(this.viewWidth);
        outline73.append(", viewHeight=");
        outline73.append(this.viewHeight);
        outline73.append(", rgbDataLength=");
        outline73.append(this.rgbDataLength);
        outline73.append(", orientation=");
        outline73.append(this.orientation);
        outline73.append(", rotation=");
        outline73.append(this.rotation);
        outline73.append(", data=");
        outline73.append(Arrays.toString(this.data));
        outline73.append(", isFrontFacingCam=");
        outline73.append(this.isFrontFacingCam);
        outline73.append(", isCapturedFramePreviewed=");
        return GeneratedOutlineSupport.outline66(outline73, this.isCapturedFramePreviewed, ")");
    }
}
