package org.opencv.imgproc;

import org.opencv.core.Mat;

public class Imgproc {
    public static native void Canny_0(long j, long j2, double d2, double d3, int i, boolean z);

    public static native void Canny_1(long j, long j2, double d2, double d3);

    public static native void GaussianBlur_0(long j, long j2, double d2, double d3, double d4, double d5, int i);

    public static native void GaussianBlur_1(long j, long j2, double d2, double d3, double d4, double d5);

    public static native void GaussianBlur_2(long j, long j2, double d2, double d3, double d4);

    public static native void HoughCircles_0(long j, long j2, int i, double d2, double d3, double d4, double d5, int i2, int i3);

    public static native void HoughCircles_1(long j, long j2, int i, double d2, double d3);

    public static native void HoughLinesP_0(long j, long j2, double d2, double d3, int i, double d4, double d5);

    public static native void HoughLinesP_1(long j, long j2, double d2, double d3, int i);

    public static native void HoughLines_0(long j, long j2, double d2, double d3, int i, double d4, double d5, double d6, double d7);

    public static native void HoughLines_1(long j, long j2, double d2, double d3, int i);

    public static native void HuMoments_0(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, long j);

    public static native void Laplacian_0(long j, long j2, int i, int i2, double d2, double d3, int i3);

    public static native void Laplacian_1(long j, long j2, int i, int i2, double d2, double d3);

    public static native void Laplacian_2(long j, long j2, int i);

    public static native void Scharr_0(long j, long j2, int i, int i2, int i3, double d2, double d3, int i4);

    public static native void Scharr_1(long j, long j2, int i, int i2, int i3, double d2, double d3);

    public static native void Scharr_2(long j, long j2, int i, int i2, int i3);

    public static native void Sobel_0(long j, long j2, int i, int i2, int i3, int i4, double d2, double d3, int i5);

    public static native void Sobel_1(long j, long j2, int i, int i2, int i3, int i4, double d2, double d3);

    public static native void Sobel_2(long j, long j2, int i, int i2, int i3);

    public static native void accumulateProduct_0(long j, long j2, long j3, long j4);

    public static native void accumulateProduct_1(long j, long j2, long j3);

    public static native void accumulateSquare_0(long j, long j2, long j3);

    public static native void accumulateSquare_1(long j, long j2);

    public static native void accumulateWeighted_0(long j, long j2, double d2, long j3);

    public static native void accumulateWeighted_1(long j, long j2, double d2);

    public static native void accumulate_0(long j, long j2, long j3);

    public static native void accumulate_1(long j, long j2);

    public static native void adaptiveThreshold_0(long j, long j2, double d2, int i, int i2, int i3, double d3);

    public static native void applyColorMap_0(long j, long j2, int i);

    public static native void approxPolyDP_0(long j, long j2, double d2, boolean z);

    public static native double arcLength_0(long j, boolean z);

    public static native void arrowedLine_0(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, int i, int i2, int i3, double d10);

    public static native void arrowedLine_1(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9);

    public static native void bilateralFilter_0(long j, long j2, int i, double d2, double d3, int i2);

    public static native void bilateralFilter_1(long j, long j2, int i, double d2, double d3);

    public static native void blur_0(long j, long j2, double d2, double d3, double d4, double d5, int i);

    public static native void blur_1(long j, long j2, double d2, double d3, double d4, double d5);

    public static native void blur_2(long j, long j2, double d2, double d3);

    public static native double[] boundingRect_0(long j);

    public static native void boxFilter_0(long j, long j2, int i, double d2, double d3, double d4, double d5, boolean z, int i2);

    public static native void boxFilter_1(long j, long j2, int i, double d2, double d3, double d4, double d5, boolean z);

    public static native void boxFilter_2(long j, long j2, int i, double d2, double d3);

    public static native void boxPoints_0(double d2, double d3, double d4, double d5, double d6, long j);

    public static native void calcBackProject_0(long j, long j2, long j3, long j4, long j5, double d2);

    public static native void calcHist_0(long j, long j2, long j3, long j4, long j5, long j6, boolean z);

    public static native void calcHist_1(long j, long j2, long j3, long j4, long j5, long j6);

    public static native void circle_0(long j, double d2, double d3, int i, double d4, double d5, double d6, double d7, int i2, int i3, int i4);

    public static native void circle_1(long j, double d2, double d3, int i, double d4, double d5, double d6, double d7, int i2);

    public static native void circle_2(long j, double d2, double d3, int i, double d4, double d5, double d6, double d7);

    public static native boolean clipLine_0(int i, int i2, int i3, int i4, double d2, double d3, double[] dArr, double d4, double d5, double[] dArr2);

