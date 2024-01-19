package org.opencv.core;

public class Core {
    public static native void LUT_0(long j, long j2, long j3);

    public static native double Mahalanobis_0(long j, long j2, long j3);

    public static native void PCABackProject_0(long j, long j2, long j3, long j4);

    public static native void PCACompute_0(long j, long j2, long j3, double d2);

    public static native void PCACompute_1(long j, long j2, long j3, int i);

    public static native void PCACompute_2(long j, long j2, long j3);

    public static native void PCAProject_0(long j, long j2, long j3, long j4);

    public static native double PSNR_0(long j, long j2);

    public static native void SVBackSubst_0(long j, long j2, long j3, long j4, long j5);

    public static native void SVDecomp_0(long j, long j2, long j3, long j4, int i);

    public static native void SVDecomp_1(long j, long j2, long j3, long j4);

    public static native void absdiff_0(long j, long j2, long j3);

    public static native void absdiff_1(long j, double d2, double d3, double d4, double d5, long j2);

    public static native void addWeighted_0(long j, double d2, long j2, double d3, double d4, long j3, int i);

    public static native void addWeighted_1(long j, double d2, long j2, double d3, double d4, long j3);

    public static native void add_0(long j, long j2, long j3, long j4, int i);

    public static native void add_1(long j, long j2, long j3, long j4);

    public static native void add_2(long j, long j2, long j3);

    public static native void add_3(long j, double d2, double d3, double d4, double d5, long j2, long j3, int i);

    public static native void add_4(long j, double d2, double d3, double d4, double d5, long j2, long j3);

    public static native void add_5(long j, double d2, double d3, double d4, double d5, long j2);

    public static native void batchDistance_0(long j, long j2, long j3, int i, long j4, int i2, int i3, long j5, int i4, boolean z);

    public static native void batchDistance_1(long j, long j2, long j3, int i, long j4, int i2, int i3);

    public static native void batchDistance_2(long j, long j2, long j3, int i, long j4);

    public static native void bitwise_and_0(long j, long j2, long j3, long j4);

    public static native void bitwise_and_1(long j, long j2, long j3);

    public static native void bitwise_not_0(long j, long j2, long j3);

    public static native void bitwise_not_1(long j, long j2);

    public static native void bitwise_or_0(long j, long j2, long j3, long j4);

    public static native void bitwise_or_1(long j, long j2, long j3);

    public static native void bitwise_xor_0(long j, long j2, long j3, long j4);

    public static native void bitwise_xor_1(long j, long j2, long j3);

    public static native int borderInterpolate_0(int i, int i2, int i3);

    public static native void calcCovarMatrix_0(long j, long j2, long j3, int i, int i2);

    public static native void calcCovarMatrix_1(long j, long j2, long j3, int i);

    public static native void cartToPolar_0(long j, long j2, long j3, long j4, boolean z);

    public static native void cartToPolar_1(long j, long j2, long j3, long j4);

    public static native boolean checkRange_0(long j, boolean z, double d2, double d3);

    public static native boolean checkRange_1(long j);

    public static native void compare_0(long j, long j2, long j3, int i);

    public static native void compare_1(long j, double d2, double d3, double d4, double d5, long j2, int i);

    public static native void completeSymm_0(long j, boolean z);

    public static native void completeSymm_1(long j);

    public static native void convertScaleAbs_0(long j, long j2, double d2, double d3);

    public static native void convertScaleAbs_1(long j, long j2);

    public static native void copyMakeBorder_0(long j, long j2, int i, int i2, int i3, int i4, int i5, double d2, double d3, double d4, double d5);

    public static native void copyMakeBorder_1(long j, long j2, int i, int i2, int i3, int i4, int i5);

    public static native int countNonZero_0(long j);

    public static native float cubeRoot_0(float f2);

    public static native void dct_0(long j, long j2, int i);

    public static native void dct_1(long j, long j2);

    public static native double determinant_0(long j);

    public static native void dft_0(long j, long j2, int i, int i2);

    public static native void dft_1(long j, long j2);

    public static native void divide_0(long j, long j2, long j3, double d2, int i);

    public static native void divide_1(long j, long j2, long j3, double d2);

    public static native void divide_2(long j, long j2, long j3);

    public static native void divide_3(long j, double d2, double d3, double d4, double d5, long j2, double d6, int i);

    public static native void divide_4(long j, double d2, double d3, double d4, double d5, long j2, double d6);

    public static native void divide_5(long j, double d2, double d3, double d4, double d5, long j2);

    public static native void divide_6(double d2, long j, long j2, int i);

    public static native void divide_7(double d2, long j, long j2);

    public static native boolean eigen_0(long j, long j2, long j3);

    public static native boolean eigen_1(long j, long j2);

    public static native void exp_0(long j, long j2);

    public static native void extractChannel_0(long j, long j2, int i);

    public static native float fastAtan2_0(float f2, float f3);

    public static native void findNonZero_0(long j, long j2);

    public static void flip(Mat mat, Mat mat2, int i) {
        flip_0(mat.nativeObj, mat2.nativeObj, i);
    }

    public static native void flip_0(long j, long j2, int i);

    public static native void gemm_0(long j, long j2, double d2, long j3, double d3, long j4, int i);

    public static native void gemm_1(long j, long j2, double d2, long j3, double d3, long j4);

    public static native String getBuildInformation_0();

    public static native long getCPUTickCount_0();

    public static native int getNumThreads_0();

    public static native int getNumberOfCPUs_0();

    public static native int getOptimalDFTSize_0(int i);

    public static native int getThreadNum_0();

    public static native long getTickCount_0();

