package org.opencv.core;

import com.android.tools.r8.GeneratedOutlineSupport;

public class Mat {
    public final long nativeObj;

    public Mat(long j) {
        if (j != 0) {
            this.nativeObj = j;
            return;
        }
        throw new UnsupportedOperationException("Native object address is NULL");
    }

    public static native void locateROI_0(long j, double[] dArr, double[] dArr2);

    public static native String nDump(long j);

    public static native double[] nGet(long j, int i, int i2);

    public static native int nGetB(long j, int i, int i2, int i3, byte[] bArr);

    public static native int nGetD(long j, int i, int i2, int i3, double[] dArr);

    public static native int nGetF(long j, int i, int i2, int i3, float[] fArr);

    public static native int nGetI(long j, int i, int i2, int i3, int[] iArr);

    public static native int nGetS(long j, int i, int i2, int i3, short[] sArr);

    public static native int nPutB(long j, int i, int i2, int i3, byte[] bArr);

    public static native int nPutD(long j, int i, int i2, int i3, double[] dArr);

    public static native int nPutF(long j, int i, int i2, int i3, float[] fArr);

    public static native int nPutI(long j, int i, int i2, int i3, int[] iArr);

    public static native int nPutS(long j, int i, int i2, int i3, short[] sArr);

    public static native long n_Mat();

    public static native long n_Mat(double d2, double d3, int i);

    public static native long n_Mat(double d2, double d3, int i, double d4, double d5, double d6, double d7);

    public static native long n_Mat(int i, int i2, int i3);

    public static native long n_Mat(int i, int i2, int i3, double d2, double d3, double d4, double d5);

    public static native long n_Mat(long j, int i, int i2);

    public static native long n_Mat(long j, int i, int i2, int i3, int i4);

    public static native long n_adjustROI(long j, int i, int i2, int i3, int i4);

    public static native void n_assignTo(long j, long j2);

    public static native void n_assignTo(long j, long j2, int i);

    public static native int n_channels(long j);

    public static native int n_checkVector(long j, int i);

    public static native int n_checkVector(long j, int i, int i2);

    public static native int n_checkVector(long j, int i, int i2, boolean z);

    public static native long n_clone(long j);

    public static native long n_col(long j, int i);

    public static native long n_colRange(long j, int i, int i2);

    public static native int n_cols(long j);

    public static native void n_convertTo(long j, long j2, int i);

    public static native void n_convertTo(long j, long j2, int i, double d2);

    public static native void n_convertTo(long j, long j2, int i, double d2, double d3);

    public static native void n_copyTo(long j, long j2);

    public static native void n_copyTo(long j, long j2, long j3);

    public static native void n_create(long j, double d2, double d3, int i);

    public static native void n_create(long j, int i, int i2, int i3);

    public static native long n_cross(long j, long j2);

    public static native long n_dataAddr(long j);

    public static native void n_delete(long j);

    public static native int n_depth(long j);

    public static native long n_diag(long j);

    public static native long n_diag(long j, int i);

    public static native int n_dims(long j);

    public static native double n_dot(long j, long j2);

    public static native long n_elemSize(long j);

    public static native long n_elemSize1(long j);

    public static native boolean n_empty(long j);

    public static native long n_eye(double d2, double d3, int i);

    public static native long n_eye(int i, int i2, int i3);

    public static native long n_inv(long j);

    public static native long n_inv(long j, int i);

    public static native boolean n_isContinuous(long j);

    public static native boolean n_isSubmatrix(long j);

    public static native long n_mul(long j, long j2);

    public static native long n_mul(long j, long j2, double d2);

    public static native long n_ones(double d2, double d3, int i);

    public static native long n_ones(int i, int i2, int i3);

    public static native void n_push_back(long j, long j2);

    public static native void n_release(long j);

    public static native long n_reshape(long j, int i);

    public static native long n_reshape(long j, int i, int i2);

    public static native long n_row(long j, int i);

    public static native long n_rowRange(long j, int i, int i2);