    public static native double compareHist_0(long j, long j2, int i);

    public static native int connectedComponentsWithStats_0(long j, long j2, long j3, long j4, int i, int i2);

    public static native int connectedComponentsWithStats_1(long j, long j2, long j3, long j4);

    public static native int connectedComponents_0(long j, long j2, int i, int i2);

    public static native int connectedComponents_1(long j, long j2);

    public static native double contourArea_0(long j, boolean z);

    public static native double contourArea_1(long j);

    public static native void convertMaps_0(long j, long j2, long j3, long j4, int i, boolean z);

    public static native void convertMaps_1(long j, long j2, long j3, long j4, int i);

    public static native void convexHull_0(long j, long j2, boolean z);

    public static native void convexHull_1(long j, long j2);

    public static native void convexityDefects_0(long j, long j2, long j3);

    public static native void cornerEigenValsAndVecs_0(long j, long j2, int i, int i2, int i3);

    public static native void cornerEigenValsAndVecs_1(long j, long j2, int i, int i2);

    public static native void cornerHarris_0(long j, long j2, int i, int i2, double d2, int i3);

    public static native void cornerHarris_1(long j, long j2, int i, int i2, double d2);

    public static native void cornerMinEigenVal_0(long j, long j2, int i, int i2, int i3);

    public static native void cornerMinEigenVal_1(long j, long j2, int i, int i2);

    public static native void cornerMinEigenVal_2(long j, long j2, int i);

    public static native void cornerSubPix_0(long j, long j2, double d2, double d3, double d4, double d5, int i, int i2, double d6);

    public static native long createCLAHE_0(double d2, double d3, double d4);

    public static native long createCLAHE_1();

    public static native void createHanningWindow_0(long j, double d2, double d3, int i);

    public static native long createLineSegmentDetector_0(int i, double d2, double d3, double d4, double d5, double d6, double d7, int i2);

    public static native long createLineSegmentDetector_1();

    public static void cvtColor(Mat mat, Mat mat2, int i, int i2) {
        cvtColor_0(mat.nativeObj, mat2.nativeObj, i, i2);
    }

    public static native void cvtColor_0(long j, long j2, int i, int i2);

    public static native void cvtColor_1(long j, long j2, int i);

    public static native void demosaicing_0(long j, long j2, int i, int i2);

    public static native void demosaicing_1(long j, long j2, int i);

    public static native void dilate_0(long j, long j2, long j3, double d2, double d3, int i, int i2, double d4, double d5, double d6, double d7);

    public static native void dilate_1(long j, long j2, long j3, double d2, double d3, int i);

    public static native void dilate_2(long j, long j2, long j3);

    public static native void distanceTransformWithLabels_0(long j, long j2, long j3, int i, int i2, int i3);

    public static native void distanceTransformWithLabels_1(long j, long j2, long j3, int i, int i2);

    public static native void distanceTransform_0(long j, long j2, int i, int i2, int i3);

    public static native void distanceTransform_1(long j, long j2, int i, int i2);

    public static native void drawContours_0(long j, long j2, int i, double d2, double d3, double d4, double d5, int i2, int i3, long j3, int i4, double d6, double d7);

    public static native void drawContours_1(long j, long j2, int i, double d2, double d3, double d4, double d5, int i2);

    public static native void drawContours_2(long j, long j2, int i, double d2, double d3, double d4, double d5);

    public static native void drawMarker_0(long j, double d2, double d3, double d4, double d5, double d6, double d7, int i, int i2, int i3, int i4);

    public static native void drawMarker_1(long j, double d2, double d3, double d4, double d5, double d6, double d7);

    public static native void ellipse2Poly_0(double d2, double d3, double d4, double d5, int i, int i2, int i3, int i4, long j);

    public static native void ellipse_0(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, int i, int i2, int i3);

    public static native void ellipse_1(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, int i);

    public static native void ellipse_2(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12);

    public static native void ellipse_3(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, int i, int i2);

    public static native void ellipse_4(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, int i);

    public static native void ellipse_5(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10);

    public static native void equalizeHist_0(long j, long j2);

    public static native void erode_0(long j, long j2, long j3, double d2, double d3, int i, int i2, double d4, double d5, double d6, double d7);

    public static native void erode_1(long j, long j2, long j3, double d2, double d3, int i);

    public static native void erode_2(long j, long j2, long j3);

    public static native void fillConvexPoly_0(long j, long j2, double d2, double d3, double d4, double d5, int i, int i2);

    public static native void fillConvexPoly_1(long j, long j2, double d2, double d3, double d4, double d5);

    public static native void fillPoly_0(long j, long j2, double d2, double d3, double d4, double d5, int i, int i2, double d6, double d7);