    public static native double getTickFrequency_0();

    public static native void hconcat_0(long j, long j2);

    public static native void idct_0(long j, long j2, int i);

    public static native void idct_1(long j, long j2);

    public static native void idft_0(long j, long j2, int i, int i2);

    public static native void idft_1(long j, long j2);

    public static native void inRange_0(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, long j2);

    public static native void insertChannel_0(long j, long j2, int i);

    public static native double invert_0(long j, long j2, int i);

    public static native double invert_1(long j, long j2);

    public static native double kmeans_0(long j, int i, long j2, int i2, int i3, double d2, int i4, int i5, long j3);

    public static native double kmeans_1(long j, int i, long j2, int i2, int i3, double d2, int i4, int i5);

    public static native void log_0(long j, long j2);

    public static native void magnitude_0(long j, long j2, long j3);

    public static native void max_0(long j, long j2, long j3);

    public static native void max_1(long j, double d2, double d3, double d4, double d5, long j2);

    public static native void meanStdDev_0(long j, long j2, long j3, long j4);

    public static native void meanStdDev_1(long j, long j2, long j3);

    public static native double[] mean_0(long j, long j2);

    public static native double[] mean_1(long j);

    public static native void merge_0(long j, long j2);

    public static native void min_0(long j, long j2, long j3);

    public static native void min_1(long j, double d2, double d3, double d4, double d5, long j2);

    public static native void mixChannels_0(long j, long j2, long j3);

    public static native void mulSpectrums_0(long j, long j2, long j3, int i, boolean z);

    public static native void mulSpectrums_1(long j, long j2, long j3, int i);

    public static native void mulTransposed_0(long j, long j2, boolean z, long j3, double d2, int i);

    public static native void mulTransposed_1(long j, long j2, boolean z, long j3, double d2);

    public static native void mulTransposed_2(long j, long j2, boolean z);

    public static native void multiply_0(long j, long j2, long j3, double d2, int i);

    public static native void multiply_1(long j, long j2, long j3, double d2);

    public static native void multiply_2(long j, long j2, long j3);

    public static native void multiply_3(long j, double d2, double d3, double d4, double d5, long j2, double d6, int i);

    public static native void multiply_4(long j, double d2, double d3, double d4, double d5, long j2, double d6);

    public static native void multiply_5(long j, double d2, double d3, double d4, double d5, long j2);

    public static native double[] n_minMaxLocManual(long j, long j2);

    public static native double norm_0(long j, long j2, int i, long j3);

    public static native double norm_1(long j, long j2, int i);

    public static native double norm_2(long j, long j2);

    public static native double norm_3(long j, int i, long j2);

    public static native double norm_4(long j, int i);

    public static native double norm_5(long j);

    public static native void normalize_0(long j, long j2, double d2, double d3, int i, int i2, long j3);

    public static native void normalize_1(long j, long j2, double d2, double d3, int i, int i2);

    public static native void normalize_2(long j, long j2, double d2, double d3, int i);

    public static native void normalize_3(long j, long j2);

    public static native void patchNaNs_0(long j, double d2);

    public static native void patchNaNs_1(long j);

    public static native void perspectiveTransform_0(long j, long j2, long j3);

    public static native void phase_0(long j, long j2, long j3, boolean z);

    public static native void phase_1(long j, long j2, long j3);

    public static native void polarToCart_0(long j, long j2, long j3, long j4, boolean z);

    public static native void polarToCart_1(long j, long j2, long j3, long j4);

    public static native void pow_0(long j, double d2, long j2);

    public static native void randShuffle_0(long j, double d2);

    public static native void randShuffle_1(long j);

    public static native void randn_0(long j, double d2, double d3);

    public static native void randu_0(long j, double d2, double d3);

    public static native void reduce_0(long j, long j2, int i, int i2, int i3);

    public static native void reduce_1(long j, long j2, int i, int i2);

    public static native void repeat_0(long j, int i, int i2, long j2);

    public static native void scaleAdd_0(long j, double d2, long j2, long j3);

    public static native void setErrorVerbosity_0(boolean z);

    public static native void setIdentity_0(long j, double d2, double d3, double d4, double d5);

    public static native void setIdentity_1(long j);

    public static native void setNumThreads_0(int i);

    public static native int solveCubic_0(long j, long j2);

    public static native double solvePoly_0(long j, long j2, int i);

    public static native double solvePoly_1(long j, long j2);

    public static native boolean solve_0(long j, long j2, long j3, int i);

    public static native boolean solve_1(long j, long j2, long j3);

    public static native void sortIdx_0(long j, long j2, int i);

    public static native void sort_0(long j, long j2, int i);

    public static native void split_0(long j, long j2);

    public static native void sqrt_0(long j, long j2);

    public static native void subtract_0(long j, long j2, long j3, long j4, int i);

    public static native void subtract_1(long j, long j2, long j3, long j4);

    public static native void subtract_2(long j, long j2, long j3);

    public static native void subtract_3(long j, double d2, double d3, double d4, double d5, long j2, long j3, int i);

    public static native void subtract_4(long j, double d2, double d3, double d4, double d5, long j2, long j3);

    public static native void subtract_5(long j, double d2, double d3, double d4, double d5, long j2);

    public static native double[] sumElems_0(long j);

    public static native double[] trace_0(long j);

    public static native void transform_0(long j, long j2, long j3);

    public static void transpose(Mat mat, Mat mat2) {
        transpose_0(mat.nativeObj, mat2.nativeObj);
    }

    public static native void transpose_0(long j, long j2);

    public static native void vconcat_0(long j, long j2);
}
