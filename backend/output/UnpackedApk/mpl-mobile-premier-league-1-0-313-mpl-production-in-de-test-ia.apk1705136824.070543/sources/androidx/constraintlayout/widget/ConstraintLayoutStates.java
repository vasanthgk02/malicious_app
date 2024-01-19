package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintLayoutStates {
    public final ConstraintLayout mConstraintLayout;
    public SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    public ConstraintsChangedListener mConstraintsChangedListener;
    public int mCurrentConstraintNumber = -1;
    public int mCurrentStateId = -1;
    public SparseArray<State> mStateList = new SparseArray<>();

    public static class State {
        public int mConstraintID = -1;
        public ConstraintSet mConstraintSet;
        public int mId;
        public ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.State_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R$styleable.State_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone((ConstraintLayout) LayoutInflater.from(context).inflate(this.mConstraintID, null));
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public int findMatch(float f2, float f3) {
            for (int i = 0; i < this.mVariants.size(); i++) {
                if (this.mVariants.get(i).match(f2, f3)) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static class Variant {
        public int mConstraintID = -1;
        public ConstraintSet mConstraintSet;
        public float mMaxHeight = Float.NaN;
        public float mMaxWidth = Float.NaN;
        public float mMinHeight = Float.NaN;
        public float mMinWidth = Float.NaN;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R$styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone((ConstraintLayout) LayoutInflater.from(context).inflate(this.mConstraintID, null));
                    }
                } else if (index == R$styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R$styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R$styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R$styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean match(float f2, float f3) {
            if (!Float.isNaN(this.mMinWidth) && f2 < this.mMinWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMinHeight) && f3 < this.mMinHeight) {
                return false;
            }
            if (!Float.isNaN(this.mMaxWidth) && f2 > this.mMaxWidth) {
                return false;
            }
            if (Float.isNaN(this.mMaxHeight) || f3 <= this.mMaxHeight) {
                return true;
            }
            return false;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ConstraintLayoutStates(android.content.Context r8, androidx.constraintlayout.widget.ConstraintLayout r9, int r10) {
        /*
            r7 = this;
            r7.<init>()
            r0 = -1
            r7.mCurrentStateId = r0
            r7.mCurrentConstraintNumber = r0
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r7.mStateList = r1
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            r7.mConstraintSetMap = r1
            r1 = 0
            r7.mConstraintsChangedListener = r1
            r7.mConstraintLayout = r9
            android.content.res.Resources r9 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r9.getXml(r10)
            int r10 = r9.getEventType()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
        L_0x0027:
            r2 = 1
            if (r10 == r2) goto L_0x00a8
            if (r10 == 0) goto L_0x0097
            r3 = 2
            if (r10 == r3) goto L_0x0031
            goto L_0x009a
        L_0x0031:
            java.lang.String r10 = r9.getName()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            int r4 = r10.hashCode()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L_0x0066;
                case 80204913: goto L_0x005c;
                case 1382829617: goto L_0x0053;
                case 1657696882: goto L_0x0049;
                case 1901439077: goto L_0x003f;
                default: goto L_0x003e;
            }     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
        L_0x003e:
            goto L_0x0070
        L_0x003f:
            java.lang.String r2 = "Variant"
            boolean r10 = r10.equals(r2)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r10 == 0) goto L_0x0070
            r2 = 3
            goto L_0x0071
        L_0x0049:
            java.lang.String r2 = "layoutDescription"
            boolean r10 = r10.equals(r2)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r10 == 0) goto L_0x0070
            r2 = 0
            goto L_0x0071
        L_0x0053:
            java.lang.String r4 = "StateSet"
            boolean r10 = r10.equals(r4)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r10 == 0) goto L_0x0070
            goto L_0x0071
        L_0x005c:
            java.lang.String r2 = "State"
            boolean r10 = r10.equals(r2)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r10 == 0) goto L_0x0070
            r2 = 2
            goto L_0x0071
        L_0x0066:
            java.lang.String r2 = "ConstraintSet"
            boolean r10 = r10.equals(r2)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r10 == 0) goto L_0x0070
            r2 = 4
            goto L_0x0071
        L_0x0070:
            r2 = -1
        L_0x0071:
            if (r2 == r3) goto L_0x0089
            if (r2 == r6) goto L_0x007c
            if (r2 == r5) goto L_0x0078
            goto L_0x009a
        L_0x0078:
            r7.parseConstraintSet(r8, r9)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x009a
        L_0x007c:
            androidx.constraintlayout.widget.ConstraintLayoutStates$Variant r10 = new androidx.constraintlayout.widget.ConstraintLayoutStates$Variant     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r10.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            if (r1 == 0) goto L_0x009a
            java.util.ArrayList<androidx.constraintlayout.widget.ConstraintLayoutStates$Variant> r2 = r1.mVariants     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r2.add(r10)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x009a
        L_0x0089:
            androidx.constraintlayout.widget.ConstraintLayoutStates$State r10 = new androidx.constraintlayout.widget.ConstraintLayoutStates$State     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r10.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintLayoutStates$State> r1 = r7.mStateList     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            int r2 = r10.mId     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r1.put(r2, r10)     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            r1 = r10
            goto L_0x009a
        L_0x0097:
            r9.getName()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
        L_0x009a:
            int r10 = r9.next()     // Catch:{ XmlPullParserException -> 0x00a4, IOException -> 0x009f }
            goto L_0x0027
        L_0x009f:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x00a8
        L_0x00a4:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayoutStates.<init>(android.content.Context, androidx.constraintlayout.widget.ConstraintLayout, int):void");
    }

    public final void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        int i;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        int i2 = 0;
        while (i2 < attributeCount) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            String attributeValue = xmlPullParser.getAttributeValue(i2);
            if (attributeName == null || attributeValue == null || !"id".equals(attributeName)) {
                i2++;
            } else {
                if (attributeValue.contains("/")) {
                    i = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i = -1;
                }
                if (i == -1 && attributeValue.length() > 1) {
                    i = Integer.parseInt(attributeValue.substring(1));
                }
                constraintSet.load(context, xmlPullParser);
                this.mConstraintSetMap.put(i, constraintSet);
                return;
            }
        }
    }

    public void updateConstraints(int i, float f2, float f3) {
        ConstraintSet constraintSet;
        State state;
        ConstraintSet constraintSet2;
        int i2 = this.mCurrentStateId;
        if (i2 == i) {
            if (i == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(i2);
            }
            int i3 = this.mCurrentConstraintNumber;
            if (i3 == -1 || !state.mVariants.get(i3).match(f2, f3)) {
                int findMatch = state.findMatch(f2, f3);
                if (this.mCurrentConstraintNumber != findMatch) {
                    if (findMatch == -1) {
                        constraintSet2 = null;
                    } else {
                        constraintSet2 = state.mVariants.get(findMatch).mConstraintSet;
                    }
                    if (findMatch != -1) {
                        int i4 = state.mVariants.get(findMatch).mConstraintID;
                    }
                    if (constraintSet2 != null) {
                        this.mCurrentConstraintNumber = findMatch;
                        constraintSet2.applyTo(this.mConstraintLayout);
                    }
                }
            }
        } else {
            this.mCurrentStateId = i;
            State state2 = this.mStateList.get(i);
            int findMatch2 = state2.findMatch(f2, f3);
            if (findMatch2 == -1) {
                constraintSet = state2.mConstraintSet;
            } else {
                constraintSet = state2.mVariants.get(findMatch2).mConstraintSet;
            }
            if (findMatch2 != -1) {
                int i5 = state2.mVariants.get(findMatch2).mConstraintID;
            }
            if (constraintSet != null) {
                this.mCurrentConstraintNumber = findMatch2;
                constraintSet.applyTo(this.mConstraintLayout);
            }
        }
    }
}