    public static native void fillPoly_1(long j, long j2, double d2, double d3, double d4, double d5);

    public static native void filter2D_0(long j, long j2, int i, long j3, double d2, double d3, double d4, int i2);

    public static native void filter2D_1(long j, long j2, int i, long j3, double d2, double d3, double d4);

    public static native void filter2D_2(long j, long j2, int i, long j3);

    public static native void findContours_0(long j, long j2, long j3, int i, int i2, double d2, double d3);

    public static native void findContours_1(long j, long j2, long j3, int i, int i2);

    public static native double[] fitEllipse_0(long j);

    public static native void fitLine_0(long j, long j2, int i, double d2, double d3, double d4);

    public static native int floodFill_0(long j, long j2, double d2, double d3, double d4, double d5, double d6, double d7, double[] dArr, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, int i);

    public static native int floodFill_1(long j, long j2, double d2, double d3, double d4, double d5, double d6, double d7);

    public static native long getAffineTransform_0(long j, long j2);

    public static native long getDefaultNewCameraMatrix_0(long j, double d2, double d3, boolean z);

    public static native long getDefaultNewCameraMatrix_1(long j);

    public static native void getDerivKernels_0(long j, long j2, int i, int i2, int i3, boolean z, int i4);

    public static native void getDerivKernels_1(long j, long j2, int i, int i2, int i3);

    public static native long getGaborKernel_0(double d2, double d3, double d4, double d5, double d6, double d7, double d8, int i);

    public static native long getGaborKernel_1(double d2, double d3, double d4, double d5, double d6, double d7);

    public static native long getGaussianKernel_0(int i, double d2, int i2);

    public static native long getGaussianKernel_1(int i, double d2);

    public static native long getPerspectiveTransform_0(long j, long j2);

    public static native void getRectSubPix_0(long j, double d2, double d3, double d4, double d5, long j2, int i);

    public static native void getRectSubPix_1(long j, double d2, double d3, double d4, double d5, long j2);

    public static native long getRotationMatrix2D_0(double d2, double d3, double d4, double d5);

    public static native long getStructuringElement_0(int i, double d2, double d3, double d4, double d5);

    public static native long getStructuringElement_1(int i, double d2, double d3);

    public static native void goodFeaturesToTrack_0(long j, long j2, int i, double d2, double d3, long j3, int i2, boolean z, double d4);

    public static native void goodFeaturesToTrack_1(long j, long j2, int i, double d2, double d3);

    public static native void grabCut_0(long j, long j2, int i, int i2, int i3, int i4, long j3, long j4, int i5, int i6);

    public static native void grabCut_1(long j, long j2, int i, int i2, int i3, int i4, long j3, long j4, int i5);

    public static native void initUndistortRectifyMap_0(long j, long j2, long j3, long j4, double d2, double d3, int i, long j5, long j6);

    public static native float initWideAngleProjMap_0(long j, long j2, double d2, double d3, int i, int i2, long j3, long j4, int i3, double d4);

    public static native float initWideAngleProjMap_1(long j, long j2, double d2, double d3, int i, int i2, long j3, long j4);

    public static native void integral2_0(long j, long j2, long j3, int i, int i2);

    public static native void integral2_1(long j, long j2, long j3);

    public static native void integral3_0(long j, long j2, long j3, long j4, int i, int i2);

    public static native void integral3_1(long j, long j2, long j3, long j4);

    public static native void integral_0(long j, long j2, int i);

    public static native void integral_1(long j, long j2);

    public static native float intersectConvexConvex_0(long j, long j2, long j3, boolean z);

    public static native float intersectConvexConvex_1(long j, long j2, long j3);

    public static native void invertAffineTransform_0(long j, long j2);

    public static native boolean isContourConvex_0(long j);

    public static native void line_0(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, int i, int i2, int i3);

    public static native void line_1(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, int i);

    public static native void line_2(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9);

    public static native void linearPolar_0(long j, long j2, double d2, double d3, double d4, int i);

    public static native void logPolar_0(long j, long j2, double d2, double d3, double d4, int i);

    public static native double matchShapes_0(long j, long j2, int i, double d2);

    public static native void matchTemplate_0(long j, long j2, long j3, int i, long j4);

    public static native void matchTemplate_1(long j, long j2, long j3, int i);

    public static native void medianBlur_0(long j, long j2, int i);

    public static native double[] minAreaRect_0(long j);

    public static native void minEnclosingCircle_0(long j, double[] dArr, double[] dArr2);

    public static native double minEnclosingTriangle_0(long j, long j2);

    public static native double[] moments_0(long j, boolean z);

    public static native double[] moments_1(long j);