    public static native int n_rows(long j);

    public static native long n_setTo(long j, double d2, double d3, double d4, double d5);

    public static native long n_setTo(long j, double d2, double d3, double d4, double d5, long j2);

    public static native long n_setTo(long j, long j2);

    public static native long n_setTo(long j, long j2, long j3);

    public static native double[] n_size(long j);

    public static native long n_step1(long j);

    public static native long n_step1(long j, int i);

    public static native long n_submat(long j, int i, int i2, int i3, int i4);

    public static native long n_submat_rr(long j, int i, int i2, int i3, int i4);

    public static native long n_t(long j);

    public static native long n_total(long j);

    public static native int n_type(long j);

    public static native long n_zeros(double d2, double d3, int i);

    public static native long n_zeros(int i, int i2, int i3);

    public Object clone() throws CloneNotSupportedException {
        return new Mat(n_clone(this.nativeObj));
    }

    public int cols() {
        return n_cols(this.nativeObj);
    }

    public boolean empty() {
        return n_empty(this.nativeObj);
    }

    public void finalize() throws Throwable {
        n_delete(this.nativeObj);
        super.finalize();
    }

    public int get(int i, int i2, int[] iArr) {
        int type = type();
        if (iArr.length % CvType.channels(type) != 0) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Provided data element number (");
            outline73.append(iArr.length);
            outline73.append(") should be multiple of the Mat channels count (");
            outline73.append(CvType.channels(type));
            outline73.append(")");
            throw new UnsupportedOperationException(outline73.toString());
        } else if ((type & 7) == 4) {
            return nGetI(this.nativeObj, i, i2, iArr.length, iArr);
        } else {
            throw new UnsupportedOperationException(GeneratedOutlineSupport.outline41("Mat data type is not compatible: ", type));
        }
    }

    public int put(int i, int i2, byte[] bArr) {
        int i3;
        int type = type();
        if (bArr == null || bArr.length % CvType.channels(type) != 0) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Provided data element number (");
            if (bArr == null) {
                i3 = 0;
            } else {
                i3 = bArr.length;
            }
            outline73.append(i3);
            outline73.append(") should be multiple of the Mat channels count (");
            outline73.append(CvType.channels(type));
            outline73.append(")");
            throw new UnsupportedOperationException(outline73.toString());
        }
        int i4 = type & 7;
        if (i4 == 0 || i4 == 1) {
            return nPutB(this.nativeObj, i, i2, bArr.length, bArr);
        }
        throw new UnsupportedOperationException(GeneratedOutlineSupport.outline41("Mat data type is not compatible: ", type));
    }

    public int rows() {
        return n_rows(this.nativeObj);
    }

    public Mat submat(Rect rect) {
        return new Mat(n_submat(this.nativeObj, rect.x, rect.y, rect.width, rect.height));
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Mat [ ");
        outline73.append(rows());
        outline73.append("*");
        outline73.append(cols());
        outline73.append("*");
        outline73.append(CvType.typeToString(type()));
        outline73.append(", isCont=");
        outline73.append(n_isContinuous(this.nativeObj));
        outline73.append(", isSubmat=");
        outline73.append(n_isSubmatrix(this.nativeObj));
        outline73.append(", nativeObj=0x");
        outline73.append(Long.toHexString(this.nativeObj));
        outline73.append(", dataAddr=0x");
        outline73.append(Long.toHexString(n_dataAddr(this.nativeObj)));
        outline73.append(" ]");
        return outline73.toString();
    }

    public long total() {
        return n_total(this.nativeObj);
    }

    public int type() {
        return n_type(this.nativeObj);
    }

    public Mat() {
        this.nativeObj = n_Mat();
    }

    public Mat(int i, int i2, int i3) {
        this.nativeObj = n_Mat(i, i2, i3);
    }

    public Mat(Mat mat, Range range) {
        this.nativeObj = n_Mat(mat.nativeObj, range.start, range.end);
    }
}
