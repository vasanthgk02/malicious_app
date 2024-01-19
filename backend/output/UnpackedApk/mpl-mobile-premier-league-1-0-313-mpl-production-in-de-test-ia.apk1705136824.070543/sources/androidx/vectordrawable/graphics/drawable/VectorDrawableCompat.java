package androidx.vectordrawable.graphics.drawable;

import a.a.a.a.d.b;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ColorStateListInflaterCompat;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.graphics.PathParser$PathDataNode;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import sfs2x.client.entities.invitation.InvitationReply;

public class VectorDrawableCompat extends VectorDrawableCommon {
    public static final Mode DEFAULT_TINT_MODE = Mode.SRC_IN;
    public boolean mAllowCaching;
    public ColorFilter mColorFilter;
    public boolean mMutated;
    public PorterDuffColorFilter mTintFilter;
    public final Rect mTmpBounds;
    public final float[] mTmpFloats;
    public final Matrix mTmpMatrix;
    public VectorDrawableCompatState mVectorState;

    public static class VClipPath extends VPath {
        public VClipPath() {
        }

        public boolean isClipPath() {
            return true;
        }

        public VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }
    }

    public static class VFullPath extends VPath {
        public float mFillAlpha = 1.0f;
        public ComplexColorCompat mFillColor;
        public float mStrokeAlpha = 1.0f;
        public ComplexColorCompat mStrokeColor;
        public Cap mStrokeLineCap = Cap.BUTT;
        public Join mStrokeLineJoin = Join.MITER;
        public float mStrokeMiterlimit = 4.0f;
        public float mStrokeWidth = 0.0f;
        public int[] mThemeAttrs;
        public float mTrimPathEnd = 1.0f;
        public float mTrimPathOffset = 0.0f;
        public float mTrimPathStart = 0.0f;

        public VFullPath() {
        }

        public float getFillAlpha() {
            return this.mFillAlpha;
        }

        public int getFillColor() {
            return this.mFillColor.mColor;
        }

        public float getStrokeAlpha() {
            return this.mStrokeAlpha;
        }

        public int getStrokeColor() {
            return this.mStrokeColor.mColor;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public float getTrimPathEnd() {
            return this.mTrimPathEnd;
        }

        public float getTrimPathOffset() {
            return this.mTrimPathOffset;
        }

        public float getTrimPathStart() {
            return this.mTrimPathStart;
        }

        public boolean isStateful() {
            return this.mFillColor.isStateful() || this.mStrokeColor.isStateful();
        }

        public boolean onStateChanged(int[] iArr) {
            return this.mStrokeColor.onStateChanged(iArr) | this.mFillColor.onStateChanged(iArr);
        }

        public void setFillAlpha(float f2) {
            this.mFillAlpha = f2;
        }

        public void setFillColor(int i) {
            this.mFillColor.mColor = i;
        }

        public void setStrokeAlpha(float f2) {
            this.mStrokeAlpha = f2;
        }

        public void setStrokeColor(int i) {
            this.mStrokeColor.mColor = i;
        }

        public void setStrokeWidth(float f2) {
            this.mStrokeWidth = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.mTrimPathEnd = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.mTrimPathOffset = f2;
        }

        public void setTrimPathStart(float f2) {
            this.mTrimPathStart = f2;
        }

        public VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.mThemeAttrs = vFullPath.mThemeAttrs;
            this.mStrokeColor = vFullPath.mStrokeColor;
            this.mStrokeWidth = vFullPath.mStrokeWidth;
            this.mStrokeAlpha = vFullPath.mStrokeAlpha;
            this.mFillColor = vFullPath.mFillColor;
            this.mFillRule = vFullPath.mFillRule;
            this.mFillAlpha = vFullPath.mFillAlpha;
            this.mTrimPathStart = vFullPath.mTrimPathStart;
            this.mTrimPathEnd = vFullPath.mTrimPathEnd;
            this.mTrimPathOffset = vFullPath.mTrimPathOffset;
            this.mStrokeLineCap = vFullPath.mStrokeLineCap;
            this.mStrokeLineJoin = vFullPath.mStrokeLineJoin;
            this.mStrokeMiterlimit = vFullPath.mStrokeMiterlimit;
        }
    }

    public static class VGroup extends VObject {
        public int mChangingConfigurations;
        public final ArrayList<VObject> mChildren = new ArrayList<>();
        public String mGroupName = null;
        public final Matrix mLocalMatrix = new Matrix();
        public float mPivotX = 0.0f;
        public float mPivotY = 0.0f;
        public float mRotate = 0.0f;
        public float mScaleX = 1.0f;
        public float mScaleY = 1.0f;
        public final Matrix mStackedMatrix = new Matrix();
        public int[] mThemeAttrs;
        public float mTranslateX = 0.0f;
        public float mTranslateY = 0.0f;

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            VPath vPath;
            super(null);
            this.mRotate = vGroup.mRotate;
            this.mPivotX = vGroup.mPivotX;
            this.mPivotY = vGroup.mPivotY;
            this.mScaleX = vGroup.mScaleX;
            this.mScaleY = vGroup.mScaleY;
            this.mTranslateX = vGroup.mTranslateX;
            this.mTranslateY = vGroup.mTranslateY;
            this.mThemeAttrs = vGroup.mThemeAttrs;
            String str = vGroup.mGroupName;
            this.mGroupName = str;
            this.mChangingConfigurations = vGroup.mChangingConfigurations;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.mLocalMatrix.set(vGroup.mLocalMatrix);
            ArrayList<VObject> arrayList = vGroup.mChildren;
            for (int i = 0; i < arrayList.size(); i++) {
                VObject vObject = arrayList.get(i);
                if (vObject instanceof VGroup) {
                    this.mChildren.add(new VGroup((VGroup) vObject, arrayMap));
                } else {
                    if (vObject instanceof VFullPath) {
                        vPath = new VFullPath((VFullPath) vObject);
                    } else if (vObject instanceof VClipPath) {
                        vPath = new VClipPath((VClipPath) vObject);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.mChildren.add(vPath);
                    String str2 = vPath.mPathName;
                    if (str2 != null) {
                        arrayMap.put(str2, vPath);
                    }
                }
            }
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public Matrix getLocalMatrix() {
            return this.mLocalMatrix;
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public float getRotation() {
            return this.mRotate;
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        public boolean isStateful() {
            for (int i = 0; i < this.mChildren.size(); i++) {
                if (this.mChildren.get(i).isStateful()) {
                    return true;
                }
            }
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.mChildren.size(); i++) {
                z |= this.mChildren.get(i).onStateChanged(iArr);
            }
            return z;
        }

        public void setPivotX(float f2) {
            if (f2 != this.mPivotX) {
                this.mPivotX = f2;
                updateLocalMatrix();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.mPivotY) {
                this.mPivotY = f2;
                updateLocalMatrix();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.mRotate) {
                this.mRotate = f2;
                updateLocalMatrix();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.mScaleX) {
                this.mScaleX = f2;
                updateLocalMatrix();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.mScaleY) {
                this.mScaleY = f2;
                updateLocalMatrix();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.mTranslateX) {
                this.mTranslateX = f2;
                updateLocalMatrix();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.mTranslateY) {
                this.mTranslateY = f2;
                updateLocalMatrix();
            }
        }

        public final void updateLocalMatrix() {
            this.mLocalMatrix.reset();
            this.mLocalMatrix.postTranslate(-this.mPivotX, -this.mPivotY);
            this.mLocalMatrix.postScale(this.mScaleX, this.mScaleY);
            this.mLocalMatrix.postRotate(this.mRotate, 0.0f, 0.0f);
            this.mLocalMatrix.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        public VGroup() {
            super(null);
        }
    }

    public static abstract class VObject {
        public VObject() {
        }

        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            return false;
        }

        public VObject(AnonymousClass1 r1) {
        }
    }

    public static abstract class VPath extends VObject {
        public int mChangingConfigurations;
        public int mFillRule = 0;
        public PathParser$PathDataNode[] mNodes = null;
        public String mPathName;

        public VPath() {
            super(null);
        }

        public PathParser$PathDataNode[] getPathData() {
            return this.mNodes;
        }

        public String getPathName() {
            return this.mPathName;
        }

        public boolean isClipPath() {
            return false;
        }

        public void setPathData(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
            if (!b.canMorph(this.mNodes, pathParser$PathDataNodeArr)) {
                this.mNodes = b.deepCopyNodes(pathParser$PathDataNodeArr);
                return;
            }
            PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = this.mNodes;
            for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
                pathParser$PathDataNodeArr2[i].mType = pathParser$PathDataNodeArr[i].mType;
                for (int i2 = 0; i2 < pathParser$PathDataNodeArr[i].mParams.length; i2++) {
                    pathParser$PathDataNodeArr2[i].mParams[i2] = pathParser$PathDataNodeArr[i].mParams[i2];
                }
            }
        }

        public VPath(VPath vPath) {
            super(null);
            this.mPathName = vPath.mPathName;
            this.mChangingConfigurations = vPath.mChangingConfigurations;
            this.mNodes = b.deepCopyNodes(vPath.mNodes);
        }
    }

    public static class VPathRenderer {
        public static final Matrix IDENTITY_MATRIX = new Matrix();
        public float mBaseHeight;
        public float mBaseWidth;
        public int mChangingConfigurations;
        public Paint mFillPaint;
        public final Matrix mFinalPathMatrix;
        public Boolean mIsStateful;
        public final Path mPath;
        public PathMeasure mPathMeasure;
        public final Path mRenderPath;
        public int mRootAlpha;
        public final VGroup mRootGroup;
        public String mRootName;
        public Paint mStrokePaint;
        public final ArrayMap<String, Object> mVGTargetsMap;
        public float mViewportHeight;
        public float mViewportWidth;

        public VPathRenderer() {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = InvitationReply.EXPIRED;
            this.mRootName = null;
            this.mIsStateful = null;
            this.mVGTargetsMap = new ArrayMap<>();
            this.mRootGroup = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        /* JADX WARNING: type inference failed for: r11v0 */
        /* JADX WARNING: type inference failed for: r11v1, types: [boolean] */
        /* JADX WARNING: type inference failed for: r11v2 */
        /* JADX WARNING: type inference failed for: r11v10 */
        /* JADX WARNING: type inference failed for: r11v11 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r11v1, types: [boolean]
          assigns: []
          uses: [?[int, short, byte, char], boolean]
          mth insns count: 240
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
         */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void drawGroupTree(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup r18, android.graphics.Matrix r19, android.graphics.Canvas r20, int r21, int r22, android.graphics.ColorFilter r23) {
            /*
                r17 = this;
                r7 = r17
                r8 = r18
                r9 = r20
                r10 = r23
                android.graphics.Matrix r0 = r8.mStackedMatrix
                r1 = r19
                r0.set(r1)
                android.graphics.Matrix r0 = r8.mStackedMatrix
                android.graphics.Matrix r1 = r8.mLocalMatrix
                r0.preConcat(r1)
                r20.save()
                r11 = 0
                r12 = 0
            L_0x001b:
                java.util.ArrayList<androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VObject> r0 = r8.mChildren
                int r0 = r0.size()
                if (r12 >= r0) goto L_0x023a
                java.util.ArrayList<androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VObject> r0 = r8.mChildren
                java.lang.Object r0 = r0.get(r12)
                androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VObject r0 = (androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject) r0
                boolean r1 = r0 instanceof androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup
                if (r1 == 0) goto L_0x0043
                r1 = r0
                androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VGroup r1 = (androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VGroup) r1
                android.graphics.Matrix r2 = r8.mStackedMatrix
                r0 = r17
                r3 = r20
                r4 = r21
                r5 = r22
                r6 = r23
                r0.drawGroupTree(r1, r2, r3, r4, r5, r6)
                goto L_0x022f
            L_0x0043:
                boolean r1 = r0 instanceof androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
                if (r1 == 0) goto L_0x022f
                androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath r0 = (androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath) r0
                r1 = r21
                float r2 = (float) r1
                float r3 = r7.mViewportWidth
                float r2 = r2 / r3
                r3 = r22
                float r4 = (float) r3
                float r5 = r7.mViewportHeight
                float r4 = r4 / r5
                float r5 = java.lang.Math.min(r2, r4)
                android.graphics.Matrix r6 = r8.mStackedMatrix
                android.graphics.Matrix r13 = r7.mFinalPathMatrix
                r13.set(r6)
                android.graphics.Matrix r13 = r7.mFinalPathMatrix
                r13.postScale(r2, r4)
                r2 = 4
                float[] r2 = new float[r2]
                r2 = {0, 1065353216, 1065353216, 0} // fill-array
                r6.mapVectors(r2)
                r4 = r2[r11]
                double r13 = (double) r4
                r4 = 1
                r6 = r2[r4]
                r19 = r5
                double r4 = (double) r6
                double r4 = java.lang.Math.hypot(r13, r4)
                float r4 = (float) r4
                r5 = 2
                r6 = r2[r5]
                double r13 = (double) r6
                r6 = 3
                r15 = r2[r6]
                double r6 = (double) r15
                double r6 = java.lang.Math.hypot(r13, r6)
                float r6 = (float) r6
                r7 = r2[r11]
                r13 = 1
                r14 = r2[r13]
                r5 = r2[r5]
                r13 = 3
                r2 = r2[r13]
                float r7 = r7 * r2
                float r14 = r14 * r5
                float r7 = r7 - r14
                float r2 = java.lang.Math.max(r4, r6)
                r4 = 0
                int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r5 <= 0) goto L_0x00a7
                float r5 = java.lang.Math.abs(r7)
                float r5 = r5 / r2
                goto L_0x00a8
            L_0x00a7:
                r5 = 0
            L_0x00a8:
                int r2 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
                if (r2 != 0) goto L_0x00b0
                r2 = r17
                goto L_0x0234
            L_0x00b0:
                r2 = r17
                android.graphics.Path r6 = r2.mPath
                if (r0 == 0) goto L_0x022d
                r6.reset()
                androidx.core.graphics.PathParser$PathDataNode[] r13 = r0.mNodes
                if (r13 == 0) goto L_0x00c0
                androidx.core.graphics.PathParser$PathDataNode.nodesToPath(r13, r6)
            L_0x00c0:
                android.graphics.Path r6 = r2.mPath
                android.graphics.Path r13 = r2.mRenderPath
                r13.reset()
                boolean r13 = r0.isClipPath()
                if (r13 == 0) goto L_0x00e9
                android.graphics.Path r4 = r2.mRenderPath
                int r0 = r0.mFillRule
                if (r0 != 0) goto L_0x00d6
                android.graphics.Path$FillType r0 = android.graphics.Path.FillType.WINDING
                goto L_0x00d8
            L_0x00d6:
                android.graphics.Path$FillType r0 = android.graphics.Path.FillType.EVEN_ODD
            L_0x00d8:
                r4.setFillType(r0)
                android.graphics.Path r0 = r2.mRenderPath
                android.graphics.Matrix r4 = r2.mFinalPathMatrix
                r0.addPath(r6, r4)
                android.graphics.Path r0 = r2.mRenderPath
                r9.clipPath(r0)
                goto L_0x0234
            L_0x00e9:
                androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VFullPath r0 = (androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VFullPath) r0
                float r13 = r0.mTrimPathStart
                r14 = 1065353216(0x3f800000, float:1.0)
                int r13 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
                if (r13 != 0) goto L_0x00f9
                float r13 = r0.mTrimPathEnd
                int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
                if (r13 == 0) goto L_0x013b
            L_0x00f9:
                float r13 = r0.mTrimPathStart
                float r15 = r0.mTrimPathOffset
                float r13 = r13 + r15
                float r13 = r13 % r14
                float r7 = r0.mTrimPathEnd
                float r7 = r7 + r15
                float r7 = r7 % r14
                android.graphics.PathMeasure r14 = r2.mPathMeasure
                if (r14 != 0) goto L_0x010e
                android.graphics.PathMeasure r14 = new android.graphics.PathMeasure
                r14.<init>()
                r2.mPathMeasure = r14
            L_0x010e:
                android.graphics.PathMeasure r14 = r2.mPathMeasure
                android.graphics.Path r15 = r2.mPath
                r14.setPath(r15, r11)
                android.graphics.PathMeasure r14 = r2.mPathMeasure
                float r14 = r14.getLength()
                float r13 = r13 * r14
                float r7 = r7 * r14
                r6.reset()
                int r15 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
                if (r15 <= 0) goto L_0x0132
                android.graphics.PathMeasure r15 = r2.mPathMeasure
                r11 = 1
                r15.getSegment(r13, r14, r6, r11)
                android.graphics.PathMeasure r13 = r2.mPathMeasure
                r13.getSegment(r4, r7, r6, r11)
                goto L_0x0138
            L_0x0132:
                r11 = 1
                android.graphics.PathMeasure r14 = r2.mPathMeasure
                r14.getSegment(r13, r7, r6, r11)
            L_0x0138:
                r6.rLineTo(r4, r4)
            L_0x013b:
                android.graphics.Path r4 = r2.mRenderPath
                android.graphics.Matrix r7 = r2.mFinalPathMatrix
                r4.addPath(r6, r7)
                androidx.core.content.res.ComplexColorCompat r4 = r0.mFillColor
                boolean r6 = r4.isGradient()
                if (r6 != 0) goto L_0x0151
                int r4 = r4.mColor
                if (r4 == 0) goto L_0x014f
                goto L_0x0151
            L_0x014f:
                r4 = 0
                goto L_0x0152
            L_0x0151:
                r4 = 1
            L_0x0152:
                r6 = 1132396544(0x437f0000, float:255.0)
                r7 = 255(0xff, float:3.57E-43)
                if (r4 == 0) goto L_0x01b1
                androidx.core.content.res.ComplexColorCompat r4 = r0.mFillColor
                android.graphics.Paint r11 = r2.mFillPaint
                if (r11 != 0) goto L_0x016b
                android.graphics.Paint r11 = new android.graphics.Paint
                r13 = 1
                r11.<init>(r13)
                r2.mFillPaint = r11
                android.graphics.Paint$Style r13 = android.graphics.Paint.Style.FILL
                r11.setStyle(r13)
            L_0x016b:
                android.graphics.Paint r11 = r2.mFillPaint
                boolean r13 = r4.isGradient()
                if (r13 == 0) goto L_0x0189
                android.graphics.Shader r4 = r4.mShader
                android.graphics.Matrix r13 = r2.mFinalPathMatrix
                r4.setLocalMatrix(r13)
                r11.setShader(r4)
                float r4 = r0.mFillAlpha
                float r4 = r4 * r6
                int r4 = java.lang.Math.round(r4)
                r11.setAlpha(r4)
                goto L_0x019b
            L_0x0189:
                r13 = 0
                r11.setShader(r13)
                r11.setAlpha(r7)
                int r4 = r4.mColor
                float r13 = r0.mFillAlpha
                int r4 = androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.applyAlpha(r4, r13)
                r11.setColor(r4)
            L_0x019b:
                r11.setColorFilter(r10)
                android.graphics.Path r4 = r2.mRenderPath
                int r13 = r0.mFillRule
                if (r13 != 0) goto L_0x01a7
                android.graphics.Path$FillType r13 = android.graphics.Path.FillType.WINDING
                goto L_0x01a9
            L_0x01a7:
                android.graphics.Path$FillType r13 = android.graphics.Path.FillType.EVEN_ODD
            L_0x01a9:
                r4.setFillType(r13)
                android.graphics.Path r4 = r2.mRenderPath
                r9.drawPath(r4, r11)
            L_0x01b1:
                androidx.core.content.res.ComplexColorCompat r4 = r0.mStrokeColor
                boolean r11 = r4.isGradient()
                if (r11 != 0) goto L_0x01c1
                int r4 = r4.mColor
                if (r4 == 0) goto L_0x01be
                goto L_0x01c1
            L_0x01be:
                r16 = 0
                goto L_0x01c3
            L_0x01c1:
                r16 = 1
            L_0x01c3:
                if (r16 == 0) goto L_0x0234
                androidx.core.content.res.ComplexColorCompat r4 = r0.mStrokeColor
                android.graphics.Paint r11 = r2.mStrokePaint
                if (r11 != 0) goto L_0x01d8
                android.graphics.Paint r11 = new android.graphics.Paint
                r13 = 1
                r11.<init>(r13)
                r2.mStrokePaint = r11
                android.graphics.Paint$Style r13 = android.graphics.Paint.Style.STROKE
                r11.setStyle(r13)
            L_0x01d8:
                android.graphics.Paint r11 = r2.mStrokePaint
                android.graphics.Paint$Join r13 = r0.mStrokeLineJoin
                if (r13 == 0) goto L_0x01e1
                r11.setStrokeJoin(r13)
            L_0x01e1:
                android.graphics.Paint$Cap r13 = r0.mStrokeLineCap
                if (r13 == 0) goto L_0x01e8
                r11.setStrokeCap(r13)
            L_0x01e8:
                float r13 = r0.mStrokeMiterlimit
                r11.setStrokeMiter(r13)
                boolean r13 = r4.isGradient()
                if (r13 == 0) goto L_0x0209
                android.graphics.Shader r4 = r4.mShader
                android.graphics.Matrix r7 = r2.mFinalPathMatrix
                r4.setLocalMatrix(r7)
                r11.setShader(r4)
                float r4 = r0.mStrokeAlpha
                float r4 = r4 * r6
                int r4 = java.lang.Math.round(r4)
                r11.setAlpha(r4)
                goto L_0x021b
            L_0x0209:
                r6 = 0
                r11.setShader(r6)
                r11.setAlpha(r7)
                int r4 = r4.mColor
                float r6 = r0.mStrokeAlpha
                int r4 = androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.applyAlpha(r4, r6)
                r11.setColor(r4)
            L_0x021b:
                r11.setColorFilter(r10)
                float r5 = r5 * r19
                float r0 = r0.mStrokeWidth
                float r0 = r0 * r5
                r11.setStrokeWidth(r0)
                android.graphics.Path r0 = r2.mRenderPath
                r9.drawPath(r0, r11)
                goto L_0x0234
            L_0x022d:
                r0 = 0
                throw r0
            L_0x022f:
                r1 = r21
                r3 = r22
                r2 = r7
            L_0x0234:
                int r12 = r12 + 1
                r7 = r2
                r11 = 0
                goto L_0x001b
            L_0x023a:
                r2 = r7
                r20.restore()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPathRenderer.drawGroupTree(androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VGroup, android.graphics.Matrix, android.graphics.Canvas, int, int, android.graphics.ColorFilter):void");
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.mRootAlpha;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.mRootAlpha = i;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.mFinalPathMatrix = new Matrix();
            this.mBaseWidth = 0.0f;
            this.mBaseHeight = 0.0f;
            this.mViewportWidth = 0.0f;
            this.mViewportHeight = 0.0f;
            this.mRootAlpha = InvitationReply.EXPIRED;
            this.mRootName = null;
            this.mIsStateful = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.mVGTargetsMap = arrayMap;
            this.mRootGroup = new VGroup(vPathRenderer.mRootGroup, arrayMap);
            this.mPath = new Path(vPathRenderer.mPath);
            this.mRenderPath = new Path(vPathRenderer.mRenderPath);
            this.mBaseWidth = vPathRenderer.mBaseWidth;
            this.mBaseHeight = vPathRenderer.mBaseHeight;
            this.mViewportWidth = vPathRenderer.mViewportWidth;
            this.mViewportHeight = vPathRenderer.mViewportHeight;
            this.mChangingConfigurations = vPathRenderer.mChangingConfigurations;
            this.mRootAlpha = vPathRenderer.mRootAlpha;
            this.mRootName = vPathRenderer.mRootName;
            String str = vPathRenderer.mRootName;
            if (str != null) {
                this.mVGTargetsMap.put(str, this);
            }
            this.mIsStateful = vPathRenderer.mIsStateful;
        }
    }

    public static class VectorDrawableCompatState extends ConstantState {
        public boolean mAutoMirrored;
        public boolean mCacheDirty;
        public boolean mCachedAutoMirrored;
        public Bitmap mCachedBitmap;
        public int mCachedRootAlpha;
        public ColorStateList mCachedTint;
        public Mode mCachedTintMode;
        public int mChangingConfigurations;
        public Paint mTempPaint;
        public ColorStateList mTint;
        public Mode mTintMode;
        public VPathRenderer mVPathRenderer;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            if (vectorDrawableCompatState != null) {
                this.mChangingConfigurations = vectorDrawableCompatState.mChangingConfigurations;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.mVPathRenderer);
                this.mVPathRenderer = vPathRenderer;
                if (vectorDrawableCompatState.mVPathRenderer.mFillPaint != null) {
                    vPathRenderer.mFillPaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mFillPaint);
                }
                if (vectorDrawableCompatState.mVPathRenderer.mStrokePaint != null) {
                    this.mVPathRenderer.mStrokePaint = new Paint(vectorDrawableCompatState.mVPathRenderer.mStrokePaint);
                }
                this.mTint = vectorDrawableCompatState.mTint;
                this.mTintMode = vectorDrawableCompatState.mTintMode;
                this.mAutoMirrored = vectorDrawableCompatState.mAutoMirrored;
            }
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public boolean isStateful() {
            VPathRenderer vPathRenderer = this.mVPathRenderer;
            if (vPathRenderer.mIsStateful == null) {
                vPathRenderer.mIsStateful = Boolean.valueOf(vPathRenderer.mRootGroup.isStateful());
            }
            return vPathRenderer.mIsStateful.booleanValue();
        }

        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        public void updateCachedBitmap(int i, int i2) {
            this.mCachedBitmap.eraseColor(0);
            Canvas canvas = new Canvas(this.mCachedBitmap);
            VPathRenderer vPathRenderer = this.mVPathRenderer;
            vPathRenderer.drawGroupTree(vPathRenderer.mRootGroup, VPathRenderer.IDENTITY_MATRIX, canvas, i, i2, null);
        }

        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public VectorDrawableCompatState() {
            this.mTint = null;
            this.mTintMode = VectorDrawableCompat.DEFAULT_TINT_MODE;
            this.mVPathRenderer = new VPathRenderer();
        }
    }

    public static class VectorDrawableDelegateState extends ConstantState {
        public final ConstantState mDelegateState;

        public VectorDrawableDelegateState(ConstantState constantState) {
            this.mDelegateState = constantState;
        }

        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable();
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources);
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.mDelegateDrawable = (VectorDrawable) this.mDelegateState.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    public VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompatState();
    }

    public static int applyAlpha(int i, float f2) {
        return (i & 16777215) | (((int) (((float) Color.alpha(i)) * f2)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032 A[Catch:{ IOException | XmlPullParserException -> 0x003f, IOException | XmlPullParserException -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037 A[Catch:{ IOException | XmlPullParserException -> 0x003f, IOException | XmlPullParserException -> 0x003f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.VectorDrawableCompat create(android.content.res.Resources r4, int r5, android.content.res.Resources.Theme r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L_0x001d
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r0 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
            r0.<init>()
            android.graphics.drawable.Drawable r4 = androidx.core.content.res.ResourcesCompat.getDrawable(r4, r5, r6)
            r0.mDelegateDrawable = r4
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState r4 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState
            android.graphics.drawable.Drawable r5 = r0.mDelegateDrawable
            android.graphics.drawable.Drawable$ConstantState r5 = r5.getConstantState()
            r4.<init>(r5)
            return r0
        L_0x001d:
            android.content.res.XmlResourceParser r5 = r4.getXml(r5)     // Catch:{ IOException | XmlPullParserException -> 0x003f }
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)     // Catch:{ IOException | XmlPullParserException -> 0x003f }
        L_0x0025:
            int r1 = r5.next()     // Catch:{ IOException | XmlPullParserException -> 0x003f }
            r2 = 2
            if (r1 == r2) goto L_0x0030
            r3 = 1
            if (r1 == r3) goto L_0x0030
            goto L_0x0025
        L_0x0030:
            if (r1 != r2) goto L_0x0037
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r4 = createFromXmlInner(r4, r5, r0, r6)     // Catch:{ IOException | XmlPullParserException -> 0x003f }
            return r4
        L_0x0037:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ IOException | XmlPullParserException -> 0x003f }
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)     // Catch:{ IOException | XmlPullParserException -> 0x003f }
            throw r4     // Catch:{ IOException | XmlPullParserException -> 0x003f }
        L_0x003f:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.create(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.graphics.drawable.VectorDrawableCompat");
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.canApplyTheme();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d3, code lost:
        if ((r1 == r7.getWidth() && r3 == r6.mCachedBitmap.getHeight()) == false) goto L_0x00d5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r11) {
        /*
            r10 = this;
            android.graphics.drawable.Drawable r0 = r10.mDelegateDrawable
            if (r0 == 0) goto L_0x0008
            r0.draw(r11)
            return
        L_0x0008:
            android.graphics.Rect r0 = r10.mTmpBounds
            r10.copyBounds(r0)
            android.graphics.Rect r0 = r10.mTmpBounds
            int r0 = r0.width()
            if (r0 <= 0) goto L_0x016b
            android.graphics.Rect r0 = r10.mTmpBounds
            int r0 = r0.height()
            if (r0 > 0) goto L_0x001f
            goto L_0x016b
        L_0x001f:
            android.graphics.ColorFilter r0 = r10.mColorFilter
            if (r0 != 0) goto L_0x0025
            android.graphics.PorterDuffColorFilter r0 = r10.mTintFilter
        L_0x0025:
            android.graphics.Matrix r1 = r10.mTmpMatrix
            r11.getMatrix(r1)
            android.graphics.Matrix r1 = r10.mTmpMatrix
            float[] r2 = r10.mTmpFloats
            r1.getValues(r2)
            float[] r1 = r10.mTmpFloats
            r2 = 0
            r1 = r1[r2]
            float r1 = java.lang.Math.abs(r1)
            float[] r3 = r10.mTmpFloats
            r4 = 4
            r3 = r3[r4]
            float r3 = java.lang.Math.abs(r3)
            float[] r4 = r10.mTmpFloats
            r5 = 1
            r4 = r4[r5]
            float r4 = java.lang.Math.abs(r4)
            float[] r6 = r10.mTmpFloats
            r7 = 3
            r6 = r6[r7]
            float r6 = java.lang.Math.abs(r6)
            r7 = 1065353216(0x3f800000, float:1.0)
            r8 = 0
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x0060
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0064
        L_0x0060:
            r1 = 1065353216(0x3f800000, float:1.0)
            r3 = 1065353216(0x3f800000, float:1.0)
        L_0x0064:
            android.graphics.Rect r4 = r10.mTmpBounds
            int r4 = r4.width()
            float r4 = (float) r4
            float r4 = r4 * r1
            int r1 = (int) r4
            android.graphics.Rect r4 = r10.mTmpBounds
            int r4 = r4.height()
            float r4 = (float) r4
            float r4 = r4 * r3
            int r3 = (int) r4
            r4 = 2048(0x800, float:2.87E-42)
            int r1 = java.lang.Math.min(r4, r1)
            int r3 = java.lang.Math.min(r4, r3)
            if (r1 <= 0) goto L_0x016b
            if (r3 > 0) goto L_0x0088
            goto L_0x016b
        L_0x0088:
            int r4 = r11.save()
            android.graphics.Rect r6 = r10.mTmpBounds
            int r9 = r6.left
            float r9 = (float) r9
            int r6 = r6.top
            float r6 = (float) r6
            r11.translate(r9, r6)
            boolean r6 = r10.isAutoMirrored()
            if (r6 == 0) goto L_0x00a5
            int r6 = a.a.a.a.d.b.getLayoutDirection(r10)
            if (r6 != r5) goto L_0x00a5
            r6 = 1
            goto L_0x00a6
        L_0x00a5:
            r6 = 0
        L_0x00a6:
            if (r6 == 0) goto L_0x00b7
            android.graphics.Rect r6 = r10.mTmpBounds
            int r6 = r6.width()
            float r6 = (float) r6
            r11.translate(r6, r8)
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11.scale(r6, r7)
        L_0x00b7:
            android.graphics.Rect r6 = r10.mTmpBounds
            r6.offsetTo(r2, r2)
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r6 = r10.mVectorState
            android.graphics.Bitmap r7 = r6.mCachedBitmap
            if (r7 == 0) goto L_0x00d5
            int r7 = r7.getWidth()
            if (r1 != r7) goto L_0x00d2
            android.graphics.Bitmap r7 = r6.mCachedBitmap
            int r7 = r7.getHeight()
            if (r3 != r7) goto L_0x00d2
            r7 = 1
            goto L_0x00d3
        L_0x00d2:
            r7 = 0
        L_0x00d3:
            if (r7 != 0) goto L_0x00df
        L_0x00d5:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r7 = android.graphics.Bitmap.createBitmap(r1, r3, r7)
            r6.mCachedBitmap = r7
            r6.mCacheDirty = r5
        L_0x00df:
            boolean r6 = r10.mAllowCaching
            if (r6 != 0) goto L_0x00e9
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r6 = r10.mVectorState
            r6.updateCachedBitmap(r1, r3)
            goto L_0x012d
        L_0x00e9:
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r6 = r10.mVectorState
            boolean r7 = r6.mCacheDirty
            if (r7 != 0) goto L_0x010d
            android.content.res.ColorStateList r7 = r6.mCachedTint
            android.content.res.ColorStateList r8 = r6.mTint
            if (r7 != r8) goto L_0x010d
            android.graphics.PorterDuff$Mode r7 = r6.mCachedTintMode
            android.graphics.PorterDuff$Mode r8 = r6.mTintMode
            if (r7 != r8) goto L_0x010d
            boolean r7 = r6.mCachedAutoMirrored
            boolean r8 = r6.mAutoMirrored
            if (r7 != r8) goto L_0x010d
            int r7 = r6.mCachedRootAlpha
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPathRenderer r6 = r6.mVPathRenderer
            int r6 = r6.getRootAlpha()
            if (r7 != r6) goto L_0x010d
            r6 = 1
            goto L_0x010e
        L_0x010d:
            r6 = 0
        L_0x010e:
            if (r6 != 0) goto L_0x012d
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r6 = r10.mVectorState
            r6.updateCachedBitmap(r1, r3)
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r1 = r10.mVectorState
            android.content.res.ColorStateList r3 = r1.mTint
            r1.mCachedTint = r3
            android.graphics.PorterDuff$Mode r3 = r1.mTintMode
            r1.mCachedTintMode = r3
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPathRenderer r3 = r1.mVPathRenderer
            int r3 = r3.getRootAlpha()
            r1.mCachedRootAlpha = r3
            boolean r3 = r1.mAutoMirrored
            r1.mCachedAutoMirrored = r3
            r1.mCacheDirty = r2
        L_0x012d:
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r1 = r10.mVectorState
            android.graphics.Rect r3 = r10.mTmpBounds
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPathRenderer r6 = r1.mVPathRenderer
            int r6 = r6.getRootAlpha()
            r7 = 255(0xff, float:3.57E-43)
            if (r6 >= r7) goto L_0x013c
            r2 = 1
        L_0x013c:
            r6 = 0
            if (r2 != 0) goto L_0x0143
            if (r0 != 0) goto L_0x0143
            r0 = r6
            goto L_0x0163
        L_0x0143:
            android.graphics.Paint r2 = r1.mTempPaint
            if (r2 != 0) goto L_0x0151
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r1.mTempPaint = r2
            r2.setFilterBitmap(r5)
        L_0x0151:
            android.graphics.Paint r2 = r1.mTempPaint
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPathRenderer r5 = r1.mVPathRenderer
            int r5 = r5.getRootAlpha()
            r2.setAlpha(r5)
            android.graphics.Paint r2 = r1.mTempPaint
            r2.setColorFilter(r0)
            android.graphics.Paint r0 = r1.mTempPaint
        L_0x0163:
            android.graphics.Bitmap r1 = r1.mCachedBitmap
            r11.drawBitmap(r1, r6, r3, r0)
            r11.restoreToCount(r4)
        L_0x016b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.draw(android.graphics.Canvas):void");
    }

    public int getAlpha() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.mColorFilter;
    }

    public ConstantState getConstantState() {
        if (this.mDelegateDrawable != null && VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }
        this.mVectorState.mChangingConfigurations = getChangingConfigurations();
        return this.mVectorState;
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    public int getOpacity() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.mVectorState.mAutoMirrored;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        if (r0.isStateful() != false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.mDelegateDrawable
            if (r0 == 0) goto L_0x0009
            boolean r0 = r0.isStateful()
            return r0
        L_0x0009:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r0 = r1.mVectorState
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x0028
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState r0 = r1.mVectorState
            android.content.res.ColorStateList r0 = r0.mTint
            if (r0 == 0) goto L_0x0026
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r0 = 0
            goto L_0x0029
        L_0x0028:
            r0 = 1
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.isStateful():boolean");
    }

    public Drawable mutate() {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.mMutated && super.mutate() == this) {
            this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
            this.mMutated = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        ColorStateList colorStateList = vectorDrawableCompatState.mTint;
        boolean z2 = true;
        if (colorStateList != null) {
            Mode mode = vectorDrawableCompatState.mTintMode;
            if (mode != null) {
                this.mTintFilter = updateTintFilter(colorStateList, mode);
                invalidateSelf();
                z = true;
            }
        }
        if (vectorDrawableCompatState.isStateful()) {
            boolean onStateChanged = vectorDrawableCompatState.mVPathRenderer.mRootGroup.onStateChanged(iArr);
            vectorDrawableCompatState.mCacheDirty |= onStateChanged;
            if (onStateChanged) {
                invalidateSelf();
                return z2;
            }
        }
        z2 = z;
        return z2;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAlpha(i);
            return;
        }
        if (this.mVectorState.mVPathRenderer.getRootAlpha() != i) {
            this.mVectorState.mVPathRenderer.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.mVectorState.mAutoMirrored = z;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    public void setTint(int i) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            b.setTint(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            b.setTintList(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTint != colorStateList) {
            vectorDrawableCompatState.mTint = colorStateList;
            this.mTintFilter = updateTintFilter(colorStateList, vectorDrawableCompatState.mTintMode);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            b.setTintMode(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.mTintMode != mode) {
            vectorDrawableCompatState.mTintMode = mode;
            this.mTintFilter = updateTintFilter(vectorDrawableCompatState.mTint, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public PorterDuffColorFilter updateTintFilter(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) throws XmlPullParserException, IOException {
        ColorStateList colorStateList;
        int i;
        ArrayDeque arrayDeque;
        VectorDrawableCompatState vectorDrawableCompatState;
        VPathRenderer vPathRenderer;
        VectorDrawableCompatState vectorDrawableCompatState2;
        VPathRenderer vPathRenderer2;
        ArrayDeque arrayDeque2;
        TypedArray typedArray;
        VGroup vGroup;
        Resources resources2 = resources;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        AttributeSet attributeSet2 = attributeSet;
        Theme theme2 = theme;
        Drawable drawable = this.mDelegateDrawable;
        if (drawable != null) {
            drawable.inflate(resources2, xmlPullParser2, attributeSet2, theme2);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState3 = this.mVectorState;
        vectorDrawableCompatState3.mVPathRenderer = new VPathRenderer();
        TypedArray obtainAttributes = b.obtainAttributes(resources2, theme2, attributeSet2, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
        VectorDrawableCompatState vectorDrawableCompatState4 = this.mVectorState;
        VPathRenderer vPathRenderer3 = vectorDrawableCompatState4.mVPathRenderer;
        int namedInt = b.getNamedInt(obtainAttributes, xmlPullParser2, "tintMode", 6, -1);
        Mode mode = Mode.SRC_IN;
        int i2 = 3;
        if (namedInt == 3) {
            mode = Mode.SRC_OVER;
        } else if (namedInt != 5) {
            if (namedInt != 9) {
                switch (namedInt) {
                    case 14:
                        mode = Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = Mode.SCREEN;
                        break;
                    case 16:
                        mode = Mode.ADD;
                        break;
                }
            } else {
                mode = Mode.SRC_ATOP;
            }
        }
        vectorDrawableCompatState4.mTintMode = mode;
        int i3 = 1;
        if (b.hasAttribute(xmlPullParser2, "tint")) {
            TypedValue typedValue = new TypedValue();
            obtainAttributes.getValue(1, typedValue);
            int i4 = typedValue.type;
            if (i4 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index " + 1 + ": " + typedValue);
            } else if (i4 < 28 || i4 > 31) {
                colorStateList = ColorStateListInflaterCompat.inflate(obtainAttributes.getResources(), obtainAttributes.getResourceId(1, 0), theme2);
            } else {
                colorStateList = ColorStateList.valueOf(typedValue.data);
            }
        } else {
            colorStateList = null;
        }
        if (colorStateList != null) {
            vectorDrawableCompatState4.mTint = colorStateList;
        }
        vectorDrawableCompatState4.mAutoMirrored = b.getNamedBoolean(obtainAttributes, xmlPullParser2, "autoMirrored", 5, vectorDrawableCompatState4.mAutoMirrored);
        vPathRenderer3.mViewportWidth = b.getNamedFloat(obtainAttributes, xmlPullParser2, "viewportWidth", 7, vPathRenderer3.mViewportWidth);
        float namedFloat = b.getNamedFloat(obtainAttributes, xmlPullParser2, "viewportHeight", 8, vPathRenderer3.mViewportHeight);
        vPathRenderer3.mViewportHeight = namedFloat;
        if (vPathRenderer3.mViewportWidth <= 0.0f) {
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (namedFloat > 0.0f) {
            vPathRenderer3.mBaseWidth = obtainAttributes.getDimension(3, vPathRenderer3.mBaseWidth);
            float dimension = obtainAttributes.getDimension(2, vPathRenderer3.mBaseHeight);
            vPathRenderer3.mBaseHeight = dimension;
            if (vPathRenderer3.mBaseWidth <= 0.0f) {
                throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                vPathRenderer3.setAlpha(b.getNamedFloat(obtainAttributes, xmlPullParser2, "alpha", 4, vPathRenderer3.getAlpha()));
                String string = obtainAttributes.getString(0);
                if (string != null) {
                    vPathRenderer3.mRootName = string;
                    vPathRenderer3.mVGTargetsMap.put(string, vPathRenderer3);
                }
                obtainAttributes.recycle();
                vectorDrawableCompatState3.mChangingConfigurations = getChangingConfigurations();
                vectorDrawableCompatState3.mCacheDirty = true;
                VectorDrawableCompatState vectorDrawableCompatState5 = this.mVectorState;
                VPathRenderer vPathRenderer4 = vectorDrawableCompatState5.mVPathRenderer;
                ArrayDeque arrayDeque3 = new ArrayDeque();
                arrayDeque3.push(vPathRenderer4.mRootGroup);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z = true;
                while (eventType != i3 && (xmlPullParser.getDepth() >= depth || eventType != i2)) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        VGroup vGroup2 = (VGroup) arrayDeque3.peek();
                        if ("path".equals(name)) {
                            VFullPath vFullPath = new VFullPath();
                            TypedArray obtainAttributes2 = b.obtainAttributes(resources2, theme2, attributeSet2, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
                            vFullPath.mThemeAttrs = null;
                            if (!b.hasAttribute(xmlPullParser2, "pathData")) {
                                arrayDeque2 = arrayDeque3;
                                vPathRenderer2 = vPathRenderer4;
                                vectorDrawableCompatState2 = vectorDrawableCompatState5;
                                vGroup = vGroup2;
                                i = depth;
                                typedArray = obtainAttributes2;
                            } else {
                                String string2 = obtainAttributes2.getString(0);
                                if (string2 != null) {
                                    vFullPath.mPathName = string2;
                                }
                                String string3 = obtainAttributes2.getString(2);
                                if (string3 != null) {
                                    vFullPath.mNodes = b.createNodesFromPathData(string3);
                                }
                                arrayDeque2 = arrayDeque3;
                                vPathRenderer2 = vPathRenderer4;
                                vectorDrawableCompatState2 = vectorDrawableCompatState5;
                                i = depth;
                                typedArray = obtainAttributes2;
                                vGroup = vGroup2;
                                vFullPath.mFillColor = b.getNamedComplexColor(obtainAttributes2, xmlPullParser, theme, "fillColor", 1, 0);
                                vFullPath.mFillAlpha = b.getNamedFloat(typedArray, xmlPullParser2, "fillAlpha", 12, vFullPath.mFillAlpha);
                                int namedInt2 = b.getNamedInt(typedArray, xmlPullParser2, "strokeLineCap", 8, -1);
                                Cap cap = vFullPath.mStrokeLineCap;
                                if (namedInt2 == 0) {
                                    cap = Cap.BUTT;
                                } else if (namedInt2 == 1) {
                                    cap = Cap.ROUND;
                                } else if (namedInt2 == 2) {
                                    cap = Cap.SQUARE;
                                }
                                vFullPath.mStrokeLineCap = cap;
                                int namedInt3 = b.getNamedInt(typedArray, xmlPullParser2, "strokeLineJoin", 9, -1);
                                Join join = vFullPath.mStrokeLineJoin;
                                if (namedInt3 == 0) {
                                    join = Join.MITER;
                                } else if (namedInt3 == 1) {
                                    join = Join.ROUND;
                                } else if (namedInt3 == 2) {
                                    join = Join.BEVEL;
                                }
                                vFullPath.mStrokeLineJoin = join;
                                vFullPath.mStrokeMiterlimit = b.getNamedFloat(typedArray, xmlPullParser2, "strokeMiterLimit", 10, vFullPath.mStrokeMiterlimit);
                                vFullPath.mStrokeColor = b.getNamedComplexColor(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                                vFullPath.mStrokeAlpha = b.getNamedFloat(typedArray, xmlPullParser2, "strokeAlpha", 11, vFullPath.mStrokeAlpha);
                                vFullPath.mStrokeWidth = b.getNamedFloat(typedArray, xmlPullParser2, "strokeWidth", 4, vFullPath.mStrokeWidth);
                                vFullPath.mTrimPathEnd = b.getNamedFloat(typedArray, xmlPullParser2, "trimPathEnd", 6, vFullPath.mTrimPathEnd);
                                vFullPath.mTrimPathOffset = b.getNamedFloat(typedArray, xmlPullParser2, "trimPathOffset", 7, vFullPath.mTrimPathOffset);
                                vFullPath.mTrimPathStart = b.getNamedFloat(typedArray, xmlPullParser2, "trimPathStart", 5, vFullPath.mTrimPathStart);
                                vFullPath.mFillRule = b.getNamedInt(typedArray, xmlPullParser2, "fillType", 13, vFullPath.mFillRule);
                            }
                            typedArray.recycle();
                            vGroup.mChildren.add(vFullPath);
                            vPathRenderer = vPathRenderer2;
                            if (vFullPath.getPathName() != null) {
                                vPathRenderer.mVGTargetsMap.put(vFullPath.getPathName(), vFullPath);
                            }
                            vectorDrawableCompatState = vectorDrawableCompatState2;
                            vectorDrawableCompatState.mChangingConfigurations |= vFullPath.mChangingConfigurations;
                            arrayDeque = arrayDeque2;
                            z = false;
                        } else {
                            ArrayDeque arrayDeque4 = arrayDeque3;
                            vPathRenderer = vPathRenderer4;
                            vectorDrawableCompatState = vectorDrawableCompatState5;
                            i = depth;
                            if ("clip-path".equals(name)) {
                                VClipPath vClipPath = new VClipPath();
                                if (b.hasAttribute(xmlPullParser2, "pathData")) {
                                    TypedArray obtainAttributes3 = b.obtainAttributes(resources2, theme2, attributeSet2, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
                                    String string4 = obtainAttributes3.getString(0);
                                    if (string4 != null) {
                                        vClipPath.mPathName = string4;
                                    }
                                    String string5 = obtainAttributes3.getString(1);
                                    if (string5 != null) {
                                        vClipPath.mNodes = b.createNodesFromPathData(string5);
                                    }
                                    vClipPath.mFillRule = b.getNamedInt(obtainAttributes3, xmlPullParser2, "fillType", 2, 0);
                                    obtainAttributes3.recycle();
                                }
                                vGroup2.mChildren.add(vClipPath);
                                if (vClipPath.getPathName() != null) {
                                    vPathRenderer.mVGTargetsMap.put(vClipPath.getPathName(), vClipPath);
                                }
                                vectorDrawableCompatState.mChangingConfigurations = vClipPath.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                            } else if ("group".equals(name)) {
                                VGroup vGroup3 = new VGroup();
                                TypedArray obtainAttributes4 = b.obtainAttributes(resources2, theme2, attributeSet2, AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
                                vGroup3.mThemeAttrs = null;
                                vGroup3.mRotate = b.getNamedFloat(obtainAttributes4, xmlPullParser2, "rotation", 5, vGroup3.mRotate);
                                vGroup3.mPivotX = obtainAttributes4.getFloat(1, vGroup3.mPivotX);
                                vGroup3.mPivotY = obtainAttributes4.getFloat(2, vGroup3.mPivotY);
                                vGroup3.mScaleX = b.getNamedFloat(obtainAttributes4, xmlPullParser2, "scaleX", 3, vGroup3.mScaleX);
                                vGroup3.mScaleY = b.getNamedFloat(obtainAttributes4, xmlPullParser2, "scaleY", 4, vGroup3.mScaleY);
                                vGroup3.mTranslateX = b.getNamedFloat(obtainAttributes4, xmlPullParser2, "translateX", 6, vGroup3.mTranslateX);
                                vGroup3.mTranslateY = b.getNamedFloat(obtainAttributes4, xmlPullParser2, "translateY", 7, vGroup3.mTranslateY);
                                String string6 = obtainAttributes4.getString(0);
                                if (string6 != null) {
                                    vGroup3.mGroupName = string6;
                                }
                                vGroup3.updateLocalMatrix();
                                obtainAttributes4.recycle();
                                vGroup2.mChildren.add(vGroup3);
                                arrayDeque = arrayDeque4;
                                arrayDeque.push(vGroup3);
                                if (vGroup3.getGroupName() != null) {
                                    vPathRenderer.mVGTargetsMap.put(vGroup3.getGroupName(), vGroup3);
                                }
                                vectorDrawableCompatState.mChangingConfigurations = vGroup3.mChangingConfigurations | vectorDrawableCompatState.mChangingConfigurations;
                            }
                            arrayDeque = arrayDeque4;
                        }
                    } else {
                        i = depth;
                        VectorDrawableCompatState vectorDrawableCompatState6 = vectorDrawableCompatState5;
                        arrayDeque = arrayDeque3;
                        vPathRenderer = vPathRenderer4;
                        vectorDrawableCompatState = vectorDrawableCompatState6;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    i2 = 3;
                    i3 = 1;
                    depth = i;
                    VectorDrawableCompatState vectorDrawableCompatState7 = vectorDrawableCompatState;
                    vPathRenderer4 = vPathRenderer;
                    arrayDeque3 = arrayDeque;
                    vectorDrawableCompatState5 = vectorDrawableCompatState7;
                }
                if (!z) {
                    this.mTintFilter = updateTintFilter(vectorDrawableCompatState3.mTint, vectorDrawableCompatState3.mTintMode);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            } else {
                throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = vectorDrawableCompatState;
        this.mTintFilter = updateTintFilter(vectorDrawableCompatState.mTint, vectorDrawableCompatState.mTintMode);
    }
}