    public static native void morphologyEx_0(long j, long j2, int i, long j3, double d2, double d3, int i2, int i3, double d4, double d5, double d6, double d7);

    public static native void morphologyEx_1(long j, long j2, int i, long j3, double d2, double d3, int i2);

    public static native void morphologyEx_2(long j, long j2, int i, long j3);

    public static native double[] n_getTextSize(String str, int i, double d2, int i2, int[] iArr);

    public static native double[] phaseCorrelate_0(long j, long j2, long j3, double[] dArr);

    public static native double[] phaseCorrelate_1(long j, long j2);

    public static native double pointPolygonTest_0(long j, double d2, double d3, boolean z);

    public static native void polylines_0(long j, long j2, boolean z, double d2, double d3, double d4, double d5, int i, int i2, int i3);

    public static native void polylines_1(long j, long j2, boolean z, double d2, double d3, double d4, double d5, int i);

    public static native void polylines_2(long j, long j2, boolean z, double d2, double d3, double d4, double d5);

    public static native void preCornerDetect_0(long j, long j2, int i, int i2);

    public static native void preCornerDetect_1(long j, long j2, int i);

    public static native void putText_0(long j, String str, double d2, double d3, int i, double d4, double d5, double d6, double d7, double d8, int i2, int i3, boolean z);

    public static native void putText_1(long j, String str, double d2, double d3, int i, double d4, double d5, double d6, double d7, double d8, int i2);

    public static native void putText_2(long j, String str, double d2, double d3, int i, double d4, double d5, double d6, double d7, double d8);

    public static native void pyrDown_0(long j, long j2, double d2, double d3, int i);

    public static native void pyrDown_1(long j, long j2, double d2, double d3);

    public static native void pyrDown_2(long j, long j2);

    public static native void pyrMeanShiftFiltering_0(long j, long j2, double d2, double d3, int i, int i2, int i3, double d4);

    public static native void pyrMeanShiftFiltering_1(long j, long j2, double d2, double d3);

    public static native void pyrUp_0(long j, long j2, double d2, double d3, int i);

    public static native void pyrUp_1(long j, long j2, double d2, double d3);

    public static native void pyrUp_2(long j, long j2);

    public static native void rectangle_0(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, int i, int i2, int i3);

    public static native void rectangle_1(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, int i);

    public static native void rectangle_2(long j, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9);

    public static native void remap_0(long j, long j2, long j3, long j4, int i, int i2, double d2, double d3, double d4, double d5);

    public static native void remap_1(long j, long j2, long j3, long j4, int i);

    public static native void resize_0(long j, long j2, double d2, double d3, double d4, double d5, int i);

    public static native void resize_1(long j, long j2, double d2, double d3);

    public static native int rotatedRectangleIntersection_0(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, long j);

    public static native void sepFilter2D_0(long j, long j2, int i, long j3, long j4, double d2, double d3, double d4, int i2);

    public static native void sepFilter2D_1(long j, long j2, int i, long j3, long j4, double d2, double d3, double d4);

    public static native void sepFilter2D_2(long j, long j2, int i, long j3, long j4);

    public static native void spatialGradient_0(long j, long j2, long j3, int i, int i2);

    public static native void spatialGradient_1(long j, long j2, long j3, int i);

    public static native void spatialGradient_2(long j, long j2, long j3);

    public static native void sqrBoxFilter_0(long j, long j2, int i, double d2, double d3, double d4, double d5, boolean z, int i2);

    public static native void sqrBoxFilter_1(long j, long j2, int i, double d2, double d3, double d4, double d5, boolean z);

    public static native void sqrBoxFilter_2(long j, long j2, int i, double d2, double d3);

    public static native double threshold_0(long j, long j2, double d2, double d3, int i);

    public static native void undistortPoints_0(long j, long j2, long j3, long j4, long j5, long j6);

    public static native void undistortPoints_1(long j, long j2, long j3, long j4);

    public static native void undistort_0(long j, long j2, long j3, long j4, long j5);

    public static native void undistort_1(long j, long j2, long j3, long j4);

    public static native void warpAffine_0(long j, long j2, long j3, double d2, double d3, int i, int i2, double d4, double d5, double d6, double d7);

    public static native void warpAffine_1(long j, long j2, long j3, double d2, double d3, int i);

    public static native void warpAffine_2(long j, long j2, long j3, double d2, double d3);

    public static native void warpPerspective_0(long j, long j2, long j3, double d2, double d3, int i, int i2, double d4, double d5, double d6, double d7);

    public static native void warpPerspective_1(long j, long j2, long j3, double d2, double d3, int i);

    public static native void warpPerspective_2(long j, long j2, long j3, double d2, double d3);

    public static native void watershed_0(long j, long j2);
}
